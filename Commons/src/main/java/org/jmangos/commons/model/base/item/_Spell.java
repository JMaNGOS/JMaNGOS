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
package org.jmangos.commons.model.base.item;

// TODO: Auto-generated Javadoc
/**
 * The Class _Spell.
 */
public final class _Spell {

    /** The Spell id. */
    private int SpellId;              // id from Spell.dbc

    /** The Spell trigger. */
    private byte SpellTrigger;

    /** The Spell charges. */
    private int SpellCharges;

    /** The Spell ppm rate. */
    private float SpellPPMRate;

    /** The Spell cooldown. */
    private int SpellCooldown;

    /** The Spell category. */
    private int SpellCategory;        // id from SpellCategory.dbc

    /** The Spell category cooldown. */
    private int SpellCategoryCooldown;

    /**
     * Instantiates a new _ spell.
     * 
     * @param spellId
     *        the spell id
     * @param spellTrigger
     *        the spell trigger
     * @param spellCharges
     *        the spell charges
     * @param spellPPMRate
     *        the spell ppm rate
     * @param spellCooldown
     *        the spell cooldown
     * @param spellCategory
     *        the spell category
     * @param spellCategoryCooldown
     *        the spell category cooldown
     */
    public _Spell(final int spellId, final byte spellTrigger, final int spellCharges,
            final float spellPPMRate, final int spellCooldown, final int spellCategory,
            final int spellCategoryCooldown) {

        this.SpellId = spellId;
        this.SpellTrigger = spellTrigger;
        this.SpellCharges = spellCharges;
        this.SpellPPMRate = spellPPMRate;
        this.SpellCooldown = spellCooldown;
        this.SpellCategory = spellCategory;
        this.SpellCategoryCooldown = spellCategoryCooldown;
    }

    /**
     * Gets the spell id.
     * 
     * @return the spellId
     */
    public int getSpellId() {

        return this.SpellId;
    }

    /**
     * Sets the spell id.
     * 
     * @param spellId
     *        the spellId to set
     */
    public void setSpellId(final int spellId) {

        this.SpellId = spellId;
    }

    /**
     * Gets the spell trigger.
     * 
     * @return the spellTrigger
     */
    public byte getSpellTrigger() {

        return this.SpellTrigger;
    }

    /**
     * Sets the spell trigger.
     * 
     * @param spellTrigger
     *        the spellTrigger to set
     */
    public void setSpellTrigger(final byte spellTrigger) {

        this.SpellTrigger = spellTrigger;
    }

    /**
     * Gets the spell charges.
     * 
     * @return the spellCharges
     */
    public int getSpellCharges() {

        return this.SpellCharges;
    }

    /**
     * Sets the spell charges.
     * 
     * @param spellCharges
     *        the spellCharges to set
     */
    public void setSpellCharges(final int spellCharges) {

        this.SpellCharges = spellCharges;
    }

    /**
     * Gets the spell ppm rate.
     * 
     * @return the spellPPMRate
     */
    public float getSpellPPMRate() {

        return this.SpellPPMRate;
    }

    /**
     * Sets the spell ppm rate.
     * 
     * @param spellPPMRate
     *        the spellPPMRate to set
     */
    public void setSpellPPMRate(final float spellPPMRate) {

        this.SpellPPMRate = spellPPMRate;
    }

    /**
     * Gets the spell cooldown.
     * 
     * @return the spellCooldown
     */
    public int getSpellCooldown() {

        return this.SpellCooldown;
    }

    /**
     * Sets the spell cooldown.
     * 
     * @param spellCooldown
     *        the spellCooldown to set
     */
    public void setSpellCooldown(final int spellCooldown) {

        this.SpellCooldown = spellCooldown;
    }

    /**
     * Gets the spell category.
     * 
     * @return the spellCategory
     */
    public int getSpellCategory() {

        return this.SpellCategory;
    }

    /**
     * Sets the spell category.
     * 
     * @param spellCategory
     *        the spellCategory to set
     */
    public void setSpellCategory(final int spellCategory) {

        this.SpellCategory = spellCategory;
    }

    /**
     * Gets the spell category cooldown.
     * 
     * @return the spellCategoryCooldown
     */
    public int getSpellCategoryCooldown() {

        return this.SpellCategoryCooldown;
    }

    /**
     * Sets the spell category cooldown.
     * 
     * @param spellCategoryCooldown
     *        the spellCategoryCooldown to set
     */
    public void setSpellCategoryCooldown(final int spellCategoryCooldown) {

        this.SpellCategoryCooldown = spellCategoryCooldown;
    }

};
