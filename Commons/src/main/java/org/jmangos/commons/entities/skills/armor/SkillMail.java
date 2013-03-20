/**
 * 
 */
package org.jmangos.commons.entities.skills.armor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "413")
public class SkillMail extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4034712154796052102L;

}
