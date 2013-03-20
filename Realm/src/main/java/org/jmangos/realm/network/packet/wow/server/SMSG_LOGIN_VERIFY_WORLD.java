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
package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_LOGIN_VERIFY_WORLD.
 */
public class SMSG_LOGIN_VERIFY_WORLD extends AbstractWoWServerPacket {

    /** The player. */
    private Player player;

    /**
     * Instantiates a new SMSG_LOGIN_VERIFY_WORLD.
     */
    public SMSG_LOGIN_VERIFY_WORLD() {

    }

    /**
     * Instantiates a new SMSG_LOGIN_VERIFY_WORLD.
     * 
     * @param player
     *        the player
     */
    public SMSG_LOGIN_VERIFY_WORLD(final Player player) {

        this.player = player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {

        writeD(this.player.getCharacterData().getMovement().getMap());
        writeF(this.player.getCharacterData().getMovement().getPosition().getX());
        writeF(this.player.getCharacterData().getMovement().getPosition().getY());
        writeF(this.player.getCharacterData().getMovement().getPosition().getZ());
        writeF(this.player.getCharacterData().getMovement().getPosition().getO());
    }

}
