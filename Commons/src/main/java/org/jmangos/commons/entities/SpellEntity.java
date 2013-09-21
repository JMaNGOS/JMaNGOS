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
package org.jmangos.commons.entities;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javolution.util.FastMap;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.jmangos.commons.dataholder.Visitable;
import org.jmangos.commons.dataholder.Visitor;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.SpellAttributes;
import org.jmangos.commons.enums.SpellFamily;
import org.jmangos.commons.model.AddedRemoved;
import org.jmangos.commons.model.CanUseSpell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "Spell")
public class SpellEntity implements Visitable<SpellEffectEntity>, AddedRemoved {

    private static final Logger logger = LoggerFactory.getLogger(SpellEntity.class);
    @Id
    @Column(name = "id")
    private Integer Id;

    @Column(name = "Category")
    private int Category;

    @Column(name = "Dispel")
    private int Dispel;

    @Column(name = "Mechanic")
    private int Mechanic;

    @Column(name = "Attributes")
    private int Attributes;

    @Column(name = "AttributesEx")
    private int AttributesEx;

    @Column(name = "AttributesEx2")
    private int AttributesEx2;

    @Column(name = "AttributesEx3")
    private int AttributesEx3;

    @Column(name = "AttributesEx4")
    private int AttributesEx4;

    @Column(name = "AttributesEx5")
    private int AttributesEx5;

    @Column(name = "AttributesEx6")
    private int AttributesEx6;

    @Column(name = "AttributesEx7")
    private int AttributesEx7;

    @Column(name = "Stances")
    private int Stances;

    @Column(name = "StancesNot")
    private int StancesNot;

    @Column(name = "Targets")
    private int Targets;

    @Column(name = "TargetCreatureType")
    private int TargetCreatureType;

    @Column(name = "RequiresSpellFocus")
    private int RequiresSpellFocus;

    @Column(name = "FacingCasterFlags")
    private int FacingCasterFlags;

    @Column(name = "CasterAuraState")
    private int CasterAuraState;

    @Column(name = "TargetAuraState")
    private int TargetAuraState;

    @Column(name = "CasterAuraStateNot")
    private int CasterAuraStateNot;

    @Column(name = "TargetAuraStateNot")
    private int TargetAuraStateNot;

    @Column(name = "casterAuraSpell")
    private int casterAuraSpell;

    @Column(name = "targetAuraSpell")
    private int targetAuraSpell;

    @Column(name = "excludeCasterAuraSpell")
    private int excludeCasterAuraSpell;

    @Column(name = "excludeTargetAuraSpell")
    private int excludeTargetAuraSpell;

    @Column(name = "CastingTimeIndex")
    private int CastingTimeIndex;

    @Column(name = "RecoveryTime")
    private int RecoveryTime;

    @Column(name = "CategoryRecoveryTime")
    private int CategoryRecoveryTime;

    @Column(name = "InterruptFlags")
    private int InterruptFlags;

    @Column(name = "AuraInterruptFlags")
    private int AuraInterruptFlags;

    @Column(name = "ChannelInterruptFlags")
    private int ChannelInterruptFlags;

    @Column(name = "procFlags")
    private int procFlags;

    @Column(name = "procChance")
    private int procChance;

    @Column(name = "procCharges")
    private int procCharges;

    @Column(name = "maxLevel")
    private int maxLevel;

    @Column(name = "baseLevel")
    private int baseLevel;

    @Column(name = "spellLevel")
    private int spellLevel;

    @Column(name = "DurationIndex")
    private int DurationIndex;

    @Column(name = "powerType")
    private int powerType;

    @Column(name = "manaCost")
    private int manaCost;

    @Column(name = "manaCostPerlevel")
    private int manaCostPerlevel;

    @Column(name = "manaPerSecond")
    private int manaPerSecond;

    @Column(name = "manaPerSecondPerLevel")
    private int manaPerSecondPerLevel;

    @Column(name = "rangeIndex")
    private int rangeIndex;

    @Column(name = "speed")
    private float speed;

    @Column(name = "modalNextSpell")
    private int modalNextSpell;

    @Column(name = "StackAmount")
    private int StackAmount;

    @Column(name = "Totem1")
    private int Totem1;

    @Column(name = "Totem2")
    private int Totem2;

    @Column(name = "Reagent")
    private final int[] Reagent = new int[8];

    @Column(name = "ReagentCount")
    private final int[] ReagentCount = new int[8];

    @Column(name = "EquippedItemClass")
    private int EquippedItemClass;

    @Column(name = "EquippedItemSubClassMask")
    private int EquippedItemSubClassMask;

