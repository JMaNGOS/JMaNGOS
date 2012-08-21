/******************************************************************************
 * Copyright (C) 2012 JMaNG <http://jmangos.org/>
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
package org.jmangos.auth.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_TEST_CRYPT</tt>.
 */
@Component
public class CMD_TEST_CRYPT extends AbstractWoWClientPacket {
    
    /** The logger. */
    private static Logger        logger = LoggerFactory.getLogger(CMD_TEST_CRYPT.class);
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    private byte[]               crypt;
    
    public CMD_TEST_CRYPT() {
    
        super();
    }
    
    /**
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
     */
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        crypt = readB(5);
    }
    
    /**
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
     */
    @Override
    protected void runImpl() {
    
        logger.debug("{}", crypt);
    }
}
