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
@DiscriminatorValue(value = "171")
public class SkillAlchemy extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -942886446249487675L;

}
