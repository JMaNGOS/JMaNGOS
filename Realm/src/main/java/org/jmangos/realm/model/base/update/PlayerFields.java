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

/**
 * The PlayerFields.
 */

import static org.jmangos.realm.model.base.update.UnitField.UNIT_END;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

public enum PlayerFields implements UpdateField {
    /**
     * The PLAYER_DUEL_ARBITER Size: 2; Type: LONG; Flags: PUBLIC
     */
    PLAYER_DUEL_ARBITER(UNIT_END + 0x0000),

    /**
     * The PLAYER_FLAGS Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_FLAGS(UNIT_END + 0x0002),

    /**
     * The PLAYER_GUILDID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_GUILDID(UNIT_END + 0x0003),

    /**
     * The PLAYER_GUILDRANK Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_GUILDRANK(UNIT_END + 0x0004),

    /**
     * The PLAYER_BYTES Size: 1; Type: BYTES; Flags: PUBLIC
     */
    PLAYER_BYTES(UNIT_END + 0x0005),

    /**
     * The PLAYER_BYTES_2 Size: 1; Type: BYTES; Flags: PUBLIC
     */
    PLAYER_BYTES_2(UNIT_END + 0x0006),

    /**
     * The PLAYER_BYTES_3 Size: 1; Type: BYTES; Flags: PUBLIC
     */
    PLAYER_BYTES_3(UNIT_END + 0x0007),

