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
@DiscriminatorValue(value = "573")
public class SkillRestorationSecond extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -9104416217853909579L;

}
