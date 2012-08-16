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
package org.jmangos.realm.network.netty.packetClient.client;

import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_CHAR_ENUM;
import org.jmangos.realm.service.AccountService;
import org.jmangos.realm.service.ItemStorages;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.BufferUnderflowException;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_CHAR_ENUM.
 */
public class CMSG_CHAR_ENUM  extends AbstractWoWClientPacket {
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The account service. */
	@Inject
	private AccountService accountService;

    @Inject
    private ItemStorages itemStorages;
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		// nothing to read
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient(), new SMSG_CHAR_ENUM( accountService.getCharacters( getAccount().getId() ) ));
	}

}
