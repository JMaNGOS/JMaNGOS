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
package org.jmangos.tools.openGL;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.util.glu.GLU.gluLookAt;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

/**
 * Camera class.
 */

public final class Camera {

    /** A zero vector. **/
    private final Vector3f vZero = new Vector3f(0.0f, 0.0f, 0.0f);

    /** The view vector. **/
    private final Vector3f vView = new Vector3f(0.0f, 1.0f, 0.5f);

    /** Up vector (rarely changed). **/
    private final Vector3f vUp = new Vector3f(0.0f, 0.0f, 1.0f);

    /** Strafe vector. **/
    private Vector3f m_vStrafe = new Vector3f();

    /** Position vector. **/
    private Vector3f m_vPosition = this.vZero;

    /** View Vector. **/
    private Vector3f m_vView = this.vView;

    /** up vector. **/
    private Vector3f m_vUpVector = this.vUp;

    /** View by mouse ? Default = false. **/
    private boolean viewByMouse = false;

    /** Is mouse inverted ? Default = false. **/
    private boolean mouseInverted = false;

    /** Mouse sensibility. **/
    private float mouseSensibility = 750.0f;

    /** Current mouse rotation on X axis. **/
    private float currentRotX = 0.0f;

    /** Fixed on X axis ? **/
    private boolean fixedX = false;

    /** Fixed on Y axis ? **/
    private boolean fixedY = false;

    /** Fixed on Z axis ? **/
    private boolean fixedZ = false;

    private float radius;

    private Vector3f pr; /*
                          * Point to rotate
                          * about
                          */
    private float focallength; /*
                                * Focal Length along
                                * vd
                                */
    private float aperture; /* Camera aperture */
    private float eyesep; /* Eye separation */

    /**  **/
    public final static int X_AXIS = 0;

    /**  **/
    public final static int Y_AXIS = 1;

    /**  **/
    public final static int Z_AXIS = 2;

    /**
     * Camera constructor.
     */

    public Camera() {

    }

    /**
     * Camera constructor.
     * 
     * @param vbm
     *        View by mouse statement.
     */

    public Camera(final boolean vbm) {

        this.viewByMouse = vbm;
    }

    /**
     * Change the view by mouse statement.
     * 
     * @param vbm
     *        View by mouse statement.
     */

    public final void setViewByMouse(final boolean vbm) {

        this.viewByMouse = vbm;
    }

    public final boolean getViewByMouse() {

        return this.viewByMouse;
    }

    /**
     * Change mouse Y movement type.
     * 
     * @param inverted
     *        Mouse Inverted ?
     */

    public final void setMouseInverted(final boolean inverted) {

        this.mouseInverted = inverted;
    }

    public Vector3f getVview() {

        return this.m_vView;
    }

    /**
     * Change mouse sensibility.
     * 
     * @param s
     *        Mouse sensibility (high = less sensible).
     */

    public final void setMouseSensibility(final float s) {

        this.mouseSensibility = s;
    }

    public final void setVview(final float y) {

        this.m_vPosition.y = 0;
    }

    /**
     * Set camera fixed to an axis.
     * 
     * @param axis
     *        <code>Camera.X_AXIS</code> or <code>Camera.Y_AXIS</code> or
     *        <code>Camera.Z_AXIS</code>.
     */

    public final void setFixedAxis(final int axis) {

        if (axis == X_AXIS) {
            this.fixedX = true;
        } else if (axis == Y_AXIS) {
            this.fixedY = true;
        } else if (axis == Z_AXIS) {
            this.fixedZ = true;
        }
    }

    /**
     * Change the camera position.
     * 
     * @param positionX
     *        Position X.
     * @param positionY
     *        Position Y.
     * @param positionZ
     *        Position Z.
     * @param viewX
     *        View X.
     * @param viewY
     *        View Y.
     * @param viewZ
     *        View Z.
     * @param upVectorX
     *        Up vector X.
     * @param upVectorY
     *        Up vector Y.
     * @param upVectorZ
     *        Up vector Z.
     */

    public final void setPosition(final float positionX, final float positionY,
            final float positionZ, final float viewX, final float viewY, final float viewZ,
            final float upVectorX, final float upVectorY, final float upVectorZ) {

        this.m_vPosition = new Vector3f(positionX, positionY, positionZ);
        this.m_vView = new Vector3f(viewX, viewY, viewZ);
        this.m_vUpVector = new Vector3f(upVectorX, upVectorY, upVectorZ);
    }

    public final Vector3f[] getPositionCamera() {

        final Vector3f[] position = { this.m_vPosition, this.m_vView, this.m_vUpVector };
        return position;
    }

    public void setPosition(final Vector3f m_vPosition) {

        this.m_vPosition.set(m_vPosition);
    }

    public void setView(final Vector3f m_vView) {

        this.m_vView.set(m_vView);
    }

    public void setUpVector(final Vector3f m_vUpVector) {

        this.m_vUpVector.set(m_vUpVector);
    }

    public final Vector3f getPosition() {

        return this.m_vPosition;
    }

