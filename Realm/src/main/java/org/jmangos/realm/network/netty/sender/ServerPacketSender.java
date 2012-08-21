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
package org.jmangos.realm.network.netty.sender;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.SendablePacket;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.commons.network.utils.NetworkUtil;
import org.springframework.stereotype.Component;

/**
 * The Class ServerPacketSender.
 */
@Component("serverPacketSender")
public class ServerPacketSender implements AbstractPacketSender {
    
    /** The packet service. */
    @Inject
    @Named("authToClientPacketHandlerFactory")
    private PacketHandlerFactory packetService;
    
    /**
     * @see org.jmangos.commons.network.netty.sender.AbstractPacketSender#send(org.jmangos.commons.network.model.NetworkChannel,
     *      org.jmangos.commons.network.model.SendablePacket)
     */
    @Override
    public void send(final NetworkChannel channel, final SendablePacket packet) {
    
        packet.setChannel(channel);
        final ChannelBuffer buffer = sendImpl(packet);
        writeToChannel(channel, buffer);
    }
    
    /**
     * Send impl.
     * 
     * @param packet
     *            the packet
     * @return the channel buffer
     */
    protected ChannelBuffer sendImpl(final SendablePacket packet) {
    
        final ChannelBuffer buffer = getBuffer();
        packet.setByteBuffer(buffer);
        packet.setOpCode(this.packetService.getServerPacketopCode(packet));
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
    protected void writeToChannel(final NetworkChannel channel, final Object buffer) {
    
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
    protected void writeToChannelAndClose(final NetworkChannel channel, final Object buffer) {
    
        channel.getChannel().write(buffer).addListener(ChannelFutureListener.CLOSE);
    }
    
    /**
     * Gets the buffer.
     * 
     * @return the buffer
     */
    protected ChannelBuffer getBuffer() {
    
        final ChannelBuffer buffer = NetworkUtil.newDinamicChannelBuffer(65536);
        return buffer;
    }
    
    /**
     * @see org.jmangos.commons.network.netty.sender.AbstractPacketSender#sendAndClose(org.jmangos.commons.network.model.NetworkChannel,
     *      org.jmangos.commons.network.model.SendablePacket)
     */
    @Override
    public void sendAndClose(final NetworkChannel channel, final SendablePacket networkPacket) {
    
        final Object buffer = sendImpl(networkPacket);
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
    private void writePacket(final NetworkChannel channel, final Object buffer) {
    
        channel.write(buffer);
    }
}
