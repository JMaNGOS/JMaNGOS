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

import org.jmangos.commons.entities.CharacterPositionerHolder;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author MinimaJack
 * 
 */
public class MOVEMENT_OPCODE extends AbstractWoWClientPacket {

    Logger log = LoggerFactory.getLogger(MOVEMENT_OPCODE.class);
    private Long guid;
    private CharacterPositionerHolder movement;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        this.guid = readPackedGuid();
        this.movement = new CharacterPositionerHolder();
        if (getPlayer().getCharacterData().getGuid().equals(this.guid)) {
            this.movement.readFrom(getByteBuffer());
            ((CharacterPositionerHolder)getPlayer().getCharacterData().getMovement()).update(movement);
            this.log.debug("Change position: {}", this.movement.getPosition());
        } else {
            this.log.warn("Movers not equal {}  and {}", getPlayer().getCharacterData().getGuid(),
                    this.guid);
        }
       
    }

    @Override
    protected void runImpl() {

    }
}
