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

// TODO: Auto-generated Javadoc

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

/**
 * The Class ObjectFields.
 */
public enum ObjectFields implements UpdateField {
    
    /** The OBJECT_FIELD_GUID
     *  Size: 2, Type: LONG, Flags: PUBLIC
     */
    OBJECT_FIELD_GUID( 0x0000 ),
    
    /** The OBJECT_FIELD_TYPE
     *  Size: 1, Type: INT, Flags: PUBLIC
     */
    OBJECT_FIELD_TYPE( 0x0002 ),
    
    /** The OBJECT_FIELD_ENTRY
     *  Size: 1, Type: INT, Flags: PUBLIC
     */
    OBJECT_FIELD_ENTRY( 0x0003 ),
    
    /** The OBJECT_FIELD_SCALE_X
     *  Size: 1, Type: FLOAT, Flags: PUBLIC
     */
    OBJECT_FIELD_SCALE_X( 0x0004 ),
    
    /** The OBJECT_FIELD_PADDING
     *  Size: 1, Type: INT, Flags: NONE
     */
    OBJECT_FIELD_PADDING( 0x0005 );
    
    /** The OBJECT_END */
    public static int OBJECT_END           = 0x0006;

    int value;
    private ObjectFields( int value ) {
        this.value = value;
    }


    @Override
    public UpdateFieldType getType() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public static UpdateField get( int value ) {
        for( UpdateField field : values() )
            if (field.getValue() == value)
                return field;

        return null;
    }
}
