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

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.ArrayUtils;
import org.jmangos.auth.controller.AccountController;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_AUTH_LOGON_PROOF;
import org.jmangos.auth.service.AccountService;
import org.jmangos.auth.utils.AccountUtils;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.commons.utils.BigNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_AUTH_LOGON_PROOF</tt>.
 */
@Component
public class CMD_AUTH_LOGON_PROOF extends AbstractWoWClientPacket {
    
    /** The Constant logger. */
    private static final Logger  logger = LoggerFactory.getLogger(CMD_AUTH_LOGON_PROOF.class);
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    /** The account controller. */
    @Inject
    AccountController            accountController;
    
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
    
        a = readB(32);
        m1 = readB(20);
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
    
        final WoWAuthResponse response = this.accountController.checkPassword(getAccount(), a, m1);
        this.sender.send(getClient(), new TCMD_AUTH_LOGON_PROOF(response));
    }
}
