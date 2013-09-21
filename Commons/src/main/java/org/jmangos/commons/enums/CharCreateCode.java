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
package org.jmangos.commons.enums;

/**
 * The Enum CharCreateCode.
 */
public enum CharCreateCode {

    IN_PROGRESS(0x2E),
    SUCCESS(0x2F),
    ERROR(0x30),
    FAILED(0x31),
    NAME_IN_USE(0x32),
    DISABLED(0x33),
    PVP_TEAMS_VIOLATION(0x34),
    SERVER_LIMIT(0x35),
    ACCOUNT_LIMIT(0x36),
    SERVER_QUEUE(0x37),
    ONLY_EXISTING(0x38),
    EXPANSION(0x39),
    EXPANSION_CLASS(0x3A),
    LEVEL_REQUIREMENT(0x3B),
    UNIQUE_CLASS_LIMIT(0x3C),
    CHARACTER_IN_GUILD(0x3D),
    RESTRICTED_RACECLASS(0x3E),
    CHARACTER_CHOOSE_RACE(0x3F),
    CHARACTER_ARENA_LEADER(0x40),
    CHARACTER_DELETE_MAIL(0x41),
    CHARACTER_SWAP_FACTION(0x42),
    CHARACTER_RACE_ONLY(0x43),
    CHARACTER_GOLD_LIMIT(0x44),
    FORCE_LOGIN(0x45);

    private int value;

    CharCreateCode(final int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }
}
