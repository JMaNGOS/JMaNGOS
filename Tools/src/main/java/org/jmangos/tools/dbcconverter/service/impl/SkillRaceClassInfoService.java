/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.tools.dbc.struct.SkillRaceClassInfoEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "skillLineService")
public class SkillRaceClassInfoService
        extends AbstractDbcService<SkillRaceClassInfoEntity, SkillRaceClassInfoEntry> {

    SkillRaceClassInfoService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final SkillRaceClassInfoEntity skillLineEntity) {

        if (skillLineEntity.getId() == null) {
            this.entityManager.persist(skillLineEntity);
        } else {
            this.entityManager.merge(skillLineEntity);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        SkillRaceClassInfoEntry entry = getEntry();
        do {
            final SkillRaceClassInfoEntity se = new SkillRaceClassInfoEntity();
            se.setId(entry.Id.get());
            se.setFlags(entry.flags.get());
            se.setRacemask(entry.racemask.get());
            se.setClassmask(entry.classmask.get());
            se.setSkillCostId(entry.skillCostId.get());
            se.setSkillLine(entry.skillLine.get());
            se.setReqlevel(entry.reqlevel.get());
            se.setSkillTierId(entry.skillTierId.get());
            this.entityManager.persist(se);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/SkillRaceClassInfo.dbc";
    }

}
