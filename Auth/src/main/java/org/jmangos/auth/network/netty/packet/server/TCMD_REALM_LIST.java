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
