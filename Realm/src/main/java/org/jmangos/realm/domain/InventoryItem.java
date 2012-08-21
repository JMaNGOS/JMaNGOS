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
package org.jmangos.realm.domain;

// TODO: Auto-generated Javadoc

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * The Class InventoryItem.
 */
@Entity
@Table(name = "character_inventory")
public class InventoryItem {
    
    /** The bag_guid. */
    @Basic
    @Column(name = "bag", length = 11, nullable = false)
    private int    bag_guid;
    
    /** The item_guid. */
    @Basic
    @Column(name = "item_template", length = 11, nullable = false)
    private int    item_guid;
    
    /** The item_id. */
    @Id
    @TableGenerator(table = "sequences", allocationSize = 1, name = "char_inv_item")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "char_inv_item")
    @Column(name = "item", length = 11, nullable = false)
    private int    item_id;
    
    /** The slot. */
    @Basic
    @Column(name = "slot", length = 3, nullable = false)
    private int    slot;
    
    @Basic
    @Column(name = "data", length = 512, nullable = false)
    private String data = "";
    
    public InventoryItem() {
    
    }
    
    public InventoryItem(final int item_guid, final int slot) {
    
        this.item_guid = item_guid;
        this.slot = slot;
    }
    
    /**
     * Instantiates a new inventory template.
     * 
     * @param data
     *            the data
     * @param bagGuid
     *            the bag guid
     * @param slot
     *            the slot
     * @param itemGuid
     *            the item guid
     * @param itemId
     *            the item id
     */
    public InventoryItem(final String data, final int bagGuid, final byte slot, final int itemGuid, final int itemId) {
    
        this.bag_guid = bagGuid;
        this.slot = slot;
        this.item_guid = itemGuid;
        this.item_id = itemId;
    }
    
    /**
     * Gets the bag_guid.
     * 
     * @return the bag_guid
     */
    public final int getBag_guid() {
    
        return this.bag_guid;
    }
    
    /**
     * Gets the item_guid.
     * 
     * @return the item_guid
     */
    public final int getItem_guid() {
    
        return this.item_guid;
    }
    
    /**
     * Gets the item_id.
     * 
     * @return the item_id
     */
    public final int getItem_id() {
    
        return this.item_id;
    }
    
    /**
     * Gets the slot.
     * 
     * @return the slot
     */
    public final int getSlot() {
    
        return this.slot;
    }
    
    /**
     * Sets the bag_guid.
     * 
     * @param bagGuid
     *            the bag_guid to set
     */
    public final void setBag_guid(final int bagGuid) {
    
        this.bag_guid = bagGuid;
    }
    
    /**
     * Sets the item_guid.
     * 
     * @param itemGuid
     *            the item_guid to set
     */
    public final void setItem_guid(final int itemGuid) {
    
        this.item_guid = itemGuid;
    }
    
    /**
     * Sets the item_id.
     * 
     * @param itemId
     *            the item_id to set
     */
    public final void setItem_id(final int itemId) {
    
        this.item_id = itemId;
    }
    
    /**
     * Sets the slot.
     * 
     * @param slot
     *            the slot to set
     */
    public final void setSlot(final int slot) {
    
        this.slot = slot;
    }
    
    public String getData() {
    
        return this.data;
    }
    
    public void setData(final String data) {
    
        this.data = data;
    }
}
