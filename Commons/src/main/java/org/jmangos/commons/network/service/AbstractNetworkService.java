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
package org.jmangos.commons.network.service;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Map.Entry;

import javolution.util.FastMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.commons.network.factory.ClientChannelFactory;
import org.jmangos.commons.network.factory.ServerChannelFactory;
import org.jmangos.commons.network.model.NetworkChannel;

/**
 * The Class AbstractNetworkService.
 */
public abstract class AbstractNetworkService implements NetworkService {
    
    /** The Constant log. */
    private static final Logger                log                   = LoggerFactory.getLogger(AbstractNetworkService.class);
    
    private final Map<Integer, NetworkChannel> channels              = new FastMap<Integer, NetworkChannel>().shared();
    private final ChannelFutureListener        channelfutureListener = new ChannelCloseListener();
    
    /**
     * Remove channel from map after disconnection
     */
    public final class ChannelCloseListener implements ChannelFutureListener {
        
        @Override
        public void operationComplete(final ChannelFuture future) throws Exception {
        
            AbstractNetworkService.this.channels.remove(future.getChannel().getId());
        }
    }
    
    /**
     * Creates the server channel.
     * 
     * @param address
     *            the address
     * @param pipelineFactory
     *            the pipeline factory
     */
    protected void createServerChannel(final InetSocketAddress address, final ChannelPipelineFactory pipelineFactory) {
    
        final ServerChannelFactory channelFactory = new ServerChannelFactory(address);
        channelFactory.initialize(pipelineFactory);
        final Channel channel = channelFactory.connect();
        log.info("Initialized server channel : " + channel.getLocalAddress());
    }
    
    /**
     * Creates the client channel.
     * 
     * @param address
     *            the address
     * @param pipelineFactory
     *            the pipeline factory
     */
    protected void createClientChannel(final InetSocketAddress address, final ChannelPipelineFactory pipelineFactory) {
    
        final ClientChannelFactory channelFactory = new ClientChannelFactory(address);
        channelFactory.initialize(pipelineFactory);
        channelFactory.connect();
        log.info("Initialized client channel to " + address);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.netty.service.NetworkService#getChannelsInfo ()
     */
    @Override
    public String getChannelsInfo() {
    
        final StringBuffer sb = new StringBuffer();
        for (final Entry<Integer, NetworkChannel> channelEntry : this.channels.entrySet()) {
            sb.append("ChannelInfo [ channelId = ").append(channelEntry.getKey()).append(" channelState = ").append(channelEntry.getValue().getChannelState()).append(" objectId = ").append(channelEntry.getValue().getObjectId()).append(" ]\n");
        }
        return sb.toString();
    }
    
    @Override
    public void registerClientChannel(final NetworkChannel channel) {
    
        this.channels.put(channel.getChannelId(), channel);
        channel.getChannel().getCloseFuture().addListener(this.channelfutureListener);
    }
}
