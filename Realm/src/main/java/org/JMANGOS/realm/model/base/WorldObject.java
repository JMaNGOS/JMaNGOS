/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base;

import java.nio.ByteOrder;
import java.util.EnumSet;

import org.JMANGOS.realm.model.base.guid.ObjectGuid;
import org.JMANGOS.realm.model.base.guid.TypeId;
import org.JMANGOS.realm.model.base.guid.TypeMask;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.JMANGOS.common.model.NamedObject;

// TODO: Auto-generated Javadoc
/**
 * The Class WorldObject.
 */
public class WorldObject extends NamedObject {
	
	/** The guid. */
	ObjectGuid guid = null;
	
	/** The object type. */
	protected EnumSet<TypeMask> objectType = EnumSet.noneOf(TypeMask.class);
	
	/** The object type id. */
	protected TypeId objectTypeId;
	
	/** The m_uint32 values. */
	protected ChannelBuffer m_uint32Values;
	
	/** The m_uint32 values_mirror. */
	protected ChannelBuffer m_uint32Values_mirror;
	
	/** The values count. */
	protected int valuesCount = 0;

	/**
	 * Instantiates a new world object.
	 *
	 * @param objectId the object id
	 */
	public WorldObject(long objectId) {
		super((int) objectId);
		guid = new ObjectGuid(objectId);
	}
	
	/**
	 * Gets the object type.
	 *
	 * @return the objectType
	 */
	public final EnumSet<TypeMask> getObjectType() {
		return objectType;
	}
	
	/**
	 * Sets the object type.
	 *
	 * @param objectType the objectType to set
	 */
	public final void setObjectType(EnumSet<TypeMask> objectType) {
		this.objectType = objectType;
	}
	
	/**
	 * Gets the object guid.
	 *
	 * @return the guid
	 */
	public final ObjectGuid getObjectGuid() {
		return guid;
	}
	
	/**
	 * Gets the object type id.
	 *
	 * @return the m_objectTypeId
	 */
	public TypeId getObjectTypeId() {
		return objectTypeId;
	}
	
	/**
	 * Sets the object type id.
	 *
	 * @param ObjectTypeId the objectTypeId to set
	 */
	public void setObjectTypeId(TypeId ObjectTypeId) {
		objectTypeId = ObjectTypeId;
	}

	/**
	 * Update.
	 */
	public void update() {
		System.out.println(m_uint32Values.capacity());
	}

	/**
	 * Initfields.
	 */
	public void initfields() {
		m_uint32Values = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN,
				valuesCount*4);
	}
	
	/**
	 * Sets the u int32 value.
	 *
	 * @param i the i
	 * @param value the value
	 */
	public void SetUInt32Value(int i, int value) {
		m_uint32Values.setInt(i*4, value);
	}
	
	/**
	 * Gets the u int32 value.
	 *
	 * @param i the i
	 * @return the int
	 */
	public int GetUInt32Value(int i) {
		return m_uint32Values.getInt(i*4);
	}
	
	/**
	 * Sets the u int64 value.
	 *
	 * @param i the i
	 * @param value the value
	 */
	public void SetUInt64Value(int i, long value) {
		m_uint32Values.setLong(i*4, value);
	}
	
	/**
	 * Gets the u int64 value.
	 *
	 * @param i the i
	 * @param value the value
	 * @return the long
	 */
	public long GetUInt64Value(int i, long value) {
		return m_uint32Values.getLong(i*4);
	}
	
	/**
	 * _ load into data field.
	 *
	 * @param strings the strings
	 * @param from the from
	 * @param count the count
	 */
	public void _LoadIntoDataField(String[] strings, int from, int count) {
		for (int i = 0; i < strings.length; i++) {
			SetUInt32Value(from + i, Integer.decode(strings[i]));
		}
	}
	
	/**
	 * Load values.
	 *
	 * @param data the data
	 * @return true, if successful
	 */
	public boolean loadValues(String[] data){
		if (data.length != valuesCount){
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
	 * @param index the index
	 * @param offset the offset
	 * @param value the value
	 */
	public void SetByteValue(int index, int offset, byte value){
		if (offset > 4) 
		return;
		int rvalue = GetUInt32Value(index);
	    if((rvalue >> (offset * 8)) != value)
	    {
	    	rvalue &= ~(0xFF << (offset * 8));
	    	rvalue |= (value << (offset * 8));
	    }
	    SetUInt32Value(index, rvalue);
	}
	
	/**
	 * Sets the float value.
	 *
	 * @param i the i
	 * @param value the value
	 */
	public void SetFloatValue(int i, float value) {
		m_uint32Values.setFloat(i*4, value);
	}
	
	/**
	 * Gets the float value.
	 *
	 * @param i the i
	 * @return the float
	 */
	public float GetFloatValue(int i) {
		return m_uint32Values.getFloat(i*4);
	}
}
