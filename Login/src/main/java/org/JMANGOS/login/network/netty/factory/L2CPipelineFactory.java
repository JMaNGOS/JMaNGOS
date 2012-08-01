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
package org.JMANGOS.login.network.netty.factory;

import static org.jboss.netty.channel.Channels.*;


import org.jboss.netty.channel.ChannelPipeline;
import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.netty.factory.BasicPipelineFactory;
import org.JMANGOS.common.network.netty.receiver.NettyPacketReceiver;
import org.JMANGOS.login.network.netty.handler.EventLogHandler;
import org.JMANGOS.login.network.netty.handler.L2CChannelHandler;

import javax.inject.Inject;
import javax.inject.Named;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating L2CPipeline objects.
 *
 * @author admin
 */

public class L2CPipelineFactory extends BasicPipelineFactory {
	
	/** The connection handler. */
	@Inject
	@Named("l2c")
	private ConnectHandler connectionHandler;
	
	/** The packet service. */
	@Inject
	@Named("l2c")
	private PacketHandlerFactory packetService;
	
	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
	 */
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = pipeline();

		pipeline.addLast("executor", getExecutorHandler());

		pipeline.addLast("eventlog", new EventLogHandler());

		pipeline.addLast("handler", new L2CChannelHandler(packetService, connectionHandler,
				new NettyPacketReceiver()));

		return pipeline;
	}
}
