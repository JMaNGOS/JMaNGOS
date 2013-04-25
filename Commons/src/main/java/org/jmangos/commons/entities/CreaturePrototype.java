package org.jmangos.commons.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "creature_template")
@AttributeOverrides({
    @AttributeOverride(name = "guid", column = @Column(name = "entry")),
    @AttributeOverride(name = "entry", column = @Column(name = "difficulty_entry_1")),
    @AttributeOverride(name = "level", column = @Column(name = "minlevel")) })
@SecondaryTables({ @SecondaryTable(name = "creature_template_addon",
        pkJoinColumns = { @PrimaryKeyJoinColumn(name = "entry", referencedColumnName = "entry") }) })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CreaturePrototype extends FieldsObject {

    @Column(name = "bytes1",
            table = "creature_template_addon",
            nullable = true)
    private Integer bytes = 0;
    @Column(name = "speed_walk",
            nullable = true)
    private Float speedWalkMod = 1f;
    @Column(name = "speed_run",
            nullable = true)
    private Float speedRunMod = 1f;
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
    public final void setName(String name) {
        this.name = name;
    }

    
    /**
     * @return the bytes
     */
    public final Integer getBytes() {
        return this.bytes;
    }

    
    /**
     * @param bytes the bytes to set
     */
    public final void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    
    /**
     * @return the speedWalkMod
     */
    public final Float getSpeedWalkMod() {
        return this.speedWalkMod;
    }

    
    /**
     * @param speedWalkMod the speedWalkMod to set
     */
    public final void setSpeedWalkMod(Float speedWalkMod) {
        this.speedWalkMod = speedWalkMod;
    }

    
    /**
     * @return the speedRunMod
     */
    public final Float getSpeedRunMod() {
        return this.speedRunMod;
    }

    
    /**
     * @param speedRunMod the speedRunMod to set
     */
    public final void setSpeedRunMod(Float speedRunMod) {
        this.speedRunMod = speedRunMod;
    }

}
