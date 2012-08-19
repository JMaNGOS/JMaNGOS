/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.realm.model.player;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * The Class PlayerHomeBindData.
 */
@Entity
@Table(name = "character_homebind")
public class PlayerHomeBindData {
    
    @Id
    @TableGenerator(table = "sequences", allocationSize = 1, name = "character_homebind")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "character_homebind")
    @Column(name = "guid")
    private int   guid;
    
    /** The home bind position x. */
    @Basic
    @Column(name = "position_x")
    private float homeBindPositionX;
    
    /** The home bind position y. */
    @Basic
    @Column(name = "position_y")
    private float homeBindPositionY;
    
    /** The home bind position z. */
    @Basic
    @Column(name = "position_z")
    private float homeBindPositionZ;
    
    /** The home bind map id. */
    @Basic
    @Column(name = "map")
    private int   homeBindMapId;
    
    /** The home bind area id. */
    @Basic
    @Column(name = "zone")
    private int   homeBindAreaId;
    
    /**
     * Null arg constructor for entity
     */
    public PlayerHomeBindData() {
    
    }
    
    /**
     * Instantiates a new player home bind data.
     * 
     * @param homeBindPositionX
     *            the home bind position x
     * @param homeBindPositionY
     *            the home bind position y
     * @param homeBindPositionZ
     *            the home bind position z
     * @param homeBindMapId
     *            the home bind map id
     * @param homeBindAreaId
     *            the home bind area id
     */
    public PlayerHomeBindData(final float homeBindPositionX, final float homeBindPositionY, final float homeBindPositionZ, final int homeBindMapId,
            final int homeBindAreaId) {
    
        this.homeBindPositionX = homeBindPositionX;
        this.homeBindPositionY = homeBindPositionY;
        this.homeBindPositionZ = homeBindPositionZ;
        this.homeBindMapId = homeBindMapId;
        this.homeBindAreaId = homeBindAreaId;
    }
    
    /**
     * Gets the home bind position x.
     * 
     * @return the home bind position x
     */
    public final float getHomeBindPositionX() {
    
        return this.homeBindPositionX;
    }
    
    /**
     * Sets the home bind position x.
     * 
     * @param homeBindPositionX
     *            the new home bind position x
     */
    public final void setHomeBindPositionX(final float homeBindPositionX) {
    
        this.homeBindPositionX = homeBindPositionX;
    }
    
    /**
     * Gets the home bind position y.
     * 
     * @return the home bind position y
     */
    public final float getHomeBindPositionY() {
    
        return this.homeBindPositionY;
    }
    
    /**
     * Sets the home bind position y.
     * 
     * @param homeBindPositionY
     *            the new home bind position y
     */
    public final void setHomeBindPositionY(final float homeBindPositionY) {
    
        this.homeBindPositionY = homeBindPositionY;
    }
    
    /**
     * Gets the home bind position z.
     * 
     * @return the home bind position z
     */
    public final float getHomeBindPositionZ() {
    
        return this.homeBindPositionZ;
    }
    
    /**
     * Sets the home bind position z.
     * 
     * @param homeBindPositionZ
     *            the new home bind position z
     */
    public final void setHomeBindPositionZ(final float homeBindPositionZ) {
    
        this.homeBindPositionZ = homeBindPositionZ;
    }
    
    /**
     * Gets the home bind map id.
     * 
     * @return the home bind map id
     */
    public final int getHomeBindMapId() {
    
        return this.homeBindMapId;
    }
    
    /**
     * Sets the home bind map id.
     * 
     * @param homeBindMapId
     *            the new home bind map id
     */
    public final void setHomeBindMapId(final int homeBindMapId) {
    
        this.homeBindMapId = homeBindMapId;
    }
    
    /**
     * Gets the home bind area id.
     * 
     * @return the home bind area id
     */
    public final int getHomeBindAreaId() {
    
        return this.homeBindAreaId;
    }
    
    /**
     * Sets the home bind area id.
     * 
     * @param homeBindAreaId
     *            the new home bind area id
     */
    public final void setHomeBindAreaId(final int homeBindAreaId) {
    
        this.homeBindAreaId = homeBindAreaId;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
        return String.format("Map %s koords %s, %s ,%s", this.homeBindMapId, this.homeBindPositionX, this.homeBindPositionY, this.homeBindPositionZ);
        
    }
}
