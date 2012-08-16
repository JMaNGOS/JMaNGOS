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
package org.jmangos.realm.network.netty.packetClient.server;

import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_COMPRESSED_UPDATE_OBJECT.
 */
public class SMSG_COMPRESSED_UPDATE_OBJECT extends AbstractWoWServerPacket {
    
    /** The player. */
    @SuppressWarnings("unused")
    private Player player;
    private byte[] packet;
    
    /**
     * <<<<<<< .merge_file_a01472 Instantiates a new SMSG_compressed_update_object.
     */
    public SMSG_COMPRESSED_UPDATE_OBJECT() {
    
    }
    
    /**
     * Instantiates a new SMSG_compressed_update_object. ======= Instantiates a new sMS g_ compresse
     * d_ updat e_ object. >>>>>>> .merge_file_a04904
     * 
     * @param player
     *            the player
     */
    public SMSG_COMPRESSED_UPDATE_OBJECT(final Player player, final byte[] packet) {
    
        this.player = player;
        this.packet = packet;
    }
    
    public void setPacket(final byte[] bytes) {
    
        this.packet = bytes;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
    
        writeB(this.packet);
    }
    
}
