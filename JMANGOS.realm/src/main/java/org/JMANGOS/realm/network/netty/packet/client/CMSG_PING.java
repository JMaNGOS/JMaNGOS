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
package org.JMANGOS.realm.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.network.netty.handler.R2CChannelHandler;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWClientPacket;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_PONG;
import org.apache.log4j.Logger;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

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
