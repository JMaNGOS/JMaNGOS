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
package org.JMANGOS.wowdata.wmo.chunks;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.chunk.MVERChunk;
import org.JMANGOS.wowdata.chunk.UNKChunk;
import org.JMANGOS.wowdata.wmo.chunks.group.*;
import org.JMANGOS.wowdata.wmo.chunks.root.*;


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
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		return this;
	}
}
