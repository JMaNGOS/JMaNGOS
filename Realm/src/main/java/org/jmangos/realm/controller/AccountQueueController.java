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
package org.jmangos.realm.controller;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javolution.util.FastMap;

import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.State;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.handler.RealmToClientChannelHandler;
import org.jmangos.realm.network.packet.auth.server.SMD_SESSION_KEY;
import org.jmangos.realm.network.packet.wow.server.SMSG_ADDON_INFO;
import org.jmangos.realm.network.packet.wow.server.SMSG_AUTH_RESPONSE;
import org.jmangos.realm.network.packet.wow.server.SMSG_CLIENTCACHE_VERSION;
import org.jmangos.realm.network.packet.wow.server.SMSG_TUTORIAL_FLAGS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author MinimaJack
 * 
 */
@Controller
public class AccountQueueController {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(AccountQueueController.class);
    /** */
    private final FastMap<String, AccountInfo> accountQueue =
            new FastMap<String, AccountInfo>().shared();
    /** The sender. */
    @Autowired
    @Qualifier("serverPacketSender")
    private AbstractPacketSender authSender;
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender clientsender;
    /** */
    private NetworkChannel authNetworkChannel;

    private static final Charset charset = Charset.forName("UTF-8");

    @Autowired
    RealmController realmController;

    /** */
    public void loadKeyAndValidateAccount(final AccountInfo aci) {

        if (this.accountQueue.containsKey(aci.getName())) {
            logger.debug("Account {} exist in queue", aci.getName());
            return;
        }
        logger.debug("Add account :{} to queue", aci.getName());
        this.accountQueue.put(aci.getName(), aci);
        this.authSender.send(this.authNetworkChannel, new SMD_SESSION_KEY(aci.getName()));
    }

    public void recieveAccountData(final AccountInfo account) {

        if (this.accountQueue.containsKey(account.getName()) && validateAccountInfo(account)) {
            logger.debug("Recieve AccountInfo for account: {}", account.getName());
            final AccountInfo cAccountInfo = this.accountQueue.get(account.getName());
            this.clientsender.send(cAccountInfo.getChannel(), new SMSG_AUTH_RESPONSE());
            this.clientsender.send(cAccountInfo.getChannel(),
                    new SMSG_ADDON_INFO(cAccountInfo.getAddonLists()));
            this.clientsender.send(cAccountInfo.getChannel(), new SMSG_CLIENTCACHE_VERSION());
            this.clientsender.send(cAccountInfo.getChannel(), new SMSG_TUTORIAL_FLAGS());
            this.accountQueue.remove(account.getName());
        } else {
            logger.debug("Auth server sent wrong data: {}", account.getName());
        }
    }

    private boolean validateAccountInfo(final AccountInfo account) {

        final AccountInfo cAccountInfo = this.accountQueue.get(account.getName());
        MessageDigest sha;
        try {
            sha = MessageDigest.getInstance("SHA-1");
        } catch (final NoSuchAlgorithmException e) {
            return false;
        }
        // TODO replace
        final RealmToClientChannelHandler channelHandler =
                (RealmToClientChannelHandler) ((NettyNetworkChannel) cAccountInfo.getChannel()).getChannel().getPipeline().getLast();
        final byte[] t = { 0, 0, 0, 0 };
        sha.update(account.getName().toUpperCase().getBytes(charset));
        sha.update(t);
        sha.update(cAccountInfo.getClientSeed());
        sha.update(channelHandler.getSeed());
        sha.update(account.getSessionKey().asByteArray(40));
        if (!Arrays.equals(sha.digest(), cAccountInfo.getvK())) {
            cAccountInfo.getChannel().getChannel().close();
            return false;
        }
        /**
         * Now Set right object id And set crypto seed
         */
        cAccountInfo.setObjectId(account.getObjectId());
        channelHandler.getCrypt().init(account.getSessionKey().asByteArray(40));
        cAccountInfo.getChannel().setChannelState(State.AUTHED);
        this.realmController.addAccount(cAccountInfo);
        return true;
    }

    public void removeFromQueue(final String accountName) {

        this.accountQueue.remove(accountName);
    }

    public void setAuthNetworkChannel(final NetworkChannel authNetworkChannel) {

        this.authNetworkChannel = authNetworkChannel;
    }
}
