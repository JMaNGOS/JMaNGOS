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

import static org.jmangos.commons.network.model.UpdateFieldType.BYTES;
import static org.jmangos.commons.network.model.UpdateFieldType.FLOAT;
import static org.jmangos.commons.network.model.UpdateFieldType.INT;
import static org.jmangos.commons.network.model.UpdateFieldType.LONG;
import static org.jmangos.commons.network.model.UpdateFieldType.TWO;
import static org.jmangos.realm.model.base.update.ObjectFields.OBJECT_END;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

/**
 * The Class UnitField.
 */
public enum UnitField implements UpdateField {

    /**
     * The UNIT_FIELD_CHARM Flags: PUBLIC
     */
    UNIT_FIELD_CHARM(OBJECT_END + 0x0000, 2, LONG),

    /**
     * The UNIT_FIELD_SUMMON Flags: PUBLIC
     */
    UNIT_FIELD_SUMMON(OBJECT_END + 0x0002, 2, LONG),

    /**
     * The UNIT_FIELD_CRITTER Flags: PRIVATE
     */
    UNIT_FIELD_CRITTER(OBJECT_END + 0x0004, 2, LONG),

    /**
     * The UNIT_FIELD_CHARMEDBY Flags: PUBLIC
     */
    UNIT_FIELD_CHARMEDBY(OBJECT_END + 0x0006, 2, LONG),

    /**
     * The UNIT_FIELD_SUMMONEDBY Flags: PUBLIC
     */
    UNIT_FIELD_SUMMONEDBY(OBJECT_END + 0x0008, 2, LONG),

    /**
     * The UNIT_FIELD_CREATEDBY Flags: PUBLIC
     */
    UNIT_FIELD_CREATEDBY(OBJECT_END + 0x000A, 2, LONG),

    /**
     * The UNIT_FIELD_TARGET Flags: PUBLIC
     */
    UNIT_FIELD_TARGET(OBJECT_END + 0x000C, 2, LONG),

    /**
     * The UNIT_FIELD_CHANNEL_OBJECT Flags: PUBLIC
     */
    UNIT_FIELD_CHANNEL_OBJECT(OBJECT_END + 0x000E, 2, LONG),

    /**
     * The UNIT_CHANNEL_SPELL Flags: PUBLIC
     */
    UNIT_CHANNEL_SPELL(OBJECT_END + 0x0010, 1, INT),

    /**
     * The UNIT_FIELD_BYTES_0 Flags: PUBLIC
     */
    UNIT_FIELD_BYTES_0(OBJECT_END + 0x0011, 1, BYTES),

    /**
     * The UNIT_FIELD_HEALTH Flags: PUBLIC
     */
    UNIT_FIELD_HEALTH(OBJECT_END + 0x0012, 1, INT),

    /**
     * The UNIT_FIELD_POWER1 Flags: PUBLIC
     */
    UNIT_FIELD_POWER1(OBJECT_END + 0x0013, 1, INT),

    /**
     * The UNIT_FIELD_POWER2 Flags: PUBLIC
     */
    UNIT_FIELD_POWER2(OBJECT_END + 0x0014, 1, INT),

    /**
     * The UNIT_FIELD_POWER3 Flags: PUBLIC
     */
    UNIT_FIELD_POWER3(OBJECT_END + 0x0015, 1, INT), // ;

    /**
     * The UNIT_FIELD_POWER4 Flags: PUBLIC
     */
    UNIT_FIELD_POWER4(OBJECT_END + 0x0016, 1, INT), // ;

    /**
     * The UNIT_FIELD_POWER5 Flags: PUBLIC
     */
    UNIT_FIELD_POWER5(OBJECT_END + 0x0017, 1, INT),

    /**
     * The UNIT_FIELD_POWER6 Flags: PUBLIC
     */
    UNIT_FIELD_POWER6(OBJECT_END + 0x0018, 1, INT),

    /**
     * The UNIT_FIELD_POWER7 Flags: PUBLIC
     */
    UNIT_FIELD_POWER7(OBJECT_END + 0x0019, 1, INT),

