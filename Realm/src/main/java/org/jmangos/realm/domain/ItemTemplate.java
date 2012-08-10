package org.jmangos.realm.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
@Table(name="item_template")
@Entity
public class ItemTemplate {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private int entry;

    @Column(name = "entry", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Id
    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    private byte clazz;

    @Column(name = "class", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getClazz() {
        return clazz;
    }

    public void setClazz(byte clazz) {
        this.clazz = clazz;
    }

    private byte subclass;

    @Column(name = "subclass", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSubclass() {
        return subclass;
    }

    public void setSubclass(byte subclass) {
        this.subclass = subclass;
    }

    private int unk0;

    @Column(name = "unk0", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getUnk0() {
        return unk0;
    }

    public void setUnk0(int unk0) {
        this.unk0 = unk0;
    }

    private String name;

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int displayid;

    @Column(name = "displayid", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getDisplayid() {
        return displayid;
    }

    public void setDisplayid(int displayid) {
        this.displayid = displayid;
    }

    private byte quality;

    @Column(name = "Quality", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getQuality() {
        return quality;
    }

    public void setQuality(byte quality) {
        this.quality = quality;
    }

    private int flags;

    @Column(name = "Flags", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    private int flags2;

    @Column(name = "Flags2", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getFlags2() {
        return flags2;
    }

    public void setFlags2(int flags2) {
        this.flags2 = flags2;
    }

    private byte buyCount;

    @Column(name = "BuyCount", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(byte buyCount) {
        this.buyCount = buyCount;
    }

    private int buyPrice;

    @Column(name = "BuyPrice", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    private int sellPrice;

    @Column(name = "SellPrice", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    private byte inventoryType;

    @Column(name = "InventoryType", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(byte inventoryType) {
        this.inventoryType = inventoryType;
    }

    private int allowableClass;

    @Column(name = "AllowableClass", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getAllowableClass() {
        return allowableClass;
    }

    public void setAllowableClass(int allowableClass) {
        this.allowableClass = allowableClass;
    }

    private int allowableRace;

    @Column(name = "AllowableRace", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getAllowableRace() {
        return allowableRace;
    }

    public void setAllowableRace(int allowableRace) {
        this.allowableRace = allowableRace;
    }

    private short itemLevel;

    @Column(name = "ItemLevel", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(short itemLevel) {
        this.itemLevel = itemLevel;
    }

    private byte requiredLevel;

    @Column(name = "RequiredLevel", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(byte requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    private short requiredSkill;

    @Column(name = "RequiredSkill", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(short requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    private short requiredSkillRank;

    @Column(name = "RequiredSkillRank", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredSkillRank() {
        return requiredSkillRank;
    }

    public void setRequiredSkillRank(short requiredSkillRank) {
        this.requiredSkillRank = requiredSkillRank;
    }

    private int requiredspell;

    @Column(name = "requiredspell", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRequiredspell() {
        return requiredspell;
    }

    public void setRequiredspell(int requiredspell) {
        this.requiredspell = requiredspell;
    }

    private int requiredhonorrank;

    @Column(name = "requiredhonorrank", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRequiredhonorrank() {
        return requiredhonorrank;
    }

    public void setRequiredhonorrank(int requiredhonorrank) {
        this.requiredhonorrank = requiredhonorrank;
    }

    private int requiredCityRank;

    @Column(name = "RequiredCityRank", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRequiredCityRank() {
        return requiredCityRank;
    }

    public void setRequiredCityRank(int requiredCityRank) {
        this.requiredCityRank = requiredCityRank;
    }

    private short requiredReputationFaction;

    @Column(name = "RequiredReputationFaction", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredReputationFaction() {
        return requiredReputationFaction;
    }

    public void setRequiredReputationFaction(short requiredReputationFaction) {
        this.requiredReputationFaction = requiredReputationFaction;
    }

    private short requiredReputationRank;

    @Column(name = "RequiredReputationRank", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredReputationRank() {
        return requiredReputationRank;
    }

    public void setRequiredReputationRank(short requiredReputationRank) {
        this.requiredReputationRank = requiredReputationRank;
    }

    private short maxcount;

    @Column(name = "maxcount", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(short maxcount) {
        this.maxcount = maxcount;
    }

    private short stackable;

    @Column(name = "stackable", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStackable() {
        return stackable;
    }

    public void setStackable(short stackable) {
        this.stackable = stackable;
    }

    private byte containerSlots;

    @Column(name = "ContainerSlots", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getContainerSlots() {
        return containerSlots;
    }

    public void setContainerSlots(byte containerSlots) {
        this.containerSlots = containerSlots;
    }

    private byte statsCount;

    @Column(name = "StatsCount", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatsCount() {
        return statsCount;
    }

    public void setStatsCount(byte statsCount) {
        this.statsCount = statsCount;
    }

    private byte statType1;

    @Column(name = "stat_type1", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType1() {
        return statType1;
    }

    public void setStatType1(byte statType1) {
        this.statType1 = statType1;
    }

    private short statValue1;

    @Column(name = "stat_value1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue1() {
        return statValue1;
    }

    public void setStatValue1(short statValue1) {
        this.statValue1 = statValue1;
    }

    private byte statType2;

    @Column(name = "stat_type2", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType2() {
        return statType2;
    }

    public void setStatType2(byte statType2) {
        this.statType2 = statType2;
    }

    private short statValue2;

    @Column(name = "stat_value2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue2() {
        return statValue2;
    }

    public void setStatValue2(short statValue2) {
        this.statValue2 = statValue2;
    }

    private byte statType3;

    @Column(name = "stat_type3", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType3() {
        return statType3;
    }

    public void setStatType3(byte statType3) {
        this.statType3 = statType3;
    }

    private short statValue3;

    @Column(name = "stat_value3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue3() {
        return statValue3;
    }

    public void setStatValue3(short statValue3) {
        this.statValue3 = statValue3;
    }

    private byte statType4;

    @Column(name = "stat_type4", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType4() {
        return statType4;
    }

    public void setStatType4(byte statType4) {
        this.statType4 = statType4;
    }

    private short statValue4;

    @Column(name = "stat_value4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue4() {
        return statValue4;
    }

    public void setStatValue4(short statValue4) {
        this.statValue4 = statValue4;
    }

    private byte statType5;

    @Column(name = "stat_type5", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType5() {
        return statType5;
    }

    public void setStatType5(byte statType5) {
        this.statType5 = statType5;
    }

    private short statValue5;

    @Column(name = "stat_value5", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue5() {
        return statValue5;
    }

    public void setStatValue5(short statValue5) {
        this.statValue5 = statValue5;
    }

    private byte statType6;

    @Column(name = "stat_type6", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType6() {
        return statType6;
    }

    public void setStatType6(byte statType6) {
        this.statType6 = statType6;
    }

    private short statValue6;

    @Column(name = "stat_value6", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue6() {
        return statValue6;
    }

    public void setStatValue6(short statValue6) {
        this.statValue6 = statValue6;
    }

    private byte statType7;

    @Column(name = "stat_type7", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType7() {
        return statType7;
    }

    public void setStatType7(byte statType7) {
        this.statType7 = statType7;
    }

    private short statValue7;

    @Column(name = "stat_value7", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue7() {
        return statValue7;
    }

    public void setStatValue7(short statValue7) {
        this.statValue7 = statValue7;
    }

    private byte statType8;

    @Column(name = "stat_type8", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType8() {
        return statType8;
    }

    public void setStatType8(byte statType8) {
        this.statType8 = statType8;
    }

    private short statValue8;

    @Column(name="stat_value8", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue8() {
        return statValue8;
    }

    public void setStatValue8(short statValue8) {
        this.statValue8 = statValue8;
    }

    private byte statType9;

    @Column(name = "stat_type9", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType9() {
        return statType9;
    }

    public void setStatType9(byte statType9) {
        this.statType9 = statType9;
    }

    private short statValue9;

    @Column(name = "stat_value9", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue9() {
        return statValue9;
    }

    public void setStatValue9(short statValue9) {
        this.statValue9 = statValue9;
    }

    private byte statType10;

    @Column(name="stat_type10", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getStatType10() {
        return statType10;
    }

    public void setStatType10(byte statType10) {
        this.statType10 = statType10;
    }

    private short statValue10;

    @Column(name="stat_value10", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStatValue10() {
        return statValue10;
    }

    public void setStatValue10(short statValue10) {
        this.statValue10 = statValue10;
    }

    private short scalingStatDistribution;

    @Column(name="scalingStatDistribution", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getScalingStatDistribution() {
        return scalingStatDistribution;
    }

    public void setScalingStatDistribution(short scalingStatDistribution) {
        this.scalingStatDistribution = scalingStatDistribution;
    }

    private int scalingStatValue;

    @Column(name="scalingStatValue", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getScalingStatValue() {
        return scalingStatValue;
    }

    public void setScalingStatValue(int scalingStatValue) {
        this.scalingStatValue = scalingStatValue;
    }

    private float dmgMin1;

    @Column(name="dmg_min1", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getDmgMin1() {
        return dmgMin1;
    }

    public void setDmgMin1(float dmgMin1) {
        this.dmgMin1 = dmgMin1;
    }

    private float dmgMax1;

    @Column(name = "dmg_max1", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getDmgMax1() {
        return dmgMax1;
    }

    public void setDmgMax1(float dmgMax1) {
        this.dmgMax1 = dmgMax1;
    }

    private byte dmgType1;

    @Column(name = "dmg_type1", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getDmgType1() {
        return dmgType1;
    }

    public void setDmgType1(byte dmgType1) {
        this.dmgType1 = dmgType1;
    }

    private float dmgMin2;

    @Column(name = "dmg_min2", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getDmgMin2() {
        return dmgMin2;
    }

    public void setDmgMin2(float dmgMin2) {
        this.dmgMin2 = dmgMin2;
    }

    private float dmgMax2;

    @Column(name = "dmg_max2", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getDmgMax2() {
        return dmgMax2;
    }

    public void setDmgMax2(float dmgMax2) {
        this.dmgMax2 = dmgMax2;
    }

    private byte dmgType2;

    @Column(name = "dmg_type2", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getDmgType2() {
        return dmgType2;
    }

    public void setDmgType2(byte dmgType2) {
        this.dmgType2 = dmgType2;
    }

    private short armor;

    @Column(name = "armor", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getArmor() {
        return armor;
    }

    public void setArmor(short armor) {
        this.armor = armor;
    }

    private byte holyRes;

    @Column(name = "holy_res", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getHolyRes() {
        return holyRes;
    }

    public void setHolyRes(byte holyRes) {
        this.holyRes = holyRes;
    }

    private byte fireRes;

    @Column(name="fire_res", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getFireRes() {
        return fireRes;
    }

    public void setFireRes(byte fireRes) {
        this.fireRes = fireRes;
    }

    private byte natureRes;

    @Column(name = "nature_res", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getNatureRes() {
        return natureRes;
    }

    public void setNatureRes(byte natureRes) {
        this.natureRes = natureRes;
    }

    private byte frostRes;

    @Column(name = "frost_res", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getFrostRes() {
        return frostRes;
    }

    public void setFrostRes(byte frostRes) {
        this.frostRes = frostRes;
    }

    private byte shadowRes;

    @Column(name = "shadow_res", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getShadowRes() {
        return shadowRes;
    }

    public void setShadowRes(byte shadowRes) {
        this.shadowRes = shadowRes;
    }

    private byte arcaneRes;

    @Column(name = "arcane_res", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getArcaneRes() {
        return arcaneRes;
    }

    public void setArcaneRes(byte arcaneRes) {
        this.arcaneRes = arcaneRes;
    }

    private short delay;

    @Column(name = "delay", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getDelay() {
        return delay;
    }

    public void setDelay(short delay) {
        this.delay = delay;
    }

    private byte ammoType;

    @Column(name = "ammo_type", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(byte ammoType) {
        this.ammoType = ammoType;
    }

    private float rangedModRange;

    @Column(name = "RangedModRange", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getRangedModRange() {
        return rangedModRange;
    }

    public void setRangedModRange(float rangedModRange) {
        this.rangedModRange = rangedModRange;
    }

    private int spellid1;

    @Column(name = "spellid_1", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSpellid1() {
        return spellid1;
    }

    public void setSpellid1(int spellid1) {
        this.spellid1 = spellid1;
    }

    private byte spelltrigger1;

    @Column(name = "spelltrigger_1", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSpelltrigger1() {
        return spelltrigger1;
    }

    public void setSpelltrigger1(byte spelltrigger1) {
        this.spelltrigger1 = spelltrigger1;
    }

    private short spellcharges1;

    @Column(name = "spellcharges_1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcharges1() {
        return spellcharges1;
    }

    public void setSpellcharges1(short spellcharges1) {
        this.spellcharges1 = spellcharges1;
    }

    private float spellppmRate1;

    @Column(name = "spellppmRate_1", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getSpellppmRate1() {
        return spellppmRate1;
    }

    public void setSpellppmRate1(float spellppmRate1) {
        this.spellppmRate1 = spellppmRate1;
    }

    private int spellcooldown1;

    @Column(name = "spellcooldown_1", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcooldown1() {
        return spellcooldown1;
    }

    public void setSpellcooldown1(int spellcooldown1) {
        this.spellcooldown1 = spellcooldown1;
    }

    private short spellcategory1;

    @Column(name = "spellcategory_1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcategory1() {
        return spellcategory1;
    }

    public void setSpellcategory1(short spellcategory1) {
        this.spellcategory1 = spellcategory1;
    }

    private int spellcategorycooldown1;

    @Column(name = "spellcategorycooldown_1", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcategorycooldown1() {
        return spellcategorycooldown1;
    }

    public void setSpellcategorycooldown1(int spellcategorycooldown1) {
        this.spellcategorycooldown1 = spellcategorycooldown1;
    }

    private int spellid2;

    @Column(name = "spellid_2", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSpellid2() {
        return spellid2;
    }

    public void setSpellid2(int spellid2) {
        this.spellid2 = spellid2;
    }

    private byte spelltrigger2;

    @Column(name = "spelltrigger_2", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSpelltrigger2() {
        return spelltrigger2;
    }

    public void setSpelltrigger2(byte spelltrigger2) {
        this.spelltrigger2 = spelltrigger2;
    }

    private short spellcharges2;

    @Column(name = "spellcharges_2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcharges2() {
        return spellcharges2;
    }

    public void setSpellcharges2(short spellcharges2) {
        this.spellcharges2 = spellcharges2;
    }

    private float spellppmRate2;

    @Column(name = "spellppmRate_2", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getSpellppmRate2() {
        return spellppmRate2;
    }

    public void setSpellppmRate2(float spellppmRate2) {
        this.spellppmRate2 = spellppmRate2;
    }

    private int spellcooldown2;

    @Column(name = "spellcooldown_2", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcooldown2() {
        return spellcooldown2;
    }

    public void setSpellcooldown2(int spellcooldown2) {
        this.spellcooldown2 = spellcooldown2;
    }

    private short spellcategory2;

    @Column(name = "spellcategory_2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcategory2() {
        return spellcategory2;
    }

    public void setSpellcategory2(short spellcategory2) {
        this.spellcategory2 = spellcategory2;
    }

    private int spellcategorycooldown2;

    @Column(name = "spellcategorycooldown_2", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcategorycooldown2() {
        return spellcategorycooldown2;
    }

    public void setSpellcategorycooldown2(int spellcategorycooldown2) {
        this.spellcategorycooldown2 = spellcategorycooldown2;
    }

    private int spellid3;

    @Column(name = "spellid_3", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSpellid3() {
        return spellid3;
    }

    public void setSpellid3(int spellid3) {
        this.spellid3 = spellid3;
    }

    private byte spelltrigger3;

    @Column(name = "spelltrigger_3", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSpelltrigger3() {
        return spelltrigger3;
    }

    public void setSpelltrigger3(byte spelltrigger3) {
        this.spelltrigger3 = spelltrigger3;
    }

    private short spellcharges3;

    @Column(name = "spellcharges_3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcharges3() {
        return spellcharges3;
    }

    public void setSpellcharges3(short spellcharges3) {
        this.spellcharges3 = spellcharges3;
    }

    private float spellppmRate3;

    @Column(name = "spellppmRate_3", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getSpellppmRate3() {
        return spellppmRate3;
    }

    public void setSpellppmRate3(float spellppmRate3) {
        this.spellppmRate3 = spellppmRate3;
    }

    private int spellcooldown3;

    @Column(name = "spellcooldown_3", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcooldown3() {
        return spellcooldown3;
    }

    public void setSpellcooldown3(int spellcooldown3) {
        this.spellcooldown3 = spellcooldown3;
    }

    private short spellcategory3;

    @Column(name = "spellcategory_3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcategory3() {
        return spellcategory3;
    }

    public void setSpellcategory3(short spellcategory3) {
        this.spellcategory3 = spellcategory3;
    }

    private int spellcategorycooldown3;

    @Column(name = "spellcategorycooldown_3", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcategorycooldown3() {
        return spellcategorycooldown3;
    }

    public void setSpellcategorycooldown3(int spellcategorycooldown3) {
        this.spellcategorycooldown3 = spellcategorycooldown3;
    }

    private int spellid4;

    @Column(name = "spellid_4", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSpellid4() {
        return spellid4;
    }

    public void setSpellid4(int spellid4) {
        this.spellid4 = spellid4;
    }

    private byte spelltrigger4;

    @Column(name = "spelltrigger_4", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSpelltrigger4() {
        return spelltrigger4;
    }

    public void setSpelltrigger4(byte spelltrigger4) {
        this.spelltrigger4 = spelltrigger4;
    }

    private short spellcharges4;

    @Column(name = "spellcharges_4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcharges4() {
        return spellcharges4;
    }

    public void setSpellcharges4(short spellcharges4) {
        this.spellcharges4 = spellcharges4;
    }

    private float spellppmRate4;

    @Column(name = "spellppmRate_4", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getSpellppmRate4() {
        return spellppmRate4;
    }

    public void setSpellppmRate4(float spellppmRate4) {
        this.spellppmRate4 = spellppmRate4;
    }

    private int spellcooldown4;

    @Column(name = "spellcooldown_4", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcooldown4() {
        return spellcooldown4;
    }

    public void setSpellcooldown4(int spellcooldown4) {
        this.spellcooldown4 = spellcooldown4;
    }

    private short spellcategory4;

    @Column(name = "spellcategory_4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcategory4() {
        return spellcategory4;
    }

    public void setSpellcategory4(short spellcategory4) {
        this.spellcategory4 = spellcategory4;
    }

    private int spellcategorycooldown4;

    @Column(name = "spellcategorycooldown_4", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcategorycooldown4() {
        return spellcategorycooldown4;
    }

    public void setSpellcategorycooldown4(int spellcategorycooldown4) {
        this.spellcategorycooldown4 = spellcategorycooldown4;
    }

    private int spellid5;

    @Column(name = "spellid_5", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSpellid5() {
        return spellid5;
    }

    public void setSpellid5(int spellid5) {
        this.spellid5 = spellid5;
    }

    private byte spelltrigger5;

    @Column(name = "spelltrigger_5", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSpelltrigger5() {
        return spelltrigger5;
    }

    public void setSpelltrigger5(byte spelltrigger5) {
        this.spelltrigger5 = spelltrigger5;
    }

    private short spellcharges5;

    @Column(name = "spellcharges_5", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcharges5() {
        return spellcharges5;
    }

    public void setSpellcharges5(short spellcharges5) {
        this.spellcharges5 = spellcharges5;
    }

    private float spellppmRate5;

    @Column(name = "spellppmRate_5", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getSpellppmRate5() {
        return spellppmRate5;
    }

    public void setSpellppmRate5(float spellppmRate5) {
        this.spellppmRate5 = spellppmRate5;
    }

    private int spellcooldown5;

    @Column(name = "spellcooldown_5", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcooldown5() {
        return spellcooldown5;
    }

    public void setSpellcooldown5(int spellcooldown5) {
        this.spellcooldown5 = spellcooldown5;
    }

    private short spellcategory5;

    @Column(name = "spellcategory_5", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getSpellcategory5() {
        return spellcategory5;
    }

    public void setSpellcategory5(short spellcategory5) {
        this.spellcategory5 = spellcategory5;
    }

    private int spellcategorycooldown5;

    @Column(name = "spellcategorycooldown_5", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSpellcategorycooldown5() {
        return spellcategorycooldown5;
    }

    public void setSpellcategorycooldown5(int spellcategorycooldown5) {
        this.spellcategorycooldown5 = spellcategorycooldown5;
    }

    private byte bonding;

    @Column(name = "bonding", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getBonding() {
        return bonding;
    }

    public void setBonding(byte bonding) {
        this.bonding = bonding;
    }

    private String description;

    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int pageText;

    @Column(name = "PageText", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getPageText() {
        return pageText;
    }

    public void setPageText(int pageText) {
        this.pageText = pageText;
    }

    private byte languageId;

    @Column(name = "LanguageID", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(byte languageId) {
        this.languageId = languageId;
    }

    private byte pageMaterial;

    @Column(name = "PageMaterial", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getPageMaterial() {
        return pageMaterial;
    }

    public void setPageMaterial(byte pageMaterial) {
        this.pageMaterial = pageMaterial;
    }

    private int startquest;

    @Column(name = "startquest", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getStartquest() {
        return startquest;
    }

    public void setStartquest(int startquest) {
        this.startquest = startquest;
    }

    private int lockid;

    @Column(name = "lockid", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getLockid() {
        return lockid;
    }

    public void setLockid(int lockid) {
        this.lockid = lockid;
    }

    private byte material;

    @Column(name = "Material", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getMaterial() {
        return material;
    }

    public void setMaterial(byte material) {
        this.material = material;
    }

    private byte sheath;

    @Column(name = "sheath", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSheath() {
        return sheath;
    }

    public void setSheath(byte sheath) {
        this.sheath = sheath;
    }

    private int randomProperty;

    @Column(name = "RandomProperty", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRandomProperty() {
        return randomProperty;
    }

    public void setRandomProperty(int randomProperty) {
        this.randomProperty = randomProperty;
    }

    private int randomSuffix;

    @Column(name = "RandomSuffix", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRandomSuffix() {
        return randomSuffix;
    }

    public void setRandomSuffix(int randomSuffix) {
        this.randomSuffix = randomSuffix;
    }

    private int block;

    @Column(name = "block", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    private int itemset;

    @Column(name = "itemset", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getItemset() {
        return itemset;
    }

    public void setItemset(int itemset) {
        this.itemset = itemset;
    }

    private short maxDurability;

    @Column(name = "MaxDurability", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(short maxDurability) {
        this.maxDurability = maxDurability;
    }

    private int area;

    @Column(name = "area", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    private short map;

    @Column(name = "Map", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getMap() {
        return map;
    }

    public void setMap(short map) {
        this.map = map;
    }

    private int bagFamily;

    @Column(name = "BagFamily", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getBagFamily() {
        return bagFamily;
    }

    public void setBagFamily(int bagFamily) {
        this.bagFamily = bagFamily;
    }

    private int totemCategory;

    @Column(name = "TotemCategory", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getTotemCategory() {
        return totemCategory;
    }

    public void setTotemCategory(int totemCategory) {
        this.totemCategory = totemCategory;
    }

    private byte socketColor1;

    @Column(name = "socketColor_1", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSocketColor1() {
        return socketColor1;
    }

    public void setSocketColor1(byte socketColor1) {
        this.socketColor1 = socketColor1;
    }

    private int socketContent1;

    @Column(name = "socketContent_1", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getSocketContent1() {
        return socketContent1;
    }

    public void setSocketContent1(int socketContent1) {
        this.socketContent1 = socketContent1;
    }

    private byte socketColor2;

    @Column(name = "socketColor_2", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSocketColor2() {
        return socketColor2;
    }

    public void setSocketColor2(byte socketColor2) {
        this.socketColor2 = socketColor2;
    }

    private int socketContent2;

    @Column(name = "socketContent_2", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getSocketContent2() {
        return socketContent2;
    }

    public void setSocketContent2(int socketContent2) {
        this.socketContent2 = socketContent2;
    }

    private byte socketColor3;

    @Column(name = "socketColor_3", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSocketColor3() {
        return socketColor3;
    }

    public void setSocketColor3(byte socketColor3) {
        this.socketColor3 = socketColor3;
    }

    private int socketContent3;

    @Column(name = "socketContent_3", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getSocketContent3() {
        return socketContent3;
    }

    public void setSocketContent3(int socketContent3) {
        this.socketContent3 = socketContent3;
    }

    private int socketBonus;

    @Column(name = "socketBonus", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getSocketBonus() {
        return socketBonus;
    }

    public void setSocketBonus(int socketBonus) {
        this.socketBonus = socketBonus;
    }

    private int gemProperties;

    @Column(name = "GemProperties", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getGemProperties() {
        return gemProperties;
    }

    public void setGemProperties(int gemProperties) {
        this.gemProperties = gemProperties;
    }

    private short requiredDisenchantSkill;

    @Column(name = "RequiredDisenchantSkill", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredDisenchantSkill() {
        return requiredDisenchantSkill;
    }

    public void setRequiredDisenchantSkill(short requiredDisenchantSkill) {
        this.requiredDisenchantSkill = requiredDisenchantSkill;
    }

    private float armorDamageModifier;

    @Column(name = "ArmorDamageModifier", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getArmorDamageModifier() {
        return armorDamageModifier;
    }

    public void setArmorDamageModifier(float armorDamageModifier) {
        this.armorDamageModifier = armorDamageModifier;
    }

    private int duration;

    @Column(name = "Duration", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private short itemLimitCategory;

    @Column(name = "ItemLimitCategory", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getItemLimitCategory() {
        return itemLimitCategory;
    }

    public void setItemLimitCategory(short itemLimitCategory) {
        this.itemLimitCategory = itemLimitCategory;
    }

    private int holidayId;

    @Column(name = "HolidayId", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    private String scriptName;

    @Column(name = "ScriptName", nullable = false, insertable = true, updatable = true, length = 64, precision = 0)
    @Basic
    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    private int disenchantId;

    @Column(name = "DisenchantID", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getDisenchantId() {
        return disenchantId;
    }

    public void setDisenchantId(int disenchantId) {
        this.disenchantId = disenchantId;
    }

    private byte foodType;

    @Column(name = "FoodType", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getFoodType() {
        return foodType;
    }

    public void setFoodType(byte foodType) {
        this.foodType = foodType;
    }

    private int minMoneyLoot;

    @Column(name = "minMoneyLoot", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getMinMoneyLoot() {
        return minMoneyLoot;
    }

    public void setMinMoneyLoot(int minMoneyLoot) {
        this.minMoneyLoot = minMoneyLoot;
    }

    private int maxMoneyLoot;

    @Column(name = "maxMoneyLoot", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getMaxMoneyLoot() {
        return maxMoneyLoot;
    }

    public void setMaxMoneyLoot(int maxMoneyLoot) {
        this.maxMoneyLoot = maxMoneyLoot;
    }

    private boolean extraFlags;

    @Column(name = "ExtraFlags", nullable = false, insertable = true, updatable = true, length = 0, precision = 0)
    @Basic
    public boolean isExtraFlags() {
        return extraFlags;
    }

    public void setExtraFlags(boolean extraFlags) {
        this.extraFlags = extraFlags;
    }
}
