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
