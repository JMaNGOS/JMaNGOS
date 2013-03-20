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
@DiscriminatorValue(value = "554")
public class SkillRidingUndeadHorse extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -4311341334674471951L;

}
