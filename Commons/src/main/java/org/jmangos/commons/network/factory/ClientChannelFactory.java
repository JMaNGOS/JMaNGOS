/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.network.factory;

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

/**
 * A factory for creating ClientChannel objects.
 */
public class ClientChannelFactory implements NetworkChannelFactory {

    /** The channel factory. */
    private final ChannelFactory channelFactory;

    /** The isa. */
    private final InetSocketAddress isa;

    /** The bootstrap. */
    private ClientBootstrap bootstrap;

    /**
     * Instantiates a new client channel factory.
     * 
     * @param isa
     *        the isa
     */
    public ClientChannelFactory(final InetSocketAddress isa) {

        this.channelFactory =
                new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool());
        this.isa = isa;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.wowemu.common.network.netty.factory.NetworkChannelFactory#connect()
     */
    @Override
    public Channel connect() {

        final ChannelFuture channelFuture = this.bootstrap.connect(this.isa);
        return channelFuture.awaitUninterruptibly().getChannel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.wowemu.common.network.netty.factory.NetworkChannelFactory#initialize
     * (org.jboss.netty.channel.ChannelPipelineFactory)
     */
    @Override
    public void initialize(final ChannelPipelineFactory pipelineFactory) {

        this.bootstrap = new ClientBootstrap(this.channelFactory);
        this.bootstrap.setPipelineFactory(pipelineFactory);
        this.bootstrap.setOption("bufferFactory",
                HeapChannelBufferFactory.getInstance(ByteOrder.LITTLE_ENDIAN));
        this.bootstrap.setOption("tcpNoDelay", true);
        this.bootstrap.setOption("keepAlive", true);
        this.bootstrap.setOption("reuseAddress", true);
        this.bootstrap.setOption("connectTimeoutMillis", 10);
        this.bootstrap.setOption("readWriteFair", true);
        this.bootstrap.setOption("remoteAddress", this.isa);
        ((BasicPipelineFactory) pipelineFactory).setChannelFactory(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.wowemu.common.network.netty.factory.NetworkChannelFactory#getAddress
     * ()
     */
    @Override
    public InetSocketAddress getAddress() {

        return this.isa;
    }
}
