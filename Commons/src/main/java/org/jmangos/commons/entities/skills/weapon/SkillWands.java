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
@DiscriminatorValue(value = "228")
public class SkillWands extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4034249867493730484L;

}
