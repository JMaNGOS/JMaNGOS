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
/**
 * The Class ObjectFields.
 */
public enum ObjectFields implements UpdateField {
    
    /** The OBJEC t_ fiel d_ guid. */
    OBJECT_FIELD_GUID( 0x0000 ), // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The OBJEC t_ fiel d_ type. */
    OBJECT_FIELD_TYPE( 0x0002 ), // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The OBJEC t_ fiel d_ entry. */
    OBJECT_FIELD_ENTRY( 0x0003 ), // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The OBJEC t_ fiel d_ scal e_ x. */
    OBJECT_FIELD_SCALE_X( 0x0004 ), // Size: 1, Type: FLOAT, Flags: PUBLIC
    
    /** The OBJEC t_ fiel d_ padding. */
    OBJECT_FIELD_PADDING( 0x0005 ); // Size: 1, Type: INT, Flags: NONE
    
    /** The OBJEC t_ end. */
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
}
