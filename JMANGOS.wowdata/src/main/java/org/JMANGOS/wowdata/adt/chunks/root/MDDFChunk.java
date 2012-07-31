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

public class MDDFChunk extends ADTChunk{
	class MDDFEntry extends ADTChunk{ 
		Unsigned32 mmidEntry = new Unsigned32();           
		Unsigned32 uniqueId = new Unsigned32();            
		Float32[] position = array(new Float32[3]);
		Float32[] rotation = array(new Float32[3]);
		Unsigned16 scale = new Unsigned16();
		Unsigned16 flags = new Unsigned16();
	}

	private MDDFEntry[] MDDFEntries;
	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		MDDFEntries = new MDDFEntry[(int) (size /36)];
		for (int i = 0; i < (size /36); i++) {
			MDDFEntries[i] = new MDDFEntry();
			MDDFEntries[i].setByteBuffer(bb, offset + 36*i);
		}
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		return this;	
	}
	
	public String toString(){
		return "[MDDFChunk]" + 
		"\n MDDFEntries count: " + MDDFEntries.length; 
	}

}
