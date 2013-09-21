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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "Skill_Line_Ability")
public class SkillLineAbilityEntity {

    private static Logger logger = LoggerFactory.getLogger(SkillLineAbilityEntity.class);

    @Id
    @Column(name = "id")
    public Integer id;
    @Column(name = "skillId")
    public int skillId;
    @Column(name = "spellId")
    public int spellId;
    @Column(name = "racemask")
    public int racemask;
    @Column(name = "classmask")
    public int classmask;
    @Column(name = "racemaskNot")
    public int racemaskNot;
    @Column(name = "classmaskNot")
    public int classmaskNot;
    @Column(name = "req_skill_value")
    public int reqSkillValue;
    @Column(name = "forward_spellid")
    public int forwardSpellId;
    @Column(name = "learnOnGetSkill")
    public int learnOnGetSkill;
    @Column(name = "valueMax")
    public int maxValue;
    @Column(name = "valueMin")
    public int minValue;
    @Column(name = "characterPoints1")
    public int characterPoints1;
    @Column(name = "characterPoints2")
    public int characterPoints2;

    public SkillLineAbilityEntity() {

    }

    /**
     * @return the logger
     */
    public static final Logger getLogger() {

        return logger;
    }

    /**
     * @param logger
     *        the logger to set
     */
    public static final void setLogger(final Logger logger) {

        SkillLineAbilityEntity.logger = logger;
    }

    /**
     * @return the id
     */
    public final Integer getId() {

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
     * @return the skillId
     */
    public final int getSkillId() {

        return this.skillId;
    }

    /**
     * @param skillId
     *        the skillId to set
     */
    public final void setSkillId(final int skillId) {

        this.skillId = skillId;
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
     * @return the racemask
     */
    public final int getRacemask() {

        return this.racemask;
    }

    /**
     * @param racemask
     *        the racemask to set
     */
    public final void setRacemask(final int racemask) {

        this.racemask = racemask;
    }

    /**
     * @return the classmask
     */
    public final int getClassmask() {

        return this.classmask;
    }

    /**
     * @param classmask
     *        the classmask to set
     */
    public final void setClassmask(final int classmask) {

        this.classmask = classmask;
    }

    /**
     * @return the racemaskNot
     */
    public final int getRacemaskNot() {

        return this.racemaskNot;
    }

    /**
     * @param racemaskNot
     *        the racemaskNot to set
     */
    public final void setRacemaskNot(final int racemaskNot) {

        this.racemaskNot = racemaskNot;
    }

    /**
     * @return the classmaskNot
     */
    public final int getClassmaskNot() {

        return this.classmaskNot;
    }

    /**
     * @param classmaskNot
     *        the classmaskNot to set
     */
    public final void setClassmaskNot(final int classmaskNot) {

        this.classmaskNot = classmaskNot;
    }

    /**
     * @return the req_skill_value
     */
    public final int getReq_skill_value() {

        return this.reqSkillValue;
    }

    /**
     * @param req_skill_value
     *        the req_skill_value to set
     */
    public final void setReqSkillValue(final int req_skill_value) {

        this.reqSkillValue = req_skill_value;
    }

    /**
     * @return the forward_spellid
     */
    public final int getForward_spellid() {

        return this.forwardSpellId;
    }

    /**
     * @param forward_spellid
     *        the forward_spellid to set
     */
    public final void setForwardSpellId(final int forward_spellid) {

        this.forwardSpellId = forward_spellid;
    }

    /**
     * @return the learnOnGetSkill
     */
    public final int getLearnOnGetSkill() {

        return this.learnOnGetSkill;
    }

    /**
     * @param learnOnGetSkill
     *        the learnOnGetSkill to set
     */
    public final void setLearnOnGetSkill(final int learnOnGetSkill) {

        this.learnOnGetSkill = learnOnGetSkill;
    }

    /**
     * @return the maxValue
     */
    public final int getMaxValue() {

        return this.maxValue;
    }

    /**
     * @param maxValue
     *        the maxValue to set
     */
    public final void setMaxValue(final int maxValue) {

        this.maxValue = maxValue;
    }

    /**
     * @return the minValue
     */
    public final int getMinValue() {

        return this.minValue;
    }

    /**
     * @param minValue
     *        the minValue to set
     */
    public final void setMinValue(final int minValue) {

        this.minValue = minValue;
    }

    /**
     * @return the characterPoints1
     */
    public final int getCharacterPoints1() {

        return this.characterPoints1;
    }

    /**
     * @param characterPoints1
     *        the characterPoints1 to set
     */
    public final void setCharacterPoints1(final int characterPoints1) {

        this.characterPoints1 = characterPoints1;
    }

    /**
     * @return the characterPoints2
     */
    public final int getCharacterPoints2() {

        return this.characterPoints2;
    }

    /**
     * @param characterPoints2
     *        the characterPoints2 to set
     */
    public final void setCharacterPoints2(final int characterPoints2) {

        this.characterPoints2 = characterPoints2;
    }

}
