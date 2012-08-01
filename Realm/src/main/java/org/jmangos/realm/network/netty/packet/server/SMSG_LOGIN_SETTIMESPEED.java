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
package org.jmangos.realm.network.netty.packet.server;

import org.jmangos.realm.network.netty.packet.AbstractWoWServerPacket;
import org.jmangos.realm.utils.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_LOGIN_SETTIMESPEED.
 */
public class SMSG_LOGIN_SETTIMESPEED extends AbstractWoWServerPacket {

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeD(Utils.TimeToBitFields(System.currentTimeMillis()));
		writeF(0.01666667F);
		writeD(0);
	}

}
