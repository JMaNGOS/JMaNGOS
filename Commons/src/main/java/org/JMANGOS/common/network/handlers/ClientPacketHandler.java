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
package org.JMANGOS.common.network.handlers;

import javolution.util.FastMap;

import org.JMANGOS.common.network.model.NetworkChannel;
import org.JMANGOS.common.network.model.ReceivablePacket;
import org.JMANGOS.common.network.model.State;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientPacketHandler.
 */
public class ClientPacketHandler {
	
	/** The Constant log. */
	private static final Logger log = Logger
			.getLogger(ClientPacketHandler.class);

	/** The packets prototypes. */
	private final FastMap<State, FastMap<Integer, ReceivablePacket>> packetsPrototypes = new FastMap<State, FastMap<Integer, ReceivablePacket>>();

	/**
	 * Gets the packet.
	 *
	 * @param id the id
	 * @param ch the ch
	 * @return the packet
	 */
	public ReceivablePacket getPacket(int id, NetworkChannel ch) {
		ReceivablePacket prototype = null;
		FastMap<Integer, ReceivablePacket> pm = packetsPrototypes.get(ch
				.getChannelState());

		if (pm != null)
			prototype = pm.get(id);

		if (prototype == null) {
			unknownPacket(ch.getChannelState(), id);
			return null;
		} else {
			ReceivablePacket res = prototype.clonePacket();
			return res;
		}
	}

	/**
	 * Handle.
	 *
	 * @param id the id
	 * @param ch the ch
	 * @return the receivable packet
	 */
	public ReceivablePacket handle(int id, NetworkChannel ch) {
		return getPacket(id, ch);
	}

	/**
	 * Unknown packet.
	 *
	 * @param state the state
	 * @param id the id
	 */
	protected static void unknownPacket(State state, int id) {
		log.warn(String.format(
				"[UNKNOWN PACKET] : received 0x%02X, state=%s %n", id, state
						.toString()));
	}

	/**
	 * Adds the packet opcode.
	 *
	 * @param packetPrototype the packet prototype
	 * @param states the states
	 */
	public void addPacketOpcode(ReceivablePacket packetPrototype, State[] states) {
		for (State state : states) {
			FastMap<Integer, ReceivablePacket> pm = packetsPrototypes
					.get(state);
			if (pm == null) {
				pm = new FastMap<Integer, ReceivablePacket>();
				packetsPrototypes.put(state, pm);
			}
			pm.put(packetPrototype.getOpCode(), packetPrototype);
		}
		
	}
}
