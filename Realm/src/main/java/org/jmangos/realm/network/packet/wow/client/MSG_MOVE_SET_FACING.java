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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class MSG_MOVE_SET_FACING.
 */
@Component
public class MSG_MOVE_SET_FACING extends AbstractWoWClientPacket {

    private static final Logger logger = LoggerFactory.getLogger(MSG_MOVE_SET_FACING.class);
    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        final Long guid = readPackedGuid();
        logger.debug("Resive MSG_MOVE_SET_FACING from {}", guid);
        skipAll();
    }

    @Override
    protected void runImpl() {

    }
}
