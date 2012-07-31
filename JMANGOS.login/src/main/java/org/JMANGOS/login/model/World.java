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
package org.JMANGOS.login.model;

// TODO: Auto-generated Javadoc
/**
 * The Class World.
 */
public class World {
	  
  	/** The id. */
  	private int id;
	  
  	/** The name. */
  	private String name;
	  
  	/** The address. */
  	private String address;
	  
  	/** The port. */
  	private int port;
	  
  	/** The icon. */
  	private int icon;
	  
  	/** The realmflags. */
  	private int realmflags;
	  
  	/** The timezone. */
  	private int timezone;
	  
  	/** The allowed security level. */
  	private int allowedSecurityLevel;
	  
  	/** The population. */
  	private float population;
	  
  	/** The realmbuilds. */
  	private String realmbuilds;
	  
	/**
	 * Instantiates a new world.
	 *
	 * @param id the id
	 * @param name the name
	 * @param address the address
	 * @param port the port
	 * @param icon the icon
	 * @param realmflags the realmflags
	 * @param timezone the timezone
	 * @param allowedSecurityLevel the allowed security level
	 * @param population the population
	 * @param realmbuilds the realmbuilds
	 */
	public World(int id, String name, String address, int port, int icon,
			int realmflags, int timezone, int allowedSecurityLevel,
			float population, String realmbuilds) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.port = port;
		this.icon = icon;
		this.realmflags = realmflags;
		this.timezone = timezone;
		this.allowedSecurityLevel = allowedSecurityLevel;
		this.population = population;
		this.realmbuilds = realmbuilds;
	}
	
	/**
	 * Instantiates a new world.
	 */
	public World() {
		
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize(){
		return 8+4+getAddress().length() + getName().length();
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address+':'+port;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Sets the port.
	 *
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public int getIcon() {
		return icon;
	}
	
	/**
	 * Sets the icon.
	 *
	 * @param icon the icon to set
	 */
	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	/**
	 * Gets the realmflags.
	 *
	 * @return the realmflags
	 */
	public int getRealmflags() {
		return realmflags;
	}
	
	/**
	 * Sets the realmflags.
	 *
	 * @param realmflags the realmflags to set
	 */
	public void setRealmflags(int realmflags) {
		this.realmflags = realmflags;
	}
	
	/**
	 * Gets the timezone.
	 *
	 * @return the timezone
	 */
	public int getTimezone() {
		return timezone;
	}
	
	/**
	 * Sets the timezone.
	 *
	 * @param timezone the timezone to set
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	
	/**
	 * Gets the allowed security level.
	 *
	 * @return the allowedSecurityLevel
	 */
	public int getAllowedSecurityLevel() {
		return allowedSecurityLevel;
	}
	
	/**
	 * Sets the allowed security level.
	 *
	 * @param allowedSecurityLevel the allowedSecurityLevel to set
	 */
	public void setAllowedSecurityLevel(int allowedSecurityLevel) {
		this.allowedSecurityLevel = allowedSecurityLevel;
	}
	
	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	public float getPopulation() {
		return population;
	}
	
	/**
	 * Sets the population.
	 *
	 * @param population the population to set
	 */
	public void setPopulation(float population) {
		this.population = population;
	}
	
	/**
	 * Gets the realmbuilds.
	 *
	 * @return the realmbuilds
	 */
	public String getRealmbuilds() {
		return realmbuilds;
	}
	
	/**
	 * Sets the realmbuilds.
	 *
	 * @param realmbuilds the realmbuilds to set
	 */
	public void setRealmbuilds(String realmbuilds) {
		this.realmbuilds = realmbuilds;
	}
}
