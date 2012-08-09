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
package org.jmangos.tools.chunk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javolution.io.Struct;

public abstract class BaseChunk extends Struct {

	protected final UTF8String chunkType = new UTF8String(4);
	protected final Signed32 ChunkSize = new Signed32();
	protected int size = 0;
	protected static int HEADERSIZE = 8;
	public int globalOffcet = 0;

	public BaseChunk() {
		super();
	}

	public final int getGlobalOffcet() {
		return globalOffcet;
	}

	public final void setGlobalOffset(int l) {
		this.globalOffcet = l;
	}

	public abstract BaseChunk reads(ByteBuffer bb, int offset, int size);

	public ByteOrder byteOrder() {
		return ByteOrder.LITTLE_ENDIAN;
	}
}
