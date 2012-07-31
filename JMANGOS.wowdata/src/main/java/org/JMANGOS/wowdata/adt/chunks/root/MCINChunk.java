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
package org.JMANGOS.wowdata.adt.chunks.root;

import java.nio.ByteBuffer;

import org.JMANGOS.wowdata.adt.chunks.ADTChunk;

public class MCINChunk extends ADTChunk{
	class MCINEntry extends ADTChunk{
		public final Unsigned32 mcnk = new Unsigned32();                   // absolute offset.
		public final Unsigned32 size = new Unsigned32();                // the size of the MCNK chunk, this is refering to.
		public final Unsigned32 flags = new Unsigned32();               // these two are always 0. only set in the client.
		public final Unsigned32 asyncId = new Unsigned32();
	}
	public MCINEntry[] MCINEntrys =  new MCINEntry[16*16];

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		for (int i = 0; i < 256; i++) {
			MCINEntrys[i] = new MCINEntry();
			MCINEntrys[i].setByteBuffer(bb, offset + 16*i);
		}
		return this;	
	}
	public String getOffsets(){
		String g = "";
		for (int i = 0; i < 16*16; i++) {
			g += "\n mcnk:" + MCINEntrys[i].mcnk.get()+" mcnk size:" + MCINEntrys[i].size.get();
		}	
		return g;
	}
	
	public String toString(){
		return "[MCINChunk]" +
		"\n offsets count: " + MCINEntrys.length; 
	}

}
