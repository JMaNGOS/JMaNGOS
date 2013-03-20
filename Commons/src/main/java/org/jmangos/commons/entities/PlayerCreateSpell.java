package org.jmangos.commons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.PlayercreateinfoPK;

/**
 * 
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "playercreateinfo_spell")
public class PlayerCreateSpell implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2154720192911038806L;

    @Embedded
    PlayercreateinfoPK playercreateinfoPK;

    @Id
    @Column(name = "spell",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    private Integer spell;

    /**
     * Empty constructor
     */
    public PlayerCreateSpell() {

    }

    /**
     * @return the playercreateinfoPK
     */
    public final PlayercreateinfoPK getPlayercreateinfoPK() {

        return this.playercreateinfoPK;
    }

    /**
     * @param playercreateinfoPK
     *        the playercreateinfoPK to set
     */
    public final void setPlayercreateinfoPK(final PlayercreateinfoPK playercreateinfoPK) {

        this.playercreateinfoPK = playercreateinfoPK;
    }

    /**
     * @return the spell
     */
    public final Integer getSpell() {

        return this.spell;
    }

    /**
     * @param spell
     *        the spell to set
     */
    public final void setSpell(final Integer spell) {

        this.spell = spell;
    }

    @Override
    public int hashCode() {

        return getPlayercreateinfoPK().hashCode() | getSpell();
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof PlayerCreateSpell)) {
            return false;
        }
        return ((PlayerCreateSpell) obj).hashCode() == hashCode();
    }
}
