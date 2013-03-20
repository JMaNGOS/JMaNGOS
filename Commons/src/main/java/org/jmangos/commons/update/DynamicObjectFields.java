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
package org.jmangos.commons.update;

import static org.jmangos.commons.update.ObjectFields.OBJECT_END;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

// TODO: Auto-generated Javadoc
/**
 * The Class DynamicObjectFields.
 */
public enum DynamicObjectFields implements UpdateField {

    /**
     * The DYNAMICOBJECT_CASTER Size: 2, Type: LONG, Flags: PUBLIC
     */
    DYNAMICOBJECT_CASTER(OBJECT_END + 0x0000),

    /**
     * The DYNAMICOBJECT_BYTES Size: 1, Type: BYTES, Flags: PUBLIC
     */
    DYNAMICOBJECT_BYTES(OBJECT_END + 0x0002),

    /**
     * The DYNAMICOBJECT_SPELLID Size: 1, Type: INT, Flags: PUBLIC
     */
    DYNAMICOBJECT_SPELLID(OBJECT_END + 0x0003),

    /**
     * The DYNAMICOBJECT_RADIUS Size: 1, Type: FLOAT, Flags: PUBLIC
     */
    DYNAMICOBJECT_RADIUS(OBJECT_END + 0x0004),

    /**
     * The DYNAMICOBJECT_CASTTIME Size: 1, Type: INT, Flags: PUBLIC
     */
    DYNAMICOBJECT_CASTTIME(OBJECT_END + 0x0005);

    /** The DYNAMICOBJECT_END */
    public static int DYNAMICOBJECT_END = OBJECT_END + 0x0006;

    private int value;

    DynamicObjectFields(final int value) {

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
