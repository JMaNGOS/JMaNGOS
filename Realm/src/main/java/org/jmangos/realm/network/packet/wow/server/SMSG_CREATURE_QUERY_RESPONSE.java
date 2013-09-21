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

    public SMSG_CREATURE_QUERY_RESPONSE(final CreaturePrototype creatureTemplate) {
        this.creatureTemplate = creatureTemplate;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
        writeD(this.creatureTemplate.getGuid());
        writeS(this.creatureTemplate.getName());
        writeC(0);
        writeC(0);
        writeC(0);
        writeS(this.creatureTemplate.getSubName());
        writeS(this.creatureTemplate.getIconName());
        writeD(this.creatureTemplate.getTypeFlag());
        writeD(this.creatureTemplate.getCreatureType());
        writeD(this.creatureTemplate.getFamily());
        writeD(this.creatureTemplate.getRank());
        writeD(this.creatureTemplate.getKillCredit(0));
        writeD(this.creatureTemplate.getKillCredit(1));

        for (int i = 0; i < MAX_CREATURE_MODEL; ++i) {
            writeD(this.creatureTemplate.getModelId(i));
        }
        writeF(this.creatureTemplate.getHealthModifier());
        writeF(this.creatureTemplate.getPowerModifier());
        writeC(this.creatureTemplate.getRacialLeader());
        // quest drop
        for (int i = 0; i < 6; ++i) {
            writeD(0);
        }
        writeD(this.creatureTemplate.getMovementId());
    }
}
