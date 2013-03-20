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
@DiscriminatorValue(value = "26")
public class SkillArms extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 2833633078179115144L;

}