    /**
     * The PLAYER_DUEL_TEAM Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_DUEL_TEAM(UNIT_END + 0x0008),

    /**
     * The PLAYER_GUILD_TIMESTAMP Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_GUILD_TIMESTAMP(UNIT_END + 0x0009),

    /**
     * The PLAYER_QUEST_LOG_1_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_1_1(UNIT_END + 0x000A),

    /**
     * The PLAYER_QUEST_LOG_1_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_1_2(UNIT_END + 0x000B),

    /**
     * The PLAYER_QUEST_LOG_1_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_1_3(UNIT_END + 0x000C),

    /**
     * The PLAYER_QUEST_LOG_1_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_1_4(UNIT_END + 0x000D),

    /**
     * The PLAYER_QUEST_LOG_1_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_1_5(UNIT_END + 0x000E),

    /**
     * The PLAYER_QUEST_LOG_2_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_2_1(UNIT_END + 0x000F),

    /**
     * The PLAYER_QUEST_LOG_2_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_2_2(UNIT_END + 0x0010),

    /**
     * The PLAYER_QUEST_LOG_2_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_2_3(UNIT_END + 0x0011),

    /**
     * The PLAYER_QUEST_LOG_2_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_2_4(UNIT_END + 0x0012),

    /**
     * The PLAYER_QUEST_LOG_2_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_2_5(UNIT_END + 0x0013),

    /**
     * The PLAYER_QUEST_LOG_3_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_3_1(UNIT_END + 0x0014),

    /**
     * The PLAYER_QUEST_LOG_3_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_3_2(UNIT_END + 0x0015),

    /**
     * The PLAYER_QUEST_LOG_3_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_3_3(UNIT_END + 0x0016),

    PLAYER_QUEST_LOG_3_4(UNIT_END + 0x0017), // Size: 2; Type: TWO_SHORT; Flags:
                                             // PRIVATE
    /**
     * The PLAYER_QUEST_LOG_3_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_3_5(UNIT_END + 0x0018),

    /**
     * The PLAYER_QUEST_LOG_4_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_4_1(UNIT_END + 0x0019),

    /**
     * The PLAYER_QUEST_LOG_4_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_4_2(UNIT_END + 0x001A),

    /**
     * The PLAYER_QUEST_LOG_4_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_4_3(UNIT_END + 0x001B),

    PLAYER_QUEST_LOG_4_4(UNIT_END + 0x001C), // Size: 2; Type: TWO_SHORT; Flags:
                                             // PRIVATE
    /**
     * The PLAYER_QUEST_LOG_4_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_4_5(UNIT_END + 0x001D),

    /**
     * The PLAYER_QUEST_LOG_5_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_5_1(UNIT_END + 0x001E),

    /**
     * The PLAYER_QUEST_LOG_5_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_5_2(UNIT_END + 0x001F),

    /**
     * The PLAYER_QUEST_LOG_5_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_5_3(UNIT_END + 0x0020),

    PLAYER_QUEST_LOG_5_4(UNIT_END + 0x0021), // Size: 2; Type: TWO_SHORT; Flags:
                                             // PRIVATE
    /**
     * The PLAYER_QUEST_LOG_5_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_5_5(UNIT_END + 0x0022),

    /**
     * The PLAYER_QUEST_LOG_6_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_6_1(UNIT_END + 0x0023),

    /**
     * The PLAYER_QUEST_LOG_6_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_6_2(UNIT_END + 0x0024),

    /**
     * The PLAYER_QUEST_LOG_6_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_6_3(UNIT_END + 0x0025),

    /**
     * The PLAYER_QUEST_LOG_6_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_6_4(UNIT_END + 0x0026),
    /**
     * The PLAYER_QUEST_LOG_6_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_6_5(UNIT_END + 0x0027),

    /**
     * The PLAYER_QUEST_LOG_7_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_7_1(UNIT_END + 0x0028),

    /**
     * The PLAYER_QUEST_LOG_7_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_7_2(UNIT_END + 0x0029),

    /**
     * The PLAYER_QUEST_LOG_7_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_7_3(UNIT_END + 0x002A),

    /**
     * The PLAYER_QUEST_LOG_7_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_7_4(UNIT_END + 0x002B),

    /**
     * The PLAYER_QUEST_LOG_7_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_7_5(UNIT_END + 0x002C),

    /**
     * The PLAYER_QUEST_LOG_8_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_8_1(UNIT_END + 0x002D),

    /**
     * The PLAYER_QUEST_LOG_8_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_8_2(UNIT_END + 0x002E),

    /**
     * The PLAYER_QUEST_LOG_8_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_8_3(UNIT_END + 0x002F),

    /**
     * The PLAYER_QUEST_LOG_8_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_8_5(UNIT_END + 0x0031),

    /**
     * The PLAYER_QUEST_LOG_9_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_9_1(UNIT_END + 0x0032),

    /**
     * The PLAYER_QUEST_LOG_9_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_9_2(UNIT_END + 0x0033),

    /**
     * The PLAYER_QUEST_LOG_9_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_9_3(UNIT_END + 0x0034),

    /**
     * The PLAYER_QUEST_LOG_9_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_9_4(UNIT_END + 0x0035),

    /**
     * The PLAYER_QUEST_LOG_9_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_9_5(UNIT_END + 0x0036),

    /**
     * The PLAYER_QUEST_LOG_10_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_10_1(UNIT_END + 0x0037),

    /**
     * The PLAYER_QUEST_LOG_10_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_10_2(UNIT_END + 0x0038),

    /**
     * The PLAYER_QUEST_LOG_10_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_10_3(UNIT_END + 0x0039),

    /**
     * The PLAYER_QUEST_LOG_10_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_10_4(UNIT_END + 0x003A),

    /**
     * The PLAYER_QUEST_LOG_10_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_10_5(UNIT_END + 0x003B),

    /**
     * The PLAYER_QUEST_LOG_11_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_11_1(UNIT_END + 0x003C),

    /**
     * The PLAYER_QUEST_LOG_11_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_11_2(UNIT_END + 0x003D),

    /**
     * The PLAYER_QUEST_LOG_11_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_11_3(UNIT_END + 0x003E),

    /**
     * The PLAYER_QUEST_LOG_11_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_11_4(UNIT_END + 0x003F),

    /**
     * The PLAYER_QUEST_LOG_11_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_11_5(UNIT_END + 0x0040),

    /**
     * The PLAYER_QUEST_LOG_12_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_12_1(UNIT_END + 0x0041),

    /**
     * The PLAYER_QUEST_LOG_12_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_12_2(UNIT_END + 0x0042),

    /**
     * The PLAYER_QUEST_LOG_12_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_12_3(UNIT_END + 0x0043),

    /**
     * The PLAYER_QUEST_LOG_12_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_12_4(UNIT_END + 0x0044),

    /**
     * The PLAYER_QUEST_LOG_12_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_12_5(UNIT_END + 0x0045),

    /**
     * The PLAYER_QUEST_LOG_13_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_13_1(UNIT_END + 0x0046),

    /**
     * The PLAYER_QUEST_LOG_13_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_13_2(UNIT_END + 0x0047),

    /**
     * The PLAYER_QUEST_LOG_13_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_13_3(UNIT_END + 0x0048),

    /**
     * The PLAYER_QUEST_LOG_13_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_13_4(UNIT_END + 0x0049),

    /**
     * The PLAYER_QUEST_LOG_13_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_13_5(UNIT_END + 0x004A),

    /**
     * The PLAYER_QUEST_LOG_14_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_14_1(UNIT_END + 0x004B),

    /**
     * The PLAYER_QUEST_LOG_14_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_14_2(UNIT_END + 0x004C),

    /**
     * The PLAYER_QUEST_LOG_14_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_14_3(UNIT_END + 0x004D),

    /**
     * The PLAYER_QUEST_LOG_14_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_14_4(UNIT_END + 0x004E),

    /**
     * The PLAYER_QUEST_LOG_14_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_14_5(UNIT_END + 0x004F),

    /**
     * The PLAYER_QUEST_LOG_15_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_15_1(UNIT_END + 0x0050),

    /**
     * The PLAYER_QUEST_LOG_15_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_15_2(UNIT_END + 0x0051),

    /**
     * The PLAYER_QUEST_LOG_15_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_15_3(UNIT_END + 0x0052),

    /**
     * The PLAYER_QUEST_LOG_15_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_15_4(UNIT_END + 0x0053),

    /**
     * The PLAYER_QUEST_LOG_15_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_15_5(UNIT_END + 0x0054),

    /**
     * The PLAYER_QUEST_LOG_16_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_16_1(UNIT_END + 0x0055),

    /**
     * The PLAYER_QUEST_LOG_16_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_16_2(UNIT_END + 0x0056),

    /**
     * The PLAYER_QUEST_LOG_16_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_16_3(UNIT_END + 0x0057),

    /**
     * The PLAYER_QUEST_LOG_16_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_16_4(UNIT_END + 0x0058),

    /**
     * The PLAYER_QUEST_LOG_16_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_16_5(UNIT_END + 0x0059),

    /**
     * The PLAYER_QUEST_LOG_17_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_17_1(UNIT_END + 0x005A),

    /**
     * The PLAYER_QUEST_LOG_17_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_17_2(UNIT_END + 0x005B),

    /**
     * The PLAYER_QUEST_LOG_17_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_17_3(UNIT_END + 0x005C),

    /**
     * The PLAYER_QUEST_LOG_17_4 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_17_4(UNIT_END + 0x005D),

    /**
     * The PLAYER_QUEST_LOG_17_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_17_5(UNIT_END + 0x005E),

    /**
     * The PLAYER_QUEST_LOG_18_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_18_1(UNIT_END + 0x005F),

    /**
     * The PLAYER_QUEST_LOG_18_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_18_2(UNIT_END + 0x0060),

    /**
     * The PLAYER_QUEST_LOG_18_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_18_3(UNIT_END + 0x0061),

    /**
     * The PLAYER_QUEST_LOG_18_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_18_4(UNIT_END + 0x0062),

    /**
     * The PLAYER_QUEST_LOG_18_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_18_5(UNIT_END + 0x0063),

    /**
     * The PLAYER_QUEST_LOG_19_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_19_1(UNIT_END + 0x0064),

    /**
     * The PLAYER_QUEST_LOG_19_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_19_2(UNIT_END + 0x0065),

    /**
     * The PLAYER_QUEST_LOG_19_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_19_3(UNIT_END + 0x0066),

    /**
     * The PLAYER_QUEST_LOG_19_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_19_4(UNIT_END + 0x0067),
    /**
     * The PLAYER_QUEST_LOG_19_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_19_5(UNIT_END + 0x0068),

    /**
     * The PLAYER_QUEST_LOG_20_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_20_1(UNIT_END + 0x0069),

    /**
     * The PLAYER_QUEST_LOG_20_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_20_2(UNIT_END + 0x006A),

    /**
     * The PLAYER_QUEST_LOG_20_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_20_3(UNIT_END + 0x006B),

    /**
     * The PLAYER_QUEST_LOG_20_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_20_4(UNIT_END + 0x006C),

    /**
     * The PLAYER_QUEST_LOG_20_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_20_5(UNIT_END + 0x006D),

    /**
     * The PLAYER_QUEST_LOG_21_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_21_1(UNIT_END + 0x006E),

    /**
     * The PLAYER_QUEST_LOG_21_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_21_2(UNIT_END + 0x006F),

    /**
     * The PLAYER_QUEST_LOG_21_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_21_3(UNIT_END + 0x0070),

    /**
     * The PLAYER_QUEST_LOG_21_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_21_4(UNIT_END + 0x0071),

    /**
     * The PLAYER_QUEST_LOG_21_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_21_5(UNIT_END + 0x0072),

    /**
     * The PLAYER_QUEST_LOG_22_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_22_1(UNIT_END + 0x0073),

    /**
     * The PLAYER_QUEST_LOG_22_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_22_2(UNIT_END + 0x0074),

    /**
     * The PLAYER_QUEST_LOG_22_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_22_3(UNIT_END + 0x0075),

    /**
     * The PLAYER_QUEST_LOG_22_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_22_4(UNIT_END + 0x0076),

    /**
     * The PLAYER_QUEST_LOG_22_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_22_5(UNIT_END + 0x0077),

    /**
     * The PLAYER_QUEST_LOG_23_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_23_1(UNIT_END + 0x0078),

    /**
     * The PLAYER_QUEST_LOG_23_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_23_2(UNIT_END + 0x0079),

    /**
     * The PLAYER_QUEST_LOG_23_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_23_3(UNIT_END + 0x007A),

    /**
     * The PLAYER_QUEST_LOG_23_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_23_4(UNIT_END + 0x007B),

    /**
     * The PLAYER_QUEST_LOG_23_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_23_5(UNIT_END + 0x007C),

    /**
     * The PLAYER_QUEST_LOG_24_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_24_1(UNIT_END + 0x007D),

    /**
     * The PLAYER_QUEST_LOG_24_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_24_2(UNIT_END + 0x007E),

    /**
     * The PLAYER_QUEST_LOG_24_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_24_3(UNIT_END + 0x007F),

    /**
     * The PLAYER_QUEST_LOG_24_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_24_4(UNIT_END + 0x0080),

    /**
     * The PLAYER_QUEST_LOG_24_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_24_5(UNIT_END + 0x0081),

    /**
     * The PLAYER_QUEST_LOG_25_1 Size: 1; Type: INT; Flags: PARTY_MEMBER
     */
    PLAYER_QUEST_LOG_25_1(UNIT_END + 0x0082),

