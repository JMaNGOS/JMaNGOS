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
 * The Class SMSG_MOTD.
 */
public class SMSG_MOTD extends AbstractWoWServerPacket {

	/** The motd. */
	private String[] motd; 
	
	/**
	 * Instantiates a new sMS g_ motd.
	 */
	public SMSG_MOTD() {
	}

	/**
	 * Instantiates a new sMS g_ motd.
	 *
	 * @param motd the motd
	 */
	public SMSG_MOTD(String[] motd) {
		this.motd  = motd;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeD(motd.length);
		for (int i = 0; i < motd.length; i++) {
			writeS(motd[i]);	
		}
		
	}

}
