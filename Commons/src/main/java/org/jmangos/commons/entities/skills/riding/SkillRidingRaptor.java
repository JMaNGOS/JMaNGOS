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
@DiscriminatorValue(value = "533")
public class SkillRidingRaptor extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3460700200770281997L;

}
