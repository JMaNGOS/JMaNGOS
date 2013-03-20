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

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.08. Time: 13:30
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "fields_gameobject")
public class FieldsGameObject extends FieldsObject {

    @Column(name = "createdBy",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int createdBy;

    @Column(name = "displayId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int displayId;

    @Column(name = "flags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int flags;

    @Embedded
    private Position parentRotation = new Position();

    @Column(name = "dynamic",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int dynamic;

    @Column(name = "faction",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int faction;

    @Column(name = "level",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int level;

    @Column(name = "bytes",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int bytes;

    /**
     * 
     */
    public FieldsGameObject() {

        super();
    }

    /**
     * @return the createdBy
     */
    public final int getCreatedBy() {

        return this.createdBy;
    }

    /**
     * @param createdBy
     *        the createdBy to set
     */
    public final void setCreatedBy(final int createdBy) {

        this.createdBy = createdBy;
    }

    /**
     * @return the displayId
     */
    public final int getDisplayId() {

        return this.displayId;
    }

    /**
     * @param displayId
     *        the displayId to set
     */
    public final void setDisplayId(final int displayId) {

        this.displayId = displayId;
    }

    /**
     * @return the flags
     */
    public final int getFlags() {

        return this.flags;
    }

    /**
     * @param flags
     *        the flags to set
     */
    public final void setFlags(final int flags) {

        this.flags = flags;
    }

    /**
     * @return the parentRotation
     */
    public final Position getParentRotation() {

        return this.parentRotation;
    }

    /**
     * @param parentRotation
     *        the parentRotation to set
     */
    public final void setParentRotation(final Position parentRotation) {

        this.parentRotation = parentRotation;
    }

    /**
     * @return the dynamic
     */
    public final int getDynamic() {

        return this.dynamic;
    }

    /**
     * @param dynamic
     *        the dynamic to set
     */
    public final void setDynamic(final int dynamic) {

        this.dynamic = dynamic;
    }

    /**
     * @return the faction
     */
    public final int getFaction() {

        return this.faction;
    }

    /**
     * @param faction
     *        the faction to set
     */
    public final void setFaction(final int faction) {

        this.faction = faction;
    }

    /**
     * @return the level
     */
    public final int getLevel() {

        return this.level;
    }

    /**
     * @param level
     *        the level to set
     */
    public final void setLevel(final int level) {

        this.level = level;
    }

    /**
     * @return the bytes
     */
    public final int getBytes() {

        return this.bytes;
    }

    /**
     * @param bytes
     *        the bytes to set
     */
    public final void setBytes(final int bytes) {

        this.bytes = bytes;
    }

}
