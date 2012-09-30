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
package org.jmangos.realm.utils;

/**
 * The Class StringUtils.
 */
public class StringUtils {

    /** The Constant HI_BYTE_MASK. */
    private static final int HI_BYTE_MASK = 0xf0;

    /** The Constant LOW_BYTE_MASK. */
    private static final int LOW_BYTE_MASK = 0x0f;

    /** The Constant HEX_SYMBOLS. */
    private static final char[] HEX_SYMBOLS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };

    /**
     * Checks if is empty.
     * 
     * @param sequence
     *        the sequence
     * @return true, if is empty
     */
    public static boolean isEmpty(final CharSequence sequence) {

        return (sequence == null) || (sequence.length() <= 0);
    }

    /**
     * To hex string.
     * 
     * @param data
     *        the data
     * @return the string
     */
    public static String toHexString(final byte[] data) {

        final StringBuffer builder = new StringBuffer(2 * data.length);
        for (final byte item : data) {
            builder.append(HEX_SYMBOLS[(HI_BYTE_MASK & item) >>> 4]);
            builder.append(HEX_SYMBOLS[(LOW_BYTE_MASK & item)]);
        }
        return builder.toString();
    }
}
