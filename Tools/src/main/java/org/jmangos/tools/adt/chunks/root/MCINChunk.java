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

public class MCINChunk extends ADTChunk {
    
    final static class MCINEntry extends ADTChunk {
        
        public final Unsigned32 mcnk    = new Unsigned32(); // absolute offset.
        public final Unsigned32 size    = new Unsigned32(); // the size of the MCNK chunk, this is
                                                            // refering to.
        public final Unsigned32 flags   = new Unsigned32(); // these two are always 0. only set in
                                                            // the client.
        public final Unsigned32 asyncId = new Unsigned32();
    }
    
    public MCINEntry[] MCINEntrys = new MCINEntry[16 * 16];
    
    @Override
    public ADTChunk reads(final ByteBuffer bb, final int offset, final long size) {
    
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        for (int i = 0; i < 256; i++) {
            this.MCINEntrys[i] = new MCINEntry();
            this.MCINEntrys[i].setByteBuffer(bb, offset + (16 * i));
        }
        return this;
    }
    
    public String getOffsets() {
    
        final StringBuffer buf = new StringBuffer();
        for (int i = 0; i < (16 * 16); ++i) {
            buf.append("\n mcnk:");
            buf.append(this.MCINEntrys[i].mcnk.get());
            buf.append(" mcnk size:");
            buf.append(this.MCINEntrys[i].size.get());
        }
        return buf.toString();
    }
    
    @Override
    public String toString() {
    
        return "[MCINChunk]" + "\n offsets count: " + this.MCINEntrys.length;
    }
    
}
