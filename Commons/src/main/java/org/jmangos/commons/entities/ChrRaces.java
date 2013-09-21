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
        return this.id;
    }

    public void setId(final Races race_id) {
        this.id = race_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getFaction_id() {
        return this.faction_id;
    }

    public void setFaction_id(final Integer faction_id) {
        this.faction_id = faction_id;
    }

    public Integer getModel_male() {
        return this.model_male;
    }

    public void setModel_male(final Integer model_male) {
        this.model_male = model_male;
    }

    public Integer getModel_female() {
        return this.model_female;
    }

    public void setModel_female(final Integer model_female) {
        this.model_female = model_female;
    }

    public Integer getTeam_id() {
        return this.team_id;
    }

    public void setTeam_id(final Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getCinematicSequence() {
        return this.CinematicSequence;
    }

    public void setCinematicSequence(final Integer cinematicSequence) {
        this.CinematicSequence = cinematicSequence;
    }

    public Integer getExpansion() {
        return this.expansion;
    }

    public void setExpansion(final Integer expansion) {
        this.expansion = expansion;
    }
}
