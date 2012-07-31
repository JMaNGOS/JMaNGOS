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
import org.JMANGOS.realm.network.netty.packet.server.SMSG_ACCOUNT_DATA_TIMES;
import org.JMANGOS.realm.service.AccountService;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_READY_FOR_ACCOUNT_DATA_TIMES.
 */
public class CMSG_READY_FOR_ACCOUNT_DATA_TIMES extends AbstractWoWClientPacket {

	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The account servise. */
	@Inject
	AccountService accountServise;
	
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
		getAccount().setAccountData(
				accountServise.getAccountData(getAccount().getObjectId()));
		sender.send(getClient(), new SMSG_ACCOUNT_DATA_TIMES(
				SMSG_ACCOUNT_DATA_TIMES.GLOBAL_CACHE_MASK, getAccount()
						.getAccountData()));

	}
}
