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

import org.jmangos.commons.enums.ActionButtonType;

/**
 * The Class <tt>CharacterButton</tt> entity for characters action buttons
 * values
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "character_buttons")
public class CharacterButton implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6223227237928120984L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "spec")
    private int spec;

    @Basic
    @Column(name = "button")
    private int button;

    @Basic
    @Column(name = "action")
    private int action;

    @Basic
    @Column(name = "buttonType")
    private int buttonType;

    @ManyToOne
    @JoinColumn(name = "characterId")
    private CharacterData character;

    public CharacterButton() {

    }

    /**
     * @return the spec
     */
    public final int getSpec() {
        return this.spec;
    }

    /**
     * @param spec
     *        the spec to set
     */
    public final void setSpec(final int spec) {
        this.spec = spec;
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
     * @return the button
     */
    public final int getButton() {
        return this.button;
    }

    /**
     * @param button
     *        the button to set
     */
    public final void setButton(final int button) {
        this.button = button;
    }

    /**
     * @return the action
     */
    public final int getAction() {
        return this.action;
    }

    /**
     * @param action
     *        the action to set
     */
    public final void setAction(final int action) {
        this.action = action;
    }

    /**
     * @return the buttonType
     */
    public final ActionButtonType getButtonType() {
        return ActionButtonType.get(this.buttonType);
    }

    /**
     * @return the buttonType
     */
    public final int getNativeButtonType() {
        return this.buttonType;
    }

    /**
     * @param buttonType
     *        the buttonType to set
     */
    public final void setButtonType(final int buttonType) {
        this.buttonType = buttonType;
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

}
