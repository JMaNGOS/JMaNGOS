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
package org.jmangos.auth.network.netty.packet.client;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.auth.controller.AccountController;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_RECONNECT_PROOF;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_RECONNECT_PROOF</tt>.
 */
@Component
public class CMD_RECONNECT_PROOF extends AbstractWoWClientPacket {
    
    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger  logger = LoggerFactory.getLogger(CMD_RECONNECT_PROOF.class);
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    /** The account controller. */
    @Inject
    AccountController            accountController;
    
    private byte[]               R1;
    private byte[]               R2;
    
    /**
     * Instantiates a new <tt>CMD_RECONNECT_PROOF</tt>.
     */
    public CMD_RECONNECT_PROOF() {
    
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void readImpl() {
    
        this.R1 = readB(16);
        this.R2 = readB(20);
        // byte[] R3 = readB(20); // Unused..
        /* int numberofKey = */readC(); // unused
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void runImpl() {
    
        final boolean response = this.accountController.checkSessionKey(getAccount(), this.R1, this.R2);
        if (response) {
            this.sender.send(getClient(), new TCMD_RECONNECT_PROOF());
        } else {
            getChannel().close();
        }
        
    }
    
}
