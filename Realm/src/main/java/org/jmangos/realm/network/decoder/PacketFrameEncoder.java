/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.realm.network.decoder;

import java.math.BigInteger;
import java.nio.ByteOrder;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jmangos.commons.OpcodeTable;
import org.jmangos.realm.network.handler.RealmToClientChannelHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PacketFrameEncoder.
 */
public class PacketFrameEncoder extends OneToOneEncoder {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(PacketFrameEncoder.class);

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

        final RealmToClientChannelHandler channelHandler =
                (RealmToClientChannelHandler) ctx.getPipeline().getLast();
        final int opcode = message.readUnsignedShort();
        final int size = message.readableBytes() + 2;
        final byte[] header = new byte[4];
        int index = 0;
        if (size > 0x7FFF) {
            header[index++] = (byte) (0x80 | (0xFF & (size >> 16)));
        }
        header[index++] = (byte) (0xFF & (size >> 8));
        header[index++] = (byte) (0xFF & size);
        header[index++] = (byte) (0xFF & opcode);
        header[index] = (byte) (0xFF & (opcode >> 8));
        final byte[] encryptHeader = channelHandler.getCrypt().decrypt(header);
        final ChannelBuffer frame = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, (size + index));
        frame.writeBytes(encryptHeader, 0, index + 1);
        final ChannelBuffer tmp = message.readBytes(message.readableBytes());
        frame.writeBytes(tmp);
        log.info(String.format("[SEND PACKET] :  0x%02X - %s", opcode,
                OpcodeTable.getOpcode(opcode)));
        final String d = toHex(tmp.array());
        log.info(d);
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
    public static String toHex(final byte[] bytes) {

        if (bytes.length == 0) {
            return "";
        }
        final BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
