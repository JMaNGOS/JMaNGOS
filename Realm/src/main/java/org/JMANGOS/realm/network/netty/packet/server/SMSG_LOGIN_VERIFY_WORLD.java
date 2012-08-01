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
package org.JMANGOS.realm.network.netty.packet.server;

import org.JMANGOS.realm.model.player.Player;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_LOGIN_VERIFY_WORLD.
 */
public class SMSG_LOGIN_VERIFY_WORLD extends AbstractWoWServerPacket{
	
	/** The player. */
	private Player player; 

	/**
	 * Instantiates a new sMS g_ logi n_ verif y_ world.
	 */
	public SMSG_LOGIN_VERIFY_WORLD() {
	}

	/**
	 * Instantiates a new sMS g_ logi n_ verif y_ world.
	 *
	 * @param player the player
	 */
	public SMSG_LOGIN_VERIFY_WORLD(Player player) {
		this.player  = player;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	public void writeImpl() {
		writeD(player.GetMapId());
	    writeF(player.getCharacterData().getPos_x());
	    writeF(player.getCharacterData().getPos_y());
	    writeF(player.getCharacterData().getPos_z());
	    writeF(player.getCharacterData().getOrientation());
	}

}
