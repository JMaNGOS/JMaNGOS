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
import javax.persistence.Embedded;
import javax.persistence.Transient;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.enums.MovementFlags;
import org.jmangos.commons.enums.MovementFlags2;
import org.jmangos.commons.enums.UpdateFlags;

/**
 * The Class <tt>CreaturePositionerHolder</tt> contains all data linked with
 * character position.</br>
 * 
 * @author MinimaJack
 */
@SuppressWarnings("serial")
@Embeddable
public class CreaturePositionerHolder extends BasicPositionerHolder implements Serializable {

    @Embedded
    private Position position = new Position();

    @Transient
    private TransportInfo transportInfo = new TransportInfo();

    @Transient
    private JumpInfo jumpInfo = new JumpInfo();

    @Transient
    /** MovementFlags */
    private int flags;

    @Transient
    /** MovementFlags2 */
    private int extraFlags;

    @Transient
    private int fallTime;

    @Transient
    private float pitch;

    @Transient
    private float splineElevation;

    @Transient
    float[] speeds = new float[] {
    /** WALK */
    2.5f,
    /** RUN */
    7.0f,
    /** RUN_BACK */
    4.5f,
    /** SWIM */
    4.722222328186f,
    /** SWIM_BACK */
    2.5f,
    /** FLIGHT */
    7.0f,
    /** TURN_RATE */
    4.5f,
    /** FLIGHT_BACK */
    3.1415927410126f,
    /** PITCH_RATE */
    3.1415927410126f };

    @Column(name = "map", nullable = false, insertable = true, updatable = true)
    private short map;

    public CreaturePositionerHolder() {

        super();
        setUpdateFlags(UpdateFlags.LIVING.getValue() | UpdateFlags.HAS_POSITION.getValue());
    }

    /**
     * @return the map
     */
    @Override
    public final int getMap() {

        return this.map;
    }

    @Override
    public void setMap(final short map) {

        this.map = map;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.BasicMovementHolder#buildUpdateBlock(org.jboss
     *      .netty.buffer. ChannelBuffer)
     */
    @Override
    public void buildUpdateData(final ChannelBuffer buffer) {

        buffer.writeInt(this.flags);
        buffer.writeShort(this.extraFlags);
        buffer.writeInt(getTime());
        if (UpdateFlags.HAS_POSITION.contains(getUpdateFlags())) {
            this.position.writeTo(buffer);
        }
        if (UpdateFlags.TRANSPORT.contains(getUpdateFlags())) {
            this.transportInfo.writeTo(buffer);
        }
        if (MovementFlags.SWIMMING.contains(this.flags) ||
            MovementFlags.FLYING.contains(this.flags) ||
            MovementFlags2.ALLOWPITCHING.contains(this.extraFlags)) {
            buffer.writeFloat(getPitch());
        }

        buffer.writeInt(getFallTime());

        if (MovementFlags.FALLING.contains(this.flags)) {

            this.jumpInfo.writeTo(buffer);

        }

        if (MovementFlags.SPLINE_ELEVATION.contains(this.flags)) {
            buffer.writeFloat(this.splineElevation);
        }

        for (final float speed : this.speeds) {
            buffer.writeFloat(speed);
        }

        super.buildUpdateData(buffer);
    }

    public void readFrom(final ChannelBuffer buffer) {
        this.flags = buffer.readInt();
        this.extraFlags = buffer.readShort();
        setTime(buffer.readInt());
        this.position.readFrom(buffer);

        if (MovementFlags.ONTRANSPORT.contains(this.flags)) {
            this.transportInfo.readFrom(buffer);
        }
        if (MovementFlags.SWIMMING.contains(this.flags) ||
            MovementFlags.FLYING.contains(this.flags) ||
            MovementFlags2.ALLOWPITCHING.contains(this.extraFlags)) {
            setPitch(buffer.readFloat());
        }

        setFallTime(buffer.readInt());

        if (MovementFlags.FALLING.contains(this.flags)) {

            this.jumpInfo.readFrom(buffer);

        }

        if (MovementFlags.SPLINE_ELEVATION.contains(this.flags)) {
            this.splineElevation = buffer.readFloat();
        }
    }

    public void update(final CreaturePositionerHolder chph) {
        this.flags = chph.getFlags();
        this.extraFlags = chph.getExtraFlags();
        setTime(chph.getTime());
        this.position.setO(chph.getPosition().getO());
        this.position.setX(chph.getPosition().getX());
        this.position.setY(chph.getPosition().getY());
        this.position.setZ(chph.getPosition().getZ());

        if (MovementFlags.ONTRANSPORT.contains(this.flags)) {
            this.transportInfo = chph.getTransportInfo();
        }
        if (MovementFlags.SWIMMING.contains(this.flags) ||
            MovementFlags.FLYING.contains(this.flags) ||
            MovementFlags2.ALLOWPITCHING.contains(this.extraFlags)) {
            setPitch(chph.getPitch());
        }

        setFallTime(chph.getFallTime());

        if (MovementFlags.FALLING.contains(this.flags)) {

            this.jumpInfo = chph.getJumpInfo();

        }

        if (MovementFlags.SPLINE_ELEVATION.contains(this.flags)) {
            this.splineElevation = chph.getSplineElevation();
        }

    }

    @Override
    protected int getHighGuid() {

        return 0x2F;
    }

    /**
     * @return the position
     */
    @Override
    public final Position getPosition() {

        return this.position;
    }

    /**
     * @param position
     *        the position to set
     */
    @Override
    public final void setPosition(final Position position) {

        this.position = position;
    }

    /**
     * @return the transportInfo
     */
    public final TransportInfo getTransportInfo() {

        return this.transportInfo;
    }

    /**
     * @param transportInfo
     *        the transportInfo to set
     */
    public final void setTransportInfo(final TransportInfo transportInfo) {

        this.transportInfo = transportInfo;
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
     * @return the extraFlags
     */
    public final int getExtraFlags() {

        return this.extraFlags;
    }

    /**
     * @param extraFlags
     *        the extraFlags to set
     */
    public final void setExtraFlags(final int extraFlags) {

        this.extraFlags = extraFlags;
    }

    /**
     * @return the fallTime
     */
    public final int getFallTime() {

        return this.fallTime;
    }

    /**
     * @param fallTime
     *        the fallTime to set
     */
    public final void setFallTime(final int fallTime) {

        this.fallTime = fallTime;
    }

    /**
     * @return the pitch
     */
    public final float getPitch() {

        return this.pitch;
    }

    /**
     * @param pitch
     *        the pitch to set
     */
    public final void setPitch(final float pitch) {

        this.pitch = pitch;
    }

    /**
     * @return the splineElevation
     */
    public final float getSplineElevation() {

        return this.splineElevation;
    }

    /**
     * @param splineElevation
     *        the splineElevation to set
     */
    public final void setSplineElevation(final float splineElevation) {

        this.splineElevation = splineElevation;
    }

    /**
     * @return the jumpInfo
     */
    public final JumpInfo getJumpInfo() {
        return this.jumpInfo;
    }

    /**
     * @param jumpInfo
     *        the jumpInfo to set
     */
    public final void setJumpInfo(final JumpInfo jumpInfo) {
        this.jumpInfo = jumpInfo;
    }

    
    /**
     * @return the speeds
     */
    public final float[] getSpeeds() {
        return this.speeds;
    }

    
    /**
     * @param speeds the speeds to set
     */
    public final void setSpeeds(float[] speeds) {
        this.speeds = speeds;
    }

}
