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
/**
 * 
 */
package org.JMANGOS.realm.network.netty.factory;

import static org.jboss.netty.channel.Channels.*;


import org.JMANGOS.realm.network.netty.decoder.PacketFrameDecoder;
import org.JMANGOS.realm.network.netty.decoder.PacketFrameEncoder;
import org.JMANGOS.realm.network.netty.handler.EventLogHandler;
import org.JMANGOS.realm.network.netty.handler.R2CChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.netty.factory.BasicPipelineFactory;
import org.JMANGOS.common.network.netty.receiver.Netty2PacketReceiver;

import javax.inject.Inject;
import javax.inject.Named;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating R2CPipeline objects.
 *
 * @author admin
 */

public class R2CPipelineFactory extends BasicPipelineFactory {
	
	/** The connection handler. */
	@Inject
	@Named("r2c")
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
		
		pipeline.addLast("framedecoder", new PacketFrameDecoder());
		 pipeline.addLast("encoder", new PacketFrameEncoder());
		pipeline.addLast("executor", getExecutorHandler());

		pipeline.addLast("eventlog", new EventLogHandler());

		// and then business logic.
		pipeline.addLast("handler", new R2CChannelHandler(packetService, connectionHandler,
				new Netty2PacketReceiver()));

		return pipeline;
	}
}
