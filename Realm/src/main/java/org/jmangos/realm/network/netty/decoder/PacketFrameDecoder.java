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
package org.jmangos.realm.network.netty.decoder;

import java.nio.ByteOrder;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jmangos.realm.network.crypt.Crypt;
import org.jmangos.realm.network.netty.handler.RealmToClientChannelHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class PacketFrameDecoder.
 */
public class PacketFrameDecoder extends FrameDecoder {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(PacketFrameDecoder.class);

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.frame.FrameDecoder#decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer)
	 */
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer msg) throws Exception {
		ChannelBuffer message = (ChannelBuffer) msg;
		if (message.readableBytes() < 6) {
			return null;
		}
		message.markReaderIndex();
		RealmToClientChannelHandler channelHandler = (RealmToClientChannelHandler) ctx
				.getPipeline().getLast();
		Crypt crypt = channelHandler.getCrypt();
		byte[] header = new byte[6];
		message.readBytes(header);
		header = crypt.encrypt(header);
		ChannelBuffer clientHeader = ChannelBuffers.wrappedBuffer(
				ByteOrder.LITTLE_ENDIAN, header);
		int size = clientHeader.readByte() << 8;
		size |= clientHeader.readByte() & 0xFF;
		size -=4;
		long opcode = clientHeader.readUnsignedInt();
		if ((size < 0) || (size > 10240) || (opcode > 10240)) {
			log
					.error("PacketFrameDecoder::decode: client sent malformed packet size = "
							+ size + " , opcode = " + opcode);
			 channel.close();
			 return null;
		}
		
		if (message.readableBytes() < size) {
			message.resetReaderIndex();
			return null;
		}

		ChannelBuffer frame = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN,
				(size + 4));
		frame.writeInt((int) opcode);
		frame.writeBytes(message.readBytes(size));
		return frame;
	}
}
