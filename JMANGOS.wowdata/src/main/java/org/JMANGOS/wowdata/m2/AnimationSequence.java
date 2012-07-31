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

public class AnimationSequence {
	short animationID;
	short subAnimationID;
	int length;
	float movingSpeed;
	int flags;
	int flags2;
	int unknown1;
	int unknown2;
	int playbackSpeed;
	float[] boundingBox = new float[6];
	float radius;
	short nextAnimation;
	short index;
	
	public static AnimationSequence read(ByteBuffer bb) {
		AnimationSequence result = new AnimationSequence();
		
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
