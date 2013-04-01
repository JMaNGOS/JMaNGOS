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

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.PlayercreateinfoPK;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "playercreateinfo_action")
public class PlayerCreateAction implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1403782310616243930L;

    @Embedded
    PlayercreateinfoPK playercreateinfoPK;

    @Id
    @Column(name = "button",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private Byte button;

    @Basic
    @Column(name = "action",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private Integer action;

    @Basic
    @Column(name = "type",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private Byte type;

    /**
     * Empty constructor
     */
    public PlayerCreateAction() {

    }

    /**
     * @return the action
     */
    public final Integer getAction() {

        return this.action;
    }

    /**
     * @return the type
     */
    public final Byte getType() {

        return this.type;
    }

    /**
     * @param action
     *        the action to set
     */
    public final void setAction(final Integer action) {

        this.action = action;
    }

    /**
     * @param type
     *        the type to set
     */
    public final void setType(final Byte type) {

        this.type = type;
    }

    /**
     * @return the button
     */
    public final Byte getButton() {

        return this.button;
    }

    /**
     * @param button
     *        the button to set
     */
    public final void setButton(final Byte button) {

        this.button = button;
    }

    /**
     * @return the playercreateinfoPK
     */
    public final PlayercreateinfoPK getPlayercreateinfoPK() {

        return this.playercreateinfoPK;
    }

    /**
     * @param playercreateinfoPK
     *        the playercreateinfoPK to set
     */
    public final void setPlayercreateinfoPK(final PlayercreateinfoPK playercreateinfoPK) {

        this.playercreateinfoPK = playercreateinfoPK;
    }

    @Override
    public int hashCode() {

        return (getPlayercreateinfoPK().hashCode() << 8) | (getButton() & 0xFF);
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof PlayerCreateAction)) {
            return false;
        }
        return ((PlayerCreateAction) obj).hashCode() == hashCode();
    }
}
