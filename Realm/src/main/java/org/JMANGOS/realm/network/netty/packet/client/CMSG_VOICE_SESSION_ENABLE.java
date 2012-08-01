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
package org.JMANGOS.realm.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import org.JMANGOS.realm.network.netty.packet.AbstractWoWClientPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_VOICE_SESSION_ENABLE.
 */
public class CMSG_VOICE_SESSION_ENABLE extends AbstractWoWClientPacket {

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		// TODO this need ??
		skipAll();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		
	}

}
