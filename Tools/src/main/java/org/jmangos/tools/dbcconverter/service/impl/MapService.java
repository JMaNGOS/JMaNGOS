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

import org.jmangos.commons.entities.WorldMap;
import org.jmangos.commons.enums.MapType;
import org.jmangos.tools.dbc.struct.MapEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "mapService")
public class MapService extends AbstractDbcService<WorldMap, MapEntry> {

    MapService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final WorldMap worldMap) {

        if (worldMap.getId() == null) {
            this.entityManager.persist(worldMap);
        } else {
            this.entityManager.merge(worldMap);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        MapEntry entry = getEntry();
        do {
            final WorldMap wm = new WorldMap();
            wm.setName(entry.name.get());
            wm.setId(entry.id.get());
            wm.setAddon(entry.addon.get());
            wm.setIsPvP(entry.isPvP.get());
            wm.setMapFlags(entry.mapFlags.get());
            if (entry.ghostEntranceMap.get() >= 0) {
                wm.setGhostEntranceMap(entry.ghostEntranceMap.get());
                wm.setGhostEntranceX(entry.ghostEntranceX.get());
                wm.setGhostEntranceY(entry.ghostEntranceY.get());
            }
            wm.setMapType(MapType.values()[entry.mapType.get()]);
            wm.setMaxPlayers(entry.maxPlayers.get());
            this.entityManager.persist(wm);
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

        return "./../Realm/dbc/Map.dbc";
    }

}
