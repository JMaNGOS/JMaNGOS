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
import java.util.HashMap;
import java.util.zip.Deflater;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.model.account.AccountData;
import org.jmangos.realm.model.enums.AccountDataType;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.springframework.stereotype.Component;

// FIXME implement opcode

/**
 * The Class CMSG_REQUEST_ACCOUNT_DATA.
 */
@Component
public class CMSG_REQUEST_ACCOUNT_DATA extends AbstractWoWClientPacket {
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    /** The type. */
    private int                  type;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.type = readD();
    }
    
    @Override
    protected void runImpl() {
    
        if (this.type > AccountDataType.NUM_ACCOUNT_DATA_TYPES.getValue()) {
            return;
        }
        final HashMap<Integer, AccountData> adata = new HashMap<Integer, AccountData>(); // getAccount().getAccountData();
                                                                                         // /*
                                                                                         // disabled
                                                                                         // by
                                                                                         // paalgyula
                                                                                         // */
        if (adata.containsKey(this.type)) {
            final Deflater compressor = new Deflater();
            final byte[] dataToCompress = adata.get(this.type).getData().getBytes();
            
            compressor.setInput(dataToCompress);
            compressor.finish();
            final ByteArrayOutputStream bos = new ByteArrayOutputStream(dataToCompress.length);
            
            final byte[] buf = new byte[1024];
            while (!compressor.finished()) {
                final int count = compressor.deflate(buf);
                bos.write(buf, 0, count);
            }
            try {
                bos.close();
            } catch (final IOException e) {
            }
            // FIXME NEED COMPLETE
            @SuppressWarnings("unused")
            final byte[] compressedData = bos.toByteArray();
            
        }
    }
}
