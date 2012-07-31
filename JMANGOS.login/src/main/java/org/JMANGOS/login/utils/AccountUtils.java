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
package org.JMANGOS.login.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.utils.BigNumber;
import org.JMANGOS.login.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountUtils.
 */
public class AccountUtils {
	
	/** The Constant N. */
	public static final BigNumber N = new BigNumber("894B645E89E1535BBDAD5B8B290650530801B18EBFBF5E8FAB3C82872A3E9BB7");
	
	/** The Constant g. */
	public static final BigNumber g = new BigNumber("7");
	
	/** The Constant k. */
	public static final BigNumber k = new BigNumber("3");

	/**
	 * Sets the vs fields.
	 *
	 * @param Ir the ir
	 * @return the hash map
	 */
	public static HashMap<String, BigNumber> setVSFields(String Ir)
	{
		BigNumber I = new BigNumber(Ir);
		HashMap<String, BigNumber> res = new HashMap<String, BigNumber>();
		byte[] hash = I.asByteArray(20);
		
		int length = hash.length;
		for (int i = 0; i < length / 2; i++)
		{
			byte j = hash[i];
			hash[i] = hash[length - 1 - i];
			hash[length - 1 - i] = j;
		}
		System.out.println("passhash:"+new BigInteger(1, hash).toString(16).toUpperCase());
		BigNumber s = new BigNumber();
		s.setRand(32);
		System.out.println("s: " + s.asHexStr());
		
		MessageDigest sha = null;
		try
		{
			sha = MessageDigest.getInstance("SHA-1");
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
		sha.update(s.asByteArray(32));
		sha.update(hash);
		BigNumber x = new BigNumber();
		x.setBinary(sha.digest());
		System.out.println("x: " + x.asHexStr());
		BigNumber verifier = g.modPow(x, N);
		System.out.println("v: " + verifier.asHexStr());
		res.put("v", verifier);
		res.put("s", s);
		return res;
	}
	 
	/**
	 * Gets the b.
	 *
	 * @param v the v
	 * @param con the con
	 * @return the b
	 */
	public static BigNumber getB(BigNumber v, NettyNetworkChannel con){
		
		BigNumber b = new BigNumber(); 
		b.setRand(19);
		((Account)con.getChanneledObject()).setB(b);
		BigNumber gmod = g.modPow(b, N);
		return ((v.multiply(k)).add(gmod)).mod(N);
		
	}
}
