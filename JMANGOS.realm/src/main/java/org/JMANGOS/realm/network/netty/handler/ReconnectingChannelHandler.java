/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.network.netty.handler;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;
import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.netty.factory.NetworkChannelFactory;
import org.JMANGOS.common.network.netty.receiver.NettyPacketReceiver;

// TODO: Auto-generated Javadoc
/**
 * The Class ReconnectingChannelHandler.
 */
public class ReconnectingChannelHandler extends SimpleChannelUpstreamHandler {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(ReconnectingChannelHandler.class);
	
	/** The Constant RECONNECT_DELAY. */
	private static final long RECONNECT_DELAY = 5;
	
	/** The timer. */
	private Timer timer;
	
	/** The channel factory. */
	private NetworkChannelFactory channelFactory;

	/**
	 * Instantiates a new reconnecting channel handler.
	 *
	 * @param timer the timer
	 * @param channelFactory the channel factory
	 * @param packetService the packet service
	 * @param connectionHandler the connection handler
	 * @param nettyPacketReceiver the netty packet receiver
	 */
	public ReconnectingChannelHandler(Timer timer,
			NetworkChannelFactory channelFactory,
			PacketHandlerFactory packetService,
			ConnectHandler connectionHandler,
			NettyPacketReceiver nettyPacketReceiver) {
		this.timer = timer;
		this.channelFactory = channelFactory;
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#channelClosed(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		timer.newTimeout(new TimerTask() {
			@Override
			public void run(Timeout timeout) throws Exception {
				log.info("Reconnecting to: " + channelFactory.getAddress());
				channelFactory.connect();
			}
		}, RECONNECT_DELAY, TimeUnit.SECONDS);

	}
}
