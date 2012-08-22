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
package org.jmangos.realm.network.packet.auth.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.config.Config;
import org.jmangos.realm.network.decoder.AuthPacketFrameDecoder;
import org.jmangos.realm.network.decoder.AuthPacketFrameEncoder;
import org.jmangos.realm.network.handler.RealmToAuthChannelHandler;
import org.jmangos.realm.network.packet.auth.AbstractRealmClientPacket;
import org.jmangos.realm.network.packet.auth.server.SMD_REALM_DATA;
import org.springframework.stereotype.Component;

/**
 * The Class <tt>CMD_AUTH_ENABLE_CRYPT</tt>.
 */
@Component
public class CMD_AUTH_ENABLE_CRYPT extends AbstractRealmClientPacket {
    
    @Inject
    @Named("serverPacketSender")
    private AbstractPacketSender sender;
    
    @Inject
    private Config               config;
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#readImpl()
     */
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        // read size of the packet before enable encryption
        readC();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.ReceivablePacket#runImpl()
     */
    @Override
    protected void runImpl() {
    
        final ChannelPipeline pipeline = getClient().getChannel().getPipeline();
        pipeline.addFirst("framedecoder", new AuthPacketFrameDecoder());
        pipeline.addFirst("encoder", new AuthPacketFrameEncoder());
        final RealmToAuthChannelHandler channelHandler = (RealmToAuthChannelHandler) pipeline.getLast();
        channelHandler.getCrypt().init(channelHandler.getSeed());
        
        // read from Player service
        final Float popl = 0.4f;
        this.sender.send(getClient(), new SMD_REALM_DATA(this.config, popl));
    }
}
