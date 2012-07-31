/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.network.netty.packet.server;

import java.util.HashMap;

import org.JMANGOS.realm.model.account.AccountData;
import org.JMANGOS.realm.model.account.AccountDataType;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_ACCOUNT_DATA_TIMES.
 */
public class SMSG_ACCOUNT_DATA_TIMES extends AbstractWoWServerPacket {

	/** The Constant GLOBAL_CACHE_MASK. */
	public static final int GLOBAL_CACHE_MASK = 0x15;

	/** The Constant PER_CHARACTER_CACHE_MASK. */
	public static final int PER_CHARACTER_CACHE_MASK = 0xEA;

	/** The curmask. */
	private int curmask;

	/** The account data. */
	private HashMap<Integer, AccountData> accountData;

	/**
	 * Instantiates a new sMS g_ accoun t_ dat a_ times.
	 */
	public SMSG_ACCOUNT_DATA_TIMES() {
		this.curmask = GLOBAL_CACHE_MASK;
	}

	/**
	 * Instantiates a new sMS g_ accoun t_ dat a_ times.
	 * 
	 * @param mask
	 *            the mask
	 * @param accountData
	 *            the account data
	 */
	public SMSG_ACCOUNT_DATA_TIMES(int mask,
			HashMap<Integer, AccountData> accountData) {
		this.curmask = mask;
		this.accountData = accountData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	public void writeImpl() {
		writeD(System.currentTimeMillis() / 1000L);
		writeC(1);
		writeD(curmask);
		for (int i = 0; i < AccountDataType.NUM_ACCOUNT_DATA_TYPES.getValue(); ++i) {
			if ((curmask & (1 << i)) > 0) {
				if (accountData.containsKey(i)) {
					writeD(accountData.get(i).getTime());
				}
			}
		}
	}
}
