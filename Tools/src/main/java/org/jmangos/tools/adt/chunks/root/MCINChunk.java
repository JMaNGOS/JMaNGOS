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
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

/**
 * Chunk <tt>MCIN</tt><br>
 * Pointers to MCNK chunks and their sizes.
 * 
 * @author MinimaJack
 * 
 */
public class MCINChunk extends ADTChunk {
	class MCINEntry extends ADTChunk {
		/** Offset */
		public final Unsigned32 mcnk = new Unsigned32();
		/** Size */
		public final Unsigned32 size = new Unsigned32();
		public final Unsigned32 flags = new Unsigned32();
		public final Unsigned32 asyncId = new Unsigned32();
	}

	public MCINEntry[] MCINEntrys = new MCINEntry[16 * 16];

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		for (int i = 0; i < 256; i++) {
			MCINEntrys[i] = new MCINEntry();
			MCINEntrys[i].setByteBuffer(bb, offset + 16 * i);
		}
		return this;
	}

	public String getOffsets() {
		String g = "";
		for (int i = 0; i < 16 * 16; i++) {
			g += "\n mcnk:" + MCINEntrys[i].mcnk.get() + " mcnk size:"
					+ MCINEntrys[i].size.get();
		}
		return g;
	}

	public String toString() {
		return "[MCINChunk]" + "\n offsets count: " + MCINEntrys.length;
	}

}
