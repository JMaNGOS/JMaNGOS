/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.model;

/**
 * The Class Account.
 */
public class RealmInfo extends NamedObject {

    /** The address. */
    private String address;

    /** The port. */
    private Integer port;

    /** The icon. */
    private Integer icon;

    /** The realmflags. */
    private Integer realmflags;

    /** The timezone. */
    private Integer timezone;

    /** The allowed security level. */
    private Integer allowedSecurityLevel;

    /** The population. */
    private Float population;

    /** The realmbuilds. */
    private String realmbuilds;

    public RealmInfo(final Integer id) {

        super(id);

    }

    public RealmInfo() {

        super();

    }

    /**
     * @return the address
     */
    public final String getAddress() {

        return this.address;
    }

    /**
     * @return the port
     */
    public final Integer getPort() {

        return this.port;
    }

    /**
     * @return the icon
     */
    public final Integer getIcon() {

        return this.icon;
    }

    /**
     * @return the realmflags
     */
    public final Integer getRealmflags() {

        return this.realmflags;
    }

    /**
     * @return the timezone
     */
    public final Integer getTimezone() {

        return this.timezone;
    }

    /**
     * @return the allowedSecurityLevel
     */
    public final Integer getAllowedSecurityLevel() {

        return this.allowedSecurityLevel;
    }

    /**
     * @return the population
     */
    public final Float getPopulation() {

        return this.population;
    }

    /**
     * @return the realmbuilds
     */
    public final String getRealmbuilds() {

        return this.realmbuilds;
    }

    /**
     * @param address
     *        the address to set
     */
    public final void setAddress(final String address) {

        this.address = address;
    }

    /**
     * @param port
     *        the port to set
     */
    public final void setPort(final Integer port) {

        this.port = port;
    }

    /**
     * @param icon
     *        the icon to set
     */
    public final void setIcon(final Integer icon) {

        this.icon = icon;
    }

    /**
     * @param realmflags
     *        the realmflags to set
     */
    public final void setRealmflags(final Integer realmflags) {

        this.realmflags = realmflags;
    }

    /**
     * @param timezone
     *        the timezone to set
     */
    public final void setTimezone(final Integer timezone) {

        this.timezone = timezone;
    }

    /**
     * @param allowedSecurityLevel
     *        the allowedSecurityLevel to set
     */
    public final void setAllowedSecurityLevel(final Integer allowedSecurityLevel) {

        this.allowedSecurityLevel = allowedSecurityLevel;
    }

    /**
     * @param population
     *        the population to set
     */
    public final void setPopulation(final Float population) {

        this.population = population;
    }

    /**
     * @param realmbuilds
     *        the realmbuilds to set
     */
    public final void setRealmbuilds(final String realmbuilds) {

        this.realmbuilds = realmbuilds;
    }

}
