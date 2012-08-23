package org.jmangos.realm.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Races;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.11. Time:
 * 19:20
 */
@Entity
@Table(name = "characters")
public class CharacterData {
    
    @Id
    @TableGenerator(table = "sequences", allocationSize = 1, name = "char_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "char_seq")
    @Column(name = "guid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private long                guid;
    
    @Basic
    @Column(name = "account", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Long                 account;
    
    @Basic
    @Column(name = "actionBars", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 actionBars;
    
    @Basic
    @Column(name = "activeSpec", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 activeSpec;
    
    @Basic
    @Column(name = "ammoId", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 ammoId;
    
    @Basic
    @Column(name = "arenaPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 arenaPoints;
    
    @Basic
    @Column(name = "at_login", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 atLoginFlags;
    
    @Basic
    @Column(name = "chosenTitle", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 chosenTitle;
    
    @Basic
    @Column(name = "cinematic", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    private boolean             cinematic;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "class", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private Classes             clazz;
    
    @Basic
    @Column(name = "death_expire_time", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    private long                deathExpireTime;
    
    @Basic
    @Column(name = "deleteDate", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    private long                deleteDate;
    
    @Basic
    @Column(name = "deleteInfos_Account", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 deleteInfosAccount;
    
    @Basic
    @Column(name = "deleteInfos_Name", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              deleteInfosName;
    
    @Basic
    @Column(name = "drunk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 drunk;
    
    @Basic
    @Column(name = "dungeon_difficulty", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 dungeonDifficulty;
    
    @Basic
    @Column(name = "equipmentCache", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              equipmentCache;
    
    @Basic
    @Column(name = "exploredZones", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              exploredZones;
    
    @Basic
    @Column(name = "extra_flags", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 extraFlags;
    
    @Basic
    @Column(name = "gender", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 gender;
    
    @Basic
    @Column(name = "health", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 health;
    
    @Basic
    @Column(name = "is_logout_resting", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    private boolean             isLogoutResting;
    
    @Basic
    @Column(name = "knownCurrencies", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    private long                knownCurrencies;
    
    @Basic
    @Column(name = "knownTitles", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              knownTitles;
    
    @Basic
    @Column(name = "level", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 level;
    
    @Basic
    @Column(name = "leveltime", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 leveltime;
    
    @Basic
    @Column(name = "logout_time", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    private long                logoutTime;
    
    @Basic
    @Column(name = "map", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 map;
    
    @Basic
    @Column(name = "money", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 money;
    
    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              name;
    
    @Basic
    @Column(name = "online", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    private boolean             online;
    
    @Basic
    @Column(name = "orientation", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               orientation;
    
    @Basic
    @Column(name = "playerBytes", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 playerBytes;
    
    @Basic
    @Column(name = "playerBytes2", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 playerBytes2;
    
    @Basic
    @Column(name = "playerFlags", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 playerFlags;
    
    @Basic
    @Column(name = "position_x", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               positionX;
    
    @Basic
    @Column(name = "position_y", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               positionY;
    
    @Basic
    @Column(name = "position_z", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               positionZ;
    
    @Basic
    @Column(name = "power1", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power1;
    
    @Basic
    @Column(name = "power2", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power2;
    
    @Basic
    @Column(name = "power3", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power3;
    
    @Basic
    @Column(name = "power4", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power4;
    
    @Basic
    @Column(name = "power5", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power5;
    
    @Basic
    @Column(name = "power6", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power6;
    
    @Basic
    @Column(name = "power7", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 power7;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "race", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private Races               race;
    
    @Basic
    @Column(name = "resettalents_cost", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 resettalentsCost;
    
    @Basic
    @Column(name = "resettalents_time", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 resettalentsTime;
    
    @Basic
    @Column(name = "rest_bonus", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               restBonus;
    
    @Basic
    @Column(name = "specCount", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 specCount;
    
    @Basic
    @Column(name = "stable_slots", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 stableSlots;
    
    @Basic
    @Column(name = "taxi_path", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              taxiPath;
    
    @Basic
    @Column(name = "taximask", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    private String              taximask;
    
    @Basic
    @Column(name = "todayHonorPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 todayHonorPoints;
    
    @Basic
    @Column(name = "todayKills", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 todayKills;
    
    @Basic
    @Column(name = "totalHonorPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 totalHonorPoints;
    
    @Basic
    @Column(name = "totalKills", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 totalKills;
    
    @Basic
    @Column(name = "totaltime", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 totaltime;
    
    @Basic
    @Column(name = "trans_o", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               transO;
    
    @Basic
    @Column(name = "trans_x", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               transX;
    
    @Basic
    @Column(name = "trans_y", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               transY;
    
    @Basic
    @Column(name = "trans_z", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
    private float               transZ;
    
    @Basic
    @Column(name = "transguid", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 transguid;
    
    @Basic
    @Column(name = "watchedFaction", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 watchedFaction;
    
    @Basic
    @Column(name = "xp", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 xp;
    
    @Basic
    @Column(name = "yesterdayHonorPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 yesterdayHonorPoints;
    
    @Basic
    @Column(name = "yesterdayKills", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 yesterdayKills;
    
    @Basic
    @Column(name = "zone", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private int                 zone;
    
    @OneToOne(targetEntity = PlayerHomeBindData.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PlayerHomeBindData  homeBindData;
    
    @JoinColumn(referencedColumnName = "guid")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryItem> inventory = new ArrayList<InventoryItem>();
    
    /**
     * Find item by inventory slot
     * 
     * @param slot
     * @return
     */
    public InventoryItem findInventorySlot(final int slot) {
    
        for (final InventoryItem invItem : this.inventory) {
            if (invItem.getSlot() == slot) {
                return invItem;
            }
        }
        // :( not found
        return null;
    }
    
    /**
     * Empty constructor
     */
    public CharacterData() {
    
    }
    
    public long getGuid() {
    
        return this.guid;
    }
    
    public void setGuid(final long guid) {
    
        this.guid = guid;
    }
    
    public Long getAccount() {
    
        return this.account;
    }
    
    public void setAccount(final Long account) {
    
        this.account = account;
    }
    
    public int getActionBars() {
    
        return this.actionBars;
    }
    
    public void setActionBars(final int actionBars) {
    
        this.actionBars = actionBars;
    }
    
    public int getActiveSpec() {
    
        return this.activeSpec;
    }
    
    public void setActiveSpec(final int activeSpec) {
    
        this.activeSpec = activeSpec;
    }
    
    public int getAmmoId() {
    
        return this.ammoId;
    }
    
    public void setAmmoId(final int ammoId) {
    
        this.ammoId = ammoId;
    }
    
    public int getArenaPoints() {
    
        return this.arenaPoints;
    }
    
    public void setArenaPoints(final int arenaPoints) {
    
        this.arenaPoints = arenaPoints;
    }
    
    public int getAtLoginFlags() {
    
        return this.atLoginFlags;
    }
    
    public void setAtLoginFlags(final int atLogin) {
    
        this.atLoginFlags = atLogin;
    }
    
    public int getChosenTitle() {
    
        return this.chosenTitle;
    }
    
    public void setChosenTitle(final int chosenTitle) {
    
        this.chosenTitle = chosenTitle;
    }
    
    public boolean isCinematic() {
    
        return this.cinematic;
    }
    
    public void setCinematic(final boolean cinematic) {
    
        this.cinematic = cinematic;
    }
    
    public long getDeathExpireTime() {
    
        return this.deathExpireTime;
    }
    
    public void setDeathExpireTime(final long deathExpireTime) {
    
        this.deathExpireTime = deathExpireTime;
    }
    
    public long getDeleteDate() {
    
        return this.deleteDate;
    }
    
    public void setDeleteDate(final long deleteDate) {
    
        this.deleteDate = deleteDate;
    }
    
    public int getDeleteInfosAccount() {
    
        return this.deleteInfosAccount;
    }
    
    public void setDeleteInfosAccount(final int deleteInfosAccount) {
    
        this.deleteInfosAccount = deleteInfosAccount;
    }
    
    public String getDeleteInfosName() {
    
        return this.deleteInfosName;
    }
    
    public void setDeleteInfosName(final String deleteInfosName) {
    
        this.deleteInfosName = deleteInfosName;
    }
    
    public int getDrunk() {
    
        return this.drunk;
    }
    
    public void setDrunk(final int drunk) {
    
        this.drunk = drunk;
    }
    
    public int getDungeonDifficulty() {
    
        return this.dungeonDifficulty;
    }
    
    public void setDungeonDifficulty(final int dungeonDifficulty) {
    
        this.dungeonDifficulty = dungeonDifficulty;
    }
    
    public String getEquipmentCache() {
    
        return this.equipmentCache;
    }
    
    public void setEquipmentCache(final String equipmentCache) {
    
        this.equipmentCache = equipmentCache;
    }
    
    public String getExploredZones() {
    
        return this.exploredZones;
    }
    
    public void setExploredZones(final String exploredZones) {
    
        this.exploredZones = exploredZones;
    }
    
    public int getExtraFlags() {
    
        return this.extraFlags;
    }
    
    public void setExtraFlags(final int extraFlags) {
    
        this.extraFlags = extraFlags;
    }
    
    public int getGender() {
    
        return this.gender;
    }
    
    public void setGender(final int gender) {
    
        this.gender = gender;
    }
    
    public int getHealth() {
    
        return this.health;
    }
    
    public void setHealth(final int health) {
    
        this.health = health;
    }
    
    public boolean isLogoutResting() {
    
        return this.isLogoutResting;
    }
    
    public void setLogoutResting(final boolean logoutResting) {
    
        this.isLogoutResting = logoutResting;
    }
    
    public long getKnownCurrencies() {
    
        return this.knownCurrencies;
    }
    
    public void setKnownCurrencies(final long knownCurrencies) {
    
        this.knownCurrencies = knownCurrencies;
    }
    
    public String getKnownTitles() {
    
        return this.knownTitles;
    }
    
    public void setKnownTitles(final String knownTitles) {
    
        this.knownTitles = knownTitles;
    }
    
    public int getLevel() {
    
        return this.level;
    }
    
    public void setLevel(final int level) {
    
        this.level = level;
    }
    
    public int getLeveltime() {
    
        return this.leveltime;
    }
    
    public void setLeveltime(final int leveltime) {
    
        this.leveltime = leveltime;
    }
    
    public long getLogoutTime() {
    
        return this.logoutTime;
    }
    
    public void setLogoutTime(final long logoutTime) {
    
        this.logoutTime = logoutTime;
    }
    
    public int getMap() {
    
        return this.map;
    }
    
    public void setMap(final int map) {
    
        this.map = map;
    }
    
    public int getMoney() {
    
        return this.money;
    }
    
    public void setMoney(final int money) {
    
        this.money = money;
    }
    
    public String getName() {
    
        return this.name;
    }
    
    public void setName(final String name) {
    
        this.name = name;
    }
    
    public boolean isOnline() {
    
        return this.online;
    }
    
    public void setOnline(final boolean online) {
    
        this.online = online;
    }
    
    public float getOrientation() {
    
        return this.orientation;
    }
    
    public void setOrientation(final float orientation) {
    
        this.orientation = orientation;
    }
    
    public int getPlayerBytes() {
    
        return this.playerBytes;
    }
    
    public void setPlayerBytes(final int playerBytes) {
    
        this.playerBytes = playerBytes;
    }
    
    public int getPlayerBytes2() {
    
        return this.playerBytes2;
    }
    
    public void setPlayerBytes2(final int playerBytes2) {
    
        this.playerBytes2 = playerBytes2;
    }
    
    public int getPlayerFlags() {
    
        return this.playerFlags;
    }
    
    public void setPlayerFlags(final int playerFlags) {
    
        this.playerFlags = playerFlags;
    }
    
    public float getPositionX() {
    
        return this.positionX;
    }
    
    public void setPositionX(final float positionX) {
    
        this.positionX = positionX;
    }
    
    public float getPositionY() {
    
        return this.positionY;
    }
    
    public void setPositionY(final float positionY) {
    
        this.positionY = positionY;
    }
    
    public float getPositionZ() {
    
        return this.positionZ;
    }
    
    public void setPositionZ(final float positionZ) {
    
        this.positionZ = positionZ;
    }
    
    public int getPower1() {
    
        return this.power1;
    }
    
    public void setPower1(final int power1) {
    
        this.power1 = power1;
    }
    
    public int getPower2() {
    
        return this.power2;
    }
    
    public void setPower2(final int power2) {
    
        this.power2 = power2;
    }
    
    public int getPower3() {
    
        return this.power3;
    }
    
    public void setPower3(final int power3) {
    
        this.power3 = power3;
    }
    
    public int getPower4() {
    
        return this.power4;
    }
    
    public void setPower4(final int power4) {
    
        this.power4 = power4;
    }
    
    public int getPower5() {
    
        return this.power5;
    }
    
    public void setPower5(final int power5) {
    
        this.power5 = power5;
    }
    
    public int getPower6() {
    
        return this.power6;
    }
    
    public void setPower6(final int power6) {
    
        this.power6 = power6;
    }
    
    public int getPower7() {
    
        return this.power7;
    }
    
    public void setPower7(final int power7) {
    
        this.power7 = power7;
    }
    
    public int getResettalentsCost() {
    
        return this.resettalentsCost;
    }
    
    public void setResettalentsCost(final int resettalentsCost) {
    
        this.resettalentsCost = resettalentsCost;
    }
    
    public int getResettalentsTime() {
    
        return this.resettalentsTime;
    }
    
    public void setResettalentsTime(final int resettalentsTime) {
    
        this.resettalentsTime = resettalentsTime;
    }
    
    public float getRestBonus() {
    
        return this.restBonus;
    }
    
    public void setRestBonus(final float restBonus) {
    
        this.restBonus = restBonus;
    }
    
    public int getSpecCount() {
    
        return this.specCount;
    }
    
    public void setSpecCount(final int specCount) {
    
        this.specCount = specCount;
    }
    
    public int getStableSlots() {
    
        return this.stableSlots;
    }
    
    public void setStableSlots(final int stableSlots) {
    
        this.stableSlots = stableSlots;
    }
    
    public String getTaxiPath() {
    
        return this.taxiPath;
    }
    
    public void setTaxiPath(final String taxiPath) {
    
        this.taxiPath = taxiPath;
    }
    
    public String getTaximask() {
    
        return this.taximask;
    }
    
    public void setTaximask(final String taximask) {
    
        this.taximask = taximask;
    }
    
    public int getTodayHonorPoints() {
    
        return this.todayHonorPoints;
    }
    
    public void setTodayHonorPoints(final int todayHonorPoints) {
    
        this.todayHonorPoints = todayHonorPoints;
    }
    
    public int getTodayKills() {
    
        return this.todayKills;
    }
    
    public void setTodayKills(final int todayKills) {
    
        this.todayKills = todayKills;
    }
    
    public int getTotalHonorPoints() {
    
        return this.totalHonorPoints;
    }
    
    public void setTotalHonorPoints(final int totalHonorPoints) {
    
        this.totalHonorPoints = totalHonorPoints;
    }
    
    public int getTotalKills() {
    
        return this.totalKills;
    }
    
    public void setTotalKills(final int totalKills) {
    
        this.totalKills = totalKills;
    }
    
    public int getTotaltime() {
    
        return this.totaltime;
    }
    
    public void setTotaltime(final int totaltime) {
    
        this.totaltime = totaltime;
    }
    
    public float getTransO() {
    
        return this.transO;
    }
    
    public void setTransO(final float transO) {
    
        this.transO = transO;
    }
    
    public float getTransX() {
    
        return this.transX;
    }
    
    public void setTransX(final float transX) {
    
        this.transX = transX;
    }
    
    public float getTransY() {
    
        return this.transY;
    }
    
    public void setTransY(final float transY) {
    
        this.transY = transY;
    }
    
    public float getTransZ() {
    
        return this.transZ;
    }
    
    public void setTransZ(final float transZ) {
    
        this.transZ = transZ;
    }
    
    public int getTransguid() {
    
        return this.transguid;
    }
    
    public void setTransguid(final int transguid) {
    
        this.transguid = transguid;
    }
    
    public int getWatchedFaction() {
    
        return this.watchedFaction;
    }
    
    public void setWatchedFaction(final int watchedFaction) {
    
        this.watchedFaction = watchedFaction;
    }
    
    public int getXp() {
    
        return this.xp;
    }
    
    public void setXp(final int xp) {
    
        this.xp = xp;
    }
    
    public int getYesterdayHonorPoints() {
    
        return this.yesterdayHonorPoints;
    }
    
    public void setYesterdayHonorPoints(final int yesterdayHonorPoints) {
    
        this.yesterdayHonorPoints = yesterdayHonorPoints;
    }
    
    public int getYesterdayKills() {
    
        return this.yesterdayKills;
    }
    
    public void setYesterdayKills(final int yesterdayKills) {
    
        this.yesterdayKills = yesterdayKills;
    }
    
    public int getZone() {
    
        return this.zone;
    }
    
    public void setZone(final int zone) {
    
        this.zone = zone;
    }
    
    public Classes getClazz() {
    
        return this.clazz;
    }
    
    public void setClazz(final Classes clazz) {
    
        this.clazz = clazz;
    }
    
    public Races getRace() {
    
        return this.race;
    }
    
    public void setRace(final Races race) {
    
        this.race = race;
    }
    
    public PlayerHomeBindData getHomeBindData() {
    
        return this.homeBindData;
    }
    
    public void setHomeBindData(final PlayerHomeBindData homeBindData) {
    
        this.homeBindData = homeBindData;
    }
    
    public List<InventoryItem> getInventory() {
    
        return this.inventory;
    }
    
    public void setInventory(final List<InventoryItem> inventory) {
    
        this.inventory = inventory;
    }
}
