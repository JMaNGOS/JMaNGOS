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
package org.jmangos.realm.network.packet.wow.client;

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

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.network.model.State;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.controller.RealmController;
import org.jmangos.realm.model.base.AddonInfo;
import org.jmangos.realm.network.handler.RealmToClientChannelHandler;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_ADDON_INFO;
import org.jmangos.realm.network.packet.wow.server.SMSG_AUTH_RESPONSE;
import org.jmangos.realm.network.packet.wow.server.SMSG_CLIENTCACHE_VERSION;
import org.jmangos.realm.network.packet.wow.server.SMSG_TUTORIAL_FLAGS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_AUTH_SESSION.
 */
@Component
public class CMSG_AUTH_SESSION extends AbstractWoWClientPacket {
    
    /** The Constant logger. */
    private static final Logger  logger = LoggerFactory.getLogger(CMSG_AUTH_SESSION.class);
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    @Inject
    private RealmController      realmController;
    
    /** The account name. */
    private String               accountName;
    
    /** The client seed. */
    private byte[]               clientSeed;
    
    /** The digest. */
    private byte[]               digest;
    
    /** The Client build. */
    @SuppressWarnings("unused")
    private int                  ClientBuild;
    
    /** The addon lists. */
    private ArrayList<AddonInfo> addonLists;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.ClientBuild = readD();
        skip(4);
        this.accountName = readS();
        skip(4);
        this.clientSeed = readB(4);
        skip(20);
        this.digest = readB(20);
        
        if (getAvaliableBytes() < 4) {
            return;
        }
        
        final int UncopressedSize = readD();
        final byte[] compressedData = readB(getAvaliableBytes());
        final Inflater decompressor = new Inflater();
        decompressor.setInput(compressedData);
        
        final ByteArrayOutputStream bos = new ByteArrayOutputStream(compressedData.length);
        
        final byte[] buf = new byte[1024];
        while (!decompressor.finished()) {
            try {
                final int count = decompressor.inflate(buf);
                bos.write(buf, 0, count);
            } catch (final DataFormatException e) {
            }
        }
        try {
            bos.close();
        } catch (final IOException e) {
        }
        
        final byte[] decompressedData = bos.toByteArray();
        if (UncopressedSize != decompressedData.length) {
            logger.warn("Somesing wrong with compressed addonInfo");
            return;
        }
        final ChannelBuffer addonInfo = ChannelBuffers.wrappedBuffer(ByteOrder.LITTLE_ENDIAN, decompressedData);
        
        final int addonsCount = addonInfo.readInt();
        
        this.addonLists = new ArrayList<AddonInfo>(addonsCount);
        for (int i = 0; i < addonsCount; i++) {
            final TextBuilder tb = TextBuilder.newInstance();
            for (byte c; (c = addonInfo.readByte()) != 0;) {
                tb.append((char) c);
            }
            final String addonName = tb.toString();
            TextBuilder.recycle(tb);
            final byte enabled = addonInfo.readByte();
            final int crc = addonInfo.readInt();
            /* int unk1 = */addonInfo.readInt();
            this.addonLists.add(new AddonInfo(addonName, enabled, crc));
        }
        
        /* int unk2 = */addonInfo.readInt();
    }
    
    @Override
    protected void runImpl() {
    
        final AccountInfo account = this.realmController.getAccount(this.accountName);
        
        getClient().setChanneledObject(account);
        // final String SessionKey = this.accountService.getSessionKeyFromDB(account.getName());
        
        final RealmToClientChannelHandler channelHandler = (RealmToClientChannelHandler) getClient().getChannel().getPipeline().getLast();
        
        MessageDigest sha;
        try {
            sha = MessageDigest.getInstance("SHA-1");
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }
        final byte[] t = { 0, 0, 0, 0 };
        sha.update(account.getName().getBytes());
        sha.update(t);
        sha.update(this.clientSeed);
        sha.update(channelHandler.getSeed());
        sha.update(account.getSessionKey().asByteArray(40));
        
        if (!Arrays.equals(sha.digest(), this.digest)) {
            getChannel().close();
            return;
        }
        
        channelHandler.getCrypt().init(account.getSessionKey().asByteArray(40));
        this.sender.send(getClient(), new SMSG_AUTH_RESPONSE());
        getClient().setChannelState(State.AUTHED);
        // TODO: what is this?
        /*
         * account.setTutorials( accountService.loadTutorialsDataFromDB(account.getObjectId()));
         */
        final SMSG_ADDON_INFO addonInfoPacket = new SMSG_ADDON_INFO(this.addonLists);
        
        this.sender.send(getClient(), addonInfoPacket);
        this.sender.send(getClient(), new SMSG_CLIENTCACHE_VERSION());
        this.sender.send(getClient(), new SMSG_TUTORIAL_FLAGS());
    }
}
