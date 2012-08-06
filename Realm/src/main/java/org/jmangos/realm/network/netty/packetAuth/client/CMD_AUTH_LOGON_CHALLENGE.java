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
package org.jmangos.realm.network.netty.packetAuth.client;

import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.packetAuth.AbstractRealmClientPacket;
import org.jmangos.realm.network.netty.packetAuth.server.CMD_AUTH_LOGON_PROOF;

/**
 * The Class CMD_AUTH_LOGON_CHALLENGE.
 */
public class CMD_AUTH_LOGON_CHALLENGE extends AbstractRealmClientPacket {
	
	/** The logger. */
	private static Logger logger = Logger
			.getLogger(CMD_AUTH_LOGON_CHALLENGE.class);
	
	/** The sender. */
	@Inject
	@Named("RealmToAuth")
	private AbstractPacketSender sender;
	
	/** The m1. */
	private byte[] m1;
	
	/** The A. */
	private BigInteger A;

	/* (non-Javadoc)
	 * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		readC();
		if (readC() == WoWAuthResponse.WOW_SUCCESS.getMessageId()) {
			SecureRandom random = new SecureRandom();
			MessageDigest sha = null;
			try {
				sha = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return;
			}
			logger.debug("Good namesever");
			
			BigInteger k = new BigInteger("3");
			byte[] Bb =  readB(32);
			readC();
			readB(1);//read g
			BigInteger g = new BigInteger("7");
			readC();
			byte[] Nb = readB(32);
			byte[] saltb = readB(32);
			/*byte[] unk3 = */readB(16);
			readC();
			ArrayUtils.reverse(Bb);
			BigInteger B = new BigInteger(1, Bb);
			ArrayUtils.reverse(Nb);
			BigInteger N = new BigInteger(1, Nb);
			
			BigInteger a = new BigInteger(1, random.generateSeed(19));
			byte[] passhash = sha.digest("ADMINISTRATOR:ADMINISTRATOR".getBytes());
			sha.update(saltb);
			sha.update(passhash);
			
			byte[] xhash = sha.digest();
			ArrayUtils.reverse(xhash);
			BigInteger x = new BigInteger(1, xhash);
			logger.debug("x:"+x.toString(16).toUpperCase());			
			BigInteger v = g.modPow(x, N);
			logger.debug("v:"+v.toString(16).toUpperCase());			
			A =  g.modPow(a, N);
			logger.debug("A:"+A.toString(16).toUpperCase());
			logger.debug("A length:"+A.toByteArray().length);
			logger.debug("B:"+B.toString(16).toUpperCase());
			logger.debug("B length:"+B.toByteArray().length);
			byte[] ahash = A.toByteArray();
			ArrayUtils.reverse(ahash);
			sha.update(ahash);
			byte[] bhash = B.toByteArray();
			ArrayUtils.reverse(bhash);
			sha.update(bhash);
			byte[] hashu = sha.digest();
			ArrayUtils.reverse(hashu);
			BigInteger u = new BigInteger(1, hashu);
			logger.debug("u:"+u.toString(16).toUpperCase());	
			BigInteger S = (B.subtract(k.multiply(g.modPow(x, N)))).modPow(a
					.add(u.multiply(x)), N);
			byte[] full_S = S.toByteArray();
			logger.debug("lenght"+full_S.length);
			byte[] s1_hash = new byte[16];
			byte[] s2_hash = new byte[16];
			for (int i = 0; i < 16; i++) {
				s1_hash[i] = full_S[i * 2];
				s2_hash[i] = full_S[i * 2 + 1];
			}
			byte[] t1 = sha.digest(s1_hash);
			byte[] t2 = sha.digest(s2_hash);
			byte[] vK = new byte[40];
			for (int i = 0; i < 20; i++) {
				vK[i * 2] = t1[i];
				vK[i * 2 + 1] = t2[i];
			}
			
			byte[] hash = new byte[20];
			logger.debug("N:"+N.toString(16).toUpperCase());
			byte[] nhash = N.toByteArray();
		//	ArrayUtils.reverse(nhash);
			//sha.update(nhash);
			hash = sha.digest(nhash);
			logger.debug("hash:"+new BigInteger(1,hash).toString(16).toUpperCase());
			
			byte[] gH = new byte[20];
			sha.update(g.toByteArray());
			gH = sha.digest();
			for (int i = 0; i < 20; ++i) {
				hash[i] ^= gH[i];
			}

			byte[] t4 = new byte[20];
			t4 = sha.digest("ADMINISTRATOR".getBytes());
			
			sha.update(hash);
			sha.update(t4);
			sha.update(saltb);
			sha.update(ahash);
			sha.update(bhash);
			sha.update(vK);
			m1 = sha.digest();
			
			sha.update(ahash);
			sha.update(m1);
			sha.update(vK);
			logger.debug("m1 length" + m1.length);
			logger.debug("m1 value" + new BigInteger(1,m1).toString(16).toUpperCase());
			@SuppressWarnings("unused")
			byte[] m2 = sha.digest(); 
		} else {
			getChannel().getPipeline().remove("handler");
			getChannel().getPipeline().remove("eventlog");
			getChannel().getPipeline().remove("executor");
			getChannel().close();
			getChannel().getFactory().releaseExternalResources();
			logger.fatal("Wrong namesever", new RuntimeException());
		}
	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient(), new CMD_AUTH_LOGON_PROOF(A.toByteArray(),m1));

	}

}
