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
package org.jmangos.tools.adt.chunks;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.root.*;
import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.MVERChunk;
import org.jmangos.tools.chunk.UNKChunk;

public class ADTChunk extends BaseChunk {
	public BaseChunk readChunkByHeader(ByteBuffer bb, int offset) {
		ChunkedTypes ch;
		ADTChunk tch = new ADTChunk();
		tch.setByteBuffer(bb, offset);
		ch = ChunkedTypes.get(tch.chunkType.get());
		switch (ch) {
		case MVER:
			return new MVERChunk().reads(bb, offset, tch.ChunkSize.get());
		case MHDR:
			return new MHDRChunk().reads(bb, offset, tch.ChunkSize.get());
		case MTEX:
			return new MTEXChunk().reads(bb, offset, tch.ChunkSize.get());
		case MMDX:
			return new MMDXChunk().reads(bb, offset, tch.ChunkSize.get());
		case MMID:
			return new MMIDChunk().reads(bb, offset, tch.ChunkSize.get());
		case MWMO:
			return new MWMOChunk().reads(bb, offset, tch.ChunkSize.get());
		case MWID:
			return new MWIDChunk().reads(bb, offset, tch.ChunkSize.get());
		case MCIN:
			return new MCINChunk().reads(bb, offset, tch.ChunkSize.get());
		case MDDF:
			return new MDDFChunk().reads(bb, offset, tch.ChunkSize.get());
		case MODF:
			return new MODFChunk().reads(bb, offset, tch.ChunkSize.get());
		case MH2O:
			return new MH2OChunk().reads(bb, offset, tch.ChunkSize.get());
		case MCNK:
			return new MCNKChunk().reads(bb, offset, tch.ChunkSize.get());
		default:
			return new UNKChunk().setChunkType(ch.toString()).reads(bb, offset, tch.ChunkSize.get());
		}
	}
	public ADTChunk reads(ByteBuffer bb, int offset, int size) {
		return this;
	}
}
