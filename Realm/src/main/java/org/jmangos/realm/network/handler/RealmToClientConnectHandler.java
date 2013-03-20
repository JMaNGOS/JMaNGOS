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
package org.jmangos.realm.network.handler;

import org.jboss.netty.channel.ChannelHandler;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.State;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.network.packet.wow.server.SMSG_AUTH_CHALLENGE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class RealmToClientConnectHandler.
 */
@Component("realmToClientConnectHandler")
public class RealmToClientConnectHandler implements ConnectHandler {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(RealmToClientConnectHandler.class);

    /** The sender. */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    /**
     * @see org.jmangos.commons.network.model.ConnectHandler#onConnect(org.jmangos.commons.network.model.NettyNetworkChannel,
     *      org.jboss.netty.channel.ChannelHandler)
     */
    @Override
    public void onConnect(final NettyNetworkChannel networkChannel, final ChannelHandler handler) {

        networkChannel.setChannelState(State.CONNECTED);
        log.info("Accepting connection from: " + networkChannel.getAddress());
        this.sender.send(networkChannel, new SMSG_AUTH_CHALLENGE());
    }

    /**
     * @see org.jmangos.commons.network.model.ConnectHandler#onDisconnect(org.jmangos.commons.network.model.NettyNetworkChannel)
     */
    @Override
    public void onDisconnect(final NettyNetworkChannel networkChannel) {

        log.info("Disconnection : " + networkChannel.getAddress().getHostName());

    }

}
