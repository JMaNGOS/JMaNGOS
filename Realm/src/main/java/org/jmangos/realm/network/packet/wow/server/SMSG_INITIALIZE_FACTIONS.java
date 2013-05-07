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

import java.nio.ByteOrder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jmangos.commons.entities.CharacterReputation;
import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_INITIALIZE_FACTIONS.
 */
public class SMSG_INITIALIZE_FACTIONS extends AbstractWoWServerPacket {

    private Player player;
    public static final int MINIMAL_FACTION_COUNT = 128;

    public SMSG_INITIALIZE_FACTIONS() {};

    public SMSG_INITIALIZE_FACTIONS(final Player player) {
        this.player = player;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {

        final int currRepSize = this.player.getCharacterData().getReputations().size();
        int dataSize = 0;
        if (currRepSize < MINIMAL_FACTION_COUNT) {
            dataSize = MINIMAL_FACTION_COUNT;
        } else {
            dataSize = currRepSize;
        }
        writeD(dataSize);

        final ChannelBuffer buffer =
                ChannelBuffers.directBuffer(ByteOrder.LITTLE_ENDIAN, dataSize * 5);

        for (final CharacterReputation reputation : this.player.getCharacterData().getReputations()) {
            final int factionIndex = reputation.getFaction();
            buffer.setByte(factionIndex * 5, reputation.getFlags());
            buffer.setInt((factionIndex * 5) + 1, reputation.getStanding());
        }

        getByteBuffer().writeBytes(buffer, 0, dataSize * 5);
    }

}
