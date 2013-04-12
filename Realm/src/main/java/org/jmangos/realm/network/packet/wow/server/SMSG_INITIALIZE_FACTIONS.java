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

import org.jmangos.commons.entities.CharacterReputation;
import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_INITIALIZE_FACTIONS.
 */
public class SMSG_INITIALIZE_FACTIONS extends AbstractWoWServerPacket {

    private Player player;
    private static final int MINIMAL_FACTION_COUNT = 128;

    public SMSG_INITIALIZE_FACTIONS() {};

    public SMSG_INITIALIZE_FACTIONS(Player player) {
        this.player = player;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {

        int currRepSize = player.getCharacterData().getReputations().size();
        int dataSize = 0;
        if (currRepSize < MINIMAL_FACTION_COUNT)
            dataSize = MINIMAL_FACTION_COUNT;
        else {
            dataSize = currRepSize;
        }
        Integer i = 0;
        writeD(dataSize);
        for (; i < dataSize; i++) {
            if(player.getCharacterData().getReputations().containsKey(i)){
                CharacterReputation data = player.getCharacterData().getReputations().get(i);
                writeC(data.getFlags());
                writeD(data.getStanding());
            }else{
                writeC(0);
                writeD(0);
            }
        }
    }

}
