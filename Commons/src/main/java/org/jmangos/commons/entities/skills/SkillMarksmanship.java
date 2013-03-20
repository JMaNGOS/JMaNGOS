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
@DiscriminatorValue(value = "163")
public class SkillMarksmanship extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 714780574382981078L;

}
