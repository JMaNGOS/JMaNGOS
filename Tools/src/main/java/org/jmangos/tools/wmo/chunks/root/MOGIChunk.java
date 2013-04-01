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

public class MOGIChunk extends WMOChunk {

    class MOGIEntry extends WMOChunk {

        Unsigned32 Flags = new Unsigned32();
        Float32[] bbox1 = array(new Float32[3]);
        Float32[] bbox2 = array(new Float32[3]);
        Signed32 name = new Signed32();
    }

    private MOGIEntry[] MOGIEntries;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MOGIEntries = new MOGIEntry[(int) (size / 32)];
        for (int i = 0; i < (size / 32); i++) {
            this.MOGIEntries[i] = new MOGIEntry();
            this.MOGIEntries[i].setByteBuffer(bb, offset + (32 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @SuppressWarnings("unused")
    private String getAllName() {

        String tmp = "";
        for (final MOGIEntry mogiEntrie : this.MOGIEntries) {
            tmp +=
                    "\n\tFlags:" +
                        mogiEntrie.Flags.get() +
                        "\n\tBounding box 1:" +
                        mogiEntrie.bbox1[0].get() +
                        " " +
                        mogiEntrie.bbox1[1].get() +
                        " " +
                        mogiEntrie.bbox1[2].get() +
                        "\n\tBounding box 2:" +
                        mogiEntrie.bbox2[0].get() +
                        " " +
                        mogiEntrie.bbox2[1].get() +
                        " " +
                        mogiEntrie.bbox2[2].get() +
                        "\n\tname or index:" +
                        mogiEntrie.name.get();

        }
        return tmp;
    }

    @Override
    public String toString() {

        return "[MOGIChunk] \n\tMOGIEntries count: " + this.MOGIEntries.length;
        // getAllName();
    }
}