    @Column(name = "EquippedItemInventoryTypeMask")
    private int EquippedItemInventoryTypeMask;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @MapKeyColumn(name = "number", nullable = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "spell_id")
    private final Map<Integer, SpellEffectEntity> effects =
            new FastMap<Integer, SpellEffectEntity>();

    @Column(name = "SpellVisual1")
    private int SpellVisual1;
    @Column(name = "SpellVisual2")
    private int SpellVisual2;

    @Column(name = "SpellIconID")
    private int SpellIconID;

    @Column(name = "activeIconID")
    private int activeIconID;
    @Column(name = "spellPriority")
    private int spellPriority;

    @Column(name = "SpellName")
    private String SpellName;
    @Column(name = "Rank")
    private String Rank;
    @Column(name = "Description", length = 2048)
    private String Description;
    @Column(name = "ManaCostPercentage")
    private int ManaCostPercentage;
    @Column(name = "StartRecoveryCategory")
    private int StartRecoveryCategory;
    @Column(name = "StartRecoveryTime")
    private int StartRecoveryTime;
    @Column(name = "MaxTargetLevel")
    private int MaxTargetLevel;
    @Column(name = "SpellFamilyName")
    private int SpellFamilyName;
    @Column(name = "SpellFamilyFlags")
    private int SpellFamilyFlags;
    @Column(name = "SpellFamilyFlags2")
    private int SpellFamilyFlags2;
    @Column(name = "MaxAffectedTargets")
    private int MaxAffectedTargets;
    @Column(name = "DmgClass")
    private int DmgClass;
    @Column(name = "PreventionType")
    private int PreventionType;
    @Column(name = "StanceBarOrder")
    private int StanceBarOrder;
    @Column(name = "MinFactionId")
    private int MinFactionId;
    @Column(name = "MinReputation")
    private int MinReputation;
    @Column(name = "RequiredAuraVision")
    private int RequiredAuraVision;
    @Column(name = "TotemCategory")
    private final int[] TotemCategory = new int[2];
    @Column(name = "AreaGroupId")
    private int AreaGroupId;
    @Column(name = "SchoolMask")
    private int SchoolMask;
    @Column(name = "runeCostID")
    private int runeCostID;
    @Column(name = "spellMissileID")
    private int spellMissileID;
    @Column(name = "PowerDisplayId")
    private int PowerDisplayId;
    @Column(name = "spellDescriptionVariableID")
    private int spellDescriptionVariableID;
    @Column(name = "SpellDifficultyId")
    private int SpellDifficultyId;
    @Transient
    private Integer skillId;

    public SpellEntity() {

    }

    /**
     * @return the id
     */
    public final Integer getId() {

        return this.Id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final int id) {

        this.Id = id;
    }

    /**
     * @return the category
     */
    public final int getCategory() {

        return this.Category;
    }

    /**
     * @param category
     *        the category to set
     */
    public final void setCategory(final int category) {

        this.Category = category;
    }

    /**
     * @return the dispel
     */
    public final int getDispel() {

        return this.Dispel;
    }

    /**
     * @param dispel
     *        the dispel to set
     */
    public final void setDispel(final int dispel) {

        this.Dispel = dispel;
    }

    /**
     * @return the mechanic
     */
    public final int getMechanic() {

        return this.Mechanic;
    }

    /**
     * @param mechanic
     *        the mechanic to set
     */
    public final void setMechanic(final int mechanic) {

        this.Mechanic = mechanic;
    }

    /**
     * @return the attributes
     */
    public final int getAttributes() {

        return this.Attributes;
    }

    /**
     * @param attributes
     *        the attributes to set
     */
    public final void setAttributes(final int attributes) {

        this.Attributes = attributes;
    }

    /**
     * @return the attributesEx
     */
    public final int getAttributesEx() {

        return this.AttributesEx;
    }

    /**
     * @param attributesEx
     *        the attributesEx to set
     */
    public final void setAttributesEx(final int attributesEx) {

        this.AttributesEx = attributesEx;
    }

    /**
     * @return the attributesEx2
     */
    public final int getAttributesEx2() {

        return this.AttributesEx2;
    }

    /**
     * @param attributesEx2
     *        the attributesEx2 to set
     */
    public final void setAttributesEx2(final int attributesEx2) {

        this.AttributesEx2 = attributesEx2;
    }

    /**
     * @return the attributesEx3
     */
    public final int getAttributesEx3() {

        return this.AttributesEx3;
    }

    /**
     * @param attributesEx3
     *        the attributesEx3 to set
     */
    public final void setAttributesEx3(final int attributesEx3) {

        this.AttributesEx3 = attributesEx3;
    }

    /**
     * @return the attributesEx4
     */
    public final int getAttributesEx4() {

        return this.AttributesEx4;
    }

