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
@DiscriminatorValue(value = "202")
public class SkillEngineering extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3144727290486280678L;

}
