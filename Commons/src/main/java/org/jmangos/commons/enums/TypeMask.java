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
 * The Enum TypeMask.
 */
public enum TypeMask {

    /** The OBJECT. */
    OBJECT(0x0001),

    /** The ITEM. */
    ITEM(0x0002),

    /** The CONTAINER. */
    CONTAINER(0x0004),

    /** The UNIT. */
    UNIT(0x0008),

    /** The PLAYER. */
    PLAYER(0x0010),

    /** The GAMEOBJECT. */
    GAMEOBJECT(0x0020),

    /** The DYNAMICOBJECT. */
    DYNAMICOBJECT(0x0040),

    /** The CORPSE. */
    CORPSE(0x0080);

    /** The Constant CREATURE_OR_GAMEOBJECT. */
    final static EnumSet<TypeMask> CREATURE_OR_GAMEOBJECT = EnumSet.of(UNIT, GAMEOBJECT);

    /** The Constant CREATURE_GAMEOBJECT_OR_ITEM. */
    final static EnumSet<TypeMask> CREATURE_GAMEOBJECT_OR_ITEM = EnumSet.of(UNIT, GAMEOBJECT, ITEM);

    /** The Constant CREATURE_GAMEOBJECT_PLAYER_OR_ITEM. */
    final static EnumSet<TypeMask> CREATURE_GAMEOBJECT_PLAYER_OR_ITEM = EnumSet.of(UNIT,
            GAMEOBJECT, ITEM, PLAYER);

    /** The value. */
    private int value;

    /**
     * Instantiates a new type mask.
     * 
     * @param value
     *        the value
     */
    TypeMask(final int value) {

        setValue(value);
    }

    /**
     * Sets the value.
     * 
     * @param value
     *        the new value
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
