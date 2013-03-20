/**
 * 
 */
package org.jmangos.commons.entities.skills.proficiency;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "773")
public class SkillInscription extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5628078091689863782L;

}