    /**
     * The PLAYER_QUEST_LOG_25_2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_25_2(UNIT_END + 0x0083),

    /**
     * The PLAYER_QUEST_LOG_25_3 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_25_3(UNIT_END + 0x0084),

    /**
     * The PLAYER_QUEST_LOG_25_4 Size: 2; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_25_4(UNIT_END + 0x0085),

    /**
     * The PLAYER_QUEST_LOG_25_5 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_QUEST_LOG_25_5(UNIT_END + 0x0086),

    /**
     * The PLAYER_VISIBLE_ITEM_1_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_1_ENTRYID(UNIT_END + 0x0087),

    /**
     * The PLAYER_VISIBLE_ITEM_1_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_1_ENCHANTMENT(UNIT_END + 0x0088),

    /**
     * The PLAYER_VISIBLE_ITEM_2_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_2_ENTRYID(UNIT_END + 0x009),

    /**
     * The PLAYER_VISIBLE_ITEM_2_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_2_ENCHANTMENT(UNIT_END + 0x008A),

    /**
     * The PLAYER_VISIBLE_ITEM_3_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_3_ENTRYID(UNIT_END + 0x008B),

    /**
     * The PLAYER_VISIBLE_ITEM_3_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_3_ENCHANTMENT(UNIT_END + 0x008C),

    /**
     * The PLAYER_VISIBLE_ITEM_4_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_4_ENTRYID(UNIT_END + 0x008D),

    /**
     * The PLAYER_VISIBLE_ITEM_4_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_4_ENCHANTMENT(UNIT_END + 0x008E),

    /**
     * The PLAYER_VISIBLE_ITEM_5_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_5_ENTRYID(UNIT_END + 0x008F),

    /**
     * The PLAYER_VISIBLE_ITEM_5_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_5_ENCHANTMENT(UNIT_END + 0x0090),

    /**
     * The PLAYER_VISIBLE_ITEM_6_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_6_ENTRYID(UNIT_END + 0x0091),

    /**
     * The PLAYER_VISIBLE_ITEM_6_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_6_ENCHANTMENT(UNIT_END + 0x0092),

    /**
     * The PLAYER_VISIBLE_ITEM_7_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_7_ENTRYID(UNIT_END + 0x0093),

    /**
     * The PLAYER_VISIBLE_ITEM_7_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_7_ENCHANTMENT(UNIT_END + 0x0094),

    /**
     * The PLAYER_VISIBLE_ITEM_8_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_8_ENTRYID(UNIT_END + 0x0095),

    /**
     * The PLAYER_VISIBLE_ITEM_8_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_8_ENCHANTMENT(UNIT_END + 0x0096),

    /**
     * The PLAYER_VISIBLE_ITEM_9_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_9_ENTRYID(UNIT_END + 0x0097),

    /**
     * The PLAYER_VISIBLE_ITEM_9_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_9_ENCHANTMENT(UNIT_END + 0x0098),

    /**
     * The PLAYER_VISIBLE_ITEM_10_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_10_ENTRYID(UNIT_END + 0x0099),

    /**
     * The PLAYER_VISIBLE_ITEM_10_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_10_ENCHANTMENT(UNIT_END + 0x009A),

    /**
     * The PLAYER_VISIBLE_ITEM_11_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_11_ENTRYID(UNIT_END + 0x009B),

    /**
     * The PLAYER_VISIBLE_ITEM_11_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_11_ENCHANTMENT(UNIT_END + 0x009C),

    /**
     * The PLAYER_VISIBLE_ITEM_12_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_12_ENTRYID(UNIT_END + 0x009D),

    /**
     * The PLAYER_VISIBLE_ITEM_12_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_12_ENCHANTMENT(UNIT_END + 0x009E),

    /**
     * The PLAYER_VISIBLE_ITEM_13_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_13_ENTRYID(UNIT_END + 0x009F),

    /**
     * The PLAYER_VISIBLE_ITEM_13_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_13_ENCHANTMENT(UNIT_END + 0x00A0),

    /**
     * The PLAYER_VISIBLE_ITEM_14_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_14_ENTRYID(UNIT_END + 0x00A1),

    /**
     * The PLAYER_VISIBLE_ITEM_14_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_14_ENCHANTMENT(UNIT_END + 0x00A2),

    /**
     * The PLAYER_VISIBLE_ITEM_15_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_15_ENTRYID(UNIT_END + 0x00A3),

    /**
     * The PLAYER_VISIBLE_ITEM_15_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_15_ENCHANTMENT(UNIT_END + 0x00A4),

    /**
     * The PLAYER_VISIBLE_ITEM_16_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_16_ENTRYID(UNIT_END + 0x00A5),

    /**
     * The PLAYER_VISIBLE_ITEM_16_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_16_ENCHANTMENT(UNIT_END + 0x00A6),

    /**
     * The PLAYER_VISIBLE_ITEM_17_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_17_ENTRYID(UNIT_END + 0x00A7),

    /**
     * The PLAYER_VISIBLE_ITEM_17_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_17_ENCHANTMENT(UNIT_END + 0x00A8),

    /**
     * The PLAYER_VISIBLE_ITEM_18_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_18_ENTRYID(UNIT_END + 0x00A9),

    /**
     * The PLAYER_VISIBLE_ITEM_18_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_18_ENCHANTMENT(UNIT_END + 0x00AA),

    /**
     * The PLAYER_VISIBLE_ITEM_19_ENTRYID Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_VISIBLE_ITEM_19_ENTRYID(UNIT_END + 0x00AB),

    /**
     * The PLAYER_VISIBLE_ITEM_19_ENCHANTMENT Size: 1; Type: TWO_SHORT; Flags:
     * PUBLIC
     */
    PLAYER_VISIBLE_ITEM_19_ENCHANTMENT(UNIT_END + 0x00AC),

