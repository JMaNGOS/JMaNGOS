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
@DiscriminatorValue(value = "129")
public class SkillFirstAid extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8860303038730634243L;

}
