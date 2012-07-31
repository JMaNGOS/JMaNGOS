package org.JMANGOS.wowdata.wmo.chunks.root;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MOPVChunk extends WMOChunk{
	Float32[] vertices;		

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		vertices = array(new Float32[(int) (size/4)]);
		return this;	
	}
	public String toString(){
		return "[MOPVChunk] \n\tVertices count:" + vertices.length;
	}
}
