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

import java.nio.BufferUnderflowException;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.auth.network.netty.decoder.RealmPacketFrameDecoder;
import org.jmangos.auth.network.netty.decoder.RealmPacketFrameEncoder;
import org.jmangos.auth.network.netty.handler.AuthToClientChannelHandler;
import org.jmangos.auth.network.netty.packet.AbstractWoWClientPacket;
import org.jmangos.auth.network.netty.packet.server.TCMD_AUTH_ENABLE_CRYPT;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;

/**
 * The Class <tt>CMD_AUTH_ENABLE_CRYPT</tt>.
 */
public class CMD_AUTH_ENABLE_CRYPT extends AbstractWoWClientPacket {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(CMD_AUTH_ENABLE_CRYPT.class);
	/** The sender. */
	@Inject
	private AbstractPacketSender sender;

	public CMD_AUTH_ENABLE_CRYPT() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		// TODO 5 - magic number send to config like realm acces
		if (getAccount().getAccessLevel() == 5) {
			logger.info("Realm " + getAccount().getName() + " started crypt");
			ChannelPipeline pipeline = getClient().getChannel().getPipeline();
			pipeline.addFirst("framedecoder", new RealmPacketFrameDecoder());
			pipeline.addFirst("encoder", new RealmPacketFrameEncoder());
			AuthToClientChannelHandler channelHandler = (AuthToClientChannelHandler) pipeline
					.getLast();
			channelHandler.getCrypt().init(getAccount().getvK());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		sender.send(this.getClient(), new TCMD_AUTH_ENABLE_CRYPT());

	}
}
