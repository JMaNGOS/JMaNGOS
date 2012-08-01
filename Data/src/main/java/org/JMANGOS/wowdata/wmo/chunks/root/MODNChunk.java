/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.wowdata.wmo.chunks.root;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MODNChunk extends WMOChunk{
	Object[] groupNames;


	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
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
			if( i > 0)
			try {
				tstr.add( decoder.decode(ByteBuffer.wrap(tsring, 0, i)).toString());
			} catch (CharacterCodingException e) {
				e.printStackTrace();
			}
			si = ++reading;
		}
		groupNames =  tstr.toArray();
		return this;	
	}
	
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < groupNames.length; i++) {
			tmp+="\n\t" + groupNames[i] ;
		}
		return tmp;
	}
	public String toString(){
		return "[MODNChunk] \n\t groupNames:" +  groupNames.length + getAllName();
	}
}
