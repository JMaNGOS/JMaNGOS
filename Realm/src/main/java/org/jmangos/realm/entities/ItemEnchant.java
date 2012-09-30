/**
 * 
 */
package org.jmangos.realm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.realm.model.enums.EnchantmentSlot;

/**
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "item_Enchants")
public class ItemEnchant implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3451226988553411250L;

    @Id
    @Column(name = "itemGuid", nullable = false, insertable = true, updatable = true)
    private long itemGuid;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "slot", nullable = false, insertable = true, updatable = true)
    private EnchantmentSlot slot;

    @Column(name = "enchantId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int enchantId;

    @Column(name = "duration",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int duration;

    @Column(name = "charges",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int charges;

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
     * @return the enchantId
     */
    public final int getEnchantId() {

        return this.enchantId;
    }

    /**
     * @param enchantId
     *        the enchantId to set
     */
    public final void setEnchantId(final int enchantId) {

        this.enchantId = enchantId;
    }

    /**
     * @return the duration
     */
    public final int getDuration() {

        return this.duration;
    }

    /**
     * @param duration
     *        the duration to set
     */
    public final void setDuration(final int duration) {

        this.duration = duration;
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

        return (int) (this.itemGuid);
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemEnchant)) {
            return false;
        }
        return ((ItemEnchant) obj).getItemGuid() == getItemGuid();
    }
}
