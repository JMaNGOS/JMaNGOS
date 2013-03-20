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
@DiscriminatorValue(value = "152")
public class SkillRidingRam extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2702552310743989920L;

}
