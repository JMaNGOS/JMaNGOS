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
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MWMOChunk extends ADTChunk {

    String[] filename;
    private MWIDChunk mwid;
    private int offset;

    @Override
    public ADTChunk reads(final ByteBuffer bb, final int offset, final long size) {

        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        this.offset = offset;
        return this;
    }

    public String fillName() {

        String name = "";
        if (this.mwid != null) {
            this.filename = new String[this.mwid.offset.length];
            for (int i = 0; i < this.mwid.offset.length; i++) {
                this.filename[i] = readStringf((int) this.mwid.offset[i].get());
                name += "\n" + this.filename[i].toString();
            }
        }
        return name;
    }

    public String readStringf(final int l) {

        final byte[] tsring = new byte[2024];
        final CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        int i = 0;
        for (; (tsring[i] = getByteBuffer().get(this.offset + HEADERSIZE + i + l)) != 0; i++) {}
        try {
            return decoder.decode(ByteBuffer.wrap(tsring, 0, i)).toString();
        } catch (final CharacterCodingException e) {
            e.printStackTrace();
        }
        return "";

    }

    @Override
    public String toString() {

        return "[MWMOChunk]" + "\n offsets count: " + fillName();
    }

    public void setMWID(final MWIDChunk mwid) {

        this.mwid = mwid;
    }

}
