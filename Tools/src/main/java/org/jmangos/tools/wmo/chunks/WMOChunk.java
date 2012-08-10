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
import org.jmangos.tools.wmo.chunks.group.MOGPChunk;
import org.jmangos.tools.wmo.chunks.group.MONRChunk;
import org.jmangos.tools.wmo.chunks.group.MOPYChunk;
import org.jmangos.tools.wmo.chunks.group.MOVIChunk;
import org.jmangos.tools.wmo.chunks.group.MOVTChunk;
import org.jmangos.tools.wmo.chunks.root.MODDChunk;
import org.jmangos.tools.wmo.chunks.root.MODNChunk;
import org.jmangos.tools.wmo.chunks.root.MODSChunk;
import org.jmangos.tools.wmo.chunks.root.MOGIChunk;
import org.jmangos.tools.wmo.chunks.root.MOGNChunk;
import org.jmangos.tools.wmo.chunks.root.MOHDChunk;
import org.jmangos.tools.wmo.chunks.root.MOMTChunk;
import org.jmangos.tools.wmo.chunks.root.MOPRChunk;
import org.jmangos.tools.wmo.chunks.root.MOPTChunk;

/**
 * Class <tt>WMOChunk</tt> allow read multiple chunks by chunk type.
 * 
 * @author MinimaJack
 * 
 */
public class WMOChunk extends BaseChunk {
	/**
	 * 
	 * @param bb
	 *            set current byte buffer for read.
	 * @param offset
	 *            of the chunk
	 * @return chunk by type or {@link UNKChunk}
	 */
	public static final BaseChunk readChunkByHeader(final ByteBuffer bb,
			final int offset) {
		ChunkedTypes ch;
		WMOChunk tch = new WMOChunk();
		tch.setByteBuffer(bb, offset);
		ch = ChunkedTypes.get(tch.getChunkType());
		int chunkSize = tch.getChunkSize();
		if (ch != null) {
			switch (ch) {
			case MVER:
				return new MVERChunk().reads(bb, offset, chunkSize);
			case MOHD:
				return new MOHDChunk().reads(bb, offset, chunkSize);
			case MOMT:
				return new MOMTChunk().reads(bb, offset, chunkSize);
			case MOGN:
				return new MOGNChunk().reads(bb, offset, chunkSize);
			case MOGI:
				return new MOGIChunk().reads(bb, offset, chunkSize);
			case MOPV:
				return new MOPYChunk().reads(bb, offset, chunkSize);
			case MOPT:
				return new MOPTChunk().reads(bb, offset, chunkSize);
			case MOPR:
				return new MOPRChunk().reads(bb, offset, chunkSize);
			case MODS:
				return new MODSChunk().reads(bb, offset, chunkSize);
			case MODN:
				return new MODNChunk().reads(bb, offset, chunkSize);
			case MODD:
				return new MODDChunk().reads(bb, offset, chunkSize);
			case MOGP:
				return new MOGPChunk().reads(bb, offset, chunkSize);
			case MOPY:
				return new MOPYChunk().reads(bb, offset, chunkSize);
			case MOVI:
				return new MOVIChunk().reads(bb, offset, chunkSize);
			case MOVT:
				return new MOVTChunk().reads(bb, offset, chunkSize);
			case MONR:
				return new MONRChunk().reads(bb, offset, chunkSize);
			default:
				UNKChunk uCh = new UNKChunk();
				uCh.setChunkType(ch.toString());
				uCh.reads(bb, offset, chunkSize);
				return uCh;
			}
		}
		return new UNKChunk().reads(bb, offset, chunkSize);
	}
}
