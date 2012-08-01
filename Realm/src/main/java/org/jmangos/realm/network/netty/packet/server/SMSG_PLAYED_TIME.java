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
 * The Class SMSG_PLAYED_TIME.
 */
public class SMSG_PLAYED_TIME extends AbstractWoWServerPacket {

	/** The unk. */
	private byte unk; 
	
	/**
	 * Instantiates a new sMS g_ playe d_ time.
	 */
	public SMSG_PLAYED_TIME() {
	}

	/**
	 * Instantiates a new sMS g_ playe d_ time.
	 *
	 * @param unk the unk
	 */
	public SMSG_PLAYED_TIME( byte unk) {
		this.unk  = unk;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeB(new byte[]{
				0x44,0x05,0x00,0x00,0x47,0x02,0x00,0x00
		});
		/*
		writeD(0);
		writeD(0);*/
		writeC(unk);
	}

}