    /**
     * The PLAYER_CHOSEN_TITLE Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_CHOSEN_TITLE(UNIT_END + 0x00AD),

    /**
     * The PLAYER_FAKE_INEBRIATION Size: 1; Type: INT; Flags: PUBLIC
     */
    PLAYER_FAKE_INEBRIATION(UNIT_END + 0x00AE),

    /**
     * The PLAYER_FIELD_PAD_0 Size: 1; Type: INT; Flags: NONE
     */
    PLAYER_FIELD_PAD_0(UNIT_END + 0x00AF),

    /**
     * The PLAYER_FIELD_INV_SLOT_HEAD Size: 46; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FIELD_INV_SLOT_HEAD(UNIT_END + 0x00B0),

    /**
     * The PLAYER_FIELD_PACK_SLOT_1 Size: 32; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FIELD_PACK_SLOT_1(UNIT_END + 0x00DE),

    /**
     * The PLAYER_FIELD_BANK_SLOT_1 Size: 56; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FIELD_BANK_SLOT_1(UNIT_END + 0x00FE),

    /**
     * The PLAYER_FIELD_BANKBAG_SLOT_1 Size: 14; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FIELD_BANKBAG_SLOT_1(UNIT_END + 0x0136),

    /**
     * The PLAYER_FIELD_VENDORBUYBACK_SLOT_1 Size: 24; Type: LONG; Flags:
     * PRIVATE
     */
    PLAYER_FIELD_VENDORBUYBACK_SLOT_1(UNIT_END + 0x0144),

