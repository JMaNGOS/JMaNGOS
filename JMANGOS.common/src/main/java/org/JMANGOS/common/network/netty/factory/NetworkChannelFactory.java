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
package org.JMANGOS.common.network.netty.factory;

import java.net.InetSocketAddress;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating NetworkChannel objects.
 */
public interface NetworkChannelFactory {
	  
  	/**
  	 * Start listening on port or connect to remote address.
  	 *
  	 * @return channel
  	 */
	  Channel connect();

	  /**
  	 * Initialize.
  	 *
  	 * @param pipelineFactory the pipeline factory
  	 */
	  void initialize(ChannelPipelineFactory pipelineFactory);

	  /**
  	 * Gets the address.
  	 *
  	 * @return address of channel connection
  	 */
	  InetSocketAddress getAddress();
	}
