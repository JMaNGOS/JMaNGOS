package org.jmangos.commons.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.12. Time: 15:11
 */
@Embeddable
public class PlayerLevelInfoPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9119089535116461815L;

    @Column(name = "race", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Races race;

    @Column(name = "class", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Classes clazz;

    @Column(name = "level", nullable = false, insertable = true, updatable = true)
    private int level;

    public PlayerLevelInfoPK() {

    }

    public PlayerLevelInfoPK(final Races race, final Classes clazz, final int level) {

        this.race = race;
        this.clazz = clazz;
        this.level = level;
    }

    public Races getRace() {

        return this.race;
    }

    public void setRace(final Races race) {

        this.race = race;
    }

    public Classes getClazz() {

        return this.clazz;
    }

    public void setClazz(final Classes clazz) {

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
        return (getClazz() == (((PlayerLevelInfoPK) object).getClazz())) &&
            (getLevel() == ((PlayerLevelInfoPK) object).getLevel()) &&
            (getRace() == ((PlayerLevelInfoPK) object).getRace());
    }

    @Override
    public int hashCode() {

        return (getRace().getValue() << 16) | (getClazz().getValue() << 8) | getLevel();
    }
}
