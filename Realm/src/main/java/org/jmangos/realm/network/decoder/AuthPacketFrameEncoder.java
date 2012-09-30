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
package org.jmangos.realm.network.decoder;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jmangos.realm.network.handler.RealmToAuthChannelHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PacketFrameEncoder.
 */
public class AuthPacketFrameEncoder extends OneToOneEncoder {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(AuthPacketFrameEncoder.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.netty.handler.codec.oneone.OneToOneEncoder#encode(org.jboss
     * .netty.channel.
     * ChannelHandlerContext, org.jboss.netty.channel.Channel, java.lang.Object)
     */
    @Override
    protected Object encode(final ChannelHandlerContext ctx, final Channel channel, final Object msg)
            throws Exception {

        final ChannelBuffer message = (ChannelBuffer) msg;

        final RealmToAuthChannelHandler channelHandler =
                (RealmToAuthChannelHandler) ctx.getPipeline().getLast();
        final int opcode = message.readUnsignedByte();
        final int size = message.readableBytes();
        final ChannelBuffer frame = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, (size + 3));
        frame.writeByte(opcode);
        frame.writeShort(size);

        byte[] tmpa = new byte[message.readableBytes()];
        message.readBytes(tmpa);
        tmpa = channelHandler.getCrypt().encrypt(tmpa);
        frame.writeBytes(tmpa);
        log.debug(String.format("[SEND PACKET] :  0x%02X", opcode));
        final List<String> d =
                breakStringInChunks(new BigInteger(1, tmpa).toString(16).toUpperCase(), 16);
        for (final String string : d) {
            log.debug(string);
        }
        return frame;
    }

    /**
     * 
     * @param text
     *        the text
     * @param chunkSize
     *        the chunk size
     * @return the list
     */
    private static List<String> breakStringInChunks(final String text, final int chunkSize) {

        final int numChunks =
                0 == (text.length() % chunkSize)
                        ? text.length() / chunkSize
                        : 1 + (text.length() / chunkSize);
        final List<String> chunks = new ArrayList<String>(numChunks);
        for (int startIndex = 0; startIndex < text.length(); startIndex += chunkSize) {
            final int endIndex = Math.min(text.length(), startIndex + chunkSize);
            chunks.add(text.substring(startIndex, endIndex));
        }
        return chunks;
    }
}
