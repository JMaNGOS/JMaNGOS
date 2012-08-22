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
package org.jmangos.realm.network.packet.auth.server;

import org.jmangos.realm.network.packet.auth.AbstractRealmServerPacket;

/**
 * The Class <tt>CMD_AUTH_LOGON_PROOF</tt>.
 */
public class CMD_AUTH_LOGON_PROOF extends AbstractRealmServerPacket {
    
    /** The m1. */
    private byte[] m1;
    
    /** The a. */
    private byte[] a;
    
    /**
     * Instantiates a new jmangos.
     */
    public CMD_AUTH_LOGON_PROOF() {
    
    }
    
    /**
     * Instantiates a new jmangos.
     * 
     * @param a
     *            the a
     * @param m1
     *            the m1
     */
    public CMD_AUTH_LOGON_PROOF(final byte[] a, final byte[] m1) {
    
        this.a = a;
        this.m1 = m1;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {
    
        final byte[] crc = new byte[20];
        writeB(this.a);
        writeB(this.m1);
        writeB(crc);
        writeH(0);
    }
}
