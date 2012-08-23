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

import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.commons.utils.BigNumber;
import org.jmangos.realm.controller.RealmController;
import org.jmangos.realm.network.packet.auth.AbstractRealmClientPacket;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_SESSION_KEY</tt>.
 */
@Component
public class CMD_SESSION_KEY extends AbstractRealmClientPacket {
    
    @Inject
    @Named("serverPacketSender")
    private AbstractPacketSender sender;
    
    @Inject
    private RealmController      realmController;
    
    private String               account;
    private int                 accountId;
    private BigNumber            sessionKey;
    
    /**
     * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
     */
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.account = readS();
        this.accountId = readD();
        this.sessionKey = new BigNumber();
        this.sessionKey.setBinary(readB(40));
    }
    
    /**
     * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
     */
    @Override
    protected void runImpl() {
    
        final AccountInfo account = new AccountInfo();
        account.setName(this.account);
        account.setObjectId(this.accountId);
        account.setSessionKey(this.sessionKey);
        this.realmController.setAccount(account);
    }
}
