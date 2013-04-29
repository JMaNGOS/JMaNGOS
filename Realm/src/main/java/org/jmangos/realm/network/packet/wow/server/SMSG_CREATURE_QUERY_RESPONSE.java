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
package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.commons.entities.CreaturePrototype;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_CREATURE_QUERY_RESPONSE.
 */
public class SMSG_CREATURE_QUERY_RESPONSE extends AbstractWoWServerPacket {

    private static final int MAX_CREATURE_MODEL = 4;
    private CreaturePrototype creatureTemplate;

    SMSG_CREATURE_QUERY_RESPONSE() {}

    public SMSG_CREATURE_QUERY_RESPONSE(CreaturePrototype creatureTemplate) {
        this.creatureTemplate = creatureTemplate;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
        writeD(creatureTemplate.getGuid());
        writeS(creatureTemplate.getName());
        writeC(0);
        writeC(0);
        writeC(0);
        writeS(creatureTemplate.getSubName());
        writeS(creatureTemplate.getIconName());
        writeD(creatureTemplate.getTypeFlag());
        writeD(creatureTemplate.getCreatureType());
        writeD(creatureTemplate.getFamily());
        writeD(creatureTemplate.getRank());
        writeD(creatureTemplate.getKillCredit(0));
        writeD(creatureTemplate.getKillCredit(1));

        for (int i = 0; i < MAX_CREATURE_MODEL; ++i){
            writeD(creatureTemplate.getModelId(i));
        }
        writeF(creatureTemplate.getHealthModifier());
        writeF(creatureTemplate.getPowerModifier());
        writeC(creatureTemplate.getRacialLeader());
        //quest drop
        for (int i = 0; i < 6; ++i)
            writeD(0);
        writeD(creatureTemplate.getMovementId());
    }
}
