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
package org.jmangos.commons.network.netty.sender;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.SendablePacket;
import org.jmangos.commons.network.utils.NetworkUtil;

/**
 * The Class ServerPacketSender.
 */
public class ServerPacketSender implements AbstractPacketSender {
	/*
	 * @Inject private Network network;
	 */
	/** The packet service. */
	@Inject
	@Named("RealmToAuth")
	private PacketHandlerFactory packetService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.wowemu.common.network.netty.sender.AbstractPacketSender#send(org.
	 * wowemu.common.network.model.NetworkChannel,
	 * org.wowemu.common.network.model.SendablePacket)
	 */
	public void send(NetworkChannel channel, SendablePacket packet) {
		packet.setChannel(channel);
		ChannelBuffer buffer = sendImpl(packet);
		writeToChannel(channel, buffer);
	}

	/**
	 * Send impl.
	 * 
	 * @param packet
	 *            the packet
	 * @return the channel buffer
	 */
	protected ChannelBuffer sendImpl(SendablePacket packet) {
		final ChannelBuffer buffer = getBuffer();
		packet.setByteBuffer(buffer);
		packet.setOpCode(packetService.getServerPacketopCode(packet));
		packet.write();
		return packet.getByteBuffer();
	}

	/**
	 * Write to channel.
	 * 
	 * @param channel
	 *            the channel
	 * @param buffer
	 *            the buffer
	 */
	protected void writeToChannel(NetworkChannel channel, Object buffer) {
		writePacket(channel, buffer);
	}

	/**
	 * Write to channel and close.
	 * 
	 * @param channel
	 *            the channel
	 * @param buffer
	 *            the buffer
	 */
	protected void writeToChannelAndClose(NetworkChannel channel, Object buffer) {
		((Channel) channel.getChannel()).write(buffer).addListener(
				ChannelFutureListener.CLOSE);
	}

	/**
	 * Gets the buffer.
	 * 
	 * @return the buffer
	 */
	protected ChannelBuffer getBuffer() {
		ChannelBuffer buffer = NetworkUtil.newDinamicChannelBuffer(65536);
		return buffer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.wowemu.common.network.netty.sender.AbstractPacketSender#sendAndClose
	 * (org.wowemu.common.network.model.NetworkChannel,
	 * org.wowemu.common.network.model.SendablePacket)
	 */
	@Override
	public void sendAndClose(NetworkChannel channel,
			SendablePacket networkPacket) {
		Object buffer = sendImpl(networkPacket);
		writePacket(channel, buffer);
		channel.getChannel().close();
	}

	/**
	 * Write packet.
	 * 
	 * @param channel
	 *            the channel
	 * @param buffer
	 *            the buffer
	 */
	private void writePacket(NetworkChannel channel, Object buffer) {
		channel.write(buffer);
	}
}
