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
package org.jmangos.realm.model;

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
     * @param clazz
     *            the clazz
     * @param level
     *            the level
     */
    public ClassLevel(final int clazz, final int level) {
    
        this.clazz = clazz;
        this.level = level;
        this.hashCode = (level * 100) + clazz;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
    
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if ((((ClassLevel) obj).clazz == this.clazz) && (((ClassLevel) obj).level == this.level)) {
            return true;
        }
        return false;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
    
        return this.hashCode;
    }
}