    /**
     * The UNIT_FIELD_MAXHEALTH Flags: PUBLIC
     */
    UNIT_FIELD_MAXHEALTH(OBJECT_END + 0x001A, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER1 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER1(OBJECT_END + 0x001B, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER2 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER2(OBJECT_END + 0x001C, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER3 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER3(OBJECT_END + 0x001D, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER4 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER4(OBJECT_END + 0x001E, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER5 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER5(OBJECT_END + 0x001F, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER6 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER6(OBJECT_END + 0x0020, 1, INT),

    /**
     * The UNIT_FIELD_MAXPOWER7 Flags: PUBLIC
     */
    UNIT_FIELD_MAXPOWER7(OBJECT_END + 0x0021, 1, INT),

    /** The UNI t_ fiel d_ powe r_ rege n_ fla t_ modifier. */
    UNIT_FIELD_POWER_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0022, 7, FLOAT), // ;
                                                                         // Flags:
                                                                         // PRIVATE;
                                                                         // OWNER

    UNIT_FIELD_POWER_1_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0023, 1, FLOAT), // ;
                                                                           // Flags:
                                                                           // PRIVATE;
                                                                           // OWNER
    UNIT_FIELD_POWER_2_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0024, 1, FLOAT), // ;
                                                                           // Flags:
                                                                           // PRIVATE;
                                                                           // OWNER
    UNIT_FIELD_POWER_3_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0025, 1, FLOAT), // ;
                                                                           // Flags:
                                                                           // PRIVATE;
                                                                           // OWNER
    UNIT_FIELD_POWER_4_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0026, 1, FLOAT), // ;
                                                                           // Flags:
                                                                           // PRIVATE;
                                                                           // OWNER
    UNIT_FIELD_POWER_5_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0027, 1, FLOAT), // ;
                                                                           // Flags:
                                                                           // PRIVATE;
                                                                           // OWNER
    UNIT_FIELD_POWER_6_REGEN_FLAT_MODIFIER(OBJECT_END + 0x0028, 1, FLOAT), // ;
                                                                           // Flags:
                                                                           // PRIVATE;
                                                                           // OWNER

