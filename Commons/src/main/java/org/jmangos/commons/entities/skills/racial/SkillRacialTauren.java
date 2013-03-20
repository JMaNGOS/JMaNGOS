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
@DiscriminatorValue(value = "124")
public class SkillRacialTauren extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6171362060312073859L;

}
