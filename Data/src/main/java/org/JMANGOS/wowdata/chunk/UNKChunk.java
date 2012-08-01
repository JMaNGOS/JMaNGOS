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
