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
@DiscriminatorValue(value = "253")
public class SkillAssasination extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6507664697058440656L;

}
