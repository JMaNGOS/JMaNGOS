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
package org.jmangos.commons.model.base.update;

import static org.jmangos.commons.model.base.update.ObjectFields.OBJECT_END;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

// TODO: Auto-generated Javadoc
/**
 * The Class GameObjectFields.
 */
public enum GameObjectFields implements UpdateField {

    /**
     * The OBJECT_FIELD_CREATED_BY Size: 2, Type: LONG, Flags: PUBLIC
     */
    OBJECT_FIELD_CREATED_BY(OBJECT_END + 0x0000),

    /**
     * The GAMEOBJECT_DISPLAYID Size: 1, Type: INT, Flags: PUBLIC
     */
    GAMEOBJECT_DISPLAYID(OBJECT_END + 0x0002),

    /**
     * The GAMEOBJECT_FLAGS Size: 1, Type: INT, Flags: PUBLIC
     */
    GAMEOBJECT_FLAGS(OBJECT_END + 0x0003),

    /**
     * The GAMEOBJECT_PARENTROTATION Size: 4, Type: FLOAT, Flags: PUBLIC
     */
    GAMEOBJECT_PARENTROTATION(OBJECT_END + 0x0004),

    /**
     * The GAMEOBJECT_DYNAMIC Size: 1, Type: TWO_SHORT, Flags: DYNAMIC
     */
    GAMEOBJECT_DYNAMIC(OBJECT_END + 0x0008),

    /**
     * The GAMEOBJECT_FACTION Size: 1, Type: INT, Flags: PUBLIC
     */
    GAMEOBJECT_FACTION(OBJECT_END + 0x0009),

    /**
     * The GAMEOBJECT_LEVEL Size: 1, Type: INT, Flags: PUBLIC
     */
    GAMEOBJECT_LEVEL(OBJECT_END + 0x000A),

    /**
     * The GAMEOBJECT_BYTES_1 Size: 1, Type: BYTES, Flags: PUBLIC
     */
    GAMEOBJECT_BYTES_1(OBJECT_END + 0x000B);

    /** The GAMEOBJECT_END */
    public static int GAMEOBJECT_END = OBJECT_END + 0x000C;

    private int value;

    GameObjectFields(final int value) {

        this.value = value;
    }

    @Override
    public UpdateFieldType getType() {

        return UpdateFieldType.INT;
    }

    @Override
    public int getSize() {

        return 0;
    }

    @Override
    public int getValue() {

        return this.value;
    }
}
