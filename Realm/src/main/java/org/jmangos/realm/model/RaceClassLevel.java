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
package org.jmangos.realm.model;

// TODO: Auto-generated Javadoc
/**
 * The Class RaceClassLevel.
 */
public class RaceClassLevel extends ClassLevel{

	/** The race. */
	private int race;

	/**
	 * Instantiates a new race class level.
	 *
	 * @param race the race
	 * @param clazz the clazz
	 * @param level the level
	 */
	public RaceClassLevel(int race, int clazz, int level) {
		super(clazz, level);
		this.hashCode  += race * 1000; 
		this.setRace(race);
	}

	/**
	 * Sets the race.
	 *
	 * @param race the new race
	 */
	public void setRace(int race) {
		this.race = race;
	}

	/**
	 * Gets the race.
	 *
	 * @return the race
	 */
	public int getRace() {
		return race;
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.realm.model.ClassLevel#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if ((((ClassLevel) obj).clazz == this.clazz)
				&& (((ClassLevel) obj).level == this.level) && (((RaceClassLevel) obj).race == this.race)) {
			return true;
		}
		return false;
	}
}
