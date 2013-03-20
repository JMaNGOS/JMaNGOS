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
@DiscriminatorValue(value = "267")
public class SkillProtectionSecond extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8260337809516702857L;

}
