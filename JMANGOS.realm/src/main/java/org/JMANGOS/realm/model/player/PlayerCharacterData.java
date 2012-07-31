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
package org.JMANGOS.realm.model.player;

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
