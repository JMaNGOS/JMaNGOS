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
package org.jmangos.auth.network.netty.packet.client;

import javax.inject.Inject;

import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_REALM_LIST;
import org.jmangos.auth.service.WorldListService;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_REALM_LIST.
 */
public class CMD_REALM_LIST extends AbstractWoWClientPacket {
	
	/** The sender. */
	@Inject
	private AbstractPacketSender sender;
	
	/** The worldlist. */
	@Inject
	private WorldListService worldlist;
	/* 
	 * {@inheritDoc}
	 */
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#getMinimumLength()
	 */
	@Override
	public int getMinimumLength() {
		return 4;
	}

	/**
	 * Instantiates a new cM d_ real m_ list.
	 */
	public CMD_REALM_LIST() {
		super();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void readImpl()
	{
		
		readB(getAvaliableBytes());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void runImpl() {
		sender.send(this.getClient() ,new TCMD_REALM_LIST(worldlist));
	}
}
