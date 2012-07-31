package org.JMANGOS.wowdata.adt.chunks.root;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.adt.chunks.ADTChunk;

public class MODFChunk extends ADTChunk{
	class MODFEntry extends ADTChunk{ 
		Unsigned32 mwidEntry = new Unsigned32();           
		Unsigned32 uniqueId = new Unsigned32();            
		Float32[] position = array(new Float32[3]);
		Float32[] rotation = array(new Float32[3]);
		Float32[]  lowerBounds = array(new Float32[3]);
		Float32[]  upperBounds = array(new Float32[3]);
		Unsigned16 flags = new Unsigned16();
		Unsigned16 doodadSet = new Unsigned16();
		Unsigned16 nameSet = new Unsigned16();
		Unsigned16 padding = new Unsigned16();
	}
	MODFEntry[] MODFEntries;
	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		this.size = (int) size;
		MODFEntries = new MODFEntry[(int) (size /64)];
		for (int i = 0; i < (size /64); i++) {
			MODFEntries[i] = new MODFEntry();
			MODFEntries[i].setByteBuffer(bb, offset + 64*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	public String toString(){
		return "[MODFChunk] size: " +this.size + 
		"\n MODFEntries count: " + MODFEntries.length; 
	}
	
	public String getStringCoords(Float32[]  position){
		if (this.size > 0)
		return "\n\t" + position[0].get()+"\n\t"+position[1].get()+"\n\t"+position[2].get();
		return "";
	}
}
