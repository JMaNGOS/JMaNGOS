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
package org.jmangos.realm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "fields_corpse")
public class FieldsCorpse extends FieldsObject {

    @Column(name = "owner",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private long owner;

    @Column(name = "party",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private long party;

    @Column(name = "displayId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int displayId;

    @Column(name = "bytes1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int bytes1;

    @Column(name = "bytes2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int bytes2;

    @Column(name = "guild",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int guild;

    @Column(name = "flags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int flags;

    @Column(name = "dynamicFlags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int dynamicFlags;

    /**
     * 
     */
    public FieldsCorpse() {

        super();
    }

    /**
     * @return the owner
     */
    public final long getOwner() {

        return this.owner;
    }

    /**
     * @param owner
     *        the owner to set
     */
    public final void setOwner(final long owner) {

        this.owner = owner;
    }

    /**
     * @return the party
     */
    public final long getParty() {

        return this.party;
    }

    /**
     * @param party
     *        the party to set
     */
    public final void setParty(final long party) {

        this.party = party;
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
     * @return the bytes1
     */
    public final int getBytes1() {

        return this.bytes1;
    }

    /**
     * @param bytes1
     *        the bytes1 to set
     */
    public final void setBytes1(final int bytes1) {

        this.bytes1 = bytes1;
    }

    /**
     * @return the bytes2
     */
    public final int getBytes2() {

        return this.bytes2;
    }

    /**
     * @param bytes2
     *        the bytes2 to set
     */
    public final void setBytes2(final int bytes2) {

        this.bytes2 = bytes2;
    }

    /**
     * @return the guild
     */
    public final int getGuild() {

        return this.guild;
    }

    /**
     * @param guild
     *        the guild to set
     */
    public final void setGuild(final int guild) {

        this.guild = guild;
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
     * @return the dynamicFlags
     */
    public final int getDynamicFlags() {

        return this.dynamicFlags;
    }

    /**
     * @param dynamicFlags
     *        the dynamicFlags to set
     */
    public final void setDynamicFlags(final int dynamicFlags) {

        this.dynamicFlags = dynamicFlags;
    }

}
