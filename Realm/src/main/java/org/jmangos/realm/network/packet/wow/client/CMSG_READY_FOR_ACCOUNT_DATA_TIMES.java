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
 * The Class CMSG_READY_FOR_ACCOUNT_DATA_TIMES.
 */
@Component
public class CMSG_READY_FOR_ACCOUNT_DATA_TIMES extends AbstractWoWClientPacket {

    /** The logger. */
    private static Logger logger = LoggerFactory.getLogger(CMSG_READY_FOR_ACCOUNT_DATA_TIMES.class);
    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {

        logger.info("CMSG_READY_FOR_ACCOUNT_DATA_TIMES received!");
    }

    @Override
    protected void runImpl() {

        // TODO: reimplement account data save
        /*
         * getAccount().setAccountData(
         * accountServise.getAccountData(getAccount().getObjectId()));
         * sender.send(getClient(), new SMSG_ACCOUNT_DATA_TIMES(
         * SMSG_ACCOUNT_DATA_TIMES.GLOBAL_CACHE_MASK, getAccount()
         * .getAccountData()));
         */

    }
}
