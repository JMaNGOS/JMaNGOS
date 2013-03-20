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
@DiscriminatorValue(value = "38")
public class SkillCombat extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3341314519941568610L;

}
