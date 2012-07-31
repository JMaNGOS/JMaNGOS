/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.network.netty.packet.client;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.model.player.Player;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWClientPacket;
import org.JMANGOS.realm.service.PlayerService;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

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
