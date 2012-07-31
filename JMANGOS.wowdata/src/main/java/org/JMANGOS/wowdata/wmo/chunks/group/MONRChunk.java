package org.JMANGOS.wowdata.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MONRChunk extends WMOChunk{
	Float32[] normals;		

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		normals = array(new Float32[(int) (size/4)]);
		return this;	
	}
	public String toString(){
		return "[MONRChunk] \n\tNormals count:" + normals.length;
	}
}
