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
@DiscriminatorValue(value = "433")
public class SkillShield extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2523940866937698283L;

}
