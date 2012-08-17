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
package org.jmangos.realm.network.netty.packetClient.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.service.PlayerService;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_PLAYER_LOGIN.
 */
@Component
public class CMSG_PLAYER_LOGIN extends AbstractWoWClientPacket {
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    /** The player service. */
    @Inject
    private PlayerService        playerService;
    
    /** The guid. */
    private long                 guid;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.guid = readQ();
    }
    
    @Override
    protected void runImpl() {
    
        final Player player = this.playerService.preparePlayer(getClient(), this.guid);
        this.playerService.LoadFromDB(player);
        this.playerService.sendInicialPackets(player);
    }
    
}
