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
package org.jmangos.realm.model.account;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jmangos.commons.model.NamedObject;
import org.jmangos.commons.network.model.ChanneledObject;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.utils.BigNumber;
import org.jmangos.realm.model.base.character.CharactersData;

// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 */
public class Account extends NamedObject implements ChanneledObject {

	/** The username. */
	private String username;

	/** Password hash. */
	private String passwordHash;

	/** Access level of account 0 = regular user, > 0 = GM. */
	private byte accessLevel;

	/** Account activated. */
	private byte locked;

	/** last server visited by user -1 if none. */
	private byte lastServer;

	/** The account data. */
	private HashMap<Integer, AccountData> accountData;
	
	/** The m_character data. */
	private List<CharactersData> m_characterData;

	/** The Tutorials. */
	private int[] Tutorials = new int[8]; 

	/**
	 * Gets the characters data.
	 *
	 * @return the characters data
	 */
	public final List<CharactersData> getCharactersData() {
		return m_characterData;
	}

	/**
	 * Sets the characters data.
	 *
	 * @param m_characterData the new characters data
	 */
	public final void setCharactersData(List<CharactersData> m_characterData) {
		this.m_characterData = m_characterData;
	}


	/**
	 * Gets the tutorials.
	 *
	 * @param i the i
	 * @return the tutorials
	 */
	public int getTutorials(int i) {
		return Tutorials[i];
	}
	
	/**
	 * Sets the tutorials.
	 *
	 * @param tutorials the tutorials to set
	 * @param i the i
	 */
	public void setTutorials(int tutorials, int i) {
		Tutorials[i] = tutorials;
	}
	
	/**
	 * Sets the tutorials.
	 *
	 * @param tutorials the tutorials to set
	 */
	public void setTutorials(int[] tutorials) {
		Tutorials = tutorials;
	}	
	
	/**
	 * Gets the character data.
	 *
	 * @param guid the guid
	 * @return the character data
	 */
	public CharactersData getCharacterData(long guid) {
		for (Iterator<CharactersData> iterator = m_characterData.iterator(); iterator.hasNext();) {
			CharactersData character =  iterator.next();
			if (character.getObjectId() == guid){
				return character;
			}
			
		}
		return null;
		
	}

	/**
	 * Gets the account data.
	 *
	 * @return the account data
	 */
	public final HashMap<Integer, AccountData> getAccountData() {
		return accountData;
	}

	/**
	 * Sets the account data.
	 *
	 * @param list the list
	 */
	public final void setAccountData(HashMap<Integer, AccountData> list) {
		this.accountData = list;
	}

	/** Last ip of user -1 if none. */
	private String lastIp;

	/** The s. */
	private String s;
	
	/** The v. */
	private String v;
	
	/** The M2. */
	private byte[] M2;

	/** The channel. */
	private NetworkChannel channel;

	/** The b. */
	private BigNumber b;

	/** The crypto b. */
	private BigNumber cryptoB;

	/** The s_crypto. */
	private BigNumber s_crypto;

	/** The v_crypto. */
	private BigNumber v_crypto;

	/** The _reconnect proof. */
	private BigNumber _reconnectProof = new BigNumber();

	/**
	 * Gets the _reconnect proof.
	 *
	 * @return the _reconnect proof
	 */
	public final BigNumber get_reconnectProof() {
		return _reconnectProof;
	}

	/**
	 * Sets the _reconnect proof.
	 *
	 * @param _reconnectProof the new _reconnect proof
	 */
	public final void set_reconnectProof(BigNumber _reconnectProof) {
		this._reconnectProof = _reconnectProof;
	}

	/**
	 * Instantiates a new account.
	 *
	 * @param objectId the object id
	 */
	public Account(int objectId) {
		super(objectId);
	}

	/**
	 * Returns true if players name and password has are equals.
	 *
	 * @param o another player to check
	 * @return true if names and password hash matches
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Account)) {
			return false;
		}

		Account account = (Account) o;

		if (username != null ? !username.equals(account.username)
				: account.username != null) {
			return false;
		}

		return !(passwordHash != null ? !passwordHash
				.equals(account.passwordHash) : account.passwordHash != null);

	}

	/**
	 * Returns access level of account.
	 *
	 * @return access level of account
	 */
	public byte getAccessLevel() {
		return accessLevel;
	}

