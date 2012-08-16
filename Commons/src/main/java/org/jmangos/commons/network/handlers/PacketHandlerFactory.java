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
package org.jmangos.commons.network.handlers;

import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.commons.network.model.SendablePacket;
import org.jmangos.commons.network.model.State;

/**
 * A factory for creating PacketHandler objects.
 */
public interface PacketHandlerFactory {
    
    /**
     * Adds the packet.
     * 
     * @param packetPrototype
     *            the packet prototype
     * @param states
     *            the states
     */
    public void addPacket(ReceivablePacket packetPrototype, State... states);
    
    /**
     * Adds the packet.
     * 
     * @param packetPrototype
     *            the packet prototype
     * @param opcode
     *            the opcode
     */
    public void addPacket(Class<? extends SendablePacket> packetPrototype, int opcode);
    
    /**
     * Gets the server packetop code.
     * 
     * @param packetClass
     *            the packet class
     * @return the server packetop code
     */
    public int getServerPacketopCode(SendablePacket packetClass);
    
    /**
     * Handle client packet.
     * 
     * @param id
     *            the id
     * @param ch
     *            the ch
     * @return the receivable packet
     */
    public ReceivablePacket handleClientPacket(int id, NetworkChannel ch);
    
    /**
     * Load packet.
     * 
     */
    public void loadPacket();
}
