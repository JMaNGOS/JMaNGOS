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
@DiscriminatorValue(value = "293")
public class SkillPlateMail extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 2737658335271479660L;

}
