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

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javolution.util.FastSet;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.jmangos.commons.dataholder.Visitable;
import org.jmangos.commons.dataholder.Visitor;

@Entity
@Table(name = "Faction")
public class FactionEntity implements Visitable<FactionDataEntity> {

    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "team")
    private Integer team;
    @Column(name = "spilloverRateIn")
    private Float spilloverRateIn;
    @Column(name = "spilloverRateOut")
    private Float spilloverRateOut;
    @Column(name = "spilloverMaxRankIn")
    private Integer spilloverMaxRankIn;
    @Column(name = "spilloverMaxRankOut")
    private Integer spilloverMaxRankOut;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "faction")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private final Set<FactionDataEntity> factionData = new FastSet<FactionDataEntity>();

    public FactionEntity() {

    }

    @Override
    public void iterate(final Visitor<FactionDataEntity> visitor) {
        for (final FactionDataEntity value : this.factionData) {
            visitor.visit(value);
        }
    }

    /**
     * @return the id
     */
    public final Integer getId() {
        return this.Id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final Integer id) {
        this.Id = id;
    }

    /**
     * @return the team
     */
    public final Integer getTeam() {
        return this.team;
    }

    /**
     * @param team
     *        the team to set
     */
    public final void setTeam(final Integer team) {
        this.team = team;
    }

    /**
     * @return the spilloverRateIn
     */
    public final Float getSpilloverRateIn() {
        return this.spilloverRateIn;
    }

    /**
     * @param spilloverRateIn
     *        the spilloverRateIn to set
     */
    public final void setSpilloverRateIn(final Float spilloverRateIn) {
        this.spilloverRateIn = spilloverRateIn;
    }

    /**
     * @return the spilloverRateOut
     */
    public final Float getSpilloverRateOut() {
        return this.spilloverRateOut;
    }

    /**
     * @param spilloverRateOut
     *        the spilloverRateOut to set
     */
    public final void setSpilloverRateOut(final Float spilloverRateOut) {
        this.spilloverRateOut = spilloverRateOut;
    }

    /**
     * @return the spilloverMaxRankIn
     */
    public final Integer getSpilloverMaxRankIn() {
        return this.spilloverMaxRankIn;
    }

    /**
     * @param spilloverMaxRankIn
     *        the spilloverMaxRankIn to set
     */
    public final void setSpilloverMaxRankIn(final Integer spilloverMaxRankIn) {
        this.spilloverMaxRankIn = spilloverMaxRankIn;
    }

    /**
     * @return the spilloverMaxRankOut
     */
    public final Integer getSpilloverMaxRankOut() {
        return this.spilloverMaxRankOut;
    }

    /**
     * @param spilloverMaxRankOut
     *        the spilloverMaxRankOut to set
     */
    public final void setSpilloverMaxRankOut(final Integer spilloverMaxRankOut) {
        this.spilloverMaxRankOut = spilloverMaxRankOut;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * @param name
     *        the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the factionData
     */
    public final Set<FactionDataEntity> getFactionData() {
        return this.factionData;
    }

}
