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
package org.JMANGOS.realm.model.base.item;

// TODO: Auto-generated Javadoc
/**
 * The Class _Spell.
 */
public final class _Spell {
	
	/** The Spell id. */
	private int SpellId; // id from Spell.dbc
	
	/** The Spell trigger. */
	private byte SpellTrigger;
	
	/** The Spell charges. */
	private int SpellCharges;
	
	/** The Spell ppm rate. */
	private float SpellPPMRate;
	
	/** The Spell cooldown. */
	private int SpellCooldown;
	
	/** The Spell category. */
	private int SpellCategory; // id from SpellCategory.dbc
	
	/** The Spell category cooldown. */
	private int SpellCategoryCooldown;

	/**
	 * Instantiates a new _ spell.
	 *
	 * @param spellId the spell id
	 * @param spellTrigger the spell trigger
	 * @param spellCharges the spell charges
	 * @param spellPPMRate the spell ppm rate
	 * @param spellCooldown the spell cooldown
	 * @param spellCategory the spell category
	 * @param spellCategoryCooldown the spell category cooldown
	 */
	public _Spell(int spellId, byte spellTrigger, int spellCharges, float spellPPMRate, int spellCooldown,
			int spellCategory, int spellCategoryCooldown) {
		SpellId = spellId;
		SpellTrigger = spellTrigger;
		SpellCharges = spellCharges;
		SpellPPMRate = spellPPMRate;
		SpellCooldown = spellCooldown;
		SpellCategory = spellCategory;
		SpellCategoryCooldown = spellCategoryCooldown;
	}

	/**
	 * Gets the spell id.
	 *
	 * @return the spellId
	 */
	public int getSpellId() {
		return SpellId;
	}

	/**
	 * Sets the spell id.
	 *
	 * @param spellId the spellId to set
	 */
	public void setSpellId(int spellId) {
		SpellId = spellId;
	}

	/**
	 * Gets the spell trigger.
	 *
	 * @return the spellTrigger
	 */
	public byte getSpellTrigger() {
		return SpellTrigger;
	}

	/**
	 * Sets the spell trigger.
	 *
	 * @param spellTrigger the spellTrigger to set
	 */
	public void setSpellTrigger(byte spellTrigger) {
		SpellTrigger = spellTrigger;
	}

	/**
	 * Gets the spell charges.
	 *
	 * @return the spellCharges
	 */
	public int getSpellCharges() {
		return SpellCharges;
	}

	/**
	 * Sets the spell charges.
	 *
	 * @param spellCharges the spellCharges to set
	 */
	public void setSpellCharges(int spellCharges) {
		SpellCharges = spellCharges;
	}

	/**
	 * Gets the spell ppm rate.
	 *
	 * @return the spellPPMRate
	 */
	public float getSpellPPMRate() {
		return SpellPPMRate;
	}

	/**
	 * Sets the spell ppm rate.
	 *
	 * @param spellPPMRate the spellPPMRate to set
	 */
	public void setSpellPPMRate(float spellPPMRate) {
		SpellPPMRate = spellPPMRate;
	}

	/**
	 * Gets the spell cooldown.
	 *
	 * @return the spellCooldown
	 */
	public int getSpellCooldown() {
		return SpellCooldown;
	}

	/**
	 * Sets the spell cooldown.
	 *
	 * @param spellCooldown the spellCooldown to set
	 */
	public void setSpellCooldown(int spellCooldown) {
		SpellCooldown = spellCooldown;
	}

	/**
	 * Gets the spell category.
	 *
	 * @return the spellCategory
	 */
	public int getSpellCategory() {
		return SpellCategory;
	}

	/**
	 * Sets the spell category.
	 *
	 * @param spellCategory the spellCategory to set
	 */
	public void setSpellCategory(int spellCategory) {
		SpellCategory = spellCategory;
	}

	/**
	 * Gets the spell category cooldown.
	 *
	 * @return the spellCategoryCooldown
	 */
	public int getSpellCategoryCooldown() {
		return SpellCategoryCooldown;
	}

	/**
	 * Sets the spell category cooldown.
	 *
	 * @param spellCategoryCooldown the spellCategoryCooldown to set
	 */
	public void setSpellCategoryCooldown(int spellCategoryCooldown) {
		SpellCategoryCooldown = spellCategoryCooldown;
	}

};
