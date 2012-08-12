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

import static org.jmangos.realm.model.base.update.ItemFields.ITEM_END;

/**
 * The Class ContainerFields.
 */
public enum ContainerFields implements UpdateField {
	
	/** The CONTAINE r_ fiel d_ nu m_ slots. */
	CONTAINER_FIELD_NUM_SLOTS( ITEM_END + 0x0000 ), 		 // Size: 1, Type: INT, Flags: PUBLIC
	
	/** The CONTAINE r_ alig n_ pad. */
	CONTAINER_ALIGN_PAD( ITEM_END + 0x0001 ), 		 // Size: 1, Type: BYTES, Flags: NONE
	
	/** The CONTAINE r_ fiel d_ slo t_1. */
	CONTAINER_FIELD_SLOT_1( ITEM_END + 0x0002 ); 		 // Size: 72, Type: LONG, Flags: PUBLIC
	
	/** The CONTAINE r_ end. */
	public static int CONTAINER_END = ITEM_END + 0x004A;

    private int value;

    ContainerFields(int value) {
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
