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
package org.jmangos.realm.network.packet.auth.server;

import org.jmangos.realm.network.packet.auth.AbstractRealmServerPacket;

/**
 * The Class <tt>SMD_SESSION_KEY</tt>.
 */
public class SMD_SESSION_KEY extends AbstractRealmServerPacket {

    private final String account;

    public SMD_SESSION_KEY(final String account) {

        this.account = account;
    }

    /**
     * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {

        writeS(this.account);
    }
}
