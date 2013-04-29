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

import javax.persistence.*;

/**
 * @author GiBSON
 */
@Table(name = "Chr_Classes")
@Entity
public class ChrClasses {

    @Id
    @Column(name = "id")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPowerType() {
        return powerType;
    }

    public Integer getCinematicSequence() {
        return CinematicSequence;
    }

    public void setId(Integer class_id) {
        this.id = class_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerType(Integer powerType) {
        this.powerType = powerType;
    }

    public void setCinematicSequence(Integer cinematicSequence) {
        CinematicSequence = cinematicSequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExpansion() {
        return expansion;
    }

    public void setExpansion(Integer expansion) {
        this.expansion = expansion;
    }
}
