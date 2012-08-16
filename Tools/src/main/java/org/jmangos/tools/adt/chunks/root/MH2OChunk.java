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

public class MH2OChunk extends ADTChunk{
	class MH2OHeader extends ADTChunk{
		public final Unsigned32 ofsInformation = new Unsigned32();
		public final Unsigned32 layerCount = new Unsigned32();
		public final Unsigned32 ofsRender = new Unsigned32();
		public MH20Information info;
		public MH2ORender render;
	}
	class MH20Information extends ADTChunk{
		public final Unsigned16 LiquidType = new Unsigned16();
		public final Unsigned16 flags = new Unsigned16();
		public final Float32 heightLevel1 = new Float32();
		public final Float32 heightLevel2 = new Float32();
		public final Unsigned8 xOffset = new Unsigned8();
		public final Unsigned8 yOffset = new Unsigned8();
		public final Unsigned8 width = new Unsigned8();
		public final Unsigned8 height = new Unsigned8();
		public final Unsigned32 ofsMask2 = new Unsigned32();
		public final Unsigned32 ofsHeightmap = new Unsigned32();
		public MH2OHeightmapData fMH2OHeightmapData;
		
	}
	class MH2OHeightmapData extends ADTChunk{
		public int count;
		public Float32[] heightMap;
		public Unsigned8[] transparency;
	}
	class MH2ORender extends ADTChunk{
		public Unsigned8[] bits = array(new Unsigned8[8]);
	}	
	public MH2OHeader[] MH2OHeaders =  new MH2OHeader[16*16];

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.size = (int) size;
		this.setByteBuffer(bb, offset);
		for (int i = 0; i < 256; i++) {
			MH2OHeaders[i] = new MH2OHeader();
			MH2OHeaders[i].setByteBuffer(bb, offset + 12*i);
			if(MH2OHeaders[i].layerCount.get() > 0){
				MH2OHeaders[i].info = new MH20Information();
				MH2OHeaders[i].info.setByteBuffer(bb, (int) (MH2OHeaders[i].ofsInformation.get() + offset));
				if( ( MH2OHeaders[i].info.flags.get() & 1) !=1 ){
					MH2OHeaders[i].info.fMH2OHeightmapData = new MH2OHeightmapData();
					MH2OHeaders[i].info.fMH2OHeightmapData.setByteBuffer(bb, (int) (MH2OHeaders[i].info.ofsHeightmap.get() + offset));
					MH2OHeaders[i].info.fMH2OHeightmapData.heightMap = array(new Float32[(MH2OHeaders[i].info.height.get()+1)*(MH2OHeaders[i].info.width.get()+1)]);
					MH2OHeaders[i].info.fMH2OHeightmapData.transparency = array(new Unsigned8[(MH2OHeaders[i].info.height.get()+1)*(MH2OHeaders[i].info.width.get()+1)]);
				}
				if(MH2OHeaders[i].ofsRender.get() > 0){
					MH2OHeaders[i].render = new  MH2ORender();
					MH2OHeaders[i].render.setByteBuffer(bb, (int) (MH2OHeaders[i].ofsRender.get() + offset));
				}
			}

		}
		return this;	
	}
	public String getOffsets(){
		String g = "";
		
		for (int i = 0; i < 256; i++) {
			if((i % 16) == 0){
				g+="\n";
			}
			if( MH2OHeaders[i].layerCount.get() > 0 ){
				g +=" 1 ";
			}
			else{
				g +=" 0 ";
			}/*
				for (int j = 0; j < 8; j++) {
					g +="\n";
					for (int k = 0; k < 8; k++) 
						if( MH2OHeaders[i].layerCount.get() > 0 ){
							 if( ( MH2OHeaders[i].render.bits[j].get() & (0x1 << k)) > 0 ){
								g +=" 1 ";
							 }
							 else
								 g +=" 0 ";
						}
						else{
							g +=" 0 ";
						}
					
				}*/
		}	
		return g;
	}
	
	public String toString(){
		return "[MH2OChunk] size:" + size +
		"\n water : " +  getOffsets(); 
	}

}
