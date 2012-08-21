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
package org.jmangos.realm.model.base.character;

import org.jmangos.realm.model.enums.InventoryType;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemData.
 */
public class ItemData {
    
    /** The Display info id. */
    private int           DisplayInfoID = 0;
    
    /** The Inventory type. */
    private InventoryType InventoryType;
    
    /** The enchant aura id. */
    private int           enchantAuraId = 0;
    
    /**
     * Gets the display info id.
     * 
     * @return the display info id
     */
    public final int getDisplayInfoID() {
    
        return this.DisplayInfoID;
    }
    
    /**
     * Sets the display info id.
     * 
     * @param displayInfoID
     *            the new display info id
     */
    public final void setDisplayInfoID(final int displayInfoID) {
    
        this.DisplayInfoID = displayInfoID;
    }
    
    /**
     * Gets the inventory type.
     * 
     * @return the inventory type
     */
    public final InventoryType getInventoryType() {
    
        return this.InventoryType;
    }
    
    /**
     * Sets the inventory type.
     * 
     * @param inventoryType
     *            the new inventory type
     */
    public final void setInventoryType(final InventoryType inventoryType) {
    
        this.InventoryType = inventoryType;
    }
    
    /**
     * Gets the enchant aura id.
     * 
     * @return the enchant aura id
     */
    public final int getEnchantAuraId() {
    
        return this.enchantAuraId;
    }
    
    /**
     * Sets the enchant aura id.
     * 
     * @param enchantAuraId
     *            the new enchant aura id
     */
    public final void setEnchantAuraId(final int enchantAuraId) {
    
        this.enchantAuraId = enchantAuraId;
    }
}
