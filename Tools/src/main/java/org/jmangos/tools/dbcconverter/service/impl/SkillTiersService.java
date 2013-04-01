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
