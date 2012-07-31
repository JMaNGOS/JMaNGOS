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
package org.JMANGOS.common.network.netty.factory;

import java.net.InetSocketAddress;
import java.nio.ByteOrder;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ServerChannel objects.
 */
public class ServerChannelFactory implements NetworkChannelFactory {
	
	/** The channel factory. */
	private ChannelFactory channelFactory;
	
	/** The isa. */
	private InetSocketAddress isa;
	
	/** The bootstrap. */
	private ServerBootstrap bootstrap;

	/**
	 * Instantiates a new server channel factory.
	 *
	 * @param isa the isa
	 */
	public ServerChannelFactory(InetSocketAddress isa) {
		this.channelFactory = new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool(), Runtime.getRuntime()
						.availableProcessors() * 2 + 1);
		this.isa = isa;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.factory.NetworkChannelFactory#connect()
	 */
	@Override
	public Channel connect() {
		return bootstrap.bind(this.isa);
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.factory.NetworkChannelFactory#initialize(org.jboss.netty.channel.ChannelPipelineFactory)
	 */
	@Override
	public void initialize(ChannelPipelineFactory pipelineFactory) {
	    bootstrap = new ServerBootstrap(channelFactory);
	    bootstrap.setPipelineFactory(pipelineFactory);
	    bootstrap.setOption("child.bufferFactory", HeapChannelBufferFactory
	        .getInstance(ByteOrder.LITTLE_ENDIAN));
	    bootstrap.setOption("child.tcpNoDelay", true);
	    bootstrap.setOption("child.keepAlive", true);
	    bootstrap.setOption("child.reuseAddress", true);
	    bootstrap.setOption("child.connectTimeoutMillis", 100);
	    bootstrap.setOption("readWriteFair", true);
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.factory.NetworkChannelFactory#getAddress()
	 */
	@Override
	public InetSocketAddress getAddress() {
		 return isa;
	}

}
