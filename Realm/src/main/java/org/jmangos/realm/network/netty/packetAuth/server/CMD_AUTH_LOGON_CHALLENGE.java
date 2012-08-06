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

import org.jmangos.realm.network.netty.packetAuth.AbstractRealmServerPacket;

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

