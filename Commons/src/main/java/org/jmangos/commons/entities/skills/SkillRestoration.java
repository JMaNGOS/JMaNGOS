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
@DiscriminatorValue(value = "374")
public class SkillRestoration extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1280734949760076383L;

}
