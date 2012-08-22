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
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.receiver.Netty2PacketReceiver;
import org.jmangos.realm.network.crypt.Crypt;

/**
 * The Class RealmToClientChannelHandler.
 * 
 * @author MinimaJack
 */
public class RealmToClientChannelHandler extends SimpleChannelUpstreamHandler {
    
    /** The receiver. */
    private final Netty2PacketReceiver receiver;
    
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
     * Instantiates a new Realm-Client channel handler.
     * 
     * @param packetService
     *            the packet service
     * @param connectionHandler
     *            the connection handler
     * @param netty2PacketReceiver
     *            the netty2 packet receiver
     */
    public RealmToClientChannelHandler(final PacketHandlerFactory packetService, final ConnectHandler connectionHandler,
            final Netty2PacketReceiver netty2PacketReceiver) {
    
        super();
        
        this.receiver = netty2PacketReceiver;
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
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelConnected(org.jboss.netty.channel
     * .ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
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
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(
     * org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
     */
    @Override
    public void messageReceived(final ChannelHandlerContext ctx, final MessageEvent e) {
    
        this.receiver.receivePacket(this.packetService, (ChannelBuffer) e.getMessage(), this.networkChannel);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelDisconnected(org.jboss.netty.
     * channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelDisconnected(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        this.connectionHandler.onDisconnect(this.networkChannel);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(org.jboss.netty.channel
     * .ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
     */
    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final ExceptionEvent e) {
    
    }
}
