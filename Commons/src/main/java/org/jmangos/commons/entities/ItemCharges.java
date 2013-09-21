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
/**
 * 
 */
package org.jmangos.commons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "item_Charges")
public class ItemCharges implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 626907239477915146L;

    @Id
    @Column(name = "itemGuid",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private long itemGuid;

    @Id
    @Column(name = "slot",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte slot;

    @Column(name = "charges",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int charges;

    public ItemCharges() {

    }

    /**
     * @return the itemGuid
     */
    public final long getItemGuid() {

        return this.itemGuid;
    }

    /**
     * @param itemGuid
     *        the itemGuid to set
     */
    public final void setItemGuid(final long itemGuid) {

        this.itemGuid = itemGuid;
    }

    /**
     * @return the slot
     */
    public final byte getSlot() {

        return this.slot;
    }

    /**
     * @param slot
     *        the slot to set
     */
    public final void setSlot(final byte slot) {

        this.slot = slot;
    }

    /**
     * @return the charges
     */
    public final int getCharges() {

        return this.charges;
    }

    /**
     * @param charges
     *        the charges to set
     */
    public final void setCharges(final int charges) {

        this.charges = charges;
    }

    @Override
    public int hashCode() {

        return (int) ((this.itemGuid & (0xFFFFFF << 6)) | this.slot);
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCharges)) {
            return false;
        }
        return (((ItemCharges) obj).getItemGuid() == getItemGuid()) &&
            (((ItemCharges) obj).getSlot() == getSlot());
    }

}
