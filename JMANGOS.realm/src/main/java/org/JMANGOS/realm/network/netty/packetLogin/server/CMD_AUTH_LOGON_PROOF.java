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
package org.JMANGOS.realm.network.netty.packetLogin.server;


import org.JMANGOS.realm.network.netty.packetLogin.AbstractRealmServerPacket;
import org.apache.commons.lang.ArrayUtils;

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
		ArrayUtils.reverse(a);
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

