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
package org.JMANGOS.realm.network.crypt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// TODO: Auto-generated Javadoc
/**
 * The Class Crypt.
 */
public class Crypt {
	
	/** The Server encryption key. */
	byte[] ServerEncryptionKey = { (byte) 0xCC,  (byte)0x98,  (byte)0xAE, 0x04,
			(byte)0xE8,  (byte)0x97, (byte)0xEA,  (byte)0xCA, 0x12,
			(byte)0xDD,  (byte)0xC0,  (byte)0x93, 0x42,  (byte)0x91, 0x53,
			0x57 };
	
	/** The Server decryption key. */
	byte[] ServerDecryptionKey = { (byte) 0xC2, (byte) 0xB3, 0x72, 0x3C, (byte) 0xC6, (byte) 0xAE, (byte) 0xD9,
			(byte) 0xB5, 0x34, 0x3C, 0x53, (byte) 0xEE, 0x2F, 0x43, 0x67, (byte) 0xCE };

	/** The is enabled. */
	private boolean isEnabled = false;

	/** The _client decrypt. */
	private SARC4 _clientDecrypt = new SARC4(); 
	
	/** The _server encrypt. */
	private SARC4 _serverEncrypt = new SARC4(); 

	/**
	 * Instantiates a new crypt.
	 */
	public Crypt() { 
	}

	/**
	 * Decrypt.
	 *
	 * @param data the data
	 * @return the byte[]
	 */
	public byte[] decrypt(byte[] data) {
		if (!isEnabled)
			return data;
		return _clientDecrypt.Update(data);
	}

	/**
	 * Encrypt.
	 *
	 * @param data the data
	 * @return the byte[]
	 */
	public byte[] encrypt(byte[] data) {
		if (!isEnabled)
			return data; 
		return _serverEncrypt.Update(data);

	}
	
	/**
	 * Inits the.
	 *
	 * @param key the key
	 */
	public void init(byte[] key){
		byte[] encryptHash = getKey(ServerEncryptionKey,key);
		_clientDecrypt.init(encryptHash);
		byte[] decryptHash = getKey(ServerDecryptionKey,key);
		_serverEncrypt.init(decryptHash);
		byte[] tar = new byte[1024];
		for(int i = 0; i < tar.length; i++)
		 {
			tar[i] = 0;
		 }
		_serverEncrypt.Update(tar);
		for(int i = 0; i < tar.length; i++)
		 {
			tar[i] = 0;
		 }
		 _clientDecrypt.Update(tar);
		this.isEnabled = true;
	}
	
	/**
	 * Gets the key.
	 *
	 * @param EncryptionKey the encryption key
	 * @param key the key
	 * @return the key
	 */
	private byte[] getKey(byte[] EncryptionKey,byte[] key) {
		SecretKeySpec ds = new SecretKeySpec(EncryptionKey, "HmacSHA1");
		Mac m;
		try {
			m = Mac.getInstance("HmacSHA1");
			m.init(ds);
			return  m.doFinal(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

}
