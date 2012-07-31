package org.JMANGOS.wowdata.skin;

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
	0x00 	uint32	ID			Mesh part ID, see below.
	0x04 	uint16	StartVertex		Starting vertex number.
	0x06 	uint16	nVertices		Number of vertices.
	0x08 	uint16	StartTriangle		Starting triangle index (that's 3* the number of triangles drawn so far).
	0x0A 	uint16	nTriangles		Number of triangle indices.
	0x0C 	uint16	nBones			Number of elements in the bone lookup table.
	0x0E 	uint16	StartBones		Starting index in the bone lookup table.
	0x10 	uint16	Unknown			
	0x12 	uint16	RootBone		Not sure.
	0x14 	Vec3F	CenterMass		Average position of all the vertices in the submesh.
	0x20 	Vec3F	CenterBoundingBox	The center of the box when an axis aligned box is built around the vertices in the submesh.
	0x2C 	float	Radius	
	*/
	public static Submeshes read(ByteBuffer bb) {
		Submeshes result = new Submeshes();
		
		result.ID = bb.getInt();
		result.StartVertex = bb.getShort();
		result.nVertices = bb.getShort();
		result.StartTriangle = bb.getShort();
		result.nTriangles = bb.getShort();
		result.nBones = bb.getShort();
		result.StartBones = bb.getShort();
		result.Unknown = bb.getShort();
		result.RootBone = bb.getShort();
		for (int index = 0; index < 3; index ++) {
			result.CenterMass[index] = bb.getFloat();
		}
		for (int index = 0; index < 3; index ++) {
			result.CenterBoundingBox[index] = bb.getFloat();
		}
		result.Radius = bb.getFloat();
		return result;
	}
	public String toString(){ 
		return "[Submeshes]\n\tID = " + ID +
		"\n\tnStartVertex: "  + StartVertex +
		"\n\tnVertices: "  + nVertices +
		"\n\tStartTriangle: "  + StartTriangle +
		"\n\tnTriangles: "  + nTriangles +
		"\n\tnBones: "  + nBones +
		"\n\tUnknown: "  + Unknown + 
		"\n\tRadius: "  + Radius ;
	}
}
