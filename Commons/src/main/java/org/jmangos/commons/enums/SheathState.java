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
 * <ul>
 * <li><b>UNARMED</b></li>
 * <li><b>MELEE</b></li>
 * <li><b>RANGED</b></li>
 * </ul>
 * 
 * @author MinimaJack
 * 
 */
public enum SheathState {
    // non prepared weapon
    UNARMED,
    // prepared melee weapon
    MELEE,
    // prepared ranged weapon
    RANGED;

    SheathState() {

    }

    public static SheathState get(int i) {
        if (i < 3) {
            return values()[i];
        } else {
            return null;
        }

    }
}
