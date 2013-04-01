/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.network.handlers;

import javolution.util.FastMap;

import org.jmangos.commons.network.model.SendablePacket;

public class ServerPacketHandler {

    /** The opcodes. */
    private final FastMap<Class<? extends SendablePacket>, Integer> opcodes =
            new FastMap<Class<? extends SendablePacket>, Integer>();

    /**
     * Gets the op code.
     * 
     * @param packetClass
     *        the packet class
     * @return the op code
     */
    @SuppressWarnings("deprecation")
    public int getOpCode(final SendablePacket packetClass) {

        Integer opcode = this.opcodes.get(packetClass.getClass());
        if (opcode == null) {
            if (packetClass.getOpcode() == null) {
                throw new IllegalArgumentException("There is no opcode for " +
                    packetClass +
                    " defined.");
            } else {
                opcode = packetClass.getOpcode();
            }
        }

        return opcode;
    }

    /**
     * Adds the packet opcode.
     * 
     * @param packetPrototype
     *        the packet prototype
     * @param opcode
     *        the opcode
     */
    public void addPacketOpcode(final Class<? extends SendablePacket> packetPrototype,
            final int opcode) {

        if (opcode < 0) {
            return;
        }

        if (this.opcodes.values().contains(opcode)) {
            throw new IllegalArgumentException(String.format(
                    "There already exists another packet with id 0x%02X", opcode));
        }

        this.opcodes.put(packetPrototype, opcode);
    }
}
