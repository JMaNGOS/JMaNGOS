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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill_Line")
public class SkillLineEntity {

    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "categoryId")
    private Integer categoryId;
    @Column(name = "skillCostID")
    private Integer skillCostID;
    @Column(name = "name")
    private String name;
    @Column(name = "description", length = 512)
    private String description;
    @Column(name = "spellIcon")
    private Integer spellIcon;
    @Column(name = "alternateVerb", length = 512)
    private String alternateVerb;
    @Column(name = "canLink")
    private Integer canLink;

    public SkillLineEntity() {

    }

    /**
     * @return the id
     */
    public final Integer getId() {

        return this.Id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final Integer id) {

        this.Id = id;
    }

    /**
     * @return the categoryId
     */
    public final Integer getCategoryId() {

        return this.categoryId;
    }

    /**
     * @param categoryId
     *        the categoryId to set
     */
    public final void setCategoryId(final Integer categoryId) {

        this.categoryId = categoryId;
    }

    /**
     * @return the skillCostID
     */
    public final Integer getSkillCostID() {

        return this.skillCostID;
    }

    /**
     * @param skillCostID
     *        the skillCostID to set
     */
    public final void setSkillCostID(final Integer skillCostID) {

        this.skillCostID = skillCostID;
    }

    /**
     * @return the name
     */
    public final String getName() {

        return this.name;
    }

    /**
     * @param name
     *        the name to set
     */
    public final void setName(final String name) {

        this.name = name;
    }

    /**
     * @return the description
     */
    public final String getDescription() {

        return this.description;
    }

    /**
     * @param description
     *        the description to set
     */
    public final void setDescription(final String description) {

        this.description = description;
    }

    /**
     * @return the spellIcon
     */
    public final Integer getSpellIcon() {

        return this.spellIcon;
    }

    /**
     * @param spellIcon
     *        the spellIcon to set
     */
    public final void setSpellIcon(final Integer spellIcon) {

        this.spellIcon = spellIcon;
    }

    /**
     * @return the alternateVerb
     */
    public final String getAlternateVerb() {

        return this.alternateVerb;
    }

    /**
     * @param alternateVerb
     *        the alternateVerb to set
     */
    public final void setAlternateVerb(final String alternateVerb) {

        this.alternateVerb = alternateVerb;
    }

    /**
     * @return the canLink
     */
    public final Integer getCanLink() {

        return this.canLink;
    }

    /**
     * @param canLink
     *        the canLink to set
     */
    public final void setCanLink(final Integer canLink) {

        this.canLink = canLink;
    }

}
