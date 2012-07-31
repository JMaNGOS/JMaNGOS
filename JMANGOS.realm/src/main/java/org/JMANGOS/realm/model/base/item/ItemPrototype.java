/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base.item;

import org.JMANGOS.common.model.NamedObject;
// TODO: Auto-generated Javadoc

/**
 * The Class ItemPrototype.
 *
 * @author minimajack
 */
public class ItemPrototype extends NamedObject {
	
	/** The Constant MAX_ITEM_PROTO_STATS. */
	final public static int MAX_ITEM_PROTO_STATS = 10;
	
	/** The Constant MAX_ITEM_PROTO_DAMAGES. */
	final public static int MAX_ITEM_PROTO_DAMAGES = 2;
	
	/** The Constant MAX_ITEM_PROTO_SOCKETS. */
	final public static int MAX_ITEM_PROTO_SOCKETS = 3;
	
	/** The Constant MAX_ITEM_PROTO_SPELLS. */
	final public static int MAX_ITEM_PROTO_SPELLS = 5;

	/** The Class. */
	private int Class;
	
	/** The Sub class. */
	private int SubClass; // id from ItemSubClass.dbc
	
	/** The Unk0. */
	private int Unk0;
	
	/** The Display info id. */
	private int DisplayInfoID; // id from ItemDisplayInfo.dbc
	
	/** The Quality. */
	private int Quality;
	
	/** The Flags. */
	private long Flags;
	
	/** The Flags2. */
	private int Flags2;
	
	/** The Buy count. */
	private byte BuyCount;
	
	/** The Buy price. */
	private int BuyPrice;
	
	/** The Sell price. */
	private int SellPrice;
	
	/** The inventory type. */
	private InventoryType inventoryType;
	
	/** The Allowable class. */
	private int AllowableClass;
	
	/** The Allowable race. */
	private int AllowableRace;
	
	/** The Item level. */
	private int ItemLevel;
	
	/** The Required level. */
	private byte RequiredLevel;
	
	/** The Required skill. */
	private int RequiredSkill; // id from SkillLine.dbc
	
	/** The Required skill rank. */
	private int RequiredSkillRank;
	
	/** The Required spell. */
	private int RequiredSpell; // id from Spell.dbc
	
	/** The Required honor rank. */
	private int RequiredHonorRank;
	
	/** The Required city rank. */
	private int RequiredCityRank;
	
	/** The Required reputation faction. */
	private int RequiredReputationFaction; // id from Faction.dbc
	
	/** The Required reputation rank. */
	private int RequiredReputationRank;
	
	/** The Max count. */
	private int MaxCount; // <=0: no limit
	
	/** The Stackable. */
	private int Stackable; // 0: not allowed, -1: put in player coin info tab
	// and don't limit stacking (so 1 slot)
	/** The Container slots. */
	private byte ContainerSlots;
	
	/** The Stats count. */
	private int StatsCount;
	
	/** item stats. */
	private Object[] ItemStat;

	/** The Scaling stat distribution. */
	private int ScalingStatDistribution; // id from ScalingStatDistribution.dbc
	
	/** The Scaling stat value. */
	private int ScalingStatValue; // mask for selecting column in
	// ScalingStatValues.dbc
	/** damages. */
	private _Damage[] Damage = new _Damage[MAX_ITEM_PROTO_DAMAGES];

	/** The Armor. */
	private int Armor;
	
	/** The Holy res. */
	private byte HolyRes;
	
	/** The Fire res. */
	private byte FireRes;
	
	/** The Nature res. */
	private byte NatureRes;
	
	/** The Frost res. */
	private byte FrostRes;
	
	/** The Shadow res. */
	private byte ShadowRes;
	
	/** The Arcane res. */
	private byte ArcaneRes;
	
	/** The Delay. */
	private int Delay;
	
	/** The Ammo type. */
	private int AmmoType;
	
	/** The Ranged mod range. */
	float RangedModRange;

	/*
	 * private int[] SpellId = new int[MAX_ITEM_PROTO_SPELLS]; private byte[]
	 * SpellTrigger = new byte[MAX_ITEM_PROTO_SPELLS]; private int[]
	 * SpellCharges = new int[MAX_ITEM_PROTO_SPELLS]; private float[]
	 * SpellPPMRate = new float[MAX_ITEM_PROTO_SPELLS]; private int[]
	 * SpellCooldown = new int[MAX_ITEM_PROTO_SPELLS]; private int[]
	 * SpellCategory = new int[MAX_ITEM_PROTO_SPELLS]; private int[]
	 * SpellCategoryCooldown = new int[MAX_ITEM_PROTO_SPELLS];
	 */

	/** The Bonding. */
	private byte Bonding;
	
	/** The Description. */
	private String Description;
	
	/** The Page text. */
	private int PageText;
	
	/** The Language id. */
	private byte LanguageID;
	
	/** The Page material. */
	private byte PageMaterial;
	
