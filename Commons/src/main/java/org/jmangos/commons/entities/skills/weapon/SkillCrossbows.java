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
@DiscriminatorValue(value = "226")
public class SkillCrossbows extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -7078309515099554715L;

}
