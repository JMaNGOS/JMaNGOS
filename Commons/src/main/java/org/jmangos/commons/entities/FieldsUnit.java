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

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import javolution.util.FastMap;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.enums.ModType;
import org.jmangos.commons.enums.ModelType;
import org.jmangos.commons.enums.Powers;
import org.jmangos.commons.enums.Races;
import org.jmangos.commons.enums.Stats;
import org.jmangos.commons.enums.TypeID;
import org.jmangos.commons.enums.TypeMask;
import org.jmangos.commons.model.UnitRegenModifier;
import org.jmangos.commons.update.UnitField;

/**
 * 
 * @author MinimaJack
 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FieldsUnit extends FieldsObject {

    @Transient
    private long charm;
    @Transient
    private long summon;
    @Transient
    private long critter;
    @Transient
    private long charmedBy;
    @Transient
    private long summonedBy;
    @Transient
    private long createdBy;
    @Transient
    private long target;
    @Transient
    private long channelObject;
    @Transient
    private int channelSpell;

    @Transient
    private Map<Byte, UnitRegenModifier> powerRegenModifier =
            new FastMap<Byte, UnitRegenModifier>();
    {
        // FIX for test
        final UnitRegenModifier rfm = new UnitRegenModifier();
        rfm.setFlat(6.789616f);
        this.powerRegenModifier.put((byte) 0, rfm);
    }
    @Transient
    private int faction_template = 1;
    @Transient
    private int[] virtualItems = new int[3];
    @Transient
    private int flags;
    @Transient
    private int flags2;
    @Transient
    private int aurastate;
    @Transient
    private final int[] attackTime = new int[3];
    @Transient
    private float boundingRadius;
    @Transient
    private float combatReach;
    @Transient
    private final int[] displayIds = new int[ModelType.COUNT_MODEL_TYPES];
    @Transient
    private final float[] mainDemage = new float[2];
    @Transient
    private float[] offDemage = new float[2];
    @Transient
    private int bytes1;
    @Transient
    private int petNumber;
    @Transient
    private int petNameTimeStamp;
    @Transient
    private int petExperience;
    @Transient
    private int petNextLevelXp;
    @Transient
    private int dynamicFlags;
    @Transient
    private float modCastSpeed;
    @Transient
    private int createdBySpell;
    @Transient
    private int npcFlags;
    @Transient
    private int npcEmoteState;
    @Transient
    private final int[] stat = new int[5];
    @Transient
    private final int[] createStat = new int[5];
    @Transient
    private int[] positiveStat = new int[5];
    @Transient
    private int[] negativeStat = new int[5];
    @Transient
    private final int[] resistances = new int[7];
    @Transient
    private int[] positiveResistances = new int[7];
    @Transient
    private int[] negativeResistances = new int[7];
    @Transient
    private int baseMana;
    @Transient
    private int baseHealth;
    @Transient
    private int bytes2;
    @Transient
    private int attackPower;
    @Transient
    private int attackPowerMod;
    @Transient
    private float attackPowerMul;

    @Transient
    private int rangedAttackPower;
    @Transient
    private int rangedAttackPowerMod;
    @Transient
    private float rangedAttackPowerMul;

    @Transient
    private final float[] rangedDemage = new float[2];

    @Transient
    private int[] powerCostMod = new int[7];
    @Transient
    private float[] powerCostMul = new float[7];

    @Transient
    private float maxHealthMul;
    @Transient
    private float hoverHeight = 1f;

    @Transient
    private final float[][] powerModifiersGroup =
            new float[Powers.values().length][ModType.values().length];

    /**
     * 
     */
    public FieldsUnit() {

        super();
        for (final Powers power : Powers.values()) {
            this.powerModifiersGroup[power.ordinal()][ModType.BASE_PCT.ordinal()] = 1f;
            this.powerModifiersGroup[power.ordinal()][ModType.TOTAL_PCT.ordinal()] = 1f;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#initBits()
     */
    @Override
    public void initBits() {

        super.initBits();
        setType(getType() | TypeMask.UNIT.getValue());
        this.bitSet.set(UnitField.UNIT_FIELD_BYTES_0.getValue());
        this.bitSet.set(UnitField.UNIT_FIELD_LEVEL.getValue());
        this.bitSet.set(UnitField.UNIT_FIELD_POWER_REGEN_FLAT_MODIFIER.getValue());
        this.bitSet.set(UnitField.UNIT_FIELD_FACTIONTEMPLATE.getValue());
        this.bitSet.set(UnitField.UNIT_FIELD_HOVERHEIGHT.getValue());

    }

    public void initBitsForCollections() {

        for (final Powers power : Powers.PLAYER_CREATE_POWERS) {
            switch (power) {
                case ENERGY:
                case RAGE:
                case FOCUS:
                case RUNE:
                case HEALTH:
                case MANA:
                    this.bitSet.set(UnitField.UNIT_FIELD_HEALTH.getValue() + power.ordinal());
                    this.bitSet.set(UnitField.UNIT_FIELD_MAXHEALTH.getValue() + power.ordinal());
                break;
                default:
                break;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#getTypeId()
     */
    @Override
    public TypeID getTypeId() {

        return TypeID.UNIT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.subentities.ItemObject#writeValuesUpdate(java.nio.ByteBuffer
     * )
     */
    @Override
    public ChannelBuffer writeValuesUpdate() {

        final ChannelBuffer ocBuffer = super.writeValuesUpdate();

        if (this.bitSet.get(UnitField.UNIT_FIELD_BYTES_0.getValue())) {
            ocBuffer.writeInt(getBytes());
        };
        for (final Powers power : Powers.values()) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_HEALTH.getValue() + power.ordinal())) {
                ocBuffer.writeInt(getPowers().getPower(power));
            }
        }
        for (final Powers power : Powers.values()) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_MAXHEALTH.getValue() + power.ordinal())) {
                ocBuffer.writeInt(getPowers().getMaxPower(power));
            }
        }
        for (final Entry<Byte, UnitRegenModifier> mod : this.powerRegenModifier.entrySet()) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_POWER_REGEN_FLAT_MODIFIER.getValue() +
                mod.getKey())) {
                ocBuffer.writeFloat(mod.getValue().getFlat());
            }
        }
        for (final Entry<Byte, UnitRegenModifier> mod : this.powerRegenModifier.entrySet()) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_POWER_REGEN_INTERRUPTED_FLAT_MODIFIER.getValue() +
                mod.getKey())) {
                ocBuffer.writeFloat(mod.getValue().getInterrupted());
            }
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_LEVEL.getValue())) {
            ocBuffer.writeInt(getLevel());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_FACTIONTEMPLATE.getValue())) {
            ocBuffer.writeInt(getFaction_template());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_FLAGS.getValue())) {
            ocBuffer.writeInt(getFlags());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_FLAGS_2.getValue())) {
            ocBuffer.writeInt(getFlags2());
        }

        for (int i = 0; i < 3; i++) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_BASEATTACKTIME.getValue() + i)) {
                ocBuffer.writeInt(getAttackTime()[i]);
            }
        }

        if (this.bitSet.get(UnitField.UNIT_FIELD_BOUNDINGRADIUS.getValue())) {
            ocBuffer.writeFloat(getBoundingRadius());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_COMBATREACH.getValue())) {
            ocBuffer.writeFloat(getCombatReach());
        }
        for (int i = 0; i < 3; i++) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_DISPLAYID.getValue() + i)) {
                ocBuffer.writeInt(getDisplayIds()[i]);
            }
        }
        for (int i = 0; i < 2; i++) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_MINDAMAGE.getValue() + i)) {
                ocBuffer.writeFloat(getMainDemage()[i]);
            }
        }
        if (this.bitSet.get(UnitField.UNIT_MOD_CAST_SPEED.getValue())) {
            ocBuffer.writeFloat(getModCastSpeed());
        }

        for (final Stats stat : Stats.values()) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_STAT0.getValue() + stat.ordinal())) {
                ocBuffer.writeInt(getStat(stat));
            }
        }
        for (int i = 0; i < 7; i++) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_RESISTANCES.getValue() + i)) {
                ocBuffer.writeInt(getResistances()[i]);
            }
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_BASE_MANA.getValue())) {
            ocBuffer.writeInt(getBaseMana());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_BASE_HEALTH.getValue())) {
            ocBuffer.writeInt(getBaseHealth());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_BYTES_2.getValue())) {
            ocBuffer.writeInt(getBytes2());
        }

        if (this.bitSet.get(UnitField.UNIT_FIELD_ATTACK_POWER.getValue())) {
            ocBuffer.writeInt(getAttackPower());
        }
        if (this.bitSet.get(UnitField.UNIT_FIELD_RANGED_ATTACK_POWER.getValue())) {
            ocBuffer.writeInt(getRangedAttackPower());
        }

        for (int i = 0; i < 2; i++) {
            if (this.bitSet.get(UnitField.UNIT_FIELD_MINRANGEDDAMAGE.getValue() + i)) {
                ocBuffer.writeFloat(getRangedDemage()[i]);
            }
        }

        if (this.bitSet.get(UnitField.UNIT_FIELD_HOVERHEIGHT.getValue())) {
            ocBuffer.writeFloat(getHoverHeight());
        }
        return ocBuffer;
    }

    public void setRace(final Races race) {

        setBytes((getBytes() & 0xFFFFFF00) | (race.getValue()));
    }

    public Races getRace() {

        return Races.get(getBytes() & 0xFF);
    }

    public void setClazz(final Classes clazz) {

        this.setBytes((getBytes() & 0xFFFF00FF) | (clazz.getValue() << 8));
    }

    public Classes getClazz() {

        return Classes.get((getBytes() >> 8) & 0xFF);
    }

    public void setGender(final Gender gender) {

        setBytes((getBytes() & ~(0xFF << 16)) | (gender.getValue() << 16));
    }

    public Gender getGender() {

        return Gender.get((getBytes() >> 16) & 0xFF);
    }

    public void setPowerType(final int power) {

        setBytes((getBytes() & ~(0xFF << 24)) | (power << 24));
    }

    /**
     * @return the charm
     */
    public final long getCharm() {

        return this.charm;
    }

    /**
     * @param charm
     *        the charm to set
     */
    public final void setCharm(final long charm) {

        this.charm = charm;
    }

    /**
     * @return the summon
     */
    public final long getSummon() {

        return this.summon;
    }

    /**
     * @param summon
     *        the summon to set
     */
    public final void setSummon(final long summon) {

        this.summon = summon;
    }

    /**
     * @return the critter
     */
    public final long getCritter() {

        return this.critter;
    }

    /**
     * @param critter
     *        the critter to set
     */
    public final void setCritter(final long critter) {

        this.critter = critter;
    }

    /**
     * @return the charmedBy
     */
    public final long getCharmedBy() {

        return this.charmedBy;
    }

    /**
     * @param charmedBy
     *        the charmedBy to set
     */
    public final void setCharmedBy(final long charmedBy) {

        this.charmedBy = charmedBy;
    }

    /**
     * @return the summonedBy
     */
    public final long getSummonedBy() {

        return this.summonedBy;
    }

    /**
     * @param summonedBy
     *        the summonedBy to set
     */
    public final void setSummonedBy(final long summonedBy) {

        this.summonedBy = summonedBy;
    }

    /**
     * @return the createdBy
     */
    public final long getCreatedBy() {

        return this.createdBy;
    }

    /**
     * @param createdBy
     *        the createdBy to set
     */
    public final void setCreatedBy(final long createdBy) {

        this.createdBy = createdBy;
    }

    /**
     * @return the target
     */
    public final long getTarget() {

        return this.target;
    }

    /**
     * @param target
     *        the target to set
     */
    public final void setTarget(final long target) {

        this.target = target;
    }

    /**
     * @return the channelObject
     */
    public final long getChannelObject() {

        return this.channelObject;
    }

    /**
     * @param channelObject
     *        the channelObject to set
     */
    public final void setChannelObject(final long channelObject) {

        this.channelObject = channelObject;
    }

    /**
     * @return the channelSpell
     */
    public final int getChannelSpell() {

        return this.channelSpell;
    }

    /**
     * @param channelSpell
     *        the channelSpell to set
     */
    public final void setChannelSpell(final int channelSpell) {

        this.channelSpell = channelSpell;
    }

    /**
     * @return the bytes
     */
    public abstract int getBytes();

    /**
     * @param bytes
     *        the bytes to set
     */
    public void setBytes(final int bytes) {

        this.bitSet.set(UnitField.UNIT_FIELD_BYTES_0.getValue());
    }

    /**
     * @return the powers
     */
    public abstract CreaturePowers getPowers();

    /**
     * @param powers
     *        the powers to set
     */
    public abstract void setPowers(final CreaturePowers powers);

    /**
     * @param powers
     *        the powers to set
     */
    public void setPower(final Powers power, final int value) {

        this.bitSet.set(UnitField.UNIT_FIELD_HEALTH.getValue() + power.ordinal());
        getPowers().setPower(power, value);
    }

    /**
     * @param powers
     *        the powers to set
     */
    public final void setCreatePower(final Powers power, final int value) {

        System.out.println("set create power " + power + " " + value);
        getPowers().setCreatePower(power, value);
    }

    /**
     * @param powers
     *        the powers to set
     */
    public final void setMaxPower(final Powers power, final int value) {

        this.bitSet.set(UnitField.UNIT_FIELD_MAXHEALTH.getValue() + power.ordinal());
        getPowers().setMaxPower(power, value);
    }

    public final Powers getPowerType() {

        switch (getClazz()) {
            case DEATH_KNIGHT:
                return Powers.RUNIC_POWER;
            case ROGUE:
                return Powers.ENERGY;
            case WARRIOR:
                return Powers.RAGE;
            default:
                return Powers.MANA;
        }
    }

    /**
     * @return the powerRegenModifier
     */
    public final Map<Byte, UnitRegenModifier> getPowerRegenModifier() {

        return this.powerRegenModifier;
    }

    /**
     * @param powerRegenModifier
     *        the powerRegenModifier to set
     */
    public final void setPowerRegenModifier(final Map<Byte, UnitRegenModifier> powerRegenModifier) {

        this.powerRegenModifier = powerRegenModifier;
    }

    /**
     * @return the level
     */
    public abstract int getLevel();

    /**
     * @param level
     *        the level to set
     */
    public void setLevel(final int level) {
        this.bitSet.set(UnitField.UNIT_FIELD_LEVEL.getValue());
    }

    /**
     * @return the faction_template
     */
    public final int getFaction_template() {

        return this.faction_template;
    }

    /**
     * @param faction_template
     *        the faction_template to set
     */
    public final void setFaction_template(final int faction_template) {

        this.faction_template = faction_template;
    }

    /**
     * @return the virtualItems
     */
    public final int[] getVirtualItems() {

        return this.virtualItems;
    }

    /**
     * @param virtualItems
     *        the virtualItems to set
     */
    public final void setVirtualItems(final int[] virtualItems) {

        this.virtualItems = virtualItems;
    }

    /**
     * @return the flags
     */
    public final int getFlags() {

        return this.flags;
    }

    /**
     * @param flags
     *        the flags to set
     */
    public final void setFlags(final int flags) {

        this.bitSet.set(UnitField.UNIT_FIELD_FLAGS.getValue());
        this.flags = flags;
    }

    /**
     * @return the flags2
     */
    public final int getFlags2() {

        return this.flags2;
    }

    /**
     * @param flags2
     *        the flags2 to set
     */
    public final void setFlags2(final int flags2) {

        this.bitSet.set(UnitField.UNIT_FIELD_FLAGS_2.getValue());
        this.flags2 = flags2;
    }

    /**
     * @return the aurastate
     */
    public final int getAurastate() {

        return this.aurastate;
    }

    /**
     * @param aurastate
     *        the aurastate to set
     */
    public final void setAurastate(final int aurastate) {

        this.aurastate = aurastate;
    }

    /**
     * @return the attackTime
     */
    public final int[] getAttackTime() {

        return this.attackTime;
    }

    /**
     * @param attackTime
     *        the attackTime to set
     */
    public final void setAttackTime(final int type, final int attackTime) {

        this.bitSet.set(UnitField.UNIT_FIELD_BASEATTACKTIME.getValue() + type);
        this.attackTime[type] = attackTime;
    }

    /**
     * @return the boundingRadius
     */
    public final float getBoundingRadius() {

        return this.boundingRadius;
    }

    /**
     * @param boundingRadius
     *        the boundingRadius to set
     */
    public final void setBoundingRadius(final float boundingRadius) {

        this.bitSet.set(UnitField.UNIT_FIELD_BOUNDINGRADIUS.getValue());
        this.boundingRadius = boundingRadius;
    }

    /**
     * @return the combatReach
     */
    public final float getCombatReach() {

        return this.combatReach;
    }

    /**
     * @param combatReach
     *        the combatReach to set
     */
    public final void setCombatReach(final float combatReach) {

        this.bitSet.set(UnitField.UNIT_FIELD_COMBATREACH.getValue());
        this.combatReach = combatReach;
    }

    /**
     * @return the displayIds
     */
    public final int[] getDisplayIds() {

        return this.displayIds;
    }

    /**
     * @param displayId
     *        the displayIds to set
     */
    public final void setDisplayId(final ModelType modelType, final int displayId) {

        this.bitSet.set(UnitField.UNIT_FIELD_DISPLAYID.getValue() + modelType.ordinal());
        this.displayIds[modelType.ordinal()] = displayId;
    }

    /**
     * @return the mainDemage
     */
    public final float[] getMainDemage() {

        return this.mainDemage;
    }

    /**
     * @param mainDemage
     *        the mainDemage to set
     */
    public final void setMainDemage(final int demageType, final float mainDemage) {

        this.bitSet.set(UnitField.UNIT_FIELD_MINDAMAGE.getValue() + demageType);
        this.mainDemage[demageType] = mainDemage;
    }

    /**
     * @return the offDemage
     */
    public final float[] getOffDemage() {

        return this.offDemage;
    }

    /**
     * @param offDemage
     *        the offDemage to set
     */
    public final void setOffDemage(final float[] offDemage) {

        this.offDemage = offDemage;
    }

    /**
     * @return the bytes1
     */
    public final int getBytes1() {

        return this.bytes1;
    }

    /**
     * @param bytes1
     *        the bytes1 to set
     */
    public final void setBytes1(final int bytes1) {

        this.bytes1 = bytes1;
    }

    /**
     * @return the petNumber
     */
    public final int getPetNumber() {

        return this.petNumber;
    }

    /**
     * @param petNumber
     *        the petNumber to set
     */
    public final void setPetNumber(final int petNumber) {

        this.petNumber = petNumber;
    }

    /**
     * @return the petNameTimeStamp
     */
    public final int getPetNameTimeStamp() {

        return this.petNameTimeStamp;
    }

    /**
     * @param petNameTimeStamp
     *        the petNameTimeStamp to set
     */
    public final void setPetNameTimeStamp(final int petNameTimeStamp) {

        this.petNameTimeStamp = petNameTimeStamp;
    }

    /**
     * @return the petExperience
     */
    public final int getPetExperience() {

        return this.petExperience;
    }

    /**
     * @param petExperience
     *        the petExperience to set
     */
    public final void setPetExperience(final int petExperience) {

        this.petExperience = petExperience;
    }

    /**
     * @return the petNextLevelXp
     */
    public final int getPetNextLevelXp() {

        return this.petNextLevelXp;
    }

    /**
     * @param petNextLevelXp
     *        the petNextLevelXp to set
     */
    public final void setPetNextLevelXp(final int petNextLevelXp) {

        this.petNextLevelXp = petNextLevelXp;
    }

    /**
     * @return the dynamicFlags
     */
    public final int getDynamicFlags() {

        return this.dynamicFlags;
    }

    /**
     * @param dynamicFlags
     *        the dynamicFlags to set
     */
    public final void setDynamicFlags(final int dynamicFlags) {

        this.dynamicFlags = dynamicFlags;
    }

    /**
     * @return the modCastSpeed
     */
    public final float getModCastSpeed() {

        return this.modCastSpeed;
    }

    /**
     * @param modCastSpeed
     *        the modCastSpeed to set
     */
    public final void setModCastSpeed(final float modCastSpeed) {

        this.bitSet.set(UnitField.UNIT_MOD_CAST_SPEED.getValue());
        this.modCastSpeed = modCastSpeed;
    }

    /**
     * @return the createdBySpell
     */
    public final int getCreatedBySpell() {

        return this.createdBySpell;
    }

    /**
     * @param createdBySpell
     *        the createdBySpell to set
     */
    public final void setCreatedBySpell(final int createdBySpell) {

        this.createdBySpell = createdBySpell;
    }

    /**
     * @return the npcFlags
     */
    public final int getNpcFlags() {

        return this.npcFlags;
    }

    /**
     * @param npcFlags
     *        the npcFlags to set
     */
    public final void setNpcFlags(final int npcFlags) {

        this.npcFlags = npcFlags;
    }

    /**
     * @return the npcEmoteState
     */
    public final int getNpcEmoteState() {

        return this.npcEmoteState;
    }

    /**
     * @param npcEmoteState
     *        the npcEmoteState to set
     */
    public final void setNpcEmoteState(final int npcEmoteState) {

        this.npcEmoteState = npcEmoteState;
    }

    /**
     * @param stat
     * @return the stat
     */
    public final int getStat(final Stats stat) {

        return this.stat[stat.ordinal()];
    }

    /**
     * @param stat
     *        the stat to set
     */
    public final void setStat(final Stats stat, final int value) {

        this.bitSet.set(UnitField.UNIT_FIELD_STAT0.getValue() + stat.ordinal());
        this.stat[stat.ordinal()] = value;
    }

    /**
     * @param stat
     *        the stat to set
     */
    public final void setCreateStat(final Stats stat, final int value) {

        this.createStat[stat.ordinal()] = value;
    }

    public float getModifierValue(final Powers power, final ModType modifierType) {

        return this.powerModifiersGroup[power.ordinal()][modifierType.ordinal()];
    }

    public void setModifierValue(final Powers power, final ModType modifierType, final float value) {

        this.powerModifiersGroup[power.ordinal()][modifierType.ordinal()] = value;
    }

    /**
     * @return the positiveStat
     */
    public final int[] getPositiveStat() {

        return this.positiveStat;
    }

    /**
     * @param positiveStat
     *        the positiveStat to set
     */
    public final void setPositiveStat(final int[] positiveStat) {

        this.positiveStat = positiveStat;
    }

    /**
     * @return the negativeStat
     */
    public final int[] getNegativeStat() {

        return this.negativeStat;
    }

    /**
     * @param negativeStat
     *        the negativeStat to set
     */
    public final void setNegativeStat(final int[] negativeStat) {

        this.negativeStat = negativeStat;
    }

    /**
     * @return the resistances
     */
    public final int[] getResistances() {

        return this.resistances;
    }

    /**
     * @param resistances
     *        the resistances to set
     */
    public final void setResistances(final int resistance, final int value) {

        this.bitSet.set(UnitField.UNIT_FIELD_RESISTANCES.getValue() + resistance);
        this.resistances[resistance] = value;
    }

    /**
     * @return the positiveResistances
     */
    public final int[] getPositiveResistances() {

        return this.positiveResistances;
    }

    /**
     * @param positiveResistances
     *        the positiveResistances to set
     */
    public final void setPositiveResistances(final int[] positiveResistances) {

        this.positiveResistances = positiveResistances;
    }

    /**
     * @return the negativeResistances
     */
    public final int[] getNegativeResistances() {

        return this.negativeResistances;
    }

    /**
     * @param negativeResistances
     *        the negativeResistances to set
     */
    public final void setNegativeResistances(final int[] negativeResistances) {

        this.negativeResistances = negativeResistances;
    }

    /**
     * @return the baseMana
     */
    public final int getBaseMana() {

        return this.baseMana;
    }

    /**
     * @param baseMana
     *        the baseMana to set
     */
    public final void setBaseMana(final int baseMana) {

        this.bitSet.set(UnitField.UNIT_FIELD_BASE_MANA.getValue());
        this.baseMana = baseMana;
    }

    /**
     * @return the baseHealth
     */
    public final int getBaseHealth() {

        return this.baseHealth;
    }

    /**
     * @param baseHealth
     *        the baseHealth to set
     */
    public final void setBaseHealth(final int baseHealth) {

        this.bitSet.set(UnitField.UNIT_FIELD_BASE_HEALTH.getValue());
        this.baseHealth = baseHealth;
    }

    /**
     * @return the bytes2
     */
    public final int getBytes2() {

        return this.bytes2;
    }

    /**
     * @param bytes2
     *        the bytes2 to set
     */
    public final void setBytes2(final int bytes2) {

        this.bitSet.set(UnitField.UNIT_FIELD_BYTES_2.getValue());
        this.bytes2 = bytes2;
    }

    /**
     * @return the attackPower
     */
    public final int getAttackPower() {

        return this.attackPower;
    }

    /**
     * @param attackPower
     *        the attackPower to set
     */
    public final void setAttackPower(final int attackPower) {

        this.bitSet.set(UnitField.UNIT_FIELD_ATTACK_POWER.getValue());
        this.attackPower = attackPower;
    }

    /**
     * @return the attackPowerMod
     */
    public final int getAttackPowerMod() {

        return this.attackPowerMod;
    }

    /**
     * @param attackPowerMod
     *        the attackPowerMod to set
     */
    public final void setAttackPowerMod(final int attackPowerMod) {

        this.attackPowerMod = attackPowerMod;
    }

    /**
     * @return the attackPowerMul
     */
    public final float getAttackPowerMul() {

        return this.attackPowerMul;
    }

    /**
     * @param attackPowerMul
     *        the attackPowerMul to set
     */
    public final void setAttackPowerMul(final float attackPowerMul) {

        this.attackPowerMul = attackPowerMul;
    }

    /**
     * @return the rangedAttackPower
     */
    public final int getRangedAttackPower() {

        return this.rangedAttackPower;
    }

    /**
     * @param rangedAttackPower
     *        the rangedAttackPower to set
     */
    public final void setRangedAttackPower(final int rangedAttackPower) {

        this.bitSet.set(UnitField.UNIT_FIELD_RANGED_ATTACK_POWER.getValue());
        this.rangedAttackPower = rangedAttackPower;
    }

    /**
     * @return the rangedAttackPowerMod
     */
    public final int getRangedAttackPowerMod() {

        return this.rangedAttackPowerMod;
    }

    /**
     * @param rangedAttackPowerMod
     *        the rangedAttackPowerMod to set
     */
    public final void setRangedAttackPowerMod(final int rangedAttackPowerMod) {

        this.rangedAttackPowerMod = rangedAttackPowerMod;
    }

    /**
     * @return the rangedAttackPowerMul
     */
    public final float getRangedAttackPowerMul() {

        return this.rangedAttackPowerMul;
    }

    /**
     * @param rangedAttackPowerMul
     *        the rangedAttackPowerMul to set
     */
    public final void setRangedAttackPowerMul(final float rangedAttackPowerMul) {

        this.rangedAttackPowerMul = rangedAttackPowerMul;
    }

    /**
     * @return the rangedDemage
     */
    public final float[] getRangedDemage() {

        return this.rangedDemage;
    }

    /**
     * @param rangedDemage
     *        the rangedDemage to set
     */
    public final void setRangedDemage(final int type, final float rangedDemage) {

        this.bitSet.set(UnitField.UNIT_FIELD_MINRANGEDDAMAGE.getValue() + type);
        this.rangedDemage[type] = rangedDemage;
    }

    /**
     * @return the powerCostMod
     */
    public final int[] getPowerCostMod() {

        return this.powerCostMod;
    }

    /**
     * @param powerCostMod
     *        the powerCostMod to set
     */
    public final void setPowerCostMod(final int[] powerCostMod) {

        this.powerCostMod = powerCostMod;
    }

    /**
     * @return the powerCostMul
     */
    public final float[] getPowerCostMul() {

        return this.powerCostMul;
    }

    /**
     * @param powerCostMul
     *        the powerCostMul to set
     */
    public final void setPowerCostMul(final float[] powerCostMul) {

        this.powerCostMul = powerCostMul;
    }

    /**
     * @return the maxHealthMul
     */
    public final float getMaxHealthMul() {

        return this.maxHealthMul;
    }

    /**
     * @param maxHealthMul
     *        the maxHealthMul to set
     */
    public final void setMaxHealthMul(final float maxHealthMul) {

        this.maxHealthMul = maxHealthMul;
    }

    /**
     * @return the hoverHeight
     */
    public final float getHoverHeight() {

        return this.hoverHeight;
    }

    /**
     * @param hoverHeight
     *        the hoverHeight to set
     */
    public final void setHoverHeight(final float hoverHeight) {

        this.hoverHeight = hoverHeight;
    }

    /**
     * @return the name
     */
    public abstract String getName();

    /**
     * @param name
     *        the name to set
     */
    public abstract void setName(String name);

}
