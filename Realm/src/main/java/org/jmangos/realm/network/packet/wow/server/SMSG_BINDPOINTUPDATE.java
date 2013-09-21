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

import org.jmangos.commons.entities.CharacterPositionerHolder;
import org.jmangos.commons.entities.HomeBindData;
import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_BINDPOINTUPDATE.
 */
public class SMSG_BINDPOINTUPDATE extends AbstractWoWServerPacket {

    /** The player. */
    private final Player player;

    /**
     * Instantiates a new SMSG_BINDPOINTUPDATE.
     * 
     * @param player
     *        the player
     */
    public SMSG_BINDPOINTUPDATE(final Player player) {

        this.player = player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {

        final HomeBindData hdb =
                ((CharacterPositionerHolder) this.player.getCharacterData().getMovement()).getHomeBindData();
        writeF(hdb.getPosition().getX());
        writeF(hdb.getPosition().getY());
        writeF(hdb.getPosition().getZ());
        writeD(hdb.getHomeBindMapId());
        writeD(hdb.getHomeBindAreaId());
    }
}
