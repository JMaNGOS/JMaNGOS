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

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.handler.RealmToClientChannelHandler;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_PONG;

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_PING.
 */
@SuppressWarnings("unused")
public class CMSG_PING extends AbstractWoWClientPacket {
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(CMSG_PING.class);
	
	/** The ping. */
	private int ping;
	
	/** The latency. */
	private int latency;
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		ping = readD();
		latency = readD();
		
		if(GetChannelHandler().getLastPingTime() < 0 ){
			GetChannelHandler().setLastPingTime(System.currentTimeMillis());
		}
		else{
			// FIXME flood protection need here??
		}
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(getClient() ,new SMSG_PONG(ping));
		
	}

}
