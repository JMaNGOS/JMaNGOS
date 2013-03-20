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
@DiscriminatorValue(value = "754")
public class SkillRacialHuman extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5628971884695838795L;

}
