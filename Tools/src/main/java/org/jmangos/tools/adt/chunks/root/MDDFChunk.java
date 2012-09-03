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

public class MDDFChunk extends ADTChunk {
    
    class MDDFEntry extends ADTChunk {
        
        Unsigned32 mmidEntry = new Unsigned32();
        Unsigned32 uniqueId  = new Unsigned32();
        Float32[]  position  = array(new Float32[3]);
        Float32[]  rotation  = array(new Float32[3]);
        Unsigned16 scale     = new Unsigned16();
        Unsigned16 flags     = new Unsigned16();
    }
    
    private MDDFEntry[] MDDFEntries;
    
    @Override
    public ADTChunk reads(final ByteBuffer bb, final int offset, final long size) {
    
        this.MDDFEntries = new MDDFEntry[(int) (size / 36)];
        for (int i = 0; i < (size / 36); i++) {
            this.MDDFEntries[i] = new MDDFEntry();
            this.MDDFEntries[i].setByteBuffer(bb, offset + (36 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }
    
    @Override
    public String toString() {
    
        return "[MDDFChunk]" + "\n MDDFEntries count: " + this.MDDFEntries.length;
    }
    
}
