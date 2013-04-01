/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.model.item;

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
     * @param damageMin
     *        the damage min
     * @param damageMax
     *        the damage max
     * @param damageType
     *        the damage type
     */
    public _Damage(final float damageMin, final float damageMax, final byte damageType) {

        this.DamageMin = damageMin;
        this.DamageMax = damageMax;
        this.DamageType = damageType;
    }

    /**
     * Gets the damage min.
     * 
     * @return the damageMin
     */
    public float getDamageMin() {

        return this.DamageMin;
    }

    /**
     * Sets the damage min.
     * 
     * @param damageMin
     *        the damageMin to set
     */
    public void setDamageMin(final float damageMin) {

        this.DamageMin = damageMin;
    }

    /**
     * Gets the damage max.
     * 
     * @return the damageMax
     */
    public float getDamageMax() {

        return this.DamageMax;
    }

    /**
     * Sets the damage max.
     * 
     * @param damageMax
     *        the damageMax to set
     */
    public void setDamageMax(final float damageMax) {

        this.DamageMax = damageMax;
    }

    /**
     * Gets the damage type.
     * 
     * @return the damageType
     */
    public byte getDamageType() {

        return this.DamageType;
    }

    /**
     * Sets the damage type.
     * 
     * @param damageType
     *        the damageType to set
     */
    public void setDamageType(final byte damageType) {

        this.DamageType = damageType;
    }
};
