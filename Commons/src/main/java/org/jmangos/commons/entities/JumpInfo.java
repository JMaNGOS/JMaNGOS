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
/**
 * 
 */
package org.jmangos.commons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * @author MinimaJack
 * 
 */
@Embeddable
public class JumpInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1602404089563628377L;

    @Column(name = "velocity",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    float velocity;
    @Column(name = "sinAngle",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    float sinAngle;
    @Column(name = "cosAngle",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    float cosAngle;
    @Column(name = "xyspeed",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 5,
            scale = 5)
    float xyspeed;

    /**
     * @return the velocity
     */
    public final float getVelocity() {

        return this.velocity;
    }

    /**
     * @param velocity
     *        the velocity to set
     */
    public final void setVelocity(final float velocity) {
        float value = velocity * 100;
        this.velocity = (float)Math.round(value)/100;
    }

    /**
     * @return the sinAngle
     */
    public final float getSinAngle() {

        return this.sinAngle;
    }

    /**
     * @param sinAngle
     *        the sinAngle to set
     */
    public final void setSinAngle(final float sinAngle) {
        float value = sinAngle * 100;
        this.sinAngle = (float)Math.round(value)/100;
    }

    /**
     * @return the cosAngle
     */
    public final float getCosAngle() {

        return this.cosAngle;
    }

    /**
     * @param cosAngle
     *        the cosAngle to set
     */
    public final void setCosAngle(final float cosAngle) {
        float value = cosAngle * 100;
        this.cosAngle = (float)Math.round(value)/100;
    }

    /**
     * @return the xyspeed
     */
    public final float getXYSpeed() {

        return this.xyspeed;
    }

    /**
     * @param xyspeed
     *        the xyspeed to set
     */
    public final void setXYSpeed(final float xyspeed) {
        float value = xyspeed * 100;
        this.xyspeed = (float)Math.round(value)/100;
    }

    public void writeTo(final ChannelBuffer bb) {

        bb.writeFloat(getVelocity());
        bb.writeFloat(getSinAngle());
        bb.writeFloat(getCosAngle());
        bb.writeFloat(getXYSpeed());
    }

    public void readFrom(ChannelBuffer buffer) {
        setVelocity(buffer.readFloat());
        setSinAngle(buffer.readFloat());
        setCosAngle(buffer.readFloat());
        setXYSpeed(buffer.readFloat());
        
    }

}
