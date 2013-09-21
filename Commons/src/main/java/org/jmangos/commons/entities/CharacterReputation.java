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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class <tt>CharacterReputation</tt> entity for characters reputation
 * values
 */
@Entity
@Table(name = "character_reputation")
public class CharacterReputation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4262803795750331114L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "faction")
    private int faction;

    @Basic
    @Column(name = "standing")
    private int standing;

    @Basic
    @Column(name = "flags")
    private int flags;

    @ManyToOne
    @JoinColumn(name = "characterId")
    private CharacterData character;

    public CharacterReputation() {

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
     * @return the standing
     */
    public final int getStanding() {
        return this.standing;
    }

    /**
     * @param standing
     *        the standing to set
     */
    public final void setStanding(final int standing) {
        this.standing = standing;
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
     * @return the id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the character
     */
    public final CharacterData getCharacter() {
        return this.character;
    }

    /**
     * @param character
     *        the character to set
     */
    public final void setCharacter(final CharacterData character) {
        this.character = character;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharacterReputation)) {
            return false;
        }
        return (((CharacterReputation) obj).getId() == getId());
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return getId();
    }

}
