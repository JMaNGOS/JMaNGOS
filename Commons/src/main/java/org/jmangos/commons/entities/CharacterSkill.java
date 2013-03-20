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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorOptions;

/**
 * The Class UnitPowers.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "character_skills")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "skillId", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
@DiscriminatorOptions(insert = false)
public class CharacterSkill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** The MANA. */
    @Basic
    @Column(name = "skillId")
    private int skillId;

    /** The RAGE. */
    @Basic
    @Column(name = "maxValue")
    private int maxValue;

    /** The FOCUS. */
    @Basic
    @Column(name = "currentValue")
    private int currentValue;

    public CharacterSkill() {

    }

    /**
     * @return the id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final int id) {
        this.id = id;
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
}
