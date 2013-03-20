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
@DiscriminatorValue(value = "237")
public class SkillArcane extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6873649394653956917L;

}
