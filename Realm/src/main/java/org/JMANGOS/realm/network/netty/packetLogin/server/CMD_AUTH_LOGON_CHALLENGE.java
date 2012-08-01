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

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_AUTH_LOGON_CHALLENGE.
 */
public class CMD_AUTH_LOGON_CHALLENGE  extends AbstractRealmServerPacket {
	
	/** The name. */
	private static String name = "ADMINISTRATOR"; 
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		byte[] empt = {0,0,0,0};
		writeC(0);
		writeH(0); 
		writeB(empt);
		writeC(0);
		writeC(0);
		writeC(0);
		writeH(12340); 
		writeB(empt);
		writeB(empt);
		writeB(empt);
		writeD(0);
		writeD(0);
		writeC(name.length());
		writeB(name.getBytes());
	}
}

