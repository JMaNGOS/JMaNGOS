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
package org.JMANGOS.realm.network.netty.packetLogin.client;

import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.network.netty.packetLogin.AbstractRealmClientPacket;
import org.JMANGOS.realm.network.netty.packetLogin.server.CMD_AUTH_LOGON_PROOF;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.JMANGOS.common.model.WoWAuthResponse;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_AUTH_LOGON_CHALLENGE.
 */
public class CMD_AUTH_LOGON_CHALLENGE extends AbstractRealmClientPacket {
	
	/** The logger. */
	private static Logger logger = Logger
			.getLogger(CMD_AUTH_LOGON_CHALLENGE.class);
	
	/** The sender. */
	@Inject
	@Named("r2l")
	private AbstractPacketSender sender;
	
	/** The m1. */
	private byte[] m1;
	
	/** The A. */
	private BigInteger A;

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
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
			logger.info("Good namesever");
			
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
			logger.info("x:"+x.toString(16).toUpperCase());			
			BigInteger v = g.modPow(x, N);
			logger.info("v:"+v.toString(16).toUpperCase());			
			A =  g.modPow(a, N);
			logger.info("A:"+A.toString(16).toUpperCase());
			logger.info("A length:"+A.toByteArray().length);
			logger.info("B:"+B.toString(16).toUpperCase());
			logger.info("B length:"+B.toByteArray().length);
			byte[] ahash = A.toByteArray();
			ArrayUtils.reverse(ahash);
			sha.update(ahash);
			byte[] bhash = B.toByteArray();
			ArrayUtils.reverse(bhash);
			sha.update(bhash);
			byte[] hashu = sha.digest();
			ArrayUtils.reverse(hashu);
			BigInteger u = new BigInteger(1, hashu);
			logger.info("u:"+u.toString(16).toUpperCase());	
			BigInteger S = (B.subtract(k.multiply(g.modPow(x, N)))).modPow(a
					.add(u.multiply(x)), N);
			byte[] full_S = S.toByteArray();
			logger.info("lenght"+full_S.length);
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
			logger.info("N:"+N.toString(16).toUpperCase());
			byte[] nhash = N.toByteArray();
		//	ArrayUtils.reverse(nhash);
			//sha.update(nhash);
			hash = sha.digest(nhash);
			logger.info("hash:"+new BigInteger(1,hash).toString(16).toUpperCase());
			
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
			logger.info("m1 length" + m1.length);
			logger.info("m1 value" + new BigInteger(1,m1).toString(16).toUpperCase());
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
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient(), new CMD_AUTH_LOGON_PROOF(A.toByteArray(),m1));

	}

}
