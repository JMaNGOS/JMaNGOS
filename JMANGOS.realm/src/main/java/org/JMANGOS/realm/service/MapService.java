/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.service;

import gnu.trove.TIntObjectHashMap;
import gnu.trove.TObjectProcedure;

import org.JMANGOS.realm.model.base.Map;
import org.JMANGOS.common.service.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class MapService.
 */
public class MapService implements Service {
	
	/** The maps. */
	TIntObjectHashMap<Map> maps = new TIntObjectHashMap<Map>();
	
	/** The map updater. */
	private MapUpdater mapUpdater = new MapUpdater();
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
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
