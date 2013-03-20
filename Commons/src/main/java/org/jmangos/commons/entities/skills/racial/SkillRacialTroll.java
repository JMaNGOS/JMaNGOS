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
public class SkillRacialTroll extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8056200033097023774L;

}
