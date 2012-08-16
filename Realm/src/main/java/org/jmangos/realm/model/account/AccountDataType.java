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
package org.jmangos.realm.model.account;

// TODO: Auto-generated Javadoc
/**
 * The Enum AccountDataType.
 */
public enum AccountDataType {
    
    /** The GLOBA l_ confi g_ cache. */
    GLOBAL_CONFIG_CACHE(0), // 0x01 g
    /** The PE r_ characte r_ confi g_ cache. */
    PER_CHARACTER_CONFIG_CACHE(1), // 0x02 p
    /** The GLOBA l_ binding s_ cache. */
    GLOBAL_BINDINGS_CACHE(2), // 0x04 g
    /** The PE r_ characte r_ binding s_ cache. */
    PER_CHARACTER_BINDINGS_CACHE(3), // 0x08 p
    /** The GLOBA l_ macro s_ cache. */
    GLOBAL_MACROS_CACHE(4), // 0x10 g
    /** The PE r_ characte r_ macro s_ cache. */
    PER_CHARACTER_MACROS_CACHE(5), // 0x20 p
    /** The PE r_ characte r_ layou t_ cache. */
    PER_CHARACTER_LAYOUT_CACHE(6), // 0x40 p
    /** The PE r_ characte r_ cha t_ cache. */
    PER_CHARACTER_CHAT_CACHE(7), // 0x80 p
    /** The NU m_ accoun t_ dat a_ types. */
    NUM_ACCOUNT_DATA_TYPES(8);
    
    /** The value. */
    private int value;
    
    /**
     * Instantiates a new account data type.
     * 
     * @param idval
     *            the idval
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
