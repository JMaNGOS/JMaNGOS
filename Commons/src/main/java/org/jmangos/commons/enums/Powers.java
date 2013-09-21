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

import java.util.EnumSet;

/**
 * The Enum Powers.
 */
public enum Powers {
    /** The HEALTH. */
    HEALTH, // 24

    /** The MANA. */
    MANA, // 25

    /** The RAGE. */
    RAGE, // 26

    /** The FOCUS. */
    FOCUS, // 27

    /** The ENERGY. */
    ENERGY, // 28

    /** The HAPPINESS. */
    HAPPINESS, // 29

    /** The RUNE. */
    RUNE, // 30

    /** The RUNIC_POWER. */
    RUNIC_POWER; // 31

    /** The MA x_ power. */
    public static final int MAX_POWER = 7;

    public static final EnumSet<Powers> PLAYER_CREATE_POWERS = EnumSet.of(HEALTH, MANA, RAGE,
            FOCUS, ENERGY, RUNE);

}
