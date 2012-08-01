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
package org.jmangos.auth.network.netty.packet.server;

import org.apache.log4j.Logger;
import org.jmangos.auth.model.Account;
import org.jmangos.auth.model.World;
import org.jmangos.auth.network.netty.packet.AbstractWoWServerPacket;
import org.jmangos.auth.service.WorldListService;

import javolution.util.FastMap;

// TODO: Auto-generated Javadoc
/**
 * The Class TCMD_REALM_LIST.
 */
public class TCMD_REALM_LIST extends AbstractWoWServerPacket {
	
	/** The Constant log. */
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(TCMD_REALM_LIST.class);
	
	/** The worldlist. */
	private WorldListService worldlist;

	/**
	 * Instantiates a new tCM d_ real m_ list.
	 */
	public TCMD_REALM_LIST() {

	}

	/**
	 * Instantiates a new tCM d_ real m_ list.
	 *
	 * @param worldlist the worldlist
	 */
	public TCMD_REALM_LIST(WorldListService worldlist) {
		this.worldlist = worldlist;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		FastMap<Integer, Integer> amountofCharacters = worldlist
				.getAmountCharacters(((Account) (getChannel()
						.getChanneledObject())).getObjectId());
		writeH(worldlist.getByteSize());
		writeD(0);
		writeH(worldlist.getSize());
		for (World world : worldlist.getWorlds().values()) {
			writeC(world.getIcon());
			writeC((world.getAllowedSecurityLevel() > ((Account) (getChannel()
					.getChanneledObject())).getAccessLevel()) ? 1 : 0);
			writeC(world.getRealmflags());
			writeS(world.getName());
			writeS(world.getAddress());
			writeF(world.getPopulation());
			writeC((amountofCharacters.containsKey(world.getId())) ? amountofCharacters
					.get(world.getId()) : 0);
			writeC(world.getTimezone());
			writeC(0x2C);
		}
		writeH(0x0010);
	}
}
