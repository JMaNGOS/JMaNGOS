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
package org.jmangos.realm.network.netty.handler;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.netty.factory.NetworkChannelFactory;
import org.jmangos.commons.network.netty.receiver.NettyPacketReceiver;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.realm.config.Config;

/**
 * The Class ReconnectingChannelHandler.
 */
public class ReconnectingChannelHandler extends SimpleChannelUpstreamHandler {
    
    /** The Constant log. */
    private static final Logger         log = Logger.getLogger(ReconnectingChannelHandler.class);
    
    /** The timer. */
    private final Timer                 timer;
    
    /** The channel factory. */
    private final NetworkChannelFactory channelFactory;
    
    /** Config */
    Config                              config;
    
    /**
     * Instantiates a new reconnecting channel handler.
     * 
     * @param timer
     *            the timer
     * @param channelFactory
     *            the channel factory
     * @param packetService
     *            the packet service
     * @param connectionHandler
     *            the connection handler
     * @param nettyPacketReceiver
     *            the netty packet receiver
     */
    public ReconnectingChannelHandler(final Timer timer, final NetworkChannelFactory channelFactory, final PacketHandlerFactory packetService,
            final ConnectHandler connectionHandler, final NettyPacketReceiver nettyPacketReceiver) {
    
        this.config = ServiceContent.getInjector().getInstance(Config.class);
        this.timer = timer;
        this.channelFactory = channelFactory;
    }
    
    /**
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelClosed(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelClosed(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        this.timer.newTimeout(new TimerTask() {
            
            @Override
            public void run(final Timeout timeout) throws Exception {
            
                log.info("Reconnecting to: " + ReconnectingChannelHandler.this.channelFactory.getAddress());
                ReconnectingChannelHandler.this.channelFactory.connect();
            }
        }, this.config.AUTH_RECONNECT_DELAY, TimeUnit.MILLISECONDS);
        
    }
}
