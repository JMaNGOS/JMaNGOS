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

public class Vertex {
	public float[] position = new float[3];
	byte[] boneWeight = new byte[4];
	byte[] boneIndices = new byte[4];
	public float[] normal = new float[3];
	public float[] textureCoords = new float[2];
	float[] unknown = new float[2];
	
	public static Vertex read(ByteBuffer bb) {
		Vertex result = new Vertex();
		
		result.position = ByteBufferUtil.readFloats(bb, result.position.length);
		result.boneWeight = ByteBufferUtil.readBytes(bb, result.boneWeight.length);
		result.boneIndices = ByteBufferUtil.readBytes(bb, result.boneIndices.length);
		result.normal = ByteBufferUtil.readFloats(bb, result.normal.length);
		result.textureCoords = ByteBufferUtil.readFloats(bb, result.textureCoords.length);
		result.unknown = ByteBufferUtil.readFloats(bb, result.unknown.length);
		
		return result;
	}
}
