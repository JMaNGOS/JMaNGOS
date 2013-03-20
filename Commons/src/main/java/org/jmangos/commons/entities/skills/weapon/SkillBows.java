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
@DiscriminatorValue(value = "45")
public class SkillBows extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -7671391642299257741L;

}
