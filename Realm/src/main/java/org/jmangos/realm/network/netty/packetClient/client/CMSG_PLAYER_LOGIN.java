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

// TODO: Auto-generated Javadoc
/**
 * The Class CMSG_PLAYER_LOGIN.
 */
public class CMSG_PLAYER_LOGIN  extends AbstractWoWClientPacket {
	
	/** The sender. */
	@SuppressWarnings("unused")
	@Inject
	@Named("client")
	private AbstractPacketSender sender;
	
	/** The player service. */
	@Inject
	private PlayerService playerService;
	
	/** The guid. */
	private long guid;
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#readImpl()
	 */
	@Override
	protected void readImpl() throws BufferUnderflowException, RuntimeException {
		guid = readQ(); 
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() {
		Player player = playerService.preparePlayer(getClient(), guid);
		playerService.LoadFromDB(player);
		playerService.sendInicialPackets(player);
		
	}

}
