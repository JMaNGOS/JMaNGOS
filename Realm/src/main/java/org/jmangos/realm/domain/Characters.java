package org.jmangos.realm.domain;

import org.jmangos.realm.model.Classes;
import org.jmangos.realm.model.Races;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 1:09
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "characters")
public class Characters {
    @Id
    @Column(nullable = false)
    private int guid;

    @Column
    private int account;

    @Column
    String name;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Races race;

    @Column(name="class")
    @Enumerated(EnumType.ORDINAL)
    private Classes clazz;

    @Column
    private int gender;

    @Column
    private int level;

    @Column
    private int xp;

    @Column
    private int money;

    @Column
    private int playerBytes;

    @Column
    private int playerBytes2;

    @Column
    private int playerFlags;

    @Column
    private float position_x;

    @Column
    private float position_y;

    @Column
    private float position_z;

    @Column
    private int map;

    @Column
    private int zone;

    @Column
    private int dungeon_difficulty;

    @Column
    private float orientation;

    @Column
    private String taximask;

    @Column
    private boolean online;

    @Column
    private boolean cinematic;

    @Column
    private int totaltime;

    @Column
    private int leveltime;

    @Column
    private long logout_time;

    @Column
    private boolean is_logout_resting;

    @Column
    private float rest_bonus;

    @Column
    private int resettalents_cost;

    @Column
    private int resettalents_time;

    @Column
    private float trans_x;

    @Column
    private float trans_y;

    @Column
    private float trans_z;

    @Column
    private float trans_o;

    @Column
    private int transguid;

    @Column
    private int extra_flags;

    @Column
    private int stable_slots;

    @Column
    private int at_login;

    @Column
    private long death_expire_time;

    @Column
    private String taxi_path;

    @Column
    private int arenaPoints;

    @Column
    private int totalHonorPoints;

    @Column
    private int todayHonorPoints;

    @Column
    private int yesterdayHonorPoints;

    @Column
    private int totalKills;

    @Column
    private int todayKills;

    @Column
    private int yesterdayKills;

    @Column
    private int chosenTitle;

    @Column
    private long knownCurrencies;

    @Column
    private int watchedFaction;

    @Column
    private int drunk;

    @Column
    private int
    health;

    @Column
    private int
    power1;

    @Column
    private int
    power2;

    @Column
    private int
    power3;

    @Column
    private int power4;

    @Column
    private int power5;

    @Column
    private int power6;

    @Column
    private int power7;

    @Column
    private int specCount;

    @Column
    private int activeSpec;

    @Column
    private String exploredZones;

    @Column
    private String equipmentCache;

    @Column
    private int ammoId;

    @Column
    private String knownTitles;

    @Column
    private int actionBars;

    @Column
    private int deleteInfos_Account;

    @Column
    private String deleteInfos_Name;

    @Column
    private long deleteDate;

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Races getRace() {
        return race;
    }

    public void setRace(Races race) {
        this.race = race;
    }

    public Classes getClazz() {
        return clazz;
    }

