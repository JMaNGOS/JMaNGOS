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
@DiscriminatorValue(value = "778")
public class SkillCompanions extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6787227817705952686L;

}
