/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.commons.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.PlayerClassLevelInfoPK;

/**
 * The Class PlayerClassLevelInfo.
 */
@Entity
@Table(name = "player_classlevelstats")
public class PlayerClassLevelInfo {

    @EmbeddedId
    PlayerClassLevelInfoPK playerClassLevelInfoPK;

    /** The base health. */
    @Basic
    @Column(name = "basehp",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int baseHealth;

    /** The base mana. */
    @Basic
    @Column(name = "basemana",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int baseMana;

    /**
     * Gets the basehealth.
     * 
     * @return the basehealth
     */
    public int getBasehealth() {

        return this.baseHealth;
    }

    /**
     * Gets the basemana.
     * 
     * @return the basemana
     */
    public int getBasemana() {

        return this.baseMana;
    }

    /**
     * No-arg constructor for persistence content
     */
    public PlayerClassLevelInfo() {

    }

    public PlayerClassLevelInfoPK getPlayerClassLevelInfoPK() {

        return this.playerClassLevelInfoPK;
    }

    public void setPlayerClassLevelInfoPK(final PlayerClassLevelInfoPK playerClassLevelInfoPK) {

        this.playerClassLevelInfoPK = playerClassLevelInfoPK;
    }
}
