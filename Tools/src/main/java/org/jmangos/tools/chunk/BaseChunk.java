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

import java.nio.ByteOrder;

import javolution.io.Struct;

/**
 * Class <tt>BaseChunk</tt> base class for all WOW chunks, contains header with
 * chunk type and chunk size
 * 
 * @author MinimaJack
 * 
 */
public abstract class BaseChunk extends Struct {
	/** Chunk type. */
	private final UTF8String chunkType = new UTF8String(4);
	/** Chunk size. */
	private final Signed32 chunkSize = new Signed32();
	/** Header size. */
	protected static final int HEADERSIZE = 8;
	/** Global offset in byte buffer. */
	private int globalOffcet = 0;

	/**
	 * 
	 * @return global offset.
	 */
	public final int getGlobalOffcet() {
		return globalOffcet;
	}

	/**
	 * Set global offset.
	 * 
	 * @param offset
	 *            - global offset
	 */
	public final void setGlobalOffset(final int offset) {
		this.globalOffcet = offset;
	}

	/**
	 * @return the chunkType
	 */
	protected final String getChunkType() {
		return chunkType.get();
	}

	/**
	 * @return size of chunk
	 */
	protected final int getChunkSize() {
		return chunkSize.get();
	}

	/**
	 * Set {@link java.nio.ByteOrder} for structure
	 * 
	 * @return LITTLE_ENDIAN byte order
	 */
	public final ByteOrder byteOrder() {
		return ByteOrder.LITTLE_ENDIAN;
	}
}
