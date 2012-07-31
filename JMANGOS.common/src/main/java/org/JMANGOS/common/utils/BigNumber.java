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

package org.JMANGOS.common.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

// TODO: Auto-generated Javadoc
/**
 * The Class BigNumber.
 */
public class BigNumber
{
	
	/**
	 * Instantiates a new big number.
	 */
	public BigNumber()
	{
		this.bigInteger = BigInteger.ZERO;
	}
	
	/**
	 * Instantiates a new big number.
	 *
	 * @param bigInteger the big integer
	 */
	public BigNumber(BigInteger bigInteger)
	{
		this.bigInteger = bigInteger.abs();
	}
	
	/**
	 * Instantiates a new big number.
	 *
	 * @param str the str
	 */
	public BigNumber(String str)
	{
		this.bigInteger = new BigInteger(str, 16);
	}
	
	/**
	 * Instantiates a new big number.
	 *
	 * @param array the array
	 */
	public BigNumber(byte[] array)
	
	{
		// Add the first byte indicates the sign of the BigInteger
		if (array[0] < 0)
		{
			byte[] tmp = new byte[array.length + 1];
			System.arraycopy(array, 0, tmp, 1, array.length);
			array = tmp;
		}
		this.bigInteger = new BigInteger(array);
	}
	
	/**
	 * Adds the.
	 *
	 * @param val the val
	 * @return the big number
	 */
	public BigNumber add(BigNumber val)
	{
		return new BigNumber(this.bigInteger.add(val.getBigInteger()));
	}
	
	/**
	 * Multiply.
	 *
	 * @param val the val
	 * @return the big number
	 */
	public BigNumber multiply(BigNumber val)
	{
		return new BigNumber(this.bigInteger.multiply(val.getBigInteger()));
	}
	
	/**
	 * Sets the hex str.
	 *
	 * @param str the new hex str
	 */
	public void setHexStr(String str)
	{
		this.bigInteger = new BigInteger(str, 16);
	}
	
	/**
	 * Sets the rand.
	 *
	 * @param numBytes the new rand
	 */
	public void setRand(int numBytes)
	{
		SecureRandom random = new SecureRandom();
		byte[] array = random.generateSeed(numBytes);
		this.bigInteger = new BigInteger(1,array);
	}
	
	/**
	 * Sets the binary.
	 *
	 * @param array the new binary
	 */
	public void setBinary(byte[] array)
	{
		// Reverse array
		int length = array.length;
		for (int i = 0; i < length / 2; i++)
		{
			byte j = array[i];
			array[i] = array[length - 1 - i];
			array[length - 1 - i] = j;
		}
		
		// Add the first byte indicates the sign of the BigInteger
		if (array[0] < 0)
		{
			byte[] tmp = new byte[array.length + 1];
			System.arraycopy(array, 0, tmp, 1, array.length);
			array = tmp;
		}
		
		this.bigInteger = new BigInteger(array);
	}
	
	/**
	 * Mod.
	 *
	 * @param m the m
	 * @return the big number
	 */
	public BigNumber mod(BigNumber m)
	{
		return new BigNumber(this.bigInteger.mod(m.getBigInteger()));
	}
	
	/**
	 * Mod pow.
	 *
	 * @param exponent the exponent
	 * @param m the m
	 * @return the big number
	 */
	public BigNumber modPow(BigNumber exponent, BigNumber m)
	{
		return new BigNumber(this.bigInteger.modPow(exponent.getBigInteger(), m.getBigInteger()));
	}
	
	/**
	 * As byte array.
	 *
	 * @param minSize the min size
	 * @return the byte[]
	 */
	public byte[] asByteArray(int minSize)
	{
		
		// Remove the first byte that indicates the sign of a BigInteger
		byte[] array = this.bigInteger.toByteArray();
		if (array[0] == 0)
		{
			byte[] tmp = new byte[array.length - 1];
			System.arraycopy(array, 1, tmp, 0, tmp.length);
			array = tmp;
		}
		
		// Reverse array
		int length = array.length;
		for (int i = 0; i < length / 2; i++)
		{
			byte j = array[i];
			array[i] = array[length - 1 - i];
			array[length - 1 - i] = j;
		}
		
		// If we need more bytes than length of BigNumber set the rest to 0
		if (minSize > length)
		{
			byte[] newArray = new byte[minSize];
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
	public String asHexStr()
	{
		return this.bigInteger.toString(16).toUpperCase();
	}
	
	/**
	 * Gets the big integer.
	 *
	 * @return the big integer
	 */
	public BigInteger getBigInteger()
	{
		return this.bigInteger.abs();
	}
	
	/** The big integer. */
	private BigInteger bigInteger;
}
