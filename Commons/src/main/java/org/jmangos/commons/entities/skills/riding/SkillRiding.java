/**
 * 
 */
package org.jmangos.commons.entities.skills.riding;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "762")
public class SkillRiding extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3132850560191344254L;

}
