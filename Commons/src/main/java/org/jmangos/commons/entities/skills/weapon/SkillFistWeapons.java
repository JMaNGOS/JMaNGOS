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
@DiscriminatorValue(value = "473")
public class SkillFistWeapons extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2145549111072926284L;

}
