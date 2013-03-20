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
package org.jmangos.commons.enums;

/**
 * The Enum NPCFlags.
 */
public enum NPCFlags {

    /** The NONE. */
    NONE(0),

    /** The GOSSIP. */
    GOSSIP(1),

    /** The QUESTGIVER. */
    QUESTGIVER(1 << 1),

    /** The UNK1. */
    UNK1(1 << 2),

    /** The UNK2. */
    UNK2(1 << 3),

    /** The TRAINER. */
    TRAINER(1 << 4),

    /** The TRAINER_CLASS. */
    TRAINER_CLASS(1 << 5),

    /** The TRAINER_PROFESSION. */
    TRAINER_PROFESSION(1 << 6),

    /** The VENDOR. */
    VENDOR(1 << 7),

    /** The VENDOR_AMMO. */
    VENDOR_AMMO(1 << 8),

    /** The VENDOR_FOOD. */
    VENDOR_FOOD(1 << 9),

    /** The VENDOR_POISON. */
    VENDOR_POISON(1 << 10),

    /** The VENDOR_REAGENT. */
    VENDOR_REAGENT(1 << 11),

    /** The REPAIR. */
    REPAIR(1 << 12),

    /** The FLIGHTMASTER. */
    FLIGHTMASTER(1 << 13),

    /** The SPIRITHEALER. */
    SPIRITHEALER(1 << 14),

    /** The SPIRITGUIDE. */
    SPIRITGUIDE(1 << 15),

    /** The INNKEEPER. */
    INNKEEPER(1 << 16),

    /** The BANKER. */
    BANKER(1 << 17),

    /** The PETITIONER. */
    PETITIONER(1 << 18),

    /** The TABARDDESIGNER. */
    TABARDDESIGNER(1 << 19),

    /** The BATTLEMASTER. */
    BATTLEMASTER(1 << 20),

    /** The AUCTIONEER. */
    AUCTIONEER(1 << 21),

    /** The STABLEMASTER. */
    STABLEMASTER(1 << 22),

    /** The GUILD_BANKER. */
    GUILD_BANKER(1 << 23),

    /** The SPELLCLICK. */
    SPELLCLICK(1 << 24);

    /** The flag. */
    private int flag;

    /**
     * Instantiates a new nPC flags.
     * 
     * @param flag
     *        the flag
     */
    NPCFlags(final int flag) {

        setFlag(flag);
    }

    /**
     * Sets the flag.
     * 
     * @param flag
     *        the new flag
     */
    public void setFlag(final int flag) {

        this.flag = flag;
    }

    /**
     * Gets the flag.
     * 
     * @return the flag
     */
    public int getFlag() {

        return this.flag;
    }
}
