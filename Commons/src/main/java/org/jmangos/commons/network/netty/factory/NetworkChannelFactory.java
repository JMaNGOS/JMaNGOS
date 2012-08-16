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
package org.jmangos.commons.network.netty.factory;

import java.net.InetSocketAddress;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;

/**
 * A factory for creating NetworkChannel objects.
 */
public interface NetworkChannelFactory {
    
    /**
     * Start listening on port or connect to remote address.
     * 
     * @return channel
     */
    Channel connect();
    
    /**
     * Initialize.
     * 
     * @param pipelineFactory
     *            the pipeline factory
     */
    void initialize(ChannelPipelineFactory pipelineFactory);
    
    /**
     * Gets the address.
     * 
     * @return address of channel connection
     */
    InetSocketAddress getAddress();
}
