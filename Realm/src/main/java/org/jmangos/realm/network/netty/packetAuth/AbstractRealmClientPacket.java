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
/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package org.jmangos.realm.network.netty.packetAuth;

import org.jmangos.commons.model.Account;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.realm.network.netty.handler.RealmToClientChannelHandler;


/**
 * The Class AbstractRealmClientPacket.
 *
 */
public abstract class AbstractRealmClientPacket extends ReceivablePacket
{
	
	/**
	 * Instantiates a new abstract realm client packet.
	 *
	 * @param opcode the opcode
	 */
	public AbstractRealmClientPacket(int opcode)
	{
		super(opcode);
		
	}
	
	/**
	 * Instantiates a new abstract realm client packet.
	 */
	public AbstractRealmClientPacket()
	{
		super();
	}
	
	/**
	 * Gets the channel handler.
	 *
	 * @return the r2 c channel handler
	 */
	protected RealmToClientChannelHandler GetChannelHandler(){
		return (RealmToClientChannelHandler)getChannel().getPipeline().getLast(); 
		
	}
	
	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount(){
		return (Account)((NettyNetworkChannel) _client).getChanneledObject();
	}
}

