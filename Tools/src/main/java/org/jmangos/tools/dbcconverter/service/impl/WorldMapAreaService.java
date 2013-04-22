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

import org.jmangos.commons.entities.WorldMapArea;
import org.jmangos.tools.dbc.struct.WorldMapAreaEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "worldMapAreaService")
public class WorldMapAreaService extends AbstractDbcService<WorldMapArea, WorldMapAreaEntry> {

    WorldMapAreaService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final WorldMapArea worldMapArea) {

        if (worldMapArea.getId() == null) {
            this.entityManager.persist(worldMapArea);
        } else {
            this.entityManager.merge(worldMapArea);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        WorldMapAreaEntry entry = getEntry();
        do {
            final WorldMapArea wma = new WorldMapArea();
            wma.setMapId(entry.map_id.get());
            wma.setAreaId(entry.area_id.get());
            wma.setName(entry.internalname.get());
            wma.setxMax(entry.x1.get());
            wma.setxMin(entry.x2.get());
            wma.setyMax(entry.y1.get());
            wma.setyMin(entry.y2.get());
            this.entityManager.persist(wma);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../Realm/dbc/WorldMapArea.dbc";
    }

}
