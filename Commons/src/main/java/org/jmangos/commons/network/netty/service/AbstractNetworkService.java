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
package org.jmangos.commons.network.netty.service;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.commons.network.netty.factory.ClientChannelFactory;
import org.jmangos.commons.network.netty.factory.ServerChannelFactory;

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
	 * @param address
	 *            the address
	 * @param pipelineFactory
	 *            the pipeline factory
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
	 * @param address
	 *            the address
	 * @param pipelineFactory
	 *            the pipeline factory
	 */
	protected void createClientChannel(InetSocketAddress address,
			ChannelPipelineFactory pipelineFactory) {
		ClientChannelFactory channelFactory = new ClientChannelFactory(address);
		channelFactory.initialize(pipelineFactory);
		Channel channel = channelFactory.connect();
		log.info("Initialized channel : {}" + channel.getLocalAddress());
	}
}
