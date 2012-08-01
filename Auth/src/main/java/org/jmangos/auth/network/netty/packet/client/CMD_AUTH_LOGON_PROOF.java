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
package org.jmangos.auth.network.netty.packet.client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_AUTH_LOGON_PROOF;
import org.jmangos.auth.service.AccountService;
import org.jmangos.auth.utils.AccountUtils;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.commons.utils.BigNumber;


// TODO: Auto-generated Javadoc
/**
 * The Class CMD_AUTH_LOGON_PROOF.
 */
public class CMD_AUTH_LOGON_PROOF extends AbstractWoWClientPacket {
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(CMD_AUTH_LOGON_PROOF.class);
	
	/** The sender. */
	@Inject
	private AbstractPacketSender sender;
	
	/** The account service. */
	@Inject
	AccountService accountService;
	
	/** The response. */
	private WoWAuthResponse response;

	/**
	 * Instantiates a new cM d_ aut h_ logo n_ proof.
	 */
	public CMD_AUTH_LOGON_PROOF() {
		super();
	}
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unused")
	@Override
	protected void readImpl() {
		byte[] a = readB(32);
		byte[] m1 = readB(20);
		byte[] crc = readB(20);
		int numberofKey = readC();
		int securityFlag = readC();
		
		logger.info("a length " + a.length);
		logger.info("a value " + new BigInteger(1,a).toString(16).toUpperCase());
		logger.info("m1 length " + m1.length);
		logger.info("m1 value " + new BigInteger(1,m1).toString(16).toUpperCase());
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
		BigNumber B = getAccount().getcryptoB();
		logger.info("B value " + B.asHexStr());
		sha.update(a);
		sha.update(B.asByteArray(32));
		BigNumber u = new BigNumber();
		u.setBinary(sha.digest());
		logger.info("u value" + u.asHexStr());
		BigNumber A = new BigNumber();
		A.setBinary(a);
		logger.info("A:"+A.asHexStr());	
		BigNumber S = new BigNumber();
		S = A.multiply(( getAccount().getV_crypto().modPow(u, AccountUtils.N))).modPow(
				getAccount().getB() , AccountUtils.N);

		byte[] t = new byte[32];
		byte[] t1 = new byte[16];
		byte[] t2 = new byte[20];
		byte[] vK = new byte[40];

		t = S.asByteArray(32);
		for (int i = 0; i < 16; ++i) {
			t1[i] = t[i * 2];
		}
		sha.update(t1);
		t2 = sha.digest();
		for (int i = 0; i < 20; ++i) {
			vK[i * 2] = t2[i];
		}
		for (int i = 0; i < 16; ++i) {
			t1[i] = t[i * 2 + 1];
		}
		sha.update(t1);
		t2 = sha.digest();
		for (int i = 0; i < 20; ++i) {
			vK[i * 2 + 1] = t2[i];
		}
		//BigNumber K = new BigNumber();
		//K.setBinary(vK);

		byte[] hash = new byte[20];
		logger.info("N:"+AccountUtils.N.asHexStr());
		sha.update(AccountUtils.N.asByteArray(32));
		hash = sha.digest();
		logger.info("hash:"+new BigInteger(1,hash).toString(16).toUpperCase());
		byte[] gH = new byte[20];
		sha.update(AccountUtils.g.asByteArray(1));
		gH = sha.digest();
		for (int i = 0; i < 20; ++i) {
			hash[i] ^= gH[i];
		}

		byte[] t4 = new byte[20];
		sha.update(getAccount().getName().getBytes()); 
		t4 = sha.digest();

		sha.update(hash);
		sha.update(t4);
		sha.update(getAccount().getS_crypto().asByteArray(32));
		sha.update(A.asByteArray(32));
		sha.update(B.asByteArray(32));
		sha.update(vK);

		byte[] sh = sha.digest();
		
		
		if(Arrays.equals(sh, m1)){
			sha.update(A.asByteArray(32));
			sha.update(sh);
			sha.update(vK);

			getAccount().setM2(sha.digest());
			ArrayUtils.reverse(vK);
			accountService.updateSessionKey( getAccount().getName(), new BigInteger(1,vK).toString(16).toUpperCase());
			response = WoWAuthResponse.WOW_SUCCESS;
		} else {
			response = WoWAuthResponse.WOW_FAIL_INCORRECT_PASSWORD;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void runImpl() {
		sender.send(this.getClient() ,new TCMD_AUTH_LOGON_PROOF(response));
	}
}
