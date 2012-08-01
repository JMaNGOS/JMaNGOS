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
package org.jmangos.commons.network.handlers;


import org.jmangos.commons.network.model.SendablePacket;

import javolution.util.FastMap;
 
public class ServerPacketHandler
{
	
	/** The opcodes. */
	private final FastMap<Class<? extends SendablePacket>, Integer>	opcodes	= new FastMap<Class<? extends SendablePacket>, Integer>();

	/**
	 * Gets the op code.
	 *
	 * @param packetClass the packet class
	 * @return the op code
	 */
	public int getOpCode(SendablePacket packetClass)
	{
		Integer opcode = opcodes.get(packetClass.getClass());
		if (opcode == null)
			throw new IllegalArgumentException("There is no opcode for " + packetClass + " defined.");

		return opcode;
	}

	/**
	 * Adds the packet opcode.
	 *
	 * @param packetPrototype the packet prototype
	 * @param opcode the opcode
	 */
	public void addPacketOpcode(Class<? extends SendablePacket> packetPrototype, int opcode)
	{ 
		if (opcode < 0)
			return;

		if (opcodes.values().contains(opcode))
			throw new IllegalArgumentException(String.format("There already exists another packet with id 0x%02X", opcode));

		opcodes.put(packetPrototype, opcode);
	}
}
