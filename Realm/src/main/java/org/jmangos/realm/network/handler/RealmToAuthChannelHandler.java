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
package org.jmangos.realm.network.handler;

import java.net.InetSocketAddress;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.timeout.ReadTimeoutException;
import org.jboss.netty.util.HashedWheelTimer;
import org.jmangos.commons.network.factory.NetworkChannelFactory;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.receiver.NettyPacketReceiver;
import org.jmangos.realm.network.crypt.Crypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class R2LChannelHandler.
 * 
 * @author MinimaJack
 */
public class RealmToAuthChannelHandler extends ReconnectingChannelHandler {
    
    /** The receiver. */
    private final NettyPacketReceiver  receiver;
    
    /** The network channel. */
    private NettyNetworkChannel        networkChannel;
    
    /** The address. */
    @SuppressWarnings("unused")
    private InetSocketAddress          address;
    
    /** The packet service. */
    private final PacketHandlerFactory packetService;
    
    /** The crypt. */
    private final Crypt                crypt = new Crypt();
    
    /** The last ping time. */
    private long                       lastPingTime;
    
    /** The seed. */
    private byte[]                     seed;
    
    /**
     * Instantiates a new Realm to Auth channel handler.
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
    public RealmToAuthChannelHandler(final NetworkChannelFactory channelFactory, final PacketHandlerFactory packetService,
            final ConnectHandler connectionHandler, final NettyPacketReceiver nettyPacketReceiver) {
    
        super(new HashedWheelTimer(), channelFactory, packetService, connectionHandler, nettyPacketReceiver);
        
        this.receiver = nettyPacketReceiver;
        this.packetService = packetService;
        this.connectionHandler = connectionHandler;
    }
    
    /**
     * Gets the seed.
     * 
     * @return the seed
     */
    public final byte[] getSeed() {
    
        return this.seed;
    }
    
    /**
     * Sets the seed.
     * 
     * @param seed
     *            the new seed
     */
    public final void setSeed(final byte[] seed) {
    
        this.seed = seed;
    }
    
    /**
     * Gets the last ping time.
     * 
     * @return the lastPingTime
     */
    public long getLastPingTime() {
    
        return this.lastPingTime;
    }
    
    /**
     * Sets the last ping time.
     * 
     * @param lastPingTime
     *            the lastPingTime to set
     */
    public void setLastPingTime(final long lastPingTime) {
    
        this.lastPingTime = lastPingTime;
    }
    
    /** The connection handler. */
    private final ConnectHandler connectionHandler;
    
    /** The Constant log. */
    private static final Logger  log = LoggerFactory.getLogger(RealmToAuthChannelHandler.class);
    
    /**
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelConnected(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelConnected(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        this.address = (InetSocketAddress) e.getChannel().getRemoteAddress();
        this.networkChannel = new NettyNetworkChannel(this, ctx.getChannel());
        this.connectionHandler.onConnect(this.networkChannel, this);
        
    }
    
    /**
     * Gets the crypt.
     * 
     * @return the crypt
     */
    public final Crypt getCrypt() {
    
        return this.crypt;
    }
    
    /**
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.MessageEvent)
     */
    @Override
    public void messageReceived(final ChannelHandlerContext ctx, final MessageEvent e) {
    
        this.receiver.receivePacket(this.packetService, (ChannelBuffer) e.getMessage(), this.networkChannel);
    }
    
    /**
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelDisconnected(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelDisconnected(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        this.connectionHandler.onDisconnect(this.networkChannel);
    }
    
    /**
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.ExceptionEvent)
     */
    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final ExceptionEvent e) {
    
        if (e.getCause() instanceof ReadTimeoutException) {
            log.info("Login server didn't respond");
        } else {
            ctx.sendUpstream(e);
        }
    }
}
