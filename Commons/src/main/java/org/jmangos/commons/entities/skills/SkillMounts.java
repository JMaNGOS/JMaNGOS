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
@DiscriminatorValue(value = "777")
public class SkillMounts extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1550619158844422195L;

}
