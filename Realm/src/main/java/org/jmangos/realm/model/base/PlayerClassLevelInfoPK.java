package org.jmangos.realm.model.base;

import org.jmangos.realm.model.Classes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * Date: 2012.08.12.
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class PlayerClassLevelInfoPK implements Serializable {

    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int clazz;

    @Column(name = "level", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int level;

    public PlayerClassLevelInfoPK() {}
    public PlayerClassLevelInfoPK( Classes clazz, int level ) {
        this.clazz = clazz.getValue();
        this.level = level;
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
