/**
 * 
 */
package org.jmangos.commons.entities.skills;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "375")
public class SkillElementalCombat extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3348430181911312116L;

}