    /**
     * The PLAYER_FIELD_KEYRING_SLOT_1 Size: 64; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FIELD_KEYRING_SLOT_1(UNIT_END + 0x015C),

    /**
     * The PLAYER_FIELD_CURRENCYTOKEN_SLOT_1 Size: 64; Type: LONG; Flags:
     * PRIVATE
     */
    PLAYER_FIELD_CURRENCYTOKEN_SLOT_1(UNIT_END + 0x019C),

    /**
     * The PLAYER_FARSIGHT Size: 2; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FARSIGHT(UNIT_END + 0x01DC),

    /**
     * The PLAYER__FIELD_KNOWN_TITLES Size: 2; Type: LONG; Flags: PRIVATE
     */
    PLAYER__FIELD_KNOWN_TITLES(UNIT_END + 0x01DE),

    /**
     * The PLAYER__FIELD_KNOWN_TITLES1 Size: 2; Type: LONG; Flags: PRIVATE
     */
    PLAYER__FIELD_KNOWN_TITLES1(UNIT_END + 0x01E0),

    /**
     * The PLAYER__FIELD_KNOWN_TITLES2 Size: 2; Type: LONG; Flags: PRIVATE
     */
    PLAYER__FIELD_KNOWN_TITLES2(UNIT_END + 0x01E2),

