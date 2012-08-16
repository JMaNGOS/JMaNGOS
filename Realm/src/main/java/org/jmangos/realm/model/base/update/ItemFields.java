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

import static org.jmangos.realm.model.base.update.ObjectFields.OBJECT_END;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

/**
 * The Class ItemFields.
 */
public enum ItemFields implements UpdateField {
    
    /**
     * The ITEM_FIELD_OWNER Size: 2, Type: LONG, Flags: PUBLIC
     */
    ITEM_FIELD_OWNER(OBJECT_END + 0x0000),
    
    /**
     * The ITEM_FIELD_CONTAINED Size: 2, Type: LONG, Flags: PUBLIC
     */
    ITEM_FIELD_CONTAINED(OBJECT_END + 0x0002),
    
    /**
     * The ITEM_FIELD_CREATOR Size: 2, Type: LONG, Flags: PUBLIC
     */
    ITEM_FIELD_CREATOR(OBJECT_END + 0x0004),
    
    /**
     * The ITEM_FIELD_GIFTCREATOR Size: 2, Type: LONG, Flags: PUBLIC
     */
    ITEM_FIELD_GIFTCREATOR(OBJECT_END + 0x0006),
    
    /**
     * The ITEM_FIELD_STACK_COUNT Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
     */
    ITEM_FIELD_STACK_COUNT(OBJECT_END + 0x0008),
    
    /**
     * The ITEM_FIELD_DURATION Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
     */
    ITEM_FIELD_DURATION(OBJECT_END + 0x0009),
    
    /**
     * The ITEM_FIELD_SPELL_CHARGES Size: 5, Type: INT, Flags: OWNER, ITEM_OWNER
     */
    ITEM_FIELD_SPELL_CHARGES(OBJECT_END + 0x000A),
    
    /**
     * The ITEM_FIELD_FLAGS Size: 1, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_FLAGS(OBJECT_END + 0x000F),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_1_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_1_1(OBJECT_END + 0x0010),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_1_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_1_3(OBJECT_END + 0x0012),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_2_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_2_1(OBJECT_END + 0x0013),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_2_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_2_3(OBJECT_END + 0x0015),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_3_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_3_1(OBJECT_END + 0x0016),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_3_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_3_3(OBJECT_END + 0x0018),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_4_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_4_1(OBJECT_END + 0x0019),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_4_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_4_3(OBJECT_END + 0x001B),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_5_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_5_1(OBJECT_END + 0x001C),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_5_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_5_3(OBJECT_END + 0x001E),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_6_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_6_1(OBJECT_END + 0x001F),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_6_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_6_3(OBJECT_END + 0x0021),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_7_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_7_1(OBJECT_END + 0x0022),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_7_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_7_3(OBJECT_END + 0x0024),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_8_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_8_1(OBJECT_END + 0x0025),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_8_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_8_3(OBJECT_END + 0x0027),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_9_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_9_1(OBJECT_END + 0x0028),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_9_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_9_3(OBJECT_END + 0x002A),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_10_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_10_1(OBJECT_END + 0x002B),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_10_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_10_3(OBJECT_END + 0x002D),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_11_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_11_1(OBJECT_END + 0x002E),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_11_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_11_3(OBJECT_END + 0x0030),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_12_1 Size: 2, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_12_1(OBJECT_END + 0x0031),
    
    /**
     * The ITEM_FIELD_ENCHANTMENT_12_3 Size: 1, Type: TWO_SHORT, Flags: PUBLIC
     */
    ITEM_FIELD_ENCHANTMENT_12_3(OBJECT_END + 0x0033),
    
    /**
     * The ITEM_FIELD_PROPERTY_SEED Size: 1, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_PROPERTY_SEED(OBJECT_END + 0x0034),
    
    /**
     * The ITEM_FIELD_RANDOM_PROPERTIES_ID Size: 1, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_RANDOM_PROPERTIES_ID(OBJECT_END + 0x0035),
    
    /**
     * The ITEM_FIELD_DURABILITY Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
     */
    ITEM_FIELD_DURABILITY(OBJECT_END + 0x0036),
    
    /**
     * The ITEM_FIELD_MAXDURABILITY Size: 1, Type: INT, Flags: OWNER, ITEM_OWNER
     */
    ITEM_FIELD_MAXDURABILITY(OBJECT_END + 0x0037),
    
    /**
     * The ITEM_FIELD_CREATED_PLAYED_TIME Size: 1, Type: INT, Flags: PUBLIC
     */
    ITEM_FIELD_CREATE_PLAYED_TIME(OBJECT_END + 0x0038),
    
    /**
     * The ITEM_FIELD_PAD Size: 1, Type: INT, Flags: NONE
     */
    ITEM_FIELD_PAD(OBJECT_END + 0x0039);
    
    /** The ITEM end. */
    public static int ITEM_END = OBJECT_END + 0x003A;
    
    private int       value;
    
    ItemFields(final int value) {
    
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
