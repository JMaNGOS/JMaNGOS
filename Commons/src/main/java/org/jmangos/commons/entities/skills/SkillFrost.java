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
@DiscriminatorValue(value = "6")
public class SkillFrost extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8011750653439647943L;

}
