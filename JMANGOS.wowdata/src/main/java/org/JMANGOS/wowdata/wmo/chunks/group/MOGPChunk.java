package org.JMANGOS.wowdata.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MOGPChunk extends WMOChunk{
	Unsigned32	Groupname = new Unsigned32(); 
	Unsigned32	DescriptiveGroupName = new Unsigned32(); 
	Unsigned32	Flags = new Unsigned32(); 
	public Float32[] bbox1 = array(new Float32[3]); 		
	public Float32[] bbox2 = array(new Float32[3]); 		
	Unsigned16	IndexMOPR = new Unsigned16(); 
	Unsigned16	CountItems = new Unsigned16(); 
	Unsigned16	NumberBatchA = new Unsigned16(); 
	Unsigned16	NumberBatchB = new Unsigned16(); 
	Unsigned32	NumberBatchC = new Unsigned32(); 
	Unsigned8[]	WmoFogIndecies = array(new Unsigned8[4]);
	Unsigned32	LiquidType = new Unsigned32(); 
	Unsigned32	WMOGroupID = new Unsigned32(); 
	Unsigned32	unk0  = new Unsigned32(); 
	Unsigned32	unk1 = new Unsigned32();
	public MOVIChunk indecies;
	public MOVTChunk vertexes;
	public MOPYChunk material; 
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		int glOffset = offset+size();
		while (glOffset < size) {
			BaseChunk ch = new WMOChunk().readChunkByHeader(bb,glOffset);
			if (ch instanceof MOVIChunk){
				indecies = (MOVIChunk) ch;
			}else if (ch instanceof MOVTChunk){
				vertexes = (MOVTChunk) ch;
			} if (ch instanceof MOPYChunk){
				material = (MOPYChunk) ch;
			}
			glOffset = ch.getGlobalOffcet();
		}
		return this;	
	}
	public String toString(){
		return "[MOGPChunk] \n\tWMOGroupID:"+ WMOGroupID.get() + 
		"\n\tBounding box 1:" + bbox1[0].get()+ " " +bbox1[1].get()+ " " + bbox1[2].get()+
		"\n\tBounding box 2:" + bbox2[0].get()+ " " +bbox2[1].get()+ " " + bbox2[2].get();
	}
}
