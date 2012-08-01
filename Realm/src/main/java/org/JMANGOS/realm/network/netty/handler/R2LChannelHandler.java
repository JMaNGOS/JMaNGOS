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
package org.JMANGOS.realm.network.netty.handler;

import org.JMANGOS.realm.network.crypt.Crypt;
import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import java.net.InetSocketAddress;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.timeout.ReadTimeoutException;
import org.jboss.netty.util.Timer;
import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.netty.factory.NetworkChannelFactory;
import org.JMANGOS.common.network.netty.receiver.NettyPacketReceiver;

// TODO: Auto-generated Javadoc
/**
 * The Class R2LChannelHandler.
 *
 * @author minimajack
 */
public class R2LChannelHandler extends ReconnectingChannelHandler {
	
	/** The receiver. */
	private final NettyPacketReceiver receiver;
	
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
	 * Instantiates a new r2 l channel handler.
	 *
	 * @param timer the timer
	 * @param channelFactory the channel factory
	 * @param packetService the packet service
	 * @param connectionHandler the connection handler
	 * @param nettyPacketReceiver the netty packet receiver
	 */
	public R2LChannelHandler(Timer timer, NetworkChannelFactory channelFactory,
			PacketHandlerFactory packetService,
			ConnectHandler connectionHandler,
			NettyPacketReceiver nettyPacketReceiver) {
		super(timer, channelFactory, packetService, connectionHandler,
				nettyPacketReceiver);

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
	private static final Logger log = Logger.getLogger(R2LChannelHandler.class);

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
		if (e.getCause() instanceof ReadTimeoutException) {
			log.info("Login server didn't respond");
		} else {
			ctx.sendUpstream(e);
		}
	}
}
