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
@DiscriminatorValue(value = "771")
public class SkillDKFrost extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7587653874752898073L;

}
