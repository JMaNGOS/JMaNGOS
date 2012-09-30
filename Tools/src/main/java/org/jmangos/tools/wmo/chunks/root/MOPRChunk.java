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

public class MOPRChunk extends WMOChunk {

    class MOPREntry extends WMOChunk {

        Unsigned16 PortalIndex = new Unsigned16();
        Unsigned16 WmoGroupIndex = new Unsigned16();
        Signed16 unk = new Signed16();
        Unsigned16 unknown = new Unsigned16();
    }

    private MOPREntry[] MOPREntries;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MOPREntries = new MOPREntry[(int) (size / 8)];
        for (int i = 0; i < (size / 8); i++) {
            this.MOPREntries[i] = new MOPREntry();
            this.MOPREntries[i].setByteBuffer(bb, offset + (8 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @SuppressWarnings("unused")
    private String getAllName() {

        String tmp = "";
        for (final MOPREntry moprEntrie : this.MOPREntries) {
            tmp +=
                    "\n\tPortalIndex:" +
                        moprEntrie.PortalIndex.get() +
                        "\n\tWmoGroupIndex:" +
                        moprEntrie.WmoGroupIndex.get() +
                        "\n\tunk:" +
                        moprEntrie.unk.get() +
                        "\n\tunknown:" +
                        moprEntrie.unknown.get() +
                        "\n";

        }
        return tmp;
    }

    @Override
    public String toString() {

        return "[MOPRChunk]" + "\n\tMOPREntries count: " + this.MOPREntries.length;// +
                                                                                   // getAllName();
    }
}
