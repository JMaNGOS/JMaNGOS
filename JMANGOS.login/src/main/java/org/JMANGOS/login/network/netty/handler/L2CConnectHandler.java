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
package org.JMANGOS.login.network.netty.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandler;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.model.State;

// TODO: Auto-generated Javadoc
/**
 * The Class L2CConnectHandler.
 */
public class L2CConnectHandler implements ConnectHandler{

	/** The Constant log. */
	private static final Logger             log     = Logger.getLogger(L2CConnectHandler.class);

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ConnectHandler#onConnect(org.wowemu.common.network.model.NettyNetworkChannel, org.jboss.netty.channel.ChannelHandler)
	 */
	@Override
	public void onConnect(NettyNetworkChannel networkChannel,
			ChannelHandler handler) {
		networkChannel.setChannelState(State.CONNECTED);
		
		log.info("Accepting connection from: "+ networkChannel.getAddress().getHostName());
		
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ConnectHandler#onDisconnect(org.wowemu.common.network.model.NettyNetworkChannel)
	 */
	@Override
	public void onDisconnect(NettyNetworkChannel networkChannel) {
		log.info("Disconnection : "+ networkChannel.getAddress().getHostName());
		
	}



}