    /**
     * @param attributesEx4
     *        the attributesEx4 to set
     */
    public final void setAttributesEx4(final int attributesEx4) {

        this.AttributesEx4 = attributesEx4;
    }

    /**
     * @return the attributesEx5
     */
    public final int getAttributesEx5() {

        return this.AttributesEx5;
    }

    /**
     * @param attributesEx5
     *        the attributesEx5 to set
     */
    public final void setAttributesEx5(final int attributesEx5) {

        this.AttributesEx5 = attributesEx5;
    }

    /**
     * @return the attributesEx6
     */
    public final int getAttributesEx6() {

        return this.AttributesEx6;
    }

    /**
     * @param attributesEx6
     *        the attributesEx6 to set
     */
    public final void setAttributesEx6(final int attributesEx6) {

        this.AttributesEx6 = attributesEx6;
    }

    /**
     * @return the attributesEx7
     */
    public final int getAttributesEx7() {

        return this.AttributesEx7;
    }

    /**
     * @param attributesEx7
     *        the attributesEx7 to set
     */
    public final void setAttributesEx7(final int attributesEx7) {

        this.AttributesEx7 = attributesEx7;
    }

    /**
     * @return the stances
     */
    public final int getStances() {

        return this.Stances;
    }

    /**
     * @param stances
     *        the stances to set
     */
    public final void setStances(final int stances) {

        this.Stances = stances;
    }

    /**
     * @return the stancesNot
     */
    public final int getStancesNot() {

        return this.StancesNot;
    }

    /**
     * @param stancesNot
     *        the stancesNot to set
     */
    public final void setStancesNot(final int stancesNot) {

        this.StancesNot = stancesNot;
    }

    /**
     * @return the targets
     */
    public final int getTargets() {

        return this.Targets;
    }

    /**
     * @param targets
     *        the targets to set
     */
    public final void setTargets(final int targets) {

        this.Targets = targets;
    }

    /**
     * @return the targetCreatureType
     */
    public final int getTargetCreatureType() {

        return this.TargetCreatureType;
    }

    /**
     * @param targetCreatureType
     *        the targetCreatureType to set
     */
    public final void setTargetCreatureType(final int targetCreatureType) {

        this.TargetCreatureType = targetCreatureType;
    }

    /**
     * @return the requiresSpellFocus
     */
    public final int getRequiresSpellFocus() {

        return this.RequiresSpellFocus;
    }

    /**
     * @param requiresSpellFocus
     *        the requiresSpellFocus to set
     */
    public final void setRequiresSpellFocus(final int requiresSpellFocus) {

        this.RequiresSpellFocus = requiresSpellFocus;
    }

    /**
     * @return the facingCasterFlags
     */
    public final int getFacingCasterFlags() {

        return this.FacingCasterFlags;
    }

    /**
     * @param facingCasterFlags
     *        the facingCasterFlags to set
     */
    public final void setFacingCasterFlags(final int facingCasterFlags) {

        this.FacingCasterFlags = facingCasterFlags;
    }

    /**
     * @return the casterAuraState
     */
    public final int getCasterAuraState() {

        return this.CasterAuraState;
    }

    /**
     * @param casterAuraState
     *        the casterAuraState to set
     */
    public final void setCasterAuraState(final int casterAuraState) {

        this.CasterAuraState = casterAuraState;
    }

    /**
     * @return the targetAuraState
     */
    public final int getTargetAuraState() {

        return this.TargetAuraState;
    }

    /**
     * @param targetAuraState
     *        the targetAuraState to set
     */
    public final void setTargetAuraState(final int targetAuraState) {

        this.TargetAuraState = targetAuraState;
    }

    /**
     * @return the casterAuraStateNot
     */
    public final int getCasterAuraStateNot() {

        return this.CasterAuraStateNot;
    }

    /**
     * @param casterAuraStateNot
     *        the casterAuraStateNot to set
     */
    public final void setCasterAuraStateNot(final int casterAuraStateNot) {

        this.CasterAuraStateNot = casterAuraStateNot;
    }

    /**
     * @return the targetAuraStateNot
     */
    public final int getTargetAuraStateNot() {

        return this.TargetAuraStateNot;
    }

    /**
     * @param targetAuraStateNot
     *        the targetAuraStateNot to set
     */
    public final void setTargetAuraStateNot(final int targetAuraStateNot) {

        this.TargetAuraStateNot = targetAuraStateNot;
    }

    /**
     * @return the casterAuraSpell
     */
    public final int getCasterAuraSpell() {

        return this.casterAuraSpell;
    }

