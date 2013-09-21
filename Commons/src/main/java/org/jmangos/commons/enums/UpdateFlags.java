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

public enum UpdateFlags {
    NONE(0x00),
    SELFTARGET(0x01),
    TRANSPORT(0x02),
    HAS_ATTACKING_TARGET(0x04),
    LOWGUID(0x08),
    HIGHGUID(0x10),
    LIVING(0x20),
    HAS_POSITION(0x40),
    VEHICLE(0x80),
    POSITION(0x100),
    ROTATION(0x200),
    UNK1(0x400);

    int value;

    UpdateFlags(final int val) {

        this.value = val;
    }

    public static UpdateFlags get(final int value) {

        for (final UpdateFlags val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }
        return null;
    }

    public int getValue() {

        return this.value;
    }

    public boolean contains(final int val) {

        if ((getValue() & val) == getValue()) {
            return true;
        }
        return false;
    }
}
