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
package org.JMANGOS.realm.model.unit;

// TODO: Auto-generated Javadoc
/**
 * The Enum Powers.
 */
public enum Powers {
	    
    	/** The POWE r_ mana. */
    	POWER_MANA                         (0),
	    
    	/** The POWE r_ rage. */
    	POWER_RAGE                         (1),
	    
    	/** The POWE r_ focus. */
    	POWER_FOCUS                        (2),
	    
    	/** The POWE r_ energy. */
    	POWER_ENERGY                       (3),
	    
    	/** The POWE r_ happiness. */
    	POWER_HAPPINESS                    (4),
	    
    	/** The POWE r_ rune. */
    	POWER_RUNE                         (5),
	    
    	/** The POWE r_ runi c_ power. */
    	POWER_RUNIC_POWER                  (6),
	    
    	/** The POWE r_ health. */
    	POWER_HEALTH                       (0xFFFFFFFE);
	    
	    /** The value. */
    	private int value;
	    
    	/** The MA x_ power. */
    	public static int MAX_POWER = 7;
		
		/**
		 * Instantiates a new powers.
		 *
		 * @param val the val
		 */
		Powers(int val){
	    	this.setValue(val);
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
