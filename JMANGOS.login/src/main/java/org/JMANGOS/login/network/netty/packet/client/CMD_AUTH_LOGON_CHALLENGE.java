/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.login.network.netty.packet.client;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.JMANGOS.common.model.WoWAuthResponse;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;
import org.JMANGOS.login.network.netty.packet.AbstractWoWClientPacket;
import org.JMANGOS.login.network.netty.packet.server.TCMD_AUTH_LOGON_CHALLENGE;
import org.JMANGOS.login.service.AccountService;

// TODO: Auto-generated Javadoc
/**
 * The Class CMD_AUTH_LOGON_CHALLENGE.
 */
public class CMD_AUTH_LOGON_CHALLENGE extends AbstractWoWClientPacket {
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(CMD_AUTH_LOGON_CHALLENGE.class);
	
	/** The sender. */
	@Inject
	private AbstractPacketSender sender;
	
	/** The account service. */
	@Inject
	AccountService accountService;
	
	/** The login. */
	private String login;

	/**
	 * Constructs new instance of <tt>R_CMD_AUTH_LOGON_CHALLENGE</tt> packet.
	 *
	 * @param opcode the opcode
	 */
	
	public CMD_AUTH_LOGON_CHALLENGE(int opcode) {
		super(opcode);
	}
	
	/**
	 * Instantiates a new cM d_ aut h_ logo n_ challenge.
	 */
	public CMD_AUTH_LOGON_CHALLENGE() {
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
		WoWAuthResponse response = accountService.login(login, (NettyNetworkChannel)getClient());
		
		switch (response) {
		case WOW_FAIL_BANNED:
			sender.sendAndClose(this.getClient() , new TCMD_AUTH_LOGON_CHALLENGE(response));
			break;
		default:
			sender.send(this.getClient() ,new TCMD_AUTH_LOGON_CHALLENGE(response));
			break;
		}
	}
}
