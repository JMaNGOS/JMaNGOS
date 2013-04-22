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
