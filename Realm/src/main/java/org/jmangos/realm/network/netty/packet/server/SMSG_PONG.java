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
package org.jmangos.realm.network.netty.packet.server;

import org.jmangos.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_PONG.
 */
public class SMSG_PONG extends AbstractWoWServerPacket {

	/** The ping. */
	private int ping; 
	
	/**
	 * Instantiates a new sMS g_ pong.
	 */
	public SMSG_PONG() {
	}

	/**
	 * Instantiates a new sMS g_ pong.
	 *
	 * @param ping the ping
	 */
	public SMSG_PONG(int ping) {
		this.ping  = ping;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeD(ping);
	}

}
