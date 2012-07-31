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
package org.JMANGOS.wowdata.chunk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javolution.io.Struct;

public abstract class BaseChunk extends Struct {

	protected final UTF8String chunkType = new UTF8String(4);
	protected final Unsigned32 ChunkSize = new Unsigned32();
	protected int size = 0;
	protected static int HEADERSIZE = 8;
	public int globalOffcet = 0;

	public BaseChunk() {
		super();
	}

	public final int getGlobalOffcet() {
		return globalOffcet;
	}

	public final void setGlobalOffcet(long l) {
		this.globalOffcet = (int) l;
	}

	public abstract BaseChunk reads(ByteBuffer bb, int offset, long size);

	public ByteOrder byteOrder() {
		return ByteOrder.LITTLE_ENDIAN;
	}

}
