package org.jmangos.commons.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jmangos.commons.update.ObjectFields;

@SuppressWarnings("serial")
@Entity
@Table(name = "creature")
@AttributeOverrides({ @AttributeOverride(name = "entry", column = @Column(name = "id")),
// Override default scale by spawnDist data
@AttributeOverride(name = "scale", column = @Column(name = "spawndist")) })
public class Creature extends FieldsUnit {

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
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.FieldsUnit#initBits()
     */
    @Override
    public void initBits() {
        super.initBits();
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
        this.setAttackTime(0, prototype.getBaseattacktime());
        this.setAttackTime(1, prototype.getBaseattacktime());
        if(prototype.getRangeattacktime() > 0){
            this.setAttackTime(2, prototype.getRangeattacktime());
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPowers(final CreaturePowers powers) {
        // TODO Auto-generated method stub

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
