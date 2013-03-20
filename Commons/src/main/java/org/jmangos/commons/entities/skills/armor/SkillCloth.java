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
@DiscriminatorValue(value = "415")
public class SkillCloth extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8166073806094974422L;

}
