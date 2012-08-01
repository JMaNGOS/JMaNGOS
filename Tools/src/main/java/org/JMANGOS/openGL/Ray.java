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
package org.JMANGOS.openGL;

import org.lwjgl.util.vector.Vector3f;

public class Ray {
	private static float eps = (float) 10e-6;
	public Vector3f Position;
	public Vector3f Direction;

	public Ray(Vector3f rayPosition, Vector3f rayDirection) {
		this.Position = rayPosition;
		this.Direction = rayDirection;
	}

	public float IntersectsTriangle(Vector3f vertex1,
			Vector3f vertex2, Vector3f vertex3) {
		// Compute vectors along two edges of the triangle.
		Vector3f edge1 = new Vector3f();
		Vector3f edge2 = new Vector3f();

		edge1 = Vector3f.sub(vertex2, vertex1, edge1);
		edge2 = Vector3f.sub(vertex3, vertex1, edge2);

		// Compute the determinant.
		Vector3f directionCrossEdge2 = new Vector3f();
		Vector3f.cross(Direction, edge2, directionCrossEdge2);

		float determinant = Vector3f.dot(directionCrossEdge2, edge1);
		// If the ray and triangle are parallel, there is no collision.
		if (determinant > -eps && determinant < eps) {
			return 0;
		}

		float inverseDeterminant = 1.0f / determinant;

		// Calculate the U parameter of the intersection point.
		Vector3f distanceVector = new Vector3f();
		Vector3f.sub(Position, vertex1, distanceVector);

		float triangleU = Vector3f.dot(directionCrossEdge2, distanceVector);
		triangleU *= inverseDeterminant;

		// Make sure the U is inside the triangle.
		if (triangleU < -eps || triangleU > (1 + eps)) {
			return 0;
		}

		// Calculate the V parameter of the intersection point.
		Vector3f distanceCrossEdge1 = new Vector3f();
		Vector3f.cross(distanceVector, edge1, distanceCrossEdge1);

		float triangleV = Vector3f.dot(Direction, distanceCrossEdge1);
		triangleV *= inverseDeterminant;

		// Make sure the V is inside the triangle.
		if (triangleV < -eps || (triangleU + triangleV) > (1 + eps)) {
			return 0;
		}

		// Get the distance to the face from our ray origin
		float rayDistance = Vector3f.dot(distanceCrossEdge1, edge2);
		rayDistance *= inverseDeterminant;

		// Is the triangle behind us?
		if (rayDistance < 0) {
			rayDistance *= -1;
			return 0;
		}
		return rayDistance;
	}

}
