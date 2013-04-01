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
 * The Class CMSG_JOIN_CHANNEL.
 */
@Component
public class CMSG_JOIN_CHANNEL extends AbstractWoWClientPacket {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(CMSG_JOIN_CHANNEL.class);

    private int chanellId;
    private String channelname;

    @SuppressWarnings("unused")
    private String password;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        /**
         * TODO implement channelMgr
         */
        this.chanellId = readD();
        /* unk = */readC();
        /* unk2 = */readC();
        this.channelname = readUTF8(1024);
        logger.debug("Character join to channel id: {} name: {}", this.chanellId, this.channelname);
        if (this.channelname.length() == 0) {
            return;
        }
        this.password = readUTF8(1024);
    }

    @Override
    protected void runImpl() {

    }
}
