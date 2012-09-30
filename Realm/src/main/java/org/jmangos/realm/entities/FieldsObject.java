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

import java.nio.ByteOrder;
import java.util.BitSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jmangos.realm.model.Streamable;
import org.jmangos.realm.model.base.update.ObjectFields;
import org.jmangos.realm.model.enums.TypeID;
import org.jmangos.realm.model.enums.TypeMask;
import org.jmangos.realm.model.enums.UpdateFlags;
import org.jmangos.realm.model.enums.UpdateType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
public abstract class FieldsObject implements Streamable {

    @Transient
    protected BitSet bitSet = new BitSet();

    @Transient
    public static final float DEFAULT_OBJECT_SCALE = 1f;

    @Id
    @GenericGenerator(name = "seq_id",
            strategy = "org.jmangos.realm.model.WowExtendIdGenerator",
            parameters = { @Parameter(name = "table_name", value = "wow_sequences") })
    @GeneratedValue(generator = "seq_id")
    private Long guid;

    @Transient
    private int type;

    @Column(name = "entry",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private int entry;

    @Column(name = "scale",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private float scale = DEFAULT_OBJECT_SCALE;

    @Transient
    private byte[] packGuid;

    public FieldsObject() {

        this.bitSet = new BitSet(getBitSize());

    }

    @PostLoad
    public void initBits() {

        packGuid();
        setType(TypeMask.OBJECT.getValue());
        this.bitSet.set(ObjectFields.OBJECT_FIELD_GUID.getValue());
        this.bitSet.set(ObjectFields.OBJECT_FIELD_GUID.getValue() + 1);
        this.bitSet.set(ObjectFields.OBJECT_FIELD_SCALE_X.getValue());
    }

    /**
     * @return the movement
     */
    public BasicPositionerHolder getMovement() {

        return new BasicPositionerHolder();
    }

    /**
     * Override to set proper bit size
     * 
     * @return
     */
    protected int getBitSize() {

        return ObjectFields.OBJECT_END;
    }

    @PostPersist
    private final void packGuid() {

        if (this.guid == null) {
            return;
        }
        long tguid = this.guid;
        final byte[] packGUID = new byte[8 + 1];
        packGUID[0] = 0;
        int size = 1;
        for (byte i = 0; tguid != 0; ++i) {
            if ((tguid & 0xFF) > 0) {
                packGUID[0] |= (1 << i);
                packGUID[size] = (byte) (tguid & 0xFF);
                ++size;
            }

            tguid >>= 8;
        }
        this.packGuid = new byte[size];
        for (int i = 0; i < size; i++) {
            this.packGuid[i] = packGUID[i];
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.id.Streamable#BuildCreateUpdateBlockForPlayer(org.jmangos
     * .test.id.Player)
     */
    @Override
    public int buildCreateBlock(final ChannelBuffer updateBlock, final CharacterData characterData) {

        final UpdateType type = getCreateUpdateType();
        updateBlock.writeByte(type.getValue());
        updateBlock.writeBytes(this.packGuid);
        updateBlock.writeByte(getTypeId());

        final UpdateFlags[] additionFlags = new UpdateFlags[2];
        if (this == characterData) {
            additionFlags[0] = (UpdateFlags.SELFTARGET);
        }
        getMovement().buildUpdateBlock(updateBlock, additionFlags);

        updateBlock.writeBytes(writeValuesUpdate());
        return 1;
    }

    protected int getTypeId() {

        return TypeID.OBJECT.getValue();
    }

    protected UpdateType getCreateUpdateType() {

        return UpdateType.CREATE_OBJECT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jmangos.test.id.Streamable#_write(java.nio.ByteBuffer)
     */
    @Override
    public ChannelBuffer writeValuesUpdate() {

        final byte[] bytesc = this.bitSet.toByteArray();
        final ChannelBuffer ocBuffer =
                ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, this.bitSet.size() * 32);
        final int arraySize =
                ((bytesc.length % 4) > 0) ? ((bytesc.length / 4) + 1) * 4 : bytesc.length;
        ocBuffer.writeByte(arraySize / 4);
        ocBuffer.writeBytes(bytesc);
        if ((bytesc.length % 4) > 0) {
            ocBuffer.writeZero(4 - (bytesc.length % 4));
        }

        if (this.bitSet.get(ObjectFields.OBJECT_FIELD_GUID.getValue())) {
            ocBuffer.writeLong(getGuid());
        };
        if (this.bitSet.get(ObjectFields.OBJECT_FIELD_TYPE.getValue())) {
            ocBuffer.writeInt(getType());
        }
        if (this.bitSet.get(ObjectFields.OBJECT_FIELD_ENTRY.getValue())) {
            ocBuffer.writeInt(getEntry());
        }
        if (this.bitSet.get(ObjectFields.OBJECT_FIELD_SCALE_X.getValue())) {
            ocBuffer.writeFloat(getScale());
        }

        return ocBuffer;
    }

    /**
     * @return the guid
     */
    public final Long getGuid() {

        return this.guid;
    }

    /**
     * @param guid
     *        the guid to set
     */
    public final void setGuid(final Long guid) {

        this.bitSet.set(ObjectFields.OBJECT_FIELD_GUID.getValue());
        this.bitSet.set(ObjectFields.OBJECT_FIELD_GUID.getValue() + 1);
        this.guid = guid;
        packGuid();
    }

    /**
     * @return the type
     */
    public final int getType() {

        return this.type;
    }

    /**
     * @param type
     *        the type to set
     */
    public final void setType(final int type) {

        this.bitSet.set(ObjectFields.OBJECT_FIELD_TYPE.getValue());
        this.type = type;
    }

    /**
     * @return the entry
     */
    public final int getEntry() {

        return this.entry;
    }

    /**
     * @param entry
     *        the entry to set
     */
    public final void setEntry(final int entry) {

        this.bitSet.set(ObjectFields.OBJECT_FIELD_ENTRY.getValue());
        this.entry = entry;
    }

    /**
     * @return the scale
     */
    public final float getScale() {

        return this.scale;
    }

    /**
     * @param scale
     *        the scale to set
     */
    public final void setScale(final float scale) {

        this.bitSet.set(ObjectFields.OBJECT_FIELD_SCALE_X.getValue());
        this.scale = scale;
    }

    /**
     * @return the packetGuid
     */
    public final byte[] getPacketGuid() {

        return this.packGuid;
    }

}
