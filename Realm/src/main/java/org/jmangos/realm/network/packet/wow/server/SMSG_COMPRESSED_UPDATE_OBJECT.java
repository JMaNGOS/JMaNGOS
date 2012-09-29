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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.DeflaterInputStream;

import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_COMPRESSED_UPDATE_OBJECT.
 */
public class SMSG_COMPRESSED_UPDATE_OBJECT extends AbstractWoWServerPacket {
    
    /** The player. */
    @SuppressWarnings("unused")
    private Player player;
    private byte[] packet;
    
    /**
     * 
     */
    public SMSG_COMPRESSED_UPDATE_OBJECT() {
    
    }
    
    /**
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
    @SuppressWarnings("restriction")
    @Override
    public void writeImpl() {
    
        final ByteArrayInputStream bais = new ByteArrayInputStream(this.packet);
        final DeflaterInputStream deflaterInputStream = new DeflaterInputStream(bais);
        byte[] defos;
        try {
            defos = sun.misc.IOUtils.readFully(deflaterInputStream, -1, true);
            writeD(defos.length);
            writeB(defos);
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
