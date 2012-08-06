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
package org.jmangos.realm.network.netty.packetClient.server;

import java.security.SecureRandom;

import org.jmangos.realm.network.netty.handler.RealmToClientChannelHandler;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_AUTH_CHALLENGE.
 */
public class SMSG_AUTH_CHALLENGE extends AbstractWoWServerPacket {
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		RealmToClientChannelHandler channelHandler = (RealmToClientChannelHandler) this
				.getChannel().getChannel().getPipeline().getLast();
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(4);
		channelHandler.setSeed(seed);
		writeD(1);
		writeB(seed);
		writeB(random.generateSeed(16));
		writeB(random.generateSeed(16));
	}
}
