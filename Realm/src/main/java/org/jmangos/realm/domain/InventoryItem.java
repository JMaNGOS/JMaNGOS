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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jmangos.realm.entities.CharacterEntity;
import org.jmangos.realm.entities.ItemEntity;

/**
 * The Class InventoryItem.
 */
@Entity
@Table(name = "character_inventory")
public class InventoryItem {
    
    /** The slot. */
    @Basic
    @Column(name = "slot", length = 3, nullable = false)
    private int        slot;
    
    /** The item_guid. */
    @Id
    @Column(name = "itemId", length = 11, nullable = false)
    private int        itemId;
    
    /** The item_id. */
    @OneToOne
    @PrimaryKeyJoinColumn(name = "item", referencedColumnName = "guid")
    private ItemEntity item;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_guid", nullable = false)
    CharacterEntity    ownerCharacter;
    
    public InventoryItem() {
    
    }
    
    /**
     * @return the slot
     */
    public final int getSlot() {
    
        return this.slot;
    }
    
    /**
     * @param slot
     *            the slot to set
     */
    public final void setSlot(final int slot) {
    
        this.slot = slot;
    }
    
    /**
     * @return the itemId
     */
    public final int getItemId() {
    
        return this.itemId;
    }
    
    /**
     * @param itemId
     *            the itemId to set
     */
    public final void setItemId(final int itemId) {
    
        this.itemId = itemId;
    }
    
    /**
     * @return the item
     */
    public final ItemEntity getItem() {
    
        return this.item;
    }
    
    /**
     * @param item
     *            the item to set
     */
    public final void setItem(final ItemEntity item) {
    
        setItemId(item.getGuid());
        this.item = item;
    }
    
    /**
     * @return the ownerCharacter
     */
    public final CharacterEntity getOwnerCharacter() {
    
        return this.ownerCharacter;
    }
    
    /**
     * @param ownerCharacter
     *            the ownerCharacter to set
     */
    public final void setOwnerCharacter(final CharacterEntity ownerCharacter) {
    
        this.ownerCharacter = ownerCharacter;
    }
    
}
