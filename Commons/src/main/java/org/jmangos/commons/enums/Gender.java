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

public enum Gender {
    MALE((byte) 0),
    FEMALE((byte) 1);

    private byte value;

    Gender(final byte val) {

        this.value = val;
    }

    /**
     * @return the value
     */
    public final byte getValue() {

        return this.value;
    }

    /**
     * @param value
     *        the value to set
     */
    public final void setValue(final byte value) {

        this.value = value;
    }

    public static Gender get(final int value) {

        for (final Gender val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }

        return null;
    }

}
