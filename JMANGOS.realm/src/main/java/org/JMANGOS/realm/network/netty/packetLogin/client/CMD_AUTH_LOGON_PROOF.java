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


import java.nio.BufferUnderflowException;

import org.JMANGOS.realm.network.netty.packetLogin.AbstractRealmClientPacket;
import org.apache.log4j.Logger;

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

