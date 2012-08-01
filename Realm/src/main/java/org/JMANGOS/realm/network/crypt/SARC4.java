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

// TODO: Auto-generated Javadoc
/**
 * The Class SARC4.
 */
public class SARC4 {
	
	/** The state. */
	private byte state[] = new byte[256];
    
    /** The x. */
    private int x;
    
    /** The y. */
    private int y;
	
	/**
	 * Inits the.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	public boolean init(byte[] key) {

        for (int i=0; i < 256; i++) {
            state[i] = (byte)i;
        }
        
        x = 0;
        y = 0;
        
        int index1 = 0;
        int index2 = 0;
        
        byte tmp;
        
        if (key == null || key.length == 0) {
            throw new NullPointerException();
        }
        
        for (int i=0; i < 256; i++) {

            index2 = ((key[index1] & 0xff) + (state[i] & 0xff) + index2) & 0xff;

            tmp = state[i];
            state[i] = state[index2];
            state[index2] = tmp;
            
            index1 = (index1 + 1) % key.length;
        }
		return true;
		
	}
	
	/**
	 * Update.
	 *
	 * @param buf the buf
	 * @return the byte[]
	 */
	public byte[] Update(byte[] buf){

	        int xorIndex;
	        byte tmp;
	        
	        if (buf == null) {
	            return null;
	        }
	        
	        byte[] result = new byte[buf.length];
	        
	        for (int i=0; i < buf.length; i++) {

	            x = (x + 1) & 0xff;
	            y = ((state[x] & 0xff) + y) & 0xff;

	            tmp = state[x];
	            state[x] = state[y];
	            state[y] = tmp;
	            
	            xorIndex = ((state[x] &0xff) + (state[y] & 0xff)) & 0xff;
	            result[i] = (byte)(buf[i] ^ state[xorIndex]);
	        }
	        
	        return result;
	    }
	}
