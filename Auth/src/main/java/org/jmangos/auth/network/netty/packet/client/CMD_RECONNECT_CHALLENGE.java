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

import org.apache.log4j.Logger;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_RECONNECT_CHALLENGE;
import org.jmangos.auth.service.AccountService;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_RECONNECT_CHALLENGE.
 */
public class CMD_RECONNECT_CHALLENGE extends AbstractWoWClientPacket {
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(CMD_RECONNECT_CHALLENGE.class);
	
	/** The sender. */
	@Inject
	private AbstractPacketSender sender;
	
	/** The account service. */
	@Inject
	AccountService accountService;
	
	/** The login. */
	private String login;

	/**
	 * Instantiates a new cM d_ reconnec t_ challenge.
	 */
	public CMD_RECONNECT_CHALLENGE() {
		super();
	}	
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#getMinimumLength()
	 */
	public int getMinimumLength()
	{
		return 0;
	}
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unused")
	@Override
	protected void readImpl()
	{
		int error = readC();
		int size  = readH(); 
		byte[] gamename = readB(4);
		int version1 = readC();
		int version2 = readC();
		int version3 = readC();
		int build = readH(); 
		byte[] platform = readB(4);
		byte[] os = readB(4);
		byte[] country = readB(4);
		int timezone_bias = readD();
		int ip = readD();
		int lenLogin = readC();
		login = new String(readB(lenLogin), 0, lenLogin);
	}

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	protected void runImpl() {
		accountService.loadClean(login, (NettyNetworkChannel)getClient());
		sender.send(this.getClient() ,new TCMD_RECONNECT_CHALLENGE());
	}
}
