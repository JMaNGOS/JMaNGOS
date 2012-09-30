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

import java.nio.ByteBuffer;

public class Submeshes {

    int ID;
    public short StartVertex;
    public short nVertices;
    public short StartTriangle;
    public short nTriangles;
    short nBones;
    short StartBones;
    short Unknown;
    short RootBone;
    float[] CenterMass = new float[3];
    float[] CenterBoundingBox = new float[3];
    float Radius;

    /*
     * 0x00 uint32 ID Mesh part ID, see below. 0x04 uint16 StartVertex Starting
     * vertex number. 0x06
     * uint16 nVertices Number of vertices. 0x08 uint16 StartTriangle Starting
     * triangle index
     * (that's 3* the number of triangles drawn so far). 0x0A uint16 nTriangles
     * Number of triangle
     * indices. 0x0C uint16 nBones Number of elements in the bone lookup table.
     * 0x0E uint16
     * StartBones Starting index in the bone lookup table. 0x10 uint16 Unknown
     * 0x12 uint16 RootBone
     * Not sure. 0x14 Vec3F CenterMass Average position of all the vertices in
     * the submesh. 0x20
     * Vec3F CenterBoundingBox The center of the box when an axis aligned box is
     * built around the
     * vertices in the submesh. 0x2C float Radius
     */
    public static Submeshes read(final ByteBuffer bb) {

        final Submeshes result = new Submeshes();

        result.ID = bb.getInt();
        result.StartVertex = bb.getShort();
        result.nVertices = bb.getShort();
        result.StartTriangle = bb.getShort();
        result.nTriangles = bb.getShort();
        result.nBones = bb.getShort();
        result.StartBones = bb.getShort();
        result.Unknown = bb.getShort();
        result.RootBone = bb.getShort();
        for (int index = 0; index < 3; index++) {
            result.CenterMass[index] = bb.getFloat();
        }
        for (int index = 0; index < 3; index++) {
            result.CenterBoundingBox[index] = bb.getFloat();
        }
        result.Radius = bb.getFloat();
        return result;
    }

    @Override
    public String toString() {

        return "[Submeshes]\n\tID = " +
            this.ID +
            "\n\tnStartVertex: " +
            this.StartVertex +
            "\n\tnVertices: " +
            this.nVertices +
            "\n\tStartTriangle: " +
            this.StartTriangle +
            "\n\tnTriangles: " +
            this.nTriangles +
            "\n\tnBones: " +
            this.nBones +
            "\n\tUnknown: " +
            this.Unknown +
            "\n\tRadius: " +
            this.Radius;
    }
}
