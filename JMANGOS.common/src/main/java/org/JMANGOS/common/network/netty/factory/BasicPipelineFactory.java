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

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.execution.ExecutionHandler;
import org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating BasicPipeline objects.
 */
public abstract class BasicPipelineFactory implements ChannelPipelineFactory {
	 
 	/** The Constant THREADS_MAX. */
 	protected static final int THREADS_MAX = 10;
	  
  	/** The Constant MEMORY_PER_CHANNEL. */
  	protected static final int MEMORY_PER_CHANNEL = 1048576;
	  
  	/** The Constant TOTAL_MEMORY. */
  	protected static final int TOTAL_MEMORY = 134217728;
	  
  	/** The Constant TIMEOUT. */
  	private static final int TIMEOUT = 100;

	  /** The executor handler. */
  	private final ExecutionHandler executorHandler;

	  /** The channel factory. */
  	protected NetworkChannelFactory channelFactory;
	  
  	/**
  	 * Instantiates a new basic pipeline factory.
  	 */
  	public BasicPipelineFactory() {
		    this.executorHandler = new ExecutionHandler(new OrderedMemoryAwareThreadPoolExecutor(
		        THREADS_MAX, MEMORY_PER_CHANNEL, TOTAL_MEMORY, TIMEOUT, TimeUnit.MILLISECONDS, Executors
		            .defaultThreadFactory()));
		  }
	  
  	/**
  	 * Gets the executor handler.
  	 *
  	 * @return the executorHandler
  	 */
	  protected final ExecutionHandler getExecutorHandler() {
	    return executorHandler;
	  }

	  /**
  	 * Sets the channel factory.
  	 *
  	 * @param channelFactory the channelFactory to set
  	 */
	  public void setChannelFactory(NetworkChannelFactory channelFactory) {
	    this.channelFactory = channelFactory;
	  }
}
