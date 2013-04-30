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

import org.jmangos.commons.enums.Races;

/**
 * @author GiBSON
 */
@Table(name = "Chr_Races")
@Entity
public class ChrRaces {

    @Id
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id")
    private Races id;

    @Column(name = "name")
    private String name = new String();

    @Column(name = "faction_id")
    private Integer faction_id;

    @Column(name = "model_male")
    private Integer model_male;

    @Column(name = "model_female")
    private Integer model_female;

    @Column(name = "team_id")
    private Integer team_id;

    @Column(name = "CinematicSequence")
    private Integer CinematicSequence;

    @Column(name = "expansion")
    private Integer expansion;

    public Races getId() {
        return id;
    }

    public void setId(Races race_id) {
        this.id = race_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFaction_id() {
        return faction_id;
    }

    public void setFaction_id(Integer faction_id) {
        this.faction_id = faction_id;
    }

    public Integer getModel_male() {
        return model_male;
    }

    public void setModel_male(Integer model_male) {
        this.model_male = model_male;
    }

    public Integer getModel_female() {
        return model_female;
    }

    public void setModel_female(Integer model_female) {
        this.model_female = model_female;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getCinematicSequence() {
        return CinematicSequence;
    }

    public void setCinematicSequence(Integer cinematicSequence) {
        CinematicSequence = cinematicSequence;
    }

    public Integer getExpansion() {
        return expansion;
    }

    public void setExpansion(Integer expansion) {
        this.expansion = expansion;
    }
}
