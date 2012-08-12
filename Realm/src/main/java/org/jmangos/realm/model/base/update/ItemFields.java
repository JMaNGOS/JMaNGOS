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

/**
 * The Class ItemFields.
 */
public enum ItemFields implements UpdateField {
    
    /** The ITE m_ fiel d_ owner. */
    ITEM_FIELD_OWNER( OBJECT_END + 0x0000 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ contained. */
    ITEM_FIELD_CONTAINED( OBJECT_END + 0x0002 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ creator. */
    ITEM_FIELD_CREATOR( OBJECT_END + 0x0004 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ giftcreator. */
    ITEM_FIELD_GIFTCREATOR( OBJECT_END + 0x0006 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ stac k_ count. */
    ITEM_FIELD_STACK_COUNT( OBJECT_END + 0x0008 ), 		 // Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
    
    /** The ITE m_ fiel d_ duration. */
    ITEM_FIELD_DURATION( OBJECT_END + 0x0009 ), 		 // Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
    
    /** The ITE m_ fiel d_ spel l_ charges. */
    ITEM_FIELD_SPELL_CHARGES( OBJECT_END + 0x000A ), 		 // Size: 5, Type: INT, Flags: OWNER, ITEM_OWNER
    
    /** The ITE m_ fiel d_ flags. */
    ITEM_FIELD_FLAGS( OBJECT_END + 0x000F ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_1_1. */
    ITEM_FIELD_ENCHANTMENT_1_1( OBJECT_END + 0x0010 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_1_3. */
    ITEM_FIELD_ENCHANTMENT_1_3( OBJECT_END + 0x0012 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_2_1. */
    ITEM_FIELD_ENCHANTMENT_2_1( OBJECT_END + 0x0013 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_2_3. */
    ITEM_FIELD_ENCHANTMENT_2_3( OBJECT_END + 0x0015 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_3_1. */
    ITEM_FIELD_ENCHANTMENT_3_1( OBJECT_END + 0x0016 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_3_3. */
    ITEM_FIELD_ENCHANTMENT_3_3( OBJECT_END + 0x0018 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_4_1. */
    ITEM_FIELD_ENCHANTMENT_4_1( OBJECT_END + 0x0019 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_4_3. */
    ITEM_FIELD_ENCHANTMENT_4_3( OBJECT_END + 0x001B ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_5_1. */
    ITEM_FIELD_ENCHANTMENT_5_1( OBJECT_END + 0x001C ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_5_3. */
    ITEM_FIELD_ENCHANTMENT_5_3( OBJECT_END + 0x001E ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_6_1. */
    ITEM_FIELD_ENCHANTMENT_6_1( OBJECT_END + 0x001F ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_6_3. */
    ITEM_FIELD_ENCHANTMENT_6_3( OBJECT_END + 0x0021 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_7_1. */
    ITEM_FIELD_ENCHANTMENT_7_1( OBJECT_END + 0x0022 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_7_3. */
    ITEM_FIELD_ENCHANTMENT_7_3( OBJECT_END + 0x0024 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_8_1. */
    ITEM_FIELD_ENCHANTMENT_8_1( OBJECT_END + 0x0025 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_8_3. */
    ITEM_FIELD_ENCHANTMENT_8_3( OBJECT_END + 0x0027 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_9_1. */
    ITEM_FIELD_ENCHANTMENT_9_1( OBJECT_END + 0x0028 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_9_3. */
    ITEM_FIELD_ENCHANTMENT_9_3( OBJECT_END + 0x002A ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_10_1. */
    ITEM_FIELD_ENCHANTMENT_10_1( OBJECT_END + 0x002B ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_10_3. */
    ITEM_FIELD_ENCHANTMENT_10_3( OBJECT_END + 0x002D ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_11_1. */
    ITEM_FIELD_ENCHANTMENT_11_1( OBJECT_END + 0x002E ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_11_3. */
    ITEM_FIELD_ENCHANTMENT_11_3( OBJECT_END + 0x0030 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_12_1. */
    ITEM_FIELD_ENCHANTMENT_12_1( OBJECT_END + 0x0031 ), 		 // Size: 2, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ enchantmen t_12_3. */
    ITEM_FIELD_ENCHANTMENT_12_3( OBJECT_END + 0x0033 ), 		 // Size: 1, Type: TWO_SHORT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ propert y_ seed. */
    ITEM_FIELD_PROPERTY_SEED( OBJECT_END + 0x0034 ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ rando m_ propertie s_ id. */
    ITEM_FIELD_RANDOM_PROPERTIES_ID( OBJECT_END + 0x0035 ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ durability. */
    ITEM_FIELD_DURABILITY( OBJECT_END + 0x0036 ), 		 // Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
    
    /** The ITE m_ fiel d_ maxdurability. */
    ITEM_FIELD_MAXDURABILITY( OBJECT_END + 0x0037 ), 		 // Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
    
    /** The ITE m_ fiel d_ creat e_ playe d_ time. */
    ITEM_FIELD_CREATE_PLAYED_TIME( OBJECT_END + 0x0038 ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The ITE m_ fiel d_ pad. */
    ITEM_FIELD_PAD( OBJECT_END + 0x0039 ); 		 // Size: 1, Type: INT, Flags: NONE
    
    /** The ITE m_ end. */
    public static int ITEM_END = OBJECT_END + 0x003A;

    private int value;

    ItemFields(int value) {
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

