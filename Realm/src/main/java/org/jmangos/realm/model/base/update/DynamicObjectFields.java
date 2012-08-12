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
package org.jmangos.realm.model.base.update;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

import static org.jmangos.realm.model.base.update.ObjectFields.OBJECT_END;
// TODO: Auto-generated Javadoc
/**
 * The Class DynamicObjectFields.
 */
public enum DynamicObjectFields implements UpdateField {
    
    /** The DYNAMICOBJEC t_ caster. */
    DYNAMICOBJECT_CASTER( OBJECT_END + 0x0000 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The DYNAMICOBJEC t_ bytes. */
    DYNAMICOBJECT_BYTES( OBJECT_END + 0x0002 ), 		 // Size: 1, Type: BYTES, Flags: PUBLIC
    
    /** The DYNAMICOBJEC t_ spellid. */
    DYNAMICOBJECT_SPELLID( OBJECT_END + 0x0003 ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The DYNAMICOBJEC t_ radius. */
    DYNAMICOBJECT_RADIUS( OBJECT_END + 0x0004 ), 		 // Size: 1, Type: FLOAT, Flags: PUBLIC
    
    /** The DYNAMICOBJEC t_ casttime. */
    DYNAMICOBJECT_CASTTIME( OBJECT_END + 0x0005 ); 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The DYNAMICOBJEC t_ end. */
    public static int DYNAMICOBJECT_END = OBJECT_END + 0x0006;

    private int value;

    DynamicObjectFields(int value) {
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

    public int getValue( ) {
        return this.value;
    }
}
