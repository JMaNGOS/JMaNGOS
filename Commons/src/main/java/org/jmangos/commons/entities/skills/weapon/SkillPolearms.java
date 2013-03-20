/**
 * 
 */
package org.jmangos.commons.entities.skills.weapon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "229")
public class SkillPolearms extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8536455148035507705L;

}
