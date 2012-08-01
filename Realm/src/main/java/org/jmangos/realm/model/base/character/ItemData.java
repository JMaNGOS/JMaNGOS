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
package org.jmangos.realm.model.base.character;

import org.jmangos.realm.model.base.item.InventoryType;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemData.
 */
public class ItemData {
	
	/** The Display info id. */
	private int DisplayInfoID = 0;
	
	/** The Inventory type. */
	private InventoryType InventoryType;
	
	/** The enchant aura id. */
	private int enchantAuraId = 0;
	
	/**
	 * Gets the display info id.
	 *
	 * @return the display info id
	 */
	public final int getDisplayInfoID() {
		return DisplayInfoID;
	}
	
	/**
	 * Sets the display info id.
	 *
	 * @param displayInfoID the new display info id
	 */
	public final void setDisplayInfoID(int displayInfoID) {
		DisplayInfoID = displayInfoID;
	}
	
	/**
	 * Gets the inventory type.
	 *
	 * @return the inventory type
	 */
	public final InventoryType getInventoryType() {
		return InventoryType;
	}
	
	/**
	 * Sets the inventory type.
	 *
	 * @param inventoryType the new inventory type
	 */
	public final void setInventoryType(InventoryType inventoryType) {
		InventoryType = inventoryType;
	}
	
	/**
	 * Gets the enchant aura id.
	 *
	 * @return the enchant aura id
	 */
	public final int getEnchantAuraId() {
		return enchantAuraId;
	}
	
	/**
	 * Sets the enchant aura id.
	 *
	 * @param enchantAuraId the new enchant aura id
	 */
	public final void setEnchantAuraId(int enchantAuraId) {
		this.enchantAuraId = enchantAuraId;
	}
}
