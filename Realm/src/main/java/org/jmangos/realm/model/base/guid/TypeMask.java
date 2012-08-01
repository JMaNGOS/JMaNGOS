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
package org.jmangos.realm.model.base.guid;

import java.util.EnumSet;

// TODO: Auto-generated Javadoc
/**
 * The Enum TypeMask.
 */
public enum TypeMask {

	/** The TYPEMAS k_ object. */
	TYPEMASK_OBJECT(0x0001),
	/** The TYPEMAS k_ item. */
	TYPEMASK_ITEM(0x0002),
	/** The TYPEMAS k_ container. */
	TYPEMASK_CONTAINER(0x0004),
	/** The TYPEMAS k_ unit. */
	TYPEMASK_UNIT(0x0008),

	/** The TYPEMAS k_ player. */
	TYPEMASK_PLAYER(0x0010),
	/** The TYPEMAS k_ gameobject. */
	TYPEMASK_GAMEOBJECT(0x0020),
	/** The TYPEMAS k_ dynamicobject. */
	TYPEMASK_DYNAMICOBJECT(0x0040),
	/** The TYPEMAS k_ corpse. */
	TYPEMASK_CORPSE(0x0080);

	/** The Constant TYPEMASK_CREATURE_OR_GAMEOBJECT. */
	final static EnumSet<TypeMask> TYPEMASK_CREATURE_OR_GAMEOBJECT = EnumSet
			.of(TYPEMASK_UNIT, TYPEMASK_GAMEOBJECT);

	/** The Constant TYPEMASK_CREATURE_GAMEOBJECT_OR_ITEM. */
	final static EnumSet<TypeMask> TYPEMASK_CREATURE_GAMEOBJECT_OR_ITEM = EnumSet
			.of(TYPEMASK_UNIT, TYPEMASK_GAMEOBJECT, TYPEMASK_ITEM);

	/** The Constant TYPEMASK_CREATURE_GAMEOBJECT_PLAYER_OR_ITEM. */
	final static EnumSet<TypeMask> TYPEMASK_CREATURE_GAMEOBJECT_PLAYER_OR_ITEM = EnumSet
			.of(TYPEMASK_UNIT, TYPEMASK_GAMEOBJECT, TYPEMASK_ITEM,
					TYPEMASK_PLAYER);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new type mask.
	 * 
	 * @param value
	 *            the value
	 */
	TypeMask(int value) {
		this.setValue(value);
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