    /**
     * @param casterAuraSpell
     *        the casterAuraSpell to set
     */
    public final void setCasterAuraSpell(final int casterAuraSpell) {

        this.casterAuraSpell = casterAuraSpell;
    }

    /**
     * @return the targetAuraSpell
     */
    public final int getTargetAuraSpell() {

        return this.targetAuraSpell;
    }

    /**
     * @param targetAuraSpell
     *        the targetAuraSpell to set
     */
    public final void setTargetAuraSpell(final int targetAuraSpell) {

        this.targetAuraSpell = targetAuraSpell;
    }

    /**
     * @return the excludeCasterAuraSpell
     */
    public final int getExcludeCasterAuraSpell() {

        return this.excludeCasterAuraSpell;
    }

    /**
     * @param excludeCasterAuraSpell
     *        the excludeCasterAuraSpell to set
     */
    public final void setExcludeCasterAuraSpell(final int excludeCasterAuraSpell) {

        this.excludeCasterAuraSpell = excludeCasterAuraSpell;
    }

    /**
     * @return the excludeTargetAuraSpell
     */
    public final int getExcludeTargetAuraSpell() {

        return this.excludeTargetAuraSpell;
    }

    /**
     * @param excludeTargetAuraSpell
     *        the excludeTargetAuraSpell to set
     */
    public final void setExcludeTargetAuraSpell(final int excludeTargetAuraSpell) {

        this.excludeTargetAuraSpell = excludeTargetAuraSpell;
    }

    /**
     * @return the castingTimeIndex
     */
    public final int getCastingTimeIndex() {

        return this.CastingTimeIndex;
    }

    /**
     * @param castingTimeIndex
     *        the castingTimeIndex to set
     */
    public final void setCastingTimeIndex(final int castingTimeIndex) {

        this.CastingTimeIndex = castingTimeIndex;
    }

    /**
     * @return the recoveryTime
     */
    public final int getRecoveryTime() {

        return this.RecoveryTime;
    }

    /**
     * @param recoveryTime
     *        the recoveryTime to set
     */
    public final void setRecoveryTime(final int recoveryTime) {

        this.RecoveryTime = recoveryTime;
    }

    /**
     * @return the categoryRecoveryTime
     */
    public final int getCategoryRecoveryTime() {

        return this.CategoryRecoveryTime;
    }

    /**
     * @param categoryRecoveryTime
     *        the categoryRecoveryTime to set
     */
    public final void setCategoryRecoveryTime(final int categoryRecoveryTime) {

        this.CategoryRecoveryTime = categoryRecoveryTime;
    }

    /**
     * @return the interruptFlags
     */
    public final int getInterruptFlags() {

        return this.InterruptFlags;
    }

    /**
     * @param interruptFlags
     *        the interruptFlags to set
     */
    public final void setInterruptFlags(final int interruptFlags) {

        this.InterruptFlags = interruptFlags;
    }

    /**
     * @return the auraInterruptFlags
     */
    public final int getAuraInterruptFlags() {

        return this.AuraInterruptFlags;
    }

    /**
     * @param auraInterruptFlags
     *        the auraInterruptFlags to set
     */
    public final void setAuraInterruptFlags(final int auraInterruptFlags) {

        this.AuraInterruptFlags = auraInterruptFlags;
    }

    /**
     * @return the channelInterruptFlags
     */
    public final int getChannelInterruptFlags() {

        return this.ChannelInterruptFlags;
    }

    /**
     * @param channelInterruptFlags
     *        the channelInterruptFlags to set
     */
    public final void setChannelInterruptFlags(final int channelInterruptFlags) {

        this.ChannelInterruptFlags = channelInterruptFlags;
    }

    /**
     * @return the procFlags
     */
    public final int getProcFlags() {

        return this.procFlags;
    }

    /**
     * @param procFlags
     *        the procFlags to set
     */
    public final void setProcFlags(final int procFlags) {

        this.procFlags = procFlags;
    }

    /**
     * @return the procChance
     */
    public final int getProcChance() {

        return this.procChance;
    }

    /**
     * @param procChance
     *        the procChance to set
     */
    public final void setProcChance(final int procChance) {

        this.procChance = procChance;
    }

    /**
     * @return the procCharges
     */
    public final int getProcCharges() {

        return this.procCharges;
    }

    /**
     * @param procCharges
     *        the procCharges to set
     */
    public final void setProcCharges(final int procCharges) {

        this.procCharges = procCharges;
    }

    /**
     * @return the maxLevel
     */
    public final int getMaxLevel() {

        return this.maxLevel;
    }

    /**
     * @param maxLevel
     *        the maxLevel to set
     */
    public final void setMaxLevel(final int maxLevel) {

        this.maxLevel = maxLevel;
    }

