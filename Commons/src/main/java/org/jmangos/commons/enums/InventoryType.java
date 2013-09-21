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
 * The Enum InventoryType.
 */
public enum InventoryType {

    /** The NON_EQUIP. */
    NON_EQUIP,

    /** The HEAD. */
    HEAD,

    /** The NECK. */
    NECK,

    /** The SHOULDERS. */
    SHOULDERS,

    /** The BODY. */
    BODY,

    /** The CHEST. */
    CHEST,

    /** The WAIST. */
    WAIST,

    /** The LEGS. */
    LEGS,

    /** The FEET. */
    FEET,

    /** The WRISTS. */
    WRISTS,

    /** The HANDS. */
    HANDS,

    /** The FINGER. */
    FINGER,

    /** The TRINKET. */
    TRINKET,

    /** The WEAPON. */
    WEAPON,

    /** The SHIELD. */
    SHIELD,

    /** The RANGED. */
    RANGED,

    /** The CLOAK. */
    CLOAK,

    /** The 2HWEAPON. */
    TWOHWEAPON,

    /** The BAG. */
    BAG,

    /** The TABARD. */
    TABARD,

    /** The ROBE. */
    ROBE,

    /** The WEAPONMAINHAND. */
    WEAPONMAINHAND,

    /** The WEAPONOFFHAND. */
    WEAPONOFFHAND,

    /** The HOLDABLE. */
    HOLDABLE,

    /** The AMMO. */
    AMMO,

    /** The THROWN. */
    THROWN,

    /** The RANGEDRIGHT. */
    RANGEDRIGHT,

    /** The QUIVER. */
    QUIVER,

    /** The RELIC. */
    RELIC;

    public static InventoryType get(final int value) {

        for (final InventoryType it : values()) {
            if (it.ordinal() == value) {
                return it;
            }
        }
        // Not found :O
        return null;
    }
}
