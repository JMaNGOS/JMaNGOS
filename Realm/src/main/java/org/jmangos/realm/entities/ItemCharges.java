/**
 * 
 */
package org.jmangos.realm.entities;

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
