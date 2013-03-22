package org.jmangos.commons.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jmangos.commons.enums.Classes;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.12. To change this
 * template use File |
 * Settings | File Templates.
 */
@SuppressWarnings("serial")
@Embeddable
public class PlayerClassLevelInfoPK implements Serializable {

    @Column(name = "class", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Classes clazz;

    @Column(name = "level", nullable = false, insertable = true, updatable = true)
    private int level;

    public PlayerClassLevelInfoPK() {

    }

    public PlayerClassLevelInfoPK(final Classes clazz, final int level) {

        this.clazz = clazz;
        this.level = level;
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
        if (!(object instanceof PlayerClassLevelInfoPK)) {
            return false;
        }
        return (getClazz() == ((PlayerClassLevelInfoPK) object).getClazz()) &&
            (getLevel() == ((PlayerClassLevelInfoPK) object).getLevel());
    }

    @Override
    public int hashCode() {

        return (getClazz().getValue() << 8) | getLevel();
    }
}
