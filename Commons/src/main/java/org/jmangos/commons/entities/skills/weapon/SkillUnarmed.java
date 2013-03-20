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
@DiscriminatorValue(value = "162")
public class SkillUnarmed extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2009080813123158769L;

}
