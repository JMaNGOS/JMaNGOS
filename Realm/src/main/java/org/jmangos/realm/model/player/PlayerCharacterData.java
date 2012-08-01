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
package org.jmangos.realm.model.player;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerCharacterData.
 */
public class PlayerCharacterData {

	/** The XP. */
	private int XP;
	
	/** The Explored zones. */
	private String ExploredZones;
	
	/** The Known titles. */
	private String KnownTitles;
	
	/** The Money. */
	private int Money;
	
	/** The Drunk. */
	private int Drunk;
	
	/** The watched faction. */
	private int watchedFaction;
	
	/** The known currencies. */
	private long knownCurrencies;
	
	/** The ammo id. */
	private int ammoId;
	
	/** The action bars. */
	private byte actionBars; 
 
	/**
	 * Instantiates a new player character data.
	 *
	 * @param xP the x p
	 * @param exploredZones the explored zones
	 * @param knownTitles the known titles
	 * @param money the money
	 * @param drunk the drunk
	 * @param watchedFaction the watched faction
	 * @param knownCurrencies the known currencies
	 * @param ammoId the ammo id
	 * @param actionBars the action bars
	 */
	public PlayerCharacterData(int xP, String exploredZones,
			String knownTitles, int money, int drunk, int watchedFaction,
			long knownCurrencies, int ammoId, byte actionBars) {
		XP = xP;
		ExploredZones = exploredZones;
		KnownTitles = knownTitles;
		Money = money;
		Drunk = drunk;
		this.watchedFaction = watchedFaction;
		this.knownCurrencies = knownCurrencies;
		this.ammoId = ammoId;
		this.actionBars = actionBars;
	}

	/**
	 * Gets the xP.
	 *
	 * @return the xP
	 */
	public int getXP() {
		return XP;
	}

	/**
	 * Gets the explored zones.
	 *
	 * @return the explored zones
	 */
	public String getExploredZones() {
		return ExploredZones;
	}

	/**
	 * Gets the known titles.
	 *
	 * @return the known titles
	 */
	public String getKnownTitles() {
		return KnownTitles;
	}

	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public int getMoney() {
		return Money;
	}

	/**
	 * Gets the drunk.
	 *
	 * @return the drunk
	 */
	public int getDrunk() {
		return Drunk;
	}

	/**
	 * Gets the watched faction.
	 *
	 * @return the watched faction
	 */
	public int getWatchedFaction() {
		return watchedFaction;
	}

	/**
	 * Gets the known currencies.
	 *
	 * @return the known currencies
	 */
	public long getKnownCurrencies() {
		return knownCurrencies;
	}

	/**
	 * Gets the ammo id.
	 *
	 * @return the ammo id
	 */
	public int getAmmoId() {
		return ammoId;
	}

	/**
	 * Gets the action bars.
	 *
	 * @return the action bars
	 */
	public byte getActionBars() {
		return actionBars;
	}

}
