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
package org.jmangos.auth.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Account.
 */
@Entity
@Table(name = "account")
public class AccountEntity {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /** The user name. */
    @Column(name = "USERNAME", length = 32, unique = true)
    private String  username;
    
    /** Password hash. */
    @Column(name = "SHA_PASS_HASH", length = 32)
    private String  shaPasswordHash;
    
    /** Access level of account 0 = regular user, > 0 = GM. */
    @Column(name = "GMLEVEL")
    private Byte    gmlevel;
    
    /** The session key. */
    @Column(name = "SESSIONKEY")
    private String  sessionKey;
    
    /** The v. */
    @Column(name = "V", nullable = false)
    private String  v;
    
    /** The s. */
    @Column(name = "S", nullable = false)
    private String  s;
    
    @Column(name = "EMAIL")
    private String  email;
    
    // @Column(name = "JOINDATE")
    // private Date joindate;
    
    @Column(name = "LAST_IP", length = 30)
    private String  lastIp;
    
    @Column(name = "FAILED_LOGINS")
    private Long    failedLogins;
    
    /** Account activated. */
    @Column(name = "LOCKED")
    private Byte    locked;
    
    // @Column(name = "LAST_LOGIN")
    // private Date lastLogin;
    
    @Column(name = "ACTIVE_REALM_ID")
    private Long    activeRealmId;
    
    @Column(name = "EXPANSION")
    private Byte    expansion;
    
    @Column(name = "MUTETIME")
    private Long    mutetime;
    
    @Column(name = "LOCALE")
    private Byte    locale;
    
    @Column(name = "LAST_SERVER")
    private Byte    lastServer;
    
    public Integer getId() {
    
        return this.id;
    }
    
    public void setId(final Integer id) {
    
        this.id = id;
    }
    
    public String getUsername() {
    
        return this.username;
    }
    
    public void setUsername(final String username) {
    
        this.username = username;
    }
    
    public String getShaPasswordHash() {
    
        return this.shaPasswordHash;
    }
    
    public void setShaPasswordHash(final String shaPasswordHash) {
    
        this.shaPasswordHash = shaPasswordHash;
    }
    
    public Byte getGmlevel() {
    
        return this.gmlevel;
    }
    
    public void setGmlevel(final Byte gmlevel) {
    
        this.gmlevel = gmlevel;
    }
    
    public String getSessionKey() {
    
        return this.sessionKey;
    }
    
    public void setSessionKey(final String sessionKey) {
    
        this.sessionKey = sessionKey;
    }
    
    public String getV() {
    
        return this.v;
    }
    
    public void setV(final String v) {
    
        this.v = v;
    }
    
    public String getS() {
    
        return this.s;
    }
    
    public void setS(final String s) {
    
        this.s = s;
    }
    
    public String getEmail() {
    
        return this.email;
    }
    
    public void setEmail(final String email) {
    
        this.email = email;
    }
    
    // public Date getJoindate() {
    //
    // return joindate;
    // }
    //
    // public void setJoindate(Date joindate) {
    //
    // this.joindate = joindate;
    // }
    
    public String getLastIp() {
    
        return this.lastIp;
    }
    
    public void setLastIp(final String lastIp) {
    
        this.lastIp = lastIp;
    }
    
    public Long getFailedLogins() {
    
        return this.failedLogins;
    }
    
    public void setFailedLogins(final Long failedLogins) {
    
        this.failedLogins = failedLogins;
    }
    
    public Byte getLocked() {
    
        return this.locked;
    }
    
    public void setLocked(final Byte locked) {
    
        this.locked = locked;
    }
    
    // public Date getLastLogin() {
    //
    // return lastLogin;
    // }
    //
    // public void setLastLogin(Date lastLogin) {
    //
    // this.lastLogin = lastLogin;
    // }
    
    public Long getActiveRealmId() {
    
        return this.activeRealmId;
    }
    
    public void setActiveRealmId(final Long activeRealmId) {
    
        this.activeRealmId = activeRealmId;
    }
    
    public Byte getExpansion() {
    
        return this.expansion;
    }
    
    public void setExpansion(final Byte expansion) {
    
        this.expansion = expansion;
    }
    
    public Long getMutetime() {
    
        return this.mutetime;
    }
    
    public void setMutetime(final Long mutetime) {
    
        this.mutetime = mutetime;
    }
    
    public Byte getLocale() {
    
        return this.locale;
    }
    
    public void setLocale(final Byte locale) {
    
        this.locale = locale;
    }
    
    public Byte getLastServer() {
    
        return this.lastServer;
    }
    
    public void setLastServer(final Byte lastServer) {
    
        this.lastServer = lastServer;
    }
    
    /**
     * Retunrns true if players name and password has are equals.
     * 
     * @param o
     *            another player to check
     * @return true if names and password hash matches
     */
    @Override
    public boolean equals(final Object o) {
    
        if (this == o) {
            return true;
        }
        
        if (!(o instanceof AccountEntity)) {
            return false;
        }
        
        final AccountEntity account = (AccountEntity) o;
        
        if (this.username != null ? !this.username.equals(account.username) : account.username != null) {
            return false;
        }
        
        return !(this.shaPasswordHash != null ? !this.shaPasswordHash.equals(account.shaPasswordHash) : account.shaPasswordHash != null);
        
    }
    
    /**
     * Returns player hashcode.
     * 
     * @return player hashcode
     */
    @Override
    public int hashCode() {
    
        int result = this.username != null ? this.username.hashCode() : 0;
        
        result = (31 * result) + (this.shaPasswordHash != null ? this.shaPasswordHash.hashCode() : 0);
        
        return result;
    }
    
}
