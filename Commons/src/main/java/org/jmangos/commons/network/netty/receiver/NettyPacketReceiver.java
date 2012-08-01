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

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;


// TODO: Auto-generated Javadoc
/**
 * The Class NettyPacketReceiver.
 */
public class NettyPacketReceiver {
	
	/** The Constant log. */
	private static final Logger             log     = Logger.getLogger(NettyPacketReceiver.class);

	/**
	 * Receive packet.
	 *
	 * @param packetHandler the packet handler
	 * @param buffer the buffer
	 * @param networkChannel the network channel
	 */
	public void receivePacket(PacketHandlerFactory packetHandler, ChannelBuffer buffer,
		      NetworkChannel networkChannel) {
		    int packetId = buffer.readUnsignedByte();
		    log.info("got packet:"+ packetId);
		    log.info("size this packet:"+ buffer.readableBytes());
		    readAndRunPacket(packetHandler, buffer, packetId, networkChannel);
		  }

	/**
	 * Read and run packet.
	 *
	 * @param packetHandler the packet handler
	 * @param buffer the buffer
	 * @param packetId the packet id
	 * @param networkChannel the network channel
	 */
	private void readAndRunPacket(PacketHandlerFactory packetHandler, ChannelBuffer buffer, int packetId, NetworkChannel networkChannel) {
		ReceivablePacket cp = packetHandler.handleClientPacket(packetId, networkChannel);
		if (cp != null)
		{
			cp.setByteBuffer(buffer); 
			cp.setClient(networkChannel);
			if (cp.getAvaliableBytes() < cp.getMinimumLength())
			{
				log.info("BUFFER_UNDER_FLOW"  + networkChannel + cp);
			}
			else if (cp.read()){
				
			}
		}
	}
}
