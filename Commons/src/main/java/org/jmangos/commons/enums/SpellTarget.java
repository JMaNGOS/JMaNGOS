package org.jmangos.commons.enums;

public enum SpellTarget {
    NONE,
    SELF,
    RANDOM_ENEMY_CHAIN_IN_AREA,                // only one spell has that, but
    // regardless, it's a target type after
    // all
    RANDOM_FRIEND_CHAIN_IN_AREA,
    TARGET_4,
    PET,
    CHAIN_DAMAGE,
    AREAEFFECT_INSTANT,                // targets around provided destination point
    AREAEFFECT_CUSTOM,
    INNKEEPER_COORDINATES,                // uses in teleport to innkeeper spells
    TARGET_10,
    TARGET_11,
    TARGET_12,
    TARGET_13,
    TARGET_14,
    ALL_ENEMY_IN_AREA,
    ALL_ENEMY_IN_AREA_INSTANT,
    TABLE_X_Y_Z_COORDINATES,                // uses in teleport spells and some other
    EFFECT_SELECT,                // highly depends on the spell effect
    TARGET_19,
    ALL_PARTY_AROUND_CASTER,
    SINGLE_FRIEND,
    CASTER_COORDINATES,                // used only in TargetA, target selection
    // dependent from TargetB
    GAMEOBJECT,
    IN_FRONT_OF_CASTER,
    DUELVSPLAYER,
    GAMEOBJECT_ITEM,
    MASTER,
    ALL_ENEMY_IN_AREA_CHANNELED,
    TARGET_29,
    ALL_FRIENDLY_UNITS_AROUND_CASTER,                // select friendly for caster
    // object faction (in different
    // original caster faction) in
    // TargetB used only with
    // TARGET_ALL_AROUND_CASTER and in
    // self casting range in TargetA
    ALL_FRIENDLY_UNITS_IN_AREA,
    MINION,
    ALL_PARTY,
    ALL_PARTY_AROUND_CASTER_2,                // used in Tranquility
    SINGLE_PARTY,
    ALL_HOSTILE_UNITS_AROUND_CASTER,
    AREAEFFECT_PARTY,
    SCRIPT,
    SELF_FISHING,
    FOCUS_OR_SCRIPTED_GAMEOBJECT,
    TOTEM_EARTH,
    TOTEM_WATER,
    TOTEM_AIR,
    TOTEM_FIRE,
    CHAIN_HEAL,
    SCRIPT_COORDINATES,
    DYNAMIC_OBJECT_FRONT,
    DYNAMIC_OBJECT_BEHIND,
    DYNAMIC_OBJECT_LEFT_SIDE,
    DYNAMIC_OBJECT_RIGHT_SIDE,
    AREAEFFECT_GO_AROUND_SOURCE,
    AREAEFFECT_GO_AROUND_DEST,                // gameobject around destination, select
    // by spell_script_target
    CURRENT_ENEMY_COORDINATES,                // set unit coordinates as dest, only 16
    // target B imlemented
    LARGE_FRONTAL_CONE,
    LEAP_FORWARD,                // Target point must be calculated in target selection
    ALL_RAID_AROUND_CASTER,
    SINGLE_FRIEND_2,
    TARGET_58,
    TARGET_59,
    NARROW_FRONTAL_CONE,
    AREAEFFECT_PARTY_AND_CLASS,
    TARGET_62,
    DUELVSPLAYER_COORDINATES,
    INFRONT_OF_VICTIM,
    BEHIND_VICTIM,                // used in teleport behind spells, caster/target
    // dependent from spell effect
    RIGHT_FROM_VICTIM,
    LEFT_FROM_VICTIM,
    TARGET_68,
    TARGET_69,
    TARGET_70,
    TARGET_71,
    RANDOM_NEARBY_LOC,                // used in teleport onto nearby locations
    RANDOM_CIRCUMFERENCE_POINT,
    RANDOM_POINT_NEAR_TARGET,                // Target point must be calculated in
    // target selection
    RANDOM_POINT_NEAR_TARGET_2,                // Target point must be calculated in
    // target selection
    DYNAMIC_OBJECT_COORDINATES,
    SINGLE_ENEMY,
    POINT_AT_NORTH,                // 78-85 possible _COORDINATES at radius with pi/4
    // step around target in unknown order, N?
    POINT_AT_SOUTH,                // S?
    POINT_AT_EAST,                // 80/81 must be symmetric from line caster->target, E
    // (base at 82/83, 84/85 order) ?
    POINT_AT_WEST,                // 80/81 must be symmetric from line caster->target, W
    // (base at 82/83, 84/85 order) ?
    POINT_AT_NE,                // from spell desc: "(NE)"
    POINT_AT_NW,                // from spell desc: "(NW)"
    POINT_AT_SE,                // from spell desc: "(SE)"
    POINT_AT_SW,                // from spell desc: "(SW)"
    RANDOM_NEARBY_DEST,                // "Test Nearby Dest Random" - random around
    // selected destination
    SELF2,
    TARGET_88,
    DIRECTLY_FORWARD,
    NONCOMBAT_PET,
    DEST_RADIUS,
    UNIT_CREATOR,
    TARGET_93,
    OWNED_VEHICLE,
    UNIT_DRIVER,
    UNIT_PASSENGER_0,
    UNIT_PASSENGER_1,
    UNIT_PASSENGER_2,
    UNIT_PASSENGER_3,
    UNIT_PASSENGER_4,
    UNIT_PASSENGER_5,
    UNIT_PASSENGER_6,
    UNIT_PASSENGER_7,
    IN_FRONT_OF_CASTER_30,
    TARGET_105,
    TARGET_106,
    TARGET_107,
    GO_IN_FRONT_OF_CASTER_90,
    TARGET_109,
    TARGET_110;

    public static final SpellTarget get(final int value) {
        if (value >= 0 & value < 111) {
            return values()[value];
        }
        return null;

    }

}
