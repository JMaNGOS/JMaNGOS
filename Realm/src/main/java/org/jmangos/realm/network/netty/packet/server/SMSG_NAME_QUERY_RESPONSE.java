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
package org.jmangos.realm.network.netty.packet.server;

import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_NAME_QUERY_RESPONSE.
 */
public class SMSG_NAME_QUERY_RESPONSE extends AbstractWoWServerPacket{
	
	/** The player. */
	private Player player; 

	/**
	 * Instantiates a new sMS g_ nam e_ quer y_ response.
	 */
	public SMSG_NAME_QUERY_RESPONSE() {
	}

	/**
	 * Instantiates a new sMS g_ nam e_ quer y_ response.
	 *
	 * @param player the player
	 */
	public SMSG_NAME_QUERY_RESPONSE(Player player) {
		this.player  = player;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writePackedGuid(player.getObjectId());
		writeC(0);
		writeS(player.getName());
		writeC(0);
		writeC(player.getCharacterData().getRace());
		writeC(player.getCharacterData().getGender());
		writeC(player.getCharacterData().getClazz());
		writeC(0);
	}


}
