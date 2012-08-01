/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.realm.network.netty.packet.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javax.inject.Inject;
import javax.inject.Named;

import javolution.text.TextBuilder;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jmangos.commons.network.model.State;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.model.account.Account;
import org.jmangos.realm.model.base.AddonInfo;
import org.jmangos.realm.network.netty.handler.R2CChannelHandler;
import org.jmangos.realm.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packet.server.SMSG_ADDON_INFO;
import org.jmangos.realm.network.netty.packet.server.SMSG_AUTH_RESPONSE;
import org.jmangos.realm.network.netty.packet.server.SMSG_CLIENTCACHE_VERSION;
import org.jmangos.realm.network.netty.packet.server.SMSG_TUTORIAL_FLAGS;
import org.jmangos.realm.service.AccountService;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_AUTH_SESSION.
 */
public class CMSG_AUTH_SESSION extends AbstractWoWClientPacket {
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(CMSG_AUTH_SESSION.class);
	
	/** The account service. */
	@Inject
	private AccountService accountService;
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The account name. */
	private String accountName;
	
	/** The client seed. */
	private byte[] clientSeed;
	
	/** The digest. */
	private byte[] digest;
	
	/** The Client build. */
	@SuppressWarnings("unused")
	private int ClientBuild;
	
	/** The addon lists. */
	private ArrayList<AddonInfo> addonLists;

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		ClientBuild = readD();
		skip(4);
		accountName = readS();
		skip(4);
		clientSeed = readB(4);
		skip(20);
		digest = readB(20);

		if (getAvaliableBytes() < 4) {
			return;
		}

		int UncopressedSize = readD();
		byte[] compressedData = readB(getAvaliableBytes());
		Inflater decompressor = new Inflater();
		decompressor.setInput(compressedData);

		ByteArrayOutputStream bos = new ByteArrayOutputStream(
				compressedData.length);

		byte[] buf = new byte[1024];
		while (!decompressor.finished()) {
			try {
				int count = decompressor.inflate(buf);
				bos.write(buf, 0, count);
			} catch (DataFormatException e) {
			}
		}
		try {
			bos.close();
		} catch (IOException e) {
		}

		byte[] decompressedData = bos.toByteArray();
		if (UncopressedSize != decompressedData.length) {
			logger.warn("Somesing wrong with compressed addonInfo");
			return;
		}
		ChannelBuffer addonInfo = ChannelBuffers.wrappedBuffer(
				ByteOrder.LITTLE_ENDIAN, decompressedData);

		int addonsCount = addonInfo.readInt();

		addonLists = new ArrayList<AddonInfo>(addonsCount);
		for (int i = 0; i < addonsCount; i++) {
			TextBuilder tb = TextBuilder.newInstance();
			for (byte c; (c = addonInfo.readByte()) != 0;)
				tb.append((char) c);
			String addonName = tb.toString(); 
			TextBuilder.recycle(tb);
			byte enabled = addonInfo.readByte();
			int crc = addonInfo.readInt();
			/* int unk1 = */addonInfo.readInt();
			addonLists.add(new AddonInfo(addonName, enabled, crc));
		}
		/* int unk2 = */addonInfo.readInt();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		Account account  = accountService
				.createAndAttachAccount(accountName, getClient());

		R2CChannelHandler channelHandler = (R2CChannelHandler) this.getClient()
				.getChannel().getPipeline().getLast();
		String SessionKey = accountService
				.getSessionKeyFromDB(account.getName());
		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
		byte[] t = {0, 0, 0, 0};
		sha.update(account.getName().getBytes());
		sha.update(t);
		sha.update(clientSeed);
		sha.update(channelHandler.getSeed());
		sha.update(convertMangosSessionKey(SessionKey));

		if (!Arrays.equals(sha.digest(), digest)) {
			getChannel().close();
			return;
		}

		channelHandler.getCrypt().init(convertMangosSessionKey(SessionKey));
		sender.send(getClient(), new SMSG_AUTH_RESPONSE());
		getClient().setChannelState(State.AUTHED);
		account.setTutorials(
				accountService.loadTutorialsDataFromDB(account.getObjectId()));
		sender.send(getClient(), new SMSG_ADDON_INFO());
		sender.send(getClient(), new SMSG_CLIENTCACHE_VERSION());
		sender.send(getClient(), new SMSG_TUTORIAL_FLAGS());

	}

	/**
	 * Convert mangos session key.
	 *
	 * @param hexkey the hexkey
	 * @return the byte[]
	 */
	private byte[] convertMangosSessionKey(String hexkey) {
		int len = hexkey.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[(len - i) / 2 - 1] = (byte) ((Character.digit(
					hexkey.charAt(i), 16) << 4) + Character.digit(hexkey
					.charAt(i + 1), 16));
		}
		return data;

	}
}
