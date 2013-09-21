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

public class MOVTChunk extends WMOChunk {

    public Float32[] vertices;

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        this.vertices = array(new Float32[(int) (size / 4)]);
        return this;
    }

    @Override
    public String toString() {

        return "[MOVTChunk] \n\tVertices count:" + this.vertices.length;
    }
}
