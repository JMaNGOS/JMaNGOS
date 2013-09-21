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
@Table(name = "Skill_Race_Class_Info")
public class SkillRaceClassInfoEntity {

    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "skillLine")
    private Integer skillLine;
    @Column(name = "racemask")
    private Integer racemask;
    @Column(name = "classmask")
    private Integer classmask;
    @Column(name = "flags")
    private Integer flags;
    @Column(name = "reqlevel")
    private Integer reqlevel;
    @Column(name = "skillTierId")
    private Integer skillTierId;
    @Column(name = "skillCostId")
    private Integer skillCostId;

    public SkillRaceClassInfoEntity() {

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
     * @return the skillLine
     */
    public final Integer getSkillLine() {

        return this.skillLine;
    }

    /**
     * @param skillLine
     *        the skillLine to set
     */
    public final void setSkillLine(final Integer skillLine) {

        this.skillLine = skillLine;
    }

    /**
     * @return the racemask
     */
    public final Integer getRacemask() {

        return this.racemask;
    }

    /**
     * @param racemask
     *        the racemask to set
     */
    public final void setRacemask(final Integer racemask) {

        this.racemask = racemask;
    }

    /**
     * @return the classmask
     */
    public final Integer getClassmask() {

        return this.classmask;
    }

    /**
     * @param classmask
     *        the classmask to set
     */
    public final void setClassmask(final Integer classmask) {

        this.classmask = classmask;
    }

    /**
     * @return the flags
     */
    public final Integer getFlags() {

        return this.flags;
    }

    /**
     * @param flags
     *        the flags to set
     */
    public final void setFlags(final Integer flags) {

        this.flags = flags;
    }

    /**
     * @return the reqlevel
     */
    public final Integer getReqlevel() {

        return this.reqlevel;
    }

    /**
     * @param reqlevel
     *        the reqlevel to set
     */
    public final void setReqlevel(final Integer reqlevel) {

        this.reqlevel = reqlevel;
    }

    /**
     * @return the skillTierId
     */
    public final Integer getSkillTierId() {

        return this.skillTierId;
    }

    /**
     * @param skillTierId
     *        the skillTierId to set
     */
    public final void setSkillTierId(final Integer skillTierId) {

        this.skillTierId = skillTierId;
    }

    /**
     * @return the skillCostId
     */
    public final Integer getSkillCostId() {

        return this.skillCostId;
    }

    /**
     * @param skillCostId
     *        the skillCostId to set
     */
    public final void setSkillCostId(final Integer skillCostId) {

        this.skillCostId = skillCostId;
    }

}
