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

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jmangos.realm.network.crypt.Crypt;
import org.jmangos.realm.network.netty.handler.RealmToClientChannelHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PacketFrameDecoder.
 */
public class AuthPacketFrameDecoder extends FrameDecoder {
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(AuthPacketFrameDecoder.class);
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.netty.handler.codec.frame.FrameDecoder#decode(org.jboss.netty.channel.
     * ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer)
     */
    @Override
    protected Object decode(final ChannelHandlerContext ctx, final Channel channel, final ChannelBuffer msg) throws Exception {
    
        final ChannelBuffer message = msg;
        if (message.readableBytes() < 3) {
            return null;
        }
        message.markReaderIndex();
        final RealmToClientChannelHandler channelHandler = (RealmToClientChannelHandler) ctx.getPipeline().getLast();
        final Crypt crypt = channelHandler.getCrypt();
        
        final byte[] header = new byte[3];
        message.readBytes(header);
        final ChannelBuffer clientHeader = ChannelBuffers.wrappedBuffer(ByteOrder.LITTLE_ENDIAN, header);
        final byte opcode = clientHeader.readByte();
        final int size = clientHeader.readShort();
        if ((size < 0) || (size > 10240) || (opcode > 10240)) {
            log.error("PacketFrameDecoder::decode: realm sent malformed packet size = " + size + " , opcode = " + opcode);
            channel.close();
            return null;
        }
        
        if (message.readableBytes() < size) {
            message.resetReaderIndex();
            return null;
        }
        
        byte[] tmpa = new byte[message.readableBytes()];
        message.readBytes(tmpa);
        tmpa = crypt.decrypt(tmpa);
        final ChannelBuffer frame = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, (size + 1));
        frame.writeByte(opcode);
        frame.writeBytes(tmpa);
        return frame;
    }
}
