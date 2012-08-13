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
package org.jmangos.realm.network.netty.packetAuth.server;

import org.jmangos.realm.config.Config;
import org.jmangos.realm.network.netty.packetAuth.AbstractRealmServerPacket;

/**
 * The Class <tt>CMD_REALM_DATA</tt>.
 */
public class CMD_REALM_DATA extends AbstractRealmServerPacket {

	private Config configs;
	private Float population;
	public CMD_REALM_DATA() {
	}

	public CMD_REALM_DATA(Config config, Float population) {
		this.configs = config;
		this.population = population;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeS(configs.REALM_NAME);
		writeS(configs.REALM_ADDRESS);
		writeD(configs.REALM_PORT);
		writeC(configs.REALM_ICON); // icon
		writeC(configs.REALM_FLAGS); // getRealmflags
		writeC(configs.REALM_TIME_ZONE); // Timezone
		writeC(configs.REALM_ALLOWED_SECURITY_LVL); // getAllowedSecurityLevel
		writeF(population);// Population
		writeS(configs.REALM_ALLOWED_CLIENT_BUILD);
	}
}
