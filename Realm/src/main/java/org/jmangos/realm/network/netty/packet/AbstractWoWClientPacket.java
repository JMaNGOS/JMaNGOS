/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.jmangos.realm.network.netty.packet;

import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.realm.model.account.Account;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.handler.R2CChannelHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractWoWClientPacket.
 */
public abstract class AbstractWoWClientPacket extends ReceivablePacket
{
	
	/**
	 * Instantiates a new abstract wo w client packet.
	 *
	 * @param opcode the opcode
	 */
	public AbstractWoWClientPacket(int opcode)
	{
		super(opcode);
		
	}
	
	/**
	 * Instantiates a new abstract wo w client packet.
	 */
	public AbstractWoWClientPacket()
	{
		super();
	}
	
	/**
	 * Gets the channel handler.
	 *
	 * @return the r2 c channel handler
	 */
	protected R2CChannelHandler GetChannelHandler(){
		return (R2CChannelHandler)getChannel().getPipeline().getLast(); 
		
	}
	
	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount(){ 
		return (Account)((NettyNetworkChannel) _client).getChanneledObject();
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer(){ 
		return (Player)((NettyNetworkChannel) _client).getActiveObject();
	}	
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ReceivablePacket#getClient()
	 */
	public NettyNetworkChannel getClient(){
		return ((NettyNetworkChannel) _client);
	}
	
}

