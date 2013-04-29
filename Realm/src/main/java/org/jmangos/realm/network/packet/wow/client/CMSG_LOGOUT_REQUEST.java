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
package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_LOGOUT_COMPLETE;
import org.jmangos.realm.service.MapService;
import org.jmangos.realm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date:
 * 2012.08.12. Time:
 * 17:31
 */
@Component
public class CMSG_LOGOUT_REQUEST extends AbstractWoWClientPacket {

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    /** The player service. */
    @Autowired
    private MapService mapService;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        skipAll();
    }

    @Override
    protected void runImpl() {
        this.mapService.getMap(getPlayer().getCharacterData().getMovement().getMap()).removeObject(getPlayer().getCharacterData());
        // TODO: implement SMSG_LOGOUT_RESPONSE
        this.sender.send(getPlayer().getChannel(), new SMSG_LOGOUT_COMPLETE());
    }
}
