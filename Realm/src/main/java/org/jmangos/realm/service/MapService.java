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
package org.jmangos.realm.service;

import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.procedure.TObjectProcedure;

import java.util.List;

import javax.annotation.PostConstruct;

import javolution.util.FastMap;

import org.jmangos.commons.entities.AreaTable;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.entities.WorldMap;
import org.jmangos.commons.entities.WorldMapArea;
import org.jmangos.commons.model.base.NestedMap;
import org.jmangos.commons.service.Service;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.realm.model.Area;
import org.jmangos.realm.model.Map;
import org.jmangos.realm.model.RootMap;
import org.jmangos.world.dao.AreaTableDao;
import org.jmangos.world.dao.WorldMapAreaDao;
import org.jmangos.world.dao.WorldMapDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * The Class MapService.
 */
@Component
public class MapService implements Service {

    Logger log = LoggerFactory.getLogger(MapService.class);
    /** The maps. */
    TIntObjectHashMap<Map> maps = new TIntObjectHashMap<Map>();
    @Autowired
    WorldMapAreaDao worldMapAreaDao;
    @Autowired
    WorldMapDao worldMapDao;
    @Autowired
    AreaTableDao areaTableDao;
    @Autowired
    ServiceContent serviceContent;
    /** The map updater. */
    private final MapUpdater mapUpdater = new MapUpdater();

    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {
        final List<WorldMap> worldMaps = this.worldMapDao.findAll();
        for (final WorldMap map : worldMaps) {
            final Map rootMap = ServiceContent.getContext().getBean(RootMap.class);
            rootMap.setId(map.getId());
            rootMap.setName(map.getName());
            this.maps.put(map.getId(), rootMap);
        }

        final List<AreaTable> areaData =
                this.areaTableDao.findAll(new Sort(Sort.Direction.ASC, "mapId").and(new Sort(
                        Sort.Direction.ASC, "parentAreaId").and(new Sort(Sort.Direction.ASC,
                        "areaId"))));
        final FastMap<Integer, Area> savedArea = new FastMap<Integer, Area>();
        for (final AreaTable area : areaData) {
            final Area mainArea = ServiceContent.getContext().getBean(Area.class);
            mainArea.setId(area.getAreaId());
            mainArea.setName(area.getName());
            savedArea.put(area.getAreaId(), mainArea);
            if (area.getParentAreaId() == null) {
                mainArea.setParentArea(this.maps.get(area.getMapId()));
            } else {
                mainArea.setParentArea(savedArea.get(area.getParentAreaId()));
            }
            final NestedMap wm = this.maps.get(area.getMapId());
            if (wm != null) {
                wm.addNestedMap(mainArea);
            } else {
                this.log.info("Cant't find map {} for area {} .", area.getMapId(), area.getAreaId());
            }

        }
        /**
         * Set simple coords
         */
        final List<WorldMapArea> lmaps =
                this.worldMapAreaDao.findAll(new Sort(Sort.Direction.ASC, "areaId").and(new Sort(
                        Sort.Direction.ASC, "mapId")));
        for (final WorldMapArea map : lmaps) {
            final Position lx = new Position();
            final Position rx = new Position();
            lx.setY(map.getyMin());
            lx.setX(map.getxMin());
            rx.setY(map.getyMax());
            rx.setX(map.getxMax());
            if (map.getAreaId() == 0) {
                final Map rootMap = this.maps.get(map.getMapId());
                if (rootMap != null) {
                    rootMap.setLeftCorner(lx);
                    rootMap.setRightCorner(rx);
                    this.log.info("Add coords to root map {}", rootMap.getName());
                } else {
                    this.log.warn("Can't find root map. Skip fetching coords.");
                }
            } else {
                if (this.maps.contains(map.getMapId())) {
                    final Area sarea = savedArea.get(map.getAreaId());
                    if (sarea != null) {
                        sarea.setLeftCorner(lx);
                        sarea.setRightCorner(rx);
                        this.log.info("Add root area {} for map {}", map.name, map.getMapId());
                    } else {
                        this.log.info("Can't find area {}. Skip fetching coords.", map.getAreaId());
                    }
                } else {
                    this.log.info("Skip single area {} {}", map.getAreaId(), map.name);
                }
            }
        }
        /*
         * this.maps.forEachValue(new TObjectProcedure<Map>() {
         * 
         * @Override
         * public boolean execute(Map object) {
         * log.info(object.toString(new StringBuilder(), "\n"));
         * return true;
         * }
         * });
         */

    }

    /**
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {

        this.maps.clear();

    }

    /**
     * Gets the map.
     * 
     * @param guid
     *        the guid
     * @return the map
     */
    public NestedMap getMap(final int guid) {

        if (this.maps.contains(guid)) {
            return this.maps.get(guid);
        }
        return null;
    }

    /**
     * Update.
     */
    public void update() {

        this.maps.forEachValue(this.mapUpdater);
    }

    /**
     * The Class MapUpdater.
     */
    static final class MapUpdater implements TObjectProcedure<Map> {

        /**
         * 
         * @see gnu.trove.TObjectProcedure#execute(java.lang.Object)
         */
        @Override
        public boolean execute(final Map map) {
            return map.update();
        }
    }
}
