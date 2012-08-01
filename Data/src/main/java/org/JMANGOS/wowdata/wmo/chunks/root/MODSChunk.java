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

public class MODSChunk extends WMOChunk{
	class MODSEntry extends WMOChunk{ 
		UTF8String  setName = new UTF8String(20);
		Unsigned32 	Index = new Unsigned32();
		Unsigned32 countInSet = new Unsigned32(); 		
		Unsigned32 unknown  = new Unsigned32();
	}

	private MODSEntry[] MODSEntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		MODSEntries = new MODSEntry[(int) (size /32)];
		for (int i = 0; i < (size /32); i++) {
			MODSEntries[i] = new MODSEntry();
			MODSEntries[i].setByteBuffer(bb, offset + 32*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	@SuppressWarnings("unused")
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < MODSEntries.length; i++) {
			tmp +="\n\tsetName:" + MODSEntries[i].setName.get()+
			"\n\tFirstIndex:" + MODSEntries[i].Index.get()+
			"\n\tcountInSet:" + MODSEntries[i].countInSet.get()+
			"\n\tunknown:" + MODSEntries[i].unknown.get() + "\n";

		}
		return tmp;
	}
	
	public String toString(){
		return "[MODSChunk]" + 
		"\n\tMODSEntries count: " + MODSEntries.length;// + getAllName(); 
	}
}
