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
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.09. Time: 16:08 To
 * change this template use
 * File | Settings | File Templates.
 */
public enum TypeID {
    OBJECT(0),
    ITEM(1),
    CONTAINER(2),
    UNIT(3),
    PLAYER(4),
    GAMEOBJECT(5),
    DYNAMICOBJECT(6),
    CORPSE(7),
    AIGROUP(8),
    AREATRIGGER(9);

    private int value;

    TypeID(final int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }
}
