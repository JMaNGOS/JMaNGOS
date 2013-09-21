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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "Faction_Data")
public class FactionDataEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "raceMask")
    public Integer raceMask;

    @Column(name = "classMask")
    public Integer classMask;

    @Column(name = "value")
    public Integer value;

    @Column(name = "flags")
    public Integer flags;

    @ManyToOne
    @JoinColumn(name = "faction_id")
    private FactionEntity faction;

    /**
     * @return the raceMask
     */
    public final Integer getRaceMask() {
        return this.raceMask;
    }

    /**
     * @param raceMask
     *        the raceMask to set
     */
    public final void setRaceMask(final Integer raceMask) {
        this.raceMask = raceMask;
    }

    /**
     * @return the classMask
     */
    public final Integer getClassMask() {
        return this.classMask;
    }

    /**
     * @param classMask
     *        the classMask to set
     */
    public final void setClassMask(final Integer classMask) {
        this.classMask = classMask;
    }

    /**
     * @return the value
     */
    public final Integer getValue() {
        return this.value;
    }

    /**
     * @param value
     *        the value to set
     */
    public final void setValue(final Integer value) {
        this.value = value;
    }

    /**
     * @return the flags
     */
    public final Integer getFlags() {
        return this.flags;
    }

    /**
     * @param flags
     *        the flags to set
     */
    public final void setFlags(final Integer flags) {
        this.flags = flags;
    }

    /**
     * @return the faction
     */
    public final FactionEntity getFaction() {
        return this.faction;
    }

    /**
     * @param faction
     *        the faction to set
     */
    public final void setFaction(final FactionEntity faction) {
        this.faction = faction;
    }

}
