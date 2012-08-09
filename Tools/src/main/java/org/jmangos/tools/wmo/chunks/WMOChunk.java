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
package org.jmangos.tools.wmo.chunks;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.MVERChunk;
import org.jmangos.tools.chunk.UNKChunk;
import org.jmangos.tools.wmo.chunks.group.*;
import org.jmangos.tools.wmo.chunks.root.*;


public class WMOChunk extends BaseChunk {
	public BaseChunk readChunkByHeader(ByteBuffer bb, int offset) {
		ChunkedTypes ch;
		WMOChunk tch = new WMOChunk();
		tch.setByteBuffer(bb, offset);
		ch = ChunkedTypes.get(tch.chunkType.get());
		if(ch != null)
		switch (ch) {
		case MVER:
			return new MVERChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOHD:
			return new MOHDChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOMT:
			return new MOMTChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOGN:
			return new MOGNChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOGI:
			return new MOGIChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOPV:
			return new MOPYChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOPT:
			return new MOPTChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOPR:
			return new MOPRChunk().reads(bb, offset, tch.ChunkSize.get());
		case MODS:
			return new MODSChunk().reads(bb, offset, tch.ChunkSize.get());
		case MODN:
			return new MODNChunk().reads(bb, offset, tch.ChunkSize.get());
		case MODD:
			return new MODDChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOGP:
			return new MOGPChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOPY:
			return new MOPYChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOVI:
			return new MOVIChunk().reads(bb, offset, tch.ChunkSize.get());
		case MOVT:
			return new MOVTChunk().reads(bb, offset, tch.ChunkSize.get());
		case MONR:
			return new MONRChunk().reads(bb, offset, tch.ChunkSize.get());
		default:
			return new UNKChunk().setChunkType(ch.toString()).reads(bb, offset, tch.ChunkSize.get());
		}
		return new UNKChunk().reads(bb, offset, tch.ChunkSize.get()); 
	}

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		return this;
	}
}
