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
 * Created with IntelliJ IDEA.
 * User: GiBSON
 * Date: 10.05.13
 * Time: 17:13
 */
public enum CharDeleteCode {

    CHAR_DELETE_IN_PROGRESS(0x46),
    CHAR_DELETE_SUCCESS(0x47),
    CHAR_DELETE_FAILED(0x48),
    CHAR_DELETE_FAILED_LOCKED_FOR_TRANSFER(0x49),
    CHAR_DELETE_FAILED_GUILD_LEADER(0x4A),
    CHAR_DELETE_FAILED_ARENA_CAPTAIN(0x4B);

    private int value;

    CharDeleteCode(final int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }
}
