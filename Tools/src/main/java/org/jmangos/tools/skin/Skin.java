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
package org.jmangos.tools.skin;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.jmangos.tools.m2.ByteBufferUtil;

public class Skin {
    
    public _offsets      offsets = new _offsets();
    public _other        other   = new _other();
    public _data         data    = new _data();
    public _lengths      lengths = new _lengths();
    public Submeshes[]   SubmeshesList;
    public TextureUnit[] TextureUnits;
    
    private Skin() {
    
    }
    
    public static Skin read(final ByteBuffer bb) {
    
        bb.order(ByteOrder.LITTLE_ENDIAN);
        final Skin result = new Skin();
        bb.get(result.other.magic);
        result.lengths.nIndices = bb.getInt();
        result.offsets.ofsIndices = bb.getInt();
        result.lengths.nTriangles = bb.getInt();
        result.offsets.ofsTriangles = bb.getInt();
        result.lengths.nProperties = bb.getInt();
        result.offsets.ofsProperties = bb.getInt();
        result.lengths.nSubmeshes = bb.getInt();
        result.offsets.ofsSubmeshes = bb.getInt();
        result.lengths.nTextureUnits = bb.getInt();
        result.offsets.ofsTextureUnits = bb.getInt();
        readData(result, bb);
        
        return result;
    }
    
    public static Skin read(final File f) throws Exception {
    
        if (!f.exists()) {
            return null;
        }
        FileInputStream fis = null;
        final ByteBuffer bb = ByteBuffer.allocate((int) f.length());
        Skin result = null;
        try {
            fis = new FileInputStream(f);
            fis.getChannel().read(bb);
            bb.rewind();
            result = read(bb);
        } finally {
            fis.close();
        }
        return result;
    }
    
    protected static void readData(final Skin result, final ByteBuffer bb) {
    
        bb.position(result.offsets.ofsIndices);
        result.data.indexes = ByteBufferUtil.readShorts(bb, result.lengths.nIndices);
        bb.position(result.offsets.ofsTriangles);
        result.data.Triangles = ByteBufferUtil.readShorts(bb, result.lengths.nTriangles);
        
        System.out.println("result.lengths.nSubmeshes" + result.lengths.nSubmeshes);
        System.out.println("result.lengths.nTextureUnits" + result.lengths.nTextureUnits);
        
        result.SubmeshesList = new Submeshes[result.lengths.nSubmeshes];
        bb.position(result.offsets.ofsSubmeshes);
        for (int i = 0; i < result.lengths.nSubmeshes; i++) {
            result.SubmeshesList[i] = Submeshes.read(bb);
        }
        
        result.TextureUnits = new TextureUnit[result.lengths.nTextureUnits];
        bb.position(result.offsets.ofsTextureUnits);
        for (int i = 0; i < result.lengths.nTextureUnits; i++) {
            result.TextureUnits[i] = TextureUnit.read(bb);
        }
    }
    
    class _offsets {
        
        public int ofsTextureUnits;
        public int ofsSubmeshes;
        public int ofsProperties;
        public int ofsTriangles;
        int        ofsIndices;
    }
    
    public class _lengths {
        
        public int nIndices;
        public int nTriangles;
        public int nProperties;
        public int nSubmeshes;
        public int nTextureUnits;
    }
    
    public class _other {
        
        public byte[]  magic     = new byte[4];
        public int     version;
        public int     globalModelFlags;
        public float[] theFloats = new float[14];
    }
    
    public class _data {
        
        public short[] indexes = null;
        public short[] Triangles;
        public int[]   Properties;
        public int[]   Submeshes;
        public int[]   TextureUnits;
    }
}
