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
package org.JMANGOS.realm.model;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryTemplate.
 */
public class InventoryTemplate {
	
	/** The bag_guid. */
	private int bag_guid;
	
	/** The item_guid. */
	private int item_guid;
	
	/** The item_id. */
	private int item_id;
	
	/** The slot. */
	private byte slot;
	
	/** The data. */
	private String data;
	
	/**
	 * Instantiates a new inventory template.
	 *
	 * @param data the data
	 * @param bagGuid the bag guid
	 * @param slot the slot
	 * @param itemGuid the item guid
	 * @param itemId the item id
	 */
	public InventoryTemplate(String data, int bagGuid, byte slot, int itemGuid, int itemId) {
		this.data = data;
		bag_guid = bagGuid;
		this.slot = slot;
		item_guid = itemGuid;
		item_id = itemId;
	}
	
	/**
	 * Gets the bag_guid.
	 *
	 * @return the bag_guid
	 */
	public final int getBag_guid() {
		return bag_guid;
	}
	
	/**
	 * Gets the item_guid.
	 *
	 * @return the item_guid
	 */
	public final int getItem_guid() {
		return item_guid;
	}
	
	/**
	 * Gets the item_id.
	 *
	 * @return the item_id
	 */
	public final int getItem_id() {
		return item_id;
	}
	
	/**
	 * Gets the slot.
	 *
	 * @return the slot
	 */
	public final int getSlot() {
		return slot;
	}
	
	/**
	 * Sets the bag_guid.
	 *
	 * @param bagGuid the bag_guid to set
	 */
	public final void setBag_guid(int bagGuid) {
		bag_guid = bagGuid;
	}
	
	/**
	 * Sets the item_guid.
	 *
	 * @param itemGuid the item_guid to set
	 */
	public final void setItem_guid(int itemGuid) {
		item_guid = itemGuid;
	}
	
	/**
	 * Sets the item_id.
	 *
	 * @param itemId the item_id to set
	 */
	public final void setItem_id(int itemId) {
		item_id = itemId;
	}
	
	/**
	 * Sets the slot.
	 *
	 * @param slot the slot to set
	 */
	public final void setSlot(byte slot) {
		this.slot = slot;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
}
