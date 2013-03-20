package org.jmangos.commons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.enums.MovementFlags;
import org.jmangos.commons.enums.MovementFlags2;
import org.jmangos.commons.enums.UpdateFlags;

@SuppressWarnings("serial")
@DynamicUpdate
@Entity
@Table(name = "character_positioner")
public class CharacterPositionerHolder extends BasicPositionerHolder implements Serializable {

    @Embedded
    private Position position = new Position();

    @Embedded
    private TransportInfo transportInfo = new TransportInfo();

    @Embedded
    private HomeBindData homeBindData = new HomeBindData();

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

    @Column(name = "zone", nullable = false, insertable = true, updatable = true)
    private int zone;

    public CharacterPositionerHolder() {

        super();
        setUpdateFlags(UpdateFlags.LIVING.getValue() | UpdateFlags.HAS_POSITION.getValue());
    }

    /**
     * @return the zone
     */
    @Override
    public final int getZone() {

        return this.zone;
    }

    /**
     * @param zone
     *        the zone to set
     */
    @Override
    public final void setZone(final int zone) {

        this.zone = zone;
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.subentities.BasicMovementHolder#buildUpdateBlock(org.jboss
     * .netty.buffer.
     * ChannelBuffer)
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
            /**
             * Need reimplement
             */
            /*
             * bb.writeFloat(getJumpInfo().getVelocity());
             * bb.writeFloat(getJumpInfo().getSinAngle());
             * bb.writeFloat(getJumpInfo().getCosAngle());
             * bb.writeFloat(getJumpInfo().getXyspeed());
             */
        }

        if (MovementFlags.SPLINE_ELEVATION.contains(this.flags)) {
            buffer.writeFloat(this.splineElevation);
        }

        for (final float speed : this.speeds) {
            buffer.writeFloat(speed);
        }

        super.buildUpdateData(buffer);
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
     * @return the homeBindData
     */
    public final HomeBindData getHomeBindData() {

        return this.homeBindData;
    }

    /**
     * @param homeBindData
     *        the homeBindData to set
     */
    public final void setHomeBindData(final HomeBindData homeBindData) {

        this.homeBindData = homeBindData;
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

}
