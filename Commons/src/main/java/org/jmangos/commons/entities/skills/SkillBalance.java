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
@DiscriminatorValue(value = "574")
public class SkillBalance extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 2954357993914002674L;

}
