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

public class UNKChunk extends BaseChunk{
	private String ch;
	private int soff;

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.soff = offset;
		this.setByteBuffer(bb, offset);
		return this;	
	}

	public BaseChunk setChunkType(String ch) {
		this.ch = ch;
		return this;
	}
	public String toString(){
		return "[UNKNOWN][ " + ch +" ] OFFSET: " + soff;
	}
}
