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
@DiscriminatorValue(value = "148")
public class SkillRidingHorse extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1212484649540559339L;

}
