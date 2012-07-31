/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base.item;

import org.JMANGOS.realm.model.base.WorldObject;
import org.JMANGOS.realm.model.base.guid.TypeId;
import org.JMANGOS.realm.model.base.guid.TypeMask;
import org.JMANGOS.realm.model.base.update.ItemFields;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public class Item extends WorldObject{
	
	/** The Constant INVENTORY_SLOT_BAG_0. */
	public static final int INVENTORY_SLOT_BAG_0 = 255;
	
	/** The Constant NULL_SLOT. */
	private static final int NULL_SLOT = 255;
	
	/** The slot. */
	private int slot = 0;
	
	/**
	 * Instantiates a new item.
	 *
	 * @param objectId the object id
	 */
	public Item(long objectId) {
		super(objectId);
		valuesCount = ItemFields.ITEM_END;
		objectType.add(TypeMask.TYPEMASK_ITEM);
		objectTypeId = TypeId.TYPEID_ITEM;
	}
	
	/**
	 * Sets the slot.
	 *
	 * @param slot the new slot
	 */
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	/**
	 * Gets the slot.
	 *
	 * @return the slot
	 */
	public int getSlot() {
		return slot;
	}
	
	/**
	 * Checks if is inventory pos.
	 *
	 * @param bag the bag
	 * @param slot the slot
	 * @return true, if successful
	 */
	public static boolean IsInventoryPos( int bag, int slot )
	{
	    if( bag == INVENTORY_SLOT_BAG_0 && slot == NULL_SLOT )
	        return true;
	    if( bag == INVENTORY_SLOT_BAG_0 && ( slot >= InventoryPackSlots.INVENTORY_SLOT_ITEM_START  && slot < InventoryPackSlots.INVENTORY_SLOT_ITEM_END ) )
	        return true;
	    if( bag >= InventorySlots.INVENTORY_SLOT_BAG_START && bag < InventorySlots.INVENTORY_SLOT_BAG_END )
	        return true;
	    if( bag == INVENTORY_SLOT_BAG_0 && ( slot >= KeyRingSlots.KEYRING_SLOT_START && slot < CurrencyTokenSlots.CURRENCYTOKEN_SLOT_END ) )
	        return true;
	    return false;
	}
	
	/**
	 * Checks if is equipment pos.
	 *
	 * @param bag the bag
	 * @param slot the slot
	 * @return true, if successful
	 */
	public static boolean IsEquipmentPos( int bag, int slot )
	{
	    if( bag == INVENTORY_SLOT_BAG_0 && ( slot < EquipmentSlots.EQUIPMENT_SLOT_END ) )
	        return true;
	    if( bag == INVENTORY_SLOT_BAG_0 && ( slot >= InventorySlots.INVENTORY_SLOT_BAG_START && slot < InventorySlots.INVENTORY_SLOT_BAG_END ) )
	        return true;
	    return false;
	}

}
