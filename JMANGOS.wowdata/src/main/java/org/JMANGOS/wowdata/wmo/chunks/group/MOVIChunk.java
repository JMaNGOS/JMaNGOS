package org.JMANGOS.wowdata.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MOVIChunk extends WMOChunk{
	public Unsigned16[] indecies;		

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		indecies = array(new Unsigned16[(int) (size/2)]);
		return this;	
	}
	public String toString(){
		return "[MOVIChunk] \n\tIndecies count:" + indecies.length;
	}
}
