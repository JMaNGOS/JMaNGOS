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
package org.jmangos.realm.network.netty.packetLogin;

import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.realm.model.account.Account;
import org.jmangos.realm.network.netty.handler.R2CChannelHandler;


// TODO: Auto-generated Javadoc
/**
 * The Class AbstractRealmClientPacket.
 *
 * @author Mr. Poke
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
}

