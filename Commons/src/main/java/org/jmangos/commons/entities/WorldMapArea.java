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
import javax.persistence.Table;

/**
 * 
 * @author MinimaJack
 * 
 */
@Table(name = "World_Map_Area")
@Entity
public class WorldMapArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "mapId")
    public Integer mapId;
    @Column(name = "areaId")
    public Integer areaId;
    @Column(name = "name")
    public String name = new String();
    @Column(name = "yMax",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    public Float yMax;
    @Column(name = "yMin",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    public Float yMin;
    @Column(name = "xMax",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    public Float xMax;
    @Column(name = "xMin",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    public Float xMin;

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
     * @return the yMax
     */
    public final Float getyMax() {
        return this.yMax;
    }

    /**
     * @param yMax
     *        the yMax to set
     */
    public final void setyMax(final Float yMax) {
        this.yMax = yMax;
    }

    /**
     * @return the yMin
     */
    public final Float getyMin() {
        return this.yMin;
    }

    /**
     * @param yMin
     *        the yMin to set
     */
    public final void setyMin(final Float yMin) {
        this.yMin = yMin;
    }

    /**
     * @return the xMax
     */
    public final Float getxMax() {
        return this.xMax;
    }

    /**
     * @param xMax
     *        the xMax to set
     */
    public final void setxMax(final Float xMax) {
        this.xMax = xMax;
    }

    /**
     * @return the xMin
     */
    public final Float getxMin() {
        return this.xMin;
    }

    /**
     * @param xMin
     *        the xMin to set
     */
    public final void setxMin(final Float xMin) {
        this.xMin = xMin;
    }

}
