/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
@Embeddable
public class PlayerClassLevelInfoPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3873915345910984822L;

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
