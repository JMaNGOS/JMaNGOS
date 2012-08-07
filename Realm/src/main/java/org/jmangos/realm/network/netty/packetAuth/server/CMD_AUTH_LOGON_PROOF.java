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
package org.jmangos.realm.network.netty.packetAuth.server;


import org.apache.commons.lang.ArrayUtils;
import org.jmangos.realm.network.netty.packetAuth.AbstractRealmServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_AUTH_LOGON_PROOF.
 */
public class CMD_AUTH_LOGON_PROOF  extends AbstractRealmServerPacket {
	
	/** The m1. */
	private byte[] m1;
	
	/** The a. */
	private byte[] a; 
	
	/**
	 * Instantiates a new cM d_ aut h_ logo n_ proof.
	 */
	public CMD_AUTH_LOGON_PROOF() {
	}
	
	/**
	 * Instantiates a new cM d_ aut h_ logo n_ proof.
	 *
	 * @param a the a
	 * @param m1 the m1
	 */
	public CMD_AUTH_LOGON_PROOF(byte[] a, byte[] m1) {
		this.a = a;
		this.m1 = m1;
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		byte[] crc = new byte[20];
		writeB(a);
		writeB(m1); 
		writeB(crc);
		writeH(0);
	}
}

