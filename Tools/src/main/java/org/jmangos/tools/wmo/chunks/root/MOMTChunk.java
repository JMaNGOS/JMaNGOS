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

public class MOMTChunk extends WMOChunk {

    class MOMTEntry extends WMOChunk {

        /* 000h */Unsigned32 flags_0 = new Unsigned32();
        /* 004h */Unsigned32 SpecularMode = new Unsigned32();
        /* 008h */Unsigned32 blendMode = new Unsigned32();
        /* 00Ch */Unsigned32 texture_1 = new Unsigned32();
        /* 010h */Unsigned32 color_1 = new Unsigned32();
        /* 014h */Unsigned32 flags_1 = new Unsigned32();
        /* 018h */Unsigned32 texture_2 = new Unsigned32();
        /* 01Ch */Unsigned32 color_2 = new Unsigned32();
        /* 020h */Unsigned32 flags_2 = new Unsigned32();
        /* 024h */Unsigned32 color_3 = new Unsigned32();
        /* 028h */Unsigned32[] unk = array(new Unsigned32[4]);
        /* 02Ch */Float32[] diffColor = array(new Float32[3]);
        /* 030h */Unsigned32[] runTimeData = array(new Unsigned32[4]);
        /* 034h */Unsigned32 unk1 = new Unsigned32();
        /* 038h */Unsigned32 unk2 = new Unsigned32();
        /* 03Ch */Unsigned32 unk3 = new Unsigned32();
        /* 040h */Unsigned32 unk4 = new Unsigned32();

        @Override
        public String toString() {

            return "\n\t\t[MOMTEntry]" +
                "\n\t\t\tflags_0: " +
                this.flags_0 +
                "\n\t\t\tSpecularMode: " +
                this.SpecularMode +
                "\n\t\t\tblendMode: " +
                this.blendMode +
                "\n\t\t\ttexture_1: " +
                this.texture_1 +
                "\n\t\t\tcolor_1: " +
                this.color_1 +
                "\n\t\t\tflags_1: " +
                this.flags_1 +
                "\n\t\t\ttexture_2: " +
                this.texture_2 +
                "\n\t\t\tcolor_2: " +
                this.color_2 +
                "\n\t\t\tflags_2: " +
                this.flags_2 +
                "\n\t\t\tcolor_3: " +
                this.color_3;
        }
    }

    private MOMTEntry[] MOMTEntries;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MOMTEntries = new MOMTEntry[(int) (size / 64)];
        for (int i = 0; i < (size / 64); i++) {
            this.MOMTEntries[i] = new MOMTEntry();
            this.MOMTEntries[i].setByteBuffer(bb, offset + (64 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        sb.append("[MOMTChunk]\n\tMOMTEntries count:").append(this.MOMTEntries.length);
        for (final MOMTEntry momt : this.MOMTEntries) {
            sb.append(momt.toString());
        }
        return sb.toString();
    }
}
