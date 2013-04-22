/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General private License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General private License for
 * more details.
 * 
 * You should have received a copy of the GNU General private License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jmangos.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author MinimaJack
 * 
 */
@Table(name = "Area_Table")
@Entity
public class AreaTable {

    @Id
    @Column(name = "areaId")
    private Integer areaId;
    @Column(name = "mapId")
    private Integer mapId;
    @Column(name = "parentAreaId", nullable = true)
    private Integer parentAreaId;
    @Column(name = "exploreBit")
    private Integer exploreBit;
    @Column(name = "flags")
    private Integer flags;
    @Column(name = "explorationLevel")
    private Integer explorationLevel;
    @Column(name = "name")
    public String name = new String();

    /**
     * @return the areaId
     */
    public final Integer getAreaId() {
        return this.areaId;
    }

    /**
     * @param areaId
     *        the areaId to set
     */
    public final void setAreaId(final Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @return the mapId
     */
    public final Integer getMapId() {
        return this.mapId;
    }

    /**
     * @param mapId
     *        the mapId to set
     */
    public final void setMapId(final Integer mapId) {
        this.mapId = mapId;
    }

    /**
     * @return the parentAreaId
     */
    public final Integer getParentAreaId() {
        return this.parentAreaId;
    }

    /**
     * @param parentAreaId
     *        the parentAreaId to set
     */
    public final void setParentAreaId(final Integer parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    /**
     * @return the exploreBit
     */
    public final Integer getExploreBit() {
        return this.exploreBit;
    }

    /**
     * @param exploreBit
     *        the exploreBit to set
     */
    public final void setExploreBit(final Integer exploreBit) {
        this.exploreBit = exploreBit;
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
     * @return the explorationLevel
     */
    public final Integer getExplorationLevel() {
        return this.explorationLevel;
    }

    /**
     * @param explorationLevel
     *        the explorationLevel to set
     */
    public final void setExplorationLevel(final Integer explorationLevel) {
        this.explorationLevel = explorationLevel;
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

}
