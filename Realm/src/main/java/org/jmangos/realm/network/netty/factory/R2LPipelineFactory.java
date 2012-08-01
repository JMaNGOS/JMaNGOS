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
/**
 * 
 */
package org.jmangos.realm.network.netty.factory;

import static org.jboss.netty.channel.Channels.*;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.util.HashedWheelTimer;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.netty.factory.BasicPipelineFactory;
import org.jmangos.commons.network.netty.receiver.NettyPacketReceiver;
import org.jmangos.realm.network.netty.handler.EventLogHandler;
import org.jmangos.realm.network.netty.handler.R2LChannelHandler;

import javax.inject.Inject;
import javax.inject.Named;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating R2LPipeline objects.
 *
 * @author admin
 */

public class R2LPipelineFactory extends BasicPipelineFactory {
	
	/** The connection handler. */
	@Inject
	@Named("r2l")
	private ConnectHandler connectionHandler;
	
	/** The packet service. */
	@Inject
	@Named("r2l")
	private PacketHandlerFactory packetService;
	
	/** The timer. */
	private HashedWheelTimer timer;

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
	 */
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = pipeline();
		timer = new HashedWheelTimer();
		pipeline.addLast("executor", getExecutorHandler());
		pipeline.addLast("eventlog", new EventLogHandler());
		// and then business logic.
		pipeline.addLast("handler", new R2LChannelHandler(timer,
				channelFactory, packetService, connectionHandler,
				new NettyPacketReceiver()));

		return pipeline;
	}
}
