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
package org.jmangos.commons.entities;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import javolution.util.FastMap;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.enums.EnchantmentSlot;
import org.jmangos.commons.enums.EquipmentSlots;
import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.enums.InventorySlots;
import org.jmangos.commons.enums.ItemBondingsCondition;
import org.jmangos.commons.enums.ItemClass;
import org.jmangos.commons.enums.ItemFlags;
import org.jmangos.commons.enums.ModType;
import org.jmangos.commons.enums.Powers;
import org.jmangos.commons.enums.RestState;
import org.jmangos.commons.enums.Stats;
import org.jmangos.commons.enums.TypeID;
import org.jmangos.commons.enums.TypeMask;
import org.jmangos.commons.enums.UnitFlags;
import org.jmangos.commons.enums.UnitFlags2;
import org.jmangos.commons.enums.UpdateType;
import org.jmangos.commons.enums.VisibilityState;
import org.jmangos.commons.model.CanUseSpell;
import org.jmangos.commons.model.UpdateBlock;
import org.jmangos.commons.model.player.Player;
import org.jmangos.commons.update.PlayerFields;
import org.jmangos.commons.update.UnitField;

/**
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "fields_player")
public class CharacterData extends FieldsUnit implements CanUseSpell {

    /**
     * 
     */
    private static final long serialVersionUID = 4154179927325225965L;

    @Transient
    private Player player;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @MapKeyColumn(name = "spellId", nullable = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "characterId")
    private final Map<Integer, CharacterSpell> spells = new FastMap<Integer, CharacterSpell>();

    @OneToMany(fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "character",
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy("button")
    private final List<CharacterButton> actionButtons = new LinkedList<CharacterButton>();

    @OneToMany(fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "character",
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy("faction")
    private final List<CharacterReputation> reputations = new LinkedList<CharacterReputation>();

    @OneToOne(targetEntity = CharacterPositionerHolder.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    CharacterPositionerHolder movement;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "contained")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @MapKeyColumn(name = "slot", nullable = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private final Map<Integer, FieldsItem> equipInventory = new FastMap<Integer, FieldsItem>();

    @Column(name = "atLoginFlag", nullable = true, insertable = true, updatable = true)
    private int atLoginFlag;

    @Transient
    private long lastSaveTime = System.currentTimeMillis();

    @Column(name = "bytes", nullable = true, insertable = true, updatable = true)
    private Integer bytes = 0;

    @Column(name = "level", nullable = false, insertable = true, updatable = true)
    private int level = 1;

    @Column(name = "name",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 255,
            precision = 0)
    private String name;

    @Column(name = "account",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private Long account;

    @Column(name = "actionBars",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int actionBars;

    @Column(name = "activeSpec",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int activeSpec;

    @Transient
    private long duelArbiter;

    @Column(name = "playerFlags", nullable = true, insertable = true, updatable = true)
    private int playerFlags;

    @Column(name = "guildId", nullable = true, insertable = true, updatable = true)
    private int guildId;

    @Column(name = "guildRank", nullable = true, insertable = true, updatable = true)
    private int guildRank;

    /**
     * <ol>
     * Contain in bytes:
     * <li>skin</li>
     * <li>face</li>
     * <li>hairStyle</li>
     * <li>hairColor</li>
     * </ol>
     */
    @Column(name = "playerBytes", nullable = true, insertable = true, updatable = true)
    private int playerBytes;
    /**
     * <ol>
     * Contain in bytes:
     * <li>facialHair</li>
     * <li>unk</li>
     * <li>{@link RestState}</li>
     * <li>unk</li>
     * </ol>
     */
    @Column(name = "playerBytes2", nullable = true, insertable = true, updatable = true)
    private int playerBytes2;
    /**
     * <ol>
     * Contain in bytes:
     * <li>gender in 1s bit</li>
     * <li>drink value</li>
     * <li>BattlefieldArenaFaction</li>
     * <li>unk</li>
     * </ol>
     */
    @Column(name = "playerBytes3", nullable = true, insertable = true, updatable = true)
    private int playerBytes3;

    @Transient
    private int duelTeam;

    @Transient
    private int guildTimeStamp;

    @Transient
    private final int[] questLog = new int[125];

    // visible item

    @Column(name = "chosenTitle", nullable = true, insertable = true, updatable = true)
    private int chosenTitle;

    @Transient
    private int fakeInebriation;

    @Transient
    private long farsight;

    @Column(name = "knownTitles", nullable = true, insertable = true, updatable = true)
    private final long[] knownTitles = new long[3];

    /** 8 bytes length */
    @Column(name = "knownCurrencies", nullable = true, insertable = true, updatable = true)
    private long knownCurrencies;

    @Column(name = "xp", nullable = true, insertable = true, updatable = true)
    private int xp;

    @Transient
    private int nextLevelXp;

    /** 384 integer */
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @MapKeyColumn(name = "number", nullable = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "characterId")
    protected final Map<Integer, CharacterSkill> skillInfo = new FastMap<Integer, CharacterSkill>();

    @OneToOne(targetEntity = CharacterPowers.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    CharacterPowers powers;

    @Transient
    private int characterPoints1;
    @Transient
    private int characterPoints2;

    @Transient
    private int trackCreatures;
    @Transient
    private int trackResources;

    @Transient
    private float blockMul;
    @Transient
    private float dodgeMul;
    @Transient
    private float parryMul;

    @Transient
    private int experties;
    @Transient
    private int offHandExperties;

    @Transient
    private float critPercentage;
    @Transient
    private float rangedCritPercentage;
    @Transient
    private float offHandCritPercentage;
    @Transient
    private final float[] spellCritPercentage = new float[7];
    @Transient
    private int shieldBlock;
    @Transient
    private float shieldCritPercentage;

    @Column(name = "exploredZones",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 1024)
    private final int[] exploredZones = new int[128];

    @Transient
    private int restStateExperience;

    @Column(name = "money", nullable = false, insertable = true, updatable = true)
    private int money;

    @Transient
    private final int[] modDamageDonePos = new int[7];
    @Transient
    private final int[] modDamageDoneNeg = new int[7];
    @Transient
    private final float[] modDamageDonePct = new float[7];
    @Transient
    private int modHealingDonePos;
    @Transient
    private float modHealingPct;
    @Transient
    private float modHealingDonePct;

    @Transient
    private int modTargetResistance;
    @Transient
    private int modTargetPhysResistance;

    @Transient
    private int playerFieldBytes;

    @Column(name = "ammoId", nullable = true, insertable = true, updatable = true)
    private int ammoId;

    @Transient
    private int selfResSpell;

    @Transient
    private int pvpMedals;

    @Transient
    private final int[] baybackPrice = new int[12];
    @Transient
    private final int[] baybackTimestamp = new int[12];

    /**
     * <ol>
     * Contain 2 uint16:
     * <li>todayKills</li>
     * <li>yesterdayKills</li>
     * </ol>
     */
    @Column(name = "kills", nullable = true, insertable = true, updatable = true)
    private int kills;

    @Transient
    private int todayContribution;
    @Transient
    private int yesterdayContribution;

    @Column(name = "totalKills", nullable = true, insertable = true, updatable = true)
    private int lifeTimeHonorableKills;

    /**
     * <ol>
     * Contain in bytes:
     * <li>Add mechanic Abilities from OverrideSpellData.dbc</li>
     * <li>unk</li>
     * <li>{@link VisibilityState}</li>
     * <li>unk</li>
     * </ol>
     */
    @Transient
    private int playerFieldBytes2;

    @Column(name = "watchedFaction", nullable = true, insertable = true, updatable = true)
    private int watchedFactionIndex;

    @Transient
    private final int[] combatRating = new int[25];

    @Transient
    private final int[] arenaTeamInfo = new int[21];

    @Column(name = "totalHonorPoints", nullable = true, insertable = true, updatable = true)
    private int honorCurrency;

    @Column(name = "arenaPoints", nullable = true, insertable = true, updatable = true)
    private int arenaCurrency;

    @Transient
    private int maxLevel = 80;

    @Transient
    private final int[] dailyQuests = new int[25];

    @Transient
    private final float[] runeRegen = new float[] { 0.1f, 0.1f, 0.1f, 0.1f };

    @Transient
    private final int[] noReagentCost = new int[3];

    @Transient
    private final int[] glyphSlots = new int[] { 21, 22, 23, 24, 25, 26 };

    @Transient
    private final int[] glyph = new int[6];

    @Transient
    private int glyphsEnabled;
    @Transient
    private int petSpellPower;

    /**
     * @return the inventory
     */
    public final Map<Integer, FieldsItem> getInventory() {

        return this.equipInventory;
    }

    public void addSpell(final SpellEntity spell) {

        spell.onAdd(this);
    }

    public void removeSpell(final SpellEntity spell) {
        if (getSpells().containsKey(spell.getId())) {
            getSpells().remove(spell.getId());
            spell.onRemove(this);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsUnit#setGender(Gender)
     */
    @Override
    public void setGender(final Gender gender) {

        super.setGender(gender);
        setPlayerBytes3(getPlayerBytes3() | (0x1 & gender.getValue()));

    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsUnit#initBits()
     */
    @Override
    public void initBits() {

        super.initBits();
        setType(getType() | TypeMask.PLAYER.getValue());

        final EnumSet<Powers> usedPower = EnumSet.of(Powers.HEALTH, getPowerType());
        for (final Powers powers : usedPower) {
            this.bitSet.set(UnitField.UNIT_FIELD_HEALTH.getValue() + powers.ordinal());
            this.bitSet.set(UnitField.UNIT_FIELD_MAXHEALTH.getValue() + powers.ordinal());
        }

        this.bitSet.set(PlayerFields.PLAYER_BYTES.getValue());
        this.bitSet.set(PlayerFields.PLAYER_BYTES_2.getValue());
        setFlags(UnitFlags.PVP_ATTACKABLE.getValue());
        setFlags2(UnitFlags2.UNIT_FLAG2_REGENERATE_POWER.getValue());
        setAttackTime(0, 2900);
        setAttackTime(1, 2000);
        setAttackTime(2, 2000);
        setBoundingRadius(0.306f);
        setCombatReach(1.5f);
        setMainDemage(0, 7.1428576f);
        setMainDemage(1, 9.142858f);
        setPlayerBytes3(0);
        setResistances(0, 45);
        setAttackPower(20);
        setRangedAttackPower(10);
        setDodgeMul(4.8438873f);
        setCritPercentage(4.8405f);
        setRangedCritPercentage(4.8405f);
        setOffHandCritPercentage(4.8405f);
        setCharacterPoints2(2);
        for (int i = 0; i < 7; i++) {
            setModDamageDonePct(i, 1f);
        }
        for (int i = 1; i < 7; i++) {
            setSpellCritPercentage(i, 4.9995003f);
        }
        setExploredZones(3, 536870912);
        setModHealingDonePct(1f);
        setModHealingPct(1f);
        setModDamageDonePct(0, 1f);
        setRangedDemage(0, 2.4285715f);
        setRangedDemage(1, 3.4285715f);

        for (int i = 0; i < 4; i++) {
            this.bitSet.set(PlayerFields.PLAYER_RUNE_REGEN_1.getValue() + i);
        }

        for (int i = 0; i < 6; i++) {
            this.bitSet.set(PlayerFields.PLAYER_FIELD_GLYPH_SLOTS_1.getValue() + i);
        }

    }

    @SuppressWarnings("unused")
    @Override
    public void initBitsForCollections() {

        super.initBitsForCollections();

        for (final Entry<Integer, FieldsItem> equips : getInventory().entrySet()) {
            final EquipmentSlots slot = EquipmentSlots.get(equips.getKey());
            if ((slot != null) && EquipmentSlots.ITEMS.contains(slot)) {
                this.bitSet.set(PlayerFields.PLAYER_VISIBLE_ITEM_1_ENTRYID.getValue() +
                    (slot.ordinal() * 2));
                if ((equips.getValue().getEnchants().get(EnchantmentSlot.PERM) != null) ||
                    (equips.getValue().getEnchants().get(EnchantmentSlot.TEMP) != null)) {
                    this.bitSet.set(PlayerFields.PLAYER_VISIBLE_ITEM_1_ENCHANTMENT.getValue() +
                        (slot.ordinal() * 2));
                }
            }
            this.bitSet.set(PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.getValue() +
                (equips.getKey() * 2));
            this.bitSet.set(PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.getValue() +
                (equips.getKey() * 2) +
                1);
        }
        for (Integer i = 0; i < this.skillInfo.size(); i++) {
            this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + (i * 3));
            if ((getSkillInfo().get(i).getCurrentValue() > 0) ||
                (getSkillInfo().get(i).getMaxValue() > 0)) {
                this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + (i * 3) + 1);
            }
            // TODO: Need check proper data.
            if (false) {
                this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + (i * 3) + 2);
            }
        }
    }

    public void updateMaxPowers() {

        int value = 0;
        for (final Powers power : Powers.PLAYER_CREATE_POWERS) {
            value = getPowers().getCreatePower(power);

            value += getModifierValue(power, ModType.BASE_FLAT);
            value *= getModifierValue(power, ModType.BASE_PCT);
            value += getModifierValue(power, ModType.TOTAL_FLAT) + getBonusPowerValue(power);
            value *= getModifierValue(power, ModType.TOTAL_PCT);

            getPowers().setMaxPower(power, value);
        }
    }

    private int getBonusPowerValue(final Powers power) {

        switch (power) {
            case HEALTH:
                final int stamina = getStat(Stats.STAMINA);

                final int baseStam = stamina < 20 ? stamina : 20;
                final int moreStam = stamina - baseStam;

                return baseStam + (moreStam * 10);
            case MANA:
                if (getPowerType() == Powers.MANA) {
                    final int intellect = getStat(Stats.INTELLECT);

                    final int baseInt = (intellect < 20) ? intellect : 20;
                    final int moreInt = intellect - baseInt;

                    return baseInt + (moreInt * 15);
                }
                return 0;
            default:
                return 0;
        }
    }

    @Override
    public BasicPositionerHolder getMovement() {

        return this.movement;
    }

    /**
     * @param movement
     *        the movement to set
     */
    public final void setMovement(final CharacterPositionerHolder movement) {

        this.movement = movement;
    }

    @Override
    public void buildCreateBlock(final UpdateBlock update, final CharacterData characterData) {

        if (this == characterData) {
            for (final Entry<Integer, FieldsItem> equips : getInventory().entrySet()) {
                equips.getValue().buildCreateBlock(update, characterData);
            }
        }
        super.buildCreateBlock(update, characterData);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsObject#getTypeId()
     */
    @Override
    public TypeID getTypeId() {

        return TypeID.PLAYER;
    }

    @Override
    protected UpdateType getCreateUpdateType() {

        return UpdateType.CREATE_OBJECT2;
    }

    public void equipItem(final EquipmentSlots equipmentSlots, final FieldsItem item) {

        item.setContained(getGuid());
        item.setOwner(getGuid());
        if (getInventory().containsKey(equipmentSlots.ordinal())) {
            final FieldsItem lastEquipItem = getInventory().get(equipmentSlots.ordinal());
            addToInventory(lastEquipItem);
        }

        getInventory().put(equipmentSlots.ordinal(), item);

        if (EquipmentSlots.ITEMS.contains(equipmentSlots)) {
            this.bitSet.set(PlayerFields.PLAYER_VISIBLE_ITEM_1_ENTRYID.getValue() +
                (equipmentSlots.ordinal() * 2));
            if ((item.getEnchants().get(EnchantmentSlot.PERM) != null) ||
                (item.getEnchants().get(EnchantmentSlot.TEMP) != null)) {
                this.bitSet.set(PlayerFields.PLAYER_VISIBLE_ITEM_1_ENCHANTMENT.getValue() +
                    (equipmentSlots.ordinal() * 2));
            }
        }
        this.bitSet.set(PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.getValue() +
            (equipmentSlots.ordinal() * 2));
        this.bitSet.set(PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.getValue() +
            (equipmentSlots.ordinal() * 2) +
            1);
        if (item.getPrototype().getBonding() == ItemBondingsCondition.WHEN_EQUIPPED.ordinal()) {
            item.addFlags(ItemFlags.BINDED.getValue());
        }

    }

    public boolean addToInventory(final FieldsItem item) {

        item.setOwner(getGuid());
        final Integer slot = getFreeSlotInPack();
        boolean success = false;
        if (slot != null) {
            item.setContained(getGuid());
            getInventory().put(slot, item);
            success = true;
        }

        if (!success) {
            for (final EquipmentSlots bag : EquipmentSlots.BAGS) {
                if (getInventory().containsKey(bag.ordinal())) {
                    final FieldsContainer curbag =
                            (FieldsContainer) getInventory().get(bag.ordinal());
                    if (curbag.addToInventory(item)) {
                        success = true;
                        break;
                    }
                }
            }
        }

        if (success &&
            (item.getPrototype().getBonding() == ItemBondingsCondition.WHEN_PICKED_UP.ordinal())) {
            item.addFlags(ItemFlags.BINDED.getValue());
        }
        return success;
    }

    private Integer getFreeSlotInPack() {

        for (Integer i = InventorySlots.ITEM_START.getValue(); i < InventorySlots.ITEM_END.getValue(); i++) {
            if (!getInventory().containsKey(i)) {
                return i;
            }
        }
        return null;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsObject#writeValuesUpdate()
     */
    @Override
    public ChannelBuffer writeValuesUpdate() {

        final ChannelBuffer ocBuffer = super.writeValuesUpdate();
        if (this.bitSet.get(PlayerFields.PLAYER_DUEL_ARBITER.getValue())) {
            ocBuffer.writeLong(getDuelArbiter());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_FLAGS.getValue())) {
            ocBuffer.writeInt(getPlayerFlags());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_GUILDID.getValue())) {
            ocBuffer.writeInt(getGuildId());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_GUILDRANK.getValue())) {
            ocBuffer.writeInt(getGuildRank());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_BYTES.getValue())) {
            ocBuffer.writeInt(getPlayerBytes());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_BYTES_2.getValue())) {
            ocBuffer.writeInt(getPlayerBytes2());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_BYTES_3.getValue())) {
            ocBuffer.writeInt(getPlayerBytes3());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_DUEL_TEAM.getValue())) {
            ocBuffer.writeInt(getDuelTeam());
        };
        if (this.bitSet.get(PlayerFields.PLAYER_GUILD_TIMESTAMP.getValue())) {
            ocBuffer.writeInt(getGuildTimeStamp());
        };
        for (int i = 0; i < 125; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_QUEST_LOG_1_1.getValue() + i)) {
                ocBuffer.writeInt(getQuestLog()[i]);
            }
        }
        for (final EquipmentSlots slot : EquipmentSlots.ITEMS) {

            if (this.bitSet.get(PlayerFields.PLAYER_VISIBLE_ITEM_1_ENTRYID.getValue() +
                (slot.ordinal() * 2))) {
                ocBuffer.writeInt(getInventory().get(slot.ordinal()).getEntry());
            };
            if (this.bitSet.get(PlayerFields.PLAYER_VISIBLE_ITEM_1_ENCHANTMENT.getValue() +
                (slot.ordinal() * 2))) {
                ItemEnchant enchant =
                        getInventory().get(slot.ordinal()).getEnchants().get(EnchantmentSlot.PERM);
                if (enchant != null) {
                    ocBuffer.writeShort(enchant.getEnchantId());
                } else {
                    ocBuffer.writeShort(0);
                }
                enchant =
                        getInventory().get(slot.ordinal()).getEnchants().get(EnchantmentSlot.TEMP);
                if (enchant != null) {
                    ocBuffer.writeShort(enchant.getEnchantId());
                } else {
                    ocBuffer.writeShort(0);
                }
            };
        }
        if (this.bitSet.get(PlayerFields.PLAYER_CHOSEN_TITLE.getValue())) {
            ocBuffer.writeInt(getChosenTitle());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FAKE_INEBRIATION.getValue())) {
            ocBuffer.writeInt(getFakeInebriation());
        }
        for (int i = 0; i < 150; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.getValue() + (i * 2))) {
                ocBuffer.writeLong(getInventory().get(i).getGuid());
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FARSIGHT.getValue())) {
            ocBuffer.writeLong(getFarsight());
        }
        for (int i = 0; i < 3; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER__FIELD_KNOWN_TITLES.getValue() + (i * 2))) {
                ocBuffer.writeLong(getKnownTitles()[i]);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_KNOWN_CURRENCIES.getValue())) {
            ocBuffer.writeLong(getKnownCurrencies());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_XP.getValue())) {
            ocBuffer.writeInt(getXp());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_NEXT_LEVEL_XP.getValue())) {
            ocBuffer.writeInt(getNextLevelXp());
        }
        for (Integer i = 0; i < this.skillInfo.size(); i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + (i * 3))) {
                ocBuffer.writeInt(getSkillInfo().get(i).getSkillId());
            }
            if (this.bitSet.get(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + (i * 3) + 1)) {
                ocBuffer.writeShort(getSkillInfo().get(i).getCurrentValue());
                ocBuffer.writeShort(getSkillInfo().get(i).getMaxValue());
            }
            if (this.bitSet.get(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + (i * 3) + 2)) {
                ocBuffer.writeShort(0);
                ocBuffer.writeShort(0);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_CHARACTER_POINTS1.getValue())) {
            ocBuffer.writeInt(getCharacterPoints1());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_CHARACTER_POINTS2.getValue())) {
            ocBuffer.writeInt(getCharacterPoints2());
        }

        if (this.bitSet.get(PlayerFields.PLAYER_TRACK_CREATURES.getValue())) {
            ocBuffer.writeInt(getTrackCreatures());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_TRACK_RESOURCES.getValue())) {
            ocBuffer.writeInt(getTrackResources());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_BLOCK_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getBlockMul());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_DODGE_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getDodgeMul());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_PARRY_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getParryMul());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_EXPERTISE.getValue())) {
            ocBuffer.writeInt(getExperties());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_OFFHAND_EXPERTISE.getValue())) {
            ocBuffer.writeInt(getOffHandExperties());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_CRIT_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getCritPercentage());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_RANGED_CRIT_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getRangedCritPercentage());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_OFFHAND_CRIT_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getOffHandCritPercentage());
        }

        for (int i = 0; i < 7; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_SPELL_CRIT_PERCENTAGE1.getValue() + i)) {
                ocBuffer.writeFloat(getSpellCritPercentage()[i]);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_SHIELD_BLOCK.getValue())) {
            ocBuffer.writeInt(getShieldBlock());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_SHIELD_BLOCK_CRIT_PERCENTAGE.getValue())) {
            ocBuffer.writeFloat(getShieldCritPercentage());
        }
        for (int i = 0; i < 128; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_EXPLORED_ZONES_1.getValue() + i)) {
                ocBuffer.writeInt(getExploredZones()[i]);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_REST_STATE_EXPERIENCE.getValue())) {
            ocBuffer.writeInt(getRestStateExperience());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_COINAGE.getValue())) {
            ocBuffer.writeInt(getMoney());
        }
        for (int i = 0; i < 7; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_POS.getValue() + i)) {
                ocBuffer.writeInt(getModDamageDonePos()[i]);
            }
        }
        for (int i = 0; i < 7; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_NEG.getValue() + i)) {
                ocBuffer.writeInt(getModDamageDoneNeg()[i]);
            }
        }
        for (int i = 0; i < 7; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_PCT.getValue() + i)) {
                ocBuffer.writeFloat(getModDamageDonePct()[i]);
            }
        }

        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_HEALING_DONE_POS.getValue())) {
            ocBuffer.writeInt(getModHealingDonePos());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_HEALING_PCT.getValue())) {
            ocBuffer.writeFloat(getModHealingPct());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_HEALING_DONE_PCT.getValue())) {
            ocBuffer.writeFloat(getModHealingDonePct());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_TARGET_RESISTANCE.getValue())) {
            ocBuffer.writeFloat(getModTargetResistance());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MOD_TARGET_PHYSICAL_RESISTANCE.getValue())) {
            ocBuffer.writeFloat(getModTargetPhysResistance());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_BYTES.getValue())) {
            ocBuffer.writeInt(getPlayerFieldBytes());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_AMMO_ID.getValue())) {
            ocBuffer.writeInt(getAmmoId());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_SELF_RES_SPELL.getValue())) {
            ocBuffer.writeInt(getSelfResSpell());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_PVP_MEDALS.getValue())) {
            ocBuffer.writeInt(getPvpMedals());
        }
        for (int i = 0; i < 12; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_BUYBACK_PRICE_1.getValue() + i)) {
                ocBuffer.writeInt(getBaybackPrice()[i]);
            }
        }
        for (int i = 0; i < 12; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_BUYBACK_TIMESTAMP_1.getValue() + i)) {
                ocBuffer.writeInt(getBaybackPrice()[i]);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_KILLS.getValue())) {
            // TODO fix kills to short
            ocBuffer.writeInt(getKills());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_TODAY_CONTRIBUTION.getValue())) {
            ocBuffer.writeInt(getTodayContribution());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_YESTERDAY_CONTRIBUTION.getValue())) {
            ocBuffer.writeInt(getYesterdayContribution());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_LIFETIME_HONORBALE_KILLS.getValue())) {
            ocBuffer.writeInt(getKills());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_BYTES2.getValue())) {
            ocBuffer.writeInt(getPlayerBytes2());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_WATCHED_FACTION_INDEX.getValue())) {
            ocBuffer.writeInt(getWatchedFactionIndex());
        }
        for (int i = 0; i < 25; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_COMBAT_RATING_1.getValue() + i)) {
                ocBuffer.writeInt(getCombatRating()[i]);
            }
        }
        for (int i = 0; i < 21; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_ARENA_TEAM_INFO_1_1.getValue() + i)) {
                ocBuffer.writeInt(getArenaTeamInfo()[i]);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_HONOR_CURRENCY.getValue())) {
            ocBuffer.writeInt(getHonorCurrency());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_ARENA_CURRENCY.getValue())) {
            ocBuffer.writeInt(getArenaCurrency());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_FIELD_MAX_LEVEL.getValue())) {
            ocBuffer.writeInt(getMaxLevel());
        }
        for (int i = 0; i < 25; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_DAILY_QUESTS_1.getValue() + i)) {
                ocBuffer.writeInt(getDailyQuests()[i]);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_RUNE_REGEN_1.getValue() + i)) {
                ocBuffer.writeFloat(getRuneRegen()[i]);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_NO_REAGENT_COST_1.getValue() + i)) {
                ocBuffer.writeInt(getNoReagentCost()[i]);
            }
        }
        for (int i = 0; i < 6; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_GLYPH_SLOTS_1.getValue() + i)) {
                ocBuffer.writeInt(getGlyphSlots()[i]);
            }
        }
        for (int i = 0; i < 6; i++) {
            if (this.bitSet.get(PlayerFields.PLAYER_FIELD_GLYPHS_1.getValue() + i)) {
                ocBuffer.writeInt(getGlyph()[i]);
            }
        }
        if (this.bitSet.get(PlayerFields.PLAYER_GLYPHS_ENABLED.getValue())) {
            ocBuffer.writeInt(getGlyphsEnabled());
        }
        if (this.bitSet.get(PlayerFields.PLAYER_PET_SPELL_POWER.getValue())) {
            ocBuffer.writeInt(getPetSpellPower());
        }
        return ocBuffer;
    }

    /**
     * @return the atLoginFlag
     */
    public int getAtLoginFlag() {

        return this.atLoginFlag;
    }

    /**
     * @param atLoginFlag
     *        the atLoginFlag to set
     */
    public void setAtLoginFlag(final int atLoginFlag) {

        this.atLoginFlag = atLoginFlag;
    }

    @Override
    public boolean addToSpellContainer(final SpellEntity spell) {
        if (!getSpells().containsKey(spell.getId())) {
            final CharacterSpell chS = new CharacterSpell();
            chS.setSpellId(spell.getId());
            getSpells().put(spell.getId(), chS);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void addProficiency(final ItemClass itemclass, final int mask) {

        // TODO Auto-generated method stub

    }

    @Override
    public void removeProficiency(final ItemClass itemclass, final int mask) {

        // TODO Auto-generated method stub

    }

    /**
     * @return the spells
     */
    public Map<Integer, CharacterSpell> getSpells() {
        return this.spells;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof CharacterData)) {
            return false;
        }
        if (((CharacterData) obj).getName().equals(getName())) {
            return true;
        }
        return false;
    }

    public void addActionButton(final CharacterButton chB) {
        this.actionButtons.add(chB);
    }

    /**
     * @return the actionBittons
     */
    public final List<CharacterButton> getActionButtons() {
        return this.actionButtons;
    }

    /**
     * @return the reputations
     */
    public final List<CharacterReputation> getReputations() {
        return this.reputations;
    }

    /**
     * @return the lastsavetime
     */
    public final long getLastSaveTime() {
        return this.lastSaveTime;
    }

    /**
     * @param lastsavetime
     *        the lastsavetime to set
     */
    public final void setLastSaveTime(final long lastsavetime) {
        this.lastSaveTime = lastsavetime;
    }

    /**
     * @return the player
     */
    public final Player getPlayer() {
        return this.player;
    }

    /**
     * @param player
     *        the player to set
     */
    public final void setPlayer(final Player player) {
        this.player = player;
    }

    /**
     * @return the account
     */
    public final Long getAccount() {

        return this.account;
    }

    /**
     * @param account
     *        the account to set
     */
    public final void setAccount(final long account) {

        this.account = account;
    }

    /**
     * @return the actionBars
     */
    public final int getActionBars() {

        return this.actionBars;
    }

    /**
     * @param actionBars
     *        the actionBars to set
     */
    public final void setActionBars(final int actionBars) {

        this.actionBars = actionBars;
    }

    /**
     * @return the activeSpec
     */
    public final int getActiveSpec() {

        return this.activeSpec;
    }

    /**
     * @param activeSpec
     *        the activeSpec to set
     */
    public final void setActiveSpec(final int activeSpec) {

        this.activeSpec = activeSpec;
    }

    /**
     * @return the duelArbiter
     */
    public final long getDuelArbiter() {

        return this.duelArbiter;
    }

    /**
     * @param duelArbiter
     *        the duelArbiter to set
     */
    public final void setDuelArbiter(final long duelArbiter) {

        this.bitSet.set(PlayerFields.PLAYER_DUEL_ARBITER.getValue());
        this.bitSet.set(PlayerFields.PLAYER_DUEL_ARBITER.getValue() + 1);
        this.duelArbiter = duelArbiter;
    }

    /**
     * @return the playerFlags
     */
    public final int getPlayerFlags() {

        return this.playerFlags;
    }

    /**
     * @param playerFlags
     *        the playerFlags to set
     */
    public final void setPlayerFlags(final int playerFlags) {

        this.bitSet.set(PlayerFields.PLAYER_FLAGS.getValue());
        this.playerFlags = playerFlags;
    }

    /**
     * @return the guildId
     */
    public final int getGuildId() {

        return this.guildId;
    }

    /**
     * @param guildId
     *        the guildId to set
     */
    public final void setGuildId(final int guildId) {

        this.bitSet.set(PlayerFields.PLAYER_GUILDID.getValue());
        this.guildId = guildId;
    }

    /**
     * @return the guildRank
     */
    public final int getGuildRank() {

        return this.guildRank;
    }

    /**
     * @param guildRank
     *        the guildRank to set
     */
    public final void setGuildRank(final int guildRank) {

        this.bitSet.set(PlayerFields.PLAYER_GUILDRANK.getValue());
        this.guildRank = guildRank;
    }

    /**
     * @return the playerBytes
     */
    public final int getPlayerBytes() {

        return this.playerBytes;
    }

    /**
     * @param playerBytes
     *        the playerBytes to set
     */
    public final void setPlayerBytes(final int playerBytes) {

        this.bitSet.set(PlayerFields.PLAYER_BYTES.getValue());
        this.playerBytes = playerBytes;
    }

    /**
     * @return the playerBytes2
     */
    public final int getPlayerBytes2() {

        return this.playerBytes2;
    }

    /**
     * @param playerBytes2
     *        the playerBytes2 to set
     */
    public final void setPlayerBytes2(final int playerBytes2) {

        this.bitSet.set(PlayerFields.PLAYER_BYTES_2.getValue());
        this.playerBytes2 = playerBytes2;
    }

    /**
     * @return the playerBytes3
     */
    public final int getPlayerBytes3() {

        return this.playerBytes3;
    }

    /**
     * @param playerBytes3
     *        the playerBytes3 to set
     */
    public final void setPlayerBytes3(final int playerBytes3) {

        this.bitSet.set(PlayerFields.PLAYER_BYTES_3.getValue());
        this.playerBytes3 = playerBytes3;
    }

    /**
     * @return the duelTeam
     */
    public final int getDuelTeam() {

        return this.duelTeam;
    }

    /**
     * @param duelTeam
     *        the duelTeam to set
     */
    public final void setDuelTeam(final int duelTeam) {

        this.bitSet.set(PlayerFields.PLAYER_DUEL_TEAM.getValue());
        this.duelTeam = duelTeam;
    }

    /**
     * @return the guildTimeStamp
     */
    public final int getGuildTimeStamp() {

        return this.guildTimeStamp;
    }

    /**
     * @param guildTimeStamp
     *        the guildTimeStamp to set
     */
    public final void setGuildTimeStamp(final int guildTimeStamp) {

        this.bitSet.set(PlayerFields.PLAYER_GUILD_TIMESTAMP.getValue());
        this.guildTimeStamp = guildTimeStamp;
    }

    /**
     * @return the questLog
     */
    public int[] getQuestLog() {

        return this.questLog;
    }

    /**
     * @param questLog
     *        the questLog to set
     */
    public void setQuestLog(final int index, final int questLog) {

        this.bitSet.set(PlayerFields.PLAYER_QUEST_LOG_1_1.getValue() + index);
        this.questLog[index] = questLog;
    }

    /**
     * @return the chosenTitle
     */
    public final int getChosenTitle() {

        return this.chosenTitle;
    }

    /**
     * @param chosenTitle
     *        the chosenTitle to set
     */
    public final void setChosenTitle(final int chosenTitle) {

        this.bitSet.set(PlayerFields.PLAYER_CHOSEN_TITLE.getValue());
        this.chosenTitle = chosenTitle;
    }

    /**
     * @return the fakeInebriation
     */
    public final int getFakeInebriation() {

        return this.fakeInebriation;
    }

    /**
     * @param fakeInebriation
     *        the fakeInebriation to set
     */
    public final void setFakeInebriation(final int fakeInebriation) {

        this.bitSet.set(PlayerFields.PLAYER_FAKE_INEBRIATION.getValue());
        this.fakeInebriation = fakeInebriation;
    }

    /**
     * @return the farsight
     */
    public final long getFarsight() {

        return this.farsight;
    }

    /**
     * @param farsight
     *        the farsight to set
     */
    public final void setFarsight(final long farsight) {

        this.bitSet.set(PlayerFields.PLAYER_FARSIGHT.getValue());
        this.bitSet.set(PlayerFields.PLAYER_FARSIGHT.getValue() + 1);
        this.farsight = farsight;
    }

    /**
     * @return the knownTitles
     */
    public final long[] getKnownTitles() {

        return this.knownTitles;
    }

    /**
     * @param knownTitles
     *        the knownTitles to set
     */
    public final void setKnownTitles(final int index, final long knownTitles) {

        this.bitSet.set(PlayerFields.PLAYER__FIELD_KNOWN_TITLES.getValue() + (index * 2));
        this.bitSet.set(PlayerFields.PLAYER__FIELD_KNOWN_TITLES.getValue() + (index * 2) + 1);
        this.knownTitles[index] = knownTitles;
    }

    /**
     * @return the knownCurrencies
     */
    public final long getKnownCurrencies() {

        return this.knownCurrencies;
    }

    /**
     * @param knownCurrencies
     *        the knownCurrencies to set
     */
    public final void setKnownCurrencies(final long knownCurrencies) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_KNOWN_CURRENCIES.getValue());
        this.bitSet.set(PlayerFields.PLAYER_FIELD_KNOWN_CURRENCIES.getValue() + 1);
        this.knownCurrencies = knownCurrencies;
    }

    /**
     * @return the xp
     */
    public final int getXp() {

        return this.xp;
    }

    /**
     * @param xp
     *        the xp to set
     */
    public final void setXp(final int xp) {

        this.bitSet.set(PlayerFields.PLAYER_XP.getValue());
        this.xp = xp;
    }

    /**
     * @return the nextLevelXp
     */
    public final int getNextLevelXp() {

        return this.nextLevelXp;
    }

    /**
     * @param nextLevelXp
     *        the nextLevelXp to set
     */
    public final void setNextLevelXp(final int nextLevelXp) {

        this.bitSet.set(PlayerFields.PLAYER_NEXT_LEVEL_XP.getValue());
        this.nextLevelXp = nextLevelXp;
    }

    /**
     * @return the skillInfo
     */
    public final CharacterSkill getSkillInfo(final int index) {

        return this.skillInfo.get(index);
    }

    /**
     * @return the skillInfo
     */
    public final Map<Integer, CharacterSkill> getSkillInfo() {

        return this.skillInfo;
    }

    /**
     * @return the skillInfo
     */
    public final CharacterSkill getSkillInfoBySkillId(final Integer skillId) {
        if (skillId == null) {
            return null;
        }
        for (final Entry<Integer, CharacterSkill> skillMap : this.skillInfo.entrySet()) {
            if (skillMap.getValue().getSkillId() == skillId) {
                return skillMap.getValue();
            }
        }
        return null;
    }

    /**
     * @return the skillInfo
     */
    public final CharacterSkill getSkillInfoBySkillClass(
            final Class<? extends CharacterSkill> langSkill) {
        for (final Entry<Integer, CharacterSkill> skillMap : this.skillInfo.entrySet()) {
            if (skillMap.getValue().getClass().equals(langSkill)) {
                return skillMap.getValue();
            }
        }
        return null;
    }

    /**
     * @param skillInfo
     *        the skillInfo to set
     */
    public final void setSkillInfo(final int skillIndex, final CharacterSkill skillValue) {

        this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + skillIndex);
        this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + skillIndex + 1);
        this.skillInfo.put(skillIndex, skillValue);
    }

    /**
     * @param skillInfo
     *        the skillInfo to set
     */
    public final void addSkillInfo(final CharacterSkill skillValue) {
        final int size = this.skillInfo.size();
        this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + size);
        this.bitSet.set(PlayerFields.PLAYER_SKILL_INFO_1_1.getValue() + size + 1);
        this.skillInfo.put(size, skillValue);
    }

    /**
     * 
     * @param skillValue
     */
    public final boolean haveSkillInfo(final int skillId) {
        for (final Entry<Integer, CharacterSkill> skillInfos : this.skillInfo.entrySet()) {
            if (skillInfos.getValue().getSkillId() == skillId) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the characterPoints1
     */
    public final int getCharacterPoints1() {

        return this.characterPoints1;
    }

    /**
     * @param characterPoints1
     *        the characterPoints1 to set
     */
    public final void setCharacterPoints1(final int characterPoints1) {

        this.bitSet.set(PlayerFields.PLAYER_CHARACTER_POINTS1.getValue());
        this.characterPoints1 = characterPoints1;
    }

    /**
     * @return the characterPoints2
     */
    public final int getCharacterPoints2() {

        return this.characterPoints2;
    }

    /**
     * @param characterPoints2
     *        the characterPoints2 to set
     */
    public final void setCharacterPoints2(final int characterPoints2) {

        this.bitSet.set(PlayerFields.PLAYER_CHARACTER_POINTS2.getValue());
        this.characterPoints2 = characterPoints2;
    }

    /**
     * @return the trackCreatures
     */
    public final int getTrackCreatures() {

        return this.trackCreatures;
    }

    /**
     * @param trackCreatures
     *        the trackCreatures to set
     */
    public final void setTrackCreatures(final int trackCreatures) {

        this.bitSet.set(PlayerFields.PLAYER_TRACK_CREATURES.getValue());
        this.trackCreatures = trackCreatures;
    }

    /**
     * @return the trackResources
     */
    public final int getTrackResources() {

        return this.trackResources;
    }

    /**
     * @param trackResources
     *        the trackResources to set
     */
    public final void setTrackResources(final int trackResources) {

        this.bitSet.set(PlayerFields.PLAYER_TRACK_RESOURCES.getValue());
        this.trackResources = trackResources;
    }

    /**
     * @return the blockMul
     */
    public final float getBlockMul() {

        return this.blockMul;
    }

    /**
     * @param blockMul
     *        the blockMul to set
     */
    public final void setBlockMul(final float blockMul) {

        this.bitSet.set(PlayerFields.PLAYER_BLOCK_PERCENTAGE.getValue());
        this.blockMul = blockMul;
    }

    /**
     * @return the dodgeMul
     */
    public final float getDodgeMul() {

        return this.dodgeMul;
    }

    /**
     * @param dodgeMul
     *        the dodgeMul to set
     */
    public final void setDodgeMul(final float dodgeMul) {

        this.bitSet.set(PlayerFields.PLAYER_DODGE_PERCENTAGE.getValue());
        this.dodgeMul = dodgeMul;
    }

    /**
     * @return the parryMul
     */
    public final float getParryMul() {

        return this.parryMul;
    }

    /**
     * @param parryMul
     *        the parryMul to set
     */
    public final void setParryMul(final float parryMul) {

        this.bitSet.set(PlayerFields.PLAYER_PARRY_PERCENTAGE.getValue());
        this.parryMul = parryMul;
    }

    /**
     * @return the experties
     */
    public final int getExperties() {

        return this.experties;
    }

    /**
     * @param experties
     *        the experties to set
     */
    public final void setExperties(final int experties) {

        this.bitSet.set(PlayerFields.PLAYER_EXPERTISE.getValue());
        this.experties = experties;
    }

    /**
     * @return the offHandExperties
     */
    public final int getOffHandExperties() {

        return this.offHandExperties;
    }

    /**
     * @param offHandExperties
     *        the offHandExperties to set
     */
    public final void setOffHandExperties(final int offHandExperties) {

        this.bitSet.set(PlayerFields.PLAYER_OFFHAND_EXPERTISE.getValue());
        this.offHandExperties = offHandExperties;
    }

    /**
     * @return the critPercentage
     */
    public final float getCritPercentage() {

        return this.critPercentage;
    }

    /**
     * @param critPercentage
     *        the critPercentage to set
     */
    public final void setCritPercentage(final float critPercentage) {

        this.bitSet.set(PlayerFields.PLAYER_CRIT_PERCENTAGE.getValue());
        this.critPercentage = critPercentage;
    }

    /**
     * @return the rangedCritPercentage
     */
    public final float getRangedCritPercentage() {

        return this.rangedCritPercentage;
    }

    /**
     * @param rangedCritPercentage
     *        the rangedCritPercentage to set
     */
    public final void setRangedCritPercentage(final float rangedCritPercentage) {

        this.bitSet.set(PlayerFields.PLAYER_RANGED_CRIT_PERCENTAGE.getValue());
        this.rangedCritPercentage = rangedCritPercentage;
    }

    /**
     * @return the offHandCritPercentage
     */
    public final float getOffHandCritPercentage() {

        return this.offHandCritPercentage;
    }

    /**
     * @param offHandCritPercentage
     *        the offHandCritPercentage to set
     */
    public final void setOffHandCritPercentage(final float offHandCritPercentage) {

        this.bitSet.set(PlayerFields.PLAYER_OFFHAND_CRIT_PERCENTAGE.getValue());
        this.offHandCritPercentage = offHandCritPercentage;
    }

    /**
     * @return the shieldBlock
     */
    public final int getShieldBlock() {

        return this.shieldBlock;
    }

    /**
     * @param shieldBlock
     *        the shieldBlock to set
     */
    public final void setShieldBlock(final int shieldBlock) {

        this.bitSet.set(PlayerFields.PLAYER_SHIELD_BLOCK.getValue());
        this.shieldBlock = shieldBlock;
    }

    /**
     * @return the shieldCritPercentage
     */
    public final float getShieldCritPercentage() {

        return this.shieldCritPercentage;
    }

    /**
     * @param shieldCritPercentage
     *        the shieldCritPercentage to set
     */
    public final void setShieldCritPercentage(final float shieldCritPercentage) {

        this.bitSet.set(PlayerFields.PLAYER_SHIELD_BLOCK_CRIT_PERCENTAGE.getValue());
        this.shieldCritPercentage = shieldCritPercentage;
    }

    /**
     * @return the exploredZones
     */
    public final int[] getExploredZones() {

        return this.exploredZones;
    }

    /**
     * @param exploredZones
     *        the exploredZones to set
     */
    public final void setExploredZones(final int index, final int exploredZones) {

        this.bitSet.set(PlayerFields.PLAYER_EXPLORED_ZONES_1.getValue() + index);
        this.exploredZones[index] = exploredZones;
    }

    /**
     * @return the restStateExperience
     */
    public final int getRestStateExperience() {

        return this.restStateExperience;
    }

    /**
     * @param restStateExperience
     *        the restStateExperience to set
     */
    public final void setRestStateExperience(final int restStateExperience) {

        this.bitSet.set(PlayerFields.PLAYER_REST_STATE_EXPERIENCE.getValue());
        this.restStateExperience = restStateExperience;
    }

    /**
     * @return the money
     */
    public final int getMoney() {

        return this.money;
    }

    /**
     * @param money
     *        the money to set
     */
    public final void setMoney(final int money) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_COINAGE.getValue());
        this.money = money;
    }

    /**
     * @return the modHealingDonePos
     */
    public final int getModHealingDonePos() {

        return this.modHealingDonePos;
    }

    /**
     * @param modHealingDonePos
     *        the modHealingDonePos to set
     */
    public final void setModHealingDonePos(final int modHealingDonePos) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MOD_HEALING_DONE_POS.getValue());
        this.modHealingDonePos = modHealingDonePos;
    }

    /**
     * @return the modHealingPct
     */
    public final float getModHealingPct() {

        return this.modHealingPct;
    }

    /**
     * @param modHealingPct
     *        the modHealingPct to set
     */
    public final void setModHealingPct(final float modHealingPct) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MOD_HEALING_PCT.getValue());
        this.modHealingPct = modHealingPct;
    }

    /**
     * @return the modHealingDonePct
     */
    public final float getModHealingDonePct() {

        return this.modHealingDonePct;
    }

    /**
     * @param modHealingDonePct
     *        the modHealingDonePct to set
     */
    public final void setModHealingDonePct(final float modHealingDonePct) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MOD_HEALING_DONE_PCT.getValue());
        this.modHealingDonePct = modHealingDonePct;
    }

    /**
     * @return the modTargetResistance
     */
    public final int getModTargetResistance() {

        return this.modTargetResistance;
    }

    /**
     * @param modTargetResistance
     *        the modTargetResistance to set
     */
    public final void setModTargetResistance(final int modTargetResistance) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MOD_TARGET_RESISTANCE.getValue());
        this.modTargetResistance = modTargetResistance;
    }

    /**
     * @return the modTargetPhysResistance
     */
    public final int getModTargetPhysResistance() {

        return this.modTargetPhysResistance;
    }

    /**
     * @param modTargetPhysResistance
     *        the modTargetPhysResistance to set
     */
    public final void setModTargetPhysResistance(final int modTargetPhysResistance) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MOD_TARGET_PHYSICAL_RESISTANCE.getValue());
        this.modTargetPhysResistance = modTargetPhysResistance;
    }

    /**
     * @return the playerFieldBytes
     */
    public final int getPlayerFieldBytes() {

        return this.playerFieldBytes;
    }

    /**
     * @param playerFieldBytes
     *        the playerFieldBytes to set
     */
    public final void setPlayerFieldBytes(final int playerFieldBytes) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_BYTES.getValue());
        this.playerFieldBytes = playerFieldBytes;
    }

    /**
     * @return the ammoId
     */
    public final int getAmmoId() {

        return this.ammoId;
    }

    /**
     * @param ammoId
     *        the ammoId to set
     */
    public final void setAmmoId(final int ammoId) {

        this.bitSet.set(PlayerFields.PLAYER_AMMO_ID.getValue());
        this.ammoId = ammoId;
    }

    /**
     * @return the selfResSpell
     */
    public final int getSelfResSpell() {

        return this.selfResSpell;
    }

    /**
     * @param selfResSpell
     *        the selfResSpell to set
     */
    public final void setSelfResSpell(final int selfResSpell) {

        this.bitSet.set(PlayerFields.PLAYER_SELF_RES_SPELL.getValue());
        this.selfResSpell = selfResSpell;
    }

    /**
     * @return the pvpMedals
     */
    public final int getPvpMedals() {

        return this.pvpMedals;
    }

    /**
     * @param pvpMedals
     *        the pvpMedals to set
     */
    public final void setPvpMedals(final int pvpMedals) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_PVP_MEDALS.getValue());
        this.pvpMedals = pvpMedals;
    }

    /**
     * @return the kills
     */
    public final int getKills() {

        return this.kills;
    }

    /**
     * @param kills
     *        the kills to set
     */
    public final void setKills(final int kills) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_KILLS.getValue());
        this.kills = kills;
    }

    /**
     * @return the todayContribution
     */
    public final int getTodayContribution() {

        return this.todayContribution;
    }

    /**
     * @param todayContribution
     *        the todayContribution to set
     */
    public final void setTodayContribution(final int todayContribution) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_TODAY_CONTRIBUTION.getValue());
        this.todayContribution = todayContribution;
    }

    /**
     * @return the yesterdayContribution
     */
    public final int getYesterdayContribution() {

        return this.yesterdayContribution;
    }

    /**
     * @param yesterdayContribution
     *        the yesterdayContribution to set
     */
    public final void setYesterdayContribution(final int yesterdayContribution) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_YESTERDAY_CONTRIBUTION.getValue());
        this.yesterdayContribution = yesterdayContribution;
    }

    /**
     * @return the lifeTimeHonorableKills
     */
    public final int getLifeTimeHonorableKills() {

        return this.lifeTimeHonorableKills;
    }

    /**
     * @param lifeTimeHonorableKills
     *        the lifeTimeHonorableKills to set
     */
    public final void setLifeTimeHonorableKills(final int lifeTimeHonorableKills) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_LIFETIME_HONORBALE_KILLS.getValue());
        this.lifeTimeHonorableKills = lifeTimeHonorableKills;
    }

    /**
     * @return the playerFieldBytes2
     */
    public final int getPlayerFieldBytes2() {

        return this.playerFieldBytes2;
    }

    /**
     * @param playerFieldBytes2
     *        the playerFieldBytes2 to set
     */
    public final void setPlayerFieldBytes2(final int playerFieldBytes2) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_BYTES2.getValue());
        this.playerFieldBytes2 = playerFieldBytes2;
    }

    /**
     * @return the watchedFactionIndex
     */
    public final int getWatchedFactionIndex() {

        return this.watchedFactionIndex;
    }

    /**
     * @param watchedFactionIndex
     *        the watchedFactionIndex to set
     */
    public final void setWatchedFactionIndex(final int watchedFactionIndex) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_WATCHED_FACTION_INDEX.getValue());
        this.watchedFactionIndex = watchedFactionIndex;
    }

    /**
     * @return the honorCurrency
     */
    public final int getHonorCurrency() {

        return this.honorCurrency;
    }

    /**
     * @param honorCurrency
     *        the honorCurrency to set
     */
    public final void setHonorCurrency(final int honorCurrency) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_HONOR_CURRENCY.getValue());
        this.honorCurrency = honorCurrency;
    }

    /**
     * @return the arenaCurrency
     */
    public final int getArenaCurrency() {

        return this.arenaCurrency;
    }

    /**
     * @param arenaCurrency
     *        the arenaCurrency to set
     */
    public final void setArenaCurrency(final int arenaCurrency) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_ARENA_CURRENCY.getValue());
        this.arenaCurrency = arenaCurrency;
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

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MAX_LEVEL.getValue());
        this.maxLevel = maxLevel;
    }

    /**
     * @return the glyphsEnabled
     */
    public final int getGlyphsEnabled() {

        return this.glyphsEnabled;
    }

    /**
     * @param glyphsEnabled
     *        the glyphsEnabled to set
     */
    public final void setGlyphsEnabled(final int glyphsEnabled) {

        this.bitSet.set(PlayerFields.PLAYER_GLYPHS_ENABLED.getValue());
        this.glyphsEnabled = glyphsEnabled;
    }

    /**
     * @return the petSpellPower
     */
    public final int getPetSpellPower() {

        return this.petSpellPower;
    }

    /**
     * @param petSpellPower
     *        the petSpellPower to set
     */
    public final void setPetSpellPower(final int petSpellPower) {

        this.bitSet.set(PlayerFields.PLAYER_PET_SPELL_POWER.getValue());
        this.petSpellPower = petSpellPower;
    }

    /**
     * @return the spellCritPercentage
     */
    public float[] getSpellCritPercentage() {

        return this.spellCritPercentage;
    }

    /**
     * @return the spellCritPercentage
     */
    public void setSpellCritPercentage(final int index, final float value) {

        this.bitSet.set(PlayerFields.PLAYER_SPELL_CRIT_PERCENTAGE1.getValue() + index);
        this.spellCritPercentage[index] = value;
    }

    /**
     * @return the modDamageDonePos
     */
    public final int[] getModDamageDonePos() {

        return this.modDamageDonePos;
    }

    /**
     * @return the modDamageDoneNeg
     */
    public final int[] getModDamageDoneNeg() {

        return this.modDamageDoneNeg;
    }

    /**
     * @return the modDamageDonePct
     */
    public final float[] getModDamageDonePct() {

        return this.modDamageDonePct;
    }

    /**
     * @return the modDamageDonePct
     */
    public final void setModDamageDonePct(final int index, final float value) {

        this.bitSet.set(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_PCT.getValue() + index);
        this.modDamageDonePct[index] = value;
    }

    /**
     * @return the baybackPrice
     */
    public final int[] getBaybackPrice() {

        return this.baybackPrice;
    }

    /**
     * @return the baybackTimestamp
     */
    public final int[] getBaybackTimestamp() {

        return this.baybackTimestamp;
    }

    /**
     * @return the combatRating
     */
    public final int[] getCombatRating() {

        return this.combatRating;
    }

    /**
     * @return the arenaTeamInfo
     */
    public final int[] getArenaTeamInfo() {

        return this.arenaTeamInfo;
    }

    /**
     * @return the dailyQuests
     */
    public final int[] getDailyQuests() {

        return this.dailyQuests;
    }

    /**
     * @return the runeRegen
     */
    public final float[] getRuneRegen() {

        return this.runeRegen;
    }

    /**
     * @return the noReagentCost
     */
    public final int[] getNoReagentCost() {

        return this.noReagentCost;
    }

    /**
     * @return the glyphSlots
     */
    public final int[] getGlyphSlots() {

        return this.glyphSlots;
    }

    /**
     * @return the glyph
     */
    public final int[] getGlyph() {

        return this.glyph;
    }

    @Override
    public CharacterPowers getPowers() {
        return this.powers;
    }

    @Override
    public void setPowers(final CreaturePowers powers) {
        this.powers = (CharacterPowers) powers;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;

    }

    @Override
    public int getBytes() {
        return this.bytes;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsUnit#setBytes(int)
     */
    @Override
    public void setBytes(final int bytes) {
        super.setBytes(bytes);
        this.bytes = bytes;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(final int level) {
        super.setLevel(level);
        this.level = level;

    }
}
