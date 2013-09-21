/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.network.model;

import java.net.InetSocketAddress;

import org.jboss.netty.channel.Channel;

/**
 * The Interface NetworkChannel.
 */
public interface NetworkChannel {

    /**
     * Gets the channel id.
     * 
     * @return unique ID for context's channel
     */
    int getChannelId();

    /**
     * Gets the object id.
     * 
     * @return ID of channeled object or -1
     */
    long getObjectId();

    /**
     * Gets the channel.
     * 
     * @return the channel
     */
    Channel getChannel();

    public InetSocketAddress getAddress();

    /**
     * Gets the channel state.
     * 
     * @return channel state
     */
    State getChannelState();

    /**
     * Sets the channel state.
     * 
     * @param channelState
     *        the new channel state
     */
    void setChannelState(State channelState);

    /**
     * Checks if is connected.
     * 
     * @return true, if is connected
     */
    boolean isConnected();

    /**
     * Write.
     * 
     * @param buffer
     *        the buffer
     */
    void write(Object buffer);
}
