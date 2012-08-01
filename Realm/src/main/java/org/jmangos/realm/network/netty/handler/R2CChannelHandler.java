/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.jmangos.realm.network.netty.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import java.net.InetSocketAddress;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.netty.receiver.Netty2PacketReceiver;
import org.jmangos.realm.network.crypt.Crypt;

// TODO: Auto-generated Javadoc
/**
 * The Class R2CChannelHandler.
 *
 * @author minimajack
 */
public class R2CChannelHandler extends SimpleChannelUpstreamHandler {
	
	/** The receiver. */
	private final Netty2PacketReceiver receiver;
	
	/** The network channel. */
	private NettyNetworkChannel networkChannel;
	
	/** The address. */
	@SuppressWarnings("unused")
	private InetSocketAddress address;
	
	/** The packet service. */
	private final PacketHandlerFactory packetService;
	
	/** The crypt. */
	private Crypt crypt = new Crypt();

	/** The last ping time. */
	private long lastPingTime;
	
	/** The seed. */
	private byte[] seed;
	
	/**
	 * Instantiates a new r2 c channel handler.
	 *
	 * @param packetService the packet service
	 * @param connectionHandler the connection handler
	 * @param netty2PacketReceiver the netty2 packet receiver
	 */
	public R2CChannelHandler(PacketHandlerFactory packetService,
			ConnectHandler connectionHandler, Netty2PacketReceiver netty2PacketReceiver) {
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
		return seed;
	}

	/**
	 * Sets the seed.
	 *
	 * @param seed the new seed
	 */
	public final void setSeed(byte[] seed) {
		this.seed = seed;
	}

	/**
	 * Gets the last ping time.
	 *
	 * @return the lastPingTime
	 */
	public long getLastPingTime() {
		return lastPingTime;
	}

	/**
	 * Sets the last ping time.
	 *
	 * @param lastPingTime the lastPingTime to set
	 */
	public void setLastPingTime(long lastPingTime) {
		this.lastPingTime = lastPingTime;
	}

	/** The connection handler. */
	private ConnectHandler connectionHandler;

	/** The Constant log. */
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(R2CChannelHandler.class);

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelConnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		address = (InetSocketAddress) e.getChannel().getRemoteAddress();
		networkChannel = new NettyNetworkChannel(this, ctx.getChannel());
		connectionHandler.onConnect(networkChannel, this);

	}

	/**
	 * Gets the crypt.
	 *
	 * @return the crypt
	 */
	public final Crypt getCrypt() {
		return crypt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(
	 * org.jboss.netty.channel.ChannelHandlerContext,
	 * org.jboss.netty.channel.MessageEvent)
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		receiver.receivePacket(packetService, (ChannelBuffer) e.getMessage(),
				networkChannel);
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelDisconnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		connectionHandler.onDisconnect(networkChannel);
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
	}
}
