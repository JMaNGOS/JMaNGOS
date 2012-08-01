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

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MOGIChunk extends WMOChunk{
	class MOGIEntry extends WMOChunk{ 
		Unsigned32 Flags = new Unsigned32();   		
		Float32[] bbox1 = array(new Float32[3]); 		
		Float32[] bbox2 = array(new Float32[3]); 		
		Signed32 name  = new Signed32();
	}
	private MOGIEntry[] MOGIEntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		MOGIEntries = new MOGIEntry[(int) (size /32)];
		for (int i = 0; i < (size /32); i++) {
			MOGIEntries[i] = new MOGIEntry();
			MOGIEntries[i].setByteBuffer(bb, offset + 32*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;
	}
	@SuppressWarnings("unused")
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < MOGIEntries.length; i++) {
			tmp +="\n\tFlags:" + MOGIEntries[i].Flags.get()+
			"\n\tBounding box 1:" + MOGIEntries[i].bbox1[0].get()+ " " +MOGIEntries[i].bbox1[1].get()+ " " + MOGIEntries[i].bbox1[2].get()+
			"\n\tBounding box 2:" + MOGIEntries[i].bbox2[0].get()+ " " +MOGIEntries[i].bbox2[1].get()+ " " + MOGIEntries[i].bbox2[2].get()+
			"\n\tname or index:" + MOGIEntries[i].name.get();

		}
		return tmp;
	}
	public String toString(){
		return "[MOGIChunk] \n\tMOGIEntries count: " + MOGIEntries.length; 
		//getAllName();
	}
}
