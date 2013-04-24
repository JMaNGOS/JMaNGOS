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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.NotImplementedException;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.enums.UpdateFlags;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class BasicPositionerHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guid")
    private int guid;

    @Column(name = "updateFlags", nullable = false, insertable = true, updatable = true)
    private int updateFlags;

    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    private int time;

    public BasicPositionerHolder() {

    }

    public void buildUpdateBlock(final ChannelBuffer buffer, final UpdateFlags... flags) {

        short additionsFlags = 0;
        for (final UpdateFlags updateFlags : flags) {
            if (updateFlags != null) {
                additionsFlags |= updateFlags.getValue();
            }
        }
        this.updateFlags |= additionsFlags;
        buffer.writeShort(this.updateFlags);
        buildUpdateData(buffer);
    }

    protected void buildUpdateData(final ChannelBuffer buffer) {

        if (UpdateFlags.LOWGUID.contains(this.updateFlags)) {
            buffer.writeInt(0x2AAA);
        }

        if (UpdateFlags.HIGHGUID.contains(this.updateFlags)) {
            buffer.writeInt(getHighGuid());
        }
    }

    protected int getHighGuid() {

        return 0x470;
    }

    /**
     * @return the guid
     */
    public final int getGuid() {

        return this.guid;
    }

    /**
     * @param guid
     *        the guid to set
     */
    public final void setGuid(final int guid) {

        this.guid = guid;
    }

    /**
     * @return the updateFlags
     */
    public final int getUpdateFlags() {

        return this.updateFlags;
    }

    public final void addUpdateFlags(final int flag) {

        this.updateFlags |= flag;
    }

    /**
     * @param updateFlags
     *        the updateFlags to set
     */
    public final void setUpdateFlags(final int updateFlags) {

        this.updateFlags = updateFlags;
    }

    /**
     * @return the time
     */
    public final int getTime() {

        return this.time;
    }

    /**
     * @param time
     *        the time to set
     */
    public final void setTime(final int time) {

        this.time = time;
    }

    public void setMap(final short map) {

        throw new NotImplementedException();
    }

    public int getMap() {

        throw new NotImplementedException();
    }

    public void setZone(final int zone) {

        throw new NotImplementedException();

    }

    public int getZone() {

        throw new NotImplementedException();
    }

    public void setPosition(final Position position) {

        throw new NotImplementedException();

    }

    public Position getPosition() {

        throw new NotImplementedException();
    }
}
