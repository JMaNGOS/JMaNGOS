package org.jmangos.world.entities;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jmangos.realm.domain.PlayercreateinfoPK;


/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.11. Time:
 * 21:10
 */
@Entity
@Table(name = "playercreateinfo")
public class Playercreateinfo {
    
    @EmbeddedId
    PlayercreateinfoPK playercreateinfoPK;
    
    @Basic
    @Column(name = "map", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    private short      map;
    
    @Basic
    @Column(name = "zone", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    private int        zone;
    
    @Basic
    @Column(name = "position_x", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    private float      positionX;
    
    @Basic
    @Column(name = "position_y", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    private float      positionY;
    
    @Basic
    @Column(name = "position_z", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    private float      positionZ;
    
    @Basic
    @Column(name = "orientation", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    private float      orientation;
    
    @OneToMany(mappedBy = "playercreateinfoPK", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlayerCreateAction> actions;
    
    @OneToMany(mappedBy = "playercreateinfoPK", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlayerCreateSpell>  spell;
    
    public Playercreateinfo() {
    
    }
    
    public PlayercreateinfoPK getPlayercreateinfoPK() {
    
        return this.playercreateinfoPK;
    }
    
    public void setPlayercreateinfoPK(final PlayercreateinfoPK playercreateinfoPK) {
    
        this.playercreateinfoPK = playercreateinfoPK;
    }
    
    public short getMap() {
    
        return this.map;
    }
    
    public void setMap(final short map) {
    
        this.map = map;
    }
    
    public int getZone() {
    
        return this.zone;
    }
    
    public void setZone(final int zone) {
    
        this.zone = zone;
    }
    
    public float getPositionX() {
    
        return this.positionX;
    }
    
    public void setPositionX(final float positionX) {
    
        this.positionX = positionX;
    }
    
    public float getPositionY() {
    
        return this.positionY;
    }
    
    public void setPositionY(final float positionY) {
    
        this.positionY = positionY;
    }
    
    public float getPositionZ() {
    
        return this.positionZ;
    }
    
    public void setPositionZ(final float positionZ) {
    
        this.positionZ = positionZ;
    }
    
    public float getOrientation() {
    
        return this.orientation;
    }
    
    public void setOrientation(final float orientation) {
    
        this.orientation = orientation;
    }
    
    
    /**
     * @return the actions
     */
    public final Set<PlayerCreateAction> getActions() {
    
        return actions;
    }

    
    /**
     * @param actions the actions to set
     */
    public final void setActions(final Set<PlayerCreateAction> actions) {
    
        this.actions = actions;
    }

    
    /**
     * @return the spell
     */
    public final Set<PlayerCreateSpell> getSpell() {
    
        return spell;
    }

    
    /**
     * @param spell the spell to set
     */
    public final void setSpell(final Set<PlayerCreateSpell> spell) {
    
        this.spell = spell;
    }

    @Override
    public boolean equals(Object object) {
    
        if (this == object) {
            return true;
        }
        if (!(object instanceof Playercreateinfo)) {
            return false;
        }
        if (playercreateinfoPK.equals(((Playercreateinfo) object).getPlayercreateinfoPK())) {
            return true;
        }
        return false;
    }
}
