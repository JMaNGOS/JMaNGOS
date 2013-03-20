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
@DiscriminatorValue(value = "776")
public class SkillRuneforging extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2564446861261113850L;

}
