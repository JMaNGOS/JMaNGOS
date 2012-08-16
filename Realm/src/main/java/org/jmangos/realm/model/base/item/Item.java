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
import org.jmangos.realm.model.base.guid.TypeId;
import org.jmangos.realm.model.base.guid.TypeMask;
import org.jmangos.realm.model.base.update.ItemFields;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public class Item extends WorldObject {
    
    /** The Constant INVENTORY_SLOT_BAG_0. */
    public static final int  INVENTORY_SLOT_BAG_0 = 255;
    
    /** The Constant NULL_SLOT. */
    private static final int NULL_SLOT            = 255;
    
    /** The slot. */
    private int              slot                 = 0;
    
    /**
     * Instantiates a new item.
     * 
     * @param objectId
     *            the object id
     */
    public Item(final long objectId) {
    
        super(objectId);
        this.valuesCount = ItemFields.ITEM_END;
        this.objectType.add(TypeMask.TYPEMASK_ITEM);
        this.objectTypeId = TypeId.TYPEID_ITEM;
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
    public static boolean IsInventoryPos(final int bag, final int slot) {
    
        if ((bag == INVENTORY_SLOT_BAG_0) && (slot == NULL_SLOT)) {
            return true;
        }
        if ((bag == INVENTORY_SLOT_BAG_0) && ((slot >= InventoryPackSlots.INVENTORY_SLOT_ITEM_START) && (slot < InventoryPackSlots.INVENTORY_SLOT_ITEM_END))) {
            return true;
        }
        if ((bag >= InventorySlots.INVENTORY_SLOT_BAG_START.getValue()) && (bag < InventorySlots.INVENTORY_SLOT_BAG_END.getValue())) {
            return true;
        }
        if ((bag == INVENTORY_SLOT_BAG_0) && ((slot >= KeyRingSlots.KEYRING_SLOT_START) && (slot < CurrencyTokenSlots.CURRENCYTOKEN_SLOT_END))) {
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
    public static boolean IsEquipmentPos(final int bag, final int slot) {
    
        if ((bag == INVENTORY_SLOT_BAG_0) && (slot < EquipmentSlots.EQUIPMENT_SLOT_END.getValue())) {
            return true;
        }
        if ((bag == INVENTORY_SLOT_BAG_0)
                && ((slot >= InventorySlots.INVENTORY_SLOT_BAG_START.getValue()) && (slot < InventorySlots.INVENTORY_SLOT_BAG_END.getValue()))) {
            return true;
        }
        return false;
    }
    
}
