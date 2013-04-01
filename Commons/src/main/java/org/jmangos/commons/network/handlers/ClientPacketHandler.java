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

import org.jmangos.commons.OpcodeTable;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.commons.network.model.ReceivablePacket;
import org.jmangos.commons.network.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientPacketHandler.
 */
public class ClientPacketHandler {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(ClientPacketHandler.class);

    /** The packets prototypes. */
    private final FastMap<State, FastMap<Integer, ReceivablePacket>> packetsPrototypes =
            new FastMap<State, FastMap<Integer, ReceivablePacket>>();

    /**
     * Gets the packet.
     * 
     * @param id
     *        the id
     * @param ch
     *        the ch
     * @return the packet
     */
    public ReceivablePacket getPacket(final int id, final NetworkChannel ch) {

        ReceivablePacket prototype = null;
        final FastMap<Integer, ReceivablePacket> pm =
                this.packetsPrototypes.get(ch.getChannelState());

        if (pm != null) {
            prototype = pm.get(id);
        }

        if (prototype == null) {
            unknownPacket(ch.getChannelState(), id);
            return null;
        } else {
            final ReceivablePacket res = prototype.clonePacket();
            return res;
        }
    }

    /**
     * Handle.
     * 
     * @param id
     *        the id
     * @param ch
     *        the ch
     * @return the receivable packet
     */
    public ReceivablePacket handle(final int id, final NetworkChannel ch) {

        return getPacket(id, ch);
    }

    /**
     * Unknown packet.
     * 
     * @param state
     *        the state
     * @param id
     *        the id
     */
    protected static void unknownPacket(final State state, final int id) {

        log.warn(String.format("[UNKNOWN PACKET] : received 0x%03X, state=%s %n", id,
                state.toString()));

        if (OpcodeTable.getOpcode(id) != null) {
            log.warn(String.format("Maybe this packet is unimplemented: " +
                OpcodeTable.getOpcode(id)));
        }
    }

    /**
     * Adds the packet opcode.
     * 
     * @param packetPrototype
     *        the packet prototype
     * @param states
     *        the states
     */
    public void addPacketOpcode(final ReceivablePacket packetPrototype, final State[] states) {

        for (final State state : states) {
            FastMap<Integer, ReceivablePacket> pm = this.packetsPrototypes.get(state);
            if (pm == null) {
                pm = new FastMap<Integer, ReceivablePacket>();
                this.packetsPrototypes.put(state, pm);
            }
            pm.put(packetPrototype.getOpCode(), packetPrototype);
        }

    }
}
