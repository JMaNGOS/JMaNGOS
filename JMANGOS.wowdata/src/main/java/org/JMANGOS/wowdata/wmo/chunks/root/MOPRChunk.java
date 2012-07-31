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

public class MOPRChunk extends WMOChunk{
	class MOPREntry extends WMOChunk{ 
		Unsigned16  PortalIndex = new Unsigned16();
		Unsigned16 	WmoGroupIndex = new Unsigned16();
		Signed16 unk = new Signed16(); 		
		Unsigned16 unknown  = new Unsigned16();
	}

	private MOPREntry[] MOPREntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		MOPREntries = new MOPREntry[(int) (size /8)];
		for (int i = 0; i < (size /8); i++) {
			MOPREntries[i] = new MOPREntry();
			MOPREntries[i].setByteBuffer(bb, offset + 8*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	@SuppressWarnings("unused")
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < MOPREntries.length; i++) {
			tmp +="\n\tPortalIndex:" + MOPREntries[i].PortalIndex.get()+
			"\n\tWmoGroupIndex:" + MOPREntries[i].WmoGroupIndex.get()+
			"\n\tunk:" + MOPREntries[i].unk.get()+
			"\n\tunknown:" + MOPREntries[i].unknown.get() + "\n";

		}
		return tmp;
	}
	
	public String toString(){
		return "[MOPRChunk]" + 
		"\n\tMOPREntries count: " + MOPREntries.length ;//+ getAllName(); 
	}
}
