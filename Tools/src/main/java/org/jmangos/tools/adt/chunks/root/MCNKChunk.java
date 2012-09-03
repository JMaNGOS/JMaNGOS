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
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MCNKChunk extends ADTChunk {
    
    public class MCNKHeader extends ADTChunk {
        
        public MCVT               fHeight;
        public final Unsigned32   flags                         = new Unsigned32();
        public final Unsigned32   IndexX                        = new Unsigned32();
        public final Unsigned32   IndexY                        = new Unsigned32();
        public final Unsigned32   nLayers                       = new Unsigned32();
        public final Unsigned32   nDoodadRefs                   = new Unsigned32();
        public final Unsigned32   ofsHeight                     = new Unsigned32();
        public final Unsigned32   ofsNormal                     = new Unsigned32();
        public final Unsigned32   ofsLayer                      = new Unsigned32();
        public final Unsigned32   ofsRefs                       = new Unsigned32();
        public final Unsigned32   ofsAlpha                      = new Unsigned32();
        public final Unsigned32   sizeAlpha                     = new Unsigned32();
        public final Unsigned32   ofsShadow                     = new Unsigned32();
        public final Unsigned32   sizeShadow                    = new Unsigned32();
        public final Unsigned32   areaid                        = new Unsigned32();
        public final Unsigned32   nMapObjRefs                   = new Unsigned32();
        public final Unsigned32   holes                         = new Unsigned32();
        public final Unsigned32[] ReallyLowQualityTextureingMap = array(new Unsigned32[4]);
        public final Unsigned32   predTex                       = new Unsigned32();
        public final Unsigned32   noEffectDoodad                = new Unsigned32();
        public final Unsigned32   ofsSndEmitters                = new Unsigned32();
        public final Unsigned32   nSndEmitters                  = new Unsigned32();
        public final Unsigned32   ofsLiquid                     = new Unsigned32();
        public final Unsigned32   sizeLiquid                    = new Unsigned32();
        public final Float32[]    position                      = array(new Float32[3]);
    }
    
    public class MCVT extends ADTChunk {
        
        public final Float32[] position = array(new Float32[145]);
        
        @Override
        public String toString() {
        
            return "[MCVTChunk] size:" + this.position.length;
        }
    }
    
    public MCNKHeader fMCNKHeader;
    
    @Override
    public ADTChunk reads(final ByteBuffer bb, final int offset, final long size) {
    
        setGlobalOffcet(offset + size + HEADERSIZE);
        this.size = (int) size;
        setByteBuffer(bb, offset);
        this.fMCNKHeader = new MCNKHeader();
        this.fMCNKHeader.setByteBuffer(bb, offset);
        this.fMCNKHeader.fHeight = new MCVT();
        this.fMCNKHeader.fHeight.setByteBuffer(bb, (int) (offset + this.fMCNKHeader.ofsHeight.get()));
        return this;
    }
    
    public String getOffsets() {
    
        String g = "";
        for (int i = 0; i < 3; i++) {
            g += "\n position " + this.fMCNKHeader.position[i];
        }
        return g;
    }
    
    @Override
    public String toString() {
    
        return "[MCNKChunk] size:" + this.size + "\n position : " + getOffsets();
    }
    
}
