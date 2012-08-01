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
