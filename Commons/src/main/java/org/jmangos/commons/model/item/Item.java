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
package org.jmangos.commons.model.item;

import org.jmangos.commons.enums.EquipmentSlots;
import org.jmangos.commons.enums.InventoryType;

/**
 * The Class Item.
 */
public class Item {

    /** The Constant INVENTORY_SLOT_BAG_0. */
    public static final int INVENTORY_SLOT_BAG_0 = 255;

    /** The Constant INVENTORY_SLOT_ITEM_START. */
    public static final int INVENTORY_SLOT_ITEM_START = 23;

    /** The Constant INVENTORY_SLOT_ITEM_END. */
    public static final int INVENTORY_SLOT_ITEM_END = 39;

    /** The Constant KEYRING_SLOT_START. */
    public static final int KEYRING_SLOT_START = 86;

    /** The Constant KEYRING_SLOT_END. */
    public static final int KEYRING_SLOT_END = 118;

    /** The Constant CURRENCYTOKEN_SLOT_START. */
    public static final int CURRENCYTOKEN_SLOT_START = 118;

    /** The Constant CURRENCYTOKEN_SLOT_END. */
    public static final int CURRENCYTOKEN_SLOT_END = 150;

    public static EquipmentSlots findEquipSlot(final InventoryType inventoryType) {

        switch (inventoryType) {
            case HEAD:
                return EquipmentSlots.HEAD;
            case SHOULDERS:
                return EquipmentSlots.SHOULDERS;
            case BODY:
                return EquipmentSlots.BODY;
            case CHEST:
                return EquipmentSlots.CHEST;
            case ROBE:
                return EquipmentSlots.CHEST;
            case WAIST:
                return EquipmentSlots.WAIST;
            case LEGS:
                return EquipmentSlots.LEGS;
            case FEET:
                return EquipmentSlots.FEET;
            case WRISTS:
                return EquipmentSlots.WRISTS;
            case HANDS:
                return EquipmentSlots.HANDS;
            case CLOAK:
                return EquipmentSlots.BACK;
            case WEAPON:
                return EquipmentSlots.MAINHAND;
            case SHIELD:
                return EquipmentSlots.OFFHAND;
            case RANGED:
                return EquipmentSlots.RANGED;
            case TWOHWEAPON:
                return EquipmentSlots.MAINHAND;
            case TABARD:
                return EquipmentSlots.TABARD;
            case WEAPONMAINHAND:
                return EquipmentSlots.MAINHAND;
            case WEAPONOFFHAND:
                return EquipmentSlots.OFFHAND;
            case HOLDABLE:
                return EquipmentSlots.OFFHAND;
            case THROWN:
                return EquipmentSlots.RANGED;
            case RANGEDRIGHT:
                return EquipmentSlots.RANGED;
            default:
                return null;
        }
    }

}
