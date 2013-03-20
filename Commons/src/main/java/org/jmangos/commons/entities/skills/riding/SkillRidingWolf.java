/**
 * 
 */
package org.jmangos.commons.entities.skills.riding;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "149")
public class SkillRidingWolf extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6830657451546262718L;

}