    /**
     * The PLAYER_FIELD_KNOWN_CURRENCIES Size: 2; Type: LONG; Flags: PRIVATE
     */
    PLAYER_FIELD_KNOWN_CURRENCIES(UNIT_END + 0x01E4),

    /**
     * The PLAYER_XP Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_XP(UNIT_END + 0x01E6),

    /**
     * The PLAYER_NEXT_LEVEL_XP Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_NEXT_LEVEL_XP(UNIT_END + 0x01E7),

    /**
     * The PLAYER_SKILL_INFO_1_1 Size: 384; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_SKILL_INFO_1_1(UNIT_END + 0x01E8),

    /**
     * The PLAYER_CHARACTER_POINTS1 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_CHARACTER_POINTS1(UNIT_END + 0x0368),

    /**
     * The PLAYER_CHARACTER_POINTS2 Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_CHARACTER_POINTS2(UNIT_END + 0x0369),

    /**
     * The PLAYER_TRACK_CREATURES Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_TRACK_CREATURES(UNIT_END + 0x036A),

    /**
     * The PLAYER_TRACK_RESOURCES Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_TRACK_RESOURCES(UNIT_END + 0x036B),

    /**
     * The PLAYER_BLOCK_PERCENTAGE Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_BLOCK_PERCENTAGE(UNIT_END + 0x036C),

    /**
     * The PLAYER_DODGE_PERCENTAGE Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_DODGE_PERCENTAGE(UNIT_END + 0x036D),

    /**
     * The PLAYER_PARRY_PERCENTAGE Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_PARRY_PERCENTAGE(UNIT_END + 0x036E),

    /**
     * The PLAYER_EXPERTISE Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_EXPERTISE(UNIT_END + 0x036F),

    /**
     * The PLAYER_OFFHAND_EXPERTISE Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_OFFHAND_EXPERTISE(UNIT_END + 0x0370),

    /**
     * The PLAYER_CRIT_PERCENTAGE Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_CRIT_PERCENTAGE(UNIT_END + 0x0371),

    /**
     * The PLAYER_RANGED_CRIT_PERCENTAGE Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_RANGED_CRIT_PERCENTAGE(UNIT_END + 0x0372),

    /**
     * The PLAYER_OFFHAND_CRIT_PERCENTAGE Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_OFFHAND_CRIT_PERCENTAGE(UNIT_END + 0x0373),

    /**
     * The PLAYER_SPELL_CRIT_PERCENTAGE1 Size: 7; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_SPELL_CRIT_PERCENTAGE1(UNIT_END + 0x0374),

    /**
     * The PLAYER_SHIELD_BLOCK Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_SHIELD_BLOCK(UNIT_END + 0x037B),

    /**
     * The PLAYER_SHIELD_BLOCK_CRIT_PERCENTAGE Size: 1; Type: FLOAT; Flags:
     * PRIVATE
     */
    PLAYER_SHIELD_BLOCK_CRIT_PERCENTAGE(UNIT_END + 0x037C),

