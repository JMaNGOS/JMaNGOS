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
 * The Enum MovementFlags.
 */
public enum MovementFlags {
    
    /** The NONE. */
    NONE(0),
    
    /** The FORWARD. */
    FORWARD(1 << 0),
    
    /** The BACKWARD. */
    BACKWARD(1 << 1),
    
    /** The STRAFE_LEFT. */
    STRAFE_LEFT(1 << 2),
    
    /** The STRAFE_RIGHT. */
    STRAFE_RIGHT(1 << 3),
    
    /** The TURN_LEFT. */
    TURN_LEFT(1 << 4),
    
    /** The TURN_RIGHT. */
    TURN_RIGHT(1 << 5),
    
    /** The PITCH_UP. */
    PITCH_UP(1 << 6),
    
    /** The PITCH_DOWN. */
    PITCH_DOWN(1 << 7),
    
    /** The WALK_MODE. */
    WALK_MODE(1 << 8),
    
    /** The ONTRANSPORT. */
    ONTRANSPORT(1 << 9),
    
    /** The LEVITATING. */
    LEVITATING(1 << 10),
    
    /** The ROOT. */
    ROOT(1 << 11),
    
    /** The FALLING. */
    FALLING(1 << 12),
    
    /** The FALLINGFAR. */
    FALLINGFAR(1 << 13),
    
    /** The PENDINGSTOP. */
    PENDINGSTOP(1 << 14),
    
    /** The PENDINGSTRAFESTOP. */
    PENDINGSTRAFESTOP(1 << 15),
    
    /** The PENDINGFORWARD. */
    PENDINGFORWARD(1 << 16),
    
    /** The PENDINGBACKWARD. */
    PENDINGBACKWARD(1 << 17),
    
    /** The PENDINGSTRAFELEFT. */
    PENDINGSTRAFELEFT(1 << 18),
    
    /** The PENDINGSTRAFERIGHT. */
    PENDINGSTRAFERIGHT(1 << 19),
    
    /** The PENDINGROOT. */
    PENDINGROOT(1 << 20),
    
    /** The SWIMMING. */
    SWIMMING(1 << 21),
    
    /** The ASCENDING. */
    ASCENDING(1 << 22),
    
    /** The DESCENDING. */
    DESCENDING(1 << 23),
    
    /** The CAN_FLY. */
    CAN_FLY(1 << 24),
    
    /** The MOVEFLA FLYING. */
    FLYING(1 << 25),
    
    /** The MOVEFLA SPLINE_ELEVATION. */
    SPLINE_ELEVATION(1 << 26),
    
    /** The MOVEFLA SPLINE_ENABLED. */
    SPLINE_ENABLED(1 << 27),
    
    /** The WATERWALKING. */
    WATERWALKING(1 << 28),
    
    /** The SAFE_FALL. */
    SAFE_FALL(1 << 29),
    
    /** The HOVER. */
    HOVER(1 << 30);
    
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
