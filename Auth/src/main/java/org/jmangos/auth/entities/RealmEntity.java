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
package org.jmangos.auth.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "realmlist")
public class RealmEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** The name. */
    @Column(name = "NAME", length = 32, nullable = false)
    private String name;

    /** The address. */
    @Column(name = "ADDRESS", length = 32, nullable = false)
    private String address;

    /** The port. */
    @Column(name = "PORT")
    private Integer port;

    /** The icon. */
    @Column(name = "ICON")
    private Integer icon;

    /** The realmflags. */
    @Column(name = "REALMFLAGS")
    private Integer realmflags;

    /** The timezone. */
    @Column(name = "TIMEZONE")
    private Integer timezone;

    /** The allowed security level. */
    @Column(name = "ALLOWEDSECURITYLEVEL")
    private Integer allowedSecurityLevel;

    /** The population. */
    @Column(name = "POPULATION")
    private Float population;

    /** The realmbuilds. */
    @Column(name = "REALMBUILDS", length = 64, nullable = false)
    private String realmbuilds;

    public Integer getId() {

        return this.id;
    }

    public void setId(final Integer id) {

        this.id = id;
    }

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public String getAddress() {

        return this.address;
    }

    public void setAddress(final String address) {

        this.address = address;
    }

    public Integer getPort() {

        return this.port;
    }

    public void setPort(final Integer port) {

        this.port = port;
    }

    public Integer getIcon() {

        return this.icon;
    }

    public void setIcon(final Integer icon) {

        this.icon = icon;
    }

    public Integer getRealmflags() {

        return this.realmflags;
    }

    public void setRealmflags(final Integer realmflags) {

        this.realmflags = realmflags;
    }

    public Integer getTimezone() {

        return this.timezone;
    }

    public void setTimezone(final Integer timezone) {

        this.timezone = timezone;
    }

    public Integer getAllowedSecurityLevel() {

        return this.allowedSecurityLevel;
    }

    public void setAllowedSecurityLevel(final Integer allowedSecurityLevel) {

        this.allowedSecurityLevel = allowedSecurityLevel;
    }

    public Float getPopulation() {

        return this.population;
    }

    public void setPopulation(final Float population) {

        this.population = population;
    }

    public String getRealmbuilds() {

        return this.realmbuilds;
    }

    public void setRealmbuilds(final String realmbuilds) {

        this.realmbuilds = realmbuilds;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.id, this.name);
    }

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
        final RealmEntity other = (RealmEntity) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.name, other.name);
    }

}
