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

import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_PONG.
 */
public class SMSG_PONG extends AbstractWoWServerPacket {

    /** The ping. */
    private int ping;

    /**
     * Instantiates a new sMS g_ pong.
     */
    public SMSG_PONG() {

    }

    /**
     * Instantiates a new sMS g_ pong.
     * 
     * @param ping
     *        the ping
     */
    public SMSG_PONG(final int ping) {

        this.ping = ping;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {

        writeD(this.ping);
    }

}
