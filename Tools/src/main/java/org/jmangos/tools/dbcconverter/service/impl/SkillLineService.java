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
