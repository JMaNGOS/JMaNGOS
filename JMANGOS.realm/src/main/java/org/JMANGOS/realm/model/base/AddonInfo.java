/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.base;

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
