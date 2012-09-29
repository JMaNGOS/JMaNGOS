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
package org.jmangos.realm.model.base;

import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.HashMap;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jmangos.commons.model.NamedObject;
import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;
import org.jmangos.realm.model.enums.TypeID;
import org.jmangos.realm.model.enums.TypeMask;

/**
 * The Class WorldObject.
 */
public class WorldObject extends NamedObject {
    
    /** The object type. */
    protected EnumSet<TypeMask>                 objectType  = EnumSet.noneOf(TypeMask.class);
    
    /** The object type id. */
    protected TypeID                            objectTypeId;
    
    /** The m_uint32 values. */
    protected ChannelBuffer                     m_uint32Values;
    
    /** The m_uint32 values_mirror. */
    protected ChannelBuffer                     m_uint32Values_mirror;
    
    /** The values count. */
    protected int                               valuesCount = 0;
    
    /** BitSet for update packet */
    protected BitSet                            bitSet      = new BitSet();
    
    /** Mapping filed value types */
    protected HashMap<Integer, UpdateFieldType> bitTypes    = new HashMap<Integer, UpdateFieldType>();
    
    /**
     * Instantiates a new world object.
     * 
     * @param objectId
     *            the object id
     */
    public WorldObject(final long objectId) {
    
        super((int) objectId);
    }
    
    /**
     * Gets the object type.
     * 
     * @return the objectType
     */
    public final EnumSet<TypeMask> getObjectType() {
    
        return this.objectType;
    }
    
    /**
     * Sets the object type.
     * 
     * @param objectType
     *            the objectType to set
     */
    public final void setObjectType(final EnumSet<TypeMask> objectType) {
    
        this.objectType = objectType;
    }
    
    /**
     * Gets the object type id.
     * 
     * @return the m_objectTypeId
     */
    public TypeID getObjectTypeId() {
    
        return this.objectTypeId;
    }
    
    /**
     * Sets the object type id.
     * 
     * @param ObjectTypeId
     *            the objectTypeId to set
     */
    public void setObjectTypeId(final TypeID ObjectTypeId) {
    
        this.objectTypeId = ObjectTypeId;
    }
    
    /**
     * Update.
     */
    public void update() {
    
        System.out.println(this.m_uint32Values.capacity());
    }
    
