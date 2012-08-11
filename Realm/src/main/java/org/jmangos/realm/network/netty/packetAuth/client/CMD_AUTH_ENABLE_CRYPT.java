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
package org.jmangos.realm.network.netty.packetAuth.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.network.netty.decoder.AuthPacketFrameDecoder;
import org.jmangos.realm.network.netty.decoder.AuthPacketFrameEncoder;
import org.jmangos.realm.network.netty.handler.RealmToAuthChannelHandler;
import org.jmangos.realm.network.netty.packetAuth.AbstractRealmClientPacket;
import org.jmangos.realm.network.netty.packetAuth.server.CMD_TEST_CRYPT;

/**
 * The Class <tt>CMD_AUTH_ENABLE_CRYPT</tt>.
 */
public class CMD_AUTH_ENABLE_CRYPT extends AbstractRealmClientPacket {

	/** The logger. */
	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(CMD_AUTH_ENABLE_CRYPT.class);
	@Inject
	@Named("RealmToAuth")
	private AbstractPacketSender sender;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		// read size of the packet before enable encryption
		readC();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		ChannelPipeline pipeline = getClient().getChannel().getPipeline();
		pipeline.addFirst("framedecoder", new AuthPacketFrameDecoder());
		pipeline.addFirst("encoder", new AuthPacketFrameEncoder());
		RealmToAuthChannelHandler channelHandler = (RealmToAuthChannelHandler)pipeline.getLast();
		channelHandler.getCrypt().init(channelHandler.getSeed());
		sender.send(getClient(), new CMD_TEST_CRYPT());
	}
}
