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
package org.jmangos.tools.wmo.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOPR</tt><br>
 * Portals used in this map.
 * 
 * @author MinimaJack
 * 
 */
public class MOPRChunk extends WMOChunk {
	class MOPREntry extends WMOChunk {
		Unsigned16 portalIndex = new Unsigned16();
		Unsigned16 wmoGroupIndex = new Unsigned16();
		Signed16 side = new Signed16();
		Unsigned16 unknown = new Unsigned16();
	}

	private MOPREntry[] MOPREntries;

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		MOPREntries = new MOPREntry[(int) (size / 8)];
		for (int i = 0; i < (size / 8); i++) {
			MOPREntries[i] = new MOPREntry();
			MOPREntries[i].setByteBuffer(bb, offset + 8 * i);
		}
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;
	}

	@SuppressWarnings("unused")
	private String getAllName() {
		String tmp = "";
		for (int i = 0; i < MOPREntries.length; i++) {
			tmp += "\n\tPortalIndex:" + MOPREntries[i].portalIndex.get()
					+ "\n\tWmoGroupIndex:" + MOPREntries[i].wmoGroupIndex.get()
					+ "\n\tside:" + MOPREntries[i].side.get() + "\n\tunknown:"
					+ MOPREntries[i].unknown.get() + "\n";

		}
		return tmp;
	}

	public String toString() {
		return "[MOPRChunk]" + "\n\tMOPREntries count: " + MOPREntries.length;// +
																				// getAllName();
	}
}
