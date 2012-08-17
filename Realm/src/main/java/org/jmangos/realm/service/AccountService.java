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
package org.jmangos.realm.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.jmangos.commons.model.Account;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.realm.dao.AccountDAO;
import org.jmangos.realm.model.account.AccountData;
import org.jmangos.realm.model.base.character.CharacterData;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for controlling all account actions.
 * 
 * @author MinimaJack
 */
@Component
public class AccountService {
    
    /** The account dao. */
    @Inject
    private AccountDAO   accountDAO;
    
    /** The item storages. */
    @Inject
    private ItemStorages itemStorages;
    
    /**
     * Creates the and attach account.
     * 
     * @param name
     *            the name
     * @param channelHandler
     *            the channel handler
     * @return the account
     */
    public Account createAndAttachAccount(final String name, final NettyNetworkChannel channelHandler) {
    
        final Account account = getAccountFromDB(name);
        channelHandler.setChanneledObject(account);
        return account;
    }
    
    /**
     * Loads account from DB and returns it, or returns null if account was not loaded.
     * 
     * @param accountName
     *            Account name
     * @return loaded account or null
     */
    public Account getAccountFromDB(final String accountName) {
    
        return this.accountDAO.getAccount(accountName);
    }
    
    /**
     * Save session key.
     * 
     * @param accountName
     *            the account name
     * @param Key
     *            the key
     */
    public void saveSessionKey(final String accountName, final String Key) {
    
        this.accountDAO.saveSessionKey(accountName, Key);
    }
    
    /**
     * Gets the account data.
     * 
     * @param id
     *            the id
     * @return the account data
     */
    public HashMap<Integer, AccountData> getAccountData(final int id) {
    
        return this.accountDAO.getAccountData(id);
    }
    
    /**
     * Gets the session key from db.
     * 
     * @param username
     *            the username
     * @return the session key from db Session Key from DB
     */
    public String getSessionKeyFromDB(final String username) {
    
        return this.accountDAO.getSessionKey(username);
    }
    
    /**
     * Load tutorials data from db.
     * 
     * @param guid
     *            - Account
     * @return the int[] all tutorial Data saved in DB
     */
    public int[] loadTutorialsDataFromDB(final int guid) {
    
        return this.accountDAO.getTutorialsData(guid);
    }
    
    /**
     * Search account's characters
     * 
     * @param accountId
     *            account to query
     */
    public List<CharacterData> getCharacters(final int accountId) {
    
        return this.accountDAO.getCharacters(accountId);
    }
}
