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
package org.jmangos.commons.network.crypt;

/**
 * The Class SARC4.
 */
public class SARC4 {
    
    /** The state. */
    private final byte state[] = new byte[256];
    
    /** The x. */
    private int        x;
    
    /** The y. */
    private int        y;
    
    /**
     * Init by seed.
     * 
     * @param key
     *            - seed
     * @return true, if successful
     */
    public boolean init(final byte[] key) {
    
        for (int i = 0; i < 256; i++) {
            this.state[i] = (byte) i;
        }
        
        this.x = 0;
        this.y = 0;
        
        int index1 = 0;
        int index2 = 0;
        
        byte tmp;
        
        if ((key == null) || (key.length == 0)) {
            throw new NullPointerException();
        }
        
        for (int i = 0; i < 256; i++) {
            
            index2 = ((key[index1] & 0xff) + (this.state[i] & 0xff) + index2) & 0xff;
            
            tmp = this.state[i];
            this.state[i] = this.state[index2];
            this.state[index2] = tmp;
            
            index1 = (index1 + 1) % key.length;
        }
        return true;
        
    }
    
    /**
     * Update.
     * 
     * @param buf
     *            the buf
     * @return the byte[]
     */
    public byte[] update(final byte[] buf) {
    
        int xorIndex;
        byte tmp;
        
        if (buf == null) {
            return null;
        }
        
        final byte[] result = new byte[buf.length];
        
        for (int i = 0; i < buf.length; i++) {
            
            this.x = (this.x + 1) & 0xff;
            this.y = ((this.state[this.x] & 0xff) + this.y) & 0xff;
            
            tmp = this.state[this.x];
            this.state[this.x] = this.state[this.y];
            this.state[this.y] = tmp;
            
            xorIndex = ((this.state[this.x] & 0xff) + (this.state[this.y] & 0xff)) & 0xff;
            result[i] = (byte) (buf[i] ^ this.state[xorIndex]);
        }
        
        return result;
    }
}