	/** The Start quest. */
	private int StartQuest; // id from QuestCache.wdb
	
	/** The Lock id. */
	private int LockID;
	
	/** The Material. */
	private int Material; // id from Material.dbc
	
	/** The Sheath. */
	private byte Sheath;
	
	/** The Random property. */
	private int RandomProperty; // id from ItemRandomProperties.dbc
	
	/** The Random suffix. */
	private int RandomSuffix; // id from ItemRandomSuffix.dbc
	
	/** The Block. */
	private int Block;
	
	/** The Item set. */
	private int ItemSet; // id from ItemSet.dbc
	
	/** The Max durability. */
	private int MaxDurability;
	
	/** The Area. */
	private int Area; // id from AreaTable.dbc
	
	/** The Map. */
	private int Map; // id from Map.dbc
	
	/** The Bag family. */
	private int BagFamily; // bit mask (1 << id from ItemBagFamily.dbc)
	
	/** The Totem category. */
	private int TotemCategory; // id from TotemCategory.dbc
	
	/** socket data. */
	private Object[] Socket;

	/** The socket bonus. */
	private int socketBonus; // id from SpellItemEnchantment.dbc
	
	/** The Gem properties. */
	private int GemProperties; // id from GemProperties.dbc
	
	/** The Required disenchant skill. */
	private int RequiredDisenchantSkill;
	
	/** The Armor damage modifier. */
	private float ArmorDamageModifier;
	
	/** The Duration. */
	private int Duration; // negative = realtime, positive = ingame time
	
	/** The Item limit category. */
	private int ItemLimitCategory; // id from ItemLimitCategory.dbc
	
	/** The Holiday id. */
	private int HolidayId; // id from Holidays.dbc
	
	/** The Script id. */
	private int ScriptId;
	
	/** The Disenchant id. */
	private int DisenchantID;
	
	/** The Food type. */
	private byte FoodType;
	
	/** The Min money loot. */
	private int MinMoneyLoot;
	
	/** The Max money loot. */
	private int MaxMoneyLoot;
	
	/** The Extra flags. */
	private byte ExtraFlags;

