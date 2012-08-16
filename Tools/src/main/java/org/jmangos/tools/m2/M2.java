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

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class M2 {
	public _offsets offsets = new _offsets();
	public _other other = new _other();
	public _data data = new _data();
	public _lengths lengths = new _lengths();
	public Textures[] textures;

	private M2() {
	}

	public static M2 read(ByteBuffer bb) {
		bb.order(ByteOrder.LITTLE_ENDIAN); // format is in little endian, ensure
											// the buffer is too
		M2 result = new M2();

		bb.get(result.other.magic);
		result.other.version = bb.getInt();
		result.lengths.lName = bb.getInt();
		result.offsets.ofsName = bb.getInt();
		result.other.globalModelFlags = bb.getInt();
		result.lengths.nGlobalSequences = bb.getInt();
		result.offsets.ofsGlobalSequences = bb.getInt();
		result.lengths.nAnimations = bb.getInt();
		result.offsets.ofsAnimations = bb.getInt();
		result.lengths.nAnimationLookup = bb.getInt();
		result.offsets.ofsAnimationLookup = bb.getInt();
		result.lengths.nBones = bb.getInt();
		result.offsets.ofsBones = bb.getInt();
		result.lengths.nKeyBoneLookup = bb.getInt();
		result.offsets.ofsKeyBoneLookup = bb.getInt();
		result.lengths.nVertices = bb.getInt();
		result.offsets.ofsVertices = bb.getInt();
		result.lengths.nViews = bb.getInt();
		result.lengths.nColors = bb.getInt();
		result.offsets.ofsColors = bb.getInt();
		result.lengths.nTextures = bb.getInt();
		result.offsets.ofsTextures = bb.getInt();
		result.lengths.nTransparency = bb.getInt();
		result.offsets.ofsTransparency = bb.getInt();
		result.lengths.nTextureAnimations = bb.getInt();
		result.offsets.ofsTextureAnimations = bb.getInt();
		result.lengths.nTexReplace = bb.getInt();
		result.offsets.ofsTexReplace = bb.getInt();
		result.lengths.nRenderFlags = bb.getInt();
		result.offsets.ofsRenderFlags = bb.getInt();
		result.lengths.nBoneLookupTable = bb.getInt();
		result.offsets.ofsBoneLookupTable = bb.getInt();
		result.lengths.nTexLookup = bb.getInt();
		result.offsets.ofsTexLookup = bb.getInt();
		result.lengths.nTexUnits = bb.getInt();
		result.offsets.ofsTexUnits = bb.getInt();
		result.lengths.nTransLookup = bb.getInt();
		result.offsets.ofsTransLookup = bb.getInt();
		result.lengths.nTexAnimLookup = bb.getInt();
		for (int index = 0; index < result.other.theFloats.length; index++) {
			result.other.theFloats[index] = bb.getFloat();
		}
		result.lengths.nBoundingTringles = bb.getInt();
		result.offsets.ofsBoundTriangles = bb.getInt();
		result.lengths.nBoundingVertices = bb.getInt();
		result.offsets.ofsBoundingVertices = bb.getInt();
		result.lengths.nBoundingNormals = bb.getInt();
		result.offsets.ofsBoundingNormals = bb.getInt();
		result.lengths.nAttachments = bb.getInt();
		result.offsets.ofsAttachments = bb.getInt();
		result.lengths.nAttachLookup = bb.getInt();
		result.offsets.ofsAttachLookup = bb.getInt();
		result.lengths.nAttachments_2 = bb.getInt();
		result.offsets.ofsAttachments_2 = bb.getInt();
		result.lengths.nLights = bb.getInt();
		result.offsets.ofsLights = bb.getInt();
		result.lengths.nCameras = bb.getInt();
		result.offsets.ofsCameras = bb.getInt();
		result.lengths.nCameraLookup = bb.getInt();
		result.offsets.ofsCameraLookup = bb.getInt();
		result.lengths.nRibbonEmitters = bb.getInt();
		result.offsets.ofsRibbonEmitters = bb.getInt();
		result.lengths.nParticleEmitters = bb.getInt();
		result.offsets.ofsParticleEmitters = bb.getInt();
		result.lengths.nUnknown = bb.getInt();
		result.offsets.ofsUnknown = bb.getInt();

		readData(result, bb);

		return result;
	}

	public Vertex[] getVertexes() {
		return data.vertexes;
	}

	public Vertex getVertex(int i) {
		return data.vertexes[i];
	}

	public int getVertexesCount() {
		return data.vertexes.length;
	}

	public static M2 read(File f) throws Exception {
		if (!f.exists())
			return null;
		FileInputStream fis = null;
		ByteBuffer bb = ByteBuffer.allocate((int) f.length());
		M2 result = null;
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

	protected static void readData(M2 result, ByteBuffer bb) {
		bb.position(result.offsets.ofsName);
		result.data.name = ByteBufferUtil.readString(bb, result.lengths.lName);

		bb.position(result.offsets.ofsGlobalSequences);
		result.data.globalSequences = ByteBufferUtil.readInts(bb,
				result.lengths.nGlobalSequences);

		bb.position(result.offsets.ofsAnimationLookup);
		result.data.animationLookups = ByteBufferUtil.readShorts(bb,
				result.lengths.nAnimationLookup);

		bb.position(result.offsets.ofsRenderFlags);
		result.data.renderFlags = ByteBufferUtil.readInts(bb,
				result.lengths.nRenderFlags);

		bb.position(result.offsets.ofsKeyBoneLookup);
		result.data.keyBoneLookupTable = ByteBufferUtil.readShorts(bb,
				result.lengths.nKeyBoneLookup);

		bb.position(result.offsets.ofsBoneLookupTable);
		result.data.boneLookupTable = ByteBufferUtil.readShorts(bb,
				result.lengths.nBoneLookupTable);

		bb.position(result.offsets.ofsVertices);
		result.data.vertexes = new Vertex[result.lengths.nVertices];
		for (int index = 0; index < result.lengths.nVertices; index++) {
			result.data.vertexes[index] = Vertex.read(bb);
		}

		bb.position(result.offsets.ofsAnimations);
		result.data.animations = new AnimationSequence[result.lengths.nAnimations];
		for (int index = 0; index < result.lengths.nAnimations; index++) {
			result.data.animations[index] = AnimationSequence.read(bb);
		}

		bb.position(result.offsets.ofsTextures);
		result.data.textures = new Textures[result.lengths.nTextures];
		for (int index = 0; index < result.lengths.nTextures; index++) {
			result.data.textures[index] = Textures.read(bb);
		}

		for (int index = 0; index < result.lengths.nTextures; index++) {
			if (result.data.textures[index].Type == 0) {
				bb.position(result.data.textures[index].ofsFilename);
				result.data.textures[index].setFileName(ByteBufferUtil.readString(bb,
						result.data.textures[index].lenFilename));
			}
		}
	}
	
	public Textures[] getTextures(){
		return data.textures;
	}
	
	class _offsets {
		int ofsName;
		int ofsGlobalSequences;
		int ofsAnimations;
		int ofsAnimationLookup;
		int ofsBones;
		int ofsKeyBoneLookup;
		int ofsVertices;
		int ofsColors;
		int ofsTextures;
		int ofsTransparency;
		int ofsTextureAnimations;
		int ofsTexReplace;
		int ofsRenderFlags;
		int ofsBoneLookupTable;
		int ofsTexLookup;
		int ofsTexUnits;
		int ofsBoundTriangles;
		int ofsBoundingVertices;
		int ofsBoundingNormals;
		int ofsAttachments;
		int ofsAttachLookup;
		int ofsAttachments_2;
		int ofsLights;
		int ofsCameras;
		int ofsCameraLookup;
		int ofsRibbonEmitters;
		int ofsParticleEmitters;
		int ofsUnknown;
		int ofsTransLookup;
	}

	public class _lengths {
		int lName;
		int nGlobalSequences;
		int nAnimations;
		int nAnimationLookup;
		int nBones;
		int nKeyBoneLookup;
		int nVertices;
		int nViews;
		int nColors;
		int nTextures;
		int nTransparency;
		int nTextureAnimations;
		int nTexReplace;
		int nRenderFlags;
		int nBoneLookupTable;
		int nTexLookup;
		int nTexUnits;
		int nTransLookup;
		int nTexAnimLookup;
		int nBoundingTringles;
		int nBoundingVertices;
		int nBoundingNormals;
		int nAttachments;
		int nAttachLookup;
		int nAttachments_2;
		int nLights;
		int nCameras;
		int nCameraLookup;
		int nRibbonEmitters;
		int nParticleEmitters;
		int nUnknown;
	}

	public class _other {
		public byte[] magic = new byte[4];
		public int version;
		public int globalModelFlags;
		public float[] theFloats = new float[14];
	}

	public class _data {
		public String name = null;
		public Vertex[] vertexes = null;
		public int[] globalSequences;
		public short[] animationLookups;
		public int[] renderFlags;
		public short[] boneLookupTable;
		public short[] keyBoneLookupTable;
		public AnimationSequence[] animations;
		public Textures[] textures;
	}
}
