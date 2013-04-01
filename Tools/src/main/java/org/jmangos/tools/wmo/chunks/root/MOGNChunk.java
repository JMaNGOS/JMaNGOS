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
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.chunks.WMOChunk;

public class MOGNChunk extends WMOChunk {

    ArrayList<String> groupNames = new ArrayList<String>();

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        final byte[] tsring = new byte[2024];
        final CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        int reading = 0;
        int si = 0;
        while ((size - reading) > 0) {
            int i = 0;
            for (; (tsring[i] = getByteBuffer().get(offset + HEADERSIZE + i + si)) != 0; i++) {
                reading++;
            }
            if (i > 0) {
                try {
                    this.groupNames.add(decoder.decode(ByteBuffer.wrap(tsring, 0, i)).toString());
                } catch (final CharacterCodingException e) {
                    e.printStackTrace();
                }
            }
            si = ++reading;
        }
        return this;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        sb.append("[MOGNChunk] groupNames size is:").append(this.groupNames.size());
        for (int i = 0; i < this.groupNames.size(); i++) {
            sb.append("\n\t").append(this.groupNames.get(i));
        }
        return sb.toString();

    }

}