    /**
     * @return the baseLevel
     */
    public final int getBaseLevel() {

        return this.baseLevel;
    }

    /**
     * @param baseLevel
     *        the baseLevel to set
     */
    public final void setBaseLevel(final int baseLevel) {

        this.baseLevel = baseLevel;
    }

    /**
     * @return the spellLevel
     */
    public final int getSpellLevel() {

        return this.spellLevel;
    }

    /**
     * @param spellLevel
     *        the spellLevel to set
     */
    public final void setSpellLevel(final int spellLevel) {

        this.spellLevel = spellLevel;
    }

    /**
     * @return the durationIndex
     */
    public final int getDurationIndex() {

        return this.DurationIndex;
    }

    /**
     * @param durationIndex
     *        the durationIndex to set
     */
    public final void setDurationIndex(final int durationIndex) {

        this.DurationIndex = durationIndex;
    }

    /**
     * @return the powerType
     */
    public final int getPowerType() {

        return this.powerType;
    }

    /**
     * @param powerType
     *        the powerType to set
     */
    public final void setPowerType(final int powerType) {

        this.powerType = powerType;
    }

    /**
     * @return the manaCost
     */
    public final int getManaCost() {

        return this.manaCost;
    }

    /**
     * @param manaCost
     *        the manaCost to set
     */
    public final void setManaCost(final int manaCost) {

        this.manaCost = manaCost;
    }

    /**
     * @return the manaCostPerlevel
     */
    public final int getManaCostPerlevel() {

        return this.manaCostPerlevel;
    }

    /**
     * @param manaCostPerlevel
     *        the manaCostPerlevel to set
     */
    public final void setManaCostPerlevel(final int manaCostPerlevel) {

        this.manaCostPerlevel = manaCostPerlevel;
    }

    /**
     * @return the manaPerSecond
     */
    public final int getManaPerSecond() {

        return this.manaPerSecond;
    }

    /**
     * @param manaPerSecond
     *        the manaPerSecond to set
     */
    public final void setManaPerSecond(final int manaPerSecond) {

        this.manaPerSecond = manaPerSecond;
    }

    /**
     * @return the manaPerSecondPerLevel
     */
    public final int getManaPerSecondPerLevel() {

        return this.manaPerSecondPerLevel;
    }

    /**
     * @param manaPerSecondPerLevel
     *        the manaPerSecondPerLevel to set
     */
    public final void setManaPerSecondPerLevel(final int manaPerSecondPerLevel) {

        this.manaPerSecondPerLevel = manaPerSecondPerLevel;
    }

    /**
     * @return the rangeIndex
     */
    public final int getRangeIndex() {

        return this.rangeIndex;
    }

    /**
     * @param rangeIndex
     *        the rangeIndex to set
     */
    public final void setRangeIndex(final int rangeIndex) {

        this.rangeIndex = rangeIndex;
    }

    /**
     * @return the speed
     */
    public final float getSpeed() {

        return this.speed;
    }

    /**
     * @param speed
     *        the speed to set
     */
    public final void setSpeed(final float speed) {

        this.speed = speed;
    }

    /**
     * @return the modalNextSpell
     */
    public final int getModalNextSpell() {

        return this.modalNextSpell;
    }

    /**
     * @param modalNextSpell
     *        the modalNextSpell to set
     */
    public final void setModalNextSpell(final int modalNextSpell) {

        this.modalNextSpell = modalNextSpell;
    }

    /**
     * @return the stackAmount
     */
    public final int getStackAmount() {

        return this.StackAmount;
    }

    /**
     * @param stackAmount
     *        the stackAmount to set
     */
    public final void setStackAmount(final int stackAmount) {

        this.StackAmount = stackAmount;
    }

    /**
     * @return the totem1
     */
    public final int getTotem1() {

        return this.Totem1;
    }

    /**
     * @param totem1
     *        the totem1 to set
     */
    public final void setTotem1(final int totem1) {

        this.Totem1 = totem1;
    }

    /**
     * @return the totem2
     */
    public final int getTotem2() {

        return this.Totem2;
    }

    /**
     * @param totem2
     *        the totem2 to set
     */
    public final void setTotem2(final int totem2) {

        this.Totem2 = totem2;
    }

    /**
     * @return the equippedItemClass
     */
    public final int getEquippedItemClass() {

        return this.EquippedItemClass;
    }

    /**
     * @param equippedItemClass
     *        the equippedItemClass to set
     */
    public final void setEquippedItemClass(final int equippedItemClass) {

        this.EquippedItemClass = equippedItemClass;
    }

    /**
     * @return the equippedItemSubClassMask
     */
    public final int getEquippedItemSubClassMask() {

        return this.EquippedItemSubClassMask;
    }

