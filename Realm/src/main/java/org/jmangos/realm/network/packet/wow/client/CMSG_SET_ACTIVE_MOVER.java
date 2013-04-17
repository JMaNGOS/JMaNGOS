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

import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMSG_SET_ACTIVE_MOVER</tt>.
 * Used to set active mover from client side.</br>
 * TODO: Need some validating.
 * 
 * @author MinimaJack
 */
@Component
public class CMSG_SET_ACTIVE_MOVER extends AbstractWoWClientPacket {

    private static final Logger logger = LoggerFactory.getLogger(CMSG_SET_ACTIVE_MOVER.class);

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        final long guid = readQ();
        // TODO: set active mover to CharacterMovementHolder
        logger.info("CMSG_SET_ACTIVE_MOVER: {} ", guid);

    }

    @Override
    protected void runImpl() {

    }
}
