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
package org.jmangos.commons.enums;

/**
 * The Enum Unit Move Type.
 */
public enum UnitMoveType {

    /** The WALK. */
    WALK,

    /** The RUN. */
    RUN,

    /** The RUN_BACK. */
    RUN_BACK,

    /** The SWIM. */
    SWIM,

    /** The SWIM_BACK. */
    SWIM_BACK,

    /** The TURN_RATE. */
    TURN_RATE,

    /** The FLIGHT. */
    FLIGHT,

    /** The FLIGHT_BACK. */
    FLIGHT_BACK,

    /** The PITCH_RATE. */
    PITCH_RATE;

    /** The Constant MAX_TYPE. */
    public final static int MAX_TYPE = 9;
}
