package org.jmangos.realm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.12. Time: 15:11
 */
@Embeddable
public class PlayerLevelInfoPK implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9119089535116461815L;
    
    @Column(name = "race", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               race;
    
    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               clazz;
    
    @Column(name = "level", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               level;
    
    public PlayerLevelInfoPK() {
    
    }
    
    public PlayerLevelInfoPK(final int race, final int clazz, final int level) {
    
        this.race = race;
        this.clazz = clazz;
        this.level = level;
    }
    
    public int getRace() {
    
        return this.race;
    }
    
    public void setRace(final int race) {
    
        this.race = race;
    }
    
    public int getClazz() {
    
        return this.clazz;
    }
    
    public void setClazz(final int clazz) {
    
        this.clazz = clazz;
    }
    
    public int getLevel() {
    
        return this.level;
    }
    
    public void setLevel(final int level) {
    
        this.level = level;
    }
    
    @Override
    public boolean equals(final Object object) {
    
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayerLevelInfoPK)) {
            return false;
        }
        return (getClazz() == (((PlayerLevelInfoPK) object).getClazz())) && (getLevel() == ((PlayerLevelInfoPK) object).getLevel())
                && (getRace() == ((PlayerLevelInfoPK) object).getRace());
    }
    
    @Override
    public int hashCode() {
    
        return (getRace() << 16) | (getClazz() << 8) | getLevel();
    }
}
