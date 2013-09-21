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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charstartoutfit")
public class CharStartOutfitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    Integer id;

    @Embedded
    CharClassRaceGender chars;

    @Basic
    @Column(name = "protoId",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    public Integer protoId;

    @Basic
    @Column(name = "slot",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    public Integer slot;

    public CharStartOutfitEntity() {

    }

    /**
     * @return the id
     */
    public final Integer getId() {

        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final Integer id) {

        this.id = id;
    }

    /**
     * @return the protoId
     */
    public final Integer getProtoId() {

        return this.protoId;
    }

    /**
     * @param protoId
     *        the protoId to set
     */
    public final void setProtoId(final Integer protoId) {

        this.protoId = protoId;
    }

    /**
     * @return the slot
     */
    public final Integer getSlot() {

        return this.slot;
    }

    /**
     * @param slot
     *        the slot to set
     */
    public final void setSlot(final Integer slot) {

        this.slot = slot;
    }

    /**
     * @return the charStartOutfitEntityPk
     */
    public final CharClassRaceGender getCharStartOutfitEntityPk() {

        return this.chars;
    }

    /**
     * @param charClassRaceGender
     *        the charStartOutfitEntityPk to set
     */
    public final void setCharStartOutfitEntityPk(final CharClassRaceGender charClassRaceGender) {

        this.chars = charClassRaceGender;
    }

}
