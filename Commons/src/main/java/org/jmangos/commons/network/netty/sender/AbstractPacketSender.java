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
package org.jmangos.commons.network.netty.sender;

import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.SendablePacket;

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
