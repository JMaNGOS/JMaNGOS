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
@DiscriminatorValue(value = "333")
public class SkillEnchanting extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8549843870169762896L;

}
