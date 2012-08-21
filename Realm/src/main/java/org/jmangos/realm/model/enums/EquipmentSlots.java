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
 * Created with IntelliJ IDEA. User: Adrian Date: 2012.08.11. Time: 23:09 To change this template
 * use File | Settings | File Templates.
 */
public enum EquipmentSlots {
    START(0),
    HEAD(0),
    NECK(1),
    SHOULDERS(2),
    BODY(3),
    CHEST(4),
    WAIST(5),
    LEGS(6),
    FEET(7),
    WRISTS(8),
    HANDS(9),
    FINGER1(10),
    FINGER2(11),
    TRINKET1(12),
    TRINKET2(13),
    BACK(14),
    MAINHAND(15),
    OFFHAND(16),
    RANGED(17),
    TABARD(18),
    END(19);
    
    private int value;
    
    private EquipmentSlots(final int value) {
    
        this.value = value;
    }
    
    public int getValue() {
    
        return this.value;
    }
}