    /**
     * @param equippedItemSubClassMask
     *        the equippedItemSubClassMask to set
     */
    public final void setEquippedItemSubClassMask(final int equippedItemSubClassMask) {

        this.EquippedItemSubClassMask = equippedItemSubClassMask;
    }

    /**
     * @return the equippedItemInventoryTypeMask
     */
    public final int getEquippedItemInventoryTypeMask() {

        return this.EquippedItemInventoryTypeMask;
    }

    /**
     * @param equippedItemInventoryTypeMask
     *        the equippedItemInventoryTypeMask to set
     */
    public final void setEquippedItemInventoryTypeMask(final int equippedItemInventoryTypeMask) {

        this.EquippedItemInventoryTypeMask = equippedItemInventoryTypeMask;
    }

    /**
     * @return the spellVisual1
     */
    public final int getSpellVisual1() {

        return this.SpellVisual1;
    }

    /**
     * @param spellVisual1
     *        the spellVisual1 to set
     */
    public final void setSpellVisual1(final int spellVisual1) {

        this.SpellVisual1 = spellVisual1;
    }

    /**
     * @return the spellVisual2
     */
    public final int getSpellVisual2() {

        return this.SpellVisual2;
    }

    /**
     * @param spellVisual2
     *        the spellVisual2 to set
     */
    public final void setSpellVisual2(final int spellVisual2) {

        this.SpellVisual2 = spellVisual2;
    }

    /**
     * @return the spellIconID
     */
    public final int getSpellIconID() {

        return this.SpellIconID;
    }

    /**
     * @param spellIconID
     *        the spellIconID to set
     */
    public final void setSpellIconID(final int spellIconID) {

        this.SpellIconID = spellIconID;
    }

    /**
     * @return the activeIconID
     */
    public final int getActiveIconID() {

        return this.activeIconID;
    }

    /**
     * @param activeIconID
     *        the activeIconID to set
     */
    public final void setActiveIconID(final int activeIconID) {

        this.activeIconID = activeIconID;
    }

    /**
     * @return the spellPriority
     */
    public final int getSpellPriority() {

        return this.spellPriority;
    }

    /**
     * @param spellPriority
     *        the spellPriority to set
     */
    public final void setSpellPriority(final int spellPriority) {

        this.spellPriority = spellPriority;
    }

    /**
     * @return the spellName
     */
    public final String getSpellName() {

        return this.SpellName;
    }

    /**
     * @param spellName
     *        the spellName to set
     */
    public final void setSpellName(final String spellName) {

        this.SpellName = spellName;
    }

    /**
     * @return the rank
     */
    public final String getRank() {

        return this.Rank;
    }

    /**
     * @param rank
     *        the rank to set
     */
    public final void setRank(final String rank) {

        this.Rank = rank;
    }

    /**
     * @return the description
     */
    public final String getDescription() {

        return this.Description;
    }

    /**
     * @param description
     *        the description to set
     */
    public final void setDescription(final String description) {

        this.Description = description;
    }

    /**
     * @return the manaCostPercentage
     */
    public final int getManaCostPercentage() {

        return this.ManaCostPercentage;
    }

    /**
     * @param manaCostPercentage
     *        the manaCostPercentage to set
     */
    public final void setManaCostPercentage(final int manaCostPercentage) {

        this.ManaCostPercentage = manaCostPercentage;
    }

    /**
     * @return the startRecoveryCategory
     */
    public final int getStartRecoveryCategory() {

        return this.StartRecoveryCategory;
    }

    /**
     * @param startRecoveryCategory
     *        the startRecoveryCategory to set
     */
    public final void setStartRecoveryCategory(final int startRecoveryCategory) {

        this.StartRecoveryCategory = startRecoveryCategory;
    }

    /**
     * @return the startRecoveryTime
     */
    public final int getStartRecoveryTime() {

        return this.StartRecoveryTime;
    }

    /**
     * @param startRecoveryTime
     *        the startRecoveryTime to set
     */
    public final void setStartRecoveryTime(final int startRecoveryTime) {

        this.StartRecoveryTime = startRecoveryTime;
    }

    /**
     * @return the maxTargetLevel
     */
    public final int getMaxTargetLevel() {

        return this.MaxTargetLevel;
    }

    /**
     * @param maxTargetLevel
     *        the maxTargetLevel to set
     */
    public final void setMaxTargetLevel(final int maxTargetLevel) {

        this.MaxTargetLevel = maxTargetLevel;
    }

    /**
     * @return the spellFamilyName
     */
    public final int getSpellFamilyName() {

        return this.SpellFamilyName;
    }

