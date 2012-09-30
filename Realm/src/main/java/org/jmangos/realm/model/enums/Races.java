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
package org.jmangos.realm.model.enums;

/**
 * 
 * @author MinimaJack
 * 
 */
public enum Races {
    HUMAN(1),
    ORC(2),
    DWARF(3),
    NIGHTELF(4),
    UNDEAD(5),
    TAUREN(6),
    GNOME(7),
    TROLL(8),
    GOBLIN(9),
    BLOODELF(10),
    DRAENEI(11),
    FEL_ORC(12),
    NAGA(13),
    BROKEN(14),
    SKELETON(15),
    VRYKUL(16),
    TUSKARR(17),
    FOREST_TROLL(18),
    TAUNKA(19),
    NORTHREND_SKELETON(20),
    ICE_TROLL(21);

    private byte value;

    Races(final int value) {

        this.value = (byte) value;
    }

    public void setValue(final byte value) {

        this.value = value;
    }

    public byte getValue() {

        return this.value;
    }

    public static Races get(final int value) {

        for (final Races val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }

        return null;
    }
}
