package org.jmangos.realm.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.buffer.ChannelBuffer;

@Embeddable
public class TransportInfo {

    @Column(name = "transportEntry",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int transportEntry;

    @Column(name = "seat",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte seat;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "x", column = @Column(name = "trans_position_x")),
        @AttributeOverride(name = "y", column = @Column(name = "trans_position_y")),
        @AttributeOverride(name = "z", column = @Column(name = "trans_position_z")),
        @AttributeOverride(name = "o", column = @Column(name = "trans_orientation")) })
    Position position;

    public TransportInfo() {

    }

    /**
     * @return the entry
     */
    public final int getTransportEntry() {

        return this.transportEntry;
    }

    /**
     * @param entry
     *        the entry to set
     */
    public final void setTransportEntry(final int entry) {

        this.transportEntry = entry;
    }

    /**
     * @return the seat
     */
    public final byte getSeat() {

        return this.seat;
    }

    /**
     * @param seat
     *        the seat to set
     */
    public final void setSeat(final byte seat) {

        this.seat = seat;
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

    public void writeTo(final ChannelBuffer bb) {

        // TODO need implement
        throw new NotImplementedException();
    }

}
