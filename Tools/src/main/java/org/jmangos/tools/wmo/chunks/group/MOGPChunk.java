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
import org.jmangos.tools.chunk.Readable;
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOGP</tt> is root for wmo group
 * 
 * @author MinimaJack
 * 
 */
public class MOGPChunk extends WMOChunk implements Readable {
	/** Define count coordinates in dimensions. */
	private static final int DIMENSION = 3;
	/** Count indices in WMO fog list. */
	private static final int COUNT_WMOFOG_INDICES = 4;
	/** Offset into MOGN chunk (root). */
	private Unsigned32 groupName = new Unsigned32();
	/** Offset into MOGN chunk (root). */
	private Unsigned32 descriptiveGroupName = new Unsigned32();
	/** Contain more information than flags in MOGI. */
	private Unsigned32 flags = new Unsigned32();
	/** Bounding box 1 corner. */
	private Float32[] bbox1 = array(new Float32[DIMENSION]);
	/** Bounding box 2 corner. */
	private Float32[] bbox2 = array(new Float32[DIMENSION]);
	/** Index in the root WMO file MOPR chunk - Portal. */
	private Unsigned16 indexMOPR = new Unsigned16();
	/** Number of items used from the MOPR chunk. */
	private Unsigned16 countItemsInMOPR = new Unsigned16();
	/** Count batches or lod A. */
	private Unsigned16 numberBatchA = new Unsigned16();
	/** Count batches or lod B. */
	private Unsigned16 numberBatchB = new Unsigned16();
	/** Count batches or lod C. */
	private Unsigned32 numberBatchC = new Unsigned32();
	/** Four indices into the WMO fog list. */
	private Unsigned8[] wmoFogIndecies = array(new Unsigned8[COUNT_WMOFOG_INDICES]);
	/** LiquidType related. */
	private Unsigned32 liquidType = new Unsigned32();
	/** Column 4 in WMOAreaTable.dbc */
	private Unsigned32 wmoGroupId = new Unsigned32();
	/** Unknown data */
	private Unsigned32 unk0 = new Unsigned32();
	/** Unknown data */
	private Unsigned32 unk1 = new Unsigned32();
	/** Indices */
	private MOVIChunk indices;
	/** Vertices */
	private MOVTChunk vertices;
	/** Material */
	private MOPYChunk material;

	@Override
	public final BaseChunk reads(final ByteBuffer bb, final int offset,
			final int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		int glOffset = offset + size();
		while (glOffset < size) {
			BaseChunk ch = WMOChunk.readChunkByHeader(bb, glOffset);
			if (ch instanceof MOVIChunk) {
				indices = (MOVIChunk) ch;
			} else if (ch instanceof MOVTChunk) {
				vertices = (MOVTChunk) ch;
			}
			if (ch instanceof MOPYChunk) {
				material = (MOPYChunk) ch;
			}
			glOffset = ch.getGlobalOffcet();
		}
		return this;
	}

	/**
	 * @return the groupName
	 */
	public final Unsigned32 getGroupName() {
		return groupName;
	}

	/**
	 * @return the descriptiveGroupName
	 */
	public final Unsigned32 getDescriptiveGroupName() {
		return descriptiveGroupName;
	}

	/**
	 * @return the flags
	 */
	public final Unsigned32 getFlags() {
		return flags;
	}

	/**
	 * @return the bounding box 1
	 */
	public final Float32[] getBbox1() {
		return bbox1;
	}

	/**
	 * @return the bounding box 2
	 */
	public final Float32[] getBbox2() {
		return bbox2;
	}

	/**
	 * @return the indexMOPR
	 */
	public final Unsigned16 getIndexMOPR() {
		return indexMOPR;
	}

	/**
	 * @return the numberBatchA
	 */
	public final Unsigned16 getNumberBatchA() {
		return numberBatchA;
	}

	/**
	 * @return the numberBatchB
	 */
	public final Unsigned16 getNumberBatchB() {
		return numberBatchB;
	}

	/**
	 * @return the numberBatchC
	 */
	public final Unsigned32 getNumberBatchC() {
		return numberBatchC;
	}

	/**
	 * @return the wmoFogIndecies
	 */
	public final Unsigned8[] getWmoFogIndecies() {
		return wmoFogIndecies;
	}

	/**
	 * @return the liquidType
	 */
	public final Unsigned32 getLiquidType() {
		return liquidType;
	}

	/**
	 * @return the wmoGroupId
	 */
	public final Unsigned32 getWmoGroupId() {
		return wmoGroupId;
	}

	/**
	 * @return the indecies
	 */
	public final MOVIChunk getIndecies() {
		return indices;
	}

	/**
	 * @return the vertexes
	 */
	public final MOVTChunk getVertexes() {
		return vertices;
	}

	/**
	 * @return the material
	 */
	public final MOPYChunk getMaterial() {
		return material;
	}

	/**
	 * @return the countItemsInMOPR
	 */
	public final Unsigned16 getCountItemsInMOPR() {
		return countItemsInMOPR;
	}

	/**
	 * @return the unk0
	 */
	public final Unsigned32 getUnk0() {
		return unk0;
	}

	/**
	 * @return the unk1
	 */
	public final Unsigned32 getUnk1() {
		return unk1;
	}

	@Override
	public final String toString() {
		return "[MOGPChunk] \n\tWMOGroupID:" + wmoGroupId.get()
				+ "\n\tBounding box 1:" + bbox1[0].get() + " " + bbox1[1].get()
				+ " " + bbox1[2].get() + "\n\tBounding box 2:" + bbox2[0].get()
				+ " " + bbox2[1].get() + " " + bbox2[2].get();
	}
}
