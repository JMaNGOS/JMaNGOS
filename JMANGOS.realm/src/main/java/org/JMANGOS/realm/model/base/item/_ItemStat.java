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

// TODO: Auto-generated Javadoc
/**
 * The Class _ItemStat.
 */
public final class _ItemStat {
	
	/** The Item stat type. */
	private byte ItemStatType;
	
	/** The Item stat value. */
	private int ItemStatValue;

	/**
	 * Instantiates a new _ item stat.
	 *
	 * @param itemStatType the item stat type
	 * @param itemStatValue the item stat value
	 */
	public _ItemStat(byte itemStatType, int itemStatValue) {
		ItemStatType = itemStatType;
		ItemStatValue = itemStatValue;
	}

	/**
	 * Gets the item stat type.
	 *
	 * @return the itemStatType
	 */
	public byte getItemStatType() {
		return ItemStatType;
	}

	/**
	 * Sets the item stat type.
	 *
	 * @param itemStatType the itemStatType to set
	 */
	public void setItemStatType(byte itemStatType) {
		ItemStatType = itemStatType;
	}

	/**
	 * Gets the item stat value.
	 *
	 * @return the itemStatValue
	 */
	public int getItemStatValue() {
		return ItemStatValue;
	}

	/**
	 * Sets the item stat value.
	 *
	 * @param itemStatValue the itemStatValue to set
	 */
	public void setItemStatValue(int itemStatValue) {
		ItemStatValue = itemStatValue;
	}
}
