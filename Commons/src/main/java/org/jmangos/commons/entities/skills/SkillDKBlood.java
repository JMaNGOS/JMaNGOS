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
@DiscriminatorValue(value = "770")
public class SkillDKBlood extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2001424907539301137L;

}
