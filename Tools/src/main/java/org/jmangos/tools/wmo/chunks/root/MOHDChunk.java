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
import org.jmangos.tools.wmo.chunks.WMOChunk;

/**
 * Chunk <tt>MOHD</tt><br>
 * Header chunk for the map object.
 * 
 * @author MinimaJack
 * 
 */
public class MOHDChunk extends WMOChunk {
	/** Number of materials. */
	Unsigned32 nTextures = new Unsigned32();
	/** Number of WMO groups. */
	Unsigned32 nGroups = new Unsigned32();
	/** Number of portals. */
	Unsigned32 nPortals = new Unsigned32();
	/** Number of lights. */
	Unsigned32 nLights = new Unsigned32();
	/** Number of M2 models. */
	Unsigned32 nModels = new Unsigned32();
	/** Number of doodads */
	Unsigned32 nDoodads = new Unsigned32();
	/** Number of doodad sets. */
	Unsigned32 nDoodadSet = new Unsigned32();
	/** Ambient color. */
	Unsigned8[] col = array(new Unsigned8[4]);
	/** Column 2 in WMOAreaTable.dbc */
	Unsigned32 wmoId = new Unsigned32();
	Float32[] bbox1 = array(new Float32[3]);
	Float32[] bbox2 = array(new Float32[3]);
	Unsigned32 liquidType = new Unsigned32();

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;
	}

	public String toString() {
		return "[MOHDChunk] \n\tnTextures:" + nTextures.get() + "\n\tnGroups:"
				+ nGroups.get() + "\n\tnPortals:" + nPortals.get()
				+ "\n\tnLights:" + nLights.get() + "\n\tnModels:"
				+ nModels.get() + "\n\tnDoodads:" + nDoodads.get()
				+ "\n\tnSets:" + nDoodadSet.get() + "\n\twmoID:" + wmoId.get()
				+ "\n\tBounding box 1:" + bbox1[0].get() + " " + bbox1[1].get()
				+ " " + bbox1[2].get() + "\n\tBounding box 2:" + bbox2[0].get()
				+ " " + bbox2[1].get() + " " + bbox2[2].get()
				+ "\n\tLiquidType:" + liquidType.get();
	}
}
