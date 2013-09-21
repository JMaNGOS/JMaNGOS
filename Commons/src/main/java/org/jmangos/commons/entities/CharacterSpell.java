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
import javax.persistence.Table;

/**
 * The Class <tt>CharacterSkill</tt> entity for characters skill values
 */
@Entity
@Table(name = "character_spell")
public class CharacterSpell implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3716661314743117821L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** The spellId. */
    @Basic
    @Column(name = "spellId")
    private int spellId;

    @Basic
    @Column(name = "active")
    private boolean active = true;

    /** The currentValue for the skill. */
    @Basic
    @Column(name = "disabled")
    private boolean disabled = false;

    public CharacterSpell() {

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
     * @return the active
     */
    public final boolean isActive() {
        return this.active;
    }

    /**
     * @param active
     *        the active to set
     */
    public final void setActive(final boolean active) {
        this.active = active;
    }

    /**
     * @return the disabled
     */
    public final boolean isDisabled() {
        return this.disabled;
    }

    /**
     * @param disabled
     *        the disabled to set
     */
    public final void setDisabled(final boolean disabled) {
        this.disabled = disabled;
    }

}
