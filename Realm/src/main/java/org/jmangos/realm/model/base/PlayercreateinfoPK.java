package org.jmangos.realm.model.base;

import org.jmangos.realm.model.Races;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.11.
 * Time: 21:10
 */
@Embeddable
public class PlayercreateinfoPK implements Serializable {

    @Column(name = "race", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int race;

    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int clazz;

    public PlayercreateinfoPK() {
    }

    public PlayercreateinfoPK(int race, int clazz) {
        this.race = race;
        this.clazz = clazz;
    }

    public int getRace() {
        return race;
    }

    public void setRace(byte race) {
        this.race = race;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(byte clazz) {
        this.clazz = clazz;
    }
}
