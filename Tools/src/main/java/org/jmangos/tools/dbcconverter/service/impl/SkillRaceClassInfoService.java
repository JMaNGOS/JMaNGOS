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

        return "./../Realm/dbc/SkillRaceClassInfo.dbc";
    }

}
