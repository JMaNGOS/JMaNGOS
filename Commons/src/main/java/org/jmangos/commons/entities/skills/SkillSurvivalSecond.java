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
@DiscriminatorValue(value = "142")
public class SkillSurvivalSecond extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1013912536815024196L;

}
