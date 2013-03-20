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
@DiscriminatorValue(value = "125")
public class SkillRacialOrc extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 2955717478182167040L;

}
