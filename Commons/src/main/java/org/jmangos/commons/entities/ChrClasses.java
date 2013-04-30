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
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.commons.enums.Classes;

/**
 * @author GiBSON
 */
@Table(name = "Chr_Classes")
@Entity
public class ChrClasses {

    @Id
    @Column(name = "id")
    @Enumerated(EnumType.ORDINAL)
    private Classes id;

    @Column(name = "name")
    private String name = new String();

    @Column(name = "powerType")
    private Integer powerType;

    @Column(name = "type")
    private String type = new String();

    @Column(name = "CinematicSequence")
    private Integer CinematicSequence;

    @Column(name = "expansion")
    private Integer expansion;

    public Classes getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPowerType() {
        return this.powerType;
    }

    public Integer getCinematicSequence() {
        return this.CinematicSequence;
    }

    public void setId(final Classes class_id) {
        this.id = class_id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPowerType(final Integer powerType) {
        this.powerType = powerType;
    }

    public void setCinematicSequence(final Integer cinematicSequence) {
        this.CinematicSequence = cinematicSequence;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Integer getExpansion() {
        return this.expansion;
    }

    public void setExpansion(final Integer expansion) {
        this.expansion = expansion;
    }
}
