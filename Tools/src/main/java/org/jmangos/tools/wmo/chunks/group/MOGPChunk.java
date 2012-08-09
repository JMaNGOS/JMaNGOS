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
 * Chunk <tt>MOGP</tt> is root for wmo group
 * 
 * @author MinimaJack
 * 
 */
public class MOGPChunk extends WMOChunk {
	/** Offset into MOGN chunk (root) */
	Unsigned32 groupName = new Unsigned32();
	/** Offset into MOGN chunk (root) */
	Unsigned32 descriptiveGroupName = new Unsigned32();
	Unsigned32 flags = new Unsigned32();
	public Float32[] bbox1 = array(new Float32[3]);
	public Float32[] bbox2 = array(new Float32[3]);
	/** Index in the root WMO file MOPR chunk - Portal */
	Unsigned16 indexMOPR = new Unsigned16();
	Unsigned16 countItemsInMOPR = new Unsigned16();
	Unsigned16 numberBatchA = new Unsigned16();
	Unsigned16 numberBatchB = new Unsigned16();
	Unsigned32 numberBatchC = new Unsigned32();
	Unsigned8[] wmoFogIndecies = array(new Unsigned8[4]);
	Unsigned32 liquidType = new Unsigned32();
	/** column 4 in WMOAreaTable.dbc */
	Unsigned32 wmoGroupId = new Unsigned32();
	Unsigned32 unk0 = new Unsigned32();
	Unsigned32 unk1 = new Unsigned32();
	public MOVIChunk indecies;
	public MOVTChunk vertexes;
	public MOPYChunk material;

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		int glOffset = offset + size();
		while (glOffset < size) {
			BaseChunk ch = new WMOChunk().readChunkByHeader(bb, glOffset);
			if (ch instanceof MOVIChunk) {
				indecies = (MOVIChunk) ch;
			} else if (ch instanceof MOVTChunk) {
				vertexes = (MOVTChunk) ch;
			}
			if (ch instanceof MOPYChunk) {
				material = (MOPYChunk) ch;
			}
			glOffset = ch.getGlobalOffcet();
		}
		return this;
	}

	public String toString() {
		return "[MOGPChunk] \n\tWMOGroupID:" + wmoGroupId.get()
				+ "\n\tBounding box 1:" + bbox1[0].get() + " " + bbox1[1].get()
				+ " " + bbox1[2].get() + "\n\tBounding box 2:" + bbox2[0].get()
				+ " " + bbox2[1].get() + " " + bbox2[2].get();
	}
}
