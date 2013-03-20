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
@DiscriminatorValue(value = "54")
public class SkillMaces extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4970783340415304510L;

}
