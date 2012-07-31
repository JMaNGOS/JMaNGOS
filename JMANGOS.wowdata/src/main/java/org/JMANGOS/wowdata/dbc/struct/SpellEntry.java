package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

public class SpellEntry extends DBCStruct<SpellEntry> {
	@XmlAttribute(name = "id", required = true)
	public final Unsigned32 Id = new Unsigned32(); // 0 m_ID
	@XmlAttribute(name = "Category", required = true)
	public final Unsigned32 Category = new Unsigned32(); // 1 m_category
	@XmlAttribute(name = "Dispel", required = true)
	public final Unsigned32 Dispel = new Unsigned32(); // 2 m_dispelType
	@XmlAttribute(name = "Mechanic", required = true)
	public final Unsigned32 Mechanic = new Unsigned32(); // 3 m_mechanic
	@XmlAttribute(name = "Attributes", required = true)
	public final Unsigned32 Attributes = new Unsigned32(); // 4 m_attribute
	@XmlAttribute(name = "AttributesEx", required = true)
	public final Unsigned32 AttributesEx = new Unsigned32(); // 5 m_attributesEx
	@XmlAttribute(name = "AttributesEx2", required = true)
	public final Unsigned32 AttributesEx2 = new Unsigned32(); // 6
																// m_attributesExB
	@XmlAttribute(name = "AttributesEx3", required = true)
	public final Unsigned32 AttributesEx3 = new Unsigned32(); // 7
																// m_attributesExC
	@XmlAttribute(name = "AttributesEx4", required = true)
	public final Unsigned32 AttributesEx4 = new Unsigned32(); // 8
																// m_attributesExD
	@XmlAttribute(name = "AttributesEx5", required = true)
	public final Unsigned32 AttributesEx5 = new Unsigned32(); // 9
																// m_attributesExE
	@XmlAttribute(name = "AttributesEx6", required = true)
	public final Unsigned32 AttributesEx6 = new Unsigned32(); // 10
																// m_attributesExF
	@XmlAttribute(name = "AttributesEx7", required = true)
	public final Unsigned32 AttributesEx7 = new Unsigned32(); // 11
																// m_attributesExG
																// (0x20 -
																// totems, 0x4 -
																// paladin
																// auras,
																// etc...)
	@XmlAttribute(name = "Stances", required = true)
	public final Unsigned32 Stances = new Unsigned32(); // 12 m_shapeshiftMask
	public final Unsigned32 unk_320_1 = new Unsigned32(); // 13 3.2.0
	@XmlAttribute(name = "StancesNot", required = true)
	public final Unsigned32 StancesNot = new Unsigned32(); // 14
															// m_shapeshiftExclude
	public final Unsigned32 unk_320_2 = new Unsigned32(); // 15 3.2.0
	@XmlAttribute(name = "Targets", required = true)
	public final Unsigned32 Targets = new Unsigned32(); // 16 m_targets
	@XmlAttribute(name = "TargetCreatureType", required = true)
	public final Unsigned32 TargetCreatureType = new Unsigned32(); // 17
																	// m_targetCreatureType
	@XmlAttribute(name = "RequiresSpellFocus", required = true)
	public final Unsigned32 RequiresSpellFocus = new Unsigned32(); // 18
																	// m_requiresSpellFocus
	@XmlAttribute(name = "FacingCasterFlags", required = true)
	public final Unsigned32 FacingCasterFlags = new Unsigned32(); // 19
																	// m_facingCasterFlags
	@XmlAttribute(name = "CasterAuraState", required = true)
	public final Unsigned32 CasterAuraState = new Unsigned32(); // 20
																// m_casterAuraState
	@XmlAttribute(name = "TargetAuraState", required = true)
	public final Unsigned32 TargetAuraState = new Unsigned32(); // 21
																// m_targetAuraState
	@XmlAttribute(name = "CasterAuraStateNot", required = true)
	public final Unsigned32 CasterAuraStateNot = new Unsigned32(); // 22
																	// m_excludeCasterAuraState
	@XmlAttribute(name = "TargetAuraStateNot", required = true)
	public final Unsigned32 TargetAuraStateNot = new Unsigned32(); // 23
																	// m_excludeTargetAuraState
	@XmlAttribute(name = "casterAuraSpell", required = true)
	public final Unsigned32 casterAuraSpell = new Unsigned32(); // 24
																// m_casterAuraSpell
	@XmlAttribute(name = "targetAuraSpell", required = true)
	public final Unsigned32 targetAuraSpell = new Unsigned32(); // 25
																// m_targetAuraSpell
	@XmlAttribute(name = "excludeCasterAuraSpell", required = true)
	public final Unsigned32 excludeCasterAuraSpell = new Unsigned32(); // 26
																		// m_excludeCasterAuraSpell
	@XmlAttribute(name = "Targets", required = true)
	public final Unsigned32 excludeTargetAuraSpell = new Unsigned32(); // 27
																		// m_excludeTargetAuraSpell
	@XmlAttribute(name = "CastingTimeIndex", required = true)
	public final Unsigned32 CastingTimeIndex = new Unsigned32(); // 28
																	// m_castingTimeIndex
	@XmlAttribute(name = "RecoveryTime", required = true)
	public final Unsigned32 RecoveryTime = new Unsigned32(); // 29
																// m_recoveryTime
	@XmlAttribute(name = "CategoryRecoveryTime", required = true)
	public final Unsigned32 CategoryRecoveryTime = new Unsigned32(); // 30
																		// m_categoryRecoveryTime
	@XmlAttribute(name = "InterruptFlags", required = true)
	public final Unsigned32 InterruptFlags = new Unsigned32(); // 31
																// m_interruptFlags
	@XmlAttribute(name = "AuraInterruptFlags", required = true)
	public final Unsigned32 AuraInterruptFlags = new Unsigned32(); // 32
																	// m_auraInterruptFlags
	@XmlAttribute(name = "ChannelInterruptFlags", required = true)
	public final Unsigned32 ChannelInterruptFlags = new Unsigned32(); // 33
																		// m_channelInterruptFlags
	@XmlAttribute(name = "procFlags")
	public final Unsigned32 procFlags = new Unsigned32(); // 34 m_procTypeMask
	@XmlAttribute(name = "procChance")
	public final Unsigned32 procChance = new Unsigned32(); // 35 m_procChance
	@XmlAttribute(name = "procCharges")
	public final Unsigned32 procCharges = new Unsigned32(); // 36 m_procCharges
	@XmlAttribute(name = "maxLevel")
	public final Unsigned32 maxLevel = new Unsigned32(); // 37 m_maxLevel
	@XmlAttribute(name = "baseLevel", required = true)
	public final Unsigned32 baseLevel = new Unsigned32(); // 38 m_baseLevel
	@XmlAttribute(name = "spellLevel", required = true)
	public final Unsigned32 spellLevel = new Unsigned32(); // 39 m_spellLevel
	@XmlAttribute(name = "DurationIndex", required = true)
	public final Unsigned32 DurationIndex = new Unsigned32(); // 40
																// m_durationIndex
	@XmlAttribute(name = "powerType", required = true)
	public final Unsigned32 powerType = new Unsigned32(); // 41 m_powerType
	@XmlAttribute(name = "manaCost", required = true)
	public final Unsigned32 manaCost = new Unsigned32(); // 42 m_manaCost
	@XmlAttribute(name = "manaCostPerlevel", required = true)
	public final Unsigned32 manaCostPerlevel = new Unsigned32(); // 43
																	// m_manaCostPerLevel
	@XmlAttribute(name = "manaPerSecond", required = true)
	public final Unsigned32 manaPerSecond = new Unsigned32(); // 44
																// m_manaPerSecond
	@XmlAttribute(name = "manaPerSecondPerLevel", required = true)
	public final Unsigned32 manaPerSecondPerLevel = new Unsigned32(); // 45
																		// m_manaPerSecondPerLevel
	@XmlAttribute(name = "rangeIndex", required = true)
	public final Unsigned32 rangeIndex = new Unsigned32(); // 46 m_rangeIndex
	@XmlAttribute(name = "speed", required = true)
	public final Float32 speed = new Float32(); // 47 m_speed
	public final Unsigned32 modalNextSpell = new Unsigned32(); // 48
																// m_modalNextSpell
																// not used
	@XmlAttribute(name = "StackAmount", required = true)
	public final Unsigned32 StackAmount = new Unsigned32(); // 49
															// m_cumulativeAura
	@XmlAttribute(name = "Totem", required = true)
	public final Unsigned32[] Totem = array(new Unsigned32[2]); // 50-51 m_totem
	@XmlAttribute(name = "Reagent", required = true)
	public final Signed32[] Reagent = array(new Signed32[8]); // 52-59 m_reagent
	@XmlAttribute(name = "ReagentCount", required = true)
	public final Unsigned32[] ReagentCount = array(new Unsigned32[8]); // 60-67
																		// m_reagentCount
	@XmlAttribute(name = "EquippedItemClass", required = true)
	public final Signed32 EquippedItemClass = new Signed32(); // 68
																// m_equippedItemClass
																// (value)
	@XmlAttribute(name = "EquippedItemSubClassMask", required = true)
	public final Signed32 EquippedItemSubClassMask = new Signed32(); // 69
																		// m_equippedItemSubclass
																		// (mask)
	@XmlAttribute(name = "EquippedItemInventoryTypeMask", required = true)
	public final Signed32 EquippedItemInventoryTypeMask = new Signed32(); // 70
																			// m_equippedItemInvTypes
																			// (mask)
	@XmlAttribute(name = "Effect", required = true)
	public final Unsigned32[] Effect = array(new Unsigned32[3]); // 71-73
																	// m_effect
	@XmlAttribute(name = "EffectDieSides", required = true)
	public final Signed32[] EffectDieSides = array(new Signed32[3]); // 74-76
																		// m_effectDieSides
	@XmlAttribute(name = "EffectRealPointsPerLeve", required = true)
	public final Float32[] EffectRealPointsPerLeve = array(new Float32[3]); // 77-79
																			// m_effectRealPointsPerLevel
	@XmlAttribute(name = "EffectBasePoints", required = true)
	public final Signed32[] EffectBasePoints = array(new Signed32[3]); // 80-82
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
	public final Unsigned32[] EffectMechanic = array(new Unsigned32[3]); // 83-85
																			// m_effectMechanic
	@XmlAttribute(name = "EffectImplicitTargetA", required = true)
	public final Unsigned32[] EffectImplicitTargetA = array(new Unsigned32[3]); // 86-88
																				// m_implicitTargetA
	@XmlAttribute(name = "EffectImplicitTargetB", required = true)
	public final Unsigned32[] EffectImplicitTargetB = array(new Unsigned32[3]); // 89-91
																				// m_implicitTargetB
	@XmlAttribute(name = "EffectRadiusIndex", required = true)
	public final Unsigned32[] EffectRadiusIndex = array(new Unsigned32[3]); // 92-94
																			// m_effectRadiusIndex
																			// -
																			// spellradius.dbc
	@XmlAttribute(name = "EffectApplyAuraName", required = true)
	public final Unsigned32[] EffectApplyAuraName = array(new Unsigned32[3]); // 95-97
																				// m_effectAura
	@XmlAttribute(name = "EffectAmplitude", required = true)
	public final Unsigned32[] EffectAmplitude = array(new Unsigned32[3]); // 98-100
																			// m_effectAuraPeriod
	@XmlAttribute(name = "EffectMultipleValue", required = true)
	public final Float32[] EffectMultipleValue = array(new Float32[3]); // 101-103
																		// m_effectAmplitude
	@XmlAttribute(name = "EffectChainTarget", required = true)
	public final Unsigned32[] EffectChainTarget = array(new Unsigned32[3]); // 104-106
																			// m_effectChainTargets
	@XmlAttribute(name = "EffectItemType", required = true)
	public final Unsigned32[] EffectItemType = array(new Unsigned32[3]); // 107-109
																			// m_effectItemType
	@XmlAttribute(name = "EffectMiscValue", required = true)
	public final Signed32[] EffectMiscValue = array(new Signed32[3]); // 110-112
																		// m_effectMiscValue
	@XmlAttribute(name = "EffectMiscValueB", required = true)
	public final Signed32[] EffectMiscValueB = array(new Signed32[3]); // 113-115
																		// m_effectMiscValueB
	@XmlAttribute(name = "EffectTriggerSpell", required = true)
	public final Unsigned32[] EffectTriggerSpell = array(new Unsigned32[3]); // 116-118
																				// m_effectTriggerSpell
	@XmlAttribute(name = "EffectPointsPerComboPoint", required = true)
	public final Float32[] EffectPointsPerComboPoint = array(new Float32[3]); // 119-121
																				// m_effectPointsPerCombo
	@XmlAttribute(name = "EffectSpellClassMaskA", required = true)
	public final Unsigned32[] EffectSpellClassMaskA = array(new Unsigned32[3]); // 122-124
																				// m_effectSpellClassMaskA,
																				// effect
																				// 0
	@XmlAttribute(name = "EffectSpellClassMaskB", required = true)
	public final Unsigned32[] EffectSpellClassMaskB = array(new Unsigned32[3]); // 125-127
																				// m_effectSpellClassMaskB,
																				// effect
																				// 1
	@XmlAttribute(name = "EffectSpellClassMaskC", required = true)
	public final Unsigned32[] EffectSpellClassMaskC = array(new Unsigned32[3]); // 128-130
																				// m_effectSpellClassMaskC,
																				// effect
																				// 2
	@XmlAttribute(name = "SpellVisual", required = true)
	public final Unsigned32[] SpellVisual = array(new Unsigned32[2]); // 131-132
																		// m_spellVisualID
	@XmlAttribute(name = "SpellIconID", required = true)
	public final Unsigned32 SpellIconID = new Unsigned32(); // 133 m_spellIconID
	@XmlAttribute(name = "activeIconID", required = true)
	public final Unsigned32 activeIconID = new Unsigned32(); // 134
																// m_activeIconID
	public final Unsigned32 spellPriority = new Unsigned32(); // 135
																// m_spellPriority
																// not used
	@XmlAttribute(name = "SpellName", required = true)
	public final MultiInternalString SpellName = new MultiInternalString();
	@XmlAttribute(name = "Rank", required = true)
	public final MultiInternalString Rank = new MultiInternalString();
	@XmlAttribute(name = "Description")
	public final MultiInternalString Description = new MultiInternalString();
	@XmlAttribute(name = "ToolTipDescription")
	public final MultiInternalString ToolTip = new MultiInternalString();
	@XmlAttribute(name = "ManaCostPercentage", required = true)
	public final Unsigned32 ManaCostPercentage = new Unsigned32();
	@XmlAttribute(name = "StartRecoveryCategory", required = true)
	public final Unsigned32 StartRecoveryCategory = new Unsigned32();
	@XmlAttribute(name = "StartRecoveryTime", required = true)
	public final Unsigned32 StartRecoveryTime = new Unsigned32();
	@XmlAttribute(name = "MaxTargetLevel", required = true)
	public final Unsigned32 MaxTargetLevel = new Unsigned32();
	@XmlAttribute(name = "SpellFamilyName", required = true)
	public final Unsigned32 SpellFamilyName = new Unsigned32();
	@XmlAttribute(name = "SpellFamilyFlags", required = true)
	public final Unsigned32 SpellFamilyFlags = new Unsigned32();
	@XmlAttribute(name = "SpellFamilyFlags2", required = true)
	public final Unsigned32 SpellFamilyFlags2 = new Unsigned32();
	@XmlAttribute(name = "MaxAffectedTargets", required = true)
	public final Unsigned32 MaxAffectedTargets = new Unsigned32();
	@XmlAttribute(name = "DmgClass", required = true)
	public final Unsigned32 DmgClass = new Unsigned32();
	@XmlAttribute(name = "PreventionType", required = true)
	public final Unsigned32 PreventionType = new Unsigned32();
	@XmlAttribute(name = "StanceBarOrder")
	public final Unsigned32 StanceBarOrder = new Unsigned32();
	@XmlAttribute(name = "DmgMultiplier", required = true)
	public final Float32[] DmgMultiplier = array(new Float32[3]);
	@XmlAttribute(name = "MinFactionId")
	public final Unsigned32 MinFactionId = new Unsigned32(); // 219
	@XmlAttribute(name = "MinReputation")
	public final Unsigned32 MinReputation = new Unsigned32(); // 220
	@XmlAttribute(name = "RequiredAuraVision")
	public final Unsigned32 RequiredAuraVision = new Unsigned32(); // 221
	@XmlAttribute(name = "TotemCategory", required = true)
	public final Unsigned32[] TotemCategory = array(new Unsigned32[2]); // 222-223
	@XmlAttribute(name = "AreaGroupId", required = true)
	public final Signed32 AreaGroupId = new Signed32(); // 224
	@XmlAttribute(name = "SchoolMask", required = true)
	public final Unsigned32 SchoolMask = new Unsigned32(); // 225 m_schoolMask
	@XmlAttribute(name = "runeCostID", required = true)
	public final Unsigned32 runeCostID = new Unsigned32(); // 226 m_runeCostID
	@XmlAttribute(name = "spellMissileID")
	public final Unsigned32 spellMissileID = new Unsigned32(); // 227
	@XmlAttribute(name = "PowerDisplayId")
	public final Unsigned32 PowerDisplayId = new Unsigned32(); // 228
	@XmlAttribute(name = "unk_320_4")
	public final Float32[] unk_320_4 = array(new Float32[3]); // 229-231 3.2.0
	@XmlAttribute(name = "spellDescriptionVariableID")
	public final Unsigned32 spellDescriptionVariableID = new Unsigned32(); // 232
	@XmlAttribute(name = "SpellDifficultyId")
	public final Unsigned32 SpellDifficultyId = new Unsigned32(); // 233 3.3.0
}