    /**
     * @param spellFamilyName
     *        the spellFamilyName to set
     */
    public final void setSpellFamilyName(final int spellFamilyName) {

        this.SpellFamilyName = spellFamilyName;
    }

    /**
     * @return the spellFamilyFlags
     */
    public final int getSpellFamilyFlags() {

        return this.SpellFamilyFlags;
    }

    /**
     * @param spellFamilyFlags
     *        the spellFamilyFlags to set
     */
    public final void setSpellFamilyFlags(final int spellFamilyFlags) {

        this.SpellFamilyFlags = spellFamilyFlags;
    }

    /**
     * @return the spellFamilyFlags2
     */
    public final int getSpellFamilyFlags2() {

        return this.SpellFamilyFlags2;
    }

    /**
     * @param spellFamilyFlags2
     *        the spellFamilyFlags2 to set
     */
    public final void setSpellFamilyFlags2(final int spellFamilyFlags2) {

        this.SpellFamilyFlags2 = spellFamilyFlags2;
    }

    /**
     * @return the maxAffectedTargets
     */
    public final int getMaxAffectedTargets() {

        return this.MaxAffectedTargets;
    }

    /**
     * @param maxAffectedTargets
     *        the maxAffectedTargets to set
     */
    public final void setMaxAffectedTargets(final int maxAffectedTargets) {

        this.MaxAffectedTargets = maxAffectedTargets;
    }

    /**
     * @return the dmgClass
     */
    public final int getDmgClass() {

        return this.DmgClass;
    }

    /**
     * @param dmgClass
     *        the dmgClass to set
     */
    public final void setDmgClass(final int dmgClass) {

        this.DmgClass = dmgClass;
    }

    /**
     * @return the preventionType
     */
    public final int getPreventionType() {

        return this.PreventionType;
    }

    /**
     * @param preventionType
     *        the preventionType to set
     */
    public final void setPreventionType(final int preventionType) {

        this.PreventionType = preventionType;
    }

    /**
     * @return the stanceBarOrder
     */
    public final int getStanceBarOrder() {

        return this.StanceBarOrder;
    }

    /**
     * @param stanceBarOrder
     *        the stanceBarOrder to set
     */
    public final void setStanceBarOrder(final int stanceBarOrder) {

        this.StanceBarOrder = stanceBarOrder;
    }

    /**
     * @return the minFactionId
     */
    public final int getMinFactionId() {

        return this.MinFactionId;
    }

    /**
     * @param minFactionId
     *        the minFactionId to set
     */
    public final void setMinFactionId(final int minFactionId) {

        this.MinFactionId = minFactionId;
    }

    /**
     * @return the minReputation
     */
    public final int getMinReputation() {

        return this.MinReputation;
    }

    /**
     * @param minReputation
     *        the minReputation to set
     */
    public final void setMinReputation(final int minReputation) {

        this.MinReputation = minReputation;
    }

    /**
     * @return the requiredAuraVision
     */
    public final int getRequiredAuraVision() {

        return this.RequiredAuraVision;
    }

    /**
     * @param requiredAuraVision
     *        the requiredAuraVision to set
     */
    public final void setRequiredAuraVision(final int requiredAuraVision) {

        this.RequiredAuraVision = requiredAuraVision;
    }

    /**
     * @return the totemCategory
     */
    public final int getTotemCategory(final int index) {

        return this.TotemCategory[index];
    }

    /**
     * @param totemCategory
     *        the totemCategory to set
     */
    public final void setTotemCategory(final int index, final int totemCategory) {

        this.TotemCategory[index] = totemCategory;
    }

    /**
     * @return the areaGroupId
     */
    public final int getAreaGroupId() {

        return this.AreaGroupId;
    }

    /**
     * @param areaGroupId
     *        the areaGroupId to set
     */
    public final void setAreaGroupId(final int areaGroupId) {

        this.AreaGroupId = areaGroupId;
    }

    /**
     * @return the schoolMask
     */
    public final int getSchoolMask() {

        return this.SchoolMask;
    }

    /**
     * @param schoolMask
     *        the schoolMask to set
     */
    public final void setSchoolMask(final int schoolMask) {

        this.SchoolMask = schoolMask;
    }

    /**
     * @return the runeCostID
     */
    public final int getRuneCostID() {

        return this.runeCostID;
    }

    /**
     * @param runeCostID
     *        the runeCostID to set
     */
    public final void setRuneCostID(final int runeCostID) {

        this.runeCostID = runeCostID;
    }

    /**
     * @return the spellMissileID
     */
    public final int getSpellMissileID() {

        return this.spellMissileID;
    }

