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
package org.JMANGOS.realm.model.base.item;

// TODO: Auto-generated Javadoc
/**
 * The Class _Damage.
 */
public final class _Damage {
	
	/** The Damage min. */
	private float DamageMin;
	
	/** The Damage max. */
	private float DamageMax;
	
	/** The Damage type. */
	private byte DamageType;

	/**
	 * Instantiates a new _ damage.
	 *
	 * @param damageMin the damage min
	 * @param damageMax the damage max
	 * @param damageType the damage type
	 */
	public _Damage(float damageMin, float damageMax, byte damageType) {
		DamageMin = damageMin;
		DamageMax = damageMax;
		DamageType = damageType;
	}

	/**
	 * Gets the damage min.
	 *
	 * @return the damageMin
	 */
	public float getDamageMin() {
		return DamageMin;
	}

	/**
	 * Sets the damage min.
	 *
	 * @param damageMin the damageMin to set
	 */
	public void setDamageMin(float damageMin) {
		DamageMin = damageMin;
	}

	/**
	 * Gets the damage max.
	 *
	 * @return the damageMax
	 */
	public float getDamageMax() {
		return DamageMax;
	}

	/**
	 * Sets the damage max.
	 *
	 * @param damageMax the damageMax to set
	 */
	public void setDamageMax(float damageMax) {
		DamageMax = damageMax;
	}

	/**
	 * Gets the damage type.
	 *
	 * @return the damageType
	 */
	public byte getDamageType() {
		return DamageType;
	}

	/**
	 * Sets the damage type.
	 *
	 * @param damageType the damageType to set
	 */
	public void setDamageType(byte damageType) {
		DamageType = damageType;
	}
};