    /**
     * The PLAYER_EXPLORED_ZONES_1 Size: 128; Type: BYTES; Flags: PRIVATE
     */
    PLAYER_EXPLORED_ZONES_1(UNIT_END + 0x037D),

    /**
     * The PLAYER_REST_STATE_EXPERIENCE Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_REST_STATE_EXPERIENCE(UNIT_END + 0x03FD),

    /**
     * The PLAYER_FIELD_COINAGE Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_COINAGE(UNIT_END + 0x03FE),

    /**
     * The PLAYER_FIELD_MOD_DAMAGE_DONE_POS Size: 7; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_DAMAGE_DONE_POS(UNIT_END + 0x03FF),

    /**
     * The PLAYER_FIELD_MOD_DAMAGE_DONE_NEG Size: 7; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_DAMAGE_DONE_NEG(UNIT_END + 0x0406),

    /**
     * The PLAYER_FIELD_MOD_DAMAGE_DONE_PCT Size: 7; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_DAMAGE_DONE_PCT(UNIT_END + 0x040D),

    /**
     * The PLAYER_FIELD_MOD_HEALING_DONE_POS Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_HEALING_DONE_POS(UNIT_END + 0x0414),

    /**
     * The PLAYER_FIELD_MOD_HEALING_PCT Size: 1; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_HEALING_PCT(UNIT_END + 0x0415),

    /**
     * The PLAYER_FIELD_MOD_HEALING_DONE_PCT Size: 1; Type: FLOAT; Flags:
     * PRIVATE
     */
    PLAYER_FIELD_MOD_HEALING_DONE_PCT(UNIT_END + 0x0416),

    /**
     * The PLAYER_FIELD_MOD_TARGET_RESISTANCE Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_TARGET_RESISTANCE(UNIT_END + 0x0417),

    /**
     * The PLAYER_FIELD_MOD_TARGET_PHYSICAL_RESISTANCE Size: 1; Type: INT;
     * Flags: PRIVATE
     */
    PLAYER_FIELD_MOD_TARGET_PHYSICAL_RESISTANCE(UNIT_END + 0x0418),

    /**
     * The PLAYER_FIELD_BYTES Size: 1; Type: BYTES; Flags: PRIVATE
     */
    PLAYER_FIELD_BYTES(UNIT_END + 0x0419),

