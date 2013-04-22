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
/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.entities.SpellEntity;
import org.jmangos.commons.enums.SpellTarget;
import org.jmangos.tools.dbc.struct.SpellEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "spellService")
public class SpellService extends AbstractDbcService<SpellEntity, SpellEntry> {

    SpellService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final SpellEntity spellEntity) {

        if (spellEntity.getId() == null) {
            this.entityManager.persist(spellEntity);
        } else {
            this.entityManager.merge(spellEntity);
        }

    }

    @Override
    public void saveAll() {

        this.entityManager.flush();
        SpellEntry entry = getEntry();
        do {
            final SpellEntity se = new SpellEntity();
            se.setId(entry.Id.get());
            se.setCategory(entry.Category.get());
            se.setDispel(entry.Dispel.get());
            se.setMechanic(entry.Mechanic.get());
            se.setAttributes(entry.Attributes.get());
            se.setAttributesEx(entry.AttributesEx.get());
            se.setAttributesEx2(entry.AttributesEx2.get());
            se.setAttributesEx3(entry.AttributesEx3.get());
            se.setAttributesEx4(entry.AttributesEx4.get());
            se.setAttributesEx5(entry.AttributesEx5.get());
            se.setAttributesEx6(entry.AttributesEx6.get());
            se.setAttributesEx7(entry.AttributesEx7.get());
            se.setStances(entry.Stances.get());
            se.setStancesNot(entry.StancesNot.get());
            se.setTargets(entry.Targets.get());
            se.setTargetCreatureType(entry.TargetCreatureType.get());
            se.setRequiresSpellFocus(entry.RequiresSpellFocus.get());
            se.setFacingCasterFlags(entry.FacingCasterFlags.get());
            se.setCasterAuraState(entry.CasterAuraState.get());
            se.setTargetAuraState(entry.TargetAuraState.get());
            se.setCasterAuraStateNot(entry.CasterAuraStateNot.get());
            se.setTargetAuraStateNot(entry.TargetAuraStateNot.get());
            se.setCasterAuraSpell(entry.casterAuraSpell.get());
            se.setTargetAuraSpell(entry.targetAuraSpell.get());
            se.setExcludeCasterAuraSpell(entry.excludeCasterAuraSpell.get());
            se.setExcludeTargetAuraSpell(entry.excludeTargetAuraSpell.get());
            se.setCastingTimeIndex(entry.CastingTimeIndex.get());
            se.setRecoveryTime(entry.RecoveryTime.get());
            se.setCategoryRecoveryTime(entry.CategoryRecoveryTime.get());
            se.setInterruptFlags(entry.InterruptFlags.get());
            se.setAuraInterruptFlags(entry.AuraInterruptFlags.get());
            se.setChannelInterruptFlags(entry.ChannelInterruptFlags.get());
            se.setProcFlags(entry.procFlags.get());
            se.setProcChance(entry.procChance.get());
            se.setProcCharges(entry.procCharges.get());
            se.setMaxLevel(entry.maxLevel.get());
            se.setBaseLevel(entry.baseLevel.get());
            se.setSpellLevel(entry.spellLevel.get());
            se.setDurationIndex(entry.DurationIndex.get());
            se.setPowerType(entry.powerType.get());
            se.setManaCost(entry.manaCost.get());
            se.setManaCostPerlevel(entry.manaCostPerlevel.get());
            se.setManaPerSecond(entry.manaPerSecond.get());
            se.setManaPerSecondPerLevel(entry.manaPerSecondPerLevel.get());
            se.setRangeIndex(entry.rangeIndex.get());
            se.setSpeed(entry.speed.get());
            se.setModalNextSpell(entry.modalNextSpell.get());
            se.setStackAmount(entry.StackAmount.get());
            se.setTotem1(entry.Totem[0].get());
            se.setTotem2(entry.Totem[1].get());
            for (int j = 0; j < 8; j++) {
                se.setReagent(j, entry.Reagent[j].get());
                se.setReagentCount(j, entry.ReagentCount[j].get());
            }
            se.setEquippedItemClass(entry.EquippedItemClass.get());
            se.setEquippedItemSubClassMask(entry.EquippedItemSubClassMask.get());
            se.setEquippedItemInventoryTypeMask(entry.EquippedItemInventoryTypeMask.get());

            se.setSpellVisual1(entry.SpellVisual[0].get());
            se.setSpellVisual2(entry.SpellVisual[1].get());

            se.setSpellIconID(entry.SpellIconID.get());
            se.setActiveIconID(entry.activeIconID.get());
            se.setSpellPriority(entry.spellPriority.get());
            se.setSpellName(entry.SpellName.get().trim());

            se.setRank(entry.Rank.get());
            se.setDescription(entry.Description.get());

            se.setManaCostPercentage(entry.ManaCostPercentage.get());
            se.setStartRecoveryCategory(entry.StartRecoveryCategory.get());
            se.setStartRecoveryTime(entry.StartRecoveryTime.get());
            se.setMaxTargetLevel(entry.MaxTargetLevel.get());
            se.setSpellFamilyName(entry.SpellFamilyName.get());
            se.setSpellFamilyFlags(entry.SpellFamilyFlags.get());
            se.setSpellFamilyFlags2(entry.SpellFamilyFlags2.get());
            se.setMaxAffectedTargets(entry.MaxAffectedTargets.get());
            se.setDmgClass(entry.DmgClass.get());
            se.setPreventionType(entry.PreventionType.get());
            se.setStanceBarOrder(entry.StanceBarOrder.get());
            se.setMinFactionId(entry.MinFactionId.get());
            se.setMinReputation(entry.MinReputation.get());
            se.setRequiredAuraVision(entry.RequiredAuraVision.get());
            se.setTotemCategory(0, entry.TotemCategory[0].get());
            se.setTotemCategory(1, entry.TotemCategory[1].get());
            se.setAreaGroupId(entry.AreaGroupId.get());
            se.setSchoolMask(entry.SchoolMask.get());
            se.setRuneCostID(entry.runeCostID.get());
            se.setSpellMissileID(entry.spellMissileID.get());
            se.setPowerDisplayId(entry.PowerDisplayId.get());
            se.setSpellDescriptionVariableID(entry.spellDescriptionVariableID.get());
            se.setSpellDifficultyId(entry.SpellDifficultyId.get());
            for (int j = 0; j < 3; j++) {
                if (entry.Effect[j].get() > 0) {
                    final SpellEffectEntity spellEffect = new SpellEffectEntity();
                    spellEffect.setEffect(entry.Effect[j].get());
                    spellEffect.setEffectDieSides(entry.EffectDieSides[j].get());
                    Float f = entry.EffectRealPointsPerLeve[j].get();
                    if (!f.isNaN()) {
                        spellEffect.setEffectRealPointsPerLeve(f);
                    } else {
                        spellEffect.setEffectRealPointsPerLeve(0f);
                    }
                    spellEffect.setEffectBasePoints(entry.EffectBasePoints[j].get());
                    spellEffect.setEffectMechanic(entry.EffectMechanic[j].get());
                    spellEffect.setEffectImplicitTargetA(SpellTarget.get(entry.EffectImplicitTargetA[j].get()));
                    spellEffect.setEffectImplicitTargetB(SpellTarget.get(entry.EffectImplicitTargetB[j].get()));
                    spellEffect.setEffectRadiusIndex(entry.EffectRadiusIndex[j].get());
                    spellEffect.setEffectApplyAuraName(entry.EffectApplyAuraName[j].get());
                    spellEffect.setEffectAmplitude(entry.EffectAmplitude[j].get());
                    spellEffect.setEffectMultipleValue(entry.EffectMultipleValue[j].get());
                    spellEffect.setEffectChainTarget(entry.EffectChainTarget[j].get());
                    spellEffect.setEffectItemType(entry.EffectItemType[j].get());
                    spellEffect.setEffectMiscValue(entry.EffectMiscValue[j].get());
                    spellEffect.setEffectMiscValueB(entry.EffectMiscValueB[j].get());
                    spellEffect.setEffectTriggerSpell(entry.EffectTriggerSpell[j].get());
                    spellEffect.setEffectPointsPerComboPoint(entry.EffectPointsPerComboPoint[j].get());
                    spellEffect.setEffectSpellClassMaskA(entry.EffectSpellClassMaskA[j].get());
                    spellEffect.setEffectSpellClassMaskB(entry.EffectSpellClassMaskB[j].get());
                    spellEffect.setEffectSpellClassMaskC(entry.EffectSpellClassMaskC[j].get());
                    f = entry.DmgMultiplier[j].get();
                    if (!f.isNaN()) {
                        spellEffect.setDmgMultiplier(f);
                    } else {
                        spellEffect.setDmgMultiplier(0f);
                    }
                    se.getEffects().put(j, spellEffect);
                }

            }
            this.entityManager.persist(se);
        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../Realm/dbc/Spell.dbc";
    }

}
