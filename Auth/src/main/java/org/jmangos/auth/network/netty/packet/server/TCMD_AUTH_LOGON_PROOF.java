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
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.model.State;



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
