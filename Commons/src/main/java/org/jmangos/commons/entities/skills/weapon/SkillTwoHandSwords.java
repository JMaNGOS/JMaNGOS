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
@DiscriminatorValue(value = "55")
public class SkillTwoHandSwords extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6158041735033431968L;

}
