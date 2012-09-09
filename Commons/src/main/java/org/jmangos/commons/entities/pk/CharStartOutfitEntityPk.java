package org.jmangos.commons.entities.pk;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharStartOutfitEntityPk implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2984603552216944986L;
    @Basic
    @Column(name = "clazz", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    public Byte               clazz;
    @Basic
    @Column(name = "gender", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    public Byte               gender;
    @Basic
    @Column(name = "race", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    public Byte               race;
    
    /**
     * @return the clazz
     */
    public final Byte getClazz() {
    
        return this.clazz;
    }
    
    /**
     * @param clazz
     *            the clazz to set
     */
    public final void setClazz(final Byte clazz) {
    
        this.clazz = clazz;
    }
    
    /**
     * @return the gender
     */
    public final Byte getGender() {
    
        return this.gender;
    }
    
    /**
     * @param gender
     *            the gender to set
     */
    public final void setGender(final Byte gender) {
    
        this.gender = gender;
    }
    
    /**
     * @return the race
     */
    public final Byte getRace() {
    
        return this.race;
    }
    
    /**
     * @param race
     *            the race to set
     */
    public final void setRace(final Byte race) {
    
        this.race = race;
    }
    
    @Override
    public boolean equals(final Object obj) {
    
        if (!(obj instanceof CharStartOutfitEntityPk)) {
            return false;
        }
        
        return ((CharStartOutfitEntityPk) obj).getGender().equals(getGender()) && ((CharStartOutfitEntityPk) obj).getClazz().equals(getClazz())
                && ((CharStartOutfitEntityPk) obj).getRace().equals(getRace());
    }
    
    @Override
    public int hashCode() {
    
        return (getRace() << 16) | (getClazz() << 8) | getGender();
    }
}
