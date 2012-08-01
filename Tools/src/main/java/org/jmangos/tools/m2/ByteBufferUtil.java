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

public class ByteBufferUtil {
	
	public static float[] readFloats(ByteBuffer bb, int length ) {
		float[] result = new float[length];
		for (int index = 0; index < length; index ++) {
			result[index] = bb.getFloat();
		}
		return result;
	}

	public static byte[] readBytes(ByteBuffer bb, int length) {
		byte[] result = new byte[length];
		for (int index = 0; index < length; index ++) {
			result[index] = bb.get();
		}
		return result;
	}

	public static short[] readShorts(ByteBuffer bb, int length) {
		short[] result = new short[length];
		for (int index = 0; index < length; index ++) {
			result[index] = bb.getShort();
		}
		return result;
	}
	
	public static int[] readInts(ByteBuffer bb, int length) {
		int[] result = new int[length];
		for (int index = 0; index < length; index ++) {
			result[index] = bb.getInt();
		}
		return result;
	}
	
	public static String readString(ByteBuffer bb, int length) {
		byte[] temp = new byte[length];
		
		bb.get(temp);
		
		return new String(temp).trim();
	}
	
	public static int normalizeByte(byte b) {
		int result = b;
		if (result < 0) {
			result = 256 + b;
		}
		return result;
	}
	
}
