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
package org.jmangos.realm.model.player;

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
