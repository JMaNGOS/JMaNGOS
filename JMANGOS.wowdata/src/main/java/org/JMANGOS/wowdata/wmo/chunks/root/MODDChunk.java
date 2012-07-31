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

public class MODDChunk extends WMOChunk{
	class MODDEntry extends WMOChunk{ 
		Unsigned32 OffsetModelName = new Unsigned32();   		
		Float32[] position = array(new Float32[3]);
		Float32[] quaternion = array(new Float32[3]);
		Float32 quaternionW = new Float32();
		Float32 Scale = new Float32();
		Unsigned8 colR = new Unsigned8();				
		Unsigned8 colG = new Unsigned8();			
		Unsigned8 colB = new Unsigned8();				
		Unsigned8 colX = new Unsigned8();					

	}

	private MODDEntry[] MODDEntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		MODDEntries = new MODDEntry[(int) (size /40)];
		for (int i = 0; i < (size /40); i++) {
			MODDEntries[i] = new MODDEntry();
			MODDEntries[i].setByteBuffer(bb, offset + 40*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	public String toString(){
		return "[MODDChunk]" + 
		"\n\tMODDEntries count: " + MODDEntries.length; 
	}
}
