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
@DiscriminatorValue(value = "150")
public class SkillRidingTiger extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 659894701122948330L;

}
