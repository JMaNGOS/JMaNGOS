package org.jmangos.commons.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jmangos.commons.enums.Classes;

@Entity
@Table(name = "creature_template")
@AttributeOverrides({
    @AttributeOverride(name = "guid", column = @Column(name = "entry")),
    @AttributeOverride(name = "entry", column = @Column(name = "difficulty_entry_1")) })
@SecondaryTables({ @SecondaryTable(name = "creature_template_addon",
        pkJoinColumns = { @PrimaryKeyJoinColumn(name = "entry", referencedColumnName = "entry") }) })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CreaturePrototype extends FieldsObject {

    @Column(name = "bytes1", table = "creature_template_addon", nullable = true)
    private Integer bytes = 0;
    @Column(name = "speed_walk", nullable = true)
    private Float speedWalkMod = 1f;
    @Column(name = "speed_run", nullable = true)
    private Float speedRunMod = 1f;
    @Column(name = "baseattacktime")
    private Integer baseattacktime = 2000;
    @Column(name = "rangeattacktime")
    private Integer rangeattacktime = 0;
    @Column(name = "minlevel")
    private int minLevel;
    @Column(name = "maxlevel")
    private int maxLevel;
    /**
     * 
     */
    private static final long serialVersionUID = 229321319875042498L;

    @Column(name = "name",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 255,
            precision = 0)
    private String name;

    @Column(name = "unit_class")
    @Enumerated(EnumType.ORDINAL)
    private Classes unitClass;
    @Column(name = "subName", nullable = true, insertable = true, updatable = true)
    private String subName;
    @Column(name = "IconName", nullable = true, insertable = true, updatable = true)
    private String iconName;
    @Column(name = "type_flags", nullable = true, insertable = true, updatable = true)
    private Integer typeFlags;
    @Column(name = "type", nullable = true, insertable = true, updatable = true)
    private Integer creatureType;
    @Column(name = "family", nullable = true, insertable = true, updatable = true)
    private Integer family;
    @Column(name = "rank", nullable = true, insertable = true, updatable = true)
    private Integer rank;
    @Column(name = "modelid_1", nullable = true, insertable = true, updatable = true)
    private Integer modelid_1;
    @Column(name = "modelid_2", nullable = true, insertable = true, updatable = true)
    private Integer modelid_2;
    @Column(name = "modelid_3", nullable = true, insertable = true, updatable = true)
    private Integer modelid_3;
    @Column(name = "modelid_4", nullable = true, insertable = true, updatable = true)
    private Integer modelid_4;
    @Column(name = "unk16", nullable = true, insertable = true, updatable = true)
    private float healthModifier;
    @Column(name = "unk17", nullable = true, insertable = true, updatable = true)
    private float powerModifier;
    @Column(name = "RacialLeader", nullable = true, insertable = true, updatable = true)
    private Integer racialLeader;
    @Column(name = "movementId", nullable = true, insertable = true, updatable = true)
    private Integer movementId;
    @Column(name = "minhealth", nullable = true, insertable = true, updatable = true)
    private Integer minHealth;
    @Column(name = "maxHealth", nullable = true, insertable = true, updatable = true)
    private Integer maxHealth;
    @Column(name = "minmana", nullable = true, insertable = true, updatable = true)
    private Integer minMana;
    @Column(name = "maxmana", nullable = true, insertable = true, updatable = true)
    private Integer maxMana;
    @Column(name = "faction_A", nullable = true, insertable = true, updatable = true)
    private int factionForAliance;
    @Column(name = "faction_H", nullable = true, insertable = true, updatable = true)
    private int factionForHorde;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_id")
    private CreatureEquip equipment;

    /**
     * @return the name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * @param name
     *        the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the bytes
     */
    public final Integer getBytes() {
        return this.bytes;
    }

    /**
     * @param bytes
     *        the bytes to set
     */
    public final void setBytes(final Integer bytes) {
        this.bytes = bytes;
    }

    /**
     * @return the speedWalkMod
     */
    public final Float getSpeedWalkMod() {
        return this.speedWalkMod;
    }

    /**
     * @param speedWalkMod
     *        the speedWalkMod to set
     */
    public final void setSpeedWalkMod(final Float speedWalkMod) {
        this.speedWalkMod = speedWalkMod;
    }

    /**
     * @return the speedRunMod
     */
    public final Float getSpeedRunMod() {
        return this.speedRunMod;
    }

    /**
     * @param speedRunMod
     *        the speedRunMod to set
     */
    public final void setSpeedRunMod(final Float speedRunMod) {
        this.speedRunMod = speedRunMod;
    }

    public Classes getClazz() {
        return this.unitClass;
    }

    /**
     * @return the baseattacktime
     */
    public final Integer getBaseattacktime() {
        return this.baseattacktime;
    }

    /**
     * @param baseattacktime
     *        the baseattacktime to set
     */
    public final void setBaseattacktime(final Integer baseattacktime) {
        this.baseattacktime = baseattacktime;
    }

    /**
     * @return the rangeattacktime
     */
    public final Integer getRangeattacktime() {
        return this.rangeattacktime;
    }

    /**
     * @param rangeattacktime
     *        the rangeattacktime to set
     */
    public final void setRangeattacktime(final Integer rangeattacktime) {
        this.rangeattacktime = rangeattacktime;
    }

    public String getSubName() {
        return this.subName;
    }

    public String getIconName() {
        return this.iconName;
    }

    public Integer getTypeFlag() {
        return this.typeFlags;
    }

    public Integer getCreatureType() {
        return this.creatureType;
    }

    public Integer getFamily() {
        return this.family;
    }

    public Integer getRank() {
        return this.rank;
    }

    public Integer getKillCredit(final int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 0;
            default:
                return 0;
        }
    }

    public Integer getModelId(final int i) {
        switch (i) {
            case 0:
                return this.modelid_1;
            case 1:
                return this.modelid_2;
            case 2:
                return this.modelid_3;
            case 3:
                return this.modelid_4;
            default:
                return 0;
        }
    }

    public float getHealthModifier() {
        return this.healthModifier;
    }

    public float getPowerModifier() {
        return this.powerModifier;
    }

    public Integer getRacialLeader() {
        return this.racialLeader;
    }

    public Integer getMovementId() {
        return this.movementId;
    }

    /**
     * 
     * @return the maxHealth
     */
    public Integer getMaxHealth() {
        return this.maxHealth;

    }

    /**
     * @return the minHealth
     */
    public final Integer getMinHealth() {
        return this.minHealth;
    }

    /**
     * @return the minMana
     */
    public final Integer getMinMana() {
        return this.minMana;
    }

    /**
     * @return the maxMana
     */
    public final Integer getMaxMana() {
        return this.maxMana;
    }

    public int getFactionForAliance() {
        return this.factionForAliance;
    }

    public int getFactionForHorde() {
        return this.factionForHorde;
    }

    /**
     * @return the minLevel
     */
    public final int getMinLevel() {
        return this.minLevel;
    }

    /**
     * @return the maxLevel
     */
    public final int getMaxLevel() {
        return this.maxLevel;
    }

    /**
     * @return the equipment
     */
    public final CreatureEquip getEquipment() {
        return this.equipment;
    }

    /**
     * @param equipment
     *        the equipment to set
     */
    public final void setEquipment(final CreatureEquip equipment) {
        this.equipment = equipment;
    }

}
