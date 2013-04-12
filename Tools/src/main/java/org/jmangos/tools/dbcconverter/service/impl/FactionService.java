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

import org.jmangos.commons.entities.FactionDataEntity;
import org.jmangos.commons.entities.FactionEntity;
import org.jmangos.tools.dbc.struct.FactionEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "factionService")
public class FactionService extends AbstractDbcService<FactionEntity, FactionEntry> {

    FactionService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final FactionEntity skillLineEntity) {

        if (skillLineEntity.getId() == null) {
            this.entityManager.persist(skillLineEntity);
        } else {
            this.entityManager.merge(skillLineEntity);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        FactionEntry entry = getEntry();
        do {
            if (entry.reputationListID.get() > 0) {
                FactionEntity fe = new FactionEntity();
                fe.setName(entry.name.get());
                fe.setId(entry.reputationListID.get());
                fe.setSpilloverMaxRankIn(entry.spilloverMaxRankIn.get());
                fe.setSpilloverMaxRankOut(entry.spilloverMaxRankOut.get());
                fe.setSpilloverRateIn(entry.spilloverRateIn.get());
                fe.setSpilloverRateOut(entry.spilloverRateOut.get());
                fe.setTeam(entry.team.get());
                for (int i = 0; i < 4; i++) {
                    if (entry.BaseRepClassMask[i].get() > 0 ||
                        entry.BaseRepRaceMask[i].get() > 0 ||
                        entry.BaseRepValue[i].get() > 0 ||
                        entry.ReputationFlags[i].get() > 0) {
                        FactionDataEntity fde = new FactionDataEntity();
                        fde.setClassMask(entry.BaseRepClassMask[i].get());
                        fde.setRaceMask(entry.BaseRepRaceMask[i].get());
                        fde.setValue(entry.BaseRepValue[i].get());
                        fde.setFlags(entry.ReputationFlags[i].get());
                        fde.setFaction(fe);
                        fe.getFactionData().add(fde);
                    }
                }
                this.entityManager.persist(fe);
            }
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/Faction.dbc";
    }

}
