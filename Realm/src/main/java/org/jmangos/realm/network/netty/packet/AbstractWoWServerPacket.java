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
import org.jmangos.commons.network.model.SendablePacket;
import org.jmangos.realm.model.account.Account;
import org.jmangos.realm.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractWoWServerPacket.
 */
public abstract class AbstractWoWServerPacket extends SendablePacket
{
	
	/**
	 * Gets the channel.
	 *
	 * @return the channel
	 */
	public NettyNetworkChannel getChannel(){ 
		return (NettyNetworkChannel) channel;
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#write()
	 */
	public void write() throws RuntimeException
	{
		writeH(this.opCode);
		writeImpl();
	}
	
	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount(){ 
		return (Account)(getChannel().getChanneledObject());
	}
	
	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer(){ 
		return (Player)(getChannel().getActiveObject());
	}
}
