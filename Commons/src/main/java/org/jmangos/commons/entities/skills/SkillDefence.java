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
@DiscriminatorValue(value = "95")
public class SkillDefence extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4311707115381861455L;

}
