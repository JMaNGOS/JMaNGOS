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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.buffer.ChannelBuffer;

@SuppressWarnings("serial")
@Embeddable
public class TransportInfo implements Serializable {

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
