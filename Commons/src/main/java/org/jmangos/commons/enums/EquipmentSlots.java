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

import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA. User: Adrian Date: 2012.08.11. Time: 23:09 To
 * change this template
 * use File | Settings | File Templates.
 */
public enum EquipmentSlots {
    HEAD,
    NECK,
    SHOULDERS,
    BODY,
    CHEST,
    WAIST,
    LEGS,
    FEET,
    WRISTS,
    HANDS,
    FINGER1,
    FINGER2,
    TRINKET1,
    TRINKET2,
    BACK,
    MAINHAND,
    OFFHAND,
    RANGED,
    TABARD,
    BAG1,
    BAG2,
    BAG3,
    BAG4;

    public static final EnumSet<EquipmentSlots> ITEMS = EnumSet.range(HEAD, TABARD);
    public static final EnumSet<EquipmentSlots> BAGS = EnumSet.range(BAG1, BAG4);

    public static EquipmentSlots get(final Integer key) {

        if (key < values().length) {
            return values()[key];
        }
        return null;
    }
}
