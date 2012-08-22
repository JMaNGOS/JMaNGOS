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
package org.jmangos.commons.network.sender;

import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.SendablePacket;

/**
 * The Interface AbstractPacketSender.
 */
public interface AbstractPacketSender {
    
    /**
     * Send.
     * 
     * @param channel
     *            the channel
     * @param packet
     *            the packet
     */
    public void send(NetworkChannel channel, SendablePacket packet);
    
    /**
     * Send and close.
     * 
     * @param channel
     *            the channel
     * @param networkPacket
     *            the network packet
     */
    void sendAndClose(NetworkChannel channel, SendablePacket networkPacket);
}
