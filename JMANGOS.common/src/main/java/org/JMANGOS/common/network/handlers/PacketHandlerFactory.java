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
package org.JMANGOS.common.network.handlers;

import org.JMANGOS.common.network.model.*;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating PacketHandler objects.
 */
public interface PacketHandlerFactory
{

	/**
	 * Adds the packet.
	 *
	 * @param packetPrototype the packet prototype
	 * @param states the states
	 */
	public void addPacket(ReceivablePacket packetPrototype, State... states);
	
	/**
	 * Adds the packet.
	 *
	 * @param packetPrototype the packet prototype
	 * @param opcode the opcode
	 */
	public void addPacket(Class<? extends SendablePacket> packetPrototype,
			int opcode);

	/**
	 * Gets the server packetop code.
	 *
	 * @param packetClass the packet class
	 * @return the server packetop code
	 */
	public int getServerPacketopCode(SendablePacket packetClass);

	/**
	 * Handle client packet.
	 *
	 * @param id the id
	 * @param ch the ch
	 * @return the receivable packet
	 */
	public ReceivablePacket handleClientPacket(int id, NetworkChannel ch);
}
