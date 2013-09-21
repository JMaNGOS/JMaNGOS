/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javolution.util.FastMap;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.enums.TypeID;
import org.jmangos.commons.enums.TypeMask;
import org.jmangos.commons.update.ContainerFields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "fields_container")
@DiscriminatorValue("2")
public class FieldsContainer extends FieldsItem {

    /**
     * 
     */
    private static final long serialVersionUID = -8097121159449054872L;

    private static final Logger logger = LoggerFactory.getLogger(FieldsContainer.class);

    @Column(name = "slotsCount",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private byte slotsCount;

    @JoinTable(name = "container_Items",
            joinColumns = @JoinColumn(name = "container_guid"),
            inverseJoinColumns = @JoinColumn(name = "item_guid"))
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @Fetch(value = FetchMode.SUBSELECT)
    @MapKeyColumn(name = "slot")
    private final Map<Byte, FieldsItem> inventory = new FastMap<Byte, FieldsItem>();

    /**
     * 
     */
    public FieldsContainer() {

        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#getTypeId()
     */
    @Override
    public TypeID getTypeId() {

        return TypeID.CONTAINER;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.BaseObject#initBits()
     */
    @Override
    public void initBits() {

        super.initBits();
        setType(getType() | TypeMask.CONTAINER.getValue());
        this.bitSet.set(ContainerFields.CONTAINER_FIELD_NUM_SLOTS.getValue());

    }

    public final boolean addToInventory(final Byte slot, final FieldsItem item) {

        if (slot > this.slotsCount) {
            logger.debug("Try add item in container but slot {} > count slots {}.", slot,
                    this.slotsCount);
            return false;
        }

        if (this.inventory.size() >= this.slotsCount) {
            logger.debug("Try add item {} in full container {}", item.getGuid(), getGuid());
            return false;
        }

        if (this.inventory.get(slot) != null) {
            logger.debug("Try add item {} but slot not free, have item {}", item.getGuid(),
                    this.inventory.get(slot).getGuid());
            return false;
        }
        item.setContained(getGuid());
        this.inventory.put(slot, item);
        this.bitSet.set(ContainerFields.CONTAINER_FIELD_SLOT_1.getValue() + slot);
        this.bitSet.set(ContainerFields.CONTAINER_FIELD_SLOT_1.getValue() + slot + 1);
        return true;
    }

    public final boolean addToInventory(final FieldsItem item) {

        final Byte slot = getFreeSlot();
        if (slot == null) {
            return false;
        }
        return this.addToInventory(slot, item);
    }

    public final Byte getFreeSlot() {

        for (byte i = 0; i < getSlotsCount(); i++) {
            if (!this.inventory.containsKey(i)) {
                return i;
            }
        }
        return null;
    }

    /**
     * @return the slotsCount
     */
    public final int getSlotsCount() {

        return this.slotsCount;
    }

    /**
     * @param slotsCount
     *        the slotsCount to set
     */
    public final void setSlotsCount(final byte slotsCount) {

        this.bitSet.set(ContainerFields.CONTAINER_FIELD_NUM_SLOTS.getValue());
        this.slotsCount = slotsCount;
    }

    /**
     * Don't use directly
     * 
     * @return the inventory
     */
    @Deprecated
    public final Map<Byte, FieldsItem> getInventory() {

        return this.inventory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.subentities.ItemObject#getBitSize()
     */
    @Override
    protected int getBitSize() {

        return ContainerFields.CONTAINER_END;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.subentities.ItemObject#writeValuesUpdate(java.nio.ByteBuffer
     * )
     */
    @Override
    public ChannelBuffer writeValuesUpdate() {

        final ChannelBuffer ocBuffer = super.writeValuesUpdate();
        if (this.bitSet.get(ContainerFields.CONTAINER_FIELD_NUM_SLOTS.getValue())) {
            ocBuffer.writeInt(getSlotsCount());
        };
        for (byte i = 0; i < getSlotsCount(); i++) {
            if (this.bitSet.get(ContainerFields.CONTAINER_FIELD_SLOT_1.getValue() + (i * 2))) {
                if (this.inventory.get(i) != null) {
                    ocBuffer.writeLong(this.inventory.get(i).getGuid());
                }
            }
        }
        return ocBuffer;
    }

}
