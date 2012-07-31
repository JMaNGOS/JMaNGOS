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
package org.JMANGOS.wowdata.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.chunk.BaseChunk;
import org.JMANGOS.wowdata.wmo.chunks.WMOChunk;

public class MOPYChunk extends WMOChunk{
	public class MOPYEntry extends WMOChunk{ 
		public Unsigned8 	Flags = new Unsigned8();
		public Unsigned8		Material  = new Unsigned8();
	}

	public MOPYEntry[] MOPYEntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		MOPYEntries = new MOPYEntry[(int) (size /2)];
		for (int i = 0; i < (size /2); i++) {
			MOPYEntries[i] = new MOPYEntry();
			MOPYEntries[i].setByteBuffer(bb, offset + 2*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	@SuppressWarnings("unused")
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < MOPYEntries.length; i++) {
			tmp +="\n\tFlags:" + MOPYEntries[i].Flags.get()+
			"\n\tMaterial:" + MOPYEntries[i].Material.get() + "\n";

		}
		return tmp;
	}
	
	public String toString(){
		return "[MOPYChunk]" + 
		"\n\tMOPYEntries count: " + MOPYEntries.length ;//+ getAllName(); 
	}
}