    public final Vector3f getView() {

        return this.m_vView;
    }

    public final Vector3f getUpVector() {

        return this.m_vUpVector;
    }

    /**
     * Move the camera (forward if speed is positive).
     * 
     * @param speed
     *        The camera speed.
     */

    public final void move(final float speed) {

        Vector3f vVector = new Vector3f();

        // Get our view vector (The direction we are facing).
        vVector = Vector3f.sub(this.m_vView, this.m_vPosition, vVector);

        // That way you don't move faster than you strafe, since the strafe
        // vector
        // is normalized too.
        vVector.normalise();

        // Fixed axis ?
        if (!this.fixedX) {
            this.m_vPosition.x += vVector.x * speed;
            this.m_vView.x += vVector.x * speed;
        }
        if (!this.fixedY) {
            this.m_vPosition.y += vVector.y * speed;
            this.m_vView.y += vVector.y * speed;
        }
        if (!this.fixedZ) {
            this.m_vPosition.z += vVector.z * speed;
            this.m_vView.z += vVector.z * speed;
        }
    }

    /**
     * Set the view according to the mouse position.
     */

    private final void mouse_view() {

        float angleY = 0.0f;
        float angle_product = 0.0f;
        final Vector3f vAxis;

        // Get the direction the mouse moved in, but bring the number down to a
        // reasonable amount.
        angleY = -(float) (Mouse.getDX()) / this.mouseSensibility;
        angle_product = (Mouse.getDY()) / this.mouseSensibility;

        // If mouse is inverted, invert rotation on angle_product axis.
        if (this.mouseInverted) {
            angle_product = -angle_product;
        }

        // Here we keep track of the current rotation (for up and down) so that
        // we can restrict the camera from doing a full 360 loop.
        this.currentRotX -= angle_product;

        // If the current rotation (in radians) is greater than 1.0, we want to
        // cap it.
        if (this.currentRotX > 90.0f) {
            this.currentRotX = 90.0f;
        } else if (this.currentRotX < -90.0f) {
            this.currentRotX = -90.0f;
        } else {

            vAxis =
                    Vector3f.cross(Vector3f.sub(this.m_vView, this.m_vPosition, null),
                            this.m_vUpVector, null);
            vAxis.normalise();

            // Rotate around our perpendicular axis and along the y-axis.
            rotateWithQuaternion(angle_product, vAxis.x, vAxis.y, vAxis.z);
            rotateWithQuaternion(angleY, 0, 1, 0);
        }
    }

    /**
     * This rotates the view around the position using an axis-angle rotation.
     * 
     * @param angle
     *        Rotation angle.
     * @param x
     *        On X axis.
     * @param y
     *        On Y axis.
     * @param z
     *        On Z axis.
     */

    @SuppressWarnings("unused")
    private final void rotate(final float angle, final float x, final float y, final float z) {

        final Vector3f vNewView = new Vector3f();
        final Vector3f vView = new Vector3f();

        // Get our view vector (The direction we are facing).

        vView.x = this.m_vView.x - this.m_vPosition.x; // This gets the
                                                       // direction of the
        // X.
        vView.y = this.m_vView.y - this.m_vPosition.y; // This gets the
                                                       // direction of the
        // Y.
        vView.z = this.m_vView.z - this.m_vPosition.z; // This gets the
                                                       // direction of the
        // Z.

        // Calculate the sine and cosine of the angle once.
        final float cosTheta = (float) cos(angle);
        final float sinTheta = (float) sin(angle);

        // Find the new x position for the new rotated point.
        vNewView.x = (cosTheta + ((1 - cosTheta) * x * x)) * vView.x;
        vNewView.x += (((1 - cosTheta) * x * y) - (z * sinTheta)) * vView.y;
        vNewView.x += (((1 - cosTheta) * x * z) + (y * sinTheta)) * vView.z;

        // Find the new y position for the new rotated point.
        vNewView.y = (((1 - cosTheta) * x * y) + (z * sinTheta)) * vView.x;
        vNewView.y += (cosTheta + ((1 - cosTheta) * y * y)) * vView.y;
        vNewView.y += (((1 - cosTheta) * y * z) - (x * sinTheta)) * vView.z;

        // Find the new z position for the new rotated point.
        vNewView.z = (((1 - cosTheta) * x * z) - (y * sinTheta)) * vView.x;
        vNewView.z += (((1 - cosTheta) * y * z) + (x * sinTheta)) * vView.y;
        vNewView.z += (cosTheta + ((1 - cosTheta) * z * z)) * vView.z;

        // Now we just add the newly rotated vector to our position to set.
        // our new rotated view of our camera.
        this.m_vView.x = this.m_vPosition.x + vNewView.x;
        this.m_vView.y = this.m_vPosition.y + vNewView.y;
        this.m_vView.z = this.m_vPosition.z + vNewView.z;
    }

