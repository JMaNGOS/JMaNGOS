/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.auth.network.packet.wow.server;

import javolution.util.FastMap;

import org.jmangos.auth.network.packet.wow.AbstractWoWServerPacket;
import org.jmangos.auth.realm.controller.RealmListController;
import org.jmangos.commons.dataholder.Visitor;
import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.model.RealmInfo;

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
     *        the worldlist
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

        final FastMap<Integer, Integer> amountofCharacters =
                this.worldlist.getAmountCharacters(((AccountInfo) (getChannel().getChanneledObject())).getObjectId());
        writeH(this.worldlist.getByteSize());
        writeD(0);
        writeH(this.worldlist.getRealmCount());
        this.worldlist.getRealms().iterate(new Visitor<RealmInfo>() {

            @Override
            public void visit(final RealmInfo realmInfo) {

                writeC(realmInfo.getIcon());
                writeC((realmInfo.getAllowedSecurityLevel() > ((AccountInfo) (getChannel().getChanneledObject())).getAccessLevel())
                        ? 1
                        : 0);
                writeC(realmInfo.getRealmflags());
                writeS(realmInfo.getName());
                writeS(realmInfo.getAddress() + ":" + realmInfo.getPort());
                writeF(realmInfo.getPopulation());
                writeC((amountofCharacters.containsKey(realmInfo.getObjectId()))
                        ? amountofCharacters.get(realmInfo.getObjectId())
                        : 0);
                writeC(realmInfo.getTimezone());
                writeC(0x2C);

            }
        });
        writeH(0x0010);
    }
}
