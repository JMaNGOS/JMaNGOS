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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class World.
 */
@Entity
@Table
public class Realm {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    
    /** The name. */
    @Column(nullable = false)
    private String name;
    
    /** The address. */
    @Column(nullable = false)
    private String address;
    
    /** The port. */
    @Column
    private int    port;
    
    /** The icon. */
    @Column
    private int    icon;
    
    /** The realmflags. */
    @Column
    private int    realmflags;
    
    /** The timezone. */
    @Column
    private int    timezone;
    
    /** The allowed security level. */
    @Column
    private int    allowedSecurityLevel = 0;
    
    /** The population. */
    @Column
    private float  population           = 0.0f;
    
    /** The realmbuilds. */
    @Column(nullable = false)
    private String realmbuilds;
    
    /**
     * Instantiates a new realm.
     * 
     * @param id
     *            the id
     * @param name
     *            the name
     * @param address
     *            the address
     * @param port
     *            the port
     * @param icon
     *            the icon
     * @param realmflags
     *            the realmflags
     * @param timezone
     *            the timezone
     * @param allowedSecurityLevel
     *            the allowed security level
     * @param population
     *            the population
     * @param realmbuilds
     *            the realmbuilds
     */
    public Realm(final int id, final String name, final String address, final int port, final int icon, final int realmflags, final int timezone,
            final int allowedSecurityLevel, final float population, final String realmbuilds) {
    
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
    public Realm() {
    
    }
    
    /**
     * Gets the size.
     * 
     * @return the size
     */
    public int getSize() {
    
        return 8 + 4 + getAddress().length() + getName().length();
    }
    
    /**
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
    
        return this.id;
    }
    
    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(final int id) {
    
        this.id = id;
    }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
    
        return this.name;
    }
    
    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
    
        this.name = name;
    }
    
    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
    
        return this.address + ':' + this.port;
    }
    
    /**
     * Sets the address.
     * 
     * @param address
     *            the address to set
     */
    public void setAddress(final String address) {
    
        this.address = address;
    }
    
    /**
     * Gets the port.
     * 
     * @return the port
     */
    public int getPort() {
    
        return this.port;
    }
    
    /**
     * Sets the port.
     * 
     * @param port
     *            the port to set
     */
    public void setPort(final int port) {
    
        this.port = port;
    }
    
    /**
     * Gets the icon.
     * 
     * @return the icon
     */
    public int getIcon() {
    
        return this.icon;
    }
    
    /**
     * Sets the icon.
     * 
     * @param icon
     *            the icon to set
     */
    public void setIcon(final int icon) {
    
        this.icon = icon;
    }
    
    /**
     * Gets the realmflags.
     * 
     * @return the realmflags
     */
    public int getRealmflags() {
    
        return this.realmflags;
    }
    
    /**
     * Sets the realmflags.
     * 
     * @param realmflags
     *            the realmflags to set
     */
    public void setRealmflags(final int realmflags) {
    
        this.realmflags = realmflags;
    }
    
    /**
     * Gets the timezone.
     * 
     * @return the timezone
     */
    public int getTimezone() {
    
        return this.timezone;
    }
    
    /**
     * Sets the timezone.
     * 
     * @param timezone
     *            the timezone to set
     */
    public void setTimezone(final int timezone) {
    
        this.timezone = timezone;
    }
    
    /**
     * Gets the allowed security level.
     * 
     * @return the allowedSecurityLevel
     */
    public int getAllowedSecurityLevel() {
    
        return this.allowedSecurityLevel;
    }
    
    /**
     * Sets the allowed security level.
     * 
     * @param allowedSecurityLevel
     *            the allowedSecurityLevel to set
     */
    public void setAllowedSecurityLevel(final int allowedSecurityLevel) {
    
        this.allowedSecurityLevel = allowedSecurityLevel;
    }
    
    /**
     * Gets the population.
     * 
     * @return the population
     */
    public float getPopulation() {
    
        return this.population;
    }
    
    /**
     * Sets the population.
     * 
     * @param population
     *            the population to set
     */
    public void setPopulation(final float population) {
    
        this.population = population;
    }
    
    /**
     * Gets the realmbuilds.
     * 
     * @return the realmbuilds
     */
    public String getRealmbuilds() {
    
        return this.realmbuilds;
    }
    
    /**
     * Sets the realmbuilds.
     * 
     * @param realmbuilds
     *            the realmbuilds to set
     */
    public void setRealmbuilds(final String realmbuilds) {
    
        this.realmbuilds = realmbuilds;
    }
}
