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
 * The Class ClassLevel.
 */
public class ClassLevel {
	
	/** The clazz. */
	int clazz;
	
	/** The level. */
	int level;
	
	/** The hash code. */
	int hashCode = 0;

	/**
	 * Instantiates a new class level.
	 *
	 * @param clazz the clazz
	 * @param level the level
	 */
	public ClassLevel(int clazz, int level) {
		this.clazz = clazz;
		this.level = level;
		this.hashCode = level*100+clazz;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if ((((ClassLevel) obj).clazz == this.clazz)
				&& (((ClassLevel) obj).level == this.level)) {
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	    return hashCode;
	}
}
