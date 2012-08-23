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
package org.jmangos.auth.network.packet.wow.server;

import javolution.util.FastMap;

import org.jmangos.auth.entities.RealmEntity;
import org.jmangos.auth.network.packet.wow.AbstractWoWServerPacket;
import org.jmangos.auth.service.RealmListController;
import org.jmangos.commons.model.AccountInfo;

/**
 * The Class <tt>TCMD_REALM_LIST</tt>.
 */
public class SMD_REALM_LIST extends AbstractWoWServerPacket {
    
    /** The worldlist. */
    private RealmListController worldlist;
    
    /**
     * Instantiates a new <tt>TCMD_REALM_LIST</tt>.
     */
    public SMD_REALM_LIST() {
    
    }
    
    /**
     * Instantiates a new TCMD_REALM_LIST.
     * 
     * @param worldlist
     *            the worldlist
     */
    public SMD_REALM_LIST(final RealmListController worldlist) {
    
        this.worldlist = worldlist;
    }
    
    /**
     * 
     * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {
    
        final FastMap<Integer, Integer> amountofCharacters = this.worldlist.getAmountCharacters(((AccountInfo) (getChannel().getChanneledObject())).getObjectId());
        writeH(this.worldlist.getByteSize());
        writeD(0);
        writeH(this.worldlist.getRealmCount());
        for (final RealmEntity realmEntity : this.worldlist.getWorlds().values()) {
            writeC(realmEntity.getIcon());
            writeC((realmEntity.getAllowedSecurityLevel() > ((AccountInfo) (getChannel().getChanneledObject())).getAccessLevel()) ? 1 : 0);
            writeC(realmEntity.getRealmflags());
            writeS(realmEntity.getName());
            writeS(realmEntity.getAddress() + ":" + realmEntity.getPort());
            writeF(realmEntity.getPopulation());
            writeC((amountofCharacters.containsKey(realmEntity.getId())) ? amountofCharacters.get(realmEntity.getId()) : 0);
            writeC(realmEntity.getTimezone());
            writeC(0x2C);
        }
        writeH(0x0010);
    }
}
