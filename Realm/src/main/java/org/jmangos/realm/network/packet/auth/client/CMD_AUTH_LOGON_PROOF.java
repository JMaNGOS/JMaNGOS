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
package org.jmangos.realm.network.packet.auth.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.auth.AbstractRealmClientPacket;
import org.jmangos.realm.network.packet.auth.server.CMD_AUTH_ENABLE_CRYPT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_AUTH_LOGON_PROOF</tt>.
 */
@Component
public class CMD_AUTH_LOGON_PROOF extends AbstractRealmClientPacket {
    
    /** The logger. */
    private static Logger        logger = LoggerFactory.getLogger(CMD_AUTH_LOGON_PROOF.class);
    @Inject
    @Named("serverPacketSender")
    private AbstractPacketSender sender;
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
     */
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        if (readC() == WoWAuthResponse.WOW_SUCCESS.getMessageId()) {
            logger.debug("CMD_AUTH_LOGON_PROOF succes");
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
     */
    @Override
    protected void runImpl() {
    
        this.sender.send(getClient(), new CMD_AUTH_ENABLE_CRYPT());
        
    }
}
