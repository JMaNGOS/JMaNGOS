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
import org.JMANGOS.realm.network.netty.packet.server.SMSG_QUERY_NEXT_MAIL_TIME;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_QUERY_NEXT_MAIL_TIME.
 */
public class CMSG_QUERY_NEXT_MAIL_TIME  extends AbstractWoWClientPacket {
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient(), new SMSG_QUERY_NEXT_MAIL_TIME());
		
	}
}
