/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.wowdata.m2;

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
