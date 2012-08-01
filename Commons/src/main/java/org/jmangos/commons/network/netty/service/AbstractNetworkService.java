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
package org.jmangos.commons.network.netty.service;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.commons.network.netty.factory.ClientChannelFactory;
import org.jmangos.commons.network.netty.factory.ServerChannelFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractNetworkService.
 */
public abstract class AbstractNetworkService implements NetworkService {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(AbstractNetworkService.class);

	  /**
  	 * Creates the server channel.
  	 *
  	 * @param address the address
  	 * @param pipelineFactory the pipeline factory
  	 */
	  protected void createServerChannel(InetSocketAddress address,
	      ChannelPipelineFactory pipelineFactory) {
	    ServerChannelFactory channelFactory = new ServerChannelFactory(address);
	    channelFactory.initialize(pipelineFactory);
	    Channel channel = channelFactory.connect();
	    log.info("Initialized channel : " + channel.getLocalAddress());
	  }

	  /**
  	 * Creates the client channel.
  	 *
  	 * @param address the address
  	 * @param pipelineFactory the pipeline factory
  	 */ 
	  protected void createClientChannel(InetSocketAddress address,
	      ChannelPipelineFactory pipelineFactory) {
	    ClientChannelFactory channelFactory = new ClientChannelFactory(address);
	    channelFactory.initialize(pipelineFactory);
	    Channel channel = channelFactory.connect();
	    log.info("Initialized channel : {}" + channel.getLocalAddress());
	  }
}
