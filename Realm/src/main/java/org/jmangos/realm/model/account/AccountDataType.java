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
package org.jmangos.realm.model.account;

// TODO: Auto-generated Javadoc
/**
 * The Enum AccountDataType.
 */
public enum AccountDataType {
	
	/** The GLOBA l_ confi g_ cache. */
	GLOBAL_CONFIG_CACHE(0), // 0x01 g
	/** The PE r_ characte r_ confi g_ cache. */
 PER_CHARACTER_CONFIG_CACHE(1), // 0x02 p
	/** The GLOBA l_ binding s_ cache. */
 GLOBAL_BINDINGS_CACHE(2), // 0x04 g
	/** The PE r_ characte r_ binding s_ cache. */
 PER_CHARACTER_BINDINGS_CACHE(3), // 0x08 p
	/** The GLOBA l_ macro s_ cache. */
 GLOBAL_MACROS_CACHE(4), // 0x10 g
	/** The PE r_ characte r_ macro s_ cache. */
 PER_CHARACTER_MACROS_CACHE(5), // 0x20 p
	/** The PE r_ characte r_ layou t_ cache. */
 PER_CHARACTER_LAYOUT_CACHE(6), // 0x40 p
	/** The PE r_ characte r_ cha t_ cache. */
 PER_CHARACTER_CHAT_CACHE(7), // 0x80 p
	/** The NU m_ accoun t_ dat a_ types. */
 NUM_ACCOUNT_DATA_TYPES(8);
	
	/** The value. */
	private int value;

	/**
	 * Instantiates a new account data type.
	 *
	 * @param idval the idval
	 */
	AccountDataType(int idval) {
		this.value = idval;
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
