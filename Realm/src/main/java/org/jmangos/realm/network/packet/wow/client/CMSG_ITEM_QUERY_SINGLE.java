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
import org.jmangos.realm.network.packet.wow.server.SMSG_ITEM_QUERY_SINGLE_RESPONSE;
import org.jmangos.realm.service.ItemStorages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_ITEM_QUERY_SINGLE.
 */
@Component
public class CMSG_ITEM_QUERY_SINGLE extends AbstractWoWClientPacket {

    private static final Logger logger = LoggerFactory.getLogger(CMSG_ITEM_QUERY_SINGLE.class);
    /** The item. */
    private int item;

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    /** The item storages. */
    @Autowired
    private ItemStorages itemStorages;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        this.item = readD();
        logger.info("Player wan't info for item {}", this.item);

    }

    @Override
    protected void runImpl() {

        this.sender.send(getClient(),
                new SMSG_ITEM_QUERY_SINGLE_RESPONSE(this.itemStorages.get(this.item)));
    }

}
