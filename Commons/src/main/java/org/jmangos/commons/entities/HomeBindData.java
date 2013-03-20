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
package org.jmangos.commons.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * The Class HomeBindData.
 */
@SuppressWarnings("serial")
@Embeddable
public class HomeBindData implements Serializable {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "x", column = @Column(name = "home_position_x")),
        @AttributeOverride(name = "y", column = @Column(name = "home_position_y")),
        @AttributeOverride(name = "z", column = @Column(name = "home_position_z")),
        @AttributeOverride(name = "o", column = @Column(name = "home_orientation")) })
    Position position;

    /** The home bind map id. */
    @Basic
    @Column(name = "home_map")
    private int homeBindMapId;

    /** The home bind area id. */
    @Basic
    @Column(name = "home_zone")
    private int homeBindAreaId;

    /**
     * Null arg constructor for entity
     */
    public HomeBindData() {

    }

    /**
     * @return the position
     */
    public final Position getPosition() {

        return this.position;
    }

    /**
     * @param position
     *        the position to set
     */
    public final void setPosition(final Position position) {

        this.position = position;
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
     *        the new home bind map id
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
     *        the new home bind area id
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

        return String.format("Map %s  %s", this.homeBindMapId, this.position.toString());

    }
}
