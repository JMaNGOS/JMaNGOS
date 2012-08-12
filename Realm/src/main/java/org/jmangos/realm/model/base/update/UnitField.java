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
import static org.jmangos.realm.model.base.update.UpdateFieldType.*;

/**
 * The Class UnitField.
 */
public enum UnitField implements UpdateField {
    
    /** The UNI t_ fiel d_ charm. */
    UNIT_FIELD_CHARM( OBJECT_END + 0x0000, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ summon. */
    UNIT_FIELD_SUMMON( OBJECT_END + 0x0002, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ critter. */
    UNIT_FIELD_CRITTER( OBJECT_END + 0x0004, 2, LONG ), //; Flags: PRIVATE
    
    /** The UNI t_ fiel d_ charmedby. */
    UNIT_FIELD_CHARMEDBY( OBJECT_END + 0x0006, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ summonedby. */
    UNIT_FIELD_SUMMONEDBY( OBJECT_END + 0x0008, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ createdby. */
    UNIT_FIELD_CREATEDBY( OBJECT_END + 0x000A, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ target. */
    UNIT_FIELD_TARGET( OBJECT_END + 0x000C, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ channe l_ object. */
    UNIT_FIELD_CHANNEL_OBJECT( OBJECT_END + 0x000E, 2, LONG ), //; Flags: PUBLIC
    
    /** The UNI t_ channe l_ spell. */
    UNIT_CHANNEL_SPELL( OBJECT_END + 0x0010, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ byte s_0. */
    UNIT_FIELD_BYTES_0( OBJECT_END + 0x0011, 1, BYTES ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ health. */
    UNIT_FIELD_HEALTH( OBJECT_END + 0x0012, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r1. */
    UNIT_FIELD_POWER1( OBJECT_END + 0x0013, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r2. */
    UNIT_FIELD_POWER2( OBJECT_END + 0x0014, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r3. */
    UNIT_FIELD_POWER3( OBJECT_END + 0x0015, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r4. */
    UNIT_FIELD_POWER4( OBJECT_END + 0x0016, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r5. */
    UNIT_FIELD_POWER5( OBJECT_END + 0x0017, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r6. */
    UNIT_FIELD_POWER6( OBJECT_END + 0x0018, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r7. */
    UNIT_FIELD_POWER7( OBJECT_END + 0x0019, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxhealth. */
    UNIT_FIELD_MAXHEALTH( OBJECT_END + 0x001A, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r1. */
    UNIT_FIELD_MAXPOWER1( OBJECT_END + 0x001B, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r2. */
    UNIT_FIELD_MAXPOWER2( OBJECT_END + 0x001C, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r3. */
    UNIT_FIELD_MAXPOWER3( OBJECT_END + 0x001D, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r4. */
    UNIT_FIELD_MAXPOWER4( OBJECT_END + 0x001E, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r5. */
    UNIT_FIELD_MAXPOWER5( OBJECT_END + 0x001F, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r6. */
    UNIT_FIELD_MAXPOWER6( OBJECT_END + 0x0020, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ maxpowe r7. */
    UNIT_FIELD_MAXPOWER7( OBJECT_END + 0x0021, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ powe r_ rege n_ fla t_ modifier. */
    UNIT_FIELD_POWER_REGEN_FLAT_MODIFIER( OBJECT_END + 0x0022, 7, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ powe r_ rege n_ interrupte d_ fla t_ modifier. */
    UNIT_FIELD_POWER_REGEN_INTERRUPTED_FLAT_MODIFIER( OBJECT_END + 0x0029, 7, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ level. */
    UNIT_FIELD_LEVEL( OBJECT_END + 0x0030, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ factiontemplate. */
    UNIT_FIELD_FACTIONTEMPLATE( OBJECT_END + 0x0031, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ virtua l_ ite m_ slo t_ id. */
    UNIT_VIRTUAL_ITEM_SLOT_ID( OBJECT_END + 0x0032, 3, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ flags. */
    UNIT_FIELD_FLAGS( OBJECT_END + 0x0035, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ flag s_2. */
    UNIT_FIELD_FLAGS_2( OBJECT_END + 0x0036, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ aurastate. */
    UNIT_FIELD_AURASTATE( OBJECT_END + 0x0037, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ baseattacktime. */
    UNIT_FIELD_BASEATTACKTIME( OBJECT_END + 0x0038, 2, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ rangedattacktime. */
    UNIT_FIELD_RANGEDATTACKTIME( OBJECT_END + 0x003A, 1, INT ), //; Flags: PRIVATE
    
    /** The UNI t_ fiel d_ boundingradius. */
    UNIT_FIELD_BOUNDINGRADIUS( OBJECT_END + 0x003B, 1, FLOAT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ combatreach. */
    UNIT_FIELD_COMBATREACH( OBJECT_END + 0x003C, 1, FLOAT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ displayid. */
    UNIT_FIELD_DISPLAYID( OBJECT_END + 0x003D, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ nativedisplayid. */
    UNIT_FIELD_NATIVEDISPLAYID( OBJECT_END + 0x003E, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ mountdisplayid. */
    UNIT_FIELD_MOUNTDISPLAYID( OBJECT_END + 0x003F, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ mindamage. */
    UNIT_FIELD_MINDAMAGE( OBJECT_END + 0x0040, 1, FLOAT ), //; Flags: PRIVATE; OWNER; PARTY_LEADER
    
    /** The UNI t_ fiel d_ maxdamage. */
    UNIT_FIELD_MAXDAMAGE( OBJECT_END + 0x0041, 1, FLOAT ), //; Flags: PRIVATE; OWNER; PARTY_LEADER
    
    /** The UNI t_ fiel d_ minoffhanddamage. */
    UNIT_FIELD_MINOFFHANDDAMAGE( OBJECT_END + 0x0042, 1, FLOAT ), //; Flags: PRIVATE; OWNER; PARTY_LEADER
    
    /** The UNI t_ fiel d_ maxoffhanddamage. */
    UNIT_FIELD_MAXOFFHANDDAMAGE( OBJECT_END + 0x0043, 1, FLOAT ), //; Flags: PRIVATE; OWNER; PARTY_LEADER
    
    /** The UNI t_ fiel d_ byte s_1. */
    UNIT_FIELD_BYTES_1( OBJECT_END + 0x0044, 1, BYTES ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ petnumber. */
    UNIT_FIELD_PETNUMBER( OBJECT_END + 0x0045, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ pe t_ nam e_ timestamp. */
    UNIT_FIELD_PET_NAME_TIMESTAMP( OBJECT_END + 0x0046, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ petexperience. */
    UNIT_FIELD_PETEXPERIENCE( OBJECT_END + 0x0047, 1, INT ), //; Flags: OWNER
    
    /** The UNI t_ fiel d_ petnextlevelexp. */
    UNIT_FIELD_PETNEXTLEVELEXP( OBJECT_END + 0x0048, 1, INT ), //; Flags: OWNER
    
    /** The UNI t_ dynami c_ flags. */
    UNIT_DYNAMIC_FLAGS( OBJECT_END + 0x0049, 1, INT ), //; Flags: DYNAMIC
    
    /** The UNI t_ mo d_ cas t_ speed. */
    UNIT_MOD_CAST_SPEED( OBJECT_END + 0x004A, 1, FLOAT ), //; Flags: PUBLIC
    
    /** The UNI t_ create d_ b y_ spell. */
    UNIT_CREATED_BY_SPELL( OBJECT_END + 0x004B, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ np c_ flags. */
    UNIT_NPC_FLAGS( OBJECT_END + 0x004C, 1, INT ), //; Flags: DYNAMIC
    
    /** The UNI t_ np c_ emotestate. */
    UNIT_NPC_EMOTESTATE( OBJECT_END + 0x004D, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ sta t0. */
    UNIT_FIELD_STAT0( OBJECT_END + 0x004E, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ sta t1. */
    UNIT_FIELD_STAT1( OBJECT_END + 0x004F, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ sta t2. */
    UNIT_FIELD_STAT2( OBJECT_END + 0x0050, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ sta t3. */
    UNIT_FIELD_STAT3( OBJECT_END + 0x0051, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ sta t4. */
    UNIT_FIELD_STAT4( OBJECT_END + 0x0052, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ possta t0. */
    UNIT_FIELD_POSSTAT0( OBJECT_END + 0x0053, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ possta t1. */
    UNIT_FIELD_POSSTAT1( OBJECT_END + 0x0054, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ possta t2. */
    UNIT_FIELD_POSSTAT2( OBJECT_END + 0x0055, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ possta t3. */
    UNIT_FIELD_POSSTAT3( OBJECT_END + 0x0056, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ possta t4. */
    UNIT_FIELD_POSSTAT4( OBJECT_END + 0x0057, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ negsta t0. */
    UNIT_FIELD_NEGSTAT0( OBJECT_END + 0x0058, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ negsta t1. */
    UNIT_FIELD_NEGSTAT1( OBJECT_END + 0x0059, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ negsta t2. */
    UNIT_FIELD_NEGSTAT2( OBJECT_END + 0x005A, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ negsta t3. */
    UNIT_FIELD_NEGSTAT3( OBJECT_END + 0x005B, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ negsta t4. */
    UNIT_FIELD_NEGSTAT4( OBJECT_END + 0x005C, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ resistances. */
    UNIT_FIELD_RESISTANCES( OBJECT_END + 0x005D, 7, INT ), //; Flags: PRIVATE; OWNER; PARTY_LEADER
    
    /** The UNI t_ fiel d_ resistancebuffmodspositive. */
    UNIT_FIELD_RESISTANCEBUFFMODSPOSITIVE( OBJECT_END + 0x0064, 7, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ resistancebuffmodsnegative. */
    UNIT_FIELD_RESISTANCEBUFFMODSNEGATIVE( OBJECT_END + 0x006B, 7, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ bas e_ mana. */
    UNIT_FIELD_BASE_MANA( OBJECT_END + 0x0072, 1, INT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ bas e_ health. */
    UNIT_FIELD_BASE_HEALTH( OBJECT_END + 0x0073, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ byte s_2. */
    UNIT_FIELD_BYTES_2( OBJECT_END + 0x0074, 1, BYTES ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ attac k_ power. */
    UNIT_FIELD_ATTACK_POWER( OBJECT_END + 0x0075, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ attac k_ powe r_ mods. */
    UNIT_FIELD_ATTACK_POWER_MODS( OBJECT_END + 0x0076, 1, TWO ), //_SHORT; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ attac k_ powe r_ multiplier. */
    UNIT_FIELD_ATTACK_POWER_MULTIPLIER( OBJECT_END + 0x0077, 1, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ range d_ attac k_ power. */
    UNIT_FIELD_RANGED_ATTACK_POWER( OBJECT_END + 0x0078, 1, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ range d_ attac k_ powe r_ mods. */
    UNIT_FIELD_RANGED_ATTACK_POWER_MODS( OBJECT_END + 0x0079, 1, TWO ), //_SHORT; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ range d_ attac k_ powe r_ multiplier. */
    UNIT_FIELD_RANGED_ATTACK_POWER_MULTIPLIER( OBJECT_END + 0x007A, 1, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ minrangeddamage. */
    UNIT_FIELD_MINRANGEDDAMAGE( OBJECT_END + 0x007B, 1, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ maxrangeddamage. */
    UNIT_FIELD_MAXRANGEDDAMAGE( OBJECT_END + 0x007C, 1, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ powe r_ cos t_ modifier. */
    UNIT_FIELD_POWER_COST_MODIFIER( OBJECT_END + 0x007D, 7, INT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ powe r_ cos t_ multiplier. */
    UNIT_FIELD_POWER_COST_MULTIPLIER( OBJECT_END + 0x0084, 7, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ maxhealthmodifier. */
    UNIT_FIELD_MAXHEALTHMODIFIER( OBJECT_END + 0x008B, 1, FLOAT ), //; Flags: PRIVATE; OWNER
    
    /** The UNI t_ fiel d_ hoverheight. */
    UNIT_FIELD_HOVERHEIGHT( OBJECT_END + 0x008C, 1, FLOAT ), //; Flags: PUBLIC
    
    /** The UNI t_ fiel d_ padding. */
    UNIT_FIELD_PADDING( OBJECT_END + 0x008D, 1, INT ); //; Flags: NONE
    
    /** The UNI t_ end. */
    public static int UNIT_END = OBJECT_END + 0x008E;

    int value;
    int size;
    UpdateFieldType type;
    UnitField(int value, int size, UpdateFieldType type) {
        this.value = value;
        this.size = size;
        this.type = type;
    }

    public static UnitField get( int value ) {
        for( UnitField val : values() ){
            if ( val.getValue() == value )
                return val;
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
