/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.login.network.netty.packet.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;
import org.JMANGOS.login.network.netty.packet.AbstractWoWClientPacket;
import org.JMANGOS.login.network.netty.packet.server.TCMD_RECONNECT_PROOF;
import org.JMANGOS.login.service.AccountService;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_RECONNECT_PROOF.
 */
public class CMD_RECONNECT_PROOF extends AbstractWoWClientPacket {
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(CMD_RECONNECT_PROOF.class);
	
	/** The sender. */
	@Inject
	private AbstractPacketSender sender;
	
	/** The account service. */
	@Inject
	private AccountService accountService;

	/**
	 * Instantiates a new cM d_ reconnec t_ proof.
	 */
	public CMD_RECONNECT_PROOF() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unused")
	@Override
	protected void readImpl() {
		byte[] R1 = readB(16);
		byte[] R2 = readB(20);
		byte[] R3 = readB(20);
		int numberofKey = readC();

		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
		String SessionKey = accountService.getSessionKey(getAccount().getName());

		sha.update(getAccount().getName().getBytes());
		sha.update(R1);
		sha.update(getAccount().get_reconnectProof().asByteArray(16));
		sha.update(convertMangosSessionKey(SessionKey));

		if (Arrays.equals(sha.digest(), R2)) {

			sender.send(this.getClient(), new TCMD_RECONNECT_PROOF());
		} else
			getChannel().close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void runImpl() {
	}
	
	/**
	 * Convert mangos session key.
	 *
	 * @param hexkey the hexkey
	 * @return the byte[]
	 */
	private byte[] convertMangosSessionKey(String hexkey){
		int len = hexkey.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[ (len - i) / 2 - 1 ] = (byte) ((Character.digit(hexkey.charAt(i), 16) << 4) + Character
					.digit(hexkey.charAt(i + 1), 16));
		}
		return data;
		
	}
}
