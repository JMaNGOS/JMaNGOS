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
 * The Enum UnitStandFlags.
 */
public enum UnitStandFlags {
	 	
	 	/** The UNI t_ stan d_ flag s_ un k1. */
	 	UNIT_STAND_FLAGS_UNK1         ( 1 << 0 ),
	    
    	/** The UNI t_ stan d_ flag s_ creep. */
    	UNIT_STAND_FLAGS_CREEP        ( 1 << 1 ),
	    
    	/** The UNI t_ stan d_ flag s_ un k3. */
    	UNIT_STAND_FLAGS_UNK3         ( 1 << 2 ),
	    
    	/** The UNI t_ stan d_ flag s_ un k4. */
    	UNIT_STAND_FLAGS_UNK4         ( 1 << 3 ),
	    
    	/** The UNI t_ stan d_ flag s_ un k5. */
    	UNIT_STAND_FLAGS_UNK5         ( 1 << 4 ),
	    
    	/** The UNI t_ stan d_ flag s_ all. */
    	UNIT_STAND_FLAGS_ALL          (0xFF);
	 	
	 	/** The flag. */
	 	private int flag;

		/**
		 * Instantiates a new unit stand flags.
		 *
		 * @param flag the flag
		 */
		UnitStandFlags(int flag){
	 		this.flag = flag;
	 	}
		
		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public int getValue(){
			return flag;
		}
}
