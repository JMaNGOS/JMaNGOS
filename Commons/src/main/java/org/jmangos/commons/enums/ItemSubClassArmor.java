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
 * 
 * @author MinimaJack
 * 
 */
public enum ItemSubClassArmor {
    MISC,
    CLOTH,
    LEATHER,
    MAIL,
    PLATE,
    BUCKLER,
    SHIELD,
    LIBRAM,
    IDOL,
    TOTEM,
    SIGIL;

    public static final int COUNT_ITEM_SUB_CLASS = 11;

    public static final ItemSubClassArmor get(final int index) {

        if (index < COUNT_ITEM_SUB_CLASS) {
            return values()[index];
        }
        return null;
    }

    public static final ItemSubClassArmor getFirstByMask(final int mask) {
        for (ItemSubClassArmor armor : values()) {
            if ((1 << armor.ordinal() & mask) > 0) {
                return armor;
            }
        }
        return null;
    }
}
