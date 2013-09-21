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
package org.jmangos.tools.m2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author MinimaJack
 * 
 */
/**
 * @author MinimaJack
 * 
 */
/**
 * @author MinimaJack
 * 
 */
/**
 * @author MinimaJack
 * 
 */
/**
 * @author MinimaJack
 * 
 */
public final class M2 {

    /**
     * Offsets
     */
    private final Offsets offsets = new Offsets();
    /**
     * Other data
     */
    private final Other other = new Other();
    /**
     * Data
     */
    private final Data data = new Data();
    /**
     * Lengths
     */
    private final Lengths lengths = new Lengths();

    /**
     * hidden constructor
     */
    private M2() {

    }

    /**
     * @param bb
     *        - ByteBuffer
     * @return M2
     */
    public static M2 read(final ByteBuffer bb) {

        bb.order(ByteOrder.LITTLE_ENDIAN); // format is in little endian, ensure
                                           // the buffer is too
        final M2 result = new M2();

        bb.get(result.other.getMagic());
        result.other.setVersion(bb.getInt());
        result.lengths.setlName(bb.getInt());
        result.offsets.setOfsName(bb.getInt());
        result.other.setGlobalModelFlags(bb.getInt());
        result.lengths.setnGlobalSequences(bb.getInt());
        result.offsets.setOfsGlobalSequences(bb.getInt());
        result.lengths.setnAnimations(bb.getInt());
        result.offsets.setOfsAnimations(bb.getInt());
        result.lengths.setnAnimationLookup(bb.getInt());
        result.offsets.setOfsAnimationLookup(bb.getInt());
        result.lengths.setnBones(bb.getInt());
        result.offsets.setOfsBones(bb.getInt());
        result.lengths.setnKeyBoneLookup(bb.getInt());
        result.offsets.setOfsKeyBoneLookup(bb.getInt());
        result.lengths.setnVertices(bb.getInt());
        result.offsets.setOfsVertices(bb.getInt());
        result.lengths.setnViews(bb.getInt());
        result.lengths.setnColors(bb.getInt());
        result.offsets.setOfsColors(bb.getInt());
        result.lengths.setnTextures(bb.getInt());
        result.offsets.setOfsTextures(bb.getInt());
        result.lengths.setnTransparency(bb.getInt());
        result.offsets.setOfsTransparency(bb.getInt());
        result.lengths.setnTextureAnimations(bb.getInt());
        result.offsets.setOfsTextureAnimations(bb.getInt());
        result.lengths.setnTexReplace(bb.getInt());
        result.offsets.setOfsTexReplace(bb.getInt());
        result.lengths.setnRenderFlags(bb.getInt());
        result.offsets.setOfsRenderFlags(bb.getInt());
        result.lengths.setnBoneLookupTable(bb.getInt());
        result.offsets.setOfsBoneLookupTable(bb.getInt());
        result.lengths.setnTexLookup(bb.getInt());
        result.offsets.setOfsTexLookup(bb.getInt());
        result.lengths.setnTexUnits(bb.getInt());
        result.offsets.setOfsTexUnits(bb.getInt());
        result.lengths.setnTransLookup(bb.getInt());
        result.offsets.setOfsTransLookup(bb.getInt());
        result.lengths.setnTexAnimLookup(bb.getInt());
        for (int index = 0; index < result.other.getTheFloats().length; index++) {
            result.other.getTheFloats()[index] = bb.getFloat();
        }
        result.lengths.setnBoundingTringles(bb.getInt());
        result.offsets.setOfsBoundTriangles(bb.getInt());
        result.lengths.setnBoundingVertices(bb.getInt());
        result.offsets.setOfsBoundingVertices(bb.getInt());
        result.lengths.setnBoundingNormals(bb.getInt());
        result.offsets.setOfsBoundingNormals(bb.getInt());
        result.lengths.setnAttachments(bb.getInt());
        result.offsets.setOfsAttachments(bb.getInt());
        result.lengths.setnAttachLookup(bb.getInt());
        result.offsets.setOfsAttachLookup(bb.getInt());
        result.lengths.setnAttachments2(bb.getInt());
        result.offsets.setOfsAttachments2(bb.getInt());
        result.lengths.setnLights(bb.getInt());
        result.offsets.setOfsLights(bb.getInt());
        result.lengths.setnCameras(bb.getInt());
        result.offsets.setOfsCameras(bb.getInt());
        result.lengths.setnCameraLookup(bb.getInt());
        result.offsets.setOfsCameraLookup(bb.getInt());
        result.lengths.setnRibbonEmitters(bb.getInt());
        result.offsets.setOfsRibbonEmitters(bb.getInt());
        result.lengths.setnParticleEmitters(bb.getInt());
        result.offsets.setOfsParticleEmitters(bb.getInt());
        result.lengths.setnUnknown(bb.getInt());
        result.offsets.setOfsUnknown(bb.getInt());

        readData(result, bb);

        return result;
    }

