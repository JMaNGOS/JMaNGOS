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

import org.apache.log4j.Logger;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_RECONNECT_CHALLENGE;
import org.jmangos.auth.service.AccountService;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_RECONNECT_CHALLENGE</tt>.
 */
@Component
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
	 * Instantiates a new CMD_RECONNECT_CHALLENGE.
	 */
	public CMD_RECONNECT_CHALLENGE() {
		super();
	}

	/**
	 * @see org.jmangos.commons.network.model.ReceivablePacket#getMinimumLength()
	 */
	public int getMinimumLength() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unused")
	@Override
	protected void readImpl() {
		int error = readC();
		int size = readH();
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
		accountService.loadClean(login, (NettyNetworkChannel) getClient());
		sender.send(this.getClient(), new TCMD_RECONNECT_CHALLENGE());
	}
}
