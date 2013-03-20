/**
 * 
 */
package org.jmangos.commons.entities.skills.armor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "414")
public class SkillLeather extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -4145222908802760205L;

}
