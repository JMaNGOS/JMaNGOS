package org.jmangos.realm.model.base.character;

import org.jmangos.realm.model.Classes;
import org.jmangos.realm.model.InventoryItem;
import org.jmangos.realm.model.Races;
import org.jmangos.realm.model.player.PlayerHomeBindData;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.11.
 * Time: 19:20
 */
@Entity
@Table(name = "characters")
public class CharacterData {
    @Id
    @TableGenerator(table = "sequences", allocationSize = 1, name = "char_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "char_seq")
	@Column(name = "guid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	private long guid;
    
    @Basic
	@Column(name = "account", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int account;
    
    @Basic
	@Column(name = "actionBars", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int actionBars;
    
    @Basic
	@Column(name = "activeSpec", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int activeSpec;
    
    @Basic
	@Column(name = "ammoId", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int ammoId;
    
    @Basic
	@Column(name = "arenaPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int arenaPoints;
    
    @Basic
	@Column(name = "at_login", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int atLoginFlags;
    
    @Basic
	@Column(name = "chosenTitle", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int chosenTitle;
    
    @Basic
	@Column(name = "cinematic", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
	private boolean cinematic;
    
    @Enumerated(EnumType.STRING)
	@Column(name = "class", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
	private Classes clazz;
    
    @Basic
	@Column(name = "death_expire_time", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
	private long deathExpireTime;
    
    @Basic
	@Column(name = "deleteDate", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
	private long deleteDate;
    
    @Basic
	@Column(name = "deleteInfos_Account", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int deleteInfosAccount;
    
    @Basic
	@Column(name = "deleteInfos_Name", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String deleteInfosName;
    
    @Basic
	@Column(name = "drunk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int drunk;
    
    @Basic
	@Column(name = "dungeon_difficulty", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int dungeonDifficulty;
    
    @Basic
	@Column(name = "equipmentCache", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String equipmentCache;
    
    @Basic
	@Column(name = "exploredZones", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String exploredZones;
    
    @Basic
	@Column(name = "extra_flags", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int extraFlags;
    
    @Basic
	@Column(name = "gender", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int gender;
    
    @Basic
	@Column(name = "health", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int health;
    
    @Basic
	@Column(name = "is_logout_resting", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
	private boolean isLogoutResting;
    
    @Basic
	@Column(name = "knownCurrencies", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
	private long knownCurrencies;
    
    @Basic
	@Column(name = "knownTitles", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String knownTitles;
    
    @Basic
	@Column(name = "level", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int level;
    
    @Basic
	@Column(name = "leveltime", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int leveltime;
    
    @Basic
	@Column(name = "logout_time", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
	private long logoutTime;
    
    @Basic
	@Column(name = "map", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int map;
    
    @Basic
	@Column(name = "money", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int money;
    
    @Basic
	@Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String name;
    
    @Basic
	@Column(name = "online", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
	private boolean online;
    
    @Basic
	@Column(name = "orientation", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float orientation;
    
    @Basic
	@Column(name = "playerBytes", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int playerBytes;
    
    @Basic
	@Column(name = "playerBytes2", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int playerBytes2;

    @Basic
	@Column(name = "playerFlags", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int playerFlags;
    
    @Basic
	@Column(name = "position_x", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float positionX;
    
    @Basic
	@Column(name = "position_y", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float positionY;
    
    @Basic
	@Column(name = "position_z", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float positionZ;
    
    @Basic
	@Column(name = "power1", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power1;

    @Basic
	@Column(name = "power2", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power2;

    @Basic
	@Column(name = "power3", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power3;

    @Basic
	@Column(name = "power4", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power4;

    @Basic
	@Column(name = "power5", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power5;

    @Basic
	@Column(name = "power6", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power6;

    @Basic
	@Column(name = "power7", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int power7;

    @Enumerated(EnumType.STRING)
	@Column(name = "race", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
	private Races race;
    
    @Basic
	@Column(name = "resettalents_cost", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int resettalentsCost;
    
    @Basic
	@Column(name = "resettalents_time", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int resettalentsTime;
    
    @Basic
	@Column(name = "rest_bonus", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float restBonus;
    
    @Basic
	@Column(name = "specCount", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int specCount;
    
    @Basic
	@Column(name = "stable_slots", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int stableSlots;
    
    @Basic
	@Column(name = "taxi_path", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String taxiPath;
    
    @Basic
	@Column(name = "taximask", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
	private String taximask;
    
    @Basic
	@Column(name = "todayHonorPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int todayHonorPoints;
    
    @Basic
	@Column(name = "todayKills", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int todayKills;
    
    @Basic
	@Column(name = "totalHonorPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int totalHonorPoints;
    
    @Basic
	@Column(name = "totalKills", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int totalKills;
    
    @Basic
	@Column(name = "totaltime", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int totaltime;
    
    @Basic
	@Column(name = "trans_o", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float transO;
    
    @Basic
	@Column(name = "trans_x", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float transX;
    
    @Basic
	@Column(name = "trans_y", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float transY;
    
    @Basic
	@Column(name = "trans_z", nullable = true, insertable = true, updatable = true, length = 12, precision = 0)
	private float transZ;
    
    @Basic
	@Column(name = "transguid", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int transguid;
    
    @Basic
	@Column(name = "watchedFaction", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int watchedFaction;
    
    @Basic
	@Column(name = "xp", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int xp;
    
    @Basic
	@Column(name = "yesterdayHonorPoints", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int yesterdayHonorPoints;
    
    @Basic
	@Column(name = "yesterdayKills", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int yesterdayKills;
    
    @Basic
	@Column(name = "zone", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	private int zone;

    @OneToOne(targetEntity = PlayerHomeBindData.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PlayerHomeBindData homeBindData;

    @JoinColumn(referencedColumnName = "guid")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryItem> inventory = new ArrayList<InventoryItem>();

    /**
     * Find item by inventory slot
     * @param slot
     * @return
     */
    public InventoryItem findInventorySlot( int slot ) {
        for( InventoryItem invItem : inventory ) {
            if ( invItem.getSlot() == slot )
                return invItem;
        }
        // :( not found
        return null;
    }

    /**
     * Empty constructor
     */
    public CharacterData() {}

    public long getGuid() {
        return guid;
    }

    public void setGuid(long guid) {
        this.guid = guid;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getActionBars() {
        return actionBars;
    }

    public void setActionBars(int actionBars) {
        this.actionBars = actionBars;
    }

    public int getActiveSpec() {
        return activeSpec;
    }

    public void setActiveSpec(int activeSpec) {
        this.activeSpec = activeSpec;
    }

    public int getAmmoId() {
        return ammoId;
    }

    public void setAmmoId(int ammoId) {
        this.ammoId = ammoId;
    }

    public int getArenaPoints() {
        return arenaPoints;
    }

    public void setArenaPoints(int arenaPoints) {
        this.arenaPoints = arenaPoints;
    }

    public int getAtLoginFlags() {
        return atLoginFlags;
    }

    public void setAtLoginFlags(int atLogin) {
        this.atLoginFlags = atLogin;
    }

    public int getChosenTitle() {
        return chosenTitle;
    }

    public void setChosenTitle(int chosenTitle) {
        this.chosenTitle = chosenTitle;
    }

    public boolean isCinematic() {
        return cinematic;
    }

    public void setCinematic(boolean cinematic) {
        this.cinematic = cinematic;
    }

    public long getDeathExpireTime() {
        return deathExpireTime;
    }

    public void setDeathExpireTime(long deathExpireTime) {
        this.deathExpireTime = deathExpireTime;
    }

    public long getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(long deleteDate) {
        this.deleteDate = deleteDate;
    }

    public int getDeleteInfosAccount() {
        return deleteInfosAccount;
    }

    public void setDeleteInfosAccount(int deleteInfosAccount) {
        this.deleteInfosAccount = deleteInfosAccount;
    }

    public String getDeleteInfosName() {
        return deleteInfosName;
    }

    public void setDeleteInfosName(String deleteInfosName) {
        this.deleteInfosName = deleteInfosName;
    }

    public int getDrunk() {
        return drunk;
    }

    public void setDrunk(int drunk) {
        this.drunk = drunk;
    }

    public int getDungeonDifficulty() {
        return dungeonDifficulty;
    }

    public void setDungeonDifficulty(int dungeonDifficulty) {
        this.dungeonDifficulty = dungeonDifficulty;
    }

    public String getEquipmentCache() {
        return equipmentCache;
    }

    public void setEquipmentCache(String equipmentCache) {
        this.equipmentCache = equipmentCache;
    }

    public String getExploredZones() {
        return exploredZones;
    }

    public void setExploredZones(String exploredZones) {
        this.exploredZones = exploredZones;
    }

    public int getExtraFlags() {
        return extraFlags;
    }

    public void setExtraFlags(int extraFlags) {
        this.extraFlags = extraFlags;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isLogoutResting() {
        return isLogoutResting;
    }

    public void setLogoutResting(boolean logoutResting) {
        isLogoutResting = logoutResting;
    }

    public long getKnownCurrencies() {
        return knownCurrencies;
    }

    public void setKnownCurrencies(long knownCurrencies) {
        this.knownCurrencies = knownCurrencies;
    }

    public String getKnownTitles() {
        return knownTitles;
    }

    public void setKnownTitles(String knownTitles) {
        this.knownTitles = knownTitles;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLeveltime() {
        return leveltime;
    }

    public void setLeveltime(int leveltime) {
        this.leveltime = leveltime;
    }

    public long getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(long logoutTime) {
        this.logoutTime = logoutTime;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    public int getPlayerBytes() {
        return playerBytes;
    }

    public void setPlayerBytes(int playerBytes) {
        this.playerBytes = playerBytes;
    }

    public int getPlayerBytes2() {
        return playerBytes2;
    }

    public void setPlayerBytes2(int playerBytes2) {
        this.playerBytes2 = playerBytes2;
    }

    public int getPlayerFlags() {
        return playerFlags;
    }

    public void setPlayerFlags(int playerFlags) {
        this.playerFlags = playerFlags;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(float positionZ) {
        this.positionZ = positionZ;
    }

    public int getPower1() {
        return power1;
    }

    public void setPower1(int power1) {
        this.power1 = power1;
    }

    public int getPower2() {
        return power2;
    }

    public void setPower2(int power2) {
        this.power2 = power2;
    }

    public int getPower3() {
        return power3;
    }

    public void setPower3(int power3) {
        this.power3 = power3;
    }

    public int getPower4() {
        return power4;
    }

    public void setPower4(int power4) {
        this.power4 = power4;
    }

    public int getPower5() {
        return power5;
    }

    public void setPower5(int power5) {
        this.power5 = power5;
    }

    public int getPower6() {
        return power6;
    }

    public void setPower6(int power6) {
        this.power6 = power6;
    }

    public int getPower7() {
        return power7;
    }

    public void setPower7(int power7) {
        this.power7 = power7;
    }

    public int getResettalentsCost() {
        return resettalentsCost;
    }

    public void setResettalentsCost(int resettalentsCost) {
        this.resettalentsCost = resettalentsCost;
    }

    public int getResettalentsTime() {
        return resettalentsTime;
    }

    public void setResettalentsTime(int resettalentsTime) {
        this.resettalentsTime = resettalentsTime;
    }

    public float getRestBonus() {
        return restBonus;
    }

    public void setRestBonus(float restBonus) {
        this.restBonus = restBonus;
    }

    public int getSpecCount() {
        return specCount;
    }

    public void setSpecCount(int specCount) {
        this.specCount = specCount;
    }

    public int getStableSlots() {
        return stableSlots;
    }

    public void setStableSlots(int stableSlots) {
        this.stableSlots = stableSlots;
    }

    public String getTaxiPath() {
        return taxiPath;
    }

    public void setTaxiPath(String taxiPath) {
        this.taxiPath = taxiPath;
    }

    public String getTaximask() {
        return taximask;
    }

    public void setTaximask(String taximask) {
        this.taximask = taximask;
    }

    public int getTodayHonorPoints() {
        return todayHonorPoints;
    }

    public void setTodayHonorPoints(int todayHonorPoints) {
        this.todayHonorPoints = todayHonorPoints;
    }

    public int getTodayKills() {
        return todayKills;
    }

    public void setTodayKills(int todayKills) {
        this.todayKills = todayKills;
    }

    public int getTotalHonorPoints() {
        return totalHonorPoints;
    }

    public void setTotalHonorPoints(int totalHonorPoints) {
        this.totalHonorPoints = totalHonorPoints;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(int totaltime) {
        this.totaltime = totaltime;
    }

    public float getTransO() {
        return transO;
    }

    public void setTransO(float transO) {
        this.transO = transO;
    }

    public float getTransX() {
        return transX;
    }

    public void setTransX(float transX) {
        this.transX = transX;
    }

    public float getTransY() {
        return transY;
    }

    public void setTransY(float transY) {
        this.transY = transY;
    }

    public float getTransZ() {
        return transZ;
    }

    public void setTransZ(float transZ) {
        this.transZ = transZ;
    }

    public int getTransguid() {
        return transguid;
    }

    public void setTransguid(int transguid) {
        this.transguid = transguid;
    }

    public int getWatchedFaction() {
        return watchedFaction;
    }

    public void setWatchedFaction(int watchedFaction) {
        this.watchedFaction = watchedFaction;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getYesterdayHonorPoints() {
        return yesterdayHonorPoints;
    }

    public void setYesterdayHonorPoints(int yesterdayHonorPoints) {
        this.yesterdayHonorPoints = yesterdayHonorPoints;
    }

    public int getYesterdayKills() {
        return yesterdayKills;
    }

    public void setYesterdayKills(int yesterdayKills) {
        this.yesterdayKills = yesterdayKills;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public Classes getClazz() {
        return clazz;
    }

    public void setClazz(Classes clazz) {
        this.clazz = clazz;
    }

    public Races getRace() {
        return race;
    }

    public void setRace(Races race) {
        this.race = race;
    }

    public PlayerHomeBindData getHomeBindData() {
        return homeBindData;
    }

    public void setHomeBindData(PlayerHomeBindData homeBindData) {
        this.homeBindData = homeBindData;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }
}
