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

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import javolution.util.FastMap;

import org.apache.commons.lang.NotImplementedException;
import org.jmangos.commons.enums.Powers;

/**
 * The Class UnitPowers.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "character_powers")
public class CharacterPowers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guid")
    private int guid;

    @Basic
    @Column(name = "health")
    private int health;

    /** The MANA. */
    @Basic
    @Column(name = "mana")
    private int mana;

    /** The RAGE. */
    @Basic
    @Column(name = "rage")
    private int rage;

    /** The FOCUS. */
    @Basic
    @Column(name = "focus")
    private int focus;

    /** The ENERGY. */
    @Basic
    @Column(name = "energy")
    private int energy;

    /** The HAPPINESS. */
    @Basic
    @Column(name = "happiness")
    private int happiness;

    /** The RUNE. */
    @Basic
    @Column(name = "rune")
    private int rune;

    /** The RUNIC_POWER. */
    @Basic
    @Column(name = "runic")
    private int runicPower;

    @Transient
    private final Map<Powers, Integer> maxPower = new FastMap<Powers, Integer>(8);

    @Transient
    private final Map<Powers, Integer> createPower = new FastMap<Powers, Integer>(8);

    public CharacterPowers() {

        for (final Powers initPower : Powers.values()) {
            switch (initPower) {
                case ENERGY:
                    this.maxPower.put(initPower, 100);
                break;
                case RAGE:
                    this.maxPower.put(initPower, 1000);
                break;
                case FOCUS:
                    this.maxPower.put(initPower, 100);
                break;
                case RUNE:
                    this.maxPower.put(initPower, 8);
                break;
                case RUNIC_POWER:
                    this.maxPower.put(initPower, 1000);
                break;
                default:
                    this.maxPower.put(initPower, 0);
            }
        }
    }

    /**
     * @return the health
     */
    public final int getHealth() {

        return this.health;
    }

    /**
     * @param health
     *        the health to set
     */
    public final void setHealth(final int health) {

        this.health = health;
    }

    /**
     * @return the mana
     */
    public final int getMana() {

        return this.mana;
    }

    /**
     * @param mana
     *        the mana to set
     */
    public final void setMana(final int mana) {

        this.mana = mana;
    }

    /**
     * @return the rage
     */
    public final int getRage() {

        return this.rage;
    }

    /**
     * @param rage
     *        the rage to set
     */
    public final void setRage(final int rage) {

        this.rage = rage;
    }

    /**
     * @return the focus
     */
    public final int getFocus() {

        return this.focus;
    }

    /**
     * @param focus
     *        the focus to set
     */
    public final void setFocus(final int focus) {

        this.focus = focus;
    }

    /**
     * @return the energy
     */
    public final int getEnergy() {

        return this.energy;
    }

    /**
     * @param energy
     *        the energy to set
     */
    public final void setEnergy(final int energy) {

        this.energy = energy;
    }

    /**
     * @return the happiness
     */
    public final int getHappiness() {

        return this.happiness;
    }

    /**
     * @param happiness
     *        the happiness to set
     */
    public final void setHappiness(final int happiness) {

        this.happiness = happiness;
    }

    /**
     * @return the rune
     */
    public final int getRune() {

        return this.rune;
    }

    /**
     * @param rune
     *        the rune to set
     */
    public final void setRune(final int rune) {

        this.rune = rune;
    }

    /**
     * @return the runicPower
     */
    public final int getRunicPower() {

        return this.runicPower;
    }

    /**
     * @param runicPower
     *        the runicPower to set
     */
    public final void setRunicPower(final int runicPower) {

        this.runicPower = runicPower;
    }

    /**
     * @return the maxPower
     */
    public final int getMaxPower(final Powers power) {

        return this.maxPower.get(power);
    }

    /**
     * @return the maxPower
     */
    public final int getCreatePower(final Powers power) {

        final Integer cp = this.createPower.get(power);

        return (cp != null) ? cp : 0;
    }

    public int getPower(final Powers power) {

        switch (power) {
            case MANA:
                return getMana();
            case ENERGY:
                return getEnergy();
            case HEALTH:
                return getHealth();
            case RAGE:
                return getRage();
            case FOCUS:
                return getFocus();
            case RUNE:
                return getRune();
            case RUNIC_POWER:
                return getRunicPower();
            case HAPPINESS:
                return getHappiness();
            default:
                throw new NotImplementedException("Power not implemented");
        }
    }

    public void setPower(final Powers power, final int value) {

        switch (power) {
            case MANA:
                setMana(value);
            break;
            case ENERGY:
                setEnergy(value);
            break;
            case HEALTH:
                setHealth(value);
            break;
            case RAGE:
                setRage(value);
            break;
            case FOCUS:
                setFocus(value);
            break;
            case RUNE:
                setRune(value);
            break;
            case RUNIC_POWER:
                setRunicPower(value);
            break;
            case HAPPINESS:
                setHappiness(value);
            break;
            default:
                throw new NotImplementedException("Power not implemented");
        }
    }

    public void setMaxPower(final Powers power, final int value) {

        this.maxPower.put(power, value);
    }

    public void setCreatePower(final Powers power, final int value) {

        this.createPower.put(power, value);

    }
}
