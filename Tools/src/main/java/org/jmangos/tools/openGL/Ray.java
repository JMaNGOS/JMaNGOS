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
package org.jmangos.tools.openGL;

import org.lwjgl.util.vector.Vector3f;

public class Ray {

    private static float eps = (float) 10e-6;
    public Vector3f Position;
    public Vector3f Direction;

    public Ray(final Vector3f rayPosition, final Vector3f rayDirection) {

        this.Position = rayPosition;
        this.Direction = rayDirection;
    }

    public float IntersectsTriangle(final Vector3f vertex1, final Vector3f vertex2,
            final Vector3f vertex3) {

        // Compute vectors along two edges of the triangle.
        Vector3f edge1 = new Vector3f();
        Vector3f edge2 = new Vector3f();

        edge1 = Vector3f.sub(vertex2, vertex1, edge1);
        edge2 = Vector3f.sub(vertex3, vertex1, edge2);

        // Compute the determinant.
        final Vector3f directionCrossEdge2 = new Vector3f();
        Vector3f.cross(this.Direction, edge2, directionCrossEdge2);

        final float determinant = Vector3f.dot(directionCrossEdge2, edge1);
        // If the ray and triangle are parallel, there is no collision.
        if ((determinant > -eps) && (determinant < eps)) {
            return 0;
        }

        final float inverseDeterminant = 1.0f / determinant;

        // Calculate the U parameter of the intersection point.
        final Vector3f distanceVector = new Vector3f();
        Vector3f.sub(this.Position, vertex1, distanceVector);

        float triangleU = Vector3f.dot(directionCrossEdge2, distanceVector);
        triangleU *= inverseDeterminant;

        // Make sure the U is inside the triangle.
        if ((triangleU < -eps) || (triangleU > (1 + eps))) {
            return 0;
        }

        // Calculate the V parameter of the intersection point.
        final Vector3f distanceCrossEdge1 = new Vector3f();
        Vector3f.cross(distanceVector, edge1, distanceCrossEdge1);

        float triangleV = Vector3f.dot(this.Direction, distanceCrossEdge1);
        triangleV *= inverseDeterminant;

        // Make sure the V is inside the triangle.
        if ((triangleV < -eps) || ((triangleU + triangleV) > (1 + eps))) {
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
