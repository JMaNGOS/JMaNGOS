package org.jmangos.realm.model.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * Date: 2012.08.12.
 * Time: 15:11
 */
@Embeddable
public class PlayerLevelInfoPK implements Serializable {
    @Column(name = "race", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int race;

    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int clazz;

    @Column(name = "level", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int level;

    public PlayerLevelInfoPK() {
    }

    public PlayerLevelInfoPK(int race, int clazz, int level) {
        this.race = race;
        this.clazz = clazz;
        this.level = level;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
