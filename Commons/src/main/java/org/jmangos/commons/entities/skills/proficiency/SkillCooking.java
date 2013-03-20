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
@DiscriminatorValue(value = "185")
public class SkillCooking extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -7108763869452225266L;

}
