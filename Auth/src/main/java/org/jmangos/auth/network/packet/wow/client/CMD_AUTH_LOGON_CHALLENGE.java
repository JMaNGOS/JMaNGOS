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

import java.nio.charset.Charset;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.auth.controller.AccountController;
import org.jmangos.auth.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.auth.network.packet.wow.server.SMD_AUTH_LOGON_CHALLENGE;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_AUTH_LOGON_CHALLENGE</tt>.
 */
@Component
public class CMD_AUTH_LOGON_CHALLENGE extends AbstractWoWClientPacket {
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    /** The account controller. */
    @Inject
    private AccountController    accountController;
    
    private int                  lenLogin;
    private String               login;
    
    /**
     * Constructs new instance of <tt>CMD_AUTH_LOGON_CHALLENGE</tt> packet.
     * 
     * @param opcode
     *            the opcode
     */
    
    public CMD_AUTH_LOGON_CHALLENGE(final int opcode) {
    
        super(opcode);
    }
    
    /**
     * Instantiates a new CMD_AUTH_LOGON_CHALLENGE.
     */
    public CMD_AUTH_LOGON_CHALLENGE() {
    
        super();
    }
    
    /**
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#getMinimumLength()
     */
    @Override
    public int getMinimumLength() {
    
        return 0;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void readImpl() {
    
        /** int error = */
        readC();
        /** int size = */
        readH();
        /** byte[] gamename = */
        readB(4);
        /** int version1 = */
        readC();
        /** int version2 = */
        readC();
        /** int version3 = */
        readC();
        /** int build = */
        readH();
        /** byte[] platform = */
        readB(4);
        /** byte[] os = */
        readB(4);
        /** byte[] country = */
        readB(4);
        /** int timezone_bias = */
        readD();
        /** int ip = */
        readD();
        this.lenLogin = readC();
        this.login = new String(readB(this.lenLogin), Charset.forName("UTF-8"));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void runImpl() {
    
        final WoWAuthResponse response = this.accountController.loadLogin(this.login, (NettyNetworkChannel) getClient());
        switch (response) {
            case WOW_FAIL_BANNED:
                this.sender.sendAndClose(getClient(), new SMD_AUTH_LOGON_CHALLENGE(response));
                break;
            default:
                this.sender.send(getClient(), new SMD_AUTH_LOGON_CHALLENGE(response));
                break;
        }
    }
}
