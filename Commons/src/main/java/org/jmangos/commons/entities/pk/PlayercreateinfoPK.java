package org.jmangos.commons.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date:
 * 2012.08.11. Time:
 * 21:10
 */
@Embeddable
public class PlayercreateinfoPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3488739986001429781L;

    @Column(name = "race", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Races race;

    @Column(name = "class", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    public Classes clazz;

    public PlayercreateinfoPK() {

    }

    public PlayercreateinfoPK(final Races race, final Classes clazz) {

        this.race = race;
        this.clazz = clazz;
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

    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayercreateinfoPK)) {
            return false;
        }
        return (getClazz() == ((PlayercreateinfoPK) object).getClazz()) &&
            (getRace() == ((PlayercreateinfoPK) object).getRace());
    }

    @Override
    public int hashCode() {

        return (getClazz().getValue() << 8) | getRace().getValue();
    }
}
