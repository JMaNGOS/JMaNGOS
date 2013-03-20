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
package org.jmangos.realm.service;

import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.service.AbstractNetworkService;
import org.jmangos.realm.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class RealmNetworkService.
 */
@Component
public class RealmNetworkService extends AbstractNetworkService {

    @Autowired
    private Config config;

    /** The RealmToClient pipeline factory. */
    @Autowired
    @Qualifier("realmToClientPipelineFactory")
    private ChannelPipelineFactory realmToClientPipelineFactory;

    /** The packet service. */
    @Autowired
    @Qualifier("сlientPacketHandlerFactory")
    private PacketHandlerFactory clientPacketService;
    /** The packet service. */
    @Autowired
    @Qualifier("realmToAuthPacketHandlerFactory")
    private PacketHandlerFactory authPacketService;

    @Autowired
    @Qualifier("realmToAuthPipelineFactory")
    private ChannelPipelineFactory realmToAuthPipelineFactory;

    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @Override
    public void start() {

        this.clientPacketService.loadPacket();
        createServerChannel(this.config.CLIENT_ADDRESS, this.realmToClientPipelineFactory);
        // Only run if auth server not from mangos team
        if (!this.config.COMPATIBLE.equals(Compatiple.MANGOS)) {
            this.authPacketService.loadPacket();
            createClientChannel(this.config.AUTH_ADDRESS, this.realmToAuthPipelineFactory);
        }
    }

    /**
     * 
     * @see org.jmangos.commons.network.service.NetworkService#status()
     */
    @Override
    public void status() {

        throw new NotImplementedException();
    }

    /**
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        throw new NotImplementedException();
    }
}
