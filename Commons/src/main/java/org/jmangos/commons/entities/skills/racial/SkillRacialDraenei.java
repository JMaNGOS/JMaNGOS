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
@DiscriminatorValue(value = "760")
public class SkillRacialDraenei extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -107508308553604637L;

}
