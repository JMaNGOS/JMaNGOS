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

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_SWAP_INV_ITEM.
 */
@Component
public class CMSG_SWAP_INV_ITEM extends AbstractWoWClientPacket {
    
    /** The logger. */
    private static Logger        logger = LoggerFactory.getLogger(CMSG_SWAP_INV_ITEM.class);
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    private int                  src;
    private int                  dst;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        logger.info("CMSG_SWAP_INV_ITEM");
        this.dst = readC();
        this.src = readC();
        logger.info("CMSG_SWAP_INV_ITEM {} {}", this.src, this.dst);
    }
    
    @Override
    protected void runImpl() {
    
    }
}
