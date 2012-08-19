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
package org.jmangos.commons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jmangos.commons.network.model.ChanneledObject;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.utils.BigNumber;

/**
 * The Class Account.
 */
@Entity
@Table(name="account")
public class Account extends NamedObject implements ChanneledObject {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int            id;
    
    /** The user name. */
    @Column(unique = true)
    private String         username;
    
    /** Password hash. */
    @Column(name = "sha_pass_hash")
    private String         passwordHash;
    
    /** Access level of account 0 = regular user, > 0 = GM. */
    @Column(name = "gmlevel")
    private byte           accessLevel;
    
    /** Account activated. */
    @Column(name = "locked")
    private boolean        locked;
    
    /** last server visited by user -1 if none. */
    @Column(name = "last_server")
    private Byte           lastServer      = -1;
    
    /** Last ip of user -1 if none. */
    @Column(name = "last_ip")
    private String         lastIp;
    
    /** The s. */
    @Column(name = "s", nullable = false)
    private String         s               = "";
    
    /** The v. */
    @Column(name = "v", nullable = false)
    private String         v               = "";
    
    /** The M2. */
    @Transient
    private byte[]         M2;
    
    /** The channel. */
    @Transient
    private NetworkChannel channel;
    
    /** The b. */
    @Transient
    private BigNumber      b;
    
    /** The crypto b. */
    @Transient
    private BigNumber      cryptoB;
    
    /** The s_crypto. */
    @Transient
    private BigNumber      s_crypto;
    
    /** The v_crypto. */
    @Transient
    private BigNumber      v_crypto;
    
    /** The _reconnect proof. */
    @Transient
    private BigNumber      _reconnectProof = new BigNumber();
    
    /** The msession key. */
    @Column(name = "session_key")
    private String         msessionKey;
    
    @Transient
    private byte[]         vK;
    
    public Account() {
    
    }
    
    /**
     * Returns account's ID
     * 
     * @return int account id
     */
    public int getId() {
    
        return this.id;
    }
    
    /**
     * Gets the _reconnect proof.
     * 
     * @return the _reconnect proof
     */
    public final BigNumber get_reconnectProof() {
    
        return this._reconnectProof;
    }
    
    /**
     * Sets the _reconnect proof.
     * 
     * @param _reconnectProof
     *            the new _reconnect proof
     */
    public final void set_reconnectProof(final BigNumber _reconnectProof) {
    
        this._reconnectProof = _reconnectProof;
    }
    
    /**
     * Instantiates a new account.
     * 
     * @param objectId
     *            the object id
     */
    public Account(final int objectId) {
    
        super(objectId);
    }
    
    /**
     * Retunrns true if players name and password has are equals.
     * 
     * @param o
     *            another player to check
     * @return true if names and password hash matches
     */
    @Override
    public boolean equals(final Object o) {
    
        if (this == o) {
            return true;
        }
        
        if (!(o instanceof Account)) {
            return false;
        }
        
        final Account account = (Account) o;
        
        if (this.username != null ? !this.username.equals(account.username) : account.username != null) {
            return false;
        }
        
        return !(this.passwordHash != null ? !this.passwordHash.equals(account.passwordHash) : account.passwordHash != null);
        
    }
    
    /**
     * Returns access level of account.
     * 
     * @return access level of account
     */
    public byte getAccessLevel() {
    
        return this.accessLevel;
    }
    
    /**
     * Gets the crypto b.
     * 
     * @return the crypto b
     */
    public final BigNumber getcryptoB() {
    
        return this.cryptoB;
    }
    
