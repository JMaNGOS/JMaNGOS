/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class SpellEntry extends DBCStruct<SpellEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Signed32 Id = new Signed32();         // 0
    // m_ID
    @XmlAttribute(name = "Category", required = true)
    public final Signed32 Category = new Signed32();         // 1
    // m_category
    @XmlAttribute(name = "Dispel", required = true)
    public final Signed32 Dispel = new Signed32();         // 2
    // m_dispelType
    @XmlAttribute(name = "Mechanic", required = true)
    public final Signed32 Mechanic = new Signed32();         // 3
    // m_mechanic
    @XmlAttribute(name = "Attributes", required = true)
    public final Signed32 Attributes = new Signed32();         // 4
    // m_attribute
    @XmlAttribute(name = "AttributesEx", required = true)
    public final Signed32 AttributesEx = new Signed32();         // 5
    // m_attributesEx
    @XmlAttribute(name = "AttributesEx2", required = true)
    public final Signed32 AttributesEx2 = new Signed32();         // 6
    // m_attributesExB
    @XmlAttribute(name = "AttributesEx3", required = true)
    public final Signed32 AttributesEx3 = new Signed32();         // 7
    // m_attributesExC
    @XmlAttribute(name = "AttributesEx4", required = true)
    public final Signed32 AttributesEx4 = new Signed32();         // 8
    // m_attributesExD
    @XmlAttribute(name = "AttributesEx5", required = true)
    public final Signed32 AttributesEx5 = new Signed32();         // 9
    // m_attributesExE
    @XmlAttribute(name = "AttributesEx6", required = true)
    public final Signed32 AttributesEx6 = new Signed32();         // 10
    // m_attributesExF
    @XmlAttribute(name = "AttributesEx7", required = true)
    public final Signed32 AttributesEx7 = new Signed32();         // 11
    // m_attributesExG
    // (0x20
    // -
    // totems,
    // 0x4
    // -
    // paladin
    // auras,
    // etc...)
    @XmlAttribute(name = "Stances", required = true)
    public final Signed32 Stances = new Signed32();         // 12
    // m_shapeshiftMask
    public final Signed32 unk_320_1 = new Signed32();         // 13
    // 3.2.0
    @XmlAttribute(name = "StancesNot", required = true)
    public final Signed32 StancesNot = new Signed32();         // 14
    // m_shapeshiftExclude
    public final Signed32 unk_320_2 = new Signed32();         // 15
    // 3.2.0
    @XmlAttribute(name = "Targets", required = true)
    public final Signed32 Targets = new Signed32();         // 16
    // m_targets
    @XmlAttribute(name = "TargetCreatureType", required = true)
    public final Signed32 TargetCreatureType = new Signed32();         // 17
    // m_targetCreatureType
    @XmlAttribute(name = "RequiresSpellFocus", required = true)
    public final Signed32 RequiresSpellFocus = new Signed32();         // 18
    // m_requiresSpellFocus
    @XmlAttribute(name = "FacingCasterFlags", required = true)
    public final Signed32 FacingCasterFlags = new Signed32();         // 19
    // m_facingCasterFlags
    @XmlAttribute(name = "CasterAuraState", required = true)
    public final Signed32 CasterAuraState = new Signed32();         // 20
    // m_casterAuraState
    @XmlAttribute(name = "TargetAuraState", required = true)
    public final Signed32 TargetAuraState = new Signed32();         // 21
    // m_targetAuraState
    @XmlAttribute(name = "CasterAuraStateNot", required = true)
    public final Signed32 CasterAuraStateNot = new Signed32();         // 22
    // m_excludeCasterAuraState
    @XmlAttribute(name = "TargetAuraStateNot", required = true)
    public final Signed32 TargetAuraStateNot = new Signed32();         // 23
    // m_excludeTargetAuraState
    @XmlAttribute(name = "casterAuraSpell", required = true)
    public final Signed32 casterAuraSpell = new Signed32();         // 24
    // m_casterAuraSpell
    @XmlAttribute(name = "targetAuraSpell", required = true)
    public final Signed32 targetAuraSpell = new Signed32();         // 25
    // m_targetAuraSpell
    @XmlAttribute(name = "excludeCasterAuraSpell", required = true)
    public final Signed32 excludeCasterAuraSpell = new Signed32();         // 26
    // m_excludeCasterAuraSpell
    @XmlAttribute(name = "Targets", required = true)
    public final Signed32 excludeTargetAuraSpell = new Signed32();         // 27
    // m_excludeTargetAuraSpell
    @XmlAttribute(name = "CastingTimeIndex", required = true)
    public final Signed32 CastingTimeIndex = new Signed32();         // 28
    // m_castingTimeIndex
    @XmlAttribute(name = "RecoveryTime", required = true)
    public final Signed32 RecoveryTime = new Signed32();         // 29
    // m_recoveryTime
    @XmlAttribute(name = "CategoryRecoveryTime", required = true)
    public final Signed32 CategoryRecoveryTime = new Signed32();         // 30
    // m_categoryRecoveryTime
    @XmlAttribute(name = "InterruptFlags", required = true)
    public final Signed32 InterruptFlags = new Signed32();         // 31
    // m_interruptFlags
    @XmlAttribute(name = "AuraInterruptFlags", required = true)
    public final Signed32 AuraInterruptFlags = new Signed32();         // 32
    // m_auraInterruptFlags
    @XmlAttribute(name = "ChannelInterruptFlags", required = true)
    public final Signed32 ChannelInterruptFlags = new Signed32();         // 33
    // m_channelInterruptFlags
    @XmlAttribute(name = "procFlags")
    public final Signed32 procFlags = new Signed32();         // 34
    // m_procTypeMask
    @XmlAttribute(name = "procChance")
    public final Signed32 procChance = new Signed32();         // 35
    // m_procChance
    @XmlAttribute(name = "procCharges")
    public final Signed32 procCharges = new Signed32();         // 36
    // m_procCharges
    @XmlAttribute(name = "maxLevel")
    public final Signed32 maxLevel = new Signed32();         // 37
    // m_maxLevel
    @XmlAttribute(name = "baseLevel", required = true)
    public final Signed32 baseLevel = new Signed32();         // 38
    // m_baseLevel
    @XmlAttribute(name = "spellLevel", required = true)
    public final Signed32 spellLevel = new Signed32();         // 39
    // m_spellLevel
    @XmlAttribute(name = "DurationIndex", required = true)
    public final Signed32 DurationIndex = new Signed32();         // 40
    // m_durationIndex
    @XmlAttribute(name = "powerType", required = true)
    public final Signed32 powerType = new Signed32();         // 41
    // m_powerType
    @XmlAttribute(name = "manaCost", required = true)
    public final Signed32 manaCost = new Signed32();         // 42
    // m_manaCost
    @XmlAttribute(name = "manaCostPerlevel", required = true)
    public final Signed32 manaCostPerlevel = new Signed32();         // 43
    // m_manaCostPerLevel
    @XmlAttribute(name = "manaPerSecond", required = true)
    public final Signed32 manaPerSecond = new Signed32();         // 44
    // m_manaPerSecond
    @XmlAttribute(name = "manaPerSecondPerLevel", required = true)
    public final Signed32 manaPerSecondPerLevel = new Signed32();         // 45
    // m_manaPerSecondPerLevel
    @XmlAttribute(name = "rangeIndex", required = true)
    public final Signed32 rangeIndex = new Signed32();         // 46
    // m_rangeIndex
    @XmlAttribute(name = "speed", required = true)
    public final Float32 speed = new Float32();            // 47
    // m_speed
    public final Signed32 modalNextSpell = new Signed32();         // 48
    // m_modalNextSpell
    // not
    // used
    @XmlAttribute(name = "StackAmount", required = true)
    public final Signed32 StackAmount = new Signed32();         // 49
    // m_cumulativeAura
    @XmlAttribute(name = "Totem", required = true)
    public final Signed32[] Totem = array(new Signed32[2]); // 50-51
                                                            // m_totem
    @XmlAttribute(name = "Reagent", required = true)
    public final Signed32[] Reagent = array(new Signed32[8]);   // 52-59
                                                              // m_reagent
    @XmlAttribute(name = "ReagentCount", required = true)
    public final Signed32[] ReagentCount = array(new Signed32[8]); // 60-67
                                                                   // m_reagentCount
    @XmlAttribute(name = "EquippedItemClass", required = true)
    public final Signed32 EquippedItemClass = new Signed32();           // 68
    // m_equippedItemClass
    // (value)
    @XmlAttribute(name = "EquippedItemSubClassMask", required = true)
    public final Signed32 EquippedItemSubClassMask = new Signed32();           // 69
    // m_equippedItemSubclass
    // (mask)
    @XmlAttribute(name = "EquippedItemInventoryTypeMask", required = true)
    public final Signed32 EquippedItemInventoryTypeMask = new Signed32();           // 70
    // m_equippedItemInvTypes
    // (mask)
    @XmlAttribute(name = "Effect", required = true)
    public final Signed32[] Effect = array(new Signed32[3]); // 71-73
                                                             // m_effect
    @XmlAttribute(name = "EffectDieSides", required = true)
    public final Signed32[] EffectDieSides = array(new Signed32[3]);   // 74-76
                                                                     // m_effectDieSides
    @XmlAttribute(name = "EffectRealPointsPerLeve", required = true)
    public final Float32[] EffectRealPointsPerLeve = array(new Float32[3]);    // 77-79
                                                                            // m_effectRealPointsPerLevel
    @XmlAttribute(name = "EffectBasePoints", required = true)
    public final Signed32[] EffectBasePoints = array(new Signed32[3]);   // 80-82
                                                                       // m_effectBasePoints
                                                                       // (don't
                                                                       // must
                                                                       // be
                                                                       // used
                                                                       // in
                                                                       // spell/auras
                                                                       // explicitly,
                                                                       // must
                                                                       // be
                                                                       // used
                                                                       // cached
                                                                       // Spell::m_currentBasePoints)
    @XmlAttribute(name = "EffectMechanic", required = true)
    public final Signed32[] EffectMechanic = array(new Signed32[3]); // 83-85
                                                                     // m_effectMechanic
    @XmlAttribute(name = "EffectImplicitTargetA", required = true)
    public final Signed32[] EffectImplicitTargetA = array(new Signed32[3]); // 86-88
                                                                            // m_implicitTargetA
    @XmlAttribute(name = "EffectImplicitTargetB", required = true)
    public final Signed32[] EffectImplicitTargetB = array(new Signed32[3]); // 89-91
                                                                            // m_implicitTargetB
    @XmlAttribute(name = "EffectRadiusIndex", required = true)
    public final Signed32[] EffectRadiusIndex = array(new Signed32[3]); // 92-94
                                                                        // m_effectRadiusIndex
                                                                        // -
                                                                        // spellradius.dbc
    @XmlAttribute(name = "EffectApplyAuraName", required = true)
    public final Signed32[] EffectApplyAuraName = array(new Signed32[3]); // 95-97
                                                                          // m_effectAura
    @XmlAttribute(name = "EffectAmplitude", required = true)
    public final Signed32[] EffectAmplitude = array(new Signed32[3]); // 98-100
                                                                      // m_effectAuraPeriod
    @XmlAttribute(name = "EffectMultipleValue", required = true)
    public final Float32[] EffectMultipleValue = array(new Float32[3]);    // 101-103
                                                                        // m_effectAmplitude
    @XmlAttribute(name = "EffectChainTarget", required = true)
    public final Signed32[] EffectChainTarget = array(new Signed32[3]); // 104-106
                                                                        // m_effectChainTargets
    @XmlAttribute(name = "EffectItemType", required = true)
    public final Signed32[] EffectItemType = array(new Signed32[3]); // 107-109
                                                                     // m_effectItemType
    @XmlAttribute(name = "EffectMiscValue", required = true)
    public final Signed32[] EffectMiscValue = array(new Signed32[3]);   // 110-112
                                                                      // m_effectMiscValue
    @XmlAttribute(name = "EffectMiscValueB", required = true)
    public final Signed32[] EffectMiscValueB = array(new Signed32[3]);   // 113-115
                                                                       // m_effectMiscValueB
    @XmlAttribute(name = "EffectTriggerSpell", required = true)
    public final Signed32[] EffectTriggerSpell = array(new Signed32[3]); // 116-118
                                                                         // m_effectTriggerSpell
    @XmlAttribute(name = "EffectPointsPerComboPoint", required = true)
    public final Float32[] EffectPointsPerComboPoint = array(new Float32[3]);    // 119-121
                                                                              // m_effectPointsPerCombo
    @XmlAttribute(name = "EffectSpellClassMaskA", required = true)
    public final Signed32[] EffectSpellClassMaskA = array(new Signed32[3]); // 122-124
                                                                            // m_effectSpellClassMaskA,
                                                                            // effect
                                                                            // 0
    @XmlAttribute(name = "EffectSpellClassMaskB", required = true)
    public final Signed32[] EffectSpellClassMaskB = array(new Signed32[3]); // 125-127
                                                                            // m_effectSpellClassMaskB,
                                                                            // effect
                                                                            // 1
    @XmlAttribute(name = "EffectSpellClassMaskC", required = true)
    public final Signed32[] EffectSpellClassMaskC = array(new Signed32[3]); // 128-130
                                                                            // m_effectSpellClassMaskC,
                                                                            // effect
                                                                            // 2
    @XmlAttribute(name = "SpellVisual", required = true)
    public final Signed32[] SpellVisual = array(new Signed32[2]); // 131-132
                                                                  // m_spellVisualID
    @XmlAttribute(name = "SpellIconID", required = true)
    public final Signed32 SpellIconID = new Signed32();         // 133
    // m_spellIconID
    @XmlAttribute(name = "activeIconID", required = true)
    public final Signed32 activeIconID = new Signed32();         // 134
    // m_activeIconID
    public final Signed32 spellPriority = new Signed32();         // 135
    // m_spellPriority
    // not
    // used
    @XmlAttribute(name = "SpellName", required = true)
    public final MultiInternalString SpellName = new MultiInternalString();
    @XmlAttribute(name = "Rank", required = true)
    public final MultiInternalString Rank = new MultiInternalString();
    @XmlAttribute(name = "Description")
    public final MultiInternalString Description = new MultiInternalString();
    @XmlAttribute(name = "ToolTipDescription")
    public final MultiInternalString ToolTip = new MultiInternalString();
    @XmlAttribute(name = "ManaCostPercentage", required = true)
    public final Signed32 ManaCostPercentage = new Signed32();
    @XmlAttribute(name = "StartRecoveryCategory", required = true)
    public final Signed32 StartRecoveryCategory = new Signed32();
    @XmlAttribute(name = "StartRecoveryTime", required = true)
    public final Signed32 StartRecoveryTime = new Signed32();
    @XmlAttribute(name = "MaxTargetLevel", required = true)
    public final Signed32 MaxTargetLevel = new Signed32();
    @XmlAttribute(name = "SpellFamilyName", required = true)
    public final Signed32 SpellFamilyName = new Signed32();
    @XmlAttribute(name = "SpellFamilyFlags", required = true)
    public final Signed32 SpellFamilyFlags = new Signed32();
    @XmlAttribute(name = "SpellFamilyFlags2", required = true)
    public final Signed32 SpellFamilyFlags2 = new Signed32();
    @XmlAttribute(name = "MaxAffectedTargets", required = true)
    public final Signed32 MaxAffectedTargets = new Signed32();
    @XmlAttribute(name = "DmgClass", required = true)
    public final Signed32 DmgClass = new Signed32();
    @XmlAttribute(name = "PreventionType", required = true)
    public final Signed32 PreventionType = new Signed32();
    @XmlAttribute(name = "StanceBarOrder")
    public final Signed32 StanceBarOrder = new Signed32();
    @XmlAttribute(name = "DmgMultiplier", required = true)
    public final Float32[] DmgMultiplier = array(new Float32[3]);
    @XmlAttribute(name = "MinFactionId")
    public final Signed32 MinFactionId = new Signed32();         // 219
    @XmlAttribute(name = "MinReputation")
    public final Signed32 MinReputation = new Signed32();         // 220
    @XmlAttribute(name = "RequiredAuraVision")
    public final Signed32 RequiredAuraVision = new Signed32();         // 221
    @XmlAttribute(name = "TotemCategory", required = true)
    public final Signed32[] TotemCategory = array(new Signed32[2]); // 222-223
    @XmlAttribute(name = "AreaGroupId", required = true)
    public final Signed32 AreaGroupId = new Signed32();           // 224
    @XmlAttribute(name = "SchoolMask", required = true)
    public final Signed32 SchoolMask = new Signed32();         // 225
    // m_schoolMask
    @XmlAttribute(name = "runeCostID", required = true)
    public final Signed32 runeCostID = new Signed32();         // 226
    // m_runeCostID
    @XmlAttribute(name = "spellMissileID")
    public final Signed32 spellMissileID = new Signed32();         // 227
    @XmlAttribute(name = "PowerDisplayId")
    public final Signed32 PowerDisplayId = new Signed32();         // 228
    @XmlAttribute(name = "unk_320_4")
    public final Float32[] unk_320_4 = array(new Float32[3]);    // 229-231
                                                              // 3.2.0
    @XmlAttribute(name = "spellDescriptionVariableID")
    public final Signed32 spellDescriptionVariableID = new Signed32();         // 232
    @XmlAttribute(name = "SpellDifficultyId")
    public final Signed32 SpellDifficultyId = new Signed32();         // 233
    // 3.3.0
}
