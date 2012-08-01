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
