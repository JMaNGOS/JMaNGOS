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
package org.JMANGOS.common.network.netty.sender;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.common.network.handlers.PacketHandlerFactory;
import org.JMANGOS.common.network.model.NetworkChannel;
import org.JMANGOS.common.network.model.SendablePacket;
import org.JMANGOS.common.network.utils.NetworkUtil;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;


// TODO: Auto-generated Javadoc
/**
 * The Class ServerPacketSender.
 */
public class ServerPacketSender implements AbstractPacketSender {
	/*
	 * @Inject private Network network;
	 */
	/** The packet service. */
	@Inject
	@Named("r2l")
	private PacketHandlerFactory packetService;

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.sender.AbstractPacketSender#send(org.wowemu.common.network.model.NetworkChannel, org.wowemu.common.network.model.SendablePacket)
	 */
	public void send(NetworkChannel channel, SendablePacket packet) {
		packet.setChannel(channel); 
		ChannelBuffer buffer = sendImpl(packet);
		writeToChannel(channel, buffer);
	}

	/**
	 * Send impl.
	 *
	 * @param packet the packet
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
	 * @param channel the channel
	 * @param buffer the buffer
	 */
	protected void writeToChannel(NetworkChannel channel, Object buffer) {
		writePacket(channel, buffer);
	}

	/**
	 * Write to channel and close.
	 *
	 * @param channel the channel
	 * @param buffer the buffer
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


	/* (non-Javadoc)
	 * @see org.wowemu.common.network.netty.sender.AbstractPacketSender#sendAndClose(org.wowemu.common.network.model.NetworkChannel, org.wowemu.common.network.model.SendablePacket)
	 */
	@Override
	public void sendAndClose(NetworkChannel channel, SendablePacket networkPacket) {
		Object buffer = sendImpl(networkPacket);
		writePacket(channel, buffer);
		channel.getChannel().close();
	}

	/**
	 * Write packet.
	 *
	 * @param channel the channel
	 * @param buffer the buffer
	 */
	private void writePacket(NetworkChannel channel, Object buffer) {
		channel.write(buffer);
	}
}
