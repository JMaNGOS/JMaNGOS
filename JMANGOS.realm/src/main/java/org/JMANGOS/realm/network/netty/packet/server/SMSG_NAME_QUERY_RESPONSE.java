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
package org.JMANGOS.realm.network.netty.packet.server;

import org.JMANGOS.realm.model.player.Player;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

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
