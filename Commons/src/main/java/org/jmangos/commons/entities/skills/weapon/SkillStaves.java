/**
 * 
 */
package org.jmangos.commons.entities.skills.weapon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "136")
public class SkillStaves extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8327421870333617883L;

}
