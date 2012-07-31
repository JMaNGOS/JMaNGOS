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
package org.JMANGOS.common.network.netty.sender;

import org.JMANGOS.common.network.model.NetworkChannel;
import org.JMANGOS.common.network.model.SendablePacket;

// TODO: Auto-generated Javadoc
/**
 * The Interface AbstractPacketSender.
 */
public interface AbstractPacketSender {
	
	/**
	 * Send.
	 *
	 * @param channel the channel
	 * @param packet the packet
	 */
	public void send(NetworkChannel channel, SendablePacket packet);
 
	/**
	 * Send and close.
	 *
	 * @param channel the channel
	 * @param networkPacket the network packet
	 */
	void sendAndClose(NetworkChannel channel, SendablePacket networkPacket);
}
