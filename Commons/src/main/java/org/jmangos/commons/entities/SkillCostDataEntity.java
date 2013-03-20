package org.jmangos.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill_Cost_Data")
public class SkillCostDataEntity {

    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "skillCostId")
    private int skillCostId;
    @Column(name = "cost1")
    private int cost1;
    @Column(name = "cost2")
    private int cost2;
    @Column(name = "cost3")
    private int cost3;

    public SkillCostDataEntity() {

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
    public final void setId(final int id) {

        this.Id = id;
    }

    /**
     * @return the skillCostId
     */
    public final int getSkillCostId() {

        return this.skillCostId;
    }

    /**
     * @param skillCostId
     *        the skillCostId to set
     */
    public final void setSkillCostId(final int skillCostId) {

        this.skillCostId = skillCostId;
    }

    /**
     * @return the cost1
     */
    public final int getCost1() {

        return this.cost1;
    }

    /**
     * @param cost1
     *        the cost1 to set
     */
    public final void setCost1(final int cost1) {

        this.cost1 = cost1;
    }

    /**
     * @return the cost2
     */
    public final int getCost2() {

        return this.cost2;
    }

    /**
     * @param cost2
     *        the cost2 to set
     */
    public final void setCost2(final int cost2) {

        this.cost2 = cost2;
    }

    /**
     * @return the cost3
     */
    public final int getCost3() {

        return this.cost3;
    }

    /**
     * @param cost3
     *        the cost3 to set
     */
    public final void setCost3(final int cost3) {

        this.cost3 = cost3;
    }

}
