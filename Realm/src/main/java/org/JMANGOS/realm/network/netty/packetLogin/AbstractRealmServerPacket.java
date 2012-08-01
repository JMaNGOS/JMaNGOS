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
package org.JMANGOS.realm.network.netty.packetLogin;

import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.model.SendablePacket;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractRealmServerPacket.
 */
public abstract class AbstractRealmServerPacket extends SendablePacket {

	/**
	 * Gets the channel.
	 * 
	 * @return the channel
	 */
	public NettyNetworkChannel getChannel() {
		return (NettyNetworkChannel) channel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.network.model.SendablePacket#write()
	 */
	public void write() throws RuntimeException {
		writeC(this.opCode);
		writeImpl();
	}
}