    /**
     * 
     * @return data vertexes
     */
    public Vertex[] getVertexes() {

        return this.data.getVertexes();
    }

    /**
     * 
     * @param i
     *        - vertex index
     * @return data vertex by index i
     */
    public Vertex getVertex(final int i) {

        return this.data.getVertexes()[i];
    }

    /**
     * 
     * @return vertexes count
     */
    public int getVertexesCount() {

        return this.data.getVertexes().length;
    }

    /**
     * Read m2 from file
     * 
     * @param f
     *        - file with M2
     * @return M2 from given File or null if file not exist.
     */
    public static M2 read(final File f) {

        if (!f.exists()) {
            return null;
        }
        FileInputStream fis = null;
        final ByteBuffer bb = ByteBuffer.allocate((int) f.length());
        M2 result = null;
        try {
            fis = new FileInputStream(f);
            fis.getChannel().read(bb);
            bb.rewind();
            result = read(bb);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * read m2 data
     * 
     * @param m2Object
     *        - m2 object
     * @param bb
     *        - ByteBuffer
     */
    protected static void readData(final M2 m2Object, final ByteBuffer bb) {

        bb.position(m2Object.offsets.getOfsName());
        m2Object.data.setName(ByteBufferUtil.readString(bb, m2Object.lengths.getlName()));

        bb.position(m2Object.offsets.getOfsGlobalSequences());
        m2Object.data.setGlobalSequences(ByteBufferUtil.readInts(bb,
                m2Object.lengths.getnGlobalSequences()));

        bb.position(m2Object.offsets.getOfsAnimationLookup());
        m2Object.data.setAnimationLookups(ByteBufferUtil.readShorts(bb,
                m2Object.lengths.getnAnimationLookup()));

        bb.position(m2Object.offsets.getOfsRenderFlags());
        m2Object.data.setRenderFlags(ByteBufferUtil.readInts(bb, m2Object.lengths.getnRenderFlags()));

        bb.position(m2Object.offsets.getOfsKeyBoneLookup());
        m2Object.data.setKeyBoneLookupTable(ByteBufferUtil.readShorts(bb,
                m2Object.lengths.getnKeyBoneLookup()));

        bb.position(m2Object.offsets.getOfsBoneLookupTable());
        m2Object.data.setBoneLookupTable(ByteBufferUtil.readShorts(bb,
                m2Object.lengths.getnBoneLookupTable()));

        bb.position(m2Object.offsets.getOfsVertices());
        m2Object.data.setVertexes(new Vertex[m2Object.lengths.getnVertices()]);
        for (int index = 0; index < m2Object.lengths.getnVertices(); index++) {
            m2Object.data.getVertexes()[index] = Vertex.read(bb);
        }

        bb.position(m2Object.offsets.getOfsAnimations());
        m2Object.data.setAnimations(new AnimationSequence[m2Object.lengths.getnAnimations()]);
        for (int index = 0; index < m2Object.lengths.getnAnimations(); index++) {
            m2Object.data.getAnimations()[index] = AnimationSequence.read(bb);
        }

        bb.position(m2Object.offsets.getOfsTextures());
        m2Object.data.setTextures(new Textures[m2Object.lengths.getnTextures()]);
        for (int index = 0; index < m2Object.lengths.getnTextures(); index++) {
            m2Object.data.getTextures()[index] = Textures.read(bb);
        }

        for (int index = 0; index < m2Object.lengths.getnTextures(); index++) {
            if (m2Object.data.getTextures()[index].getType() == 0) {
                bb.position(m2Object.data.getTextures()[index].getOfsFilename());
                m2Object.data.getTextures()[index].setFileName(ByteBufferUtil.readString(bb,
                        m2Object.data.getTextures()[index].getLenFilename()));
            }
        }
    }
}
