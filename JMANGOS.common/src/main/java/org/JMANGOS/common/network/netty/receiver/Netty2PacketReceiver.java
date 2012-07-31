/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.common.network.netty.receiver;

import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.NetworkChannel;
import org.JMANGOS.common.network.model.ReceivablePacket;
import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;


// TODO: Auto-generated Javadoc
/**
 * The Class Netty2PacketReceiver.
 */
public class Netty2PacketReceiver {
	
	/** The Constant log. */
	private static final Logger             log     = Logger.getLogger(Netty2PacketReceiver.class);

	/**
	 * Receive packet.
	 *
	 * @param packetHandler the packet handler
	 * @param buffer the buffer
	 * @param networkChannel the network channel
	 */
	public void receivePacket(PacketHandlerFactory packetHandler, ChannelBuffer buffer,
		      NetworkChannel networkChannel) {
		    int packetId = buffer.readInt();
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
