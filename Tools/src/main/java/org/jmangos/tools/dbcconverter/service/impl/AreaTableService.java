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

import org.jmangos.commons.entities.AreaTable;
import org.jmangos.tools.dbc.struct.AreaTableEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "areaTableService")
public class AreaTableService extends AbstractDbcService<AreaTable, AreaTableEntry> {

    AreaTableService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final AreaTable areaTable) {

        if (areaTable.getAreaId() == null) {
            this.entityManager.persist(areaTable);
        } else {
            this.entityManager.merge(areaTable);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        AreaTableEntry entry = getEntry();
        do {
            final AreaTable at = new AreaTable();
            at.setAreaId(entry.id.get());
            at.setMapId(entry.mapId.get());
            if (entry.ParentAreaID.get() > 0) {
                at.setParentAreaId(entry.ParentAreaID.get());
            }
            at.setExploreBit(entry.AreaBit.get());
            at.setFlags(entry.flags.get());
            at.setExplorationLevel(entry.ExplorationLevel.get());
            at.setName(entry.AreaName.get());
            this.entityManager.persist(at);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../Realm/dbc/AreaTable.dbc";
    }

}
