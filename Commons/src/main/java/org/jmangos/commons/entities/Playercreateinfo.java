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
package org.jmangos.commons.entities;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.PlayercreateinfoPK;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date:
 * 2012.08.11. Time:
 * 21:10
 */
@Entity
@Table(name = "playercreateinfo")
public class Playercreateinfo {

    @EmbeddedId
    PlayercreateinfoPK playercreateinfoPK;

    @Basic
    @Column(name = "map",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private short map;

    @Basic
    @Column(name = "zone",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int zone;

    @Embedded
    Position position;

    @OneToMany(mappedBy = "playercreateinfoPK", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlayerCreateAction> actions;

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

    /**
     * @return the actions
     */
    public final Set<PlayerCreateAction> getActions() {

        return this.actions;
    }

    /**
     * @param actions
     *        the actions to set
     */
    public final void setActions(final Set<PlayerCreateAction> actions) {

        this.actions = actions;
    }

    /**
     * @return the position
     */
    public final Position getPosition() {
        return this.position;
    }

    /**
     * @param position
     *        the position to set
     */
    public final void setPosition(final Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {

        return getPlayercreateinfoPK().hashCode();
    }

    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }
        if (!(object instanceof Playercreateinfo)) {
            return false;
        }
        if (this.playercreateinfoPK.equals(((Playercreateinfo) object).getPlayercreateinfoPK())) {
            return true;
        }
        return false;
    }
}