    /**
     * Initfields.
     */
    public void initfields() {
    
        this.m_uint32Values = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, this.valuesCount * 4);
    }
    
    /**
     * Sets the u int32 value.
     * 
     * @param i
     *            the i
     * @param value
     *            the value
     */
    public void SetUInt32Value(final int i, final int value) {
    
        this.m_uint32Values.setInt(i * 4, value);
        this.bitSet.set(i);
        this.bitTypes.put(i, UpdateFieldType.INT);
    }
    
    /**
     * Sets the u int32 value.
     * 
     * @param updateField
     *            the PlayerFields enum
     * @param value
     *            the value
     */
    public void SetUInt32Value(final UpdateField updateField, final int value) {
    
        SetUInt32Value(updateField.getValue(), value);
    }
    
    /**
     * Gets the u int32 value.
     * 
     * @param i
     *            the i
     * @return the int
     */
    public int GetUInt32Value(final int i) {
    
        return this.m_uint32Values.getInt(i * 4);
    }
    
    /**
     * Gets the u int32 value.
     * 
     * @param updateField
     *            the PlayerField
     * @return the int
     */
    public int GetUInt32Value(final UpdateField updateField) {
    
        return this.m_uint32Values.getInt(updateField.getValue() * 4);
    }
    
    /**
     * Sets the u int64 value.
     * 
     * @param i
     *            the i
     * @param value
     *            the value
     */
    public void SetUInt64Value(final int i, final long value) {
    
        this.m_uint32Values.setLong(i * 4, value);
        this.bitSet.set(i);
        this.bitTypes.put(i, UpdateFieldType.LONG);
    }
    
    /**
     * Sets the u int64 value.
     * 
     * @param updateField
     *            the i
     * @param value
     *            the value
     */
    public void SetUInt64Value(final UpdateField updateField, final long value) {
    
        SetUInt64Value(updateField.getValue(), value);
    }
    
    /**
     * Gets the u int64 value.
     * 
     * @param i
     *            the i
     * @return the long
     */
    public long GetUInt64Value(final int i) {
    
        return this.m_uint32Values.getLong(i * 4);
    }
    
    /**
     * Gets the u int64 value.
     * 
     * @param updateField
     *            the i
     * @return the long
     */
    public long GetUInt64Value(final UpdateField updateField) {
    
        return this.m_uint32Values.getLong(updateField.getValue() * 4);
    }
    
    /**
     * _ load into data field.
     * 
     * @param strings
     *            the strings
     * @param from
     *            the from
     * @param count
     *            the count
     */
    public void _LoadIntoDataField(final String[] strings, final int from, final int count) {
    
        for (int i = 0; i < strings.length; i++) {
            try {
                SetUInt32Value(from + i, Integer.decode(strings[i]));
            } catch (final NumberFormatException e) {
                // Hmmmm... Manual DB Edit? N00B!
            }
        }
    }
    
    /**
     * Load values.
     * 
     * @param data
     *            the data
     * @return true, if successful
     */
    public boolean loadValues(final String[] data) {
    
        if (data.length != this.valuesCount) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            SetUInt32Value(i, Long.decode(data[i]).intValue());
        }
        return true;
    }
    
    /**
     * Sets the byte value.
     * 
     * @param index
     *            the index
     * @param offset
     *            the offset
     * @param value
     *            the value
     */
    public void SetByteValue(final int index, final int offset, final byte value) {
    
        if (offset > 4) {
            return;
        }
        int rvalue = GetUInt32Value(index);
        if ((rvalue >> (offset * 8)) != value) {
            rvalue &= ~(0xFF << (offset * 8));
            rvalue |= (value << (offset * 8));
        }
        SetUInt32Value(index, rvalue);
        this.bitSet.set(index);
        this.bitTypes.put(index, UpdateFieldType.BYTES);
    }
    
    /**
     * Sets the byte value.
     * 
     * @param updateField
     *            the PlayerFields index
     * @param offset
     *            the offset
     * @param value
     *            the value
     */
    public void SetByteValue(final UpdateField updateField, final int offset, final byte value) {
    
        SetByteValue(updateField.getValue(), offset, value);
    }
    
    /**
     * Set m_ byte value
     * 
     * @param index
     *            int UpdateField index
     * @param value
     *            byte value
     */
    public void SetByteValue(final int index, final byte value) {
    
        this.m_uint32Values.setByte(index * 4, value);
        this.bitSet.set(index);
        this.bitTypes.put(index, UpdateFieldType.BYTES);
    }
    
    /**
     * 
     * @param index
     * @return
     */
    public byte GetByteValue(final int index) {
    
        return this.m_uint32Values.getByte(index * 4);
    }
    
    /**
     * Set m_ byte value
     * 
     * @param updateField
     *            UpdateField index
     * @param value
     *            byte value
     */
    public void SetByteValue(final UpdateField updateField, final byte value) {
    
        this.m_uint32Values.setByte(updateField.getValue(), value);
    }
    
    /**
     * Sets the float value.
     * 
     * @param i
     *            the i
     * @param value
     *            the value
     */
    public void SetFloatValue(final int i, final float value) {
    
        this.m_uint32Values.setFloat(i * 4, value);
        this.bitSet.set(i);
        this.bitTypes.put(i, UpdateFieldType.FLOAT);
    }
    
    /**
     * Sets the float value.
     * 
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public void SetFloatValue(final UpdateField field, final float value) {
    
        SetFloatValue(field.getValue(), value);
    }
    
    /**
     * Gets the float value.
     * 
     * @param i
     *            the i
     * @return the float
     */
    public float GetFloatValue(final int i) {
    
        return this.m_uint32Values.getFloat(i * 4);
    }
    
    /**
     * Gets the float value.
     * 
     * @param updateField
     *            the i
     * @return the float
     */
    public float GetFloatValue(final UpdateField updateField) {
    
        return GetFloatValue(updateField.getValue());
    }
    
    /** Updatemask */
    public BitSet getBitSet() {
    
        return this.bitSet;
    }
    
    /** Updatemask index-type map */
    public HashMap<Integer, UpdateFieldType> getBitTypes() {
    
        return this.bitTypes;
    }
    
    // For clear any pending display changes
    public void clearBits() {
    
        this.bitTypes.clear();
        this.bitSet.clear();
    }
    
    /**
     * @return the m_uint32Values_mirror
     */
    public final ChannelBuffer getM_uint32Values_mirror() {
    
        return this.m_uint32Values_mirror;
    }
    
    /**
     * @param m_uint32Values_mirror
     *            the m_uint32Values_mirror to set
     */
    public final void setM_uint32Values_mirror(final ChannelBuffer m_uint32Values_mirror) {
    
        this.m_uint32Values_mirror = m_uint32Values_mirror;
    }
}
