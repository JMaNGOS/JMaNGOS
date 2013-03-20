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
@DiscriminatorValue(value = "172")
public class SkillTwoHandAxes extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3580428497535137625L;

}
