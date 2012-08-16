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
package org.jmangos.realm.model.unit;

// TODO: Auto-generated Javadoc
/**
 * The Enum MovementFlags.
 */
public enum MovementFlags {
    
    /** The MOVEFLA g_ none. */
    MOVEFLAG_NONE(0),
    
    /** The MOVEFLA g_ forward. */
    MOVEFLAG_FORWARD(1 << 0),
    
    /** The MOVEFLA g_ backward. */
    MOVEFLAG_BACKWARD(1 << 1),
    
    /** The MOVEFLA g_ straf e_ left. */
    MOVEFLAG_STRAFE_LEFT(1 << 2),
    
    /** The MOVEFLA g_ straf e_ right. */
    MOVEFLAG_STRAFE_RIGHT(1 << 3),
    
    /** The MOVEFLA g_ tur n_ left. */
    MOVEFLAG_TURN_LEFT(1 << 4),
    
    /** The MOVEFLA g_ tur n_ right. */
    MOVEFLAG_TURN_RIGHT(1 << 5),
    
    /** The MOVEFLA g_ pitc h_ up. */
    MOVEFLAG_PITCH_UP(1 << 6),
    
    /** The MOVEFLA g_ pitc h_ down. */
    MOVEFLAG_PITCH_DOWN(1 << 7),
    
    /** The MOVEFLA g_ wal k_ mode. */
    MOVEFLAG_WALK_MODE(1 << 8), // Walking
    /** The MOVEFLA g_ ontransport. */
    MOVEFLAG_ONTRANSPORT(1 << 9),
    
    /** The MOVEFLA g_ levitating. */
    MOVEFLAG_LEVITATING(1 << 10),
    
    /** The MOVEFLA g_ root. */
    MOVEFLAG_ROOT(1 << 11),
    
    /** The MOVEFLA g_ falling. */
    MOVEFLAG_FALLING(1 << 12),
    
    /** The MOVEFLA g_ fallingfar. */
    MOVEFLAG_FALLINGFAR(1 << 13),
    
    /** The MOVEFLA g_ pendingstop. */
    MOVEFLAG_PENDINGSTOP(1 << 14),
    
    /** The MOVEFLA g_ pendingstrafestop. */
    MOVEFLAG_PENDINGSTRAFESTOP(1 << 15),
    
    /** The MOVEFLA g_ pendingforward. */
    MOVEFLAG_PENDINGFORWARD(1 << 16),
    
    /** The MOVEFLA g_ pendingbackward. */
    MOVEFLAG_PENDINGBACKWARD(1 << 17),
    
    /** The MOVEFLA g_ pendingstrafeleft. */
    MOVEFLAG_PENDINGSTRAFELEFT(1 << 18),
    
    /** The MOVEFLA g_ pendingstraferight. */
    MOVEFLAG_PENDINGSTRAFERIGHT(1 << 19),
    
    /** The MOVEFLA g_ pendingroot. */
    MOVEFLAG_PENDINGROOT(1 << 20),
    
    /** The MOVEFLA g_ swimming. */
    MOVEFLAG_SWIMMING(1 << 21), // appears with fly flag also
    /** The MOVEFLA g_ ascending. */
    MOVEFLAG_ASCENDING(1 << 22), // swim up also
    /** The MOVEFLA g_ descending. */
    MOVEFLAG_DESCENDING(1 << 23), // swim down also
    /** The MOVEFLA g_ ca n_ fly. */
    MOVEFLAG_CAN_FLY(1 << 24), // can fly in 3.3?
    /** The MOVEFLA g_ flying. */
    MOVEFLAG_FLYING(1 << 25), // Actual flying mode
    /** The MOVEFLA g_ splin e_ elevation. */
    MOVEFLAG_SPLINE_ELEVATION(1 << 26), // used for flight paths
    /** The MOVEFLA g_ splin e_ enabled. */
    MOVEFLAG_SPLINE_ENABLED(1 << 27), // used for flight paths
    /** The MOVEFLA g_ waterwalking. */
    MOVEFLAG_WATERWALKING(1 << 28), // prevent unit from falling through water
    /** The MOVEFLA g_ saf e_ fall. */
    MOVEFLAG_SAFE_FALL(1 << 29), // active rogue safe fall spell (passive)
    /** The MOVEFLA g_ hover. */
    MOVEFLAG_HOVER(1 << 30);
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new movement flags.
     * 
     * @param flag
     *            the flag
     */
    MovementFlags(final int flag) {
    
        setValue(flag);
    }
    
    /**
     * Sets the value.
     * 
     * @param value
     *            the new value
     */
    public void setValue(final int value) {
    
        this.value = value;
    }
    
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {
    
        return this.value;
    }
}
