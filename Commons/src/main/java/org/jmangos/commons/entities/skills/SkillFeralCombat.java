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
@DiscriminatorValue(value = "134")
public class SkillFeralCombat extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5456864060394442560L;

}
