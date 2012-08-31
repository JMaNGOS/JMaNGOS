package org.jmangos.commons.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;

@Entity
@Table(name = "charstartoutfit")
public class CharStartOutfitEntity {
    
    @EmbeddedId
    CharStartOutfitEntityPk charStartOutfitEntityPk;
    
    @Basic
    @Column(name = "itemId", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer          itemId;
    @Basic
    @Column(name = "itemDisplayId", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer          itemDisplayId;
    
    public CharStartOutfitEntity() {
    
    }
    
    /**
     * @return the charStartOutfitEntityPk
     */
    public final CharStartOutfitEntityPk getCharStartOutfitEntityPk() {
    
        return this.charStartOutfitEntityPk;
    }
    
    /**
     * @param charStartOutfitEntityPk
     *            the charStartOutfitEntityPk to set
     */
    public final void setCharStartOutfitEntityPk(final CharStartOutfitEntityPk charStartOutfitEntityPk) {
    
        this.charStartOutfitEntityPk = charStartOutfitEntityPk;
    }
    
    /**
     * @return the itemId
     */
    public final Integer getItemId() {
    
        return this.itemId;
    }
    
    /**
     * @param itemId
     *            the itemId to set
     */
    public final void setItemId(final Integer itemId) {
    
        this.itemId = itemId;
    }
    
    /**
     * @return the itemDisplayId
     */
    public final Integer getItemDisplayId() {
    
        return this.itemDisplayId;
    }
    
    /**
     * @param itemDisplayId
     *            the itemDisplayId to set
     */
    public final void setItemDisplayId(final Integer itemDisplayId) {
    
        this.itemDisplayId = itemDisplayId;
    }
    
}
