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
package org.jmangos.auth.network.netty.packet.server;

import org.jmangos.auth.model.Account;
import org.jmangos.auth.network.netty.packet.AbstractWoWServerPacket;
import org.jmangos.auth.utils.AccountUtils;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.utils.BigNumber;

/**
 * The Class <tt>TCMD_AUTH_LOGON_CHALLENGE</tt>.
 * 
 */
public class TCMD_AUTH_LOGON_CHALLENGE extends AbstractWoWServerPacket {

	/** The response. */
	private WoWAuthResponse response;

	/**
	 * Constructs new instance of <tt>TCMD_AUTH_LOGON_CHALLENGE</tt> packet.
	 * 
	 * @param response
	 *            auth response
	 */
	public TCMD_AUTH_LOGON_CHALLENGE(WoWAuthResponse response) {
		this.response = response;
	}

	/**
	 * 
	 */
	public TCMD_AUTH_LOGON_CHALLENGE() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl() {
		writeC(0x00);
		writeC(response.getMessageId());
		if (response == WoWAuthResponse.WOW_SUCCESS) {
			BigNumber unk3 = new BigNumber();
			unk3.setRand(16);
			writeB(((Account) (getChannel().getChanneledObject())).getcryptoB()
					.asByteArray(32));
			writeC(1);
			writeB(AccountUtils.g.asByteArray(1));
			writeC(32);
			writeB(AccountUtils.N.asByteArray(32));
			writeB(((Account) (getChannel().getChanneledObject()))
					.getS_crypto().asByteArray(32));
			writeB(unk3.asByteArray(16));
			writeC(0);
		}
	}
}
