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
@DiscriminatorValue(value = "355")
public class SkillAffliction extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1271591467066256931L;

}
