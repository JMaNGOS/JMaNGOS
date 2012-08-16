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
/**
 * 
 */
package org.jmangos.commons.network.model;

import org.jboss.netty.channel.ChannelHandler;

/**
 * The Interface ConnectHandler.
 * 
 * @author admin
 */
public interface ConnectHandler {
    
    /**
     * On connect.
     * 
     * @param networkChannel
     *            the network channel
     * @param handler
     *            the handler
     */
    void onConnect(NettyNetworkChannel networkChannel, ChannelHandler handler);
    
    /**
     * On disconnect.
     * 
     * @param networkChannel
     *            the network channel
     */
    void onDisconnect(NettyNetworkChannel networkChannel);
}
