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

import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.enums.CharDeleteCode;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CMSG_CHAR_DELETE extends AbstractWoWClientPacket {

    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Autowired
    private CharacterController characterController;

    /**
     * The guid.
     */
    private long guid;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        this.guid = readQ();
    }

    @Override
    protected void runImpl() {
        final CharDeleteCode code = this.characterController.deleteCharacter(this.guid);
        this.sender.send(getClient(), new SMSG_CHAR_DELETE(code));
    }
}
