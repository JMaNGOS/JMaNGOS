/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.tools.dbc.struct.SkillLineAbilityEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
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
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/SkillLineAbility.dbc";
    }

}
