package org.jmangos.realm.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA. User: ITEXPERT Date: 2012.08.12. Time: 14:31 To change this template
 * use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "player_xp_for_level", schema = "", catalog = "mangos")
@Entity
public class PlayerXpForLevel {
    
    private int lvl;
    
    @javax.persistence.Column(name = "lvl", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getLvl() {
    
        return this.lvl;
    }
    
    public void setLvl(final int lvl) {
    
        this.lvl = lvl;
    }
    
    private int xpForNextLevel;
    
    @javax.persistence.Column(name = "xp_for_next_level", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getXpForNextLevel() {
    
        return this.xpForNextLevel;
    }
    
    public void setXpForNextLevel(final int xpForNextLevel) {
    
        this.xpForNextLevel = xpForNextLevel;
    }
    
    @Override
    public boolean equals(final Object o) {
    
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        
        final PlayerXpForLevel that = (PlayerXpForLevel) o;
        
        if (this.lvl != that.lvl) {
            return false;
        }
        if (this.xpForNextLevel != that.xpForNextLevel) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
    
        int result = this.lvl;
        result = (31 * result) + this.xpForNextLevel;
        return result;
    }
}
