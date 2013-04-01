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

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 3:58 To
 * change this template use
 * File | Settings | File Templates.
 */
public class MSG_MOVE_TIME_SKIPPED extends AbstractWoWServerPacket {

    private long guid;
    private int time_dif;

    public MSG_MOVE_TIME_SKIPPED() {

    }

    public MSG_MOVE_TIME_SKIPPED(final long guid, final int time_dif) {

        this.guid = guid;
        this.time_dif = time_dif;
    }

    @Override
    protected void writeImpl() {

        writePackedGuid(this.guid);
        writeD(this.time_dif);
    }
}
