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
package org.jmangos.auth.network.packet.wow.client;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.auth.controller.AccountController;
import org.jmangos.auth.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.auth.network.packet.wow.server.SMD_AUTH_LOGON_PROOF;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_AUTH_LOGON_PROOF</tt>.
 */
@Component
public class CMD_AUTH_LOGON_PROOF extends AbstractWoWClientPacket {
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    /** The account controller. */
    @Inject
    private AccountController    accountController;
    
    private byte[]               a;
    private byte[]               m1;
    
    /**
     * Instantiates a new CMD_AUTH_LOGON_PROOF.
     */
    public CMD_AUTH_LOGON_PROOF() {
    
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void readImpl() {
    
        this.a = readB(32);
        this.m1 = readB(20);
        /** byte[] crc = */
        readB(20);
        /** int numberofKey = */
        readC();
        /** int securityFlag = */
        readC();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void runImpl() {
    
        final WoWAuthResponse response = this.accountController.checkPassword(getAccount(), this.a, this.m1);
        this.sender.send(getClient(), new SMD_AUTH_LOGON_PROOF(response));
    }
}
