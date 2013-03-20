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
@DiscriminatorValue(value = "165")
public class SkillLeatherworking extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 5007595958463379304L;

}
