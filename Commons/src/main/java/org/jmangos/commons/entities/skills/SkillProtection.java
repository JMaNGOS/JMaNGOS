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
@DiscriminatorValue(value = "257")
public class SkillProtection extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8096833851921062034L;

}
