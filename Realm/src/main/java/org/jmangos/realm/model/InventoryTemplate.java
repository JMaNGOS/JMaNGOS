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
package org.jmangos.realm.model;

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
