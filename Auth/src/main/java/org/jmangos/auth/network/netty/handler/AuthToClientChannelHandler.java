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
package org.jmangos.auth.network.netty.handler;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jmangos.auth.network.crypt.Crypt;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.netty.receiver.NettyPacketReceiver;

/**
 * The Class AuthToClientChannelHandler.
 * 
 * @author MinimaJack
 */
public class AuthToClientChannelHandler extends SimpleChannelUpstreamHandler {
    
    /** The receiver. */
    private final NettyPacketReceiver  receiver;
    
    /** The network channel. */
    private NettyNetworkChannel        networkChannel;
    
    /** The address. */
    @SuppressWarnings("unused")
    private InetSocketAddress          address;
    
    /** The packet service. */
    private final PacketHandlerFactory packetService;
    
    /** The connection handler. */
    private final ConnectHandler       connectionHandler;
    
    /** The Constant log. */
    @SuppressWarnings("unused")
    private static final Logger        log   = Logger.getLogger(AuthToClientChannelHandler.class);
    
    private Crypt                      crypt = new Crypt();
    
    /**
     * Instantiates a new Auth to Client channel handler.
     * 
     * @param packetService
     *            the packet service
     * @param connectionHandler
     *            the connection handler
     * @param receiver
     *            the receiver
     */
    public AuthToClientChannelHandler(final PacketHandlerFactory packetService, final ConnectHandler connectionHandler, final NettyPacketReceiver receiver) {
    
        super();
        
        this.receiver = receiver;
        this.packetService = packetService;
        this.connectionHandler = connectionHandler;
    }
    
    /**
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
     * 
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.MessageEvent)
     */
    @Override
    public void messageReceived(final ChannelHandlerContext ctx, final MessageEvent e) {
    
        this.receiver.receivePacket(this.packetService, (ChannelBuffer) e.getMessage(), this.networkChannel);
    }
    
    /**
     * 
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelDisconnected(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.ChannelStateEvent)
     */
    @Override
    public void channelDisconnected(final ChannelHandlerContext ctx, final ChannelStateEvent e) throws Exception {
    
        this.connectionHandler.onDisconnect(this.networkChannel);
    }
    
    /**
     * 
     * 
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext,
     *      org.jboss.netty.channel.ExceptionEvent)
     */
    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final ExceptionEvent e) {
    
    }
    
    public Crypt getCrypt() {
    
        return this.crypt;
    }
    
    public void setCrypt(final Crypt crypt) {
    
        this.crypt = crypt;
    }
}
