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

import javax.persistence.*;

/**
 * The Class InventoryItem.
 */
@Entity
@Table(name="character_inventory")
public class InventoryItem {

    /** The bag_guid. */
    @Basic
    @Column(name="bag", length = 11, nullable = false)
    private int bag_guid;
	
	/** The item_guid. */
    @Basic
    @Column(name="item_template", length = 11, nullable = false)
    private int item_guid;
	
	/** The item_id. */
    @Id
    @TableGenerator(table = "sequences", allocationSize = 1, name = "char_inv_item")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "char_inv_item")
    @Column(name="item", length = 11, nullable = false)
    private int item_id;
	
	/** The slot. */
    @Basic
    @Column(name="slot", length = 3, nullable = false)
    private int slot;

    @Basic
    @Column(name="data", length = 512, nullable = false)
    private String data = "";

    public InventoryItem() {
    }

    public InventoryItem(int item_guid, int slot) {
        this.item_guid = item_guid;
        this.slot = slot;
    }

    /**
	 * Instantiates a new inventory template.
	 *
	 * @param data the data
	 * @param bagGuid the bag guid
	 * @param slot the slot
	 * @param itemGuid the item guid
	 * @param itemId the item id
	 */
	public InventoryItem(String data, int bagGuid, byte slot, int itemGuid, int itemId) {
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
	public final void setSlot(int slot) {
		this.slot = slot;
	}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
