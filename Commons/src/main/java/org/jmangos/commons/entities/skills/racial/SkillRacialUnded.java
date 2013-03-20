/**
 * 
 */
package org.jmangos.commons.entities.skills.racial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "220")
public class SkillRacialUnded extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8037619771269342910L;

}
