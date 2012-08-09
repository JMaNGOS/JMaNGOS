/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MODFChunk extends ADTChunk{
	class MODFEntry extends ADTChunk{ 
		Unsigned32 mwidEntry = new Unsigned32();           
		Unsigned32 uniqueId = new Unsigned32();            
		Float32[] position = array(new Float32[3]);
		Float32[] rotation = array(new Float32[3]);
		Float32[]  lowerBounds = array(new Float32[3]);
		Float32[]  upperBounds = array(new Float32[3]);
		Unsigned16 flags = new Unsigned16();
		Unsigned16 doodadSet = new Unsigned16();
		Unsigned16 nameSet = new Unsigned16();
		Unsigned16 padding = new Unsigned16();
	}
	MODFEntry[] MODFEntries;
	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, int size) {
		this.size = (int) size;
		MODFEntries = new MODFEntry[(int) (size /64)];
		for (int i = 0; i < (size /64); i++) {
			MODFEntries[i] = new MODFEntry();
			MODFEntries[i].setByteBuffer(bb, offset + 64*i);
		}
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	public String toString(){
		return "[MODFChunk] size: " +this.size + 
		"\n MODFEntries count: " + MODFEntries.length; 
	}
	
	public String getStringCoords(Float32[]  position){
		if (this.size > 0)
		return "\n\t" + position[0].get()+"\n\t"+position[1].get()+"\n\t"+position[2].get();
		return "";
	}
}
