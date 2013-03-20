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
import java.util.ArrayList;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javolution.text.TextBuilder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.model.AddonInfo;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.controller.AccountQueueController;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_AUTH_SESSION.
 */
@Component
public class CMSG_AUTH_SESSION extends AbstractWoWClientPacket {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(CMSG_AUTH_SESSION.class);

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Autowired
    private AccountQueueController queueController;

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
            } catch (final DataFormatException e) {}
        }
        try {
            bos.close();
        } catch (final IOException e) {}

        final byte[] decompressedData = bos.toByteArray();
        if (UncopressedSize != decompressedData.length) {
            logger.warn("Somesing wrong with compressed addonInfo");
            return;
        }
        final ChannelBuffer addonInfo =
                ChannelBuffers.wrappedBuffer(ByteOrder.LITTLE_ENDIAN, decompressedData);

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
            final int unk1 = addonInfo.readInt();
            logger.debug("{}: {} {} {} {}", new Object[] { i, enabled, crc, unk1, addonName });
            this.addonLists.add(new AddonInfo(addonName, enabled, crc));
        }

        /* int unk2 = */addonInfo.readInt();
    }

    @Override
    protected void runImpl() {

        final AccountInfo aci = new AccountInfo();
        aci.setChannel(getClient());
        aci.setName(this.accountName);
        aci.setAddonLists(this.addonLists);
        aci.setvK(this.digest);
        aci.setClientSeed(this.clientSeed);
        getClient().setChanneledObject(aci);
        this.queueController.loadKeyAndValidateAccount(aci);
    }
}
