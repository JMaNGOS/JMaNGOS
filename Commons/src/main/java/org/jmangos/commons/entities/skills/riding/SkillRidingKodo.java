/**
 * 
 */
package org.jmangos.commons.entities.skills.riding;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "713")
public class SkillRidingKodo extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1903160718931913241L;

}
