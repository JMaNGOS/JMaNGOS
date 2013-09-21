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
import javax.persistence.Transient;

import org.apache.commons.lang.NotImplementedException;
import org.jmangos.commons.entities.pk.PlayerLevelInfoPK;
import org.jmangos.commons.enums.Stats;

/**
 * The Class PlayerLevelInfo.
 */
@Entity
@Table(name = "player_levelstats")
public class PlayerLevelInfo {

    @EmbeddedId
    PlayerLevelInfoPK playerLevelInfoPK;

    @Basic
    @Column(name = "str",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int strength;

    @Basic
    @Column(name = "agi",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int agility;

    @Basic
    @Column(name = "sta",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int stamina;

    @Basic
    @Column(name = "inte",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int intellect;

    @Basic
    @Column(name = "spi",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int spirit;

    /**
     * Initialize Persistent entity
     */
    public PlayerLevelInfo() {

    }

    /**
     * Gets the stats.
     * 
     * @param stat
     *        the stat
     * @return the stats
     */
    @Transient
    public int getStats(final Stats stat) {

        switch (stat) {
            case AGILITY:
                return this.agility;
            case INTELLECT:
                return this.intellect;
            case SPIRIT:
                return this.spirit;
            case STAMINA:
                return this.stamina;
            case STRENGTH:
                return this.strength;
            default:
                throw new NotImplementedException("The enum value: " + stat + " not implemented!");
        }
    }

    public PlayerLevelInfoPK getPlayerLevelInfoPK() {

        return this.playerLevelInfoPK;
    }

    public void setPlayerLevelInfoPK(final PlayerLevelInfoPK levelInfo) {

        this.playerLevelInfoPK = levelInfo;
    }

    public int getStrength() {

        return this.strength;
    }

    public void setStrength(final int strength) {

        this.strength = strength;
    }

    public int getAgility() {

        return this.agility;
    }

    public void setAgility(final int agility) {

        this.agility = agility;
    }

    public int getStamina() {

        return this.stamina;
    }

    public void setStamina(final int stamina) {

        this.stamina = stamina;
    }

    public int getIntellect() {

        return this.intellect;
    }

    public void setIntellect(final int intellect) {

        this.intellect = intellect;
    }

    public int getSpirit() {

        return this.spirit;
    }

    public void setSpirit(final int spirit) {

        this.spirit = spirit;
    }
}
