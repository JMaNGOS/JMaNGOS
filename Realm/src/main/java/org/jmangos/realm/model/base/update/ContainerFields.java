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

import static org.jmangos.realm.model.base.update.ItemFields.ITEM_END;

/**
 * The Class ContainerFields.
 */
public enum ContainerFields implements UpdateField {
	
	/** The CONTAINER_FIELD_NUM_SLOTS
     *  Size: 1, Type: INT, Flags: PUBLIC
     */
	CONTAINER_FIELD_NUM_SLOTS( ITEM_END + 0x0000 ),
	
	/** The CONTAINER_ALIGN_PAD
     *  Size: 1, Type: BYTES, Flags: NONE
     */
	CONTAINER_ALIGN_PAD( ITEM_END + 0x0001 ),
	
	/** The CONTAINER_FIELD_SLOT_1
     *  Size: 72, Type: LONG, Flags: PUBLIC
     */
	CONTAINER_FIELD_SLOT_1( ITEM_END + 0x0002 );
	
	/** The CONTAINER_END */
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
