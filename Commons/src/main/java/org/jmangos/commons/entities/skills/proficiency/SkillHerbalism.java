/**
 * 
 */
package org.jmangos.commons.entities.skills.proficiency;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "182")
public class SkillHerbalism extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6851662042731046669L;

}
