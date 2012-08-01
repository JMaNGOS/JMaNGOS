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
package org.jmangos.commons.network.netty.factory;

import java.net.InetSocketAddress;
import java.nio.ByteOrder;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ClientChannel objects.
 */
public class ClientChannelFactory implements NetworkChannelFactory {

	/** The channel factory. */
	private ChannelFactory channelFactory;
	
	/** The isa. */
	private InetSocketAddress isa;
	
	/** The bootstrap. */
	private ClientBootstrap bootstrap;

	/**
	 * Instantiates a new client channel factory.
	 *
	 * @param isa the isa
	 */
	public ClientChannelFactory(InetSocketAddress isa) {
		this.channelFactory = new NioClientSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool());
		this.isa = isa;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.factory.NetworkChannelFactory#connect()
	 */
	@Override
	public Channel connect() {
		ChannelFuture channelFuture = bootstrap.connect(this.isa);
		return channelFuture.awaitUninterruptibly().getChannel();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.factory.NetworkChannelFactory#initialize(org.jboss.netty.channel.ChannelPipelineFactory)
	 */
	@Override
	public void initialize(ChannelPipelineFactory pipelineFactory) {
		bootstrap = new ClientBootstrap(channelFactory);
		bootstrap.setPipelineFactory(pipelineFactory);
		bootstrap.setOption("bufferFactory",
				HeapChannelBufferFactory.getInstance(ByteOrder.LITTLE_ENDIAN));
		bootstrap.setOption("tcpNoDelay", true);
		bootstrap.setOption("keepAlive", true);
		bootstrap.setOption("reuseAddress", true);
		bootstrap.setOption("connectTimeoutMillis", 10);
		bootstrap.setOption("readWriteFair", true);
		bootstrap.setOption("remoteAddress", isa);
		((BasicPipelineFactory) pipelineFactory).setChannelFactory(this);
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.factory.NetworkChannelFactory#getAddress()
	 */
	@Override
	public InetSocketAddress getAddress() {
		return isa;
	}
}
