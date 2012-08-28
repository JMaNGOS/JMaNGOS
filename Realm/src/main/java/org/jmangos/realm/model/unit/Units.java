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
package org.jmangos.realm.model.unit;

import org.jmangos.realm.model.base.WorldObject;
import org.jmangos.realm.model.base.update.UnitField;
import org.jmangos.realm.model.enums.CombatRating;
import org.jmangos.realm.model.enums.Powers;
import org.jmangos.realm.model.enums.SpellSchools;
import org.jmangos.realm.model.enums.Stats;
import org.jmangos.realm.model.enums.TypeID;
import org.jmangos.realm.model.enums.TypeMask;
import org.jmangos.realm.model.enums.UnitMoveType;
import org.jmangos.realm.model.enums.WeaponAttackType;

/**
 * The Class Units.
 */
public class Units extends WorldObject {
    
    /** The base move speed. */
    float[]         baseMoveSpeed   = new float[UnitMoveType.MAX_TYPE];
    
    /** The m_speed_rate. */
    float[]         m_speed_rate    = new float[UnitMoveType.MAX_TYPE];
    
    /** The base rating value. */
    int[]           baseRatingValue = new int[CombatRating.MAX_COMBAT_RATING.ordinal()];
    
    /** The m_attack timer. */
    protected int[] m_attackTimer   = new int[WeaponAttackType.MAX.ordinal()];
    
    /** The create stats. */
    float[]         createStats     = new float[Stats.MAX_STATS];
    
    /**
     * Gets the creates the stat.
     * 
     * @param stat
     *            the stat
     * @return the creates the stat
     */
    public final float getCreateStat(final Stats stat) {
    
        return this.createStats[stat.ordinal()];
    }
    
    /**
     * Sets the create stat.
     * 
     * @param stat
     *            the stat
     * @param value
     *            the value
     */
    public final void setCreateStat(final Stats stat, final int value) {
    
        this.createStats[stat.ordinal()] = value;
    }
    
    /**
     * Instantiates a new units.
     * 
     * @param objectId
     *            the object id
     */
    public Units(final long objectId) {
    
        super(objectId);
        this.valuesCount = UnitField.UNIT_END;
        this.objectTypeId = TypeID.UNIT;
        this.objectType.add(TypeMask.UNIT);
    }
    
    /**
     * Gets the max power.
     * 
     * @param power
     *            the power
     * @return the int
     */
    public int GetMaxPower(final Powers power) {
    
        return GetUInt32Value(UnitField.UNIT_FIELD_MAXPOWER1.getValue() + power.getValue());
    }
    
    /**
     * Gets the stat.
     * 
     * @param stat
     *            the stat
     * @return the float
     */
    public float GetStat(final Stats stat) {
    
        return GetUInt32Value(UnitField.UNIT_FIELD_STAT0.getValue() + stat.ordinal());
    }
    
    /**
     * Gets the armor.
     * 
     * @return the int
     */
    public int GetArmor() {
    
        return GetResistance(SpellSchools.NORMAL);
    }
    
    /**
     * Sets the armor.
     * 
     * @param value
     *            the value
     */
    public void SetArmor(final int value) {
    
        SetResistance(SpellSchools.NORMAL, value);
    }
    
    /**
     * Gets the resistance.
     * 
     * @param school
     *            the school
     * @return the int
     */
    public int GetResistance(final SpellSchools school) {
    
        return GetUInt32Value(UnitField.UNIT_FIELD_RESISTANCES.getValue() + school.ordinal());
    }
    
    /**
     * Sets the resistance.
     * 
     * @param school
     *            the school
     * @param value
     *            the value
     */
    public void SetResistance(final SpellSchools school, final int value) {
    
        SetUInt32Value(UnitField.UNIT_FIELD_RESISTANCES.getValue() + school.ordinal(), value);
    }
    
    /**
     * Gets the attack time.
     * 
     * @param type
     *            the type
     * @return the int
     */
    public int GetAttackTime(final WeaponAttackType type) {
    
        return this.m_attackTimer[type.ordinal()];
    }
    
    /**
     * Gets the max health.
     * 
     * @return the int
     */
    public int GetMaxHealth() {
    
        return GetUInt32Value(UnitField.UNIT_FIELD_MAXHEALTH);
    }
    
    /**
     * Gets the create powers.
     * 
     * @param power
     *            the power
     * @return the int
     */
    public int GetCreatePowers(final Powers power) {
    
        // POWER_FOCUS and POWER_HAPPINESS only have hunter pet
        switch (power) {
            case MANA:
                return GetCreateMana();
            case RAGE:
                return 1000;
            case FOCUS:
                return (getObjectTypeId() == TypeID.PLAYER ? 0 : 100);
            case ENERGY:
                return 100;
            case HAPPINESS:
                return (getObjectTypeId() == TypeID.PLAYER ? 0 : 1050000);
            case RUNIC_POWER:
                return 1000;
            case RUNE:
                return 0;
            case HEALTH:
                return 0;
        }
        
        return 0;
    }
    
    /**
     * Sets the max power.
     * 
     * @param power
     *            the power
     * @param value
     *            the value
     */
    public void SetMaxPower(final Powers power, final int value) {
    
        SetUInt32Value(UnitField.UNIT_FIELD_MAXPOWER1.getValue() + power.ordinal(), value);
    }
    
    /**
     * Sets the health.
     * 
     * @param val
     *            the val
     */
    public void SetHealth(int val) {
    
        final int maxHealth = GetMaxHealth();
        if (maxHealth < val) {
            val = maxHealth;
        }
        SetUInt32Value(UnitField.UNIT_FIELD_HEALTH, val);
    }
    
    /**
     * Sets the max health.
     * 
     * @param value
     *            the value
     */
    public void SetMaxHealth(final int value) {
    
        SetUInt32Value(UnitField.UNIT_FIELD_MAXHEALTH, value);
    }
    
    /**
     * Sets the power.
     * 
     * @param power
     *            the power
     * @param val
     *            the val
     */
    public void SetPower(final Powers power, int val) {
    
        final int maxPower = GetMaxPower(power);
        if (maxPower < val) {
            val = maxPower;
        }
        
        SetUInt32Value(UnitField.UNIT_FIELD_POWER1.getValue() + power.ordinal(), val);
    }
    
    /**
     * Gets the power.
     * 
     * @param power
     *            the power
     * @return the int
     */
    public int GetPower(final Powers power) {
    
        return GetUInt32Value(UnitField.UNIT_FIELD_POWER1.getValue() + power.ordinal());
    }
    
    /**
     * Gets the create mana.
     * 
     * @return the int
     */
    public int GetCreateMana() {
    
        return GetUInt32Value(UnitField.UNIT_FIELD_BASE_MANA);
    }
}
