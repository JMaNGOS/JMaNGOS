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

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import javolution.util.FastMap;

import org.jmangos.commons.enums.Powers;

/**
 * The Class <tt>CreaturePowers</tt>.
 */
@MappedSuperclass
@Table(name = "creature_powers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CreaturePowers implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7437008187319811913L;

    @Id
    @TableGenerator(table = "sequences", allocationSize = 1, name = "chreature_powers")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "chreature_powers")
    private int guid;

    @Basic
    @Column(name = "health")
    private int health;

    /** The MANA. */
    @Basic
    @Column(name = "mana")
    private int mana;

    @Transient
    private final Map<Powers, Integer> createPower = new FastMap<Powers, Integer>(8);

    @Transient
    private final Map<Powers, Integer> maxPower = new FastMap<Powers, Integer>(8);

    public CreaturePowers() {}

    /**
     * @return the guid
     */
    public final int getGuid() {
        return this.guid;
    }

    /**
     * @param guid
     *        the guid to set
     */
    public final void setGuid(final int guid) {
        this.guid = guid;
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

    public int getPower(final Powers power) {

        switch (power) {
            case MANA:
                return getMana();
            case HEALTH:
                return getHealth();
            default:
                return 0;
        }

    }

    public void setPower(final Powers power, final int value) {

        switch (power) {
            case MANA:
                setMana(value);
            break;
            case HEALTH:
                setHealth(value);
            break;
            default:
            break;
        }
    }

    /**
     * @return the maxPower
     */
    public final int getCreatePower(final Powers power) {

        final Integer cp = this.createPower.get(power);

        return (cp != null) ? cp : 0;
    }

    /**
     * 
     * @param power
     * @param value
     */
    public void setCreatePower(final Powers power, final int value) {

        this.createPower.put(power, value);

    }

    /**
     * @return the maxPower
     */
    public final int getMaxPower(final Powers power) {

        return this.maxPower.get(power);
    }

    /**
     * 
     * @param power
     * @param value
     */
    public void setMaxPower(final Powers power, final int value) {

        this.maxPower.put(power, value);
    }
}
