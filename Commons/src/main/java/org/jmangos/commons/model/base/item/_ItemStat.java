/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.model.base.item;

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
     * @param itemStatType
     *        the item stat type
     * @param itemStatValue
     *        the item stat value
     */
    public _ItemStat(final byte itemStatType, final int itemStatValue) {

        this.ItemStatType = itemStatType;
        this.ItemStatValue = itemStatValue;
    }

    /**
     * Gets the item stat type.
     * 
     * @return the itemStatType
     */
    public byte getItemStatType() {

        return this.ItemStatType;
    }

    /**
     * Sets the item stat type.
     * 
     * @param itemStatType
     *        the itemStatType to set
     */
    public void setItemStatType(final byte itemStatType) {

        this.ItemStatType = itemStatType;
    }

    /**
     * Gets the item stat value.
     * 
     * @return the itemStatValue
     */
    public int getItemStatValue() {

        return this.ItemStatValue;
    }

    /**
     * Sets the item stat value.
     * 
     * @param itemStatValue
     *        the itemStatValue to set
     */
    public void setItemStatValue(final int itemStatValue) {

        this.ItemStatValue = itemStatValue;
    }
}
