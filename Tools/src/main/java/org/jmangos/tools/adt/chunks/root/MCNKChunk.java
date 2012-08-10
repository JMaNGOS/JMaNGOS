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

/**
 * Chunk <tt>MCNK</tt><br>
 * Pointers to MCNK chunks and their sizes.
 * 
 * @author MinimaJack
 * 
 */
public class MCNKChunk extends ADTChunk {
	private int fullSize = 0;

	public class MCNKHeader extends ADTChunk {
		public MCVT fHeight;
		public final Unsigned32 flags = new Unsigned32();
		public final Unsigned32 IndexX = new Unsigned32();
		public final Unsigned32 IndexY = new Unsigned32();
		public final Unsigned32 nLayers = new Unsigned32();
		public final Unsigned32 nDoodadRefs = new Unsigned32();
		public final Unsigned32 ofsHeight = new Unsigned32();
		public final Unsigned32 ofsNormal = new Unsigned32();
		public final Unsigned32 ofsLayer = new Unsigned32();
		public final Unsigned32 ofsRefs = new Unsigned32();
		public final Unsigned32 ofsAlpha = new Unsigned32();
		public final Unsigned32 sizeAlpha = new Unsigned32();
		public final Unsigned32 ofsShadow = new Unsigned32();
		public final Unsigned32 sizeShadow = new Unsigned32();
		public final Unsigned32 areaid = new Unsigned32();
		public final Unsigned32 nMapObjRefs = new Unsigned32();
		public final Unsigned32 holes = new Unsigned32();
		public final Unsigned32[] ReallyLowQualityTextureingMap = array(new Unsigned32[4]);
		public final Unsigned32 predTex = new Unsigned32();
		public final Unsigned32 noEffectDoodad = new Unsigned32();
		public final Unsigned32 ofsSndEmitters = new Unsigned32();
		public final Unsigned32 nSndEmitters = new Unsigned32();
		public final Unsigned32 ofsLiquid = new Unsigned32();
		public final Unsigned32 sizeLiquid = new Unsigned32();
		public final Float32[] position = array(new Float32[3]);
	}

	public class MCVT extends ADTChunk {
		public final Float32[] position = array(new Float32[145]);

		public String toString() {
			return "[MCVTChunk] size:" + position.length;
		}
	}

	public MCNKHeader fMCNKHeader;

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, int size) {
		setGlobalOffset(offset + size + HEADERSIZE);
		setFullSize(size);
		this.setByteBuffer(bb, offset);
		fMCNKHeader = new MCNKHeader();
		fMCNKHeader.setByteBuffer(bb, offset);
		fMCNKHeader.fHeight = new MCVT();
		fMCNKHeader.fHeight.setByteBuffer(bb,
				(int) (offset + fMCNKHeader.ofsHeight.get()));
		return this;
	}

	public String getOffsets() {
		String g = "";
		for (int i = 0; i < 3; i++) {
			g += "\n position " + fMCNKHeader.position[i];
		}
		return g;
	}

	public int getFullSize() {
		return fullSize;
	}

	public void setFullSize(int fullSize) {
		this.fullSize = fullSize;
	}

	public String toString() {
		return "[MCNKChunk] size:" + getFullSize() + "\n position : "
				+ getOffsets();
	}


}
