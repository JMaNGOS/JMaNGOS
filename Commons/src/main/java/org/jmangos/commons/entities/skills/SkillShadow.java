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
@DiscriminatorValue(value = "78")
public class SkillShadow extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 5200995812187337401L;

}
