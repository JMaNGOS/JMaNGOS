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
package org.JMANGOS.realm.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum Classes.
 */
public enum Classes {
	
	/** The CLAS s_ warrior. */
	CLASS_WARRIOR(1), 
 /** The CLAS s_ paladin. */
 CLASS_PALADIN(2), 
 /** The CLAS s_ hunter. */
 CLASS_HUNTER(3), 
 /** The CLAS s_ rogue. */
 CLASS_ROGUE(4), 
 /** The CLAS s_ priest. */
 CLASS_PRIEST(
			5), 
 /** The CLAS s_ deat h_ knight. */
 CLASS_DEATH_KNIGHT(6), 
 /** The CLAS s_ shaman. */
 CLASS_SHAMAN(7), 
 /** The CLAS s_ mage. */
 CLASS_MAGE(8), 
 /** The CLAS s_ warlock. */
 CLASS_WARLOCK(
			9), 
 /** The CLAS s_ druid. */
 CLASS_DRUID(11);
	
	/** The value. */
	private int value;

	/**
	 * Instantiates a new classes.
	 *
	 * @param value the value
	 */
	Classes(int value) {
		this.setValue(value);
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
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
