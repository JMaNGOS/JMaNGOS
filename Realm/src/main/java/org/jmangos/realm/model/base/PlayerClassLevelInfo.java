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
package org.jmangos.realm.model.base;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerClassLevelInfo.
 */
public class PlayerClassLevelInfo {

	/** The base health. */
	private int baseHealth;
	
	/** The base mana. */
	private int baseMana;

	/**
	 * Gets the basehealth.
	 *
	 * @return the basehealth
	 */
	public int getBasehealth() {
		return baseHealth;
	}

	/**
	 * Gets the basemana.
	 *
	 * @return the basemana
	 */
	public int getBasemana() {
		return baseMana;
	}

	/**
	 * Instantiates a new player class level info.
	 *
	 * @param baseHealth the base health
	 * @param baseMana the base mana
	 */
	public PlayerClassLevelInfo(int baseHealth, int baseMana) {
		this.baseHealth = baseHealth;
		this.baseMana = baseMana;
	}

}
