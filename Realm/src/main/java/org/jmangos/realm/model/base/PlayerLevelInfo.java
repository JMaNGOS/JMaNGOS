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
package org.jmangos.realm.model.base;

import org.apache.commons.lang.NotImplementedException;
import org.jmangos.realm.model.unit.Stats;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerLevelInfo.
 */
@Entity
@Table(name="player_levelstats")
public class PlayerLevelInfo {

    @EmbeddedId
    PlayerLevelInfoPK playerLevelInfoPK;

    @Basic
    @Column(name = "str", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int strength;

    @Basic
    @Column(name = "agi", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int agility;

    @Basic
    @Column(name = "sta", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int stamina;

    @Basic
    @Column(name = "inte", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int intellect;

    @Basic
    @Column(name = "spi", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    private int spirit;

    /**
	 * Initialize Persistent entity
	 */
	public PlayerLevelInfo() {
	}
	
	/**
	 * Gets the stats.
	 *
	 * @param stat the stat
	 * @return the stats
	 */
    @Transient
	public int getStats(Stats stat) {
		switch (stat) {
            case AGILITY: return agility;
            case INTELLECT: return intellect;
            case SPIRIT: return spirit;
            case STAMINA: return stamina;
            case STRENGTH: return strength;
            default:
                throw new NotImplementedException( "The enum value: " + stat + " not implemented!" );
        }
	}

    public PlayerLevelInfoPK getPlayerLevelInfoPK() {
        return playerLevelInfoPK;
    }

    public void setPlayerLevelInfoPK(PlayerLevelInfoPK levelInfo) {
        this.playerLevelInfoPK = levelInfo;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }
}
