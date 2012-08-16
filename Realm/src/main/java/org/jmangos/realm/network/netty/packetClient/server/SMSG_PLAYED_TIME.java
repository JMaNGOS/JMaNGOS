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

import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_PLAYED_TIME.
 */
public class SMSG_PLAYED_TIME extends AbstractWoWServerPacket {
    
    /** The unk. */
    private byte unk;
    
    /**
     * Instantiates a new sMS g_ playe d_ time.
     */
    public SMSG_PLAYED_TIME() {
    
    }
    
    /**
     * Instantiates a new sMS g_ playe d_ time.
     * 
     * @param unk
     *            the unk
     */
    public SMSG_PLAYED_TIME(final byte unk) {
    
        this.unk = unk;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {
    
        writeB(new byte[] { 0x44, 0x05, 0x00, 0x00, 0x47, 0x02, 0x00, 0x00 });
        /*
         * writeD(0); writeD(0);
         */
        writeC(this.unk);
    }
    
}
