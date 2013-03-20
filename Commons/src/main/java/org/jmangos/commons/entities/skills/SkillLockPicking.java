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
@DiscriminatorValue(value = "633")
public class SkillLockPicking extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3676091270409490786L;

}
