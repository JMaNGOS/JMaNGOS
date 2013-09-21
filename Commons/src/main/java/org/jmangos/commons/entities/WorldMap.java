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

import org.jmangos.commons.enums.MapType;

/**
 * 
 * @author MinimaJack
 * 
 */
@Table(name = "World_Map")
@Entity
public class WorldMap {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "mapType")
    @Enumerated(EnumType.ORDINAL)
    private MapType mapType;

    @Column(name = "mapFlags")
    private Integer mapFlags;

    @Column(name = "isPvP")
    private Integer isPvP;

    @Column(name = "name")
    private String name = new String();

    @Column(name = "ghostEntranceMap")
    private Integer ghostEntranceMap;

    @Column(name = "ghostEntranceX")
    private Float ghostEntranceX;

    @Column(name = "ghostEntranceY")
    private Float ghostEntranceY;

    @Column(name = "addon")
    private Integer addon;

    @Column(name = "maxPlayers")
    private Integer maxPlayers;

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
     * @return the mapType
     */
    public final MapType getMapType() {
        return this.mapType;
    }

    /**
     * @param mapType
     *        the mapType to set
     */
    public final void setMapType(final MapType mapType) {
        this.mapType = mapType;
    }

    /**
     * @return the mapFlags
     */
    public final Integer getMapFlags() {
        return this.mapFlags;
    }

    /**
     * @param mapFlags
     *        the mapFlags to set
     */
    public final void setMapFlags(final Integer mapFlags) {
        this.mapFlags = mapFlags;
    }

    /**
     * @return the isPvP
     */
    public final Integer getIsPvP() {
        return this.isPvP;
    }

    /**
     * @param isPvP
     *        the isPvP to set
     */
    public final void setIsPvP(final Integer isPvP) {
        this.isPvP = isPvP;
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
     * @return the ghostEntranceMap
     */
    public final Integer getGhostEntranceMap() {
        return this.ghostEntranceMap;
    }

    /**
     * @param ghostEntranceMap
     *        the ghostEntranceMap to set
     */
    public final void setGhostEntranceMap(final Integer ghostEntranceMap) {
        this.ghostEntranceMap = ghostEntranceMap;
    }

    /**
     * @return the ghostEntranceX
     */
    public final Float getGhostEntranceX() {
        return this.ghostEntranceX;
    }

    /**
     * @param ghostEntranceX
     *        the ghostEntranceX to set
     */
    public final void setGhostEntranceX(final Float ghostEntranceX) {
        this.ghostEntranceX = ghostEntranceX;
    }

    /**
     * @return the ghostEntranceY
     */
    public final Float getGhostEntranceY() {
        return this.ghostEntranceY;
    }

    /**
     * @param ghostEntranceY
     *        the ghostEntranceY to set
     */
    public final void setGhostEntranceY(final Float ghostEntranceY) {
        this.ghostEntranceY = ghostEntranceY;
    }

    /**
     * @return the addon
     */
    public final Integer getAddon() {
        return this.addon;
    }

    /**
     * @param addon
     *        the addon to set
     */
    public final void setAddon(final Integer addon) {
        this.addon = addon;
    }

    /**
     * @return the maxPlayers
     */
    public final Integer getMaxPlayers() {
        return this.maxPlayers;
    }

    /**
     * @param maxPlayers
     *        the maxPlayers to set
     */
    public final void setMaxPlayers(final Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

}
