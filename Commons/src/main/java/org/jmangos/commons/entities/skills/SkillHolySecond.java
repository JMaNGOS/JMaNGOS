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
@DiscriminatorValue(value = "594")
public class SkillHolySecond extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5444731054316304198L;

}
