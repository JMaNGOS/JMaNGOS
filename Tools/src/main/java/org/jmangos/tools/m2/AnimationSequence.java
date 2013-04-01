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

import java.nio.ByteBuffer;

/**
 * 
 * @author MinimaJack
 * 
 */
public class AnimationSequence {

    /** Constant - count coordinates in bounding box. */
    private static final int COUNT_BOUNDING_BOX_COORDS = 6;
    /**
     * animationID
     */
    private short animationID;
    /**
     * subAnimationID
     */
    private short subAnimationID;
    /**
     * length
     */
    private int length;
    /**
     * movingSpeed
     */
    private float movingSpeed;
    /**
     * flags
     */
    private int flags;
    /**
     * flags2
     */
    private int flags2;
    /**
     * unknown1
     */
    private int unknown1;
    /**
     * unknown2
     */
    private int unknown2;
    /**
     * playbackSpeed
     */
    private int playbackSpeed;
    /**
     * boundingBox
     */
    private float[] boundingBox = new float[COUNT_BOUNDING_BOX_COORDS];
    /**
     * radius
     */
    private float radius;
    /**
     * nextAnimation
     */
    private short nextAnimation;
    /**
     * index
     */
    private short index;

    /**
     * Instantiate
     */
    AnimationSequence() {

    }

    /**
     * Read AnimationSequence.
     * 
     * @param bb
     *        ByteBuffer
     * @return AnimationSequence
     */
    public static AnimationSequence read(final ByteBuffer bb) {

        final AnimationSequence result = new AnimationSequence();

        result.animationID = bb.getShort();
        result.subAnimationID = bb.getShort();
        result.length = bb.getInt();
        result.movingSpeed = bb.getFloat();
        result.flags = bb.getInt();
        result.flags2 = bb.getInt();
        result.unknown1 = bb.getInt();
        result.unknown2 = bb.getInt();
        result.playbackSpeed = bb.getInt();
        result.boundingBox = ByteBufferUtil.readFloats(bb, COUNT_BOUNDING_BOX_COORDS);
        result.radius = bb.getFloat();
        result.nextAnimation = bb.getShort();
        result.index = bb.getShort();

        return result;
    }

    /**
     * @return the animationID
     */
    public final short getAnimationID() {

        return this.animationID;
    }

    /**
     * @param givenAnimationID
     *        the animationID to set
     */
    public final void setAnimationID(final short givenAnimationID) {

        this.animationID = givenAnimationID;
    }

    /**
     * @return the subAnimationID
     */
    public final short getSubAnimationID() {

        return this.subAnimationID;
    }

    /**
     * @param givenSubAnimationID
     *        the subAnimationID to set
     */
    public final void setSubAnimationID(final short givenSubAnimationID) {

        this.subAnimationID = givenSubAnimationID;
    }

    /**
     * @return the length
     */
    public final int getLength() {

        return this.length;
    }

    /**
     * @param givenLength
     *        the length to set
     */
    public final void setLength(final int givenLength) {

        this.length = givenLength;
    }

    /**
     * @return the movingSpeed
     */
    public final float getMovingSpeed() {

        return this.movingSpeed;
    }

    /**
     * @param givenMovingSpeed
     *        the movingSpeed to set
     */
    public final void setMovingSpeed(final float givenMovingSpeed) {

        this.movingSpeed = givenMovingSpeed;
    }

    /**
     * @return the flags
     */
    public final int getFlags() {

        return this.flags;
    }

    /**
     * @param givenFlags
     *        the flags to set
     */
    public final void setFlags(final int givenFlags) {

        this.flags = givenFlags;
    }

    /**
     * @return the flags2
     */
    public final int getFlags2() {

        return this.flags2;
    }

    /**
     * @param givenFlags2
     *        the flags2 to set
     */
    public final void setFlags2(final int givenFlags2) {

        this.flags2 = givenFlags2;
    }

    /**
     * @return the unknown1
     */
    public final int getUnknown1() {

        return this.unknown1;
    }

    /**
     * @param givenUnknown1
     *        the unknown1 to set
     */
    public final void setUnknown1(final int givenUnknown1) {

        this.unknown1 = givenUnknown1;
    }

    /**
     * @return the unknown2
     */
    public final int getUnknown2() {

        return this.unknown2;
    }

    /**
     * @param givenUnknown2
     *        the unknown2 to set
     */
    public final void setUnknown2(final int givenUnknown2) {

        this.unknown2 = givenUnknown2;
    }

    /**
     * @return the playbackSpeed
     */
    public final int getPlaybackSpeed() {

        return this.playbackSpeed;
    }

    /**
     * @param givenPlaybackSpeed
     *        the playbackSpeed to set
     */
    public final void setPlaybackSpeed(final int givenPlaybackSpeed) {

        this.playbackSpeed = givenPlaybackSpeed;
    }

    /**
     * @return the boundingBox
     */
    public final float[] getBoundingBox() {

        return this.boundingBox;
    }

    /**
     * @param givenBoundingBox
     *        the boundingBox to set
     */
    public final void setBoundingBox(final float[] givenBoundingBox) {

        this.boundingBox = givenBoundingBox;
    }

    /**
     * @return the radius
     */
    public final float getRadius() {

        return this.radius;
    }

    /**
     * @param givenRadius
     *        the radius to set
     */
    public final void setRadius(final float givenRadius) {

        this.radius = givenRadius;
    }

    /**
     * @return the nextAnimation
     */
    public final short getNextAnimation() {

        return this.nextAnimation;
    }

    /**
     * @param givenNextAnimation
     *        the nextAnimation to set
     */
    public final void setNextAnimation(final short givenNextAnimation) {

        this.nextAnimation = givenNextAnimation;
    }

    /**
     * @return the index
     */
    public final short getIndex() {

        return this.index;
    }

    /**
     * @param givenIndex
     *        the index to set
     */
    public final void setIndex(final short givenIndex) {

        this.index = givenIndex;
    }
}
