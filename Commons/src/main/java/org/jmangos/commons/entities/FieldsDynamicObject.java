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
import javax.persistence.Table;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "fields_dynamicobject")
public class FieldsDynamicObject extends FieldsObject {

    /**
     * 
     */
    private static final long serialVersionUID = 5104865877250245472L;

    @Column(name = "caster",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private long caster;

    @Column(name = "bytes",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int bytes;

    @Column(name = "spellId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int spellId;

    @Column(name = "radius",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private float radius;

    @Column(name = "castTime",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int castTime;

    /**
     * 
     */
    public FieldsDynamicObject() {

        super();
    }

    /**
     * @return the caster
     */
    public final long getCaster() {

        return this.caster;
    }

    /**
     * @param caster
     *        the caster to set
     */
    public final void setCaster(final long caster) {

        this.caster = caster;
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

    /**
     * @return the spellId
     */
    public final int getSpellId() {

        return this.spellId;
    }

    /**
     * @param spellId
     *        the spellId to set
     */
    public final void setSpellId(final int spellId) {

        this.spellId = spellId;
    }

    /**
     * @return the radius
     */
    public final float getRadius() {

        return this.radius;
    }

    /**
     * @param radius
     *        the radius to set
     */
    public final void setRadius(final float radius) {

        this.radius = radius;
    }

    /**
     * @return the castTime
     */
    public final int getCastTime() {

        return this.castTime;
    }

    /**
     * @param castTime
     *        the castTime to set
     */
    public final void setCastTime(final int castTime) {

        this.castTime = castTime;
    }

}
