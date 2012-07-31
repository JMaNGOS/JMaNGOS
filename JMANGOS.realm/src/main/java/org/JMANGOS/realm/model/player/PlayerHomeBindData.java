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
package org.JMANGOS.realm.model.player;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerHomeBindData.
 */
public class PlayerHomeBindData {
	
	/** The home bind position x. */
	private float homeBindPositionX;
	
	/** The home bind position y. */
	private float homeBindPositionY;
	
	/** The home bind position z. */
	private float homeBindPositionZ;
	
	/** The home bind map id. */
	private int homeBindMapId;
	
	/** The home bind area id. */
	private int homeBindAreaId;
	
	/**
	 * Instantiates a new player home bind data.
	 *
	 * @param homeBindPositionX the home bind position x
	 * @param homeBindPositionY the home bind position y
	 * @param homeBindPositionZ the home bind position z
	 * @param homeBindMapId the home bind map id
	 * @param homeBindAreaId the home bind area id
	 */
	public PlayerHomeBindData(float homeBindPositionX, float homeBindPositionY,
			float homeBindPositionZ, int homeBindMapId, int homeBindAreaId) {
		this.homeBindPositionX = homeBindPositionX;
		this.homeBindPositionY = homeBindPositionY;
		this.homeBindPositionZ = homeBindPositionZ;
		this.homeBindMapId = homeBindMapId;
		this.homeBindAreaId = homeBindAreaId;
	}
	
	/**
	 * Gets the home bind position x.
	 *
	 * @return the home bind position x
	 */
	public final float getHomeBindPositionX() {
		return homeBindPositionX;
	}
	
	/**
	 * Sets the home bind position x.
	 *
	 * @param homeBindPositionX the new home bind position x
	 */
	public final void setHomeBindPositionX(float homeBindPositionX) {
		this.homeBindPositionX = homeBindPositionX;
	}
	
	/**
	 * Gets the home bind position y.
	 *
	 * @return the home bind position y
	 */
	public final float getHomeBindPositionY() {
		return homeBindPositionY;
	}
	
	/**
	 * Sets the home bind position y.
	 *
	 * @param homeBindPositionY the new home bind position y
	 */
	public final void setHomeBindPositionY(float homeBindPositionY) {
		this.homeBindPositionY = homeBindPositionY;
	}
	
	/**
	 * Gets the home bind position z.
	 *
	 * @return the home bind position z
	 */
	public final float getHomeBindPositionZ() {
		return homeBindPositionZ;
	}
	
	/**
	 * Sets the home bind position z.
	 *
	 * @param homeBindPositionZ the new home bind position z
	 */
	public final void setHomeBindPositionZ(float homeBindPositionZ) {
		this.homeBindPositionZ = homeBindPositionZ;
	}
	
	/**
	 * Gets the home bind map id.
	 *
	 * @return the home bind map id
	 */
	public final int getHomeBindMapId() {
		return homeBindMapId;
	}
	
	/**
	 * Sets the home bind map id.
	 *
	 * @param homeBindMapId the new home bind map id
	 */
	public final void setHomeBindMapId(int homeBindMapId) {
		this.homeBindMapId = homeBindMapId;
	}
	
	/**
	 * Gets the home bind area id.
	 *
	 * @return the home bind area id
	 */
	public final int getHomeBindAreaId() {
		return homeBindAreaId;
	}
	
	/**
	 * Sets the home bind area id.
	 *
	 * @param homeBindAreaId the new home bind area id
	 */
	public final void setHomeBindAreaId(int homeBindAreaId) {
		this.homeBindAreaId = homeBindAreaId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("Map %s koords %s, %s ,%s", homeBindMapId,
				homeBindPositionX, homeBindPositionY, homeBindPositionZ);

	}
}
