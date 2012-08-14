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

import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_BINDPOINTUPDATE.
 */
public class SMSG_BINDPOINTUPDATE  extends AbstractWoWServerPacket {
	
	/** The player. */
	private Player player;
	
	/**
	 * Instantiates a new sMS g_ bindpointupdate.
	 *
	 * @param player the player
	 */
	public SMSG_BINDPOINTUPDATE(Player player){
		this.player = player;
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	public void writeImpl() {
		writeF(player.getHomeBind().getHomeBindPositionX());
		writeF(player.getHomeBind().getHomeBindPositionY());
		writeF(player.getHomeBind().getHomeBindPositionZ());
		writeD(player.getHomeBind().getHomeBindMapId());
		writeD(player.getHomeBind().getHomeBindAreaId());
	}
}
