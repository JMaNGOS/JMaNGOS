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
@DiscriminatorValue(value = "50")
public class SkillBeastMastery extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6998154069065345721L;

}
