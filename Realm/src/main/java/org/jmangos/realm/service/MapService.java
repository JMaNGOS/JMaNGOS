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

import org.jmangos.commons.entities.Position;
import org.jmangos.commons.entities.WorldMapArea;
import org.jmangos.commons.model.base.Area;
import org.jmangos.commons.model.base.Map;
import org.jmangos.commons.service.Service;
import org.jmangos.commons.service.ServiceContent;
import org.jmangos.world.dao.WorldMapAreaDao;
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
                final Map rootMap = ServiceContent.getContext().getBean("Map", Map.class);
                rootMap.setId(map.getMapId());
                rootMap.setLeftCorner(lx);
                rootMap.setRightCorner(rx);
                this.maps.put(map.getMapId(), rootMap);
                this.log.info("Add root map {}", map.name);
            } else {
                final Area mainArea = ServiceContent.getContext().getBean(Area.class);
                mainArea.setId(map.getAreaId());
                mainArea.setParentArea(this.maps.get(map.getMapId()));
                mainArea.setLeftCorner(lx);
                mainArea.setRightCorner(rx);
                if (this.maps.contains(map.getMapId())) {
                    this.maps.get(map.getMapId()).addSubArea(mainArea);
                    this.log.info("Add root area {} for map {}", map.name, map.getMapId());
                } else {
                    this.log.info("Add single area {} {}", map.getAreaId(), map.name);
                }
            }

        }
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
    public Map getMap(final int guid) {

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