	/**
	 * This class is Item Template.
	 *
	 * @param guid the guid
	 * @param clazz the clazz
	 * @param subClass the sub class
	 * @param unk0 the unk0
	 * @param displayInfoID the display info id
	 * @param quality the quality
	 * @param flags the flags
	 * @param flags2 the flags2
	 * @param buyCount the buy count
	 * @param buyPrice the buy price
	 * @param sellPrice the sell price
	 * @param inventoryType the inventory type
	 * @param allowableClass the allowable class
	 * @param allowableRace the allowable race
	 * @param itemLevel the item level
	 * @param requiredLevel the required level
	 * @param requiredSkill the required skill
	 * @param requiredSkillRank the required skill rank
	 * @param requiredSpell the required spell
	 * @param requiredHonorRank the required honor rank
	 * @param requiredCityRank the required city rank
	 * @param requiredReputationFaction the required reputation faction
	 * @param requiredReputationRank the required reputation rank
	 * @param maxCount the max count
	 * @param stackable the stackable
	 * @param containerSlots the container slots
	 * @param statsCount the stats count
	 * @param scalingStatDistribution the scaling stat distribution
	 * @param scalingStatValue the scaling stat value
	 * @param armor the armor
	 * @param holyRes the holy res
	 * @param fireRes the fire res
	 * @param natureRes the nature res
	 * @param frostRes the frost res
	 * @param shadowRes the shadow res
	 * @param arcaneRes the arcane res
	 * @param delay the delay
	 * @param ammoType the ammo type
	 * @param rangedModRange the ranged mod range
	 * @param bonding the bonding
	 * @param description the description
	 * @param pageText the page text
	 * @param languageID the language id
	 * @param pageMaterial the page material
	 * @param startQuest the start quest
	 * @param lockID the lock id
	 * @param material the material
	 * @param sheath the sheath
	 * @param randomProperty the random property
	 * @param randomSuffix the random suffix
	 * @param block the block
	 * @param itemSet the item set
	 * @param maxDurability the max durability
	 * @param area the area
	 * @param map the map
	 * @param bagFamily the bag family
	 * @param totemCategory the totem category
	 * @param _socketBonus the _socket bonus
	 * @param gemProperties the gem properties
	 * @param requiredDisenchantSkill the required disenchant skill
	 * @param armorDamageModifier the armor damage modifier
	 * @param duration the duration
	 * @param itemLimitCategory the item limit category
	 * @param holidayId the holiday id
	 * @param scriptId the script id
	 * @param disenchantID the disenchant id
	 * @param foodType the food type
	 * @param minMoneyLoot the min money loot
	 * @param maxMoneyLoot the max money loot
	 * @param extraFlags the extra flags
	 */
	public ItemPrototype(int guid, int clazz, int subClass, int unk0,
			int displayInfoID, int quality, long flags, int flags2,
			byte buyCount, int buyPrice, int sellPrice, byte inventoryType,
			int allowableClass, int allowableRace, int itemLevel,
			byte requiredLevel, int requiredSkill, int requiredSkillRank,
			int requiredSpell, int requiredHonorRank, int requiredCityRank,
			int requiredReputationFaction, int requiredReputationRank,
			int maxCount, int stackable, byte containerSlots, int statsCount,
			int scalingStatDistribution, int scalingStatValue, int armor,
			byte holyRes, byte fireRes, byte natureRes, byte frostRes,
			byte shadowRes, byte arcaneRes, int delay, int ammoType,
			float rangedModRange, byte bonding, String description,
			int pageText, byte languageID, byte pageMaterial, int startQuest,
			int lockID, int material, byte sheath, int randomProperty,
			int randomSuffix, int block, int itemSet, int maxDurability,
			int area, int map, int bagFamily, int totemCategory,
			int _socketBonus, int gemProperties, int requiredDisenchantSkill,
			float armorDamageModifier, int duration, int itemLimitCategory,
			int holidayId, int scriptId, int disenchantID, byte foodType,
			int minMoneyLoot, int maxMoneyLoot, byte extraFlags) {
		super(guid);
		Class = clazz;
		SubClass = subClass;
		Unk0 = unk0;
		DisplayInfoID = displayInfoID;
		Quality = quality;
		Flags = flags;
		Flags2 = flags2;
		BuyCount = buyCount;
		BuyPrice = buyPrice;
		SellPrice = sellPrice;
		for (InventoryType inv : InventoryType.values()) {
			if(inventoryType == inv.ordinal()){
				this.inventoryType = inv;
			}
		}
		//InventoryType = (inventoryType);
		AllowableClass = allowableClass;
		AllowableRace = allowableRace;
		ItemLevel = itemLevel;
		RequiredLevel = requiredLevel;
		RequiredSkill = requiredSkill;
		RequiredSkillRank = requiredSkillRank;
		RequiredSpell = requiredSpell;
		RequiredHonorRank = requiredHonorRank;
		RequiredCityRank = requiredCityRank;
		RequiredReputationFaction = requiredReputationFaction;
		RequiredReputationRank = requiredReputationRank;
		MaxCount = maxCount;
		Stackable = stackable;
		ContainerSlots = containerSlots;
		StatsCount = statsCount;
		ScalingStatDistribution = scalingStatDistribution;
		ScalingStatValue = scalingStatValue;
		Armor = armor;
		HolyRes = holyRes;
		FireRes = fireRes;
		NatureRes = natureRes;
		FrostRes = frostRes;
		ShadowRes = shadowRes;
		ArcaneRes = arcaneRes;
		Delay = delay;
		AmmoType = ammoType;
		RangedModRange = rangedModRange;
		Bonding = bonding;
		Description = description;
		PageText = pageText;
		LanguageID = languageID;
		PageMaterial = pageMaterial;
		StartQuest = startQuest;
		LockID = lockID;
		Material = material;
		Sheath = sheath;
		RandomProperty = randomProperty;
		RandomSuffix = randomSuffix;
		Block = block;
		ItemSet = itemSet;
		MaxDurability = maxDurability;
		Area = area;
		Map = map;
		BagFamily = bagFamily;
		TotemCategory = totemCategory;
		socketBonus = _socketBonus;
		GemProperties = gemProperties;
		RequiredDisenchantSkill = requiredDisenchantSkill;
		ArmorDamageModifier = armorDamageModifier;
		Duration = duration;
		ItemLimitCategory = itemLimitCategory;
		HolidayId = holidayId;
		ScriptId = scriptId;
		DisenchantID = disenchantID;
		FoodType = foodType;
		MinMoneyLoot = minMoneyLoot;
		MaxMoneyLoot = maxMoneyLoot;
		ExtraFlags = extraFlags;
	}

	/**
	 * Gets the clazz.
	 *
	 * @return the class of Item from ItemClass.dbc
	 */
	public int getClazz() {
		return Class;
	}

	/**
	 * Sets the clazz.
	 *
	 * @param clazz set Class Item
	 */
	public void setClazz(int clazz) {
		Class = clazz;
	}

	/**
	 * Gets the sub class.
	 *
	 * @return the subClass
	 */
	public int getSubClass() {
		return SubClass;
	}

	/**
	 * Sets the sub class.
	 *
	 * @param subClass the subClass to set
	 */
	public void setSubClass(int subClass) {
		SubClass = subClass;
	}

	/**
	 * Gets the unk0.
	 *
	 * @return the unk0
	 */
	public int getUnk0() {
		return Unk0;
	}

	/**
	 * Sets the unk0.
	 *
	 * @param unk0 the unk0 to set
	 */
	public void setUnk0(int unk0) {
		Unk0 = unk0;
	}

	/**
	 * Gets the display info id.
	 *
	 * @return the displayInfoID
	 */
	public int getDisplayInfoID() {
		return DisplayInfoID;
	}

