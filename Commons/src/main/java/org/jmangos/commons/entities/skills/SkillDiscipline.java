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
@DiscriminatorValue(value = "613")
public class SkillDiscipline extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8796984550176653573L;

}
