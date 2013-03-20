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
@DiscriminatorValue(value = "56")
public class SkillHoly extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -363486530868063965L;

}
