package org.JMANGOS.wowdata.adt.chunks.root;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;

import org.JMANGOS.wowdata.adt.chunks.ADTChunk;


public class MTEXChunk extends ADTChunk{
	 
	final static int localOffset = new MTEXChunk().size();
	Object[] filename;


	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		byte[] tsring = new byte[2024];
		ArrayList<String> tstr = new ArrayList<String>();
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		int reading = 0;
		int si = 0;
		while( (size - reading) > 0){
			int i = 0;
			for (; (tsring[i] = getByteBuffer().get(
					(int) (offset+ HEADERSIZE  + i + si))) != 0; i++) {
				reading++;
			}
			try {
				tstr.add( decoder.decode(ByteBuffer.wrap(tsring, 0, i)).toString());
			} catch (CharacterCodingException e) {
				e.printStackTrace();
			}
			 si = ++reading;
		}
		filename =  tstr.toArray();
		return this;	
	}
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < filename.length; i++) {
			tmp+="\n" + filename[i] ;
		}
		return tmp;
	}
	public String toString(){
		return "[MTEXChunk] filename: " +  getAllName();
		 
	}

}
