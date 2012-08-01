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

