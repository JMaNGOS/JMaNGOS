/**
 * 
 */
package org.jmangos.commons.entities.skills.weapon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "44")
public class SkillAxes extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6504630274237418502L;

}
