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
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.realm.dao.AccountDAO;
import org.jmangos.realm.model.account.Account;
import org.jmangos.realm.model.account.AccountData;
import org.jmangos.realm.model.base.character.CharactersData;
import org.jmangos.realm.model.base.item.ItemPrototype;
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
	private AccountDAO accountDAO;

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
	public Account createAndAttachAccount(String name,
			NettyNetworkChannel channelHandler) {
		Account account = getAccountFromDB(name);
		channelHandler.setChanneledObject(account);
		return account;
	}

	/**
	 * Loads account from DB and returns it, or returns null if account was not
	 * loaded.
	 * 
	 * @param accountName
	 *            Account name
	 * @return loaded account or null
	 */
	public Account getAccountFromDB(String accountName) {
		return accountDAO.getAccount(accountName);
	}

	/**
	 * Save session key.
	 * 
	 * @param accountName
	 *            the account name
	 * @param Key
	 *            the key
	 */
	public void saveSessionKey(String accountName, String Key) {
		accountDAO.saveSessionKey(accountName, Key);
	}

	/**
	 * Gets the account data.
	 * 
	 * @param id
	 *            the id
	 * @return the account data
	 */
	public HashMap<Integer, AccountData> getAccountData(int id) {
		return accountDAO.getAccountData(id);
	}

	/**
	 * Gets the characters data.
	 * 
	 * @param guid
	 *            the guid
	 * @return the characters data
	 */
	public List<CharactersData> getCharactersData(int guid) {
		List<CharactersData> charactersData = accountDAO
				.getCharactersData(guid);
		for (Iterator<CharactersData> chdIterator = charactersData.iterator(); chdIterator
				.hasNext();) {
			CharactersData characterData = chdIterator.next();
			for (int i = 0; i < characterData.getItems().length; i++) {
				ItemPrototype itemPrototype = itemStorages.get(characterData
						.getItems()[i].getDisplayInfoID());
				if (itemPrototype != null) {
					characterData.getItems()[i].setDisplayInfoID(itemPrototype
							.getDisplayInfoID());
					characterData.getItems()[i].setInventoryType(itemPrototype
							.getInventoryType());
				} else {
					characterData.getItems()[i].setDisplayInfoID(0);
					characterData.getItems()[i].setEnchantAuraId(0);
				}
			}
		}
		return charactersData;
	}

	/**
	 * Gets the session key from db.
	 * 
	 * @param username
	 *            the username
	 * @return the session key from db Session Key from DB
	 */
	public String getSessionKeyFromDB(String username) {
		return accountDAO.getSessionKey(username);
	}

	/**
	 * Load tutorials data from db.
	 * 
	 * @param guid
	 *            - Account
	 * @return the int[] all tutorial Data saved in DB
	 */
	public int[] loadTutorialsDataFromDB(int guid) {
		return accountDAO.getTutorialsData(guid);
	}
}