	/**
	 * Sets the display info id.
	 *
	 * @param displayInfoID the displayInfoID to set
	 */
	public void setDisplayInfoID(int displayInfoID) {
		DisplayInfoID = displayInfoID;
	}

	/**
	 * Gets the quality.
	 *
	 * @return the quality
	 */
	public int getQuality() {
		return Quality;
	}

	/**
	 * Sets the quality.
	 *
	 * @param quality the quality to set
	 */
	public void setQuality(int quality) {
		Quality = quality;
	}

	/**
	 * Gets the flags.
	 *
	 * @return the flags
	 */
	public long getFlags() {
		return Flags;
	}

	/**
	 * Sets the flags.
	 *
	 * @param flags the flags to set
	 */
	public void setFlags(int flags) {
		Flags = flags;
	}

	/**
	 * Gets the buy count.
	 *
	 * @return the buyCount
	 */
	public int getBuyCount() {
		return BuyCount;
	}

	/**
	 * Sets the buy count.
	 *
	 * @param buyCount the buyCount to set
	 */
	public void setBuyCount(byte buyCount) {
		BuyCount = buyCount;
	}

	/**
	 * Gets the buy price.
	 *
	 * @return the buyPrice
	 */
	public int getBuyPrice() {
		return BuyPrice;
	}

	/**
	 * Sets the buy price.
	 *
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(int buyPrice) {
		BuyPrice = buyPrice;
	}

	/**
	 * Gets the sell price.
	 *
	 * @return the sellPrice
	 */
	public int getSellPrice() {
		return SellPrice;
	}

	/**
	 * Sets the sell price.
	 *
	 * @param sellPrice the sellPrice to set
	 */
	public void setSellPrice(int sellPrice) {
		SellPrice = sellPrice;
	}

	/**
	 * Gets the inventory type.
	 *
	 * @return the inventoryType
	 */
	public InventoryType getInventoryType() {
		return inventoryType;
	}

