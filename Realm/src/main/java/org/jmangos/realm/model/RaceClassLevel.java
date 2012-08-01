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
