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
@DiscriminatorValue(value = "354")
public class SkillDemonology extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1766865852028108797L;

}
