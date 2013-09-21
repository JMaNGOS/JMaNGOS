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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.09. Time: 0:07 To
 * change this template use
 * File | Settings | File Templates.
 */
public class SMSG_UPDATE_OBJECT extends AbstractWoWServerPacket {

    /** The logger. */
    private static Logger logger = LoggerFactory.getLogger(SMSG_UPDATE_OBJECT.class);

    private final byte[] data;

    public SMSG_UPDATE_OBJECT(final byte[] array) {

        this.data = array;
    }

    @Override
    protected void writeImpl() {

        writeB(this.data);
        logger.debug("Update complete. packets cleared.");
    }

}
