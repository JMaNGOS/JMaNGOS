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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "character_start_skill")
public class SkillEntity {

    @Id
    @Column(name = "entry", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entry;

    @Column(name = "clazz", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    private Classes clazz;

    @Column(name = "race", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.ORDINAL)
    private Races race;

    @Column(name = "skillId", nullable = false, insertable = true, updatable = true)
    private int skillId;

    @Column(name = "currentValue", nullable = false, insertable = true, updatable = true)
    private int currentValue;

    @Column(name = "maxValue", nullable = false, insertable = true, updatable = true)
    private int maxValue;

    public SkillEntity() {

    }

    /**
     * @return the entry
     */
    public final Integer getEntry() {

        return this.entry;
    }

    /**
     * @param entry
     *        the entry to set
     */
    public final void setEntry(final Integer entry) {

        this.entry = entry;
    }

    /**
     * @return the clazz
     */
    public final Classes getClazz() {

        return this.clazz;
    }

    /**
     * @param clazz
     *        the clazz to set
     */
    public final void setClazz(final Classes clazz) {

        this.clazz = clazz;
    }

    /**
     * @return the race
     */
    public final Races getRace() {

        return this.race;
    }

    /**
     * @param race
     *        the race to set
     */
    public final void setRace(final Races race) {

        this.race = race;
    }

    /**
     * @return the skillId
     */
    public final int getSkillId() {

        return this.skillId;
    }

    /**
     * @param skillId
     *        the skillId to set
     */
    public final void setSkillId(final int skillId) {

        this.skillId = skillId;
    }

    /**
     * @return the currentValue
     */
    public final int getCurrentValue() {

        return this.currentValue;
    }

    /**
     * @param currentValue
     *        the currentValue to set
     */
    public final void setCurrentValue(final int currentValue) {

        this.currentValue = currentValue;
    }

    /**
     * @return the maxValue
     */
    public final int getMaxValue() {

        return this.maxValue;
    }

    /**
     * @param maxValue
     *        the maxValue to set
     */
    public final void setMaxValue(final int maxValue) {

        this.maxValue = maxValue;
    }

}
