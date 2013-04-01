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

public class MOHDChunk extends WMOChunk {

    Unsigned32 nTextures = new Unsigned32();
    Unsigned32 nGroups = new Unsigned32();
    Unsigned32 nPortals = new Unsigned32();
    Unsigned32 nLights = new Unsigned32();
    Unsigned32 nModels = new Unsigned32();
    Unsigned32 nDoodads = new Unsigned32();
    Unsigned32 nSets = new Unsigned32();
    Unsigned8 colR = new Unsigned8();
    Unsigned8 colG = new Unsigned8();
    Unsigned8 colB = new Unsigned8();
    Unsigned8 colX = new Unsigned8();
    Unsigned32 wmoID = new Unsigned32();
    Float32[] bbox1 = array(new Float32[3]);
    Float32[] bbox2 = array(new Float32[3]);
    Unsigned32 LiquidType = new Unsigned32();

    @Override
    public BaseChunk reads(final ByteBuffer bb, final int offset, final long size) {

        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @Override
    public String toString() {

        return "[MOHDChunk] \n\tnTextures:" +
            this.nTextures.get() +
            "\n\tnGroups:" +
            this.nGroups.get() +
            "\n\tnPortals:" +
            this.nPortals.get() +
            "\n\tnLights:" +
            this.nLights.get() +
            "\n\tnModels:" +
            this.nModels.get() +
            "\n\tnDoodads:" +
            this.nDoodads.get() +
            "\n\tnSets:" +
            this.nSets.get() +
            "\n\tcolR:" +
            this.colR.get() +
            "\n\tcolG:" +
            this.colG.get() +
            "\n\tcolB:" +
            this.colB.get() +
            "\n\tcolX:" +
            this.colX.get() +
            "\n\twmoID:" +
            this.wmoID.get() +
            "\n\tBounding box 1:" +
            this.bbox1[0].get() +
            " " +
            this.bbox1[1].get() +
            " " +
            this.bbox1[2].get() +
            "\n\tBounding box 2:" +
            this.bbox2[0].get() +
            " " +
            this.bbox2[1].get() +
            " " +
            this.bbox2[2].get() +
            "\n\tLiquidType:" +
            this.LiquidType.get();
    }
}
