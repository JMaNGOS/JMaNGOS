/**
 * 
 */
package org.jmangos.commons.entities.skills.racial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "756")
public class SkillRacialBloodElf extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2821912419606217752L;

}
