package org.jmangos.realm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.jmangos.realm.model.enums.Classes;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.12. To change this template use File |
 * Settings | File Templates.
 */
@Embeddable
public class PlayerClassLevelInfoPK implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1978496511121197159L;
    
    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               clazz;
    
    @Column(name = "level", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int               level;
    
    public PlayerClassLevelInfoPK() {
    
    }
    
    public PlayerClassLevelInfoPK(final Classes clazz, final int level) {
    
        this.clazz = clazz.getValue();
        this.level = level;
    }
    
    public PlayerClassLevelInfoPK(final int clazz, final int level) {
    
        this.clazz = clazz;
        this.level = level;
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
        if (!(object instanceof PlayerClassLevelInfoPK)) {
            return false;
        }
        return (getClazz() == ((PlayerClassLevelInfoPK) object).getClazz()) && (getLevel() == ((PlayerClassLevelInfoPK) object).getLevel());
    }
    
    @Override
    public int hashCode() {
    
        return (getClazz() << 8) | getLevel();
    }
}
