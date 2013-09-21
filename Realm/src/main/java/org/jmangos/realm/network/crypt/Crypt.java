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
package org.jmangos.realm.network.crypt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.jmangos.commons.network.crypt.SARC4;

/**
 * The Class Crypt.
 */
public class Crypt {

    /** The Server encryption key. */
    byte[] serverEncryptionKey = {
        (byte) 0xCC, (byte) 0x98, (byte) 0xAE, 0x04, (byte) 0xE8, (byte) 0x97, (byte) 0xEA,
        (byte) 0xCA, 0x12, (byte) 0xDD, (byte) 0xC0, (byte) 0x93, 0x42, (byte) 0x91, 0x53, 0x57 };

    /** The Server decryption key. */
    byte[] clientDecryptionKey = {
        (byte) 0xC2, (byte) 0xB3, 0x72, 0x3C, (byte) 0xC6, (byte) 0xAE, (byte) 0xD9, (byte) 0xB5,
        0x34, 0x3C, 0x53, (byte) 0xEE, 0x2F, 0x43, 0x67, (byte) 0xCE };

    /** The is enabled. */
    private boolean isEnabled = false;

    /** The _client decrypt. */
    private final SARC4 clientDecryptSARC4 = new SARC4();

    /** The _server encrypt. */
    private final SARC4 serverEncryptSARC4 = new SARC4();

    /**
     * Instantiates a new crypt.
     */
    public Crypt() {

    }

    /**
     * Decrypt.
     * 
     * @param data
     *        the data
     * @return the byte[]
     */
    public byte[] decrypt(final byte[] data) {

        if (!this.isEnabled) {
            return data;
        }
        return this.clientDecryptSARC4.update(data);
    }

    /**
     * Encrypt.
     * 
     * @param data
     *        the data
     * @return the byte[]
     */
    public byte[] encrypt(final byte[] data) {

        if (!this.isEnabled) {
            return data;
        }
        return this.serverEncryptSARC4.update(data);

    }

    /**
     * Init crypto-system.
     * 
     * @param key
     *        is seed
     */
    public void init(final byte[] key) {

        final byte[] encryptHash = getKey(this.serverEncryptionKey, key);
        this.clientDecryptSARC4.init(encryptHash);

        final byte[] decryptHash = getKey(this.clientDecryptionKey, key);
        this.serverEncryptSARC4.init(decryptHash);

        final byte[] tar = new byte[1024];
        for (int i = 0; i < tar.length; i++) {
            tar[i] = 0;
        }
        this.serverEncryptSARC4.update(tar);
        for (int i = 0; i < tar.length; i++) {
            tar[i] = 0;
        }
        this.clientDecryptSARC4.update(tar);
        this.isEnabled = true;
    }

    /**
     * Gets the encryption key.
     * 
     * @param EncryptionKey
     *        the encryption key
     * @param key
     *        the key
     * @return the key
     */
    private byte[] getKey(final byte[] EncryptionKey, final byte[] key) {

        final SecretKeySpec ds = new SecretKeySpec(EncryptionKey, "HmacSHA1");
        Mac m;
        try {
            m = Mac.getInstance("HmacSHA1");
            m.init(ds);
            return m.doFinal(key);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
