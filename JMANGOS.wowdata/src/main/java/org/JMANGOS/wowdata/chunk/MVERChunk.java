package org.JMANGOS.wowdata.chunk;

import java.nio.ByteBuffer;

public class MVERChunk extends BaseChunk{
	Unsigned32 Version = new Unsigned32();
	
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	public String toString(){
		return "[MVERChunk] \n\tVersion:" + Version.get();
	}
}
