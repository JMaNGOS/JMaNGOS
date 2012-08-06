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


import java.nio.BufferUnderflowException;

import org.apache.log4j.Logger;
import org.jmangos.realm.network.netty.packetAuth.AbstractRealmClientPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_AUTH_LOGON_PROOF.
 */
public class CMD_AUTH_LOGON_PROOF  extends AbstractRealmClientPacket {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(CMD_AUTH_LOGON_PROOF.class);
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		logger.info("WoWAuthResponse "+readC());
	/*	if (readC() == WoWAuthResponse.WOW_SUCCESS.getMessageId()) {
			logger.info( WoWAuthResponse.WOW_SUCCESS);
		}*/
		
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		// TODO Auto-generated method stub
		
	}
}

