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
package org.JMANGOS.realm.network.netty.decoder;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.JMANGOS.realm.network.netty.handler.R2CChannelHandler;
import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class PacketFrameEncoder.
 */
public class PacketFrameEncoder extends OneToOneEncoder {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(PacketFrameEncoder.class);

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.oneone.OneToOneEncoder#encode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, java.lang.Object)
	 */
	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception {
		ChannelBuffer message = (ChannelBuffer) msg;

		R2CChannelHandler channelHandler = (R2CChannelHandler) ctx
				.getPipeline().getLast();
		int opcode = message.readUnsignedShort();
		int size = message.readableBytes()+2;
		byte[] header = new byte[4];
		int index = 0;
		if (size > 0x7FFF) {
			header[index++] = (byte) (0x80 | (0xFF & (size >> 16)));
		}
		header[index++] = (byte)(0xFF & (size >> 8));
		header[index++] = (byte)(0xFF & size);
		header[index++] = (byte)(0xFF & opcode);
		header[index] = (byte)(0xFF & (opcode >> 8));
		byte[] encryptHeader = channelHandler.getCrypt().decrypt(header);
		ChannelBuffer frame = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN,
				(size + index));
		frame.writeBytes(encryptHeader,0,index+1);
		ChannelBuffer tmp  = message.readBytes(message.readableBytes());
		frame.writeBytes(tmp);
		log.info(String.format("[SEND PACKET] :  0x%02X", opcode));
		List<String> d =  breakStringInChunks(new BigInteger(1,tmp.array()).toString(16).toUpperCase(),16);
		for (Iterator<String> iterator = d.iterator(); iterator.hasNext();) {
			String string =  iterator.next();
			log.info(string);
		}
		log.info("");
		return frame;
	}
	
	/**
	 * Break string in chunks.
	 *
	 * @param text the text
	 * @param chunkSize the chunk size
	 * @return the list
	 */
	private static List<String> breakStringInChunks(final String text, final int chunkSize) {
	    final int numChunks = 0 == (text.length() % chunkSize) ? text.length() / chunkSize : 1 + (text.length() / chunkSize);
	    final List<String> chunks = new ArrayList<String>(numChunks);
	    for (int startIndex = 0; startIndex < text.length(); startIndex += chunkSize) {
	        final int endIndex = Math.min(text.length(), startIndex + chunkSize);
	        chunks.add(text.substring(startIndex, endIndex));
	    }
	    return chunks;
	}
}
