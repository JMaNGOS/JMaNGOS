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
@DiscriminatorValue(value = "118")
public class SkillDualWield extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3999144948964076393L;

}
