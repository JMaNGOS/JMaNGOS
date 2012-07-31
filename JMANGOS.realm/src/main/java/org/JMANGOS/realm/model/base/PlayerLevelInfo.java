/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base;

import org.JMANGOS.realm.model.unit.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerLevelInfo.
 */
public class PlayerLevelInfo {
	
	/** The stats. */
	int[] stats = new int[Stats.MAX_STATS];
	
	/**
	 * Instantiates a new player level info.
	 *
	 * @param stats the stats
	 */
	public PlayerLevelInfo(int[] stats) {
		this.stats = stats;
	}
	
	/**
	 * Gets the stats.
	 *
	 * @param stat the stat
	 * @return the stats
	 */
	public int getStats(Stats stat) {
		return this.stats[stat.ordinal()];
	}

}
