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

public class MOHDChunk extends WMOChunk{
	Unsigned32 nTextures = new Unsigned32();		
	Unsigned32 nGroups = new Unsigned32();		
	Unsigned32 nPortals = new Unsigned32();		
	Unsigned32 nLights = new Unsigned32();		
	Unsigned32 nModels = new Unsigned32();		
	Unsigned32 nDoodads = new Unsigned32();		
	Unsigned32 nSets = new Unsigned32();		
	Unsigned8 colR = new Unsigned8();				
	Unsigned8 colG = new Unsigned8();			
	Unsigned8 colB = new Unsigned8();				
	Unsigned8 colX = new Unsigned8();					
	Unsigned32 wmoID = new Unsigned32();
	Float32[]  bbox1 = array(new Float32[3]);
	Float32[]  bbox2 = array(new Float32[3]);		
	Unsigned32 LiquidType = new Unsigned32();	

	@Override
	public BaseChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	public String toString(){
		return "[MOHDChunk] \n\tnTextures:" + nTextures.get()+
		"\n\tnGroups:" + nGroups.get()+
		"\n\tnPortals:" + nPortals.get()+
		"\n\tnLights:" + nLights.get()+
		"\n\tnModels:" + nModels.get()+
		"\n\tnDoodads:" + nDoodads.get()+
		"\n\tnSets:" + nSets.get()+
		"\n\tcolR:" + colR.get()+
		"\n\tcolG:" + colG.get()+
		"\n\tcolB:" + colB.get()+
		"\n\tcolX:" + colX.get()+
		"\n\twmoID:" + wmoID.get()+
		"\n\tBounding box 1:" + bbox1[0].get()+ " " +bbox1[1].get()+ " " + bbox1[2].get()+
		"\n\tBounding box 2:" + bbox2[0].get()+ " " +bbox2[1].get()+ " " + bbox2[2].get()+
		"\n\tLiquidType:" + LiquidType.get();
	}
}
