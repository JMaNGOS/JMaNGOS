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
package org.jmangos.realm.model.base;

// TODO: Auto-generated Javadoc
/**
 * The Class AddonInfo.
 */
public class AddonInfo {
	
	/** The Name. */
	private String Name;
    
    /** The Enabled. */
    private byte Enabled;
    
    /** The CRC. */
    private int CRC;
	
	/**
	 * Instantiates a new addon info.
	 *
	 * @param name the name
	 * @param enabled the enabled
	 * @param crc the crc
	 */
	public AddonInfo(String name, byte enabled, int crc) {
		super();
		Name = name;
		Enabled = enabled;
		CRC = crc;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return Name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public final void setName(String name) {
		Name = name;
	}
	
	/**
	 * Gets the enabled.
	 *
	 * @return the enabled
	 */
	public final byte getEnabled() {
		return Enabled;
	}
	
	/**
	 * Sets the enabled.
	 *
	 * @param enabled the enabled to set
	 */
	public final void setEnabled(byte enabled) {
		Enabled = enabled;
	}
	
	/**
	 * Gets the cRC.
	 *
	 * @return the cRC
	 */
	public final int getCRC() {
		return CRC;
	}
	
	/**
	 * Sets the cRC.
	 *
	 * @param cRC the cRC to set
	 */
	public final void setCRC(int cRC) {
		CRC = cRC;
	}
}
