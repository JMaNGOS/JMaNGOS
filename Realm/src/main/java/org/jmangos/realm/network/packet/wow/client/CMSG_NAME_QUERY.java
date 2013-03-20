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
package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_NAME_QUERY_RESPONSE;
import org.jmangos.realm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_NAME_QUERY.
 */
@Component
public class CMSG_NAME_QUERY extends AbstractWoWClientPacket {

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    /** The guid. */
    private long guid;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        this.guid = readQ();
    }

    @Override
    protected void runImpl() {

        /**
         * FIXME send from database information too need cache
         */

        if (PlayerService.getPlayer(this.guid) != null) {
            this.sender.send(getClient(),
                    new SMSG_NAME_QUERY_RESPONSE(PlayerService.getPlayer(this.guid)));
        }

    }
}
