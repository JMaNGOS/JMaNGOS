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
package org.jmangos.auth.network.netty.factory;

import static org.jboss.netty.channel.Channels.pipeline;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.auth.network.netty.handler.AuthToClientChannelHandler;
import org.jmangos.auth.network.netty.handler.EventLogHandler;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.netty.factory.BasicPipelineFactory;
import org.jmangos.commons.network.netty.receiver.NettyPacketReceiver;

/**
 * A factory for creating Auth-Client Pipeline objects.
 * 
 * @author MinimaJack
 */
public class AuthToClientPipelineFactory extends BasicPipelineFactory {
    
    /** The connection handler. */
    @Inject
    @Named("AuthToClient")
    private ConnectHandler       connectionHandler;
    
    /** The packet service. */
    @Inject
    @Named("AuthToClient")
    private PacketHandlerFactory packetService;
    
    /**
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
     */
    @Override
    public ChannelPipeline getPipeline() throws Exception {
    
        final ChannelPipeline pipeline = pipeline();
        
        pipeline.addLast("executor", getExecutorHandler());
        
        pipeline.addLast("eventlog", new EventLogHandler());
        
        pipeline.addLast("handler", new AuthToClientChannelHandler(this.packetService, this.connectionHandler, new NettyPacketReceiver()));
        
        return pipeline;
    }
}
