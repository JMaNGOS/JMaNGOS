package org.jmangos.commons.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;

@Entity
@Table(name = "charstartoutfit")
public class CharStartOutfitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    Integer id;

    @Embedded
    CharStartOutfitEntityPk charStartOutfitEntityPk;

    @Basic
    @Column(name = "protoId",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    public Integer protoId;

    @Basic
    @Column(name = "slot",
            nullable = true,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    public Integer slot;

    public CharStartOutfitEntity() {

    }

    /**
     * @return the id
     */
    public final Integer getId() {

        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final Integer id) {

        this.id = id;
    }

    /**
     * @return the protoId
     */
    public final Integer getProtoId() {

        return this.protoId;
    }

    /**
     * @param protoId
     *        the protoId to set
     */
    public final void setProtoId(final Integer protoId) {

        this.protoId = protoId;
    }

    /**
     * @return the slot
     */
    public final Integer getSlot() {

        return this.slot;
    }

    /**
     * @param slot
     *        the slot to set
     */
    public final void setSlot(final Integer slot) {

        this.slot = slot;
    }

    /**
     * @return the charStartOutfitEntityPk
     */
    public final CharStartOutfitEntityPk getCharStartOutfitEntityPk() {

        return this.charStartOutfitEntityPk;
    }

    /**
     * @param charStartOutfitEntityPk
     *        the charStartOutfitEntityPk to set
     */
    public final void setCharStartOutfitEntityPk(
            final CharStartOutfitEntityPk charStartOutfitEntityPk) {

        this.charStartOutfitEntityPk = charStartOutfitEntityPk;
    }

}
