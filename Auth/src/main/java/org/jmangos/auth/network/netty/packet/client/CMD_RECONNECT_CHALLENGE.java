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

/**
 * The Class <tt>CMD_RECONNECT_CHALLENGE</tt>.
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
		int error = readC(); // error
		int size = readH(); // size
		readB(4); // gamename
		readC(); // version 3
		readC(); // version 5
		readC(); // version 5
		readH(); // client buildNr
		readB(4); // platform
		readB(4); // OS
		readB(4); // country (enUS)
        /*int timezone_bias = */readD();
		/*int ip = */readD();
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
