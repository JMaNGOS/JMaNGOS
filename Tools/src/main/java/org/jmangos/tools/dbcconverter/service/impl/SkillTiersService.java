/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SkillTiersEntity;
import org.jmangos.tools.dbc.struct.SkillTiersEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "skillTiersService")
public class SkillTiersService extends AbstractDbcService<SkillTiersEntity, SkillTiersEntry> {

    SkillTiersService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final SkillTiersEntity skillTiersEntity) {

        if (skillTiersEntity.getId() == null) {
            this.entityManager.persist(skillTiersEntity);
        } else {
            this.entityManager.merge(skillTiersEntity);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        SkillTiersEntry entry = getEntry();
        do {
            final SkillTiersEntity se = new SkillTiersEntity();
            se.setId(entry.Id.get());
            for (int i = 0; i < 16; i++) {
                se.setCost(i, entry.cost[i].get());
                se.setMaxValue(i, entry.maxValue[i].get());
            }
            this.entityManager.persist(se);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/SkillTiers.dbc";
    }

}
