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
package org.jmangos.realm.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The Class ItemPrototype.
 * 
 * @author minimajack
 */
@Entity
@Table(name = "item_instance")
public class ItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guid", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    private Integer         guid;
    
    @Basic
    @Column(name = "proto", nullable = true, insertable = true, updatable = true, length = 11, precision = 0)
    private Integer         proto;
    
    @Basic
    @Column(name = "owner_guid", nullable = true, insertable = true, updatable = true, length = 11, precision = 0)
    private Integer         ownerGuid;
    
    /** The Owner. */
    @OneToOne
    @PrimaryKeyJoinColumn(name = "owner_guid", referencedColumnName = "guid")
    private CharacterEntity owner;
    
    /** The data */
    @Basic
    @Column(name = "data", length = 512, nullable = true, insertable = true, updatable = true)
    private String          data;     // id from
                                       // ItemSubClass.dbc
                                       
    /** The text */
    @Basic
    @Column(name = "text", length = 512, nullable = true, insertable = true, updatable = true)
    private String          text;
    
    /** Instantiate new item entry. */
    public ItemEntity() {
    
    }
    
    /**
     * @return the guid
     */
    public final Integer getGuid() {
    
        return this.guid;
    }
    
    /**
     * @param guid
     *            the guid to set
     */
    public final void setGuid(final Integer guid) {
    
        this.guid = guid;
    }
    
    /**
     * @return the ownerId
     */
    public final long getOwnerGuid() {
    
        return this.ownerGuid;
    }
    
    /**
     * @param ownerId
     *            the ownerId to set
     */
    public final void setOwnerGuid(final Integer ownerId) {
    
        this.ownerGuid = ownerId;
    }
    
    /**
     * @return the owner
     */
    
    public final CharacterEntity getOwner() {
    
        return this.owner;
    }
    
    /**
     * @param owner
     *            the owner to set
     */
    
    public final void setOwner(final CharacterEntity owner) {
    
        this.ownerGuid = owner.getGuid();
        this.owner = owner;
    }
    
    /**
     * @return the data
     */
    public final String getData() {
    
        return this.data;
    }
    
    /**
     * @param data
     *            the data to set
     */
    public final void setData(final String data) {
    
        this.data = data;
    }
    
    /**
     * @return the text
     */
    public final String getText() {
    
        return this.text;
    }
    
    /**
     * @param text
     *            the text to set
     */
    public final void setText(final String text) {
    
        this.text = text;
    }
    
    /**
     * @return the proto
     */
    public final Integer getProto() {
    
        return this.proto;
    }
    
    /**
     * @param proto
     *            the proto to set
     */
    public final void setProto(final Integer proto) {
    
        this.proto = proto;
    }
    
}