    /**
     * The PLAYER_AMMO_ID Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_AMMO_ID(UNIT_END + 0x041A),

    /**
     * The PLAYER_SELF_RES_SPELL Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_SELF_RES_SPELL(UNIT_END + 0x041B),

    /**
     * The PLAYER_FIELD_PVP_MEDALS Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_PVP_MEDALS(UNIT_END + 0x041C),

    /**
     * The PLAYER_FIELD_BUYBACK_PRICE_1 Size: 12; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_BUYBACK_PRICE_1(UNIT_END + 0x041D),

    /**
     * The PLAYER_FIELD_BUYBACK_TIMESTAMP_1 Size: 12; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_BUYBACK_TIMESTAMP_1(UNIT_END + 0x0429),

    /**
     * The PLAYER_FIELD_KILLS Size: 1; Type: TWO_SHORT; Flags: PRIVATE
     */
    PLAYER_FIELD_KILLS(UNIT_END + 0x0435),

    /**
     * The PLAYER_FIELD_TODAY_CONTRIBUTION Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_TODAY_CONTRIBUTION(UNIT_END + 0x0436),

    /**
     * The PLAYER_FIELD_YESTERDAY_CONTRIBUTION Size: 1; Type: INT; Flags:
     * PRIVATE
     */
    PLAYER_FIELD_YESTERDAY_CONTRIBUTION(UNIT_END + 0x0437),

    /**
     * The PLAYER_FIELD_LIFETIME_HONORBALE_KILLS Size: 1; Type: INT; Flags:
     * PRIVATE
     */
    PLAYER_FIELD_LIFETIME_HONORBALE_KILLS(UNIT_END + 0x0438),

    /**
     * The PLAYER_FIELD_BYTES2 Size: 1; Type: 6; Flags: PRIVATE
     */
    PLAYER_FIELD_BYTES2(UNIT_END + 0x0439),

    /**
     * The PLAYER_FIELD_WATCHED_FACTION_INDEX Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_WATCHED_FACTION_INDEX(UNIT_END + 0x043A),

    /**
     * The PLAYER_FIELD_COMBAT_RATING_1 Size: 25; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_COMBAT_RATING_1(UNIT_END + 0x043B),

    /**
     * The PLAYER_FIELD_ARENA_TEAM_INFO_1_1 Size: 21; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_ARENA_TEAM_INFO_1_1(UNIT_END + 0x0454),

    /**
     * The PLAYER_FIELD_HONOR_CURRENCY Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_HONOR_CURRENCY(UNIT_END + 0x0469),

    /**
     * The PLAYER_FIELD_ARENA_CURRENCY Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_ARENA_CURRENCY(UNIT_END + 0x046A),

    /**
     * The PLAYER_FIELD_MAX_LEVEL Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_MAX_LEVEL(UNIT_END + 0x046B),

    /**
     * The PLAYER_FIELD_DAILY_QUESTS_1 Size: 25; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_DAILY_QUESTS_1(UNIT_END + 0x046C),

    /**
     * The PLAYER_RUNE_REGEN_1 Size: 4; Type: FLOAT; Flags: PRIVATE
     */
    PLAYER_RUNE_REGEN_1(UNIT_END + 0x0485),

    /**
     * The PLAYER_NO_REAGENT_COST_1 Size: 3; Type: INT; Flags: PRIVATE
     */
    PLAYER_NO_REAGENT_COST_1(UNIT_END + 0x0489),

    /**
     * The PLAYER_FIELD_GLYPH_SLOTS_1 Size: 6; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_GLYPH_SLOTS_1(UNIT_END + 0x048C),

    /**
     * The PLAYER_FIELD_GLYPHS_1 Size: 6; Type: INT; Flags: PRIVATE
     */
    PLAYER_FIELD_GLYPHS_1(UNIT_END + 0x0492),

    /**
     * The PLAYER_GLYPHS_ENABLED Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_GLYPHS_ENABLED(UNIT_END + 0x0498),

    /**
     * The PLAYER_PET_SPELL_POWER Size: 1; Type: INT; Flags: PRIVATE
     */
    PLAYER_PET_SPELL_POWER(UNIT_END + 0x0499);

    /**
     * The PLAYER_END.
     */
    public static final int PLAYER_END = UNIT_END + 0x049A;

    private int value;

    PlayerFields(final int value) {

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

    public static UpdateField get(final int value) {

        for (final UpdateField pf : values()) {
            if (pf.getValue() == value) {
                return pf;
            }
        }
        // Not found :O
        return null;
    }
}
