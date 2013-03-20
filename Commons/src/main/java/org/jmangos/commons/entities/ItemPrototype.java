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
package org.jmangos.commons.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jmangos.commons.enums.InventoryType;
import org.jmangos.commons.model.NamedObject;
import org.jmangos.commons.model.item._Damage;
import org.jmangos.commons.model.item._ItemStat;
import org.jmangos.commons.model.item._Socket;

/**
 * The Class ItemPrototype.
 * 
 * @author minimajack
 */
@Entity
@Table(name = "item_template")
public class ItemPrototype extends NamedObject {

    /** The Constant MAX_ITEM_PROTO_STATS. */
    final public static int MAX_ITEM_PROTO_STATS = 10;

    /** The Constant MAX_ITEM_PROTO_DAMAGES. */
    final public static int MAX_ITEM_PROTO_DAMAGES = 2;

    /** The Constant MAX_ITEM_PROTO_SOCKETS. */
    final public static int MAX_ITEM_PROTO_SOCKETS = 3;

    /** The Constant MAX_ITEM_PROTO_SPELLS. */
    final public static int MAX_ITEM_PROTO_SPELLS = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private Integer entry;

    /** The Class. */
    @Basic
    @Column(name = "class",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int Class;

    /** The Sub class. */
    @Basic
    @Column(name = "subclass",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int SubClass;                                                    // id from
    // ItemSubClass.dbc

    /** The Unk0. */
    @Basic
    @Column(name = "unk0",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int Unk0;

    @Basic
    @Column(name = "name",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 100,
            precision = 0)
    private String itemName;

    /** The Display info id. */
    @Basic
    @Column(name = "displayid",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int displayId;                                                   // id from
    // ItemDisplayInfo.dbc

    /** The Quality. */
    @Basic
    @Column(name = "Quality",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int Quality;

    /** The Flags. */
    @Basic
    @Column(name = "Flags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private long Flags;

    /** The Flags2. */
    @Basic
    @Column(name = "Flags2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int Flags2;

    /** The Buy count. */
    @Basic
    @Column(name = "BuyCount",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int BuyCount;

    /** The Buy price. */
    @Basic
    @Column(name = "BuyPrice",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int BuyPrice;

    /** The Sell price. */
    @Basic
    @Column(name = "SellPrice",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int SellPrice;

    /** The inventory type. */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "InventoryType",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private InventoryType inventoryType;

    /** The Allowable class. */
    @Column(name = "AllowableClass",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    private int AllowableClass;

    /** The Allowable race. */
    @Basic
    @Column(name = "AllowableRace",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    private int AllowableRace;

    /** The Item level. */
    @Basic
    @Column(name = "ItemLevel",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int ItemLevel;

    /** The Required level. */
    @Basic
    @Column(name = "RequiredLevel",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte RequiredLevel;

    /** The Required skill. */
    @Basic
    @Column(name = "RequiredSkill",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int RequiredSkill;                                               // id from
    // SkillLine.dbc

    /** The Required skill rank. */
    @Basic
    @Column(name = "RequiredSkillRank",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int RequiredSkillRank;

    /** The Required spell. */
    @Basic
    @Column(name = "requiredspell",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int RequiredSpell;                                               // id from
    // Spell.dbc

    /** The Required honor rank. */
    @Basic
    @Column(name = "requiredhonorrank",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int RequiredHonorRank;

    /** The Required city rank. */
    @Basic
    @Column(name = "RequiredCityRank",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int RequiredCityRank;

    /** The Required reputation faction. */
    @Basic
    @Column(name = "RequiredReputationFaction",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int RequiredReputationFaction;                                   // id from
    // Faction.dbc

    /** The Required reputation rank. */
    @Basic
    @Column(name = "RequiredReputationRank",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int RequiredReputationRank;

    /** The Max count. */
    @Basic
    @Column(name = "maxcount",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int MaxCount;                                                    // <=0: no
    // limit

    /** The Stackable. */
    @Basic
    @Column(name = "stackable",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int Stackable;                                                   // 0: not
    // allowed,
    // -1: put
    // in
    // player
    // coin
    // info
    // tab
    // and don't limit stacking (so 1 slot)

    /** The Container slots. */
    @Basic
    @Column(name = "ContainerSlots",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte ContainerSlots;

    /** The Stats count. */
    @Basic
    @Column(name = "StatsCount",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int statsCount;

    // TODO: item bytes implement
    // @Basic
    // @Column(name = "stat_type1", nullable = false, insertable = true,
    // updatable = true, length =
    // 3, precision = 0)
    /** item stats. */
    @Transient
    private _ItemStat[] itemStat;

    /** The Scaling stat distribution. */
    @Basic
    @Column(name = "scalingStatDistribution",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int ScalingStatDistribution;                                     // id from
    // ScalingStatDistribution.dbc

    /** The Scaling stat value. */
    @Basic
    @Column(name = "scalingStatValue",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int ScalingStatValue;                                            // mask
    // for
    // selecting
    // column
    // in
    // ScalingStatValues.dbc

    /*
     * @Columns(columns = {
     * 
     * @Column(name = "dmg_min1", nullable = false, insertable = true, updatable
     * = true, length =
     * 12, precision = 0),
     * 
     * @Column(name = "dmg_max1", nullable = false, insertable = true, updatable
     * = true, length =
     * 12, precision = 0),
     * 
     * @Column(name = "dmg_type1", nullable = false, insertable = true,
     * updatable = true, length =
     * 3, precision = 0),
     * 
     * @Column(name = "dmg_min2", nullable = false, insertable = true, updatable
     * = true, length =
     * 12, precision = 0),
     * 
     * @Column(name = "dmg_max2", nullable = false, insertable = true, updatable
     * = true, length =
     * 12, precision = 0),
     * 
     * @Column(name = "dmg_type2", nullable = false, insertable = true,
     * updatable = true, length =
     * 3, precision = 0), })
     */
    @Transient
    private final _Damage[] Damage = new _Damage[MAX_ITEM_PROTO_DAMAGES];

    /** The Armor. */
    @Basic
    @Column(name = "armor",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int Armor;

    /** The Holy res. */
    @Basic
    @Column(name = "holy_res",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte HolyRes;

    /** The Fire res. */
    @Basic
    @Column(name = "fire_res",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte FireRes;

    /** The Nature res. */
    @Basic
    @Column(name = "nature_res",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte NatureRes;

    /** The Frost res. */
    @Basic
    @Column(name = "frost_res",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte FrostRes;

    /** The Shadow res. */
    @Basic
    @Column(name = "shadow_res",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte ShadowRes;

    /** The Arcane res. */
    @Basic
    @Column(name = "arcane_res",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte ArcaneRes;

    /** The Delay. */
    @Basic
    @Column(name = "delay",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int Delay;

    /** The Ammo type. */
    @Basic
    @Column(name = "ammo_type",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int AmmoType;

    /** The Ranged mod range. */
    @Column(name = "RangedModRange",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 12,
            precision = 0)
    float RangedModRange;

    /*
     * private int[] SpellId = new int[MAX_ITEM_PROTO_SPELLS]; private byte[]
     * SpellTrigger = new
     * byte[MAX_ITEM_PROTO_SPELLS]; private int[] SpellCharges = new
     * int[MAX_ITEM_PROTO_SPELLS];
     * private float[] SpellPPMRate = new float[MAX_ITEM_PROTO_SPELLS]; private
     * int[] SpellCooldown
     * = new int[MAX_ITEM_PROTO_SPELLS]; private int[] SpellCategory = new
     * int[MAX_ITEM_PROTO_SPELLS]; private int[] SpellCategoryCooldown = new
     * int[MAX_ITEM_PROTO_SPELLS];
     */

    /** The Bonding. */
    @Basic
    @Column(name = "bonding",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte Bonding;

    /** The Description. */
    @Basic
    @Column(name = "description",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 255,
            precision = 0)
    private String Description;

    /** The Page text. */
    @Basic
    @Column(name = "PageText",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int PageText;

    /** The Language id. */
    @Basic
    @Column(name = "LanguageID",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte LanguageID;

    /** The Page material. */
    @Basic
    @Column(name = "PageMaterial",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte PageMaterial;

    /** The Start quest. */
    @Basic
    @Column(name = "startquest",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int StartQuest;                                                  // id from
    // QuestCache.wdb

    /** The Lock id. */
    @Basic
    @Column(name = "lockid",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int LockID;

    /** The Material. */
    @Basic
    @Column(name = "Material",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private int Material;                                                    // id from
    // Material.dbc

    /** The Sheath. */
    @Basic
    @Column(name = "sheath",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte Sheath;

    /** The Random property. */
    @Basic
    @Column(name = "RandomProperty",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int RandomProperty;                                              // id from
    // ItemRandomProperties.dbc

    /** The Random suffix. */
    @Basic
    @Column(name = "RandomSuffix",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int RandomSuffix;                                                // id from
    // ItemRandomSuffix.dbc

    /** The Block. */
    @Basic
    @Column(name = "block",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int Block;

    /** The Item set. */
    @Basic
    @Column(name = "itemset",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int ItemSet;                                                     // id from
    // ItemSet.dbc

    /** The Max durability. */
    @Basic
    @Column(name = "MaxDurability",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int MaxDurability;

    /** The Area. */
    @Basic
    @Column(name = "area",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private int Area;                                                        // id from
    // AreaTable.dbc

    /** The Map. */
    @Basic
    @Column(name = "Map",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int Map;                                                         // id from
    // Map.dbc

    /** The Bag family. */
    @Basic
    @Column(name = "BagFamily",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    private int BagFamily;                                                   // bit
    // mask (1
    // << id
    // from
    // ItemBagFamily.dbc)

    /** The Totem category. */
    @Basic
    @Column(name = "TotemCategory",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    private int TotemCategory;                                               // id from
    // TotemCategory.dbc

    /** socket data. */
    // TODO: implement socket
    // @Column(name = "socketColor_1", nullable = false, insertable = true,
    // updatable = true, length
    // = 3, precision = 0)
    // @Column(name = "socketContent_1", nullable = false, insertable = true,
    // updatable = true,
    // length = 7, precision = 0)
    @Transient
    private _Socket[] Socket;

    /** The socket bonus. */
    @Basic
    @Column(name = "socketBonus",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    private int socketBonus;                                                 // id from
    // SpellItemEnchantment.dbc

    /** The Gem properties. */
    @Basic
    @Column(name = "GemProperties",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    private int GemProperties;                                               // id from
    // GemProperties.dbc

    /** The Required disenchant skill. */
    @Basic
    @Column(name = "RequiredDisenchantSkill",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int RequiredDisenchantSkill;

    /** The Armor damage modifier. */
    @Basic
    @Column(name = "ArmorDamageModifier",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 12,
            precision = 0)
    private float ArmorDamageModifier;

    /** The Duration. */
    @Basic
    @Column(name = "Duration",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int Duration;                                                    // negative
    // =
    // realtime,
    // positive
    // =
    // ingame
    // time

    /** The Item limit category. */
    @Basic
    @Column(name = "ItemLimitCategory",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    private int ItemLimitCategory;                                           // id from
    // ItemLimitCategory.dbc

    /** The Holiday id. */
    @Basic
    @Column(name = "HolidayId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int HolidayId;                                                   // id from
    // Holidays.dbc

    /** The Script name. */
    @Basic
    @Column(name = "ScriptName",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 64,
            precision = 0)
    private String ScriptName;

    /** The Disenchant id. */
    @Basic
    @Column(name = "DisenchantID",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    int DisenchantID;

    /** The Food type. */
    @Basic
    @Column(name = "FoodType",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    private byte FoodType;

    /** The Min money loot. */
    @Basic
    @Column(name = "minMoneyLoot",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int MinMoneyLoot;

    /** The Max money loot. */
    @Basic
    @Column(name = "maxMoneyLoot",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int MaxMoneyLoot;

    /** The Extra flags. */
    @Basic
    @Column(name = "ExtraFlags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 0,
            precision = 0)
    private byte ExtraFlags;

    public ItemPrototype() {

    }

    /**
     * Gets the clazz.
     * 
     * @return the class of Item from ItemClass.dbc
     */
    public int getClazz() {

        return this.Class;
    }

    /**
     * Sets the clazz.
     * 
     * @param clazz
     *        set Class Item
     */
    public void setClazz(final int clazz) {

        this.Class = clazz;
    }

    /**
     * Gets the sub class.
     * 
     * @return the subClass
     */
    public int getSubClass() {

        return this.SubClass;
    }

    /**
     * Sets the sub class.
     * 
     * @param subClass
     *        the subClass to set
     */
    public void setSubClass(final int subClass) {

        this.SubClass = subClass;
    }

    /**
     * Gets the unk0.
     * 
     * @return the unk0
     */
    public int getUnk0() {

        return this.Unk0;
    }

    /**
     * Sets the unk0.
     * 
     * @param unk0
     *        the unk0 to set
     */
    public void setUnk0(final int unk0) {

        this.Unk0 = unk0;
    }

    /**
     * Gets the display info id.
     * 
     * @return the displayInfoID
     */
    public int getDisplayInfoID() {

        return this.displayId;
    }

    /**
     * Sets the display info id.
     * 
     * @param displayInfoID
     *        the displayInfoID to set
     */
    public void setDisplayInfoID(final int displayInfoID) {

        this.displayId = displayInfoID;
    }

    /**
     * Gets the quality.
     * 
     * @return the quality
     */
    public int getQuality() {

        return this.Quality;
    }

    /**
     * Sets the quality.
     * 
     * @param quality
     *        the quality to set
     */
    public void setQuality(final int quality) {

        this.Quality = quality;
    }

    /**
     * Gets the flags.
     * 
     * @return the flags
     */
    public long getFlags() {

        return this.Flags;
    }

    /**
     * Sets the flags.
     * 
     * @param flags
     *        the flags to set
     */
    public void setFlags(final int flags) {

        this.Flags = flags;
    }

    /**
     * Gets the buy count.
     * 
     * @return the buyCount
     */
    public int getBuyCount() {

        return this.BuyCount;
    }

    /**
     * Sets the buy count.
     * 
     * @param buyCount
     *        the buyCount to set
     */
    public void setBuyCount(final int buyCount) {

        this.BuyCount = buyCount;
    }

    /**
     * Gets the buy price.
     * 
     * @return the buyPrice
     */
    public int getBuyPrice() {

        return this.BuyPrice;
    }

    /**
     * Sets the buy price.
     * 
     * @param buyPrice
     *        the buyPrice to set
     */
    public void setBuyPrice(final int buyPrice) {

        this.BuyPrice = buyPrice;
    }

    /**
     * Gets the sell price.
     * 
     * @return the sellPrice
     */
    public int getSellPrice() {

        return this.SellPrice;
    }

    /**
     * Sets the sell price.
     * 
     * @param sellPrice
     *        the sellPrice to set
     */
    public void setSellPrice(final int sellPrice) {

        this.SellPrice = sellPrice;
    }

    /**
     * Gets the inventory type.
     * 
     * @return the inventoryType
     */
    public InventoryType getInventoryType() {

        return this.inventoryType;
    }

    /**
     * Sets the inventory type.
     * 
     * @param inventoryType
     *        the inventoryType to set
     */
    public void setInventoryType(final InventoryType inventoryType) {

        this.inventoryType = inventoryType;
    }

    /**
     * Gets the allowable class.
     * 
     * @return the allowableClass
     */
    public int getAllowableClass() {

        return this.AllowableClass;
    }

    /**
     * Sets the allowable class.
     * 
     * @param allowableClass
     *        the allowableClass to set
     */
    public void setAllowableClass(final int allowableClass) {

        this.AllowableClass = allowableClass;
    }

    /**
     * Gets the allowable race.
     * 
     * @return the allowableRace
     */
    public int getAllowableRace() {

        return this.AllowableRace;
    }

    /**
     * Sets the allowable race.
     * 
     * @param allowableRace
     *        the allowableRace to set
     */
    public void setAllowableRace(final int allowableRace) {

        this.AllowableRace = allowableRace;
    }

    /**
     * Gets the item level.
     * 
     * @return the itemLevel
     */
    public int getItemLevel() {

        return this.ItemLevel;
    }

    /**
     * Sets the item level.
     * 
     * @param itemLevel
     *        the itemLevel to set
     */
    public void setItemLevel(final int itemLevel) {

        this.ItemLevel = itemLevel;
    }

    /**
     * Gets the required level.
     * 
     * @return the requiredLevel
     */
    public int getRequiredLevel() {

        return this.RequiredLevel;
    }

    /**
     * Sets the required level.
     * 
     * @param requiredLevel
     *        the requiredLevel to set
     */
    public void setRequiredLevel(final byte requiredLevel) {

        this.RequiredLevel = requiredLevel;
    }

    /**
     * Gets the required skill.
     * 
     * @return the requiredSkill
     */
    public int getRequiredSkill() {

        return this.RequiredSkill;
    }

    /**
     * Sets the required skill.
     * 
     * @param requiredSkill
     *        the requiredSkill to set
     */
    public void setRequiredSkill(final int requiredSkill) {

        this.RequiredSkill = requiredSkill;
    }

    /**
     * Gets the required skill rank.
     * 
     * @return the requiredSkillRank
     */
    public int getRequiredSkillRank() {

        return this.RequiredSkillRank;
    }

    /**
     * Sets the required skill rank.
     * 
     * @param requiredSkillRank
     *        the requiredSkillRank to set
     */
    public void setRequiredSkillRank(final int requiredSkillRank) {

        this.RequiredSkillRank = requiredSkillRank;
    }

    /**
     * Gets the required spell.
     * 
     * @return the requiredSpell
     */
    public int getRequiredSpell() {

        return this.RequiredSpell;
    }

    /**
     * Sets the required spell.
     * 
     * @param requiredSpell
     *        the requiredSpell to set
     */
    public void setRequiredSpell(final int requiredSpell) {

        this.RequiredSpell = requiredSpell;
    }

    /**
     * Gets the required honor rank.
     * 
     * @return the requiredHonorRank
     */
    public int getRequiredHonorRank() {

        return this.RequiredHonorRank;
    }

    /**
     * Sets the required honor rank.
     * 
     * @param requiredHonorRank
     *        the requiredHonorRank to set
     */
    public void setRequiredHonorRank(final int requiredHonorRank) {

        this.RequiredHonorRank = requiredHonorRank;
    }

    /**
     * Gets the required city rank.
     * 
     * @return the requiredCityRank
     */
    public int getRequiredCityRank() {

        return this.RequiredCityRank;
    }

    /**
     * Sets the required city rank.
     * 
     * @param requiredCityRank
     *        the requiredCityRank to set
     */
    public void setRequiredCityRank(final int requiredCityRank) {

        this.RequiredCityRank = requiredCityRank;
    }

    /**
     * Gets the required reputation faction.
     * 
     * @return the requiredReputationFaction
     */
    public int getRequiredReputationFaction() {

        return this.RequiredReputationFaction;
    }

    /**
     * Sets the required reputation faction.
     * 
     * @param requiredReputationFaction
     *        the requiredReputationFaction to set
     */
    public void setRequiredReputationFaction(final int requiredReputationFaction) {

        this.RequiredReputationFaction = requiredReputationFaction;
    }

    /**
     * Gets the required reputation rank.
     * 
     * @return the requiredReputationRank
     */
    public int getRequiredReputationRank() {

        return this.RequiredReputationRank;
    }

    /**
     * Sets the required reputation rank.
     * 
     * @param requiredReputationRank
     *        the requiredReputationRank to set
     */
    public void setRequiredReputationRank(final int requiredReputationRank) {

        this.RequiredReputationRank = requiredReputationRank;
    }

    /**
     * Gets the max count.
     * 
     * @return the maxCount
     */
    public int getMaxCount() {

        return this.MaxCount;
    }

    /**
     * Sets the max count.
     * 
     * @param maxCount
     *        the maxCount to set
     */
    public void setMaxCount(final int maxCount) {

        this.MaxCount = maxCount;
    }

    /**
     * Gets the stackable.
     * 
     * @return the stackable
     */
    public int getStackable() {

        return this.Stackable;
    }

    /**
     * Sets the stackable.
     * 
     * @param stackable
     *        the stackable to set
     */
    public void setStackable(final int stackable) {

        this.Stackable = stackable;
    }

    /**
     * Gets the container slots.
     * 
     * @return the containerSlots
     */
    public int getContainerSlots() {

        return this.ContainerSlots;
    }

    /**
     * Sets the container slots.
     * 
     * @param containerSlots
     *        the containerSlots to set
     */
    public void setContainerSlots(final byte containerSlots) {

        this.ContainerSlots = containerSlots;
    }

    /**
     * Gets the stats count.
     * 
     * @return the statsCount
     */
    public int getStatsCount() {

        return this.statsCount;
    }

    /**
     * Sets the stats count.
     * 
     * @param statsCount
     *        the statsCount to set
     */
    public void setStatsCount(final int statsCount) {

        this.statsCount = statsCount;
    }

    /**
     * Gets the item stat.
     * 
     * @param i
     *        the i
     * @return the _ItemStat
     */
    public _ItemStat getItemStat(final int i) {

        return this.itemStat[i];
    }

    /**
     * Sets the item stat.
     * 
     * @param is
     *        the new item stat
     */
    public void setItemStat(final _ItemStat[] is) {

        this.itemStat = is;
    }

    /**
     * Gets the scaling stat distribution.
     * 
     * @return the scalingStatDistribution
     */
    public int getScalingStatDistribution() {

        return this.ScalingStatDistribution;
    }

    /**
     * Sets the scaling stat distribution.
     * 
     * @param scalingStatDistribution
     *        the scalingStatDistribution to set
     */
    public void setScalingStatDistribution(final int scalingStatDistribution) {

        this.ScalingStatDistribution = scalingStatDistribution;
    }

    /**
     * Gets the scaling stat value.
     * 
     * @return the scalingStatValue
     */
    public int getScalingStatValue() {

        return this.ScalingStatValue;
    }

    /**
     * Sets the scaling stat value.
     * 
     * @param scalingStatValue
     *        the scalingStatValue to set
     */
    public void setScalingStatValue(final int scalingStatValue) {

        this.ScalingStatValue = scalingStatValue;
    }

    /**
     * Gets the damage.
     * 
     * @param i
     *        the i
     * @return the damage
     */
    public _Damage getDamage(final int i) {

        return this.Damage[i];
    }

    /**
     * Sets the damage.
     * 
     * @param _damage
     *        the _damage
     * @param pos
     *        the pos
     */
    public void setDamage(final _Damage _damage, final byte pos) {

        this.Damage[pos] = _damage;
    }

    /**
     * Sets the damage.
     * 
     * @param damageMin
     *        the damage min
     * @param damageMax
     *        the damage max
     * @param damageType
     *        the damage type
     * @param pos
     *        the pos
     */
    public void setDamage(final float damageMin, final float damageMax, final byte damageType,
            final byte pos) {

        this.Damage[pos] = new _Damage(damageMin, damageMax, damageType);
    }

    /**
     * Gets the armor.
     * 
     * @return the armor
     */
    public int getArmor() {

        return this.Armor;
    }

    /**
     * Sets the armor.
     * 
     * @param armor
     *        the armor to set
     */
    public void setArmor(final int armor) {

        this.Armor = armor;
    }

    /**
     * Gets the holy res.
     * 
     * @return the holy Resistance
     */
    public byte getHolyRes() {

        return this.HolyRes;
    }

    /**
     * Sets the holy res.
     * 
     * @param holyRes
     *        the holyRes to set
     */
    public void setHolyRes(final byte holyRes) {

        this.HolyRes = holyRes;
    }

    /**
     * Gets the fire res.
     * 
     * @return the fire Resistance
     */
    public byte getFireRes() {

        return this.FireRes;
    }

    /**
     * Sets the fire res.
     * 
     * @param fireRes
     *        the fireRes to set
     */
    public void setFireRes(final byte fireRes) {

        this.FireRes = fireRes;
    }

    /**
     * Gets the nature res.
     * 
     * @return the nature Resistance
     */
    public byte getNatureRes() {

        return this.NatureRes;
    }

    /**
     * Sets the nature res.
     * 
     * @param natureRes
     *        the natureRes to set
     */
    public void setNatureRes(final byte natureRes) {

        this.NatureRes = natureRes;
    }

    /**
     * Gets the frost res.
     * 
     * @return the frostRes
     */
    public byte getFrostRes() {

        return this.FrostRes;
    }

    /**
     * Sets the frost res.
     * 
     * @param frostRes
     *        the frostRes to set
     */
    public void setFrostRes(final byte frostRes) {

        this.FrostRes = frostRes;
    }

    /**
     * Gets the shadow res.
     * 
     * @return the shadowRes
     */
    public byte getShadowRes() {

        return this.ShadowRes;
    }

    /**
     * Sets the shadow res.
     * 
     * @param shadowRes
     *        the shadowRes to set
     */
    public void setShadowRes(final byte shadowRes) {

        this.ShadowRes = shadowRes;
    }

    /**
     * Gets the arcane res.
     * 
     * @return the arcaneRes
     */
    public byte getArcaneRes() {

        return this.ArcaneRes;
    }

    /**
     * Sets the arcane res.
     * 
     * @param arcaneRes
     *        the arcaneRes to set
     */
    public void setArcaneRes(final byte arcaneRes) {

        this.ArcaneRes = arcaneRes;
    }

    /**
     * Gets the delay.
     * 
     * @return the delay
     */
    public int getDelay() {

        return this.Delay;
    }

    /**
     * Sets the delay.
     * 
     * @param delay
     *        the delay to set
     */
    public void setDelay(final int delay) {

        this.Delay = delay;
    }

    /**
     * Gets the ammo type.
     * 
     * @return the ammoType
     */
    public int getAmmoType() {

        return this.AmmoType;
    }

    /**
     * Sets the ammo type.
     * 
     * @param ammoType
     *        the ammoType to set
     */
    public void setAmmoType(final int ammoType) {

        this.AmmoType = ammoType;
    }

    /**
     * Gets the ranged mod range.
     * 
     * @return the rangedModRange
     */
    public float getRangedModRange() {

        return this.RangedModRange;
    }

    /**
     * Sets the ranged mod range.
     * 
     * @param rangedModRange
     *        the rangedModRange to set
     */
    public void setRangedModRange(final float rangedModRange) {

        this.RangedModRange = rangedModRange;
    }

    /**
     * Gets the bonding.
     * 
     * @return the bonding
     */
    /*
     * public void setSpells(int _SpellId, byte _SpellTrigger, int
     * _SpellCharges, float
     * _SpellPPMRate, int _SpellCooldown, int _SpellCategory, int
     * _SpellCategoryCooldown, byte pos)
     * { SpellId[pos] = _SpellId; SpellTrigger[pos] = _SpellTrigger;
     * SpellCharges[pos] =
     * _SpellCharges; SpellPPMRate[pos] = _SpellPPMRate; SpellCooldown[pos] =
     * _SpellCooldown;
     * SpellCategory[pos] = _SpellCategory; SpellCategoryCooldown[pos] =
     * _SpellCategoryCooldown; }
     */
    /**
     * @return the bonding
     */
    public int getBonding() {

        return this.Bonding;
    }

    /**
     * Sets the bonding.
     * 
     * @param bonding
     *        the bonding to set
     */
    public void setBonding(final byte bonding) {

        this.Bonding = bonding;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {

        return this.Description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *        the description to set
     */
    public void setDescription(final String description) {

        this.Description = description;
    }

    /**
     * Gets the page text.
     * 
     * @return the pageText
     */
    public int getPageText() {

        return this.PageText;
    }

    /**
     * Sets the page text.
     * 
     * @param pageText
     *        the pageText to set
     */
    public void setPageText(final int pageText) {

        this.PageText = pageText;
    }

    /**
     * Gets the language id.
     * 
     * @return the languageID
     */
    public byte getLanguageID() {

        return this.LanguageID;
    }

    /**
     * Sets the language id.
     * 
     * @param languageID
     *        the languageID to set
     */
    public void setLanguageID(final byte languageID) {

        this.LanguageID = languageID;
    }

    /**
     * Gets the page material.
     * 
     * @return the pageMaterial
     */
    public byte getPageMaterial() {

        return this.PageMaterial;
    }

    /**
     * Sets the page material.
     * 
     * @param pageMaterial
     *        the pageMaterial to set
     */
    public void setPageMaterial(final byte pageMaterial) {

        this.PageMaterial = pageMaterial;
    }

    /**
     * Gets the start quest.
     * 
     * @return the startQuest
     */
    public int getStartQuest() {

        return this.StartQuest;
    }

    /**
     * Sets the start quest.
     * 
     * @param startQuest
     *        the startQuest to set
     */
    public void setStartQuest(final int startQuest) {

        this.StartQuest = startQuest;
    }

    /**
     * Gets the lock id.
     * 
     * @return the lockID
     */
    public int getLockID() {

        return this.LockID;
    }

    /**
     * Sets the lock id.
     * 
     * @param lockID
     *        the lockID to set
     */
    public void setLockID(final int lockID) {

        this.LockID = lockID;
    }

    /**
     * Gets the material.
     * 
     * @return the material
     */
    public int getMaterial() {

        return this.Material;
    }

    /**
     * Sets the material.
     * 
     * @param material
     *        the material to set
     */
    public void setMaterial(final int material) {

        this.Material = material;
    }

    /**
     * Gets the sheath.
     * 
     * @return the sheath
     */
    public byte getSheath() {

        return this.Sheath;
    }

    /**
     * Sets the sheath.
     * 
     * @param sheath
     *        the sheath to set
     */
    public void setSheath(final byte sheath) {

        this.Sheath = sheath;
    }

    /**
     * Gets the random property.
     * 
     * @return the randomProperty
     */
    public int getRandomProperty() {

        return this.RandomProperty;
    }

    /**
     * Sets the random property.
     * 
     * @param randomProperty
     *        the randomProperty to set
     */
    public void setRandomProperty(final int randomProperty) {

        this.RandomProperty = randomProperty;
    }

    /**
     * Gets the random suffix.
     * 
     * @return the randomSuffix
     */
    public int getRandomSuffix() {

        return this.RandomSuffix;
    }

    /**
     * Sets the random suffix.
     * 
     * @param randomSuffix
     *        the randomSuffix to set
     */
    public void setRandomSuffix(final int randomSuffix) {

        this.RandomSuffix = randomSuffix;
    }

    /**
     * Gets the block.
     * 
     * @return the block
     */
    public int getBlock() {

        return this.Block;
    }

    /**
     * Sets the block.
     * 
     * @param block
     *        the block to set
     */
    public void setBlock(final int block) {

        this.Block = block;
    }

    /**
     * Gets the item set.
     * 
     * @return the itemSet
     */
    public int getItemSet() {

        return this.ItemSet;
    }

    /**
     * Sets the item set.
     * 
     * @param itemSet
     *        the itemSet to set
     */
    public void setItemSet(final int itemSet) {

        this.ItemSet = itemSet;
    }

    /**
     * Gets the max durability.
     * 
     * @return the maxDurability
     */
    public int getMaxDurability() {

        return this.MaxDurability;
    }

    /**
     * Sets the max durability.
     * 
     * @param maxDurability
     *        the maxDurability to set
     */
    public void setMaxDurability(final int maxDurability) {

        this.MaxDurability = maxDurability;
    }

    /**
     * Gets the area.
     * 
     * @return the area
     */
    public int getArea() {

        return this.Area;
    }

    /**
     * Sets the area.
     * 
     * @param area
     *        the area to set
     */
    public void setArea(final int area) {

        this.Area = area;
    }

    /**
     * Gets the map.
     * 
     * @return the map
     */
    public int getMap() {

        return this.Map;
    }

    /**
     * Sets the map.
     * 
     * @param map
     *        the map to set
     */
    public void setMap(final int map) {

        this.Map = map;
    }

    /**
     * Gets the bag family.
     * 
     * @return the bagFamily
     */
    public int getBagFamily() {

        return this.BagFamily;
    }

    /**
     * Sets the bag family.
     * 
     * @param bagFamily
     *        the bagFamily to set
     */
    public void setBagFamily(final int bagFamily) {

        this.BagFamily = bagFamily;
    }

    /**
     * Gets the totem category.
     * 
     * @return the totemCategory
     */
    public int getTotemCategory() {

        return this.TotemCategory;
    }

    /**
     * Sets the totem category.
     * 
     * @param totemCategory
     *        the totemCategory to set
     */
    public void setTotemCategory(final int totemCategory) {

        this.TotemCategory = totemCategory;
    }

    /**
     * Gets the socket.
     * 
     * @param i
     *        the i
     * @return the socket
     */
    public _Socket getSocket(final int i) {

        // TODO implement socket
        return new _Socket((byte) 0, 0);
    }

    /**
     * Sets the socket.
     * 
     * @param ob
     *        the new socket
     */
    public void setSocket(final _Socket[] ob) {

        this.Socket = ob;
    }

    /**
     * Gets the socket bonus.
     * 
     * @return the socketBonus
     */
    public int getSocketBonus() {

        return this.socketBonus;
    }

    /**
     * Sets the socket bonus.
     * 
     * @param socketBonus
     *        the socketBonus to set
     */
    public void setSocketBonus(final int socketBonus) {

        this.socketBonus = socketBonus;
    }

    /**
     * Gets the gem properties.
     * 
     * @return the gemProperties
     */
    public int getGemProperties() {

        return this.GemProperties;
    }

    /**
     * Sets the gem properties.
     * 
     * @param gemProperties
     *        the gemProperties to set
     */
    public void setGemProperties(final int gemProperties) {

        this.GemProperties = gemProperties;
    }

    /**
     * Gets the required disenchant skill.
     * 
     * @return the requiredDisenchantSkill
     */
    public int getRequiredDisenchantSkill() {

        return this.RequiredDisenchantSkill;
    }

    /**
     * Sets the required disenchant skill.
     * 
     * @param requiredDisenchantSkill
     *        the requiredDisenchantSkill to set
     */
    public void setRequiredDisenchantSkill(final int requiredDisenchantSkill) {

        this.RequiredDisenchantSkill = requiredDisenchantSkill;
    }

    /**
     * Gets the armor damage modifier.
     * 
     * @return the armorDamageModifier
     */
    public float getArmorDamageModifier() {

        return this.ArmorDamageModifier;
    }

    /**
     * Sets the armor damage modifier.
     * 
     * @param armorDamageModifier
     *        the armorDamageModifier to set
     */
    public void setArmorDamageModifier(final float armorDamageModifier) {

        this.ArmorDamageModifier = armorDamageModifier;
    }

    /**
     * Gets the duration.
     * 
     * @return the duration
     */
    public int getDuration() {

        return this.Duration;
    }

    /**
     * Sets the duration.
     * 
     * @param duration
     *        the duration to set
     */
    public void setDuration(final int duration) {

        this.Duration = duration;
    }

    /**
     * Gets the item limit category.
     * 
     * @return the itemLimitCategory
     */
    public int getItemLimitCategory() {

        return this.ItemLimitCategory;
    }

    /**
     * Sets the item limit category.
     * 
     * @param itemLimitCategory
     *        the itemLimitCategory to set
     */
    public void setItemLimitCategory(final int itemLimitCategory) {

        this.ItemLimitCategory = itemLimitCategory;
    }

    /**
     * Gets the holiday id.
     * 
     * @return the holidayId
     */
    public int getHolidayId() {

        return this.HolidayId;
    }

    /**
     * Sets the holiday id.
     * 
     * @param holidayId
     *        the holidayId to set
     */
    public void setHolidayId(final int holidayId) {

        this.HolidayId = holidayId;
    }

    /**
     * Gets the script id.
     * 
     * @return the scriptId
     */
    public String getScriptId() {

        return this.ScriptName;
    }

    /**
     * Sets the script id.
     * 
     * @param scriptName
     *        the scriptId to set
     */
    public void setScriptId(final String scriptName) {

        this.ScriptName = scriptName;
    }

    /**
     * Gets the disenchant id.
     * 
     * @return the disenchantID
     */
    public int getDisenchantID() {

        return this.DisenchantID;
    }

    /**
     * Sets the disenchant id.
     * 
     * @param disenchantID
     *        the disenchantID to set
     */
    public void setDisenchantID(final int disenchantID) {

        this.DisenchantID = disenchantID;
    }

    /**
     * Gets the food type.
     * 
     * @return the foodType
     */
    public byte getFoodType() {

        return this.FoodType;
    }

    /**
     * Sets the food type.
     * 
     * @param foodType
     *        the foodType to set
     */
    public void setFoodType(final byte foodType) {

        this.FoodType = foodType;
    }

    /**
     * Gets the min money loot.
     * 
     * @return the minMoneyLoot
     */
    public int getMinMoneyLoot() {

        return this.MinMoneyLoot;
    }

    /**
     * Sets the min money loot.
     * 
     * @param minMoneyLoot
     *        the minMoneyLoot to set
     */
    public void setMinMoneyLoot(final int minMoneyLoot) {

        this.MinMoneyLoot = minMoneyLoot;
    }

    /**
     * Gets the max money loot.
     * 
     * @return the maxMoneyLoot
     */
    public int getMaxMoneyLoot() {

        return this.MaxMoneyLoot;
    }

    /**
     * Sets the max money loot.
     * 
     * @param maxMoneyLoot
     *        the maxMoneyLoot to set
     */
    public void setMaxMoneyLoot(final int maxMoneyLoot) {

        this.MaxMoneyLoot = maxMoneyLoot;
    }

    /**
     * Gets the extra flags.
     * 
     * @return the extraFlags
     */
    public byte getExtraFlags() {

        return this.ExtraFlags;
    }

    /**
     * Sets the extra flags.
     * 
     * @param extraFlags
     *        the extraFlags to set
     */
    public void setExtraFlags(final byte extraFlags) {

        this.ExtraFlags = extraFlags;
    }

    /**
     * Gets the flags2.
     * 
     * @return the flags2
     */
    public int getFlags2() {

        return this.Flags2;
    }

    /**
     * Sets the flags2.
     * 
     * @param flags2
     *        the new flags2
     */
    public void setFlags2(final int flags2) {

        this.Flags2 = flags2;
    }

    public Integer getEntry() {

        return this.entry;
    }

    public void setEntry(final Integer entry) {

        this.entry = entry;
    }

    public String getItemName() {

        return this.itemName;
    }

    public void setItemName(final String itemName) {

        this.itemName = itemName;
    }
}
