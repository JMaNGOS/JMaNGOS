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

public class MOMTChunk extends WMOChunk{
	class MOMTEntry extends WMOChunk{ 
		/*000h*/  Unsigned32 flags1 = new Unsigned32();   		
		/*004h*/  Unsigned32 SpecularMode = new Unsigned32();
		/*008h*/  Unsigned32 blendMode = new Unsigned32();
		/*00Ch*/  Unsigned32 texture_1 = new Unsigned32();	
		/*010h*/  Unsigned32 color_1 = new Unsigned32(); 
		/*014h*/  Unsigned32 flags_1 = new Unsigned32();
		/*018h*/  Unsigned32 texture_2 = new Unsigned32();	
		/*01Ch*/  Unsigned32 color_2 = new Unsigned32();
		/*020h*/  Unsigned32 flags_2 = new Unsigned32();
		/*024h*/  Unsigned32 color_3 = new Unsigned32(); 	
		/*028h*/  Unsigned32[] unk = array( new Unsigned32[4]);
		/*02Ch*/  Float32[] diffColor = array(new Float32[3]); 		
		/*030h*/  Unsigned32[] runTimeData= array(new Unsigned32[4]);
		/*034h*/  Unsigned32 unk1 = new Unsigned32();		
		/*038h*/  Unsigned32 unk2 = new Unsigned32();
		/*03Ch*/  Unsigned32 unk3 = new Unsigned32();
		/*040h*/  Unsigned32 unk4 = new Unsigned32();
	}

	private MOMTEntry[] MOMTEntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		MOMTEntries = new MOMTEntry[(int) (size /64)];
		for (int i = 0; i < (size /64); i++) {
			MOMTEntries[i] = new MOMTEntry();
			MOMTEntries[i].setByteBuffer(bb, offset + 64*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	public String toString(){
		return "[MOMTChunk]" + 
		"\n\tMOMTEntries count: " + MOMTEntries.length; 
	}
}
