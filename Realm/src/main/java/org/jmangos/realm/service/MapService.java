/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.realm.service;

import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.procedure.TObjectProcedure;

import org.jmangos.commons.service.Service;
import org.jmangos.realm.model.base.Map;

/**
 * The Class MapService.
 */
public class MapService implements Service {
	
	/** The maps. */
	TIntObjectHashMap<Map> maps = new TIntObjectHashMap<Map>();
	
	/** The map updater. */
	private MapUpdater mapUpdater = new MapUpdater();
	
	/* (non-Javadoc)
	 * @see org.jmangos.commons.service.Service#start()
	 */
	@Override
	public void start() {
		
	}

	/* (non-Javadoc)
	 * @see org.jmangos.commons.service.Service#stop()
	 */
	@Override
	public void stop() {
		maps.clear();

	}

	/**
	 * Gets the map.
	 *
	 * @param guid the guid
	 * @return the map
	 */
	public Map getMap(int guid) {
		if (maps.contains(guid)) {
			return maps.get(guid);
		} else {
			Map map = new Map(guid);
			maps.put(guid, map);
			return map;
		}
	}
	
	/**
	 * Update.
	 */
	public void update() {
		maps.forEachValue(mapUpdater);
	}
	
	/**
	 * The Class MapUpdater.
	 */
	class MapUpdater implements TObjectProcedure<Map> {
		
		/* (non-Javadoc)
		 * @see gnu.trove.TObjectProcedure#execute(java.lang.Object)
		 */
		@Override
		public boolean execute(Map map) {
			return map.update();
		}
	}
}
