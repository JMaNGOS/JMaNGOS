package org.jmangos.realm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.model.container.AccountsContainer;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.auth.server.SMD_SESSION_KEY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RealmController {
    
    /** The Constant logger. */
    private static final Logger      logger   = LoggerFactory.getLogger(RealmController.class);
    
    private static AccountsContainer accounts = new AccountsContainer();
    
    /** The sender. */
    @Inject
    @Named("serverPacketSender")
    private AbstractPacketSender     authSender;
    
    private NetworkChannel           authNetworkChannel;
    
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
