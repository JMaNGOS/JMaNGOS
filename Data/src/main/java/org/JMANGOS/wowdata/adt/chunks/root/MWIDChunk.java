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

public class MWIDChunk extends ADTChunk{
	public Unsigned32[] offset;

	@Override
	public ADTChunk reads(ByteBuffer bb, int offset, long size) {
		setGlobalOffcet(offset + size + HEADERSIZE);
		this.setByteBuffer(bb, offset);
		this.offset = array(new Unsigned32[(int) (size/4)]);
		return this;	
	}
	
	public String toString(){
		return "[MWIDChunk]" +
		"\n offsets count: " + offset.length; 
	}

}
