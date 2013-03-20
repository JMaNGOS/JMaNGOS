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
@DiscriminatorValue(value = "43")
public class SkillSwords extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7978985256630309168L;

}
