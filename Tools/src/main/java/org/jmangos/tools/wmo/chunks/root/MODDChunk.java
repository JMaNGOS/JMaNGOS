/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.tools.wmo.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.chunks.WMOChunk;

public class MODDChunk extends WMOChunk {

    class MODDEntry extends WMOChunk {

        Unsigned32 OffsetModelName = new Unsigned32();
        Float32[] position = array(new Float32[3]);
        Float32[] quaternion = array(new Float32[3]);
        Float32 quaternionW = new Float32();
        Float32 Scale = new Float32();
        Unsigned8 colR = new Unsigned8();
        Unsigned8 colG = new Unsigned8();
        Unsigned8 colB = new Unsigned8();
        Unsigned8 colX = new Unsigned8();

    }

    private MODDEntry[] MODDEntries;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MODDEntries = new MODDEntry[(int) (size / 40)];
        for (int i = 0; i < (size / 40); i++) {
            this.MODDEntries[i] = new MODDEntry();
            this.MODDEntries[i].setByteBuffer(bb, offset + (40 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @Override
    public String toString() {

        return "[MODDChunk]" + "\n\tMODDEntries count: " + this.MODDEntries.length;
    }
}
