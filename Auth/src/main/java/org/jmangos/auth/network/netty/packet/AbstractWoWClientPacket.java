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
package org.jmangos.auth.network.netty.packet;

import org.jmangos.auth.model.Account;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;


// TODO: Auto-generated Javadoc
/**
 * The Class AbstractWoWClientPacket.
 *
 * @author Mr. Poke
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
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount(){ 
		return (Account)((NettyNetworkChannel) _client).getChanneledObject();
	}
}

