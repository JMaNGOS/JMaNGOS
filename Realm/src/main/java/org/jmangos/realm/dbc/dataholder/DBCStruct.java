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
package org.jmangos.realm.dbc.dataholder;

import javolution.io.Struct;

import javax.xml.bind.annotation.XmlAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class DBCStruct<T extends DBCStruct<T>> extends DBCBaseStruct
		implements Iterable<T>, Iterator<T>, Cloneable {
	private int count;
	private int skiplenght = 0;
	private int currposition = 0;
	private Object[] FiledsName;
	private boolean mode;

	@SuppressWarnings("unchecked")
	@Override
	protected <M extends Struct.Member> M[] array(M[] param) {
		if (param.length > 0) {
			if (INTERNALSTRING.isInstance(param)) {
				for (int i = 0; i < param.length;) {
					param[i++] = (M) new InternalString();
				}
				return param;
			} else
				return super.array(param);
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	public T LookupEntry(int i) {
		setCurrposition(i);
		setByteBufferPosition(HEADER_SIZE + (size() + skiplenght) * i);
		return (T) this;
	}

	public final void setStringBufferPosition(int stringBufPos) {
		this.stringBufPos = stringBufPos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T clone() {
		T re = null;
		try {
			re = (T) this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		re.setByteBuffer(getByteBuffer(), getByteBufferPosition());
		re.setStringBufferPosition(stringBufPos);
		return re;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSkiplenght() {
		return skiplenght;
	}

	public void setSkipLenght(int skiplenght) {
		this.skiplenght = skiplenght;
	}

	@Override
	public boolean hasNext() {
		return (currposition + 1) < getCount();
	}

	@Override
	public T next() {
		if (hasNext()) {
			return LookupEntry(currposition + 1);
		}
		return null;
	}

	@Override
	public void remove() {

	}

	public void cacheFields( boolean mode) {
		Field[] f = this.getClass().getFields();
		List<String> TFiledsName = new ArrayList<String>();
		for (int i = 0; i < f.length; i++) {
			if (Modifier.isStatic(f[i].getModifiers())
					|| !f[i].isAnnotationPresent(XmlAttribute.class)) {
				continue;
			}
			XmlAttribute property = f[i].getAnnotation(XmlAttribute.class);
			if (property.name() != null & (property.required() | mode)) {
				try {
					if (f[i].getType().isArray()) {
						Object sd = f[i].get(this);
						for (int j = 0; j < Array.getLength(sd); j++) {
							TFiledsName.add(property.name() + (j + 1));
						}
					} else if (f[i].getType() == InternalString.class
							|| f[i].getType() == MultiInternalString.class) {
						if (mode)
							TFiledsName.add(property.name());
					} else {
						TFiledsName.add(property.name());
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}
		;
		FiledsName = TFiledsName.toArray();
	}


	public void setCurrposition(int currposition) {
		this.currposition = currposition;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T iterator() {
		return (T) this;
	}
}
