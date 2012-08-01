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

import org.apache.log4j.Logger;
import org.jmangos.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_ADDON_INFO.
 */
public class SMSG_ADDON_INFO  extends AbstractWoWServerPacket {
	
	/** The logger. */
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(SMSG_ADDON_INFO.class);

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		byte[] addinfo = {2,1,0,0,0,0,0,0};
		for (int i = 0; i < 23; i++) {
			writeB(addinfo);
		}
		 writeD(0);
	}
}

