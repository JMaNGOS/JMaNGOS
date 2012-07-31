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
package org.JMANGOS.login.network.netty.packet.server;

import org.JMANGOS.common.network.model.State;
import org.JMANGOS.login.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class <tt>TCMD_RECONNECT_PROOF</tt>.
 * 
 */
public class TCMD_RECONNECT_PROOF extends AbstractWoWServerPacket {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl() {
		writeC(0);
		writeH(0);
		getChannel().setChannelState(State.AUTHED);
	}
}
