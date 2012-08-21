package org.jmangos.realm.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.12. Time: 14:31
 */
@Table(name = "player_classlevelstats")
@Entity
public class PlayerClasslevelstats {
    
    @EmbeddedId
    PlayerClassLevelInfoPK playerClassLevelInfoPK;
    
    private short          basehp;
    
    @Column(name = "basehp", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getBasehp() {
    
        return this.basehp;
    }
    
    public void setBasehp(final short basehp) {
    
        this.basehp = basehp;
    }
    
    private short basemana;
    
    @Column(name = "basemana", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getBasemana() {
    
        return this.basemana;
    }
    
    public void setBasemana(final short basemana) {
    
        this.basemana = basemana;
    }
    
}
