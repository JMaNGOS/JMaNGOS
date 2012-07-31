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
package org.JMANGOS.login.network.netty.packet.server;

import org.JMANGOS.common.model.WoWAuthResponse;
import org.JMANGOS.common.network.model.State;
import org.JMANGOS.login.model.Account;
import org.JMANGOS.login.network.netty.packet.AbstractWoWServerPacket;



// TODO: Auto-generated Javadoc
/**
 * The Class TCMD_AUTH_LOGON_PROOF.
 */
public class TCMD_AUTH_LOGON_PROOF extends AbstractWoWServerPacket {

	/** The response. */
	private WoWAuthResponse response;
	
	/**
	 * Instantiates a new tCM d_ aut h_ logo n_ proof.
	 */
	public TCMD_AUTH_LOGON_PROOF() {
	}
	
	/**
	 * Constructs new instance of <tt>T_CMD_AUTH_LOGON_PROOF</tt> packet.
	 *
	 * @param response the response
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
