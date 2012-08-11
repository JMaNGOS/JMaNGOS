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
import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.config.Config;
import org.jmangos.realm.network.netty.handler.RealmToAuthChannelHandler;
import org.jmangos.realm.network.netty.packetAuth.AbstractRealmClientPacket;
import org.jmangos.realm.network.netty.packetAuth.server.CMD_AUTH_LOGON_PROOF;
import org.jmangos.realm.utils.StringUtils;

/**
 * The Class <tt>CMD_AUTH_LOGON_CHALLENGE</tt>.
 */
public class CMD_AUTH_LOGON_CHALLENGE extends AbstractRealmClientPacket {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(CMD_AUTH_LOGON_CHALLENGE.class);
	
	@Inject
	private Config config;

	/** The sender. */
	@Inject
	@Named("RealmToAuth")
	private AbstractPacketSender sender;

	/** The m1. */
	private byte[] m1;

	private byte[] ahash;

	/*
	 * (non-Javadoc)
	 * 
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
			BigInteger k = new BigInteger("3");
			byte[] Bb = readB(32);
			BigInteger g = new BigInteger(readB(readC()));
			byte[] Nb = readB(readC());
			byte[] saltb = readB(32);
			/* byte[] unk3 = */readB(16);
			readC();
			ArrayUtils.reverse(Bb);
			BigInteger B = new BigInteger(1, Bb);
			ArrayUtils.reverse(Bb);
			ArrayUtils.reverse(Nb);
			BigInteger N = new BigInteger(1, Nb);
			ArrayUtils.reverse(Nb);
			BigInteger a = new BigInteger(1, random.generateSeed(19));

			byte[] passhash = sha.digest(config.AUTH_LOGIN.toUpperCase()
					.concat(":").concat(config.AUTH_PASSWORD.toUpperCase())
					.getBytes());
			sha.update(saltb);
			sha.update(passhash);

			byte[] xhash = sha.digest();
			ArrayUtils.reverse(xhash);
			BigInteger x = new BigInteger(1, xhash);
			logger.debug("x:" + x.toString(16).toUpperCase());
			BigInteger v = g.modPow(x, N);
			logger.debug("v:" + v.toString(16).toUpperCase());
			BigInteger A = g.modPow(a, N);
			logger.debug("A:" + A.toString(16).toUpperCase());
			logger.debug("B:" + B.toString(16).toUpperCase());
			ahash = A.toByteArray();
			ArrayUtils.reverse(ahash);
			sha.update(ahash);
			sha.update(Bb);
			byte[] hashu = sha.digest();
			ArrayUtils.reverse(hashu);
			BigInteger u = new BigInteger(1, hashu);
			logger.debug("u:" + u.toString(16).toUpperCase());
			BigInteger S = (B.subtract(k.multiply(g.modPow(x, N)))).modPow(
					a.add(u.multiply(x)), N);

			byte[] full_S = S.toByteArray();
			ArrayUtils.reverse(full_S);
			logger.debug("t:" + StringUtils.toHexString(full_S));
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
			logger.debug("N:" + N.toString(16).toUpperCase());
			hash = sha.digest(Nb);

			logger.debug("hash:"
					+ new BigInteger(1, hash).toString(16).toUpperCase());

			byte[] gH = new byte[20];
			sha.update(g.toByteArray());
			gH = sha.digest();
			for (int i = 0; i < 20; ++i) {
				hash[i] ^= gH[i];
			}

			byte[] t4 = new byte[20];
			t4 = sha.digest(config.AUTH_LOGIN.toUpperCase().getBytes());

			sha.update(hash);
			logger.debug("hash:" + StringUtils.toHexString(hash));
			sha.update(t4);
			logger.debug("t4:" + StringUtils.toHexString(t4));
			sha.update(saltb);
			logger.debug("saltb:" + StringUtils.toHexString(saltb));
			sha.update(ahash);
			logger.debug("ahash:" + StringUtils.toHexString(ahash));
			sha.update(Bb);
			logger.debug("Bb:" + StringUtils.toHexString(Bb));
			sha.update(vK);
			logger.debug("vK:" + StringUtils.toHexString(vK));
			m1 = sha.digest();

			sha.update(ahash);
			sha.update(m1);
			sha.update(vK);
			logger.debug("m1 value" + StringUtils.toHexString(m1));
			@SuppressWarnings("unused")
			byte[] m2 = sha.digest();

			ChannelPipeline pipeline = (ChannelPipeline) getClient()
					.getChannel().getPipeline();
			((RealmToAuthChannelHandler) pipeline.getLast()).setSeed(vK);

		} else {
			getChannel().getPipeline().remove("handler");
			getChannel().getPipeline().remove("eventlog");
			getChannel().getPipeline().remove("executor");
			getChannel().close();
			getChannel().getFactory().releaseExternalResources();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient(), new CMD_AUTH_LOGON_PROOF(ahash, m1));

	}
}
