package org.jmangos.realm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.11. Time:
 * 21:10
 */
@Embeddable
public class PlayercreateinfoPK implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3488739986001429781L;
    
    @Column(name = "race", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               race;
    
    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               clazz;
    
    public PlayercreateinfoPK() {
    
    }
    
    public PlayercreateinfoPK(final int race, final int clazz) {
    
        this.race = race;
        this.clazz = clazz;
    }
    
    public int getRace() {
    
        return this.race;
    }
    
    public void setRace(final byte race) {
    
        this.race = race;
    }
    
    public int getClazz() {
    
        return this.clazz;
    }
    
    public void setClazz(final byte clazz) {
    
        this.clazz = clazz;
    }
    
    @Override
    public boolean equals(final Object object) {
    
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayercreateinfoPK)) {
            return false;
        }
        return (getClazz() == ((PlayercreateinfoPK) object).getClazz()) && (getRace() == ((PlayercreateinfoPK) object).getRace());
    }
    
    @Override
    public int hashCode() {
    
        return (getClazz() << 8) | getRace();
    }
}
