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
package org.jmangos.tools.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOVI</tt><br> 
 * Contains Vertex indices.
 * 
 * @author MinimaJack
 *
 */
public class MOVIChunk extends WMOChunk{
	public Unsigned16[] indecies;		

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		indecies = array(new Unsigned16[size/2]);
		return this;	
	}
	public String toString(){
		return "[MOVIChunk] \n\tIndecies count:" + indecies.length;
	}
}
