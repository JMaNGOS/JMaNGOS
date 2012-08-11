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
import org.jmangos.tools.chunk.Readable;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MODD</tt><br>
 * Contains information for doodad instances.
 * 
 * @author MinimaJack
 * 
 */
public class MODDChunk extends WMOChunk implements Readable {
	class MODDEntry extends WMOChunk {
		/** Offset into MODN chunk (root) */
		Unsigned32 offsetModelName = new Unsigned32();
		/** Position (X,Z,-Y) */
		Float32[] position = array(new Float32[3]);
		/** Quaternion (X, Y, Z, W) */
		Float32[] quaternion = array(new Float32[4]);
		/** The scale factor */
		Float32 Scale = new Float32();
		/** (B,G,R,A) Lightning */
		Unsigned8[] col = array(new Unsigned8[4]);
	}

	private MODDEntry[] MODDEntries;

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		MODDEntries = new MODDEntry[size / 40];
		for (int i = 0; i < (size / 40); i++) {
			MODDEntries[i] = new MODDEntry();
			MODDEntries[i].setByteBuffer(bb, offset + 40 * i);
		}
		setGlobalOffset(offset + size + HEADERSIZE);
		setByteBuffer(bb, offset);
		return this;
	}

	public String toString() {
		return "[MODDChunk]" + "\n\tMODDEntries count: " + MODDEntries.length;
	}
}
