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
import org.JMANGOS.realm.utils.Utils;

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
