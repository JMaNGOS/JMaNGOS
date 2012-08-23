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
package org.jmangos.auth.model;

public class RealmDto implements Cloneable {
    
    private Long    id;
    private String  name;
    private String  address;
    private Integer port;
    private Integer icon;
    private Integer realmflags;
    private Integer timezone;
    private Integer allowedSecurityLevel;
    private Float   population;
    private String  realmbuilds;
    
    public Long getId() {
    
        return this.id;
    }
    
    public void setId(final Long id) {
    
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
    public String toString() {
    
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nid = ").append(this.id).append("\nname = ").append(this.name).append("\n");
        return sb.toString();
    }
    
    @Override
    public RealmDto clone() {
    
        final RealmDto clone = new RealmDto();
        fillClone(clone);
        return clone;
    }
    
    protected void fillClone(final RealmDto clone) {
    
        clone.setId(getId());
        clone.setName(getName());
        clone.setAddress(getAddress());
        clone.setPort(getPort());
        clone.setIcon(getIcon());
        clone.setRealmflags(getRealmflags());
        clone.setTimezone(getTimezone());
        clone.setAllowedSecurityLevel(getAllowedSecurityLevel());
        clone.setPopulation(getPopulation());
        clone.setRealmbuilds(getRealmbuilds());
    }
}
