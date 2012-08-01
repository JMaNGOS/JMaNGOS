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
package org.JMANGOS.realm.network.netty.packet.server;

import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_REALM_SPLIT.
 */
public class SMSG_REALM_SPLIT extends AbstractWoWServerPacket {

	/** The unk. */
	private int unk; 
	
	/**
	 * Instantiates a new sMS g_ real m_ split.
	 */
	public SMSG_REALM_SPLIT() {
	}

	/**
	 * Instantiates a new sMS g_ real m_ split.
	 *
	 * @param unk the unk
	 */
	public SMSG_REALM_SPLIT(int unk) {
		this.unk  = unk;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeD(unk);
		writeD(0);
		writeS("01/01/01");
	}

}
