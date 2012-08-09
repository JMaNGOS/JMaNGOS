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
 * Chunk <tt>MOGI</tt><br>
 * Group information for WMO groups.
 * 
 * @author MinimaJack
 * 
 */
public class MOGIChunk extends WMOChunk {
	class MOGIEntry extends WMOChunk {
		Unsigned32 flags = new Unsigned32();
		Float32[] bbox1 = array(new Float32[3]);
		Float32[] bbox2 = array(new Float32[3]);
		/** Index of name in MOGN chunk */
		Signed32 name = new Signed32();
	}

	private MOGIEntry[] MOGIEntries;

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		MOGIEntries = new MOGIEntry[(int) (size / 32)];
		for (int i = 0; i < (size / 32); i++) {
			MOGIEntries[i] = new MOGIEntry();
			MOGIEntries[i].setByteBuffer(bb, offset + 32 * i);
		}
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;
	}

	@SuppressWarnings("unused")
	private String getAllName() {
		String tmp = "";
		for (int i = 0; i < MOGIEntries.length; i++) {
			tmp += "\n\tFlags:" + MOGIEntries[i].flags.get()
					+ "\n\tBounding box 1:" + MOGIEntries[i].bbox1[0].get()
					+ " " + MOGIEntries[i].bbox1[1].get() + " "
					+ MOGIEntries[i].bbox1[2].get() + "\n\tBounding box 2:"
					+ MOGIEntries[i].bbox2[0].get() + " "
					+ MOGIEntries[i].bbox2[1].get() + " "
					+ MOGIEntries[i].bbox2[2].get() + "\n\tname or index:"
					+ MOGIEntries[i].name.get();

		}
		return tmp;
	}

	public String toString() {
		return "[MOGIChunk] \n\tMOGIEntries count: " + MOGIEntries.length;
		// getAllName();
	}
}
