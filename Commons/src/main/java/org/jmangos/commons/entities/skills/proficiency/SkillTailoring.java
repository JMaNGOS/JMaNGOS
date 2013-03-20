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
@DiscriminatorValue(value = "197")
public class SkillTailoring extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -22445688281285670L;

}
