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
package org.JMANGOS.realm.model.unit;

import org.JMANGOS.realm.model.base.WorldObject;
import org.JMANGOS.realm.model.base.guid.TypeId;
import org.JMANGOS.realm.model.base.guid.TypeMask;
import org.JMANGOS.realm.model.base.update.UnitFields;

// TODO: Auto-generated Javadoc
/**
 * The Class Units.
 */
public class Units extends WorldObject {
	
	/** The base move speed. */
	float[] baseMoveSpeed = new float[UnitMoveType.MAX_MOVE_TYPE];
	
	/** The m_speed_rate. */
	float[] m_speed_rate = new float[UnitMoveType.MAX_MOVE_TYPE];
	
	/** The base rating value. */
	int[] baseRatingValue = new int[CombatRating.MAX_COMBAT_RATING.ordinal()];
	
	/** The m_attack timer. */
	protected int[] m_attackTimer = new int[WeaponAttackType.MAX_ATTACK
			.ordinal()];
	
	/** The create stats. */
	float[] createStats = new float[Stats.MAX_STATS];

	/**
	 * Gets the creates the stat.
	 *
	 * @param stat the stat
	 * @return the creates the stat
	 */
	public final float getCreateStat(Stats stat) {
		return createStats[stat.ordinal()];
	}
	
	/**
	 * Sets the create stat.
	 *
	 * @param stat the stat
	 * @param value the value
	 */
	public final void setCreateStat(Stats stat, int value) {
		this.createStats[stat.ordinal()] = value;
	}
	
	/**
	 * Instantiates a new units.
	 *
	 * @param objectId the object id
	 */
	public Units(long objectId) {
		super(objectId);
		valuesCount = UnitFields.UNIT_END;
		objectTypeId = TypeId.TYPEID_UNIT;
		objectType.add(TypeMask.TYPEMASK_UNIT);
	}
	
	/**
	 * Gets the max power.
	 *
	 * @param power the power
	 * @return the int
	 */
	public int GetMaxPower(Powers power) {
		return GetUInt32Value(UnitFields.UNIT_FIELD_MAXPOWER1
				+ power.getValue());
	}

	/**
	 * Gets the stat.
	 *
	 * @param stat the stat
	 * @return the float
	 */
	public float GetStat(Stats stat) {
		return GetUInt32Value(UnitFields.UNIT_FIELD_STAT0 + stat.ordinal());
	}
	
	/**
	 * Gets the armor.
	 *
	 * @return the int
	 */
	public int GetArmor() {
		return GetResistance(SpellSchools.SPELL_SCHOOL_NORMAL);
	}
	
	/**
	 * Sets the armor.
	 *
	 * @param value the value
	 */
	public void SetArmor(int value) {
		SetResistance(SpellSchools.SPELL_SCHOOL_NORMAL, value);
	}
	
	/**
	 * Gets the resistance.
	 *
	 * @param school the school
	 * @return the int
	 */
	public int GetResistance(SpellSchools school) {
		return GetUInt32Value(UnitFields.UNIT_FIELD_RESISTANCES
				+ school.ordinal());
	}
	
	/**
	 * Sets the resistance.
	 *
	 * @param school the school
	 * @param value the value
	 */
	public void SetResistance(SpellSchools school, int value) {
		SetUInt32Value(UnitFields.UNIT_FIELD_RESISTANCES + school.ordinal(),
				value);
	}
	
	/**
	 * Gets the attack time.
	 *
	 * @param type the type
	 * @return the int
	 */
	public int GetAttackTime(WeaponAttackType type) {
		return m_attackTimer[type.ordinal()];
	}

	/**
	 * Gets the max health.
	 *
	 * @return the int
	 */
	public int GetMaxHealth() {
		return GetUInt32Value(UnitFields.UNIT_FIELD_MAXHEALTH);
	}
	
	/**
	 * Gets the create powers.
	 *
	 * @param power the power
	 * @return the int
	 */
	public int GetCreatePowers(Powers power) {
		// POWER_FOCUS and POWER_HAPPINESS only have hunter pet
		switch (power) {
			case POWER_MANA :
				return GetCreateMana();
			case POWER_RAGE :
				return 1000;
			case POWER_FOCUS :
				return (getObjectTypeId() == TypeId.TYPEID_PLAYER ? 0 : 100);
			case POWER_ENERGY :
				return 100;
			case POWER_HAPPINESS :
				return (getObjectTypeId() == TypeId.TYPEID_PLAYER ? 0 : 1050000);
			case POWER_RUNIC_POWER :
				return 1000;
			case POWER_RUNE :
				return 0;
			case POWER_HEALTH :
				return 0;
		}

		return 0;
	}
	
	/**
	 * Sets the max power.
	 *
	 * @param power the power
	 * @param value the value
	 */
	public void SetMaxPower(Powers power, int value) {
		SetUInt32Value(UnitFields.UNIT_FIELD_MAXPOWER1 + power.ordinal(), value);
	}
	
	/**
	 * Sets the health.
	 *
	 * @param val the val
	 */
	public void SetHealth(int val) {
		int maxHealth = GetMaxHealth();
		if (maxHealth < val)
			val = maxHealth;
		SetUInt32Value(UnitFields.UNIT_FIELD_HEALTH, val);
	}

	/**
	 * Sets the max health.
	 *
	 * @param value the value
	 */
	public void SetMaxHealth(int value) {
		SetUInt32Value(UnitFields.UNIT_FIELD_MAXHEALTH, value);
	}

	/**
	 * Sets the power.
	 *
	 * @param power the power
	 * @param val the val
	 */
	public void SetPower(Powers power, int val) {
		int maxPower = GetMaxPower(power);
		if (maxPower < val)
			val = maxPower;

		SetUInt32Value(UnitFields.UNIT_FIELD_POWER1 + power.ordinal(), val);
	}
	
	/**
	 * Gets the power.
	 *
	 * @param power the power
	 * @return the int
	 */
	public int GetPower(Powers power) {
		return GetUInt32Value(UnitFields.UNIT_FIELD_POWER1 + power.ordinal());
	}

	/**
	 * Gets the create mana.
	 *
	 * @return the int
	 */
	public int GetCreateMana() {
		return GetUInt32Value(UnitFields.UNIT_FIELD_BASE_MANA);
	}
}
