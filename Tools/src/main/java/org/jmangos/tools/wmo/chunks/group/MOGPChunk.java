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
package org.jmangos.tools.wmo.chunks.group;

import java.nio.ByteBuffer;

import org.jmangos.tools.chunk.BaseChunk;
import org.jmangos.tools.wmo.chunks.WMOChunk;

public class MOGPChunk extends WMOChunk {
    
    Unsigned32       Groupname            = new Unsigned32();
    Unsigned32       DescriptiveGroupName = new Unsigned32();
    Unsigned32       Flags                = new Unsigned32();
    public Float32[] bbox1                = array(new Float32[3]);
    public Float32[] bbox2                = array(new Float32[3]);
    Unsigned16       IndexMOPR            = new Unsigned16();
    Unsigned16       CountItems           = new Unsigned16();
    Unsigned16       NumberBatchA         = new Unsigned16();
    Unsigned16       NumberBatchB         = new Unsigned16();
    Unsigned32       NumberBatchC         = new Unsigned32();
    Unsigned8[]      WmoFogIndecies       = array(new Unsigned8[4]);
    Unsigned32       LiquidType           = new Unsigned32();
    Unsigned32       WMOGroupID           = new Unsigned32();
    Unsigned32       unk0                 = new Unsigned32();
    Unsigned32       unk1                 = new Unsigned32();
    public MOVIChunk indecies;
    public MOVTChunk vertexes;
    public MOPYChunk material;
    
    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {
    
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        int glOffset = offset + size();
        while (glOffset < size) {
            final BaseChunk ch = new WMOChunk().readChunkByHeader(bb, glOffset);
            if (ch instanceof MOVIChunk) {
                this.indecies = (MOVIChunk) ch;
            } else if (ch instanceof MOVTChunk) {
                this.vertexes = (MOVTChunk) ch;
            }
            if (ch instanceof MOPYChunk) {
                this.material = (MOPYChunk) ch;
            }
            glOffset = ch.getGlobalOffcet();
        }
        return this;
    }
    
    @Override
    public String toString() {
    
        return "[MOGPChunk] \n\tWMOGroupID:" + this.WMOGroupID.get() + "\n\tBounding box 1:" + this.bbox1[0].get() + " " + this.bbox1[1].get() + " "
                + this.bbox1[2].get() + "\n\tBounding box 2:" + this.bbox2[0].get() + " " + this.bbox2[1].get() + " " + this.bbox2[2].get();
    }
}
