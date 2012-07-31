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
