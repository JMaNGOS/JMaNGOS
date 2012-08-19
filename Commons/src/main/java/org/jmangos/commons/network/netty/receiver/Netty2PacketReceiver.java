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
package org.jmangos.commons.network.netty.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;

/**
 * The Class Netty2PacketReceiver.
 */
public class Netty2PacketReceiver {
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(Netty2PacketReceiver.class);
    
    /**
     * Receive packet.
     * 
     * @param packetHandler
     *            the packet handler
     * @param buffer
     *            the buffer
     * @param networkChannel
     *            the network channel
     */
    public void receivePacket(final PacketHandlerFactory packetHandler, final ChannelBuffer buffer, final NetworkChannel networkChannel) {
    
        final int packetId = buffer.readInt();
        readAndRunPacket(packetHandler, buffer, packetId, networkChannel);
    }
    
    /**
     * Read and run packet.
     * 
     * @param packetHandler
     *            the packet handler
     * @param buffer
     *            the buffer
     * @param packetId
     *            the packet id
     * @param networkChannel
     *            the network channel
     */
    private void readAndRunPacket(final PacketHandlerFactory packetHandler, final ChannelBuffer buffer, final int packetId, final NetworkChannel networkChannel) {
    
        final ReceivablePacket cp = packetHandler.handleClientPacket(packetId, networkChannel);
        if (cp != null) {
            cp.setByteBuffer(buffer);
            cp.setClient(networkChannel);
            if (cp.getAvaliableBytes() < cp.getMinimumLength()) {
                log.info("BUFFER_UNDER_FLOW" + networkChannel + cp);
            } else if (cp.read()) {
                
            }
        }
    }
}