    /** The UNI t_ fiel d_ powe r_ rege n_ interrupte d_ fla t_ modifier. */
    UNIT_FIELD_POWER_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x0029, 7, FLOAT), // ;
                                                                                     // Flags:
                                                                                     // PRIVATE;
                                                                                     // OWNER

    UNIT_FIELD_POWER_1_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x002A, 7, FLOAT), // ;
                                                                                       // Flags:
                                                                                       // PRIVATE;
                                                                                       // OWNER
    UNIT_FIELD_POWER_2_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x002B, 7, FLOAT), // ;
                                                                                       // Flags:
                                                                                       // PRIVATE;
                                                                                       // OWNER
    UNIT_FIELD_POWER_3_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x002C, 7, FLOAT), // ;
                                                                                       // Flags:
                                                                                       // PRIVATE;
                                                                                       // OWNER
    UNIT_FIELD_POWER_4_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x002D, 7, FLOAT), // ;
                                                                                       // Flags:
                                                                                       // PRIVATE;
                                                                                       // OWNER
    UNIT_FIELD_POWER_5_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x002E, 7, FLOAT), // ;
                                                                                       // Flags:
                                                                                       // PRIVATE;
                                                                                       // OWNER
    UNIT_FIELD_POWER_6_REGEN_INTERRUPTED_FLAT_MODIFIER(OBJECT_END + 0x002F, 7, FLOAT), // ;
                                                                                       // Flags:
                                                                                       // PRIVATE;
                                                                                       // OWNER

    /** The UNI t_ fiel d_ level. */
    UNIT_FIELD_LEVEL(OBJECT_END + 0x0030, 1, INT), // ; Flags: PUBLIC

    /**
     * The UNIT_FIELD_FACTIONTEMPLATE Flags: PUBLIC
     */
    UNIT_FIELD_FACTIONTEMPLATE(OBJECT_END + 0x0031, 1, INT),

    /**
     * The UNIT_VIRTUAL_ITEM_SLOT_ID Flags: PUBLIC
     */
    UNIT_VIRTUAL_ITEM_SLOT_ID(OBJECT_END + 0x0032, 3, INT),

    /**
     * The UNIT_FIELD_FLAGS Flags: PUBLIC
     */
    UNIT_FIELD_FLAGS(OBJECT_END + 0x0035, 1, INT),

    /**
     * The UNIT_FIELD_FLAGS_2 Flags: PUBLIC
     */
    UNIT_FIELD_FLAGS_2(OBJECT_END + 0x0036, 1, INT),

    /**
     * The UNIT_FIELD_AURASTATE Flags: PUBLIC
     */
    UNIT_FIELD_AURASTATE(OBJECT_END + 0x0037, 1, INT),

    /**
     * The UNIT_FIELD_BASEATTACKTIME Flags: PUBLIC
     */
    UNIT_FIELD_BASEATTACKTIME(OBJECT_END + 0x0038, 2, INT),

    /**
     * The UNIT_FIELD_RANGEDATTACKTIME Flags: PRIVATE
     */
    UNIT_FIELD_RANGEDATTACKTIME(OBJECT_END + 0x003A, 1, INT),

    /**
     * The UNIT_FIELD_BOUNDINGRADIUS Flags: PUBLIC
     */
    UNIT_FIELD_BOUNDINGRADIUS(OBJECT_END + 0x003B, 1, FLOAT),

    /**
     * The UNIT_FIELD_COMBATREACH Flags: PUBLIC
     */
    UNIT_FIELD_COMBATREACH(OBJECT_END + 0x003C, 1, FLOAT),

    /**
     * The UNIT_FIELD_DISPLAYID Flags: PUBLIC
     */
    UNIT_FIELD_DISPLAYID(OBJECT_END + 0x003D, 1, INT),

    /**
     * The UNIT_FIELD_NATIVEDISPLAYID Flags: PUBLIC
     */
    UNIT_FIELD_NATIVEDISPLAYID(OBJECT_END + 0x003E, 1, INT),

    /**
     * The UNIT_FIELD_MOUNTDISPLAYID Flags: PUBLIC
     */
    UNIT_FIELD_MOUNTDISPLAYID(OBJECT_END + 0x003F, 1, INT),

    /**
     * The UNIT_FIELD_MINDAMAGE Flags: PRIVATE; OWNER; PARTY_LEADER
     */
    UNIT_FIELD_MINDAMAGE(OBJECT_END + 0x0040, 1, FLOAT),

    /**
     * The UNIT_FIELD_MAXDAMAGE Flags: PRIVATE; OWNER; PARTY_LEADER
     */
    UNIT_FIELD_MAXDAMAGE(OBJECT_END + 0x0041, 1, FLOAT),

    /**
     * The UNIT_FIELD_MINOFFHANDDAMAGE Flags: PRIVATE; OWNER; PARTY_LEADER
     */
    UNIT_FIELD_MINOFFHANDDAMAGE(OBJECT_END + 0x0042, 1, FLOAT),

    /**
     * The UNIT_FIELD_MAXOFFHANDDAMAGE Flags: PRIVATE; OWNER; PARTY_LEADER
     */
    UNIT_FIELD_MAXOFFHANDDAMAGE(OBJECT_END + 0x0043, 1, FLOAT),

    /**
     * The UNIT_FIELD_BYTES_1 Flags: PUBLIC
     */
    UNIT_FIELD_BYTES_1(OBJECT_END + 0x0044, 1, BYTES),

    /**
     * The UNIT_FIELD_PETNUMBER Flags: PUBLIC
     */
    UNIT_FIELD_PETNUMBER(OBJECT_END + 0x0045, 1, INT),

    /**
     * The UNIT_FIELD_PET_NAME_TIMESTAMP Flags: PUBLIC
     */
    UNIT_FIELD_PET_NAME_TIMESTAMP(OBJECT_END + 0x0046, 1, INT),

    /**
     * The UNIT_FIELD_PETEXPERIENCE Flags: OWNER
     */
    UNIT_FIELD_PETEXPERIENCE(OBJECT_END + 0x0047, 1, INT),

    /**
     * The UNIT_FIELD_PETNEXTLEVELEXP Flags: OWNER
     */
    UNIT_FIELD_PETNEXTLEVELEXP(OBJECT_END + 0x0048, 1, INT),

    /**
     * The UNIT_DYNAMIC_FLAGS Flags: DYNAMIC
     */
    UNIT_DYNAMIC_FLAGS(OBJECT_END + 0x0049, 1, INT),

    /**
     * The UNIT_MOD_CAST_SPEED Flags: PUBLIC
     */
    UNIT_MOD_CAST_SPEED(OBJECT_END + 0x004A, 1, FLOAT),

    /**
     * The UNIT_CREATED_BY_SPELL Flags: PUBLIC
     */
    UNIT_CREATED_BY_SPELL(OBJECT_END + 0x004B, 1, INT),

    /**
     * The UNIT_NPC_FLAGS Flags: DYNAMIC
     */
    UNIT_NPC_FLAGS(OBJECT_END + 0x004C, 1, INT),

    /**
     * The UNIT_NPC_EMOTESTATE Flags: PUBLIC
     */
    UNIT_NPC_EMOTESTATE(OBJECT_END + 0x004D, 1, INT),

    /**
     * The UNIT_FIELD_STAT0 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_STAT0(OBJECT_END + 0x004E, 1, INT),

    /**
     * The UNIT_FIELD_STAT1 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_STAT1(OBJECT_END + 0x004F, 1, INT),

    /**
     * The UNIT_FIELD_STAT2 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_STAT2(OBJECT_END + 0x0050, 1, INT),

    /**
     * The UNIT_FIELD_STAT3 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_STAT3(OBJECT_END + 0x0051, 1, INT),

    /**
     * The UNIT_FIELD_STAT4 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_STAT4(OBJECT_END + 0x0052, 1, INT),

    /**
     * The UNIT_FIELD_POSSTAT0 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POSSTAT0(OBJECT_END + 0x0053, 1, INT),

    /**
     * The UNIT_FIELD_POSSTAT1 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POSSTAT1(OBJECT_END + 0x0054, 1, INT),

    /**
     * The UNIT_FIELD_POSSTAT2 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POSSTAT2(OBJECT_END + 0x0055, 1, INT),

    /**
     * The UNIT_FIELD_POSSTAT3 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POSSTAT3(OBJECT_END + 0x0056, 1, INT),

    /**
     * The UNIT_FIELD_POSSTAT4 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POSSTAT4(OBJECT_END + 0x0057, 1, INT),

    /**
     * The UNIT_FIELD_NEGSTAT0 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_NEGSTAT0(OBJECT_END + 0x0058, 1, INT),

    /**
     * The UNIT_FIELD_NEGSTAT1 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_NEGSTAT1(OBJECT_END + 0x0059, 1, INT),

    /**
     * The UNIT_FIELD_NEGSTAT2 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_NEGSTAT2(OBJECT_END + 0x005A, 1, INT),

    /**
     * The UNIT_FIELD_NEGSTAT3 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_NEGSTAT3(OBJECT_END + 0x005B, 1, INT),

    /**
     * The UNIT_FIELD_NEGSTAT4 Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_NEGSTAT4(OBJECT_END + 0x005C, 1, INT),

    /**
     * The UNIT_FIELD_RESISTANCES Flags: PRIVATE; OWNER; PARTY_LEADER
     */
    UNIT_FIELD_RESISTANCES(OBJECT_END + 0x005D, 7, INT),

    /**
     * The UNIT_FIELD_RESISTANCEBUFFMODSPOSITIVE Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_RESISTANCEBUFFMODSPOSITIVE(OBJECT_END + 0x0064, 7, INT),

    /**
     * The UNIT_FIELD_RESISTANCEBUFFMODSNEGATIVE Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_RESISTANCEBUFFMODSNEGATIVE(OBJECT_END + 0x006B, 7, INT),

    /**
     * The UNIT_FIELD_BASE_MANA Flags: PUBLIC
     */
    UNIT_FIELD_BASE_MANA(OBJECT_END + 0x0072, 1, INT),

    /**
     * The UNIT_FIELD_BASE_HEALTH Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_BASE_HEALTH(OBJECT_END + 0x0073, 1, INT),

    /**
     * The UNIT_FIELD_BYTES_2 Flags: PUBLIC
     */
    UNIT_FIELD_BYTES_2(OBJECT_END + 0x0074, 1, BYTES),

    /**
     * The UNIT_FIELD_ATTACK_POWER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_ATTACK_POWER(OBJECT_END + 0x0075, 1, INT),

    /**
     * The UNIT_FIELD_ATTACK_POWER_MODS _SHORT; Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_ATTACK_POWER_MODS(OBJECT_END + 0x0076, 1, TWO),

    /**
     * The UNIT_FIELD_ATTACK_POWER_MULTIPLIER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_ATTACK_POWER_MULTIPLIER(OBJECT_END + 0x0077, 1, FLOAT),

    /**
     * The UNIT_FIELD_RANGED_ATTACK_POWER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_RANGED_ATTACK_POWER(OBJECT_END + 0x0078, 1, INT),

    /**
     * The UNIT_FIELD_RANGED_ATTACK_POWER_MODS _SHORT; Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_RANGED_ATTACK_POWER_MODS(OBJECT_END + 0x0079, 1, TWO),

    /**
     * The UNIT_FIELD_RANGED_ATTACK_POWER_MULTIPLIER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_RANGED_ATTACK_POWER_MULTIPLIER(OBJECT_END + 0x007A, 1, FLOAT),

    /**
     * The UNIT_FIELD_MINRANGEDDAMAGE Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_MINRANGEDDAMAGE(OBJECT_END + 0x007B, 1, FLOAT),

    /**
     * The UNIT_FIELD_MAXRANGEDDAMAGE Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_MAXRANGEDDAMAGE(OBJECT_END + 0x007C, 1, FLOAT),

    /**
     * The UNIT_FIELD_POWER_COST_MODIFIER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POWER_COST_MODIFIER(OBJECT_END + 0x007D, 7, INT),

    /**
     * The UNIT_FIELD_POWER_COST_MULTIPLIER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_POWER_COST_MULTIPLIER(OBJECT_END + 0x0084, 7, FLOAT),

    /**
     * The UNIT_FIELD_MAXHEALTHMODIFIER Flags: PRIVATE; OWNER
     */
    UNIT_FIELD_MAXHEALTHMODIFIER(OBJECT_END + 0x008B, 1, FLOAT),

    /**
     * The UNIT_FIELD_HOVERHEIGHT Flags: PUBLIC
     */
    UNIT_FIELD_HOVERHEIGHT(OBJECT_END + 0x008C, 1, FLOAT),

    /**
     * The UNIT_FIELD_PADDING Flags: NONE
     */
    UNIT_FIELD_PADDING(OBJECT_END + 0x008D, 1, INT);

    /**
     * The UNIT_END 0x94 - 148 dec
     */
    public static final int UNIT_END = OBJECT_END + 0x008E;

    int value;
    int size;
    UpdateFieldType type;

    UnitField(final int value, final int size, final UpdateFieldType type) {

        this.value = value;
        this.size = size;
        this.type = type;
    }

    public static UnitField get(final int value) {

        for (final UnitField val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }
        return null;
    }

    @Override
    public UpdateFieldType getType() {

        return this.type;
    }

    @Override
    public int getSize() {

        return this.size;
    }

    @Override
    public int getValue() {

        return this.value;
    }
}
