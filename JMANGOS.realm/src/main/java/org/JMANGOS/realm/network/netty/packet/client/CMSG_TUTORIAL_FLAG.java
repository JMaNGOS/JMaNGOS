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
package org.JMANGOS.realm.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import org.JMANGOS.realm.network.netty.packet.AbstractWoWClientPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_TUTORIAL_FLAG.
 */
public class CMSG_TUTORIAL_FLAG extends AbstractWoWClientPacket {

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		int Flag = readD();
		int wInt = (Flag / 32);
		if (wInt >= 8) {
			return;
		}
		int rInt = (Flag % 32);

		int tutorials = getAccount().getTutorials(wInt);
		tutorials |= (1 << rInt);
		getAccount().setTutorials(tutorials, wInt);

	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {

	}
}
