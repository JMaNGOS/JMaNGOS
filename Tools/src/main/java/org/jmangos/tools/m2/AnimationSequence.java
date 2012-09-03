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

public class AnimationSequence {
    
    short   animationID;
    short   subAnimationID;
    int     length;
    float   movingSpeed;
    int     flags;
    int     flags2;
    int     unknown1;
    int     unknown2;
    int     playbackSpeed;
    float[] boundingBox = new float[6];
    float   radius;
    short   nextAnimation;
    short   index;
    
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
        result.boundingBox = ByteBufferUtil.readFloats(bb, 6);
        result.radius = bb.getFloat();
        result.nextAnimation = bb.getShort();
        result.index = bb.getShort();
        
        return result;
    }
}
