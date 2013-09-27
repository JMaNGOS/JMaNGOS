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

import org.jmangos.commons.entities.ChrRaces;
import org.jmangos.commons.enums.Races;
import org.jmangos.tools.dbc.struct.ChrRacesEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 */
@Service
@Qualifier(value = "ChrRacesService")
public class ChrRacesService extends AbstractDbcService<ChrRaces, ChrRacesEntry> {

    ChrRacesService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final ChrRaces chrRaces) {

        if (chrRaces.getId() == null) {
            this.entityManager.persist(chrRaces);
        } else {
            this.entityManager.merge(chrRaces);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        ChrRacesEntry entry = getEntry();
        do {
            final ChrRaces cr = new ChrRaces();
            cr.setId(Races.get(entry.RaceID.get()));
            cr.setName(entry.name.get());
            cr.setCinematicSequence(entry.CinematicSequence.get());
            cr.setFaction_id(entry.FactionID.get());
            cr.setModel_female(entry.modelF.get());
            cr.setModel_male(entry.modelM.get());
            cr.setTeam_id(entry.TeamID.get());
            cr.setExpansion(entry.expansion.get());
            this.entityManager.persist(cr);
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

        return "./../Realm/dbc/ChrRaces.dbc";
    }

}
