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
package org.jmangos.realm.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javolution.util.FastMap;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.realm.model.Streamable;
import org.jmangos.realm.model.base.update.ItemFields;
import org.jmangos.realm.model.base.update.ObjectFields;
import org.jmangos.realm.model.enums.EnchantmentSlot;
import org.jmangos.realm.model.enums.TypeID;
import org.jmangos.realm.model.enums.TypeMask;
import org.jmangos.world.entities.ItemPrototype;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@DynamicUpdate
@Table(name = "fields_item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class FieldsItem extends FieldsObject implements Streamable {
    
   // @Column(name = "slot", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
   // private int                                     slot;
    
    @Column(name = "owner", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private long                                    owner;
    
    @Column(name = "contained", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Long                                    contained;
    
    @Column(name = "creator", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private long                                    creator;
    
    @Column(name = "giftcreator", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private long                                    giftcreator;
    
    @Column(name = "stackCount", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    private int                                     stackCount = 1;
    
    @Column(name = "duration", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     duration;
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "itemGuid")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @MapKeyColumn(name = "slot")
    @Fetch(value = FetchMode.SUBSELECT)
    private final Map<Byte, ItemCharges>            charges    = new FastMap<Byte, ItemCharges>();
    
    @Column(name = "flags", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     flags;
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "itemGuid")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @MapKeyEnumerated(EnumType.ORDINAL)
    @MapKeyColumn(name = "slot")
    @Fetch(value = FetchMode.SUBSELECT)
    private final Map<EnchantmentSlot, ItemEnchant> enchants   = new FastMap<EnchantmentSlot, ItemEnchant>();
    
    @Column(name = "propertySeed", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     propertySeed;
    
    @Column(name = "propertyId", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     propertyId;
    
    @Column(name = "durability", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     durability;
    
    @Column(name = "maxDurability", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     maxDurability;
    
    @Column(name = "playedTime", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int                                     playedTime;
    
    @Transient
    private ItemPrototype                           prototype;
    
    /**
     * 
     */
    public FieldsItem() {
    
        super();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#initBits()
     */
    @Override
    public void initBits() {
    
        super.initBits();
        setType(getType() | TypeMask.ITEM.getValue());
        this.bitSet.set(ObjectFields.OBJECT_FIELD_ENTRY.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_FLAGS.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_STACK_COUNT.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_CONTAINED.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_CONTAINED.getValue() + 1);
        this.bitSet.set(ItemFields.ITEM_FIELD_OWNER.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_OWNER.getValue() + 1);
        if (getMaxDurability() > 0) {
            this.bitSet.set(ItemFields.ITEM_FIELD_DURABILITY.getValue());
            this.bitSet.set(ItemFields.ITEM_FIELD_MAXDURABILITY.getValue());
        }
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#getTypeId()
     */
    @Override
    protected int getTypeId() {
    
        return TypeID.ITEM.getValue();
    }
    
    /**
     * @return the owner
     */
    public final Long getOwner() {
    
        return this.owner;
    }
    
    /**
     * @param owner
     *            the owner to set
     */
    public final void setOwner(final Long owner) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_OWNER.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_OWNER.getValue() + 1);
        this.owner = owner;
    }
    
    /**
     * @return the contained
     */
    public final Long getContained() {
    
        return this.contained;
    }
    
    /**
     * @param contained
     *            the contained to set
     */
    public final void setContained(final Long contained) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_CONTAINED.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_CONTAINED.getValue() + 1);
        this.contained = contained;
    }
    
    /**
     * @return the created
     */
    public final long getCreated() {
    
        return this.creator;
    }
    
    /**
     * @param created
     *            the created to set
     */
    public final void setCreated(final long created) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_CREATOR.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_CREATOR.getValue() + 1);
        this.creator = created;
    }
    
    /**
     * @return the giftcreator
     */
    public final Long getGiftcreator() {
    
        return this.giftcreator;
    }
    
    /**
     * @param giftcreator
     *            the giftcreator to set
     */
    public final void setGiftcreator(final Long giftcreator) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_GIFTCREATOR.getValue());
        this.bitSet.set(ItemFields.ITEM_FIELD_GIFTCREATOR.getValue() + 1);
        this.giftcreator = giftcreator;
    }
    
    /**
     * @return the stackCount
     */
    public final int getStackCount() {
    
        return this.stackCount;
    }
    
    /**
     * @param stackCount
     *            the stackCount to set
     */
    public final void setStackCount(final int stackCount) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_STACK_COUNT.getValue());
        this.stackCount = stackCount;
    }
    
    /**
     * @return the duration
     */
    public final int getDuration() {
    
        return this.duration;
    }
    
    /**
     * @param duration
     *            the duration to set
     */
    public final void setDuration(final int duration) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_DURATION.getValue());
        this.duration = duration;
    }
    
    /**
     * @return the charges
     */
    public final Map<Byte, ItemCharges> getCharges() {
    
        return this.charges;
    }
    
    /**
     * @return the flags
     */
    public final int getFlags() {
    
        return this.flags;
    }
    
    /**
     * @param flags
     *            the flags to set
     */
    public final void setFlags(final int flags) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_FLAGS.getValue());
        this.flags = flags;
    }
    
    /**
     * @param flags
     *            the flags to set
     */
    public final void addFlags(final int flags) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_FLAGS.getValue());
        this.flags |= flags;
    }
    
    /**
     * @return the propertySeed
     */
    public final int getPropertySeed() {
    
        return this.propertySeed;
    }
    
    /**
     * @param propertySeed
     *            the propertySeed to set
     */
    public final void setPropertySeed(final int propertySeed) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_PROPERTY_SEED.getValue());
        this.propertySeed = propertySeed;
    }
    
    /**
     * @return the propertyId
     */
    public final int getPropertyId() {
    
        return this.propertyId;
    }
    
    /**
     * @param propertyId
     *            the propertyId to set
     */
    public final void setPropertyId(final int propertyId) {
    
        this.propertyId = propertyId;
    }
    
    /**
     * @return the durability
     */
    public final int getDurability() {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_DURABILITY.getValue());
        return this.durability;
    }
    
    /**
     * @param durability
     *            the durability to set
     */
    public final void setDurability(final int durability) {
    
        this.durability = durability;
    }
    
    /**
     * @return the maxDurability
     */
    public final int getMaxDurability() {
    
        return this.maxDurability;
    }
    
    /**
     * @param maxDurability
     *            the maxDurability to set
     */
    public final void setMaxDurability(final int maxDurability) {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_MAXDURABILITY.getValue());
        this.maxDurability = maxDurability;
    }
    
    /**
     * @return the playedTime
     */
    public final int getPlayedTime() {
    
        this.bitSet.set(ItemFields.ITEM_FIELD_CREATE_PLAYED_TIME.getValue());
        return this.playedTime;
    }
    
    /**
     * @param playedTime
     *            the playedTime to set
     */
    public final void setPlayedTime(final int playedTime) {
    
        this.playedTime = playedTime;
    }
    
    /**
     * @return the enchants
     */
    public final Map<EnchantmentSlot, ItemEnchant> getEnchants() {
    
        return this.enchants;
    }
    
    /**
     * @return the prototype
     */
    public final ItemPrototype getPrototype() {
    
        return this.prototype;
    }
    
    /**
     * @param prototype
     *            the prototype to set
     */
    public final void setPrototype(final ItemPrototype prototype) {
    
        this.prototype = prototype;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#getBitSize()
     */
    @Override
    protected int getBitSize() {
    
        return ItemFields.ITEM_END;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#_write(java.nio.ByteBuffer)
     */
    @Override
    public ChannelBuffer writeValuesUpdate() {
    
        final ChannelBuffer oByteBuffer = super.writeValuesUpdate();
        if (this.bitSet.get(ItemFields.ITEM_FIELD_OWNER.getValue())) {
            oByteBuffer.writeLong(getOwner());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_CONTAINED.getValue())) {
            oByteBuffer.writeLong(getContained());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_CREATOR.getValue())) {
            oByteBuffer.writeLong(getCreated());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_GIFTCREATOR.getValue())) {
            oByteBuffer.writeLong(getGiftcreator());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_STACK_COUNT.getValue())) {
            oByteBuffer.writeInt(getStackCount());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_DURATION.getValue())) {
            oByteBuffer.writeInt(getDuration());
        };
        for (int i = 0; i < 5; i++) {
            if (this.bitSet.get(ItemFields.ITEM_FIELD_SPELL_CHARGES.getValue() + i)) {
                oByteBuffer.writeInt(getCharges().get(i).getCharges());
            }
            
        }
        if (this.bitSet.get(ItemFields.ITEM_FIELD_FLAGS.getValue())) {
            oByteBuffer.writeInt(getFlags());
        };
        for (int i = 0; i < 12; i++) {
            if (this.bitSet.get(ItemFields.ITEM_FIELD_ENCHANTMENT_1_1.getValue() + (i * 3))) {
                oByteBuffer.writeInt(getEnchants().get(i).getEnchantId());
            }
            if (this.bitSet.get(ItemFields.ITEM_FIELD_ENCHANTMENT_1_1.getValue() + (i * 3) + 1)) {
                oByteBuffer.writeInt(getEnchants().get(i).getDuration());
            }
            if (this.bitSet.get(ItemFields.ITEM_FIELD_ENCHANTMENT_1_1.getValue() + (i * 3) + 2)) {
                oByteBuffer.writeInt(getEnchants().get(i).getCharges());
            }
        }
        if (this.bitSet.get(ItemFields.ITEM_FIELD_PROPERTY_SEED.getValue())) {
            oByteBuffer.writeInt(getPropertySeed());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_RANDOM_PROPERTIES_ID.getValue())) {
            oByteBuffer.writeInt(getPropertyId());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_DURABILITY.getValue())) {
            oByteBuffer.writeInt(getDurability());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_MAXDURABILITY.getValue())) {
            oByteBuffer.writeInt(getMaxDurability());
        };
        if (this.bitSet.get(ItemFields.ITEM_FIELD_CREATE_PLAYED_TIME.getValue())) {
            oByteBuffer.writeInt(getPlayedTime());
        };
        return oByteBuffer;
    }
    
}
