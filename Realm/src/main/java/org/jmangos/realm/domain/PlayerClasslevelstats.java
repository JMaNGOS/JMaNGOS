package org.jmangos.realm.domain;

import org.jmangos.realm.model.base.PlayerClassLevelInfoPK;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * Date: 2012.08.12.
 * Time: 14:31
 */
@Table(name = "player_classlevelstats")
@Entity
public class PlayerClasslevelstats {
    @EmbeddedId
    PlayerClassLevelInfoPK playerClassLevelInfoPK;

    private short basehp;

    @Column(name = "basehp", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getBasehp() {
        return basehp;
    }

    public void setBasehp(short basehp) {
        this.basehp = basehp;
    }

    private short basemana;

    @Column(name = "basemana", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getBasemana() {
        return basemana;
    }

    public void setBasemana(short basemana) {
        this.basemana = basemana;
    }

}