	/**
	 * Sets the inventory type.
	 *
	 * @param inventoryType the inventoryType to set
	 */
	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}

	/**
	 * Gets the allowable class.
	 *
	 * @return the allowableClass
	 */
	public int getAllowableClass() {
		return AllowableClass;
	}

	/**
	 * Sets the allowable class.
	 *
	 * @param allowableClass the allowableClass to set
	 */
	public void setAllowableClass(int allowableClass) {
		AllowableClass = allowableClass;
	}

	/**
	 * Gets the allowable race.
	 *
	 * @return the allowableRace
	 */
	public int getAllowableRace() {
		return AllowableRace;
	}

	/**
	 * Sets the allowable race.
	 *
	 * @param allowableRace the allowableRace to set
	 */
	public void setAllowableRace(int allowableRace) {
		AllowableRace = allowableRace;
	}

	/**
	 * Gets the item level.
	 *
	 * @return the itemLevel
	 */
	public int getItemLevel() {
		return ItemLevel;
	}

	/**
	 * Sets the item level.
	 *
	 * @param itemLevel the itemLevel to set
	 */
	public void setItemLevel(int itemLevel) {
		ItemLevel = itemLevel;
	}

	/**
	 * Gets the required level.
	 *
	 * @return the requiredLevel
	 */
	public int getRequiredLevel() {
		return RequiredLevel;
	}

	/**
	 * Sets the required level.
	 *
	 * @param requiredLevel the requiredLevel to set
	 */
	public void setRequiredLevel(byte requiredLevel) {
		RequiredLevel = requiredLevel;
	}

	/**
	 * Gets the required skill.
	 *
	 * @return the requiredSkill
	 */
	public int getRequiredSkill() {
		return RequiredSkill;
	}

	/**
	 * Sets the required skill.
	 *
	 * @param requiredSkill the requiredSkill to set
	 */
	public void setRequiredSkill(int requiredSkill) {
		RequiredSkill = requiredSkill;
	}

	/**
	 * Gets the required skill rank.
	 *
	 * @return the requiredSkillRank
	 */
	public int getRequiredSkillRank() {
		return RequiredSkillRank;
	}

	/**
	 * Sets the required skill rank.
	 *
	 * @param requiredSkillRank the requiredSkillRank to set
	 */
	public void setRequiredSkillRank(int requiredSkillRank) {
		RequiredSkillRank = requiredSkillRank;
	}

	/**
	 * Gets the required spell.
	 *
	 * @return the requiredSpell
	 */
	public int getRequiredSpell() {
		return RequiredSpell;
	}

	/**
	 * Sets the required spell.
	 *
	 * @param requiredSpell the requiredSpell to set
	 */
	public void setRequiredSpell(int requiredSpell) {
		RequiredSpell = requiredSpell;
	}

	/**
	 * Gets the required honor rank.
	 *
	 * @return the requiredHonorRank
	 */
	public int getRequiredHonorRank() {
		return RequiredHonorRank;
	}

	/**
	 * Sets the required honor rank.
	 *
	 * @param requiredHonorRank the requiredHonorRank to set
	 */
	public void setRequiredHonorRank(int requiredHonorRank) {
		RequiredHonorRank = requiredHonorRank;
	}

	/**
	 * Gets the required city rank.
	 *
	 * @return the requiredCityRank
	 */
	public int getRequiredCityRank() {
		return RequiredCityRank;
	}

	/**
	 * Sets the required city rank.
	 *
	 * @param requiredCityRank the requiredCityRank to set
	 */
	public void setRequiredCityRank(int requiredCityRank) {
		RequiredCityRank = requiredCityRank;
	}

	/**
	 * Gets the required reputation faction.
	 *
	 * @return the requiredReputationFaction
	 */
	public int getRequiredReputationFaction() {
		return RequiredReputationFaction;
	}

	/**
	 * Sets the required reputation faction.
	 *
	 * @param requiredReputationFaction the requiredReputationFaction to set
	 */
	public void setRequiredReputationFaction(int requiredReputationFaction) {
		RequiredReputationFaction = requiredReputationFaction;
	}

	/**
	 * Gets the required reputation rank.
	 *
	 * @return the requiredReputationRank
	 */
	public int getRequiredReputationRank() {
		return RequiredReputationRank;
	}

	/**
	 * Sets the required reputation rank.
	 *
	 * @param requiredReputationRank the requiredReputationRank to set
	 */
	public void setRequiredReputationRank(int requiredReputationRank) {
		RequiredReputationRank = requiredReputationRank;
	}

	/**
	 * Gets the max count.
	 *
	 * @return the maxCount
	 */
	public int getMaxCount() {
		return MaxCount;
	}

	/**
	 * Sets the max count.
	 *
	 * @param maxCount the maxCount to set
	 */
	public void setMaxCount(int maxCount) {
		MaxCount = maxCount;
	}

	/**
	 * Gets the stackable.
	 *
	 * @return the stackable
	 */
	public int getStackable() {
		return Stackable;
	}

	/**
	 * Sets the stackable.
	 *
	 * @param stackable the stackable to set
	 */
	public void setStackable(int stackable) {
		Stackable = stackable;
	}

	/**
	 * Gets the container slots.
	 *
	 * @return the containerSlots
	 */
	public int getContainerSlots() {
		return ContainerSlots;
	}

	/**
	 * Sets the container slots.
	 *
	 * @param containerSlots the containerSlots to set
	 */
	public void setContainerSlots(byte containerSlots) {
		ContainerSlots = containerSlots;
	}

	/**
	 * Gets the stats count.
	 *
	 * @return the statsCount
	 */
	public int getStatsCount() {
		return StatsCount;
	}

	/**
	 * Sets the stats count.
	 *
	 * @param statsCount the statsCount to set
	 */
	public void setStatsCount(int statsCount) {
		StatsCount = statsCount;
	}

	/**
	 * Gets the item stat.
	 *
	 * @param i the i
	 * @return the _ItemStat
	 */
	public _ItemStat getItemStat(int i) {
		return (_ItemStat) ItemStat[i];
	}

	/**
	 * Sets the item stat.
	 *
	 * @param is the new item stat
	 */
	public void setItemStat(Object[] is) {
		ItemStat = is;
	}

	/**
	 * Gets the scaling stat distribution.
	 *
	 * @return the scalingStatDistribution
	 */
	public int getScalingStatDistribution() {
		return ScalingStatDistribution;
	}

	/**
	 * Sets the scaling stat distribution.
	 *
	 * @param scalingStatDistribution the scalingStatDistribution to set
	 */
	public void setScalingStatDistribution(int scalingStatDistribution) {
		ScalingStatDistribution = scalingStatDistribution;
	}

	/**
	 * Gets the scaling stat value.
	 *
	 * @return the scalingStatValue
	 */
	public int getScalingStatValue() {
		return ScalingStatValue;
	}

	/**
	 * Sets the scaling stat value.
	 *
	 * @param scalingStatValue the scalingStatValue to set
	 */
	public void setScalingStatValue(int scalingStatValue) {
		ScalingStatValue = scalingStatValue;
	}

	/**
	 * Gets the damage.
	 *
	 * @param i the i
	 * @return the damage
	 */
	public _Damage getDamage(int i) {
		return Damage[i];
	}


	/**
	 * Sets the damage.
	 *
	 * @param _damage the _damage
	 * @param pos the pos
	 */
	public void setDamage(_Damage _damage, byte pos) {
		
		Damage[pos] = _damage;
	}
	
	/**
	 * Sets the damage.
	 *
	 * @param damageMin the damage min
	 * @param damageMax the damage max
	 * @param damageType the damage type
	 * @param pos the pos
	 */
	public void setDamage(float damageMin, float damageMax, byte damageType, byte pos) {
		Damage[pos] = new _Damage(damageMin, damageMax, damageType);
	}
	
	/**
	 * Gets the armor.
	 *
	 * @return the armor
	 */
	public int getArmor() {
		return Armor;
	}

	/**
	 * Sets the armor.
	 *
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		Armor = armor;
	}

	/**
	 * Gets the holy res.
	 *
	 * @return the holy Resistance
	 */
	public byte getHolyRes() {
		return HolyRes;
	}

	/**
	 * Sets the holy res.
	 *
	 * @param holyRes the holyRes to set
	 */
	public void setHolyRes(byte holyRes) {
		HolyRes = holyRes;
	}

	/**
	 * Gets the fire res.
	 *
	 * @return the fire Resistance
	 */
	public byte getFireRes() {
		return FireRes;
	}

	/**
	 * Sets the fire res.
	 *
	 * @param fireRes the fireRes to set
	 */
	public void setFireRes(byte fireRes) {
		FireRes = fireRes;
	}

	/**
	 * Gets the nature res.
	 *
	 * @return the nature Resistance
	 */
	public byte getNatureRes() {
		return NatureRes;
	}

	/**
	 * Sets the nature res.
	 *
	 * @param natureRes the natureRes to set
	 */
	public void setNatureRes(byte natureRes) {
		NatureRes = natureRes;
	}

	/**
	 * Gets the frost res.
	 *
	 * @return the frostRes
	 */
	public byte getFrostRes() {
		return FrostRes;
	}

	/**
	 * Sets the frost res.
	 *
	 * @param frostRes the frostRes to set
	 */
	public void setFrostRes(byte frostRes) {
		FrostRes = frostRes;
	}

	/**
	 * Gets the shadow res.
	 *
	 * @return the shadowRes
	 */
	public byte getShadowRes() {
		return ShadowRes;
	}

	/**
	 * Sets the shadow res.
	 *
	 * @param shadowRes the shadowRes to set
	 */
	public void setShadowRes(byte shadowRes) {
		ShadowRes = shadowRes;
	}

	/**
	 * Gets the arcane res.
	 *
	 * @return the arcaneRes
	 */
	public byte getArcaneRes() {
		return ArcaneRes;
	}

	/**
	 * Sets the arcane res.
	 *
	 * @param arcaneRes the arcaneRes to set
	 */
	public void setArcaneRes(byte arcaneRes) {
		ArcaneRes = arcaneRes;
	}

	/**
	 * Gets the delay.
	 *
	 * @return the delay
	 */
	public int getDelay() {
		return Delay;
	}

	/**
	 * Sets the delay.
	 *
	 * @param delay the delay to set
	 */
	public void setDelay(int delay) {
		Delay = delay;
	}

	/**
	 * Gets the ammo type.
	 *
	 * @return the ammoType
	 */
	public int getAmmoType() {
		return AmmoType;
	}

	/**
	 * Sets the ammo type.
	 *
	 * @param ammoType the ammoType to set
	 */
	public void setAmmoType(int ammoType) {
		AmmoType = ammoType;
	}

	/**
	 * Gets the ranged mod range.
	 *
	 * @return the rangedModRange
	 */
	public float getRangedModRange() {
		return RangedModRange;
	}

	/**
	 * Sets the ranged mod range.
	 *
	 * @param rangedModRange the rangedModRange to set
	 */
	public void setRangedModRange(float rangedModRange) {
		RangedModRange = rangedModRange;
	}

	/**
	 * Gets the bonding.
	 *
	 * @return the bonding
	 */
	/*
	 * public void setSpells(int _SpellId, byte _SpellTrigger, int
	 * _SpellCharges, float _SpellPPMRate, int _SpellCooldown, int
	 * _SpellCategory, int _SpellCategoryCooldown, byte pos) { SpellId[pos] =
	 * _SpellId; SpellTrigger[pos] = _SpellTrigger; SpellCharges[pos] =
	 * _SpellCharges; SpellPPMRate[pos] = _SpellPPMRate; SpellCooldown[pos] =
	 * _SpellCooldown; SpellCategory[pos] = _SpellCategory;
	 * SpellCategoryCooldown[pos] = _SpellCategoryCooldown; }
	 */
	/**
	 * @return the bonding
	 */
	public int getBonding() {
		return Bonding;
	}

	/**
	 * Sets the bonding.
	 *
	 * @param bonding the bonding to set
	 */
	public void setBonding(byte bonding) {
		Bonding = bonding;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * Gets the page text.
	 *
	 * @return the pageText
	 */
	public int getPageText() {
		return PageText;
	}

	/**
	 * Sets the page text.
	 *
	 * @param pageText the pageText to set
	 */
	public void setPageText(int pageText) {
		PageText = pageText;
	}

	/**
	 * Gets the language id.
	 *
	 * @return the languageID
	 */
	public byte getLanguageID() {
		return LanguageID;
	}

	/**
	 * Sets the language id.
	 *
	 * @param languageID the languageID to set
	 */
	public void setLanguageID(byte languageID) {
		LanguageID = languageID;
	}

	/**
	 * Gets the page material.
	 *
	 * @return the pageMaterial
	 */
	public byte getPageMaterial() {
		return PageMaterial;
	}

	/**
	 * Sets the page material.
	 *
	 * @param pageMaterial the pageMaterial to set
	 */
	public void setPageMaterial(byte pageMaterial) {
		PageMaterial = pageMaterial;
	}

	/**
	 * Gets the start quest.
	 *
	 * @return the startQuest
	 */
	public int getStartQuest() {
		return StartQuest;
	}

	/**
	 * Sets the start quest.
	 *
	 * @param startQuest the startQuest to set
	 */
	public void setStartQuest(int startQuest) {
		StartQuest = startQuest;
	}

	/**
	 * Gets the lock id.
	 *
	 * @return the lockID
	 */
	public int getLockID() {
		return LockID;
	}

	/**
	 * Sets the lock id.
	 *
	 * @param lockID the lockID to set
	 */
	public void setLockID(int lockID) {
		LockID = lockID;
	}

	/**
	 * Gets the material.
	 *
	 * @return the material
	 */
	public int getMaterial() {
		return Material;
	}

	/**
	 * Sets the material.
	 *
	 * @param material the material to set
	 */
	public void setMaterial(int material) {
		Material = material;
	}

	/**
	 * Gets the sheath.
	 *
	 * @return the sheath
	 */
	public byte getSheath() {
		return Sheath;
	}

	/**
	 * Sets the sheath.
	 *
	 * @param sheath the sheath to set
	 */
	public void setSheath(byte sheath) {
		Sheath = sheath;
	}

	/**
	 * Gets the random property.
	 *
	 * @return the randomProperty
	 */
	public int getRandomProperty() {
		return RandomProperty;
	}

	/**
	 * Sets the random property.
	 *
	 * @param randomProperty the randomProperty to set
	 */
	public void setRandomProperty(int randomProperty) {
		RandomProperty = randomProperty;
	}

	/**
	 * Gets the random suffix.
	 *
	 * @return the randomSuffix
	 */
	public int getRandomSuffix() {
		return RandomSuffix;
	}

	/**
	 * Sets the random suffix.
	 *
	 * @param randomSuffix the randomSuffix to set
	 */
	public void setRandomSuffix(int randomSuffix) {
		RandomSuffix = randomSuffix;
	}

	/**
	 * Gets the block.
	 *
	 * @return the block
	 */
	public int getBlock() {
		return Block;
	}

	/**
	 * Sets the block.
	 *
	 * @param block the block to set
	 */
	public void setBlock(int block) {
		Block = block;
	}

	/**
	 * Gets the item set.
	 *
	 * @return the itemSet
	 */
	public int getItemSet() {
		return ItemSet;
	}

	/**
	 * Sets the item set.
	 *
	 * @param itemSet the itemSet to set
	 */
	public void setItemSet(int itemSet) {
		ItemSet = itemSet;
	}

	/**
	 * Gets the max durability.
	 *
	 * @return the maxDurability
	 */
	public int getMaxDurability() {
		return MaxDurability;
	}

	/**
	 * Sets the max durability.
	 *
	 * @param maxDurability the maxDurability to set
	 */
	public void setMaxDurability(int maxDurability) {
		MaxDurability = maxDurability;
	}

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public int getArea() {
		return Area;
	}

	/**
	 * Sets the area.
	 *
	 * @param area the area to set
	 */
	public void setArea(int area) {
		Area = area;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public int getMap() {
		return Map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the map to set
	 */
	public void setMap(int map) {
		Map = map;
	}

	/**
	 * Gets the bag family.
	 *
	 * @return the bagFamily
	 */
	public int getBagFamily() {
		return BagFamily;
	}

	/**
	 * Sets the bag family.
	 *
	 * @param bagFamily the bagFamily to set
	 */
	public void setBagFamily(int bagFamily) {
		BagFamily = bagFamily;
	}

	/**
	 * Gets the totem category.
	 *
	 * @return the totemCategory
	 */
	public int getTotemCategory() {
		return TotemCategory;
	}

	/**
	 * Sets the totem category.
	 *
	 * @param totemCategory the totemCategory to set
	 */
	public void setTotemCategory(int totemCategory) {
		TotemCategory = totemCategory;
	}

	/**
	 * Gets the socket.
	 *
	 * @param i the i
	 * @return the socket
	 */
	public _Socket getSocket(int i) {
		return (_Socket) Socket[i];
	}

	/**
	 * Sets the socket.
	 *
	 * @param ob the new socket
	 */
	public void setSocket(Object[] ob) {
		Socket = ob;
	}

	/**
	 * Gets the socket bonus.
	 *
	 * @return the socketBonus
	 */
	public int getSocketBonus() {
		return socketBonus;
	}

	/**
	 * Sets the socket bonus.
	 *
	 * @param socketBonus the socketBonus to set
	 */
	public void setSocketBonus(int socketBonus) {
		this.socketBonus = socketBonus;
	}

	/**
	 * Gets the gem properties.
	 *
	 * @return the gemProperties
	 */
	public int getGemProperties() {
		return GemProperties;
	}

	/**
	 * Sets the gem properties.
	 *
	 * @param gemProperties the gemProperties to set
	 */
	public void setGemProperties(int gemProperties) {
		GemProperties = gemProperties;
	}

	/**
	 * Gets the required disenchant skill.
	 *
	 * @return the requiredDisenchantSkill
	 */
	public int getRequiredDisenchantSkill() {
		return RequiredDisenchantSkill;
	}

	/**
	 * Sets the required disenchant skill.
	 *
	 * @param requiredDisenchantSkill the requiredDisenchantSkill to set
	 */
	public void setRequiredDisenchantSkill(int requiredDisenchantSkill) {
		RequiredDisenchantSkill = requiredDisenchantSkill;
	}

	/**
	 * Gets the armor damage modifier.
	 *
	 * @return the armorDamageModifier
	 */
	public float getArmorDamageModifier() {
		return ArmorDamageModifier;
	}

	/**
	 * Sets the armor damage modifier.
	 *
	 * @param armorDamageModifier the armorDamageModifier to set
	 */
	public void setArmorDamageModifier(float armorDamageModifier) {
		ArmorDamageModifier = armorDamageModifier;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return Duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		Duration = duration;
	}

	/**
	 * Gets the item limit category.
	 *
	 * @return the itemLimitCategory
	 */
	public int getItemLimitCategory() {
		return ItemLimitCategory;
	}

	/**
	 * Sets the item limit category.
	 *
	 * @param itemLimitCategory the itemLimitCategory to set
	 */
	public void setItemLimitCategory(int itemLimitCategory) {
		ItemLimitCategory = itemLimitCategory;
	}

	/**
	 * Gets the holiday id.
	 *
	 * @return the holidayId
	 */
	public int getHolidayId() {
		return HolidayId;
	}

	/**
	 * Sets the holiday id.
	 *
	 * @param holidayId the holidayId to set
	 */
	public void setHolidayId(int holidayId) {
		HolidayId = holidayId;
	}

	/**
	 * Gets the script id.
	 *
	 * @return the scriptId
	 */
	public int getScriptId() {
		return ScriptId;
	}

	/**
	 * Sets the script id.
	 *
	 * @param scriptId the scriptId to set
	 */
	public void setScriptId(int scriptId) {
		ScriptId = scriptId;
	}

	/**
	 * Gets the disenchant id.
	 *
	 * @return the disenchantID
	 */
	public int getDisenchantID() {
		return DisenchantID;
	}

	/**
	 * Sets the disenchant id.
	 *
	 * @param disenchantID the disenchantID to set
	 */
	public void setDisenchantID(int disenchantID) {
		DisenchantID = disenchantID;
	}

	/**
	 * Gets the food type.
	 *
	 * @return the foodType
	 */
	public byte getFoodType() {
		return FoodType;
	}

	/**
	 * Sets the food type.
	 *
	 * @param foodType the foodType to set
	 */
	public void setFoodType(byte foodType) {
		FoodType = foodType;
	}

	/**
	 * Gets the min money loot.
	 *
	 * @return the minMoneyLoot
	 */
	public int getMinMoneyLoot() {
		return MinMoneyLoot;
	}

	/**
	 * Sets the min money loot.
	 *
	 * @param minMoneyLoot the minMoneyLoot to set
	 */
	public void setMinMoneyLoot(int minMoneyLoot) {
		MinMoneyLoot = minMoneyLoot;
	}

	/**
	 * Gets the max money loot.
	 *
	 * @return the maxMoneyLoot
	 */
	public int getMaxMoneyLoot() {
		return MaxMoneyLoot;
	}

	/**
	 * Sets the max money loot.
	 *
	 * @param maxMoneyLoot the maxMoneyLoot to set
	 */
	public void setMaxMoneyLoot(int maxMoneyLoot) {
		MaxMoneyLoot = maxMoneyLoot;
	}

	/**
	 * Gets the extra flags.
	 *
	 * @return the extraFlags
	 */
	public byte getExtraFlags() {
		return ExtraFlags;
	}

	/**
	 * Sets the extra flags.
	 *
	 * @param extraFlags the extraFlags to set
	 */
	public void setExtraFlags(byte extraFlags) {
		ExtraFlags = extraFlags;
	}

	/**
	 * Gets the flags2.
	 *
	 * @return the flags2
	 */
	public int getFlags2() {
		return Flags2;
	}

	/**
	 * Sets the flags2.
	 *
	 * @param flags2 the new flags2
	 */
	public void setFlags2(int flags2) {
		Flags2 = flags2;
	}

}
