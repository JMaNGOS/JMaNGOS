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
package org.jmangos.auth.dao;

import org.jmangos.auth.model.Account;
import org.jmangos.commons.database.dao.DAO;

/**
 * DAO that manages accounts.
 * 
 * @author MinimaJack
 * 
 */
public abstract class AccountDAO implements DAO {

	/**
	 * Returns account by name or null.
	 * 
	 * @param name
	 *            account name
	 * @return account object or null
	 */
	public abstract Account getAccount(String name);

	/**
	 * Retuns account id or -1 in case of error.
	 * 
	 * @param name
	 *            name of account
	 * @return id or -1 in case of error
	 */
	public abstract int getAccountId(String name);

	/**
	 * Reruns account count If error occured - returns -1.
	 * 
	 * @return account count
	 */
	public abstract int getAccountCount();

	/**
	 * Update security key.
	 * 
	 * @param account
	 *            the account
	 * @return true, if successful
	 */
	public abstract boolean updateSecurityKey(Account account);

	/**
	 * Updates lastServer field of account.
	 * 
	 * @param accountId
	 *            account id
	 * @param lastServer
	 *            last accessed server
	 * @return was updated successful or not
	 */
	public abstract boolean updateLastServer(int accountId, byte lastServer);

	/**
	 * Updates last ip that was used to access an account.
	 * 
	 * @param accountId
	 *            account id
	 * @param ip
	 *            ip address
	 * @return was update successful or not
	 */
	public abstract boolean updateLastIp(int accountId, String ip);

	/**
	 * Get last ip that was used to access an account.
	 * 
	 * @param accountId
	 *            account id
	 * @return ip address
	 */
	public abstract String getLastIp(int accountId);

	/**
	 * Returns uniquire class name for all implementations.
	 * 
	 * @return uniquire class name for all implementations
	 */
	@Override
	public final String getClassName() {
		return AccountDAO.class.getName();
	}

	/**
	 * Update session key.
	 * 
	 * @param username
	 *            the username
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public abstract boolean updateSessionKey(String username, String key);

	/**
	 * Gets the session key.
	 * 
	 * @param username
	 *            the username
	 * @return the session key
	 */
	public abstract String getSessionKey(String username);
}
