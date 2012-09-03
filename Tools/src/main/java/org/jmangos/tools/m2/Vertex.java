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
package org.jmangos.tools.m2;

import java.nio.ByteBuffer;

/**
 * 
 * @author MinimaJack
 * 
 */
public final class Vertex {
    
    /** Constant count coordinate */
    private static final int COUNT_POINTS        = 3;
    /** Constant count bone data */
    private static final int COUNT_BONE_DATA     = 4;
    /** Constant count textures data */
    private static final int COUNT_TEXTURES_DATA = 2;
    /**
     * Position
     */
    private float[]          position            = new float[COUNT_POINTS];
    /**
     * Bone weight
     */
    private byte[]           boneWeight          = new byte[COUNT_BONE_DATA];
    /**
     * Bone indexes
     */
    private byte[]           boneIndices         = new byte[COUNT_BONE_DATA];
    /**
     * Normals
     */
    private float[]          normal              = new float[COUNT_POINTS];
    /**
     * Texture coords
     */
    private float[]          textureCoords       = new float[COUNT_TEXTURES_DATA];
    /**
     * Unknown data
     */
    private float[]          unknown             = new float[COUNT_TEXTURES_DATA];
    
    /**
     * Instantiate new Vertex
     */
    private Vertex() {
    
    }
    
    /**
     * Read vertices
     * 
     * @param bb
     *            ByteBuffer
     * @return Vertex
     */
    public static Vertex read(final ByteBuffer bb) {
    
        final Vertex result = new Vertex();
        
        result.position = ByteBufferUtil.readFloats(bb, result.position.length);
        result.boneWeight = ByteBufferUtil.readBytes(bb, result.boneWeight.length);
        result.boneIndices = ByteBufferUtil.readBytes(bb, result.boneIndices.length);
        result.normal = ByteBufferUtil.readFloats(bb, result.normal.length);
        result.textureCoords = ByteBufferUtil.readFloats(bb, result.textureCoords.length);
        result.unknown = ByteBufferUtil.readFloats(bb, result.unknown.length);
        
        return result;
    }
}
