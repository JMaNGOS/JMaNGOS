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
package org.jmangos.tools.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.Readable;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOPY</tt><br>
 * Materials for triangles.
 * 
 * @author MinimaJack
 * 
 */
public class MOPYChunk extends WMOChunk implements Readable {
	/**
	 * Single entries of MOPY chunk
	 * 
	 */
	public static class MOPYEntry extends WMOChunk {
		/** some flags */
		private Unsigned8 flags = new Unsigned8();
		/** Index in the root WMO file MOMT chunk. */
		private Unsigned8 materialId = new Unsigned8();

		/**
		 * @return the flags
		 */
		public final Unsigned8 getFlags() {
			return flags;
		}

		/**
		 * @return the materialId
		 */
		public final Unsigned8 getMaterialId() {
			return materialId;
		}
	}

	/** All MOPY entries */
	private MOPYEntry[] aMOPYEntries;

	@Override
	public final BaseChunk reads(final ByteBuffer bb, final int offset,
			final int size) {
		setMOPYEntries(new MOPYEntry[size / 2]);
		for (int i = 0; i < (size / 2); i++) {
			getMOPYEntries()[i] = new MOPYEntry();
			getMOPYEntries()[i].setByteBuffer(bb, offset + 2 * i);
		}
		setGlobalOffset(offset + size + HEADERSIZE);
		setByteBuffer(bb, offset);
		return this;
	}

	/**
	 * @return the mOPYEntries
	 */
	public final MOPYEntry[] getMOPYEntries() {
		return aMOPYEntries;
	}

	/**
	 * @param mOPYEntries
	 *            the mOPYEntries to set
	 */
	public final void setMOPYEntries(final MOPYEntry[] mOPYEntries) {
		aMOPYEntries = mOPYEntries;
	}

	@Override
	public final String toString() {
		return "[MOPYChunk]" + "\n\tMOPYEntries count: "
				+ getMOPYEntries().length;
	}
}
