package org.jmangos.commons.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorOptions;
import org.jmangos.commons.enums.SpellTarget;
import org.jmangos.commons.model.AddedRemoved;
import org.jmangos.commons.model.CanUseSpell;

@Entity
@Table(name = "Spell_Effect")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Effect", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
@DiscriminatorOptions(insert = false)
public class SpellEffectEntity implements AddedRemoved {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "Effect")
    public int Effect;

    @Column(name = "EffectDieSides")
    public int EffectDieSides;

    @Column(name = "EffectRealPointsPerLeve")
    public float EffectRealPointsPerLeve;

    @Column(name = "EffectBasePoints")
    public int EffectBasePoints;

    @Column(name = "EffectMechanic")
    public int EffectMechanic;

    @Column(name = "EffectImplicitTargetA")
    @Enumerated(EnumType.ORDINAL)
    public SpellTarget EffectImplicitTargetA;

    @Column(name = "EffectImplicitTargetB")
    @Enumerated(EnumType.ORDINAL)
    public SpellTarget EffectImplicitTargetB;

    @Column(name = "EffectRadiusIndex")
    public int EffectRadiusIndex;

    @Column(name = "EffectApplyAuraName")
    public int EffectApplyAuraName;

    @Column(name = "EffectAmplitude")
    public int EffectAmplitude;

    @Column(name = "EffectMultipleValue")
    public float EffectMultipleValue;

    @Column(name = "EffectChainTarget")
    public int EffectChainTarget;

    @Column(name = "EffectItemType")
    public int EffectItemType;

    @Column(name = "EffectMiscValue")
    public int EffectMiscValue;

    @Column(name = "EffectMiscValueB")
    public int EffectMiscValueB;

    @Column(name = "EffectTriggerSpell")
    public int EffectTriggerSpell;

    @Column(name = "EffectPointsPerComboPoint")
    public float EffectPointsPerComboPoint;

    @Column(name = "EffectSpellClassMaskA")
    public int EffectSpellClassMaskA;

    @Column(name = "EffectSpellClassMaskB")
    public int EffectSpellClassMaskB;

    @Column(name = "EffectSpellClassMaskC")
    public int EffectSpellClassMaskC;

    @Column(name = "DmgMultiplier")
    private float DmgMultiplier;

    @ManyToOne
    @JoinColumn(name = "spell_id")
    private SpellEntity spell;

    public SpellEffectEntity() {

    }

    public void apply() {

    }

    public boolean canApply(final CanUseSpell player) {
        return true;

    }

    /**
     * @return the id
     */
    public final int getId() {

        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final int id) {

        this.id = id;
    }

    /**
     * @return the effect
     */
    public final int getEffect() {

        return this.Effect;
    }

    /**
     * @param effect
     *        the effect to set
     */
    public final void setEffect(final int effect) {

        this.Effect = effect;
    }

    /**
     * @return the effectDieSides
     */
    public final int getEffectDieSides() {

        return this.EffectDieSides;
    }

    /**
     * @param effectDieSides
     *        the effectDieSides to set
     */
    public final void setEffectDieSides(final int effectDieSides) {

        this.EffectDieSides = effectDieSides;
    }

    /**
     * @return the effectRealPointsPerLeve
     */
    public final float getEffectRealPointsPerLeve() {

        return this.EffectRealPointsPerLeve;
    }

    /**
     * @param effectRealPointsPerLeve
     *        the effectRealPointsPerLeve to set
     */
    public final void setEffectRealPointsPerLeve(final float effectRealPointsPerLeve) {

        this.EffectRealPointsPerLeve = effectRealPointsPerLeve;
    }

    /**
     * @return the effectBasePoints
     */
    public final int getEffectBasePoints() {

        return this.EffectBasePoints;
    }

    /**
     * @param effectBasePoints
     *        the effectBasePoints to set
     */
    public final void setEffectBasePoints(final int effectBasePoints) {

        this.EffectBasePoints = effectBasePoints;
    }

    /**
     * @return the effectMechanic
     */
    public final int getEffectMechanic() {

        return this.EffectMechanic;
    }

    /**
     * @param effectMechanic
     *        the effectMechanic to set
     */
    public final void setEffectMechanic(final int effectMechanic) {

        this.EffectMechanic = effectMechanic;
    }

    /**
     * @return the effectImplicitTargetA
     */
    public final SpellTarget getEffectImplicitTargetA() {

        return this.EffectImplicitTargetA;
    }

    /**
     * @param effectImplicitTargetA
     *        the effectImplicitTargetA to set
     */
    public final void setEffectImplicitTargetA(final SpellTarget effectImplicitTargetA) {

        this.EffectImplicitTargetA = effectImplicitTargetA;
    }

    /**
     * @return the effectImplicitTargetB
     */
    public final SpellTarget getEffectImplicitTargetB() {

        return this.EffectImplicitTargetB;
    }

    /**
     * @param effectImplicitTargetB
     *        the effectImplicitTargetB to set
     */
    public final void setEffectImplicitTargetB(final SpellTarget effectImplicitTargetB) {

        this.EffectImplicitTargetB = effectImplicitTargetB;
    }

    /**
     * @return the effectRadiusIndex
     */
    public final int getEffectRadiusIndex() {

        return this.EffectRadiusIndex;
    }

    /**
     * @param effectRadiusIndex
     *        the effectRadiusIndex to set
     */
    public final void setEffectRadiusIndex(final int effectRadiusIndex) {

        this.EffectRadiusIndex = effectRadiusIndex;
    }

    /**
     * @return the effectApplyAuraName
     */
    public final int getEffectApplyAuraName() {

        return this.EffectApplyAuraName;
    }

    /**
     * @param effectApplyAuraName
     *        the effectApplyAuraName to set
     */
    public final void setEffectApplyAuraName(final int effectApplyAuraName) {

        this.EffectApplyAuraName = effectApplyAuraName;
    }

    /**
     * @return the effectAmplitude
     */
    public final int getEffectAmplitude() {

        return this.EffectAmplitude;
    }

    /**
     * @param effectAmplitude
     *        the effectAmplitude to set
     */
    public final void setEffectAmplitude(final int effectAmplitude) {

        this.EffectAmplitude = effectAmplitude;
    }

    /**
     * @return the effectMultipleValue
     */
    public final float getEffectMultipleValue() {

        return this.EffectMultipleValue;
    }

    /**
     * @param effectMultipleValue
     *        the effectMultipleValue to set
     */
    public final void setEffectMultipleValue(final float effectMultipleValue) {

        this.EffectMultipleValue = effectMultipleValue;
    }

    /**
     * @return the effectChainTarget
     */
    public final int getEffectChainTarget() {

        return this.EffectChainTarget;
    }

    /**
     * @param effectChainTarget
     *        the effectChainTarget to set
     */
    public final void setEffectChainTarget(final int effectChainTarget) {

        this.EffectChainTarget = effectChainTarget;
    }

    /**
     * @return the effectItemType
     */
    public final int getEffectItemType() {

        return this.EffectItemType;
    }

    /**
     * @param effectItemType
     *        the effectItemType to set
     */
    public final void setEffectItemType(final int effectItemType) {

        this.EffectItemType = effectItemType;
    }

    /**
     * @return the effectMiscValue
     */
    public final int getEffectMiscValue() {

        return this.EffectMiscValue;
    }

    /**
     * @param effectMiscValue
     *        the effectMiscValue to set
     */
    public final void setEffectMiscValue(final int effectMiscValue) {

        this.EffectMiscValue = effectMiscValue;
    }

    /**
     * @return the effectMiscValueB
     */
    public final int getEffectMiscValueB() {

        return this.EffectMiscValueB;
    }

    /**
     * @param effectMiscValueB
     *        the effectMiscValueB to set
     */
    public final void setEffectMiscValueB(final int effectMiscValueB) {

        this.EffectMiscValueB = effectMiscValueB;
    }

    /**
     * @return the effectTriggerSpell
     */
    public final int getEffectTriggerSpell() {

        return this.EffectTriggerSpell;
    }

    /**
     * @param effectTriggerSpell
     *        the effectTriggerSpell to set
     */
    public final void setEffectTriggerSpell(final int effectTriggerSpell) {

        this.EffectTriggerSpell = effectTriggerSpell;
    }

    /**
     * @return the effectPointsPerComboPoint
     */
    public final float getEffectPointsPerComboPoint() {

        return this.EffectPointsPerComboPoint;
    }

    /**
     * @param effectPointsPerComboPoint
     *        the effectPointsPerComboPoint to set
     */
    public final void setEffectPointsPerComboPoint(final float effectPointsPerComboPoint) {

        this.EffectPointsPerComboPoint = effectPointsPerComboPoint;
    }

    /**
     * @return the effectSpellClassMaskA
     */
    public final int getEffectSpellClassMaskA() {

        return this.EffectSpellClassMaskA;
    }

    /**
     * @param effectSpellClassMaskA
     *        the effectSpellClassMaskA to set
     */
    public final void setEffectSpellClassMaskA(final int effectSpellClassMaskA) {

        this.EffectSpellClassMaskA = effectSpellClassMaskA;
    }

    /**
     * @return the effectSpellClassMaskB
     */
    public final int getEffectSpellClassMaskB() {

        return this.EffectSpellClassMaskB;
    }

    /**
     * @param effectSpellClassMaskB
     *        the effectSpellClassMaskB to set
     */
    public final void setEffectSpellClassMaskB(final int effectSpellClassMaskB) {

        this.EffectSpellClassMaskB = effectSpellClassMaskB;
    }

    /**
     * @return the effectSpellClassMaskC
     */
    public final int getEffectSpellClassMaskC() {

        return this.EffectSpellClassMaskC;
    }

    /**
     * @param effectSpellClassMaskC
     *        the effectSpellClassMaskC to set
     */
    public final void setEffectSpellClassMaskC(final int effectSpellClassMaskC) {

        this.EffectSpellClassMaskC = effectSpellClassMaskC;
    }

    /**
     * @return the dmgMultiplier
     */
    public final float getDmgMultiplier() {

        return this.DmgMultiplier;
    }

    /**
     * @param dmgMultiplier
     *        the dmgMultiplier to set
     */
    public final void setDmgMultiplier(final float dmgMultiplier) {

        this.DmgMultiplier = dmgMultiplier;
    }

    /**
     * @return the spell
     */
    public final SpellEntity getSpell() {

        return this.spell;
    }

    /**
     * @param spell
     *        the spell to set
     */
    public final void setSpell(final SpellEntity spell) {

        this.spell = spell;
    }

    @Override
    public void onAdd(final CanUseSpell player) {

        // throw new NotImplementedException("For class"+
        // this.getClass().getName());

    }

    @Override
    public void onRemove(final CanUseSpell player) {

        // throw new NotImplementedException();

    }

}
