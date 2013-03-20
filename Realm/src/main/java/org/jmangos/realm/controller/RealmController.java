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
package org.jmangos.realm.controller;

import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.model.container.AccountsContainer;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RealmController {

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(RealmController.class);

    private static AccountsContainer accounts = new AccountsContainer();

    /** The sender. */
    @Autowired
    @Qualifier("serverPacketSender")
    private AbstractPacketSender authSender;

    @SuppressWarnings("unused")
    private NetworkChannel authNetworkChannel;

    public void setAuthNetworkChannel(final NetworkChannel authNetworkChannel) {

        this.authNetworkChannel = authNetworkChannel;
    }

    public AccountInfo getAccount(final String accountName) {

        return accounts.getNamedObject(accountName);
    }

    public void addAccount(final AccountInfo account) {

        accounts.addObject(account);
    }

}
