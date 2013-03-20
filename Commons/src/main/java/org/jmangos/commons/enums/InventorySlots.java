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
 * The Class InventorySlots.
 */
public enum InventorySlots {
    BAG_START(19),
    BAG_1(19),
    BAG_2(20),
    BAG_3(21),
    BAG_4(22),
    BAG_END(23),
    ITEM_START(23),
    ITEM_1(23),
    ITEM_2(24),
    ITEM_3(25),
    ITEM_4(26),
    ITEM_5(27),
    ITEM_6(28),
    ITEM_7(29),
    ITEM_8(30),
    ITEM_9(31),
    ITEM_10(32),
    ITEM_11(33),
    ITEM_12(34),
    ITEM_13(35),
    ITEM_14(36),
    ITEM_15(37),
    ITEM_16(38),
    ITEM_END(39);

    private int value;

    InventorySlots(final int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }

    public static InventorySlots get(final int value) {

        for (final InventorySlots slot : values()) {
            if (slot.getValue() == value) {
                return slot;
            }
        }
        return null;
    }
}
