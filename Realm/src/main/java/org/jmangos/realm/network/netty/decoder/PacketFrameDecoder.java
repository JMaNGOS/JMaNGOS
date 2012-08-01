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
package org.jmangos.realm.network.netty.decoder;

import java.nio.ByteOrder;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jmangos.realm.network.crypt.Crypt;
import org.jmangos.realm.network.netty.handler.R2CChannelHandler;

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
		R2CChannelHandler channelHandler = (R2CChannelHandler) ctx
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
