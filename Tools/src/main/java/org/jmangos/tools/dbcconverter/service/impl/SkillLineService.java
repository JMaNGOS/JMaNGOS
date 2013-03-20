/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SkillLineEntity;
import org.jmangos.tools.dbc.struct.SkillLineEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "skillLineService")
public class SkillLineService extends AbstractDbcService<SkillLineEntity, SkillLineEntry> {

    SkillLineService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final SkillLineEntity skillLineEntity) {

        if (skillLineEntity.getId() == null) {
            this.entityManager.persist(skillLineEntity);
        } else {
            this.entityManager.merge(skillLineEntity);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        SkillLineEntry entry = getEntry();
        do {
            final SkillLineEntity se = new SkillLineEntity();
            se.setId(entry.Id.get());
            se.setAlternateVerb(entry.alternateVerb.get());
            se.setCanLink(entry.canLink.get());
            se.setCategoryId(entry.categoryId.get());
            se.setDescription(entry.description.get());
            se.setName(entry.name.get());
            se.setSkillCostID(entry.skillCostID.get());
            se.setSpellIcon(entry.spellIcon.get());
            this.entityManager.persist(se);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/SkillLine.dbc";
    }

}
