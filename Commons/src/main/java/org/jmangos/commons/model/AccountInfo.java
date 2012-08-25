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

import java.util.ArrayList;

import org.jmangos.commons.network.model.ChanneledObject;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.utils.BigNumber;

/**
 * The Class Account.
 */
public class AccountInfo extends NamedObject implements ChanneledObject {
    
    /** Access level of account 0 = regular user, > 0 = GM. */
    private byte                 accessLevel;
    
    /** The M2. */
    private byte[]               M2;
    
    /** The channel. */
    private NetworkChannel       channel;
    
    /** The b. */
    private BigNumber            b;
    
    /** The crypto b. */
    private BigNumber            cryptoB;
    
    /** The s_crypto. */
    private BigNumber            s_crypto;
    
    /** The v_crypto. */
    private BigNumber            v_crypto;
    
    /** The _reconnect proof. */
    private BigNumber            _reconnectProof = new BigNumber();
    
    private byte[]               vK;
    
    private BigNumber            sessionKey;
    
    private ArrayList<AddonInfo> addonLists;
    
    private byte[]               clientSeed;
    
    public AccountInfo() {
    
        super();
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
    public AccountInfo(final int objectId) {
    
        super(objectId);
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
    
    @Override
    public NetworkChannel getChannel() {
    
        return this.channel;
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
     * Gets the s_crypto.
     * 
     * @return the s_crypto
     */
    public final BigNumber getS_crypto() {
    
        return this.s_crypto;
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
    
    @Override
    public void setChannel(final NetworkChannel channel) {
    
        this.channel = channel;
        
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
     * Sets the s.
     * 
     * @param s2
     *            the new s
     */
    public void sets(final BigNumber s2) {
    
        this.s_crypto = s2;
        
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
    
    public byte[] getvK() {
    
        return this.vK;
    }
    
    public void setvK(final byte[] vK) {
    
        // need clone
        this.vK = vK.clone();
    }
    
    public BigNumber getSessionKey() {
    
        return this.sessionKey;
    }
    
    public void setSessionKey(final BigNumber sessionKey) {
    
        this.sessionKey = sessionKey;
    }
    
    public ArrayList<AddonInfo> getAddonLists() {
    
        return this.addonLists;
    }
    
    public void setAddonLists(final ArrayList<AddonInfo> addonLists) {
    
        this.addonLists = addonLists;
    }
    
    public void setClientSeed(final byte[] clientSeed) {
    
        this.clientSeed = clientSeed;
        
    }
    
    /**
     * @return the clientSeed
     */
    public final byte[] getClientSeed() {
    
        return this.clientSeed;
    }
}
