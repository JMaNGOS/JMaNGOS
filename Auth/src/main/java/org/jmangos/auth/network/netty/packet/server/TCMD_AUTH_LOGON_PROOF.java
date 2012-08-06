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
package org.jmangos.auth.network.netty.packet.server;

import org.jmangos.auth.model.Account;
import org.jmangos.auth.network.netty.packet.AbstractWoWServerPacket;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.model.State;

/**
 * The Class TCMD_AUTH_LOGON_PROOF.
 */
public class TCMD_AUTH_LOGON_PROOF extends AbstractWoWServerPacket {

	/** The response. */
	private WoWAuthResponse response;

	/**
	 * Instantiates a new TCMD_AUTH_LOGON_PROOF.
	 */
	public TCMD_AUTH_LOGON_PROOF() {
	}

	/**
	 * Constructs new instance of <tt>T_CMD_AUTH_LOGON_PROOF</tt> packet.
	 * 
	 * @param response
	 *            the WoWAuthResponse
	 */
	public TCMD_AUTH_LOGON_PROOF(WoWAuthResponse response) {
		this.response = response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl() {
		writeC(response.getMessageId());
		if (response == WoWAuthResponse.WOW_SUCCESS) {
			getChannel().setChannelState(State.AUTHED);
			writeB(((Account) (getChannel().getChanneledObject())).getM2());
			writeC(0);
			writeC(-128);
			writeC(0);
			writeC(0);
			// surveyId
			writeC(0);
			writeC(0);
			writeC(0);
			writeC(0);
			// unkFlags
			writeC(0);
			writeC(0);
			getChannel().setChannelState(State.AUTHED);
		}
	}
}
