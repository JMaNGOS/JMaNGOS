/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.login.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.JMANGOS.common.model.WoWAuthResponse;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.utils.BigNumber;
import org.JMANGOS.login.dao.AccountDAO;
import org.JMANGOS.login.model.Account;
import org.JMANGOS.login.utils.AccountUtils;

// TODO: Auto-generated Javadoc
/**
 * This class is responsible for controlling all account actions.
 */
public class AccountService {
	
	/** The account dao. */
	@Inject
	private  AccountDAO accountDAO;
	
	/**
	 * Load clean.
	 *
	 * @param name the name
	 * @param channelHandler the channel handler
	 */
	public void loadClean(String name, NettyNetworkChannel channelHandler) {
		Account account = loadAccount(name);
		channelHandler.setChanneledObject(account);
	}
	
	/**
	 * Login.
	 *
	 * @param name the name
	 * @param channelHandler the channel handler
	 * @return the wo w auth response
	 */
	public WoWAuthResponse login(String name, NettyNetworkChannel channelHandler) {
		//if (BannedIpController.isBanned(channelHandler.getAddress().getAddress().getHostAddress())) {
		//	return WoWAuthResponse.WOW_FAIL_BANNED;
		//}
		;
		Account account = loadAccount(name);
		HashMap<String, BigNumber> variable = new HashMap<String, BigNumber>();
		BigNumber s = new BigNumber();
		BigNumber v = new BigNumber();

		if (account == null) {
			return WoWAuthResponse.WOW_FAIL_UNKNOWN_ACCOUNT;
		}
		channelHandler.setChanneledObject(account);
		if (account.getV().length() != 32 * 2
				|| account.getS().length() != 32 * 2) {
			variable = AccountUtils.setVSFields(account.getPasswordHash());
			s = variable.get("s");
			v = variable.get("v");
			updateSV(account);
		} else {
			s.setHexStr(account.getS());
			v.setHexStr(account.getV());
		}
		
		BigNumber B = AccountUtils.getB(v, channelHandler);
		account.setB_crypto(B);
		account.sets(s);
		account.setV_crypto(v);
		
		accountDAO.updateLastIp(account.getObjectId(),
				channelHandler.getAddress().getAddress().getHostAddress());
		
		return WoWAuthResponse.WOW_SUCCESS;
	}

	/**
	 * Update sv.
	 *
	 * @param account the account
	 */
	public void updateSV(Account account) {
		accountDAO.updateSecurityKey(account);
	}

	/**
	 * Loads account from DB and returns it, or returns null if account was not
	 * loaded.
	 *
	 * @param name Account name
	 * @return loaded account or null
	 */
	public Account loadAccount(String name) {
		return accountDAO.getAccount(name);
	}

	/**
	 * Update session key.
	 *
	 * @param username the username
	 * @param Key the key
	 */
	public void updateSessionKey(String username, String Key) {
		accountDAO.updateSessionKey(username, Key);
	}

	/**
	 * Gets the session key.
	 *
	 * @param username the username
	 * @return the session key
	 */
	public String getSessionKey(String username) {
		return accountDAO.getSessionKey(username);
	}
}
