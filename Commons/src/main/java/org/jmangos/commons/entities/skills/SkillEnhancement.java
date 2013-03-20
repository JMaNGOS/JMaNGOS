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
@DiscriminatorValue(value = "373")
public class SkillEnhancement extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6919482758682106440L;

}
