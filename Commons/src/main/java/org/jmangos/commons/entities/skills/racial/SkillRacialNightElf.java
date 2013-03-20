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
@DiscriminatorValue(value = "126")
public class SkillRacialNightElf extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4250128075401777313L;

}
