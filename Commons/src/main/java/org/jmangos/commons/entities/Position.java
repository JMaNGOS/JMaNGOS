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

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.jboss.netty.buffer.ChannelBuffer;

@Embeddable
public class Position implements Cloneable, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5951666104511646838L;

    @Column(name = "position_x",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    private float x;

    @Column(name = "position_y",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    private float y;

    @Column(name = "position_z",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    private float z;

    @Column(name = "orientation",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    private float o;

    public Position() {

    }

    /**
     * @return the x
     */
    public final float getX() {

        return this.x;
    }

    /**
     * @param x
     *        the x to set
     */
    public final void setX(final float x) {
        final float value = x * 100;
        this.x = (float) Math.round(value) / 100;
    }

    /**
     * @return the y
     */
    public final float getY() {

        return this.y;
    }

    /**
     * @param y
     *        the y to set
     */
    public final void setY(final float y) {
        final float value = y * 100;
        this.y = (float) Math.round(value) / 100;
    }

    /**
     * @return the z
     */
    public final float getZ() {

        return this.z;
    }

    /**
     * @param z
     *        the z to set
     */
    public final void setZ(final float z) {
        final float value = z * 100;
        this.z = (float) Math.round(value) / 100;
    }

    /**
     * @return the o
     */
    public final float getO() {

        return this.o;
    }

    /**
     * @param o
     *        the o to set
     */
    public final void setO(final float o) {
        final float value = o * 100;
        this.o = (float) Math.round(value) / 100;
    }

    @Override
    public String toString() {

        return "[Position] x:" + this.x + " y:" + this.y + " z:" + this.z;
    }

    @Override
    public Position clone() {

        final Position newPos = new Position();
        newPos.setX(getX());
        newPos.setY(getY());
        newPos.setZ(getZ());
        newPos.setO(getO());
        return newPos;
    }

    public void writeTo(final ChannelBuffer bb) {

        bb.writeFloat(getX());
        bb.writeFloat(getY());
        bb.writeFloat(getZ());
        bb.writeFloat(getO());

    }

    public void readFrom(final ChannelBuffer buffer) {
        setX(buffer.readFloat());
        setY(buffer.readFloat());
        setZ(buffer.readFloat());
        setO(buffer.readFloat());
    }
}
