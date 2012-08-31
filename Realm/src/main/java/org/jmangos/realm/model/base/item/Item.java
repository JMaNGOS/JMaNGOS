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

import org.jmangos.realm.model.base.WorldObject;
import org.jmangos.realm.model.base.update.ItemFields;
import org.jmangos.realm.model.enums.EquipmentSlots;
import org.jmangos.realm.model.enums.InventorySlots;
import org.jmangos.realm.model.enums.TypeID;
import org.jmangos.realm.model.enums.TypeMask;

/**
 * The Class Item.
 */
public class Item extends WorldObject {
    
    /** The Constant INVENTORY_SLOT_BAG_0. */
    public static final int  INVENTORY_SLOT_BAG_0      = 255;
    
    /** The Constant NULL_SLOT. */
    private static final int NULL_SLOT                 = 255;
    
    /** The Constant INVENTORY_SLOT_ITEM_START. */
    public static final int  INVENTORY_SLOT_ITEM_START = 23;
    
    /** The Constant INVENTORY_SLOT_ITEM_END. */
    public static final int  INVENTORY_SLOT_ITEM_END   = 39;
    
    /** The Constant KEYRING_SLOT_START. */
    public static final int  KEYRING_SLOT_START        = 86;
    
    /** The Constant KEYRING_SLOT_END. */
    public static final int  KEYRING_SLOT_END          = 118;
    
    /** The Constant CURRENCYTOKEN_SLOT_START. */
    public static final int  CURRENCYTOKEN_SLOT_START  = 118;
    
    /** The Constant CURRENCYTOKEN_SLOT_END. */
    public static final int  CURRENCYTOKEN_SLOT_END    = 150;
    
    /** The slot. */
    private int              slot                      = 0;
    
    /**
     * Instantiates a new item.
     * 
     * @param objectId
     *            the object id
     */
    public Item(final long objectId) {
    
        super(objectId);
        this.valuesCount = ItemFields.ITEM_END;
        this.objectType.add(TypeMask.ITEM);
        this.objectTypeId = TypeID.ITEM;
    }
    
    /**
     * Sets the slot.
     * 
     * @param slot
     *            the new slot
     */
    public void setSlot(final int slot) {
    
        this.slot = slot;
    }
    
    /**
     * Gets the slot.
     * 
     * @return the slot
     */
    public int getSlot() {
    
        return this.slot;
    }
    
    /**
     * Checks if is inventory pos.
     * 
     * @param bag
     *            the bag
     * @param slot
     *            the slot
     * @return true, if successful
     */
    public static boolean isInventoryPos(final int bag, final int slot) {
    
        if ((bag == INVENTORY_SLOT_BAG_0) && (slot == NULL_SLOT)) {
            return true;
        }
        if ((bag == INVENTORY_SLOT_BAG_0) && ((slot >= INVENTORY_SLOT_ITEM_START) && (slot < INVENTORY_SLOT_ITEM_END))) {
            return true;
        }
        if ((bag >= InventorySlots.BAG_START.getValue()) && (bag < InventorySlots.BAG_END.getValue())) {
            return true;
        }
        if ((bag == INVENTORY_SLOT_BAG_0) && ((slot >= KEYRING_SLOT_START) && (slot < CURRENCYTOKEN_SLOT_END))) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if is equipment pos.
     * 
     * @param bag
     *            the bag
     * @param slot
     *            the slot
     * @return true, if successful
     */
    public static boolean isEquipmentPos(final int bag, final int slot) {
    
        if ((bag == INVENTORY_SLOT_BAG_0) && (slot < EquipmentSlots.END.getValue())) {
            return true;
        }
        if ((bag == INVENTORY_SLOT_BAG_0) && ((slot >= InventorySlots.BAG_START.getValue()) && (slot < InventorySlots.BAG_END.getValue()))) {
            return true;
        }
        return false;
    }
    
}
