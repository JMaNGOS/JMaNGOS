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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.PlayerClassLevelInfoPK;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.12. Time: 14:31
 */
@Table(name = "player_classlevelstats")
@Entity
public class PlayerClasslevelstats {

    @EmbeddedId
    PlayerClassLevelInfoPK playerClassLevelInfoPK;

    private short basehp;

    @Column(name = "basehp",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getBasehp() {

        return this.basehp;
    }

    public void setBasehp(final short basehp) {

        this.basehp = basehp;
    }

    private short basemana;

    @Column(name = "basemana",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getBasemana() {

        return this.basemana;
    }

    public void setBasemana(final short basemana) {

        this.basemana = basemana;
    }

}
