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
import org.JMANGOS.realm.network.netty.packet.server.SMSG_ITEM_QUERY_SINGLE_RESPONSE;
import org.JMANGOS.realm.service.ItemStorages;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_ITEM_QUERY_SINGLE.
 */
public class CMSG_ITEM_QUERY_SINGLE extends AbstractWoWClientPacket {

	/** The item. */
	private int item;
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The item storages. */
	@Inject
	private ItemStorages itemStorages;
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		item = readD();
		
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient(), new SMSG_ITEM_QUERY_SINGLE_RESPONSE(itemStorages.get(item)));
		
	}

}
