/**
 * 
 */
package org.jmangos.commons.entities.skills.proficiency;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "755")
public class SkillJewelcrafting extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -719754536711455620L;

}
