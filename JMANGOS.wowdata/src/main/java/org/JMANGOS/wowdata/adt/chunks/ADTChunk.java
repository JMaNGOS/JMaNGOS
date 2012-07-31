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
package org.JMANGOS.wowdata.adt.chunks;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.adt.chunks.root.*;
import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.chunk.MVERChunk;
import org.JMANGOS.wowdata.chunk.UNKChunk;

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
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		return this;
	}
}
