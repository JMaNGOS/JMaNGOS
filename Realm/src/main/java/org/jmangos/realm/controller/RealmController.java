package org.jmangos.realm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.model.AccountInfo;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.auth.server.SMD_SESSION_KEY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RealmController {
    
    /** The Constant logger. */
    private static final Logger         logger   = LoggerFactory.getLogger(RealmController.class);
    
    private static Map<String, AccountInfo> accounts = new HashMap<String, AccountInfo>();
    
    /** The sender. */
    @Inject
    @Named("serverPacketSender")
    private AbstractPacketSender        authSender;
    
    private NetworkChannel              authNetworkChannel;
    
    public void getAuthNetworkChannel(final NetworkChannel authNetworkChannel) {
    
        this.authNetworkChannel = authNetworkChannel;
    }
    
    public AccountInfo getAccount(final String accountName) {
    
        if ((accountName != null) && !accountName.isEmpty() && (this.authNetworkChannel != null)) {
            this.authSender.send(this.authNetworkChannel, new SMD_SESSION_KEY(accountName));
            accounts.put(accountName, null);
            
            boolean first = true;
            for (int i = 0; i < 10; i++) {
                try {
                    if (first) {
                        first = false;
                        Thread.sleep(3000);
                    } else {
                        Thread.sleep(2000);
                    }
                    if (accounts.get(accountName) != null) {
                        final AccountInfo account = accounts.get(accountName);
                        accounts.remove(accountName);
                        return account;
                    }
                } catch (final InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
            accounts.remove(accountName);
        }
        return null;
    }
    
    public void setAccount(final AccountInfo account) {
    
        accounts.put(account.getName(), account);
    }
    
}
