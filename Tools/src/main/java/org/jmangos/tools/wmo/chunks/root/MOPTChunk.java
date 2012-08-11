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
package org.jmangos.tools.wmo.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.chunk.Readable;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOPT</tt><br>
 * Portal information. 
 * 
 * @author MinimaJack
 * 
 */
public class MOPTChunk extends WMOChunk implements Readable {
	class MOPTEntry extends WMOChunk{ 
		Unsigned16  baseVertex = new Unsigned16();
		Unsigned16 	countVert = new Unsigned16();
		Float32[] vector = array(new Float32[3]); 		
		Float32 unknown  = new Float32();
	}

	private MOPTEntry[] MOPTEntries;
	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		MOPTEntries = new MOPTEntry[(int) (size /20)];
		for (int i = 0; i < (size /20); i++) {
			MOPTEntries[i] = new MOPTEntry();
			MOPTEntries[i].setByteBuffer(bb, offset + 20*i);
		}
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	@SuppressWarnings("unused")
	private String getAllName(){
		String tmp = "";
		for (int i = 0; i < MOPTEntries.length; i++) {
			tmp +="\n\tBaseVertex:" + MOPTEntries[i].baseVertex.get()+
			"\n\tcountVert:" + MOPTEntries[i].countVert.get()+
			"\n\tvector:" + MOPTEntries[i].vector[0].get()+ " " +MOPTEntries[i].vector[1].get()+ " " + MOPTEntries[i].vector[2].get()+
			"\n\tunknown:" + MOPTEntries[i].unknown.get();

		}
		return tmp;
	}
	
	public String toString(){
		return "[MOPTChunk]" + 
		"\n\tMOPTEntries count: " + MOPTEntries.length ;//+ getAllName(); 
	}
}
