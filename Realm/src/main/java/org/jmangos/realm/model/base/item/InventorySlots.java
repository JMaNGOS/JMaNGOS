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
package org.jmangos.realm.model.base.item;

// TODO: Auto-generated Javadoc

/**
 * The Class InventorySlots.
 */
public enum InventorySlots {
    INVENTORY_SLOT_BAG_START(19),
    INVENTORY_SLOT_BAG_1(19),
    INVENTORY_SLOT_BAG_2(20),
    INVENTORY_SLOT_BAG_3(21),
    INVENTORY_SLOT_BAG_4(22),
    INVENTORY_SLOT_BAG_END(23),
    INVENTORY_SLOT_ITEM_START(23),
    INVENTORY_SLOT_ITEM_1(23),
    INVENTORY_SLOT_ITEM_2(24),
    INVENTORY_SLOT_ITEM_3(25),
    INVENTORY_SLOT_ITEM_4(26),
    INVENTORY_SLOT_ITEM_5(27),
    INVENTORY_SLOT_ITEM_6(28),
    INVENTORY_SLOT_ITEM_7(29),
    INVENTORY_SLOT_ITEM_8(30),
    INVENTORY_SLOT_ITEM_9(31),
    INVENTORY_SLOT_ITEM_10(32),
    INVENTORY_SLOT_ITEM_11(33),
    INVENTORY_SLOT_ITEM_12(34),
    INVENTORY_SLOT_ITEM_13(35),
    INVENTORY_SLOT_ITEM_14(36),
    INVENTORY_SLOT_ITEM_15(37),
    INVENTORY_SLOT_ITEM_16(38),
    INVENTORY_SLOT_ITEM_END(39);

    private int value;

    InventorySlots(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static InventorySlots get( int value ) {
        for ( InventorySlots slot : values() )
            if ( slot.getValue() == value )
                return slot;
        return null;
    }
}
