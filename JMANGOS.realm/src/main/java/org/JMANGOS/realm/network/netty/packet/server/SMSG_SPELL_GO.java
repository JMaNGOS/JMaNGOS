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
 * The Class SMSG_SPELL_GO.
 */
public class SMSG_SPELL_GO extends AbstractWoWServerPacket {

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeB(new byte[]{
				0x01,0x01,0x01,0x01,0x00,0x44,0x03,0x00,0x00,0x00,0x01,0x00,0x00,0x44,(byte) 0xC8,0x00
				,0x00,0x01,0x01,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x02,0x00,0x00,0x00,0x01
				,0x01
		});
		
	}

}
