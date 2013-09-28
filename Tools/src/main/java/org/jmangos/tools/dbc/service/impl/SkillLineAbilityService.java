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
/**
 * 
 */
package org.jmangos.tools.dbc.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.tools.dbc.service.AbstractDbcService;
import org.jmangos.tools.dbc.struct.SkillLineAbilityEntry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "skillLineAbilityService")
public class SkillLineAbilityService
        extends AbstractDbcService<SkillLineAbilityEntity, SkillLineAbilityEntry> {

    SkillLineAbilityService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final SkillLineAbilityEntity skillLineAbilityEntity) {

        if (skillLineAbilityEntity.getId() == null) {
            this.entityManager.persist(skillLineAbilityEntity);
        } else {
            this.entityManager.merge(skillLineAbilityEntity);
        }

    }

    @Override
    public void saveAll() {

        SkillLineAbilityEntry entry = getEntry();
        do {
            final SkillLineAbilityEntity se = new SkillLineAbilityEntity();
            se.setId(entry.Id.get());
            se.setSkillId(entry.skillId.get());
            se.setSpellId(entry.spellId.get());
            se.setRacemask(entry.racemask.get());
            se.setClassmask(entry.classmask.get());
            se.setRacemaskNot(entry.racemaskNot.get());
            se.setClassmaskNot(entry.classmaskNot.get());
            se.setReqSkillValue(entry.req_skill_value.get());
            se.setForwardSpellId(entry.forward_spellid.get());
            se.setLearnOnGetSkill(entry.learnOnGetSkill.get());
            se.setMaxValue(entry.maxValue.get());
            se.setMinValue(entry.minValue.get());
            se.setCharacterPoints1(entry.characterPoints[0].get());
            se.setCharacterPoints2(entry.characterPoints[1].get());
            this.entityManager.persist(se);
            if ((entry.getCurrposition() % 10000) == 0) {
                this.entityManager.flush();
                this.entityManager.clear();
            }
        } while ((entry = entry.next()) != null);
        this.entityManager.flush();
        this.entityManager.clear();
    }

    @Override
    public String getDbcPath() {

        return "./../Realm/dbc/SkillLineAbility.dbc";
    }

}
