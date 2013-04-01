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

public class MOPTChunk extends WMOChunk {

    class MOPTEntry extends WMOChunk {

        Unsigned16 BaseVertex = new Unsigned16();
        Unsigned16 countVert = new Unsigned16();
        Float32[] vector = array(new Float32[3]);
        Float32 unknown = new Float32();
    }

    private MOPTEntry[] MOPTEntries;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MOPTEntries = new MOPTEntry[(int) (size / 20)];
        for (int i = 0; i < (size / 20); i++) {
            this.MOPTEntries[i] = new MOPTEntry();
            this.MOPTEntries[i].setByteBuffer(bb, offset + (20 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @SuppressWarnings("unused")
    private String getAllName() {

        String tmp = "";
        for (final MOPTEntry moptEntrie : this.MOPTEntries) {
            tmp +=
                    "\n\tBaseVertex:" +
                        moptEntrie.BaseVertex.get() +
                        "\n\tcountVert:" +
                        moptEntrie.countVert.get() +
                        "\n\tvector:" +
                        moptEntrie.vector[0].get() +
                        " " +
                        moptEntrie.vector[1].get() +
                        " " +
                        moptEntrie.vector[2].get() +
                        "\n\tunknown:" +
                        moptEntrie.unknown.get();

        }
        return tmp;
    }

    @Override
    public String toString() {

        return "[MOPTChunk]" + "\n\tMOPTEntries count: " + this.MOPTEntries.length;// +
                                                                                   // getAllName();
    }
}
