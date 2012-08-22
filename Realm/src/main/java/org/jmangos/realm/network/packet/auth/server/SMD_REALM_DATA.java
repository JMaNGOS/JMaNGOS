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
package org.jmangos.realm.network.packet.auth.server;

import org.jmangos.realm.config.Config;
import org.jmangos.realm.network.packet.auth.AbstractRealmServerPacket;

/**
 * The Class <tt>CMD_REALM_DATA</tt>.
 */
public class SMD_REALM_DATA extends AbstractRealmServerPacket {
    
    private Config configs;
    private Float  population;
    
    public SMD_REALM_DATA() {
    
    }
    
    public SMD_REALM_DATA(final Config config, final Float population) {
    
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
    
        writeS(this.configs.REALM_NAME);
        writeS(this.configs.REALM_ADDRESS);
        writeD(this.configs.REALM_PORT);
        writeC(this.configs.REALM_ICON); // icon
        writeC(this.configs.REALM_FLAGS); // getRealmflags
        writeC(this.configs.REALM_TIME_ZONE); // Timezone
        writeC(this.configs.REALM_ALLOWED_SECURITY_LVL); // getAllowedSecurityLevel
        writeF(this.population);// Population
        writeS(this.configs.REALM_ALLOWED_CLIENT_BUILD);
    }
}
