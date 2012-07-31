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

import java.security.SecureRandom;

import org.JMANGOS.realm.network.netty.handler.R2CChannelHandler;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_AUTH_CHALLENGE.
 */
public class SMSG_AUTH_CHALLENGE extends AbstractWoWServerPacket {
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		R2CChannelHandler channelHandler = (R2CChannelHandler) this
				.getChannel().getChannel().getPipeline().getLast();
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(4);
		channelHandler.setSeed(seed);
		writeD(1);
		writeB(seed);
		writeB(random.generateSeed(16));
		writeB(random.generateSeed(16));
	}
}
