package org.JMANGOS.wowdata.adt.chunks.root;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.adt.chunks.ADTChunk;

public class MHDRChunk extends ADTChunk{
	 public enum MHDRFlags {  mhdr_MFBO (0),
		    mhdr_northrend (1);
	 	int value;
	 	MHDRFlags(int value){
	 		this.value = value;
	 	}
	 };
	 
	final static int localOffset = new MHDRChunk().size();
		public final Enum32<MHDRFlags>   MHDRflags = new Enum32<MHDRFlags>(MHDRFlags.values());
		Unsigned32 flag = new Unsigned32();
		Unsigned32 mcin = new Unsigned32();
		Unsigned32 mtex = new Unsigned32();
		Unsigned32 mmdx = new Unsigned32();
		Unsigned32 mmid = new Unsigned32();
		Unsigned32 mwmo = new Unsigned32();
		Unsigned32 mwid = new Unsigned32();
		Unsigned32 mddf = new Unsigned32();
		Unsigned32 mfbo;                     // this is only set if flags & mhdr_MFBO.
		Unsigned32 modf;
		
		Unsigned32 mh2o;
		Unsigned32 mtfx;
		Unsigned32 uint32_t;
		Unsigned32 uint32_t2;
		Unsigned32 uint32_t3;
		Unsigned32 uint32_t4;
		Unsigned32 uint32_t5;


	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		if(mfboIn()){
			mfbo = new Unsigned32();
		}
		modf = new Unsigned32();
		mh2o = new Unsigned32();
		mtfx = new Unsigned32();
		uint32_t= new Unsigned32();
		uint32_t2= new Unsigned32();
		uint32_t3= new Unsigned32();
		uint32_t4= new Unsigned32();
		uint32_t5= new Unsigned32();
		return this;	
	}
	
	public String toString(){
		return "[MHDRChunk]" +
		"\n ENUM: " + MHDRflags.get()+ 
		"\n FLAG: " + flag.get()+
		"\n MCIN: " + mcin.get()+
		"\n MTEX: " + mtex.get()+
		"\n MMDX: " + mmdx.get()+
		"\n MMID: " + mmid.get()+
		"\n MWMO: " + mwmo.get()+
		"\n MWID: " + mwid.get()+
		"\n MDDF: " + mddf.get()+
		"\n MODF: " + modf.get()+
		(mfboIn()?("\n MFBO: " + mfbo.get()):"");

	}
	private boolean mfboIn(){
		return (1 & flag.get()) > 0;
	}

}