    /**
     * @param spellMissileID
     *        the spellMissileID to set
     */
    public final void setSpellMissileID(final int spellMissileID) {

        this.spellMissileID = spellMissileID;
    }

    /**
     * @return the powerDisplayId
     */
    public final int getPowerDisplayId() {

        return this.PowerDisplayId;
    }

    /**
     * @param powerDisplayId
     *        the powerDisplayId to set
     */
    public final void setPowerDisplayId(final int powerDisplayId) {

        this.PowerDisplayId = powerDisplayId;
    }

    /**
     * @return the spellDescriptionVariableID
     */
    public final int getSpellDescriptionVariableID() {

        return this.spellDescriptionVariableID;
    }

    /**
     * @param spellDescriptionVariableID
     *        the spellDescriptionVariableID to set
     */
    public final void setSpellDescriptionVariableID(final int spellDescriptionVariableID) {

        this.spellDescriptionVariableID = spellDescriptionVariableID;
    }

    /**
     * @return the spellDifficultyId
     */
    public final int getSpellDifficultyId() {

        return this.SpellDifficultyId;
    }

    /**
     * @param spellDifficultyId
     *        the spellDifficultyId to set
     */
    public final void setSpellDifficultyId(final int spellDifficultyId) {

        this.SpellDifficultyId = spellDifficultyId;
    }

    /**
     * @return the reagent
     */
    public final int[] getReagent() {

        return this.Reagent;
    }

    /**
     * @return the reagent
     */
    public final void setReagent(final int index, final int value) {

        this.Reagent[index] = value;
    }

    /**
     * @return the reagentCount
     */
    public final int[] getReagentCount() {

        return this.ReagentCount;
    }

    /**
     * @return the reagent
     */
    public final void setReagentCount(final int index, final int value) {

        this.ReagentCount[index] = value;
    }

    /**
     * @return the effects
     */
    public final Map<Integer, SpellEffectEntity> getEffects() {

        return this.effects;
    }

    /**
     * @return the skillId
     */
    public final Integer getSkillId() {
        return this.skillId;
    }

    /**
     * @param skill
     *        the skillId to set
     */
    public final void setSkillId(final Integer skillId) {
        this.skillId = skillId;
    }

    @Override
    public void iterate(final Visitor<SpellEffectEntity> visitor) {

        for (final Entry<Integer, SpellEffectEntity> value : this.effects.entrySet()) {
            visitor.visit(value.getValue());
        }
    }

    @Override
    public void onAdd(final CanUseSpell object) {
        if (object instanceof CharacterData) {
            final CharacterData cd = ((CharacterData) object);
            final SpellFamily spellFamily = SpellFamily.get(getSpellFamilyName());
            if (cd.getLevel() < getSpellLevel()) {
                logger.debug("Can't add spell due to low level");
                return;
            }
            switch (spellFamily) {
                case DEATHKNIGHT:
                    if (cd.getClazz() != Classes.DEATH_KNIGHT) {
                        return;
                    }
                break;
                case DRUID:
                    if (cd.getClazz() != Classes.DRUID) {
                        return;
                    }
                break;
                case HUNTER:
                    if (cd.getClazz() != Classes.HUNTER) {
                        return;
                    }
                break;
                case MAGE:
                    if (cd.getClazz() != Classes.MAGE) {
                        return;
                    }
                break;
                case PRIEST:
                    if (cd.getClazz() != Classes.PRIEST) {
                        return;
                    }
                break;
                case PALADIN:
                    if (cd.getClazz() != Classes.PALADIN) {
                        return;
                    }
                break;
                case WARLOCK:
                    if (cd.getClazz() != Classes.WARLOCK) {
                        return;
                    }
                break;
                case WARRIOR:
                    if (cd.getClazz() != Classes.WARRIOR) {
                        return;
                    }
                break;
                default:
                break;
            }
        }

        boolean canApply = true;
        for (final Entry<Integer, SpellEffectEntity> value : this.effects.entrySet()) {
            canApply &= value.getValue().canApply(object);
        }
        if (canApply) {
            logger.debug("Add {} spell named {}", getId(), getSpellName());
            if (object.addToSpellContainer(this)) {
                for (final Entry<Integer, SpellEffectEntity> value : this.effects.entrySet()) {
                    value.getValue().onAdd(object);
                }
            }
        }
    }

    @Override
    public void onRemove(final CanUseSpell object) {

        for (final Entry<Integer, SpellEffectEntity> value : this.effects.entrySet()) {
            value.getValue().onRemove(object);
        }
    }

    public boolean isPassive() {

        return SpellAttributes.PASSIVE.contains(getAttributes());
    }

    public boolean isAbility() {

        return SpellAttributes.ABILITY.contains(getAttributes());
    }
}
