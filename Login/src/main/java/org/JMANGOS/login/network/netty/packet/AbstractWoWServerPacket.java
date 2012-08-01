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
package org.JMANGOS.login.network.netty.packet;

import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.model.SendablePacket;


// TODO: Auto-generated Javadoc
/**
 * The Class AbstractWoWServerPacket.
 */
public abstract class AbstractWoWServerPacket extends SendablePacket
{
	
	/**
	 * Gets the channel.
	 *
	 * @return the channel
	 */
	public NettyNetworkChannel getChannel(){ 
		return (NettyNetworkChannel) channel;
	}
}
