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
package org.jmangos.commons.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AddonInfo.
 */
public class AddonInfo {
    
    /** The Name. */
    private String Name;
    
    /** The Enabled. */
    private byte   Enabled;
    
    /** The CRC. */
    private int    CRC;
    
    /**
     * Instantiates a new addon info.
     * 
     * @param name
     *            the name
     * @param enabled
     *            the enabled
     * @param crc
     *            the crc
     */
    public AddonInfo(final String name, final byte enabled, final int crc) {
    
        super();
        this.Name = name;
        this.Enabled = enabled;
        this.CRC = crc;
    }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public final String getName() {
    
        return this.Name;
    }
    
    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
    
        this.Name = name;
    }
    
    /**
     * Gets the enabled.
     * 
     * @return the enabled
     */
    public final byte getEnabled() {
    
        return this.Enabled;
    }
    
    /**
     * Sets the enabled.
     * 
     * @param enabled
     *            the enabled to set
     */
    public final void setEnabled(final byte enabled) {
    
        this.Enabled = enabled;
    }
    
    /**
     * Gets the cRC.
     * 
     * @return the cRC
     */
    public final int getCRC() {
    
        return this.CRC;
    }
    
    /**
     * Sets the cRC.
     * 
     * @param cRC
     *            the cRC to set
     */
    public final void setCRC(final int cRC) {
    
        this.CRC = cRC;
    }
}
