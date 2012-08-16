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
package org.jmangos.commons.network.netty.factory;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.execution.ExecutionHandler;
import org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor;

/**
 * A factory for creating BasicPipeline objects.
 */
public abstract class BasicPipelineFactory implements ChannelPipelineFactory {
    
    /** The Constant THREADS_MAX. */
    protected static final int      THREADS_MAX        = 10;
    
    /** The Constant MEMORY_PER_CHANNEL. */
    protected static final int      MEMORY_PER_CHANNEL = 1048576;
    
    /** The Constant TOTAL_MEMORY. */
    protected static final int      TOTAL_MEMORY       = 134217728;
    
    /** The Constant TIMEOUT. */
    private static final int        TIMEOUT            = 100;
    
    /** The executor handler. */
    private final ExecutionHandler  executorHandler;
    
    /** The channel factory. */
    protected NetworkChannelFactory channelFactory;
    
    /**
     * Instantiates a new basic pipeline factory.
     */
    public BasicPipelineFactory() {
    
        this.executorHandler = new ExecutionHandler(new OrderedMemoryAwareThreadPoolExecutor(THREADS_MAX, MEMORY_PER_CHANNEL, TOTAL_MEMORY, TIMEOUT, TimeUnit.MILLISECONDS, Executors.defaultThreadFactory()));
    }
    
    /**
     * Gets the executor handler.
     * 
     * @return the executorHandler
     */
    protected final ExecutionHandler getExecutorHandler() {
    
        return this.executorHandler;
    }
    
    /**
     * Sets the channel factory.
     * 
     * @param channelFactory
     *            the channelFactory to set
     */
    public void setChannelFactory(final NetworkChannelFactory channelFactory) {
    
        this.channelFactory = channelFactory;
    }
}
