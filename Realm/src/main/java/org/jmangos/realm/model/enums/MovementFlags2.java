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
package org.jmangos.realm.model.enums;

/**
 * The Enum MovementFlags2.
 */
public enum MovementFlags2 {
    
    /** The NONE. */
    NONE(0),
    
    /** The NO_STRAFE. */
    NO_STRAFE(1 << 0),
    
    /** The NO_JUMPING. */
    NO_JUMPING(1 << 1),
    
    /** The UNKNOWN3. */
    UNKNOWN3(1 << 2),
    
    /** The FULLSPEEDTURNING. */
    FULLSPEEDTURNING(1 << 3),
    
    /** The FULLSPEEDPITCHING. */
    FULLSPEEDPITCHING(1 << 4),
    
    /** The ALWAYSALLOWPITCHING. */
    ALLOWPITCHING(1 << 5),
    
    /** The UNKNOWN4. */
    UNKNOWN4(1 << 6),
    
    /** The UNKNOWN5. */
    UNKNOWN5(1 << 7),
    
    /** The UNKNOWN6. */
    UNKNOWN6(1 << 8),
    
    /** The UNKNOWN7. */
    UNKNOWN7(1 << 9),
    
    /** The INTERPOLATED_MOVEMENT. */
    INTERPOLATED_MOVEMENT(1 << 10),
    
    /** The INTERPOLATED_TURNING. */
    INTERPOLATED_TURNING(1 << 11),
    
    /** The INTERPOLATED_PITCHING. */
    INTERPOLATED_PITCHING(1 << 12),
    
    /** The UNKNOWN8. */
    UNKNOWN8(1 << 13),
    
    /** The UNKNOWN9. */
    UNKNOWN9(1 << 14),
    
    /** The UNKNOWN10. */
    UNKNOWN10(1 << 15);
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new movement flags.
     * 
     * @param flag
     *            the flag
     */
    MovementFlags2(final int flag) {
    
        value = flag;
    }
    
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {
    
        return this.value;
    }
    
    public static MovementFlags2 get(int value) {
    
        for (MovementFlags2 val : values()) {
            if (val.getValue() == value)
                return val;
        }
        return null;
    }
    
    public boolean contains(int val) {
    
        for (MovementFlags2 values : values()) {
            if ((values.getValue() & val) == values.getValue())
                return true;
        }
        return false;
    }
}
