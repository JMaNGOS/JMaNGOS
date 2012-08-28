package org.jmangos.realm.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.realm.domain.PlayercreateinfoPK;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "playercreateinfo_action")
public class PlayerCreateActionEntity implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1403782310616243930L;
    
    @Embedded
    PlayercreateinfoPK        playercreateinfoPK;
    
    @Id
    @Column(name = "button", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    private Byte              button;
    
    @Basic
    @Column(name = "action", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer           action;
    
    @Basic
    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Byte              type;
    
    /**
     * Empty constructor
     */
    public PlayerCreateActionEntity() {
    
    }
    
    /**
     * @return the action
     */
    public final Integer getAction() {
    
        return this.action;
    }
    
    /**
     * @return the type
     */
    public final Byte getType() {
    
        return this.type;
    }
    
    /**
     * @param action
     *            the action to set
     */
    public final void setAction(final Integer action) {
    
        this.action = action;
    }
    
    /**
     * @param type
     *            the type to set
     */
    public final void setType(final Byte type) {
    
        this.type = type;
    }
    
    /**
     * @return the button
     */
    public final Byte getButton() {
    
        return this.button;
    }
    
    /**
     * @param button
     *            the button to set
     */
    public final void setButton(final Byte button) {
    
        this.button = button;
    }
    
    /**
     * @return the playercreateinfoPK
     */
    public final PlayercreateinfoPK getPlayercreateinfoPK() {
    
        return this.playercreateinfoPK;
    }
    
    /**
     * @param playercreateinfoPK
     *            the playercreateinfoPK to set
     */
    public final void setPlayercreateinfoPK(final PlayercreateinfoPK playercreateinfoPK) {
    
        this.playercreateinfoPK = playercreateinfoPK;
    }
    
    @Override
    public int hashCode() {
    
        return (getPlayercreateinfoPK().hashCode() << 8) | getButton();
    }
    
    @Override
    public boolean equals(final Object obj) {
    
        if (!(obj instanceof PlayerCreateActionEntity)) {
            return false;
        }
        return ((PlayerCreateActionEntity) obj).hashCode() == hashCode();
    }
}
