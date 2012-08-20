package org.jmangos.auth.model;

import java.util.Date;

public class AccountDto implements Cloneable {
    
    private Long   id;
    private String username;
    private String shaPasswordHash;
    private Byte   gmlevel;
    private String sessionKey;
    private String v;
    private String s;
    private String email;
    private Date   joindate;
    private String lastIp;
    private Long   failedLogins;
    private Byte   locked;
    private Date   lastLogin;
    private Long   activeRealmId;
    private Byte   expansion;
    private Long   mutetime;
    private Byte   locale;
    private Byte   lastServer;
    
    public AccountDto() {
    
    }
    
    public Long getId() {
    
        return id;
    }
    
    public void setId(Long id) {
    
        this.id = id;
    }
    
    public String getUsername() {
    
        return username;
    }
    
    public void setUsername(String username) {
    
        this.username = username;
    }
    
    public String getShaPasswordHash() {
    
        return shaPasswordHash;
    }
    
    public void setShaPasswordHash(String shaPasswordHash) {
    
        this.shaPasswordHash = shaPasswordHash;
    }
    
    public Byte getGmlevel() {
    
        return gmlevel;
    }
    
    public void setGmlevel(Byte gmlevel) {
    
        this.gmlevel = gmlevel;
    }
    
    public String getSessionKey() {
    
        return sessionKey;
    }
    
    public void setSessionKey(String sessionKey) {
    
        this.sessionKey = sessionKey;
    }
    
    public String getV() {
    
        return v;
    }
    
    public void setV(String v) {
    
        this.v = v;
    }
    
    public String getS() {
    
        return s;
    }
    
    public void setS(String s) {
    
        this.s = s;
    }
    
    public String getEmail() {
    
        return email;
    }
    
    public void setEmail(String email) {
    
        this.email = email;
    }
    
    public Date getJoindate() {
    
        return joindate;
    }
    
    public void setJoindate(Date joindate) {
    
        this.joindate = joindate;
    }
    
    public String getLastIp() {
    
        return lastIp;
    }
    
    public void setLastIp(String lastIp) {
    
        this.lastIp = lastIp;
    }
    
    public Long getFailedLogins() {
    
        return failedLogins;
    }
    
    public void setFailedLogins(Long failedLogins) {
    
        this.failedLogins = failedLogins;
    }
    
    public Byte getLocked() {
    
        return locked;
    }
    
    public void setLocked(Byte locked) {
    
        this.locked = locked;
    }
    
    public Date getLastLogin() {
    
        return lastLogin;
    }
    
    public void setLastLogin(Date lastLogin) {
    
        this.lastLogin = lastLogin;
    }
    
    public Long getActiveRealmId() {
    
        return activeRealmId;
    }
    
    public void setActiveRealmId(Long activeRealmId) {
    
        this.activeRealmId = activeRealmId;
    }
    
    public Byte getExpansion() {
    
        return expansion;
    }
    
    public void setExpansion(Byte expansion) {
    
        this.expansion = expansion;
    }
    
    public Long getMutetime() {
    
        return mutetime;
    }
    
    public void setMutetime(Long mutetime) {
    
        this.mutetime = mutetime;
    }
    
    public Byte getLocale() {
    
        return locale;
    }
    
    public void setLocale(Byte locale) {
    
        this.locale = locale;
    }
    
    public Byte getLastServer() {
    
        return lastServer;
    }
    
    public void setLastServer(Byte lastServer) {
    
        this.lastServer = lastServer;
    }
    
    @Override
    public String toString() {
    
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nid = ").append(this.id).append("\nusername = ").append(this.username).append("\n");
        return sb.toString();
    }
    
    @Override
    public AccountDto clone() {
    
        final AccountDto clone = new AccountDto();
        fillClone(clone);
        return clone;
    }
    
    protected void fillClone(final AccountDto clone) {
    
        clone.setId(getId());
        clone.setUsername(getUsername());
        clone.setShaPasswordHash(getShaPasswordHash());
        clone.setGmlevel(getGmlevel());
        clone.setSessionKey(getSessionKey());
        clone.setV(getV());
        clone.setS(getS());
        clone.setEmail(getEmail());
        clone.setJoindate(getJoindate());
        clone.setLastIp(getLastIp());
        clone.setFailedLogins(getFailedLogins());
        clone.setLocked(getLocked());
        clone.setLastLogin(getLastLogin());
        clone.setActiveRealmId(getActiveRealmId());
        clone.setExpansion(getExpansion());
        clone.setMutetime(getMutetime());
        clone.setLocale(getLocale());
        clone.setLastServer(getLastServer());
    }
}
