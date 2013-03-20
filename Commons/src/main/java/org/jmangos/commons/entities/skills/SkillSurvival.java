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
@DiscriminatorValue(value = "51")
public class SkillSurvival extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8945160004542771359L;

}
