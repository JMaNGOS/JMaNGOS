package org.JMANGOS.wowdata.adt.chunks.root;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.adt.chunks.ADTChunk;

public class MWIDChunk extends ADTChunk{
	public Unsigned32[] offset;

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		this.offset = array(new Unsigned32[(int) (size/4)]);
		return this;	
	}
	
	public String toString(){
		return "[MWIDChunk]" +
		"\n offsets count: " + offset.length; 
	}

}
