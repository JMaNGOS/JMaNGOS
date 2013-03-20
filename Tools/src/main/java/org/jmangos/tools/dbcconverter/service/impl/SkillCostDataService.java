/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SkillCostDataEntity;
import org.jmangos.tools.dbc.struct.SkillCostsDataEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "skillCostDataService")
public class SkillCostDataService
        extends AbstractDbcService<SkillCostDataEntity, SkillCostsDataEntry> {

    SkillCostDataService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final SkillCostDataEntity skillCostDataEntity) {

        if (skillCostDataEntity.getId() == null) {
            this.entityManager.persist(skillCostDataEntity);
        } else {
            this.entityManager.merge(skillCostDataEntity);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        SkillCostsDataEntry entry = getEntry();
        do {
            final SkillCostDataEntity se = new SkillCostDataEntity();
            se.setId(entry.Id.get());
            se.setSkillCostId(entry.skillCostId.get());
            se.setCost1(entry.cost1.get());
            se.setCost2(entry.cost2.get());
            se.setCost3(entry.cost3.get());
            this.entityManager.persist(se);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/SkillCostsData.dbc";
    }

}
