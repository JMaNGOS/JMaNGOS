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
package org.JMANGOS.common.network.model;

import org.jboss.netty.channel.ChannelHandler;


// TODO: Auto-generated Javadoc
/**
 * The Interface ConnectHandler.
 *
 * @author admin
 */
public interface ConnectHandler {

	  /**
  	 * On connect.
  	 *
  	 * @param networkChannel the network channel
  	 * @param handler the handler
  	 */
	  void onConnect(NettyNetworkChannel networkChannel, ChannelHandler handler);

	  /**
  	 * On disconnect.
  	 *
  	 * @param networkChannel the network channel
  	 */
	  void onDisconnect(NettyNetworkChannel networkChannel);
}
