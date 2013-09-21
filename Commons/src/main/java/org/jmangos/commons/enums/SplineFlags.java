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
package org.jmangos.commons.enums;

/**
 * The Enum SplineFlags.
 */
public enum SplineFlags {

    /** The NONE. */
    NONE(0),

    /** The DONE. */
    DONE(1 << 8),
    /** The NO_SPLINE. */
    NO_SPLINE(1 << 9),

    /** The PARABOLIC. */
    PARABOLIC(1 << 10),

    /** The WALKMODE. */
    WALKMODE(1 << 11),

    /** The FLYING. */
    FLYING(1 << 12),

    /** The ORIENTATION_FIXED. */
    ORIENTATION_FIXED(1 << 13),

    /** The FINAL_POINT. */
    FINAL_POINT(1 << 14),

    /** The FINAL_TARGET. */
    FINAL_TARGET(1 << 15),

    /** The FINAL_ORIENT. */
    FINAL_ORIENT(1 << 16),

    /** The CATMULLROM. */
    CATMULLROM(1 << 17),

    /** The CYCLIC. */
    CYCLIC(1 << 18),

    /** The ENTER_CYCLE. */
    ENTER_CYCLE(1 << 19),

    /** The ANIMATION. */
    ANIMATION(1 << 20),

    /** The FROZEN. */
    FROZEN(1 << 21),

    /** The UNKNOWN5. */
    UNKNOWN5(1 << 22),

    /** The UNKNOWN6. */
    UNKNOWN6(1 << 23),

    /** The UNKNOWN7. */
    UNKNOWN7(1 << 24),

    /** The UNKNOWN8. */
    UNKNOWN8(1 << 25),

    /** The ORIENTATION_REVERSED. */
    ORIENTATION_REVERSED(1 << 26),

    /** The UNKNOWN10. */
    UNKNOWN10(1 << 25),

    /** The UNKNOWN11. */
    UNKNOWN11(1 << 25),

    /** The UNKNOWN12. */
    UNKNOWN12(1 << 25),

    /** The UNKNOWN13. */
    UNKNOWN13(1 << 25);

    /** The value. */
    private int value;

    /**
     * Instantiates a new spline flags.
     * 
     * @param flag
     *        the flag
     */
    SplineFlags(final int flag) {

        this.value = flag;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {

        return this.value;
    }

    public static SplineFlags get(final int value) {

        for (final SplineFlags val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }
        return null;
    }

    public boolean contains(final int val) {

        for (final SplineFlags values : values()) {
            if ((values.getValue() & val) == values.getValue()) {
                return true;
            }
        }
        return false;
    }
}