    /**
     * Gets the b.
     * 
     * @return the b
     */
    public final BigNumber getB() {
    
        return this.b;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.ChanneledObject#getChannel()
     */
    @Override
    public NetworkChannel getChannel() {
    
        return this.channel;
    }
    
    /**
     * Returns last ip that player played from.
     * 
     * @return last ip that player played from
     */
    public String getLastIp() {
    
        return this.lastIp;
    }
    
    /**
     * Returns last server that player visited.
     * 
     * @return last server that player visited
     */
    public Byte getLastServer() {
    
        return this.lastServer;
    }
    
    /**
     * Returns account activated.
     * 
     * @return access level of account
     */
    public boolean getLocked() {
    
        return this.locked;
    }
    
    /**
     * Gets the m2.
     * 
     * @return the m2
     */
    public byte[] getM2() {
    
        return this.M2;
    }
    
    /**
     * Returns account name.
     * 
     * @return account name
     */
    @Override
    public String getName() {
    
        return this.username;
    }
    
    /**
     * Returns password hash.
     * 
     * @return password hash
     */
    public String getPasswordHash() {
    
        return this.passwordHash;
    }
    
    /**
     * Gets the s.
     * 
     * @return the s
     */
    public String getS() {
    
        return this.s;
    }
    
    /**
     * Gets the s_crypto.
     * 
     * @return the s_crypto
     */
    public final BigNumber getS_crypto() {
    
        return this.s_crypto;
    }
    
    /**
     * Gets the v.
     * 
     * @return the v
     */
    public String getV() {
    
        return this.v;
    }
    
    /**
     * Gets the v_crypto.
     * 
     * @return the v_crypto
     */
    public final BigNumber getV_crypto() {
    
        return this.v_crypto;
    }
    
    /**
     * Returns player hashcode.
     * 
     * @return player hashcode
     */
    @Override
    public int hashCode() {
    
        int result = this.username != null ? this.username.hashCode() : 0;
        
        result = (31 * result) + (this.passwordHash != null ? this.passwordHash.hashCode() : 0);
        
        return result;
    }
    
    /**
     * Sets access level of account.
     * 
     * @param accessLevel
     *            access level of account
     */
    public void setAccessLevel(final byte accessLevel) {
    
        this.accessLevel = accessLevel;
    }
    
    /**
     * Sets the b.
     * 
     * @param b
     *            the new b
     */
    public void setB(final BigNumber b) {
    
        this.b = b;
        
    }
    
    /**
     * Sets the b_crypto.
     * 
     * @param b2
     *            the new b_crypto
     */
    public void setB_crypto(final BigNumber b2) {
    
        this.cryptoB = b2;
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.ChanneledObject#setChannel(org.wowemu
     * .common.network.model.NetworkChannel)
     */
    @Override
    public void setChannel(final NetworkChannel channel) {
    
        this.channel = channel;
        
    }
    
    /**
     * Sets last ip that player players from.
     * 
     * @param lastIp
     *            last ip that player played from
     */
    public void setLastIp(final String lastIp) {
    
        this.lastIp = lastIp;
    }
    
    /**
     * Sets last server that player visited.
     * 
     * @param lastServer
     *            last server that player visited
     */
    public void setLastServer(final Byte lastServer) {
    
        this.lastServer = lastServer;
    }
    
    /**
     * Sets access level of account.
     * 
     * @param activated
     *            access level of account
     */
    public void setLocked(final boolean activated) {
    
        this.locked = activated;
    }
    
    /**
     * Sets the m2.
     * 
     * @param bs
     *            the m2 to set
     */
    public void setM2(final byte[] bs) {
    
        this.M2 = bs;
    }
    
    /**
     * Sets account name.
     * 
     * @param name
     *            account name
     */
    @Override
    public void setName(final String name) {
    
        this.username = name;
    }
    
    /**
     * Sets password hash.
     * 
     * @param passwordHash
     *            password hash
     */
    public void setPasswordHash(final String passwordHash) {
    
        this.passwordHash = passwordHash;
    }
    
    /**
     * Sets the s.
     * 
     * @param s2
     *            the new s
     */
    public void sets(final BigNumber s2) {
    
        this.s_crypto = s2;
        
    }
    
    /**
     * Sets the s.
     * 
     * @param s
     *            the new s
     */
    public void setS(final String s) {
    
        this.s = s;
    }
    
    /**
     * Sets the v.
     * 
     * @param v
     *            the new v
     */
    public void setV(final String v) {
    
        this.v = v;
    }
    
    /**
     * Sets the v_crypto.
     * 
     * @param v_crypto
     *            the new v_crypto
     */
    public final void setV_crypto(final BigNumber v_crypto) {
    
        this.v_crypto = v_crypto;
    }
    
    /**
     * Sets the session key.
     * 
     * @param string
     *            the new session key
     */
    public void setSessionKey(final String string) {
    
        setMsessionKey(string);
        
    }
    
    public void setMsessionKey(final String msessionKey) {
    
        this.msessionKey = msessionKey;
    }
    
    public String getMsessionKey() {
    
        return this.msessionKey;
    }
    
    public byte[] getvK() {
    
        return this.vK;
    }
    
    public void setvK(final byte[] vK) {
    
        // need clone
        this.vK = vK.clone();
    }
}
