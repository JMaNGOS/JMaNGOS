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

public class MODSChunk extends WMOChunk {
    
    class MODSEntry extends WMOChunk {
        
        UTF8String setName    = new UTF8String(20);
        Unsigned32 Index      = new Unsigned32();
        Unsigned32 countInSet = new Unsigned32();
        Unsigned32 unknown    = new Unsigned32();
    }
    
    private MODSEntry[] MODSEntries;
    
    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {
    
        this.MODSEntries = new MODSEntry[(int) (size / 32)];
        for (int i = 0; i < (size / 32); i++) {
            this.MODSEntries[i] = new MODSEntry();
            this.MODSEntries[i].setByteBuffer(bb, offset + (32 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }
    
    @Override
    public String toString() {
    
        final StringBuilder sb = new StringBuilder();
        sb.append("[MODSChunk] MODSEntries size:").append(this.MODSEntries.length);
        for (final MODSEntry modsEntrie : this.MODSEntries) {
            sb.append("\n\tsetName:").append(modsEntrie.setName.get());
            sb.append("\n\tFirstIndex:").append(modsEntrie.Index.get());
            sb.append("\n\tcountInSet:").append(modsEntrie.countInSet.get());
        }
        return sb.toString();
    }
}
