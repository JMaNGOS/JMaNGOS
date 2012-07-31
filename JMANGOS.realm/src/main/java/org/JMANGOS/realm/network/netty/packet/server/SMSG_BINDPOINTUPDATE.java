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
 * The Class SMSG_BINDPOINTUPDATE.
 */
public class SMSG_BINDPOINTUPDATE  extends AbstractWoWServerPacket {
	
	/** The player. */
	private Player player;
	
	/**
	 * Instantiates a new sMS g_ bindpointupdate.
	 */
	public SMSG_BINDPOINTUPDATE(){
	}
	
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