    private final void rotateWithQuaternion(final float angleDir, final float xSpeed,
            final float ySpeed, final float zSpeed) {

        final Quaternion qRotation = new Quaternion();
        final Quaternion qView = new Quaternion();
        final Quaternion qNewView = new Quaternion();

        // Create the rotation quaternion based on the axis we are rotating on.
        qRotation.setFromAxisAngle(new Vector4f(xSpeed, ySpeed, zSpeed, angleDir));

        // Create the view quaternion. This will be the direction of the view
        // and position.
        qView.x = this.m_vView.x - this.m_vPosition.x; // This gets the
                                                       // direction of the
        // X.
        qView.y = this.m_vView.y - this.m_vPosition.y; // This gets the
                                                       // direction of the
        // Y.
        qView.z = this.m_vView.z - this.m_vPosition.z; // This gets the
                                                       // direction of the
        // Z.
        qView.w = 0;

        // Create the resulting quaternion by multiplying the rotation quat by
        // the view quat
        // then multiplying that by the conjugate of the rotation quat.

        final Quaternion dv = new Quaternion();
        final Quaternion nqRotation = new Quaternion();
        Quaternion.mul(qRotation, qView, dv);
        qRotation.negate(nqRotation);
        Quaternion.mul(dv, nqRotation, qNewView);

        // Update the view information by adding the position to the resulting
        // quaternion.
        this.m_vView.x = this.m_vPosition.x + qNewView.x;
        this.m_vView.y = this.m_vPosition.y + qNewView.y;
        this.m_vView.z = this.m_vPosition.z + qNewView.z;

    }

    /**
     * Strafe the camera (left or right, depending on the speed).
     * 
     * @param speed
     *        The camera moving speed.
     */

    public final void strafe(final float speed) {

        // Add the strafe vector to our position.
        this.m_vPosition.x += this.m_vStrafe.x * speed;
        this.m_vPosition.z += this.m_vStrafe.z * speed;

        // Add the strafe vector to our view.
        this.m_vView.x += this.m_vStrafe.x * speed;
        this.m_vView.z += this.m_vStrafe.z * speed;
    }

    /**
     * Update the camera state.
     */

    public final void update() {

        // Normalize the strafe vector.
        this.m_vStrafe =
                Vector3f.cross(Vector3f.sub(this.m_vView, this.m_vPosition, null),
                        this.m_vUpVector, null);
        this.m_vStrafe.normalise();

        // View by mouse if enabled.
        if (this.viewByMouse) {
            mouse_view();
        }
    }

    /**
     * Update camera view.
     */

    public final void look() {

        gluLookAt(this.m_vPosition.x, this.m_vPosition.y, this.m_vPosition.z, this.m_vView.x,
                this.m_vView.y, this.m_vView.z, this.m_vUpVector.x, this.m_vUpVector.y,
                this.m_vUpVector.z);
    }

    /**
     * @param radius
     *        the radius to set
     */
    public void setRadius(final float radius) {

        this.radius = radius;
    }

    /**
     * @return the radius
     */
    public float getRadius() {

        return this.radius;
    }

    /**
     * @param pr
     *        the pr to set
     */
    public void setPr(final Vector3f pr) {

        this.pr = pr;
    }

    /**
     * @return the pr
     */
    public Vector3f getPr() {

        return this.pr;
    }

    /**
     * @param focallength
     *        the focallength to set
     */
    public void setFocallength(final float focallength) {

        this.focallength = focallength;
    }

    /**
     * @return the focallength
     */
    public float getFocallength() {

        return this.focallength;
    }

    /**
     * @param aperture
     *        the aperture to set
     */
    public void setAperture(final float aperture) {

        this.aperture = aperture;
    }

    /**
     * @return the aperture
     */
    public float getAperture() {

        return this.aperture;
    }

    /**
     * @param eyesep
     *        the eyesep to set
     */
    public void setEyesep(final float eyesep) {

        this.eyesep = eyesep;
    }

    /**
     * @return the eyesep
     */
    public float getEyesep() {

        return this.eyesep;
    }

    public Ray getRayFromMouse() {

        int mousex = 0, mousey = 0;
        mousex = Mouse.getX();
        mousey = Mouse.getY();
        final FloatBuffer projection = BufferUtils.createFloatBuffer(16);
        final FloatBuffer modelview = BufferUtils.createFloatBuffer(16);
        final IntBuffer viewport = BufferUtils.createIntBuffer(16);
        final FloatBuffer position = BufferUtils.createFloatBuffer(3);
        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelview);
        GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projection);
        GL11.glGetInteger(GL11.GL_VIEWPORT, viewport);

        GLU.gluUnProject(mousex, mousey, 1, modelview, projection, viewport, position);
        final Vector3f near = new Vector3f(position.get(0), position.get(1), position.get(2));
        // reuse buffers
        // near = eyeOut;
        projection.rewind();
        modelview.rewind();
        viewport.rewind();
        position.rewind();
        GLU.gluUnProject(mousex, mousey, 0, modelview, projection, viewport, position);
        final Vector3f far = new Vector3f(position.get(0), position.get(1), position.get(2));
        Vector3f.sub(near, far, this.vView);
        this.vView.normalise();
        return new Ray(this.m_vPosition, this.vView);
    }
}
