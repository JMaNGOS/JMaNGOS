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
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MCNKChunk extends ADTChunk{
	public class MCNKHeader extends ADTChunk{
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
	public class MCVT extends ADTChunk{
		public final Float32[] position = array(new Float32[145]);
		public String toString(){
			return "[MCVTChunk] size:" + position.length;
		}
	}
	

	public MCNKHeader fMCNKHeader;

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.size = (int) size;
		this.setByteBuffer(bb, offset);
		fMCNKHeader =  new MCNKHeader();
		fMCNKHeader.setByteBuffer(bb, offset);
		fMCNKHeader.fHeight = new MCVT();
		fMCNKHeader.fHeight.setByteBuffer(bb, (int) (offset + fMCNKHeader.ofsHeight.get()));
		return this;	
	}
	public String getOffsets(){
		String g = "";
		for (int i = 0; i < 3; i++) {
			g+="\n position "+fMCNKHeader.position[i];
		}
		return g;
	}
	
	public String toString(){
		return "[MCNKChunk] size:" + size +
		"\n position : " +  getOffsets(); 
	}

}
