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

import org.JMANGOS.common.utils.BigNumber;
import org.JMANGOS.login.model.Account;
import org.JMANGOS.login.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class <tt>TCMD_RECONNECT_CHALLENGE</tt>.
 */
public class TCMD_RECONNECT_CHALLENGE extends AbstractWoWServerPacket {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl() {
		writeC(0x00);
		BigNumber s = new BigNumber();
		s.setRand(16);
		((Account) (getChannel().getChanneledObject())).set_reconnectProof(s);

		writeB(s.asByteArray(16));
		writeQ(0L);
		writeQ(0L);
	}
}
