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
package org.jmangos.tools.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.chunks.WMOChunk;

public class MOPYChunk extends WMOChunk {

    public class MOPYEntry extends WMOChunk {

        public Unsigned8 Flags = new Unsigned8();
        public Unsigned8 Material = new Unsigned8();
    }

    public MOPYEntry[] MOPYEntries;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MOPYEntries = new MOPYEntry[(int) (size / 2)];
        for (int i = 0; i < (size / 2); i++) {
            this.MOPYEntries[i] = new MOPYEntry();
            this.MOPYEntries[i].setByteBuffer(bb, offset + (2 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @SuppressWarnings("unused")
    private String getAllName() {

        String tmp = "";
        for (final MOPYEntry mopyEntrie : this.MOPYEntries) {
            tmp +=
                    "\n\tFlags:" +
                        mopyEntrie.Flags.get() +
                        "\n\tMaterial:" +
                        mopyEntrie.Material.get() +
                        "\n";

        }
        return tmp;
    }

    @Override
    public String toString() {

        return "[MOPYChunk]" + "\n\tMOPYEntries count: " + this.MOPYEntries.length;// +
                                                                                   // getAllName();
    }
}
