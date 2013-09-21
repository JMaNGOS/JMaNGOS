package org.jmangos.commons.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jmangos.commons.enums.HighGuid;
import org.jmangos.commons.enums.ModelType;
import org.jmangos.commons.enums.Powers;
import org.jmangos.commons.enums.SheathState;
import org.jmangos.commons.update.ObjectFields;
import org.jmangos.commons.utils.Rnd;

@SuppressWarnings("serial")
@Entity
@Table(name = "creature")
@AttributeOverrides({ @AttributeOverride(name = "entry", column = @Column(name = "id")),
// Override default scale by spawnDist data
@AttributeOverride(name = "scale", column = @Column(name = "spawndist")) })
public class Creature extends FieldsUnit {

    /**
     * 
     */
    private static final long serialVersionUID = -8876628710784393342L;

    @Embedded
    CreaturePositionerHolder movement;

    @Transient
    CreaturePrototype prototype;

    @Transient
    private Float curScale = DEFAULT_OBJECT_SCALE;

    @Transient
    private Integer bytes = 0;

    @Transient
    private Integer level = 0;

    @Transient
    private CreaturePowers power = new CreaturePowers();

    @Transient
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsUnit#initBits()
     */
    @Override
    public void initBits() {
        super.initBits();
        long entry = getEntry();
        entry <<= 24;
        long higuid = HighGuid.UNIT.getValue();
        higuid <<= 52;
        setGuid(higuid | entry | getGuid());
        this.bitSet.set(ObjectFields.OBJECT_FIELD_ENTRY.getValue());
    }

    /**
     * @param prototype
     *        the prototype to set
     */
    public final void setPrototype(final CreaturePrototype prototype) {
        this.prototype = prototype;
        this.curScale = prototype.getScale();
        setClazz(prototype.getClazz());
        setAttackTime(0, prototype.getBaseattacktime());
        setAttackTime(1, prototype.getBaseattacktime());
        final int minLevel = prototype.getMaxLevel();
        final int maxLevel = prototype.getMinLevel();
        int level = 0;
        if (maxLevel != minLevel) {
            level = minLevel + Rnd.nextInt(maxLevel - minLevel);
        } else {
            level = minLevel;
        }
        setLevel(level);
        setDisplayId(ModelType.NATIVE, prototype.getModelId(0));
        setDisplayId(ModelType.CURRENT, prototype.getModelId(0));
        final Integer minHealth = prototype.getMaxHealth();
        final Integer maxHealth = prototype.getMinHealth();
        final int health = minHealth + Rnd.nextInt(maxHealth - minHealth);
        setPower(Powers.HEALTH, health);
        setBaseHealth(health);
        switch (prototype.getClazz()) {
            case MAGE:
            case PALADIN:
                final Integer minMana = prototype.getMaxMana();
                final Integer maxMana = prototype.getMinMana();
                final int mana = minHealth + Rnd.nextInt(maxMana - minMana);
                setPower(Powers.MANA, mana);
                setBaseMana(mana);
            break;

            default:
            break;
        }
        if (prototype.getRangeattacktime() > 0) {
            setAttackTime(2, prototype.getRangeattacktime());
        }
        setFaction_template(prototype.getFactionForAliance());
        setSheath(SheathState.MELEE);
        if (prototype.getEquipment().getEquipentry1() != 0) {
            setVirtualItem(0, prototype.getEquipment().getEquipentry1());
        }
        if (prototype.getEquipment().getEquipentry2() != 0) {
            setVirtualItem(1, prototype.getEquipment().getEquipentry2());
        }
        if (prototype.getEquipment().getEquipentry3() != 0) {
            setVirtualItem(2, prototype.getEquipment().getEquipentry3());
        }
        // walk
        this.movement.getSpeeds()[0] = this.movement.getSpeeds()[0] * prototype.getSpeedWalkMod();
        this.movement.getSpeeds()[1] = this.movement.getSpeeds()[1] * prototype.getSpeedRunMod();
    }

    /**
     * override FieldsObject.getScale to get SpawnDist
     * 
     * @return
     */
    public float getSpawnDist() {
        return super.getScale();
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsObject#getScale()
     */
    @Override
    public float getScale() {
        return this.curScale;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsObject#setScale(float)
     */
    @Override
    public void setScale(final float scale) {
        this.bitSet.set(ObjectFields.OBJECT_FIELD_SCALE_X.getValue());
        this.curScale = scale;
    }

    /**
     * @return the movement
     */
    @Override
    public final CreaturePositionerHolder getMovement() {
        return this.movement;
    }

    /**
     * @param movement
     *        the movement to set
     */
    public final void setMovement(final CreaturePositionerHolder movement) {
        this.movement = movement;
    }

    /**
     * @return the prototype
     */
    public final CreaturePrototype getPrototype() {
        return this.prototype;
    }

    @Override
    public CreaturePowers getPowers() {
        return this.power;
    }

    @Override
    public void setPowers(final CreaturePowers powers) {
        this.power = powers;

    }

    @Override
    public String getName() {
        return getPrototype().getName();
    }

    @Override
    public void setName(final String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getBytes() {
        return this.bytes;
    }

    /**
     * @param bytes
     *        the bytes to set
     */
    @Override
    public final void setBytes(final int bytes) {
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