    public void setClazz(Classes clazz) {
        this.clazz = clazz;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public float getPosition_x() {
        return position_x;
    }

    public void setPosition_x(float position_x) {
        this.position_x = position_x;
    }

    public float getPosition_y() {
        return position_y;
    }

    public void setPosition_y(float position_y) {
        this.position_y = position_y;
    }

    public float getPosition_z() {
        return position_z;
    }

    public void setPosition_z(float position_z) {
        this.position_z = position_z;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getDungeon_difficulty() {
        return dungeon_difficulty;
    }

    public void setDungeon_difficulty(int dungeon_difficulty) {
        this.dungeon_difficulty = dungeon_difficulty;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    public String getTaximask() {
        return taximask;
    }

    public void setTaximask(String taximask) {
        this.taximask = taximask;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isCinematic() {
        return cinematic;
    }

    public void setCinematic(boolean cinematic) {
        this.cinematic = cinematic;
    }

    public int getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(int totaltime) {
        this.totaltime = totaltime;
    }

    public int getLeveltime() {
        return leveltime;
    }

    public void setLeveltime(int leveltime) {
        this.leveltime = leveltime;
    }

    public long getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(long logout_time) {
        this.logout_time = logout_time;
    }

    public boolean isIs_logout_resting() {
        return is_logout_resting;
    }

    public void setIs_logout_resting(boolean is_logout_resting) {
        this.is_logout_resting = is_logout_resting;
    }

    public float getRest_bonus() {
        return rest_bonus;
    }

    public void setRest_bonus(float rest_bonus) {
        this.rest_bonus = rest_bonus;
    }

    public int getResettalents_cost() {
        return resettalents_cost;
    }

    public void setResettalents_cost(int resettalents_cost) {
        this.resettalents_cost = resettalents_cost;
    }

    public int getResettalents_time() {
        return resettalents_time;
    }

    public void setResettalents_time(int resettalents_time) {
        this.resettalents_time = resettalents_time;
    }

    public float getTrans_x() {
        return trans_x;
    }

    public void setTrans_x(float trans_x) {
        this.trans_x = trans_x;
    }

    public float getTrans_y() {
        return trans_y;
    }

    public void setTrans_y(float trans_y) {
        this.trans_y = trans_y;
    }

    public float getTrans_z() {
        return trans_z;
    }

    public void setTrans_z(float trans_z) {
        this.trans_z = trans_z;
    }

    public float getTrans_o() {
        return trans_o;
    }

    public void setTrans_o(float trans_o) {
        this.trans_o = trans_o;
    }

    public int getTransguid() {
        return transguid;
    }

    public void setTransguid(int transguid) {
        this.transguid = transguid;
    }

    public int getExtra_flags() {
        return extra_flags;
    }

    public void setExtra_flags(int extra_flags) {
        this.extra_flags = extra_flags;
    }

    public int getStable_slots() {
        return stable_slots;
    }

    public void setStable_slots(int stable_slots) {
        this.stable_slots = stable_slots;
    }

    public int getAt_login() {
        return at_login;
    }

    public void setAt_login(int at_login) {
        this.at_login = at_login;
    }

    public long getDeath_expire_time() {
        return death_expire_time;
    }

    public void setDeath_expire_time(long death_expire_time) {
        this.death_expire_time = death_expire_time;
    }

    public String getTaxi_path() {
        return taxi_path;
    }

    public void setTaxi_path(String taxi_path) {
        this.taxi_path = taxi_path;
    }

    public int getArenaPoints() {
        return arenaPoints;
    }

    public void setArenaPoints(int arenaPoints) {
        this.arenaPoints = arenaPoints;
    }

    public int getTotalHonorPoints() {
        return totalHonorPoints;
    }

    public void setTotalHonorPoints(int totalHonorPoints) {
        this.totalHonorPoints = totalHonorPoints;
    }

    public int getTodayHonorPoints() {
        return todayHonorPoints;
    }

    public void setTodayHonorPoints(int todayHonorPoints) {
        this.todayHonorPoints = todayHonorPoints;
    }

    public int getYesterdayHonorPoints() {
        return yesterdayHonorPoints;
    }

    public void setYesterdayHonorPoints(int yesterdayHonorPoints) {
        this.yesterdayHonorPoints = yesterdayHonorPoints;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getTodayKills() {
        return todayKills;
    }

    public void setTodayKills(int todayKills) {
        this.todayKills = todayKills;
    }

    public int getYesterdayKills() {
        return yesterdayKills;
    }

    public void setYesterdayKills(int yesterdayKills) {
        this.yesterdayKills = yesterdayKills;
    }

    public int getChosenTitle() {
        return chosenTitle;
    }

    public void setChosenTitle(int chosenTitle) {
        this.chosenTitle = chosenTitle;
    }

    public long getKnownCurrencies() {
        return knownCurrencies;
    }

    public void setKnownCurrencies(long knownCurrencies) {
        this.knownCurrencies = knownCurrencies;
    }

    public int getWatchedFaction() {
        return watchedFaction;
    }

    public void setWatchedFaction(int watchedFaction) {
        this.watchedFaction = watchedFaction;
    }

    public int getDrunk() {
        return drunk;
    }

    public void setDrunk(int drunk) {
        this.drunk = drunk;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getSpecCount() {
        return specCount;
    }

    public void setSpecCount(int specCount) {
        this.specCount = specCount;
    }

    public int getActiveSpec() {
        return activeSpec;
    }

    public void setActiveSpec(int activeSpec) {
        this.activeSpec = activeSpec;
    }

    public String getExploredZones() {
        return exploredZones;
    }

    public void setExploredZones(String exploredZones) {
        this.exploredZones = exploredZones;
    }

    public String getEquipmentCache() {
        return equipmentCache;
    }

    public void setEquipmentCache(String equipmentCache) {
        this.equipmentCache = equipmentCache;
    }

    public int getAmmoId() {
        return ammoId;
    }

    public void setAmmoId(int ammoId) {
        this.ammoId = ammoId;
    }

    public String getKnownTitles() {
        return knownTitles;
    }

    public void setKnownTitles(String knownTitles) {
        this.knownTitles = knownTitles;
    }

    public int getActionBars() {
        return actionBars;
    }

    public void setActionBars(int actionBars) {
        this.actionBars = actionBars;
    }

    public int getDeleteInfos_Account() {
        return deleteInfos_Account;
    }

    public void setDeleteInfos_Account(int deleteInfos_Account) {
        this.deleteInfos_Account = deleteInfos_Account;
    }

    public String getDeleteInfos_Name() {
        return deleteInfos_Name;
    }

    public void setDeleteInfos_Name(String deleteInfos_Name) {
        this.deleteInfos_Name = deleteInfos_Name;
    }

    public long getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(long deleteDate) {
        this.deleteDate = deleteDate;
    }
}
