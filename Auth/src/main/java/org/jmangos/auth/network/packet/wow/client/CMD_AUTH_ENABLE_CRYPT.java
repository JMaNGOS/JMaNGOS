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
package org.jmangos.auth.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.auth.network.decoder.RealmPacketFrameDecoder;
import org.jmangos.auth.network.decoder.RealmPacketFrameEncoder;
import org.jmangos.auth.network.handler.AuthToClientChannelHandler;
import org.jmangos.auth.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.auth.network.packet.wow.server.SMD_AUTH_ENABLE_CRYPT;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_AUTH_ENABLE_CRYPT</tt>.
 */
@Component
public class CMD_AUTH_ENABLE_CRYPT extends AbstractWoWClientPacket {
    
    /** The logger. */
    private static Logger        logger = LoggerFactory.getLogger(CMD_AUTH_ENABLE_CRYPT.class);
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    public CMD_AUTH_ENABLE_CRYPT() {
    
        super();
    }
    
    /**
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
     */
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
    }
    
    /**
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
     */
    @Override
    protected void runImpl() {
    
        // TODO 5 - magic number send to config like realm acces
        if (getAccountInfo().getAccessLevel() == 5) {
            logger.info("Realm " + getAccountInfo().getName() + " started crypt");
            final ChannelPipeline pipeline = getClient().getChannel().getPipeline();
            pipeline.addFirst("framedecoder", new RealmPacketFrameDecoder());
            pipeline.addFirst("encoder", new RealmPacketFrameEncoder());
            final AuthToClientChannelHandler channelHandler = (AuthToClientChannelHandler) pipeline.getLast();
            channelHandler.getCrypt().init(getAccountInfo().getvK());
        }
        
        this.sender.send(getClient(), new SMD_AUTH_ENABLE_CRYPT());
    }
}
