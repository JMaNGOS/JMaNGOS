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

package org.jmangos.commons.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * The Class BigNumber.
 */
public class BigNumber {
    
    /**
     * Instantiates a new big number.
     */
    public BigNumber() {
    
        this.bigInteger = BigInteger.ZERO;
    }
    
    /**
     * Instantiates a new big number.
     * 
     * @param bigInteger
     *            the big integer
     */
    public BigNumber(final BigInteger bigInteger) {
    
        this.bigInteger = bigInteger.abs();
    }
    
    /**
     * Instantiates a new big number.
     * 
     * @param str
     *            the str
     */
    public BigNumber(final String str) {
    
        this.bigInteger = new BigInteger(str, 16);
    }
    
    /**
     * Instantiates a new big number.
     * 
     * @param array
     *            the array
     */
    public BigNumber(byte[] array)
    
    {
    
        // Add the first byte indicates the sign of the BigInteger
        if (array[0] < 0) {
            final byte[] tmp = new byte[array.length + 1];
            System.arraycopy(array, 0, tmp, 1, array.length);
            array = tmp;
        }
        this.bigInteger = new BigInteger(array);
    }
    
    /**
     * Adds the.
     * 
     * @param val
     *            the val
     * @return the big number
     */
    public BigNumber add(final BigNumber val) {
    
        return new BigNumber(this.bigInteger.add(val.getBigInteger()));
    }
    
    /**
     * Multiply.
     * 
     * @param val
     *            the val
     * @return the big number
     */
    public BigNumber multiply(final BigNumber val) {
    
        return new BigNumber(this.bigInteger.multiply(val.getBigInteger()));
    }
    
    /**
     * Sets the hex str.
     * 
     * @param str
     *            the new hex str
     */
    public void setHexStr(final String str) {
    
        this.bigInteger = new BigInteger(str, 16);
    }
    
    /**
     * Sets the rand.
     * 
     * @param numBytes
     *            the new rand
     */
    public void setRand(final int numBytes) {
    
        final SecureRandom random = new SecureRandom();
        final byte[] array = random.generateSeed(numBytes);
        this.bigInteger = new BigInteger(1, array);
    }
    
    /**
     * Sets the binary.
     * 
     * @param array
     *            the new binary
     */
    public void setBinary(byte[] array) {
    
        // Reverse array
        final int length = array.length;
        for (int i = 0; i < (length / 2); i++) {
            final byte j = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = j;
        }
        
        // Add the first byte indicates the sign of the BigInteger
        if (array[0] < 0) {
            final byte[] tmp = new byte[array.length + 1];
            System.arraycopy(array, 0, tmp, 1, array.length);
            array = tmp;
        }
        
        this.bigInteger = new BigInteger(array);
    }
    
    /**
     * Mod.
     * 
     * @param m
     *            the m
     * @return the big number
     */
    public BigNumber mod(final BigNumber m) {
    
        return new BigNumber(this.bigInteger.mod(m.getBigInteger()));
    }
    
    /**
     * Mod pow.
     * 
     * @param exponent
     *            the exponent
     * @param m
     *            the m
     * @return the big number
     */
    public BigNumber modPow(final BigNumber exponent, final BigNumber m) {
    
        return new BigNumber(this.bigInteger.modPow(exponent.getBigInteger(), m.getBigInteger()));
    }
    
    /**
     * As byte array.
     * 
     * @param minSize
     *            the min size
     * @return the byte[]
     */
    public byte[] asByteArray(final int minSize) {
    
        // Remove the first byte that indicates the sign of a BigInteger
        byte[] array = this.bigInteger.toByteArray();
        if (array[0] == 0) {
            final byte[] tmp = new byte[array.length - 1];
            System.arraycopy(array, 1, tmp, 0, tmp.length);
            array = tmp;
        }
        
        // Reverse array
        final int length = array.length;
        for (int i = 0; i < (length / 2); i++) {
            final byte j = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = j;
        }
        
        // If we need more bytes than length of BigNumber set the rest to 0
        if (minSize > length) {
            final byte[] newArray = new byte[minSize];
            System.arraycopy(array, 0, newArray, 0, length);
            
            return newArray;
        }
        
        return array;
    }
    
    /**
     * As hex str.
     * 
     * @return the string
     */
    public String asHexStr() {
    
        return this.bigInteger.toString(16).toUpperCase();
    }
    
    /**
     * Gets the big integer.
     * 
     * @return the big integer
     */
    public BigInteger getBigInteger() {
    
        return this.bigInteger.abs();
    }
    
    /** The big integer. */
    private BigInteger bigInteger;
}
