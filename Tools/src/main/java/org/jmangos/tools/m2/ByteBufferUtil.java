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
import java.nio.charset.Charset;

/**
 * 
 * @author MinimaJack
 * 
 */
public final class ByteBufferUtil {

    /**
     * hide constructor
     */
    private ByteBufferUtil() {

    }

    /**
     * 
     * @param bb
     *        ByteBuffer
     * @param length
     *        count floats
     * @return float array
     */
    public static float[] readFloats(final ByteBuffer bb, final int length) {

        final float[] result = new float[length];
        for (int index = 0; index < length; index++) {
            result[index] = bb.getFloat();
        }
        return result;
    }

    /**
     * 
     * @param bb
     *        ByteBuffer
     * @param length
     *        count Bytes
     * @return bytes array
     */
    public static byte[] readBytes(final ByteBuffer bb, final int length) {

        final byte[] result = new byte[length];
        for (int index = 0; index < length; index++) {
            result[index] = bb.get();
        }
        return result;
    }

    /**
     * 
     * @param bb
     *        ByteBuffer
     * @param length
     *        count Shorts
     * @return Shorts array
     */
    public static short[] readShorts(final ByteBuffer bb, final int length) {

        final short[] result = new short[length];
        for (int index = 0; index < length; index++) {
            result[index] = bb.getShort();
        }
        return result;
    }

    /**
     * 
     * @param bb
     *        ByteBuffer
     * @param length
     *        count ints
     * @return ints array
     */
    public static int[] readInts(final ByteBuffer bb, final int length) {

        final int[] result = new int[length];
        for (int index = 0; index < length; index++) {
            result[index] = bb.getInt();
        }
        return result;
    }

    /**
     * 
     * @param bb
     *        ByteBuffer
     * @param length
     *        length string
     * @return read String
     */
    public static String readString(final ByteBuffer bb, final int length) {

        final byte[] temp = new byte[length];
        bb.get(temp);
        return new String(temp, Charset.forName("UTF-8")).trim();
    }
}
