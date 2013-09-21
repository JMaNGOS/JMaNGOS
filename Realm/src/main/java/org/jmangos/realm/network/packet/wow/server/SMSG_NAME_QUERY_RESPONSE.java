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

import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_NAME_QUERY_RESPONSE.
 */
public class SMSG_NAME_QUERY_RESPONSE extends AbstractWoWServerPacket {

    /** The player. */
    private Player player;

    /**
     * Instantiates a new sMS g_ nam e_ quer y_ response.
     */
    public SMSG_NAME_QUERY_RESPONSE() {

    }

    /**
     * Instantiates a new sMS g_ nam e_ quer y_ response.
     * 
     * @param player
     *        the player
     */
    public SMSG_NAME_QUERY_RESPONSE(final Player player) {

        this.player = player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {

        writePackedGuid(this.player.getCharacterData().getGuid());
        writeC(0);
        writeS(this.player.getCharacterData().getName());
        writeC(0);
        writeC(this.player.getCharacterData().getRace().getValue());
        writeC(this.player.getCharacterData().getGender().getValue());
        writeC(this.player.getCharacterData().getClazz().getValue());
        writeC(0);
    }

}
