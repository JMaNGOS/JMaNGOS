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
package org.JMANGOS.realm.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.network.netty.packet.AbstractWoWClientPacket;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_NAME_QUERY_RESPONSE;
import org.JMANGOS.realm.service.PlayerService;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_NAME_QUERY.
 */
public class CMSG_NAME_QUERY extends AbstractWoWClientPacket {
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The guid. */
	private long guid;

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		guid = readQ();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		/**
		 *  FIXME send from database information too
		 *  need cache
		 */
		
		if (PlayerService.getPlayer(guid) != null) {
			sender.send(getClient(), new SMSG_NAME_QUERY_RESPONSE(PlayerService
					.getPlayer(guid)));
		}

	}
}