	/**
	 * Gets the crypto b.
	 *
	 * @return the crypto b
	 */
	public final BigNumber getcryptoB() {
		return cryptoB;
	}

	/**
	 * Gets the b.
	 *
	 * @return the b
	 */
	public final BigNumber getB() {
		return b;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ChanneledObject#getChannel()
	 */
	@Override
	public NetworkChannel getChannel() {
		return channel;
	}

	/**
	 * Returns last ip that player played from.
	 *
	 * @return last ip that player played from
	 */
	public String getLastIp() {
		return lastIp;
	}

	/**
	 * Returns last server that player visited.
	 *
	 * @return last server that player visited
	 */
	public byte getLastServer() {
		return lastServer;
	}

	/**
	 * Returns account activated.
	 *
	 * @return access level of account
	 */
	public byte getLocked() {
		return locked;
	}

	/**
	 * Gets the m2.
	 *
	 * @return the m2
	 */
	public byte[] getM2() {
		return M2;
	}

	/**
	 * Returns account name.
	 *
	 * @return account name
	 */
	public String getName() {
		return username;
	}

	/**
	 * Returns password hash.
	 *
	 * @return password hash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Gets the s.
	 *
	 * @return the s
	 */
	public String getS() {
		return s;
	}

	/**
	 * Gets the s_crypto.
	 *
	 * @return the s_crypto
	 */
	public final BigNumber getS_crypto() {
		return s_crypto;
	}

	/**
	 * Gets the v.
	 *
	 * @return the v
	 */
	public String getV() {
		return v;
	}

	/**
	 * Gets the v_crypto.
	 *
	 * @return the v_crypto
	 */
	public final BigNumber getV_crypto() {
		return v_crypto;
	}

	/**
	 * Returns player hashcode.
	 * 
	 * @return player hashcode
	 */
	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;

		result = 31 * result
				+ (passwordHash != null ? passwordHash.hashCode() : 0);

		return result;
	}

	/**
	 * Sets access level of account.
	 *
	 * @param accessLevel access level of account
	 */
	public void setAccessLevel(byte accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * Sets the b.
	 *
	 * @param b the new b
	 */
	public void setB(BigNumber b) {
		this.b = b;

	}

	/**
	 * Sets the b_crypto.
	 *
	 * @param b2 the new b_crypto
	 */
	public void setB_crypto(BigNumber b2) {
		this.cryptoB = b2;

	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ChanneledObject#setChannel(org.wowemu.common.network.model.NetworkChannel)
	 */
	@Override
	public void setChannel(NetworkChannel channel) {
		this.channel = channel;

	}

	/**
	 * Sets last ip that player players from.
	 *
	 * @param lastIp last ip that player played from
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	/**
	 * Sets last server that player visited.
	 *
	 * @param lastServer last server that player visited
	 */
	public void setLastServer(byte lastServer) {
		this.lastServer = lastServer;
	}

	/**
	 * Sets access level of account.
	 *
	 * @param activated access level of account
	 */
	public void setLocked(byte activated) {
		this.locked = activated;
	}

	/**
	 * Sets the m2.
	 *
	 * @param bs the m2 to set
	 */
	public void setM2(byte[] bs) {
		M2 = bs;
	}

	/**
	 * Sets account name.
	 *
	 * @param name account name
	 */
	public void setName(String name) {
		this.username = name;
	}

	/**
	 * Sets password hash.
	 *
	 * @param passwordHash password hash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Sets the s.
	 *
	 * @param s2 the new s
	 */
	public void sets(BigNumber s2) {
		this.s_crypto = s2;

	}

	/**
	 * Sets the s.
	 *
	 * @param s the new s
	 */
	public void setS(String s) {
		this.s = s;
	}

	/**
	 * Sets the v.
	 *
	 * @param v the new v
	 */
	public void setV(String v) {
		this.v = v;
	}

	/**
	 * Sets the v_crypto.
	 *
	 * @param v_crypto the new v_crypto
	 */
	public final void setV_crypto(BigNumber v_crypto) {
		this.v_crypto = v_crypto;
	}

	/**
	 * Sets the session key.
	 *
	 * @param string the new session key
	 */
	public void setSessionKey(String string) {

	}
}
