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
/**
 * 
 */
package org.jmangos.commons.enums;

/**
 * @author MinimaJack
 * 
 */
public enum SpellFamily {
    GENERIC,
    UNK1,                            // events, holidays
    UNUSED,
    MAGE,
    WARRIOR,
    WARLOCK,
    PRIEST,
    DRUID,
    ROGUE,
    HUNTER,
    PALADIN,
    SHAMAN,
    UNK2,                          // 2 spells (silence resistance)
    POTION,
    UNUSED2,
    DEATHKNIGHT,
    UNUSED3,
    PET;

    public static final int MAX_SPELL_FAMILY = 18;

    public static final SpellFamily get(int value) {
        if (value < MAX_SPELL_FAMILY) {
            return values()[value];
        }
        return null;
    }
}
