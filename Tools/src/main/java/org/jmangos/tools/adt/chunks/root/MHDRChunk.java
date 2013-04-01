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
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MHDRChunk extends ADTChunk {

    public enum MHDRFlags {
        mhdr_MFBO(0),
        mhdr_northrend(1);

        int value;

        MHDRFlags(final int value) {

            this.value = value;
        }
    };

    final static int localOffset = new MHDRChunk().size();
    public final Enum32<MHDRFlags> MHDRflags = new Enum32<MHDRFlags>(MHDRFlags.values());
    Unsigned32 flag = new Unsigned32();
    Unsigned32 mcin = new Unsigned32();
    Unsigned32 mtex = new Unsigned32();
    Unsigned32 mmdx = new Unsigned32();
    Unsigned32 mmid = new Unsigned32();
    Unsigned32 mwmo = new Unsigned32();
    Unsigned32 mwid = new Unsigned32();
    Unsigned32 mddf = new Unsigned32();
    Unsigned32 mfbo;                                                   // this
    // is
    // only
    // set
    // if
    // flags
    // &
    // mhdr_MFBO.
    Unsigned32 modf;

    Unsigned32 mh2o;
    Unsigned32 mtfx;
    Unsigned32 uint32_t;
    Unsigned32 uint32_t2;
    Unsigned32 uint32_t3;
    Unsigned32 uint32_t4;
    Unsigned32 uint32_t5;

    @Override
    public ADTChunk reads(final ByteBuffer bb, final int offset, final long size) {

        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        if (mfboIn()) {
            this.mfbo = new Unsigned32();
        }
        this.modf = new Unsigned32();
        this.mh2o = new Unsigned32();
        this.mtfx = new Unsigned32();
        this.uint32_t = new Unsigned32();
        this.uint32_t2 = new Unsigned32();
        this.uint32_t3 = new Unsigned32();
        this.uint32_t4 = new Unsigned32();
        this.uint32_t5 = new Unsigned32();
        return this;
    }

    @Override
    public String toString() {

        return "[MHDRChunk]" +
            "\n ENUM: " +
            this.MHDRflags.get() +
            "\n FLAG: " +
            this.flag.get() +
            "\n MCIN: " +
            this.mcin.get() +
            "\n MTEX: " +
            this.mtex.get() +
            "\n MMDX: " +
            this.mmdx.get() +
            "\n MMID: " +
            this.mmid.get() +
            "\n MWMO: " +
            this.mwmo.get() +
            "\n MWID: " +
            this.mwid.get() +
            "\n MDDF: " +
            this.mddf.get() +
            "\n MODF: " +
            this.modf.get() +
            (mfboIn() ? ("\n MFBO: " + this.mfbo.get()) : "");

    }

    private boolean mfboIn() {

        return (1 & this.flag.get()) > 0;
    }

}
