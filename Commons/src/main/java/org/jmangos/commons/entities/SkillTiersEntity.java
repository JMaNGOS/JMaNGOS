package org.jmangos.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill_Tiers")
public class SkillTiersEntity {

    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "cost")
    private final int[] cost = new int[16];
    @Column(name = "maxValue")
    private final int[] maxValue = new int[16];

    public SkillTiersEntity() {

    }

    /**
     * @return the id
     */
    public final Integer getId() {

        return this.Id;
    }

    /**
     * @param id
     *        the id to set
     */
    public final void setId(final Integer id) {

        this.Id = id;
    }

    /**
     * @return the cost
     */
    public final int[] getCost() {

        return this.cost;
    }

    /**
     * @param cost
     *        the cost to set
     */
    public final void setCost(final int index, final int cost) {

        this.cost[index] = cost;
    }

    /**
     * @return the maxValue
     */
    public final int[] getMaxValue() {

        return this.maxValue;
    }

    /**
     * @param maxValue
     *        the maxValue to set
     */
    public final void setMaxValue(final int index, final int maxValue) {

        this.maxValue[index] = maxValue;
    }

}
