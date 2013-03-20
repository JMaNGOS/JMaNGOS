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
@DiscriminatorValue(value = "8")
public class SkillFire extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5394117393681187361L;

}
