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
 * The Enum AccountDataType.
 */
public enum AccountDataType {

    /** The GLOBAL_CONFIG_CACHE. */
    GLOBAL_CONFIG_CACHE(0),

    /** The PER_CHARACTER_CONFIG_CACHE. */
    PER_CHARACTER_CONFIG_CACHE(1),

    /** The GLOBAL_BINDINGS_CACHE. */
    GLOBAL_BINDINGS_CACHE(2),

    /** The PER_CHARACTER_BINDINGS_CACHE. */
    PER_CHARACTER_BINDINGS_CACHE(3),

    /** The GLOBAL_MACROS_CACHE. */
    GLOBAL_MACROS_CACHE(4),

    /** The PER_CHARACTER_MACROS_CACHE. */
    PER_CHARACTER_MACROS_CACHE(5),

    /** The PER_CHARACTER_LAYOUT_CACHE. */
    PER_CHARACTER_LAYOUT_CACHE(6),

    /** The PER_CHARACTER_CHAT_CACHE. */
    PER_CHARACTER_CHAT_CACHE(7),

    /** The NUM_ACCOUNT_DATA_TYPES. */
    NUM_ACCOUNT_DATA_TYPES(8);

    /** The value. */
    private int value;

    /**
     * Instantiates a new account data type.
     * 
     * @param idval
     *        the idval
     */
    AccountDataType(final int idval) {

        this.value = idval;
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
